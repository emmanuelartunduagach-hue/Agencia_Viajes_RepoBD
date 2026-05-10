# 1. Introducción

Durante el desarrollo del proyecto de Agencia de Viajes se realizó la construcción completa del backend utilizando Java con Spring Boot, implementando una arquitectura orientada a APIs REST para permitir la comunicación con el frontend y la gestión de la base de datos.

El backend se diseñó con el objetivo de:

Gestionar usuarios y autenticación.
Permitir operaciones CRUD.
Conectarse a una base de datos MySQL.
Proporcionar seguridad mediante JWT.
Servir como base para futuras integraciones del frontend.

# 2. Tecnologías Utilizadas

Las tecnologías utilizadas durante el desarrollo fueron:

Tecnología	Uso
Java 17	Lenguaje principal del backend
Spring Boot	Framework principal
Spring Web	Creación de APIs REST
Spring Data JPA	Conexión y manejo de base de datos
MySQL	Base de datos relacional
JWT	Autenticación mediante tokens
Maven	Gestión de dependencias
Lombok	Reducción de código repetitivo
Postman	Pruebas de endpoints
IntelliJ IDEA	Entorno de desarrollo

# 3. Configuración Inicial del Proyecto

Inicialmente se creó el proyecto utilizando Spring Boot y Maven.

Se configuró:

Java 17.
Dependencias necesarias.
Conexión con MySQL.
Estructura de carpetas.

Cada carpeta cumple una función específica:

controller: recibe las peticiones HTTP.
service: contiene la lógica del negocio.
repository: acceso a base de datos.
model: entidades/tablas.
dto: transferencia de datos.
security: manejo de JWT y seguridad.

# 4. Configuración de la Base de Datos

Se utilizó MySQL como sistema gestor de base de datos.

Se configuró el archivo application.properties con:

URL de conexión.
Usuario y contraseña.
Puerto.
Configuración de Hibernate.

Se creó la base de datos correspondiente para almacenar:

Usuarios.
Categorías.
Información futura del sistema.

Posteriormente se verificó la conexión correcta entre Spring Boot y MySQL mediante pruebas de ejecución.

# 5. Creación de Entidades

Se desarrollaron las entidades principales del sistema.

Las entidades representan las tablas de la base de datos.

Ejemplo:

Usuario
Categoría
Otras entidades futuras del sistema.

Cada entidad fue anotada utilizando JPA con:

@Entity
@Table
@Id
@GeneratedValue
@Column

Esto permitió mapear automáticamente las tablas de MySQL con objetos Java.

# 6. Implementación de Repositories

Se implementaron interfaces Repository utilizando Spring Data JPA.

Estas interfaces permitieron:

Buscar registros.
Guardar información.
Actualizar datos.
Eliminar registros.

La ventaja principal fue evitar escribir consultas SQL manuales para operaciones básicas.

También se implementaron métodos personalizados como búsqueda por correo electrónico.

# 7. Implementación de Services

La capa Service se desarrolló para manejar la lógica del negocio.

Aquí se implementaron funciones como:

Listar usuarios.
Buscar usuarios.
Guardar usuarios.
Eliminar usuarios.
Login.
Validaciones.

La lógica se separó del controlador para mantener una arquitectura más limpia y organizada.

# 8. Implementación de Controllers

Los Controllers fueron desarrollados para exponer los endpoints REST.

Se implementaron rutas utilizando:

@RestController
@RequestMapping
@GetMapping
@PostMapping
@DeleteMapping

Los endpoints permitieron:

Método	Función
GET	Obtener información
POST	Crear información
DELETE	Eliminar información

Ejemplos:

/api/usuarios
/api/usuarios/login
/api/categorias

# 9. Implementación de DTOs

Se crearon DTOs (Data Transfer Objects) para controlar la información enviada al frontend.

Esto permitió:

Evitar enviar datos sensibles.
Personalizar respuestas.
Mejorar seguridad.
Organizar mejor la información.

Se implementaron DTOs para:

LoginRequestDTO
LoginResponseDTO
UsuarioDTO

# 10. Validaciones

Se implementaron validaciones utilizando Spring Validation.

Ejemplos:

Correos obligatorios.
Campos vacíos.
Restricciones de longitud.

Esto ayudó a evitar datos incorrectos en el sistema.

# 11. Implementación de Seguridad JWT

Uno de los procesos más importantes fue la implementación de autenticación mediante JWT (JSON Web Token).

El objetivo fue:

Permitir login seguro.
Validar usuarios.
Proteger endpoints.
Mantener sesiones mediante tokens.

Se creó la clase JwtUtil encargada de:

Generar tokens.
Validar tokens.
Extraer información del token.

El token contiene:

Correo del usuario.
ID del usuario.
Rol.
Fecha de expiración.

# 12. Configuración de Spring Security

Se configuró Spring Security para proteger las rutas del sistema.

Se permitió acceso público únicamente al endpoint de login.

El resto de rutas requieren autenticación mediante Bearer Token.

Esto garantiza:

Mayor seguridad.
Protección de datos.
Control de acceso.

# 13. Implementación de BCrypt

Se implementó BCryptPasswordEncoder para proteger las contraseñas.

Las contraseñas:

No se almacenan en texto plano.
Se almacenan cifradas.
Son verificadas mediante hash.

Esto representa una mejora importante en seguridad.

# 14. Pruebas con Postman

Se realizaron pruebas completas utilizando Postman.

Las pruebas incluyeron:

Login.
Creación de usuarios.
Consultas GET.
Eliminación de registros.
Validación de tokens.

También se verificó:

Respuestas JSON.
Manejo de errores.
Estados HTTP.

# 15. Integración Preparada para Frontend

El backend quedó preparado para ser consumido por el equipo frontend.

Se entregó:

URL base.
Endpoints.
Ejemplos de request.
Ejemplos de response.
Uso del token JWT.

Esto permitirá que el frontend pueda conectarse mediante JavaScript utilizando fetch o Axios.
