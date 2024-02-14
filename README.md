# PelisApp

Esta es una aplicación CRUD para gestionar tu lista de películas favoritas desarrollada en Android Studio y que utiliza una API en Spring Boot.

## Características de la Api propia creada para el proyecto

- **Versiones utilizadas:**
  - Java 17
  - Spring Boot 3.2.2
  - H2 Database
  - Lombok
  - Spring Boot DevTools
  
- **Descripción:**
  Esta API permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en una base de datos de películas.
  
## Configuración del Proyecto

- **Dependencias y Versiones Utilizadas:**
  - Android Gradle Plugin: 7.0.2
  - Kotlin: 1.5.31
  - Compile SDK: 34
  - Target SDK: 33
  - Material Components: 1.4.0
  - Retrofit: 2.9.0
  - Gson Converter: 2.9.0
  - Picasso: 2.8
  - Google Play Services Auth: 20.7.0
  - Firebase BOM: 32.7.2
  - Firebase Analytics: 22.6.0
  - Firebase Auth: 22.3.1
  - JUnit: 4.13.2
  - Espresso: 3.5.1

- **Plugin Maven:**
  - Spring Boot Maven Plugin: Permite empaquetar la aplicación como un JAR ejecutable.


## Estructura del Proyecto

El proyecto sigue una estructura de paquetes estándar de Spring Boot, que incluye paquetes para controladores, servicios, modelos y repositorios.

**com.vedruna.mproyectofinalsegundotrimestre.adapter**

Este paquete contiene el adaptador personalizado MovieAdapter, que se utiliza para mostrar una lista de películas en la interfaz de usuario. El adaptador se encarga de inflar las vistas de cada elemento de la lista y asignar los valores correspondientes a partir de los datos proporcionados por la lista de películas. Además, utiliza la biblioteca Picasso para cargar imágenes de manera eficiente en las vistas.

**com.vedruna.mproyectofinalsegundotrimestre.interfaces**

En este paquete se define la interfaz CRUDInterfaces, que especifica las operaciones CRUD (Crear, Leer, Actualizar, Eliminar) para las películas. Esta interfaz utiliza anotaciones de Retrofit para definir los endpoints de la API REST que interactúan con el backend de la aplicación.

**com.vedruna.mproyectofinalsegundotrimestre.model**

Aquí se encuentra la clase Movie, que representa un objeto de película en el modelo de datos de la aplicación. Esta clase tiene campos para almacenar información como el ID de la película, el título, el director, el género y la URL de la imagen. También incluye métodos para acceder y modificar estos campos, así como un método toString() para obtener una representación en cadena legible de la película.

**com.vedruna.mproyectofinalsegundotrimestre.utils**

Este paquete contiene la clase Constants, que define constantes utilizadas en toda la aplicación. En particular, incluye la URL base para las solicitudes de la API en diferentes entornos (desarrollo local en casa y en Vedruna). Esto facilita la configuración y el cambio entre diferentes entornos de backend sin tener que modificar manualmente las URL en todo el código.

Esta estructura organizativa sigue las mejores prácticas de desarrollo de aplicaciones Android y facilita la mantenibilidad, escalabilidad y comprensión del código. Cada paquete contiene clases con responsabilidades específicas, lo que facilita la localización de código relacionado y la colaboración entre miembros del equipo de desarrollo.

## Pantallas de la Aplicación

A continuación se muestran pantallazos de cada una de las pantallas de la aplicación:

1. **Pantalla Inicio de Sesión (Login)**

![Pantalla Principal](https://github.com/dblancou/AppCRUDenAndroidStudio/blob/main/images/CapturaLogin.JPG?raw=true)

La pantalla de inicio de sesión es la primera pantalla que los usuarios ven al abrir la aplicación. Permite a los usuarios ingresar sus credenciales para acceder a la aplicación. A continuación se describe la disposición y funcionalidad de los elementos en esta pantalla:

    Logo de la Aplicación:
        Un ShapeableImageView que muestra el logo de la aplicación.
        Se coloca en la parte superior de la pantalla.

    Título de la Aplicación:
        Un TextView que muestra el nombre de la aplicación.
        Se coloca debajo del logo de la aplicación.

    Campo de Entrada de Nombre de Usuario:
        Un EditText donde los usuarios pueden ingresar su nombre de usuario.
        Se coloca debajo del título de la aplicación.

    Campo de Entrada de Contraseña:
        Un EditText donde los usuarios pueden ingresar su contraseña.
        Se coloca debajo del campo de entrada de nombre de usuario.

    Botón de Inicio de Sesión:
        Un Button que permite a los usuarios iniciar sesión.
        Se coloca en la parte inferior de la pantalla.

    Botón de Inicio de Sesión con Google:
        Un SignInButton proporcionado por Google que permite a los usuarios iniciar sesión con sus cuentas de Google.
        Se coloca en el centro de la pantalla.

La pantalla también proporciona funcionalidad para iniciar sesión con Google. Cuando se presiona el botón de inicio de sesión con Google, se inicia el proceso de inicio de sesión con Google utilizando Firebase Authentication.

El código Java asociado con esta pantalla maneja la autenticación de Firebase y el inicio de sesión con Google, así como también la validación de las credenciales ingresadas por el usuario para iniciar sesión en la aplicación.

En resumen, la pantalla de inicio de sesión proporciona a los usuarios una forma fácil de acceder a la aplicación, ya sea utilizando sus credenciales locales o mediante el inicio de sesión con Google.

1. **Pantalla Principal (Home)**

![Pantalla Principal](https://github.com/dblancou/AppCRUDenAndroidStudio/blob/main/images/CapturaHome.JPG?raw=true)

La pantalla principal de la aplicación, representada por el fragmento HomeFragment, muestra una lista de películas en la interfaz de usuario. A continuación se describe la disposición y funcionalidad de los elementos en esta pantalla:

    Título: En la parte superior de la pantalla, se encuentra una barra de herramientas con el título "Watchlist". Esta barra de herramientas proporciona una navegación intuitiva y una identificación clara de la función de la pantalla.

    Lista de elementos: Justo debajo de la barra de herramientas, se muestra una lista de películas. Cada elemento de la lista contiene información básica sobre una película, como el título, el director y el género, así como una imagen de la película. La lista es desplazable, lo que permite al usuario explorar fácilmente todas las películas disponibles.

    Funcionalidad de carga de datos: Cuando el fragmento se crea, se realiza una llamada a la API para obtener todas las películas disponibles. Una vez que se reciben los datos, se cargan en la lista utilizando un adaptador personalizado (MovieAdapter). Este adaptador se encarga de inflar las vistas para cada elemento de la lista y asignar los datos correspondientes a partir de la lista de películas obtenida de la API.

    Interacción con la lista: El usuario puede interactuar con la lista tocando cualquier elemento, lo que podría desencadenar acciones adicionales, como ver más detalles de la película o realizar operaciones CRUD sobre ella.

Esta pantalla proporciona una experiencia de usuario intuitiva y eficiente para explorar y gestionar la lista de películas favoritas. La combinación de una barra de herramientas clara, una lista de elementos bien organizada y la funcionalidad de carga de datos en tiempo real garantiza una experiencia fluida y satisfactoria para el usuario.

2. **Añadir Película**

![Añadir Película](https://github.com/dblancou/AppCRUDenAndroidStudio/blob/main/images/CapturaA%C3%B1adir.JPG?raw=true)

La pantalla "Añadir Película", representada por el fragmento CrearFragment, permite al usuario ingresar información sobre una nueva película, como el título, director, género y URL del póster. A continuación se describe la disposición y funcionalidad de los elementos en esta pantalla:

    Título: En la parte superior de la pantalla, se encuentra una barra de herramientas con el título "Añadir Película". Esta barra de herramientas proporciona una identificación clara de la función de la pantalla y ayuda al usuario a comprender el contexto de la acción que se está realizando.

    Campos de entrada de datos: Justo debajo de la barra de herramientas, se muestran varios campos de texto donde el usuario puede ingresar información sobre la película:
        Título: Permite al usuario ingresar el título de la película.
        Director: Permite al usuario ingresar el nombre del director de la película.
        Género: Permite al usuario ingresar el género de la película.
        URL del Póster: Permite al usuario ingresar la URL del póster de la película.

    Botón para añadir película: Al final de la pantalla, se encuentra un botón "Añadir Película" que el usuario puede tocar una vez que haya ingresado toda la información requerida sobre la película. Al hacer clic en este botón, se enviará una solicitud para crear la nueva película utilizando los datos proporcionados.

    Validación de datos: Antes de permitir que el usuario cree una nueva película, se verifica que todos los campos de entrada de datos estén completos. Si algún campo está vacío, se muestra un mensaje de error indicando al usuario que complete todos los campos antes de continuar.

    Creación de película: Una vez que el usuario ha ingresado todos los detalles de la película y hace clic en el botón "Añadir Película", se envía una solicitud a la API para crear la película con los datos proporcionados. Si la creación es exitosa, se muestra un mensaje de éxito con el título de la película creada. En caso de error durante la creación, se muestra un mensaje de error indicando al usuario que ocurrió un problema y que vuelva a intentarlo más tarde.
    
3. **Actualizar Película**

![Actualizar Película](https://github.com/dblancou/AppCRUDenAndroidStudio/blob/main/images/CapturaModificar.JPG?raw=true)

La pantalla "Modificar Película", representada por el fragmento ModificarFragment, permite al usuario actualizar la información de una película existente. A continuación se describe la disposición y funcionalidad de los elementos en esta pantalla:

    Título: En la parte superior de la pantalla, se encuentra una barra de herramientas con el título "Actualizar". Esta barra de herramientas proporciona una identificación clara de la función de la pantalla y ayuda al usuario a comprender el contexto de la acción que se está realizando.

    Campos de entrada de datos: Justo debajo de la barra de herramientas, se muestran varios campos de texto donde el usuario puede editar la información existente de la película:
        ID: Permite al usuario ingresar el ID de la película que desea modificar.
        Título: Permite al usuario editar el título de la película.
        Director: Permite al usuario editar el nombre del director de la película.
        Género: Permite al usuario editar el género de la película.
        URL del Póster: Permite al usuario editar la URL del póster de la película.

    Botón para actualizar película: Al final de la pantalla, se encuentra un botón "Actualizar Película" que el usuario puede tocar una vez que haya realizado los cambios deseados en la información de la película. Al hacer clic en este botón, se enviará una solicitud para actualizar la película con los datos modificados.

    Validación de datos: Antes de permitir que el usuario actualice la película, se verifica que todos los campos de entrada de datos estén completos. Si algún campo está vacío, se muestra un mensaje de error indicando al usuario que complete todos los campos antes de continuar.

    Actualización de película: Una vez que el usuario ha ingresado los cambios deseados en la información de la película y hace clic en el botón "Actualizar Película", se envía una solicitud a la API para actualizar la película con los datos modificados. Si la actualización es exitosa, se muestra un mensaje de éxito con el título de la película actualizada. En caso de error durante la actualización, se muestra un mensaje de error indicando al usuario que ocurrió un problema y que vuelva a intentarlo más tarde.

4. **Borrar Película**

![Borrar Película](https://github.com/dblancou/AppCRUDenAndroidStudio/blob/main/images/CapturaBorrar.JPG?raw=true)

La pantalla "Borrar Película", representada por el fragmento BorrarFragment, permite al usuario eliminar una película existente proporcionando su ID. A continuación se describe la disposición y funcionalidad de los elementos en esta pantalla:

    Título: En la parte superior de la pantalla, se encuentra una barra de herramientas con el título "Borrar". Esta barra de herramientas proporciona una identificación clara de la función de la pantalla y ayuda al usuario a comprender el contexto de la acción que se está realizando.

    Campo de entrada de ID de película: Justo debajo de la barra de herramientas, hay un campo de entrada de texto donde el usuario puede ingresar el ID de la película que desea eliminar.

    Botón para borrar película: Debajo del campo de entrada de ID, se encuentra un botón "Borrar Película" que el usuario puede tocar una vez que haya ingresado el ID de la película que desea eliminar. Al hacer clic en este botón, se enviará una solicitud para eliminar la película con el ID proporcionado.

    Verificación de existencia de película: Antes de enviar la solicitud de eliminación, se realiza una verificación para asegurarse de que la película con el ID proporcionado realmente exista en la base de datos. Si la película no existe, se muestra un mensaje indicando al usuario que la película no se puede encontrar.

    Eliminación de película: Si la película existe y se puede encontrar en la base de datos, se envía una solicitud para eliminarla. Si la eliminación es exitosa, se muestra un mensaje de éxito informando al usuario que la película se ha eliminado correctamente. En caso de error durante la eliminación, se muestra un mensaje de error indicando al usuario que ocurrió un problema y que vuelva a intentarlo más tarde.

5. **Salir de la Aplicación**

![Salir de la Aplicación](screenshots/exit_screen.png)

Descripción: Esta pantalla muestra un mensaje de confirmación al usuario antes de salir de la aplicación.

