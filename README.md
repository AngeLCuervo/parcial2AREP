# parcial2AREP

## Para ejecutar:

### Se levantan 2 instancias del servicio de tribonacci en diferenes consolas:

1. mvn spring-boot:run "-Dspring-boot.run.arguments=--server.port=8081"
2. mvn spring-boot:run "-Dspring-boot.run.arguments=--server.port=8082"

### Ejecutamos el proxy por el puerto 8080
mvn spring-boot:run "-Dspring-boot.run.arguments=--server.port=8080"

### Para probar ponemos lo siguiente por ejepmplo en el navegador:
http://localhost:8080/proxy/tribonacci?numero=5

### Para ver la interfaz web accedemos a:
http://localhost:8080/
