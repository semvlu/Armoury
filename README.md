# Armoury Management System
The project Armoury is a Java back-end project aims to manage the rifles in an armoury. Controller-Service-Repository pattern and REST API are adopted. We authorise a person to get, update, and delete the rifle's information by the person's id. 
# Docker PostgreSQL instructions
```
docker compose up -d
docker exec -it armoury_postgres bash
psql -U <username>
\c <database>
```

Everytime `pom.xml` is modified, it requires Maven to sync project

# Pack as a jar file
> Maven: clean -> install

> `java -jar armoury-0.0.1-SNAPSHOT.jar --server.port=8080`

# Technologies
Spring Boot, Maven PostgreSQL, Docker


