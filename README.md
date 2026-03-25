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




Corriendo los servidores:
<img width="559" height="247" alt="image" src="https://github.com/user-attachments/assets/57ba8688-dca4-41a9-a9bc-aa5eb445dd86" />

 
Descripcion de como correrlO en EC2

Ingresamos a EC2
 <img width="614" height="247" alt="image" src="https://github.com/user-attachments/assets/5bac1366-70ff-42ea-88b5-bd895065dda7" />


Vamos a lanzar una instancia 
 <img width="605" height="197" alt="image" src="https://github.com/user-attachments/assets/3cc22222-09c1-4c4d-91a0-dd9f2215819e" />

 <img width="617" height="167" alt="image" src="https://github.com/user-attachments/assets/65f682e6-2ae7-48ad-80df-c1a5484e9fc5" />



Seleccionamos la instancia creada y despues la conectamosl
le damos luego a conectar la instancia
<img width="604" height="238" alt="image" src="https://github.com/user-attachments/assets/2bac6dd6-ebce-4c9e-8a98-f9d8202b6ecb" />

 
miramos que la llave este en una carpeta, la cual podamos hacer la coneccion 
 <img width="604" height="279" alt="image" src="https://github.com/user-attachments/assets/dc7c2b71-336e-493c-831c-981b0f21224f" />


Vamos a SSH client
 <img width="468" height="247" alt="image" src="https://github.com/user-attachments/assets/df3bc88f-de25-47b1-9f20-301fc63220d4" />


Y lo corremos desde la carpeta de la llave 
 

Listo ya esta conectado 
<img width="551" height="332" alt="image" src="https://github.com/user-attachments/assets/5e760db3-f891-4d19-8a5c-5af8d5ebd150" />


Instalamos el  JDK for Amazon Corretto 17:
Example
sudo yum install java-17-amazon-corretto-devel

ssh -i "arep2.pem" ec2-user@ec2-13-218-161-43.compute-1.amazonaws.com

ec2-13-218-161-43.compute-1.amazonaws.com

ssh -i "arep2.pem" ec2-13-218-161-43.compute-1.amazonaws.com
