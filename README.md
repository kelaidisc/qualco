# Nations API — Spring Boot Backend

REST API serving country, language and statistics data from a relational database.

## Stack

- Java 17
- Spring Boot 4
- Spring Data JPA (Hibernate)
- MySQL
- Lombok

## Architecture

Standard layered architecture: Controller → Service → Repository.

Controllers are thin — no business logic, just routing and parameter binding.
Services own the business logic. Repositories handle data access via JPA and JPQL.

DTOs are used as the API contract, keeping the persistence model decoupled from what gets serialized over the wire.

## Design Decisions

**DTO layer over entities**
Entities are never returned directly from controllers. This keeps the API contract stable regardless of schema changes and prevents unintentional field exposure.

**JPQL with constructor expressions**
Complex queries use JPQL constructor expressions (`new com.example.dto.SomeDto(...)`) to map results directly to DTOs at the query level, avoiding an extra mapping step in the service.

**Max ratio logic in JPQL subquery**
The best GDP/population year per country is computed via a correlated subquery in JPQL rather than fetching all rows and processing in Java. Keeps the heavy lifting in the database where it belongs.

**`@EmbeddedId` + `@MapsId` for composite keys**
`country_stats` uses a composite PK (`country_id`, `year`). Modelled with `@EmbeddedId` and `@MapsId` on the `@ManyToOne` relationship — the JPA-spec correct approach for derived identities, avoids the `insertable=false, updatable=false` workaround.

**`open-in-view` disabled**
`spring.jpa.open-in-view=false` — prevents the anti-pattern of lazy-loading within the serialization phase, making session boundaries explicit.

**`ddl-auto=none`**
Schema is managed externally via `nations.sql`. Hibernate never touches the schema.

## Known Gaps

- No global exception handler — errors return raw Spring defaults
- Page size is not capped server-side
- Credentials are hardcoded in `application.properties` — should be externalized via environment variables in any real deployment

## Running

Update `application.properties` with your local MySQL credentials, then:

```bash
mvn spring-boot:run
```

API available at `http://localhost:8080/api`.

## Endpoints

| Method | Path | Description |
|--------|------|-------------|
| GET | `/api/countries` | All countries ordered by name |
| GET | `/api/countries/{id}/languages` | Languages spoken in a country |
| GET | `/api/regions` | All regions ordered by name |
| GET | `/api/stats/max-ratio` | Best GDP/population year per country |
| GET | `/api/stats/explore` | Paginated stats with optional filters |

### Explorer query parameters

| Param | Type | Required | Description |
|-------|------|----------|-------------|
| `regionId` | Integer | No | Filter by region |
| `yearFrom` | Integer | No | Stats from this year |
| `yearTo` | Integer | No | Stats up to this year |
| `page` | Integer | No | Page number (default 0) |
| `size` | Integer | No | Page size (default 10) |
