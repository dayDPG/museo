
# MUSEO
Para ver exposiciones de arte y las obras que tienen.
#
### *RUTAS WEB*

- UI principal: http://localhost:8080/web/exposiciones
- Ver exposiciones: http://localhost:8080/web/exposiciones
- Ver obras: http://localhost:8080/web/obras

### *API REST*

- Listar exposiciones: http://localhost:8080/api/exposiciones
- Listar obras: http://localhost:8080/api/obras
- Lista de obras de una exposición: http://localhost:8080/api/exposiciones/{id}/obras
- Valor total de obras de una exposición: http://localhost:8080/api/exposiciones/{id}/valor-total

#
### __*DOCKER!!!*__
__Iniciar__ el docker:

```bash
    docker compose up -d
```
**Arrancar la aplicación:**    
```bash
    \mvnw.cmd spring-boot:run
```
__Eliminar__ el contenedor
```bash
    docker compose down
```
>*Eliminar contenedor mas datos  :*       `docker compose down -v`

#
### *DATOS DE EJEMPLO*
 
Para cargar exposiciones y obras de ejemplo en la base de datos:
 
**1.** Copiar el archivo al contenedor de MySQL:
```bash
docker cp ejemplo/datos.sql museo_mysql:/datos.sql
```
 
**2.** Ejecutar el script:
```bash
docker exec -i museo_mysql sh -c "mysql -u museo_user -pmuseo_pass --default-character-set=utf8mb4 museo_db < /datos.sql"
```
 
>Incluye **exposiciones** (pasadas, activas y próximas) con **obras c/u** de distintos valores.
 
#
#### TEMA ASIGNADO 
|EXPOSICION	|OBRA|
|---|---|
|titulo|`titulo`|
|fechaInicio|`autor`|
|fechaFin|`año`|
|ciudad	| `tecnica`|
|---|`valorEuros`|
#