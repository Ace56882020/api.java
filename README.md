# api.java
api res spring boot

Api Rest JAVA



Clone el repositorio, ejecute netbeans donde debe abrir el proyecto clonado.

Crear la base de datos en postgres de nombre books

al tener el proyecto abierto, nos dirigimos a la carpeta Other Sources precionamos la carpeta src/main/resource en la carpeta default package

en el archivo application.properties se configura los accesos a la base de datos creada y colocar el usuario y contraseña de la base de datos en postgres

spring.jpa.database=postgresql
spring.jpa.show-sql=false
spring.jpa.hibernate.ddl-auto=update

spring.datasource.drive-class-name=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://localhost/books

//cambiar el nombre de usuario de la base

spring.datasource.username=postgres

//cambiar la contraseña de la base

spring.datasource.password=Ace5688

server.port=8092

ya configurado la conexion a la base en  el proyecto dar clic derecho y seleccionar Clean and Build, para descargar las dependencias, y crear la tabla book, validar que la tabla se haya creado en la base

para realizar la ejcucion del proyecto nos dirigimos a ApiBookRestApplication y damos un click derecho y seleccionamos Run File ya esta arriba el servicio de la api
