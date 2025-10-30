## GERMAN BONHOMME, BENJAMIN FIGUEROA, TOMAS BUSTOS

Antes de ejecutar este proyecto, asegúrate de tener instalado:

Java 17 o superior

Apache Maven

MySQL 8+

Git

(Opcional) Postman
 para probar los endpoints

💻 Configuración inicial

Clonar el repositorio

git clone https://github.com/tu-usuario/huertohogarJV-carrito.git
cd huertohogarJV-carrito


Configurar la base de datos MySQL

Crea una base de datos llamada:

CREATE DATABASE db_huertohogar;


Abre el archivo

src/main/resources/application.properties


y ajusta las credenciales de tu base de datos:

spring.application.name=backend
spring.datasource.url=jdbc:mysql://localhost:3306/db_huertohogar
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect


(Opcional) Cargar datos iniciales

Ejecuta el script:

src/main/resources/cargaDatosInicial.sql


desde MySQL Workbench o tu cliente SQL favorito.

🏗️ Construcción del proyecto

Compila y empaqueta el proyecto en un .jar ejecutable:

mvn clean package -DskipTests


Esto generará el archivo:

target/carrito-microservice.jar

▶️ Ejecución

Inicia el microservicio con:

java -jar target/carrito-microservice.jar
