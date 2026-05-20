# Museo

Este proyecto es una aplicación Spring Boot para gestionar exposiciones y obras.

## Rutas web

- UI principal: `http://localhost:8080/web/exposiciones`
- Ver exposiciones: `http://localhost:8080/web/exposiciones`
- Ver obras: `http://localhost:8080/web/obras`

## API REST

- Listar exposiciones: `http://localhost:8080/api/exposiciones`
- Listar obras: `http://localhost:8080/api/obras`
- Lista de obras de una exposición: `http://localhost:8080/api/exposiciones/{id}/obras`
- Valor total de obras de una exposición: `http://localhost:8080/api/exposiciones/{id}/valor-total`

## Docker

- Iniciar servicios:
  ```powershell
  docker compose up --build --force-recreate -d
  ```
- Detener y limpiar:
  ```powershell
  docker compose down --remove-orphans
  ```

## Notas

- La UI del proyecto está bajo el prefijo `/web`.
- El puerto de la app es `8080`.
