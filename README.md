# PelisApp

Esta es una aplicación de gestión de películas desarrollada utilizando Spring Boot.

## Contenido del proyecto

- **Versiones utilizadas:**
  - Java 17
  - Spring Boot 3.2.2
  - H2 Database
  - Lombok
  - Spring Boot DevTools
  
- **Descripción:**
  Esta API permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en una base de datos de películas.
  
## Configuración del Proyecto

- **Dependencias:**
  - Spring Boot Starter Data JPA: Para la integración con JPA y la base de datos.
  - Spring Boot Starter Web: Para el desarrollo de la API REST.
  - Spring Boot DevTools: Para la mejora de la experiencia de desarrollo.
  - H2 Database: Base de datos en memoria para desarrollo y pruebas.
  - Lombok: Para la reducción del código boilerplate.
  - Spring Boot Starter Test: Para las pruebas unitarias.

- **Plugin Maven:**
  - Spring Boot Maven Plugin: Permite empaquetar la aplicación como un JAR ejecutable.

## Estructura del Proyecto

El proyecto sigue una estructura de paquetes estándar de Spring Boot, que incluye paquetes para controladores, servicios, modelos y repositorios.

## Pantallas de la Aplicación

A continuación se muestran pantallazos de cada una de las pantallas de la aplicación:

1. **Pantalla Principal (Home)**

![Pantalla Principal](screenshots/home_screen.png)

Descripción: Esta pantalla muestra una lista de películas.

2. **Crear Película**

![Crear Película](screenshots/create_movie_screen.png)

Descripción: Esta pantalla permite al usuario agregar una nueva película proporcionando detalles como título, director, género y URL del póster.

3. **Actualizar Película**

![Actualizar Película](screenshots/update_movie_screen.png)

Descripción: Esta pantalla permite al usuario actualizar los detalles de una película existente.

4. **Borrar Película**

![Borrar Película](screenshots/delete_movie_screen.png)

Descripción: Esta pantalla permite al usuario eliminar una película proporcionando su ID.

5. **Salir de la Aplicación**

![Salir de la Aplicación](screenshots/exit_screen.png)

Descripción: Esta pantalla muestra un mensaje de confirmación al usuario antes de salir de la aplicación.

