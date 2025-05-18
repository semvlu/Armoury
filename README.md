# Armoury Management System

# Docker PostgreSQL instructions
```
docker compose up -d
docker exec -it armoury_postgres bash
psql -U <username>
\c <database>
```

Everytime `pom.xml` is modified, it requires Maven to sync project
# Pack as a jar:
Maven: clean -> install
`java -jar armoury-0.0.1-SNAPSHOT.jar --server.port=8080`

# Technologies
Spring Boot, Maven PostgreSQL, Docker


