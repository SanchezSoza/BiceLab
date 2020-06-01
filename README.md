https://github.com/SanchezSoza/BiceLab Bice Lab
Consumo de APIS para obtener informacion bursatil desde la url http://www.indecon.online
La tecnologia utilizada es:
* Java 8
* Spring Boot
* Maven 
* Junit
* Mockito
* Docker

# Creacion de Proyecto en Docker
* Primero se deben bajar las fuentes que se desean compilar y desplegar en Docker, este proyecto se encuentra en la siguiente ruta: "https://github.com/SanchezSoza/BiceLab", para subir a docker es requisito contar con Docker para realizar la operacion
* Despues de descargadas las fuentes uno se debe posicionar dentro del proyecto descargado a la altura donde se encuentra el archivo DockerFile y pom.xml
* Posteriormente crearemos la imagen del archivo que queremos compilar con el siguiente comando
```bash
docker image build -t bicelab .
```
 Para efectos practicos bicelab corresponde al nombre que se le quiere dar a la imagen creada
 PD: el punto en la creación de imagen debe ir
 * Posterior a la creacion de la imagen se debe desplegar el contenedor en el Docker
 ```bash
docker container run -p 8080:8080 -d bicelab
```

#Prueba Aplicación
* Para poder probar la aplicacion se debe dirigir en su navegador al sitio "http://localhost:8080/home", el cual cargara la pagina inicial del proyecto
* Este proyecto tiene 3 paginas, las cuales cada una muestra una información diferente, en algunas solicitara que ingrese informacion adicional y en otra cargara automaticamente la información solicitada