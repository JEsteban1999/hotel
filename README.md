# Hotel Reservation Backend

Este es el backend de un sistema de reservas de hoteles desarrollado con Java 17, Spring Boot y MySQL. El sistema permite a los usuarios ver la disponibilidad de habitaciones, consultar tarifas y realizar reservas en diferentes hoteles.

## Requisitos

- Java 17
- MySQL
- Maven

## Configuración

### 1. Clonar el repositorio

```bash
git clone https://github.com/tu-usuario/hotel-reservation-backend.git
cd hotel-reservation-backend
```

### 2. Configurar la base de datos

1. Crea una base de datos en MySQL llamada hotel_reservation.
2. Configura las credenciales de la base de datos en el archivo application.properties:

```bash
spring.datasource.url=jdbc:mysql://localhost:3306/hotel_reservation
spring.datasource.username=root
spring.datasource.password=tu-contraseña
spring.jpa.hibernate.ddl-auto=update
```

### 3. Ejecutar la aplicación

```bash
mvn spring-boot:run
```

La aplicación estará disponible en http://localhost:8080.
