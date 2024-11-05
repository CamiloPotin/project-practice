# Spring JWT Authentication

Este proyecto tiene como objetivo implementar una autenticación básica utilizando **JWT** (JSON Web Tokens) junto con **Spring Security**. El propósito es aprender a configurar y utilizar JWT para la autenticación y autorización en aplicaciones basadas en Spring Boot.

JWT es una forma segura y compacta de transmitir información entre partes como un objeto JSON. Este proyecto proporciona un ejemplo de cómo integrarlo con Spring Security para proteger las rutas y manejar la autenticación de usuarios.

## Tecnologías Utilizadas

- **Spring Security**: Framework para la autenticación y autorización en aplicaciones Spring.
- **Spring Boot**: Plataforma para crear aplicaciones Java rápidas y fáciles de configurar.
- **JWT (JSON Web Token)**: Método estándar para el intercambio de información segura entre cliente y servidor.
- **Spring Data JPA**: Framework para la persistencia de datos utilizando JPA (Java Persistence API).

## Endpoints

Este proyecto proporciona varios endpoints para interactuar con el sistema de autenticación. Los usuarios pueden registrarse, iniciar sesión y acceder a sus datos.

### 1. `POST /auth/signup`
Registra un nuevo usuario en el sistema.
#### Request Body:
```json
   {
  "name": "nombre",
  "password": "contraseña",
  "email": "email@hotmail.com",
  "roles": "user"
   }
```

### 2. `POST /auth/login`
Valida las credenciales del usuario y devuelve un JWT en caso de éxito.`
#### Request Body:
```json
   {
  "name": "nombre",
  "password": "contraseña"
   }
```
#### Response (si el login es exitoso):
```json
{
  "token": "jwt_token_aqui",
  "expiresIn": 3600000
}
```

### 2. `GET /users/me`
Devuelve los detalles del usuario autenticado. Este endpoint requiere el token JWT en el encabezado de autorización.
#### Headers
    Authorization: Bearer <jwt_token_aqui>

### 2. `GET /users/`
Devuelve una lista de todos los usuarios en el sistema. Este endpoint también requiere el token JWT en el encabezado de autorización.
#### Headers
    Authorization: Bearer <jwt_token_aqui>
