# Chat en Vivo con Spring WebSocket y Thymeleaf

Este proyecto es una aplicación de chat en tiempo real que utiliza **Spring WebSocket** para la comunicación en tiempo real y **Thymeleaf** como motor de plantillas para la generación de vistas. Permite a los usuarios conectarse al chat, enviar mensajes y recibir notificaciones cuando otros usuarios ingresan o salen del chat.

## Objetivo

El objetivo de este proyecto es conocer el funcionamiento de **WebSocket** y los protocolos necesarios para su funcionamiento en aplicaciones de tiempo real. La implementación se basa en un **backend** que actúa como **broker** para manejar los mensajes, y un **frontend** que se suscribe a un **topic** y publica mensajes en tiempo real.

## Tecnologías Utilizadas

- **Spring Boot**: Framework utilizado para construir la aplicación.
- **Spring WebSocket**: Para habilitar la comunicación en tiempo real entre el cliente y el servidor.
- **Thymeleaf**: Motor de plantillas para la generación de vistas en el frontend.
- **SockJS**: Protocolo que permite crear conexiones WebSocket a través de otros transportes cuando WebSocket no está disponible.
- **STOMP**: Protocolo de mensajería utilizado para la comunicación entre el cliente y el servidor sobre WebSocket.

## Funcionalidades

- **Conexión de usuarios** al chat en tiempo real.
- **Envío y recepción de mensajes** instantáneos entre los usuarios.
- **Notificaciones en tiempo real** cuando un usuario entra o sale del chat.
- Los mensajes son enviados y recibidos en **tiempo real**, sin necesidad de recargar la página.

## Endpoints

### `GET /chat` - URL: `localhost:8080/chat`
Al acceder a esta URL, los usuarios son dirigidos a la página de chat donde deben ingresar un nombre de usuario. Desde ahí, pueden enviar y recibir mensajes en tiempo real, y las instancias conectadas recibirán actualizaciones en tiempo real cuando alguien ingrese o salga del chat.


## Futuras Posibles Mejoras

1. **Frontend**: Mejorar la interfaz de usuario utilizando un framework moderno como **React** para hacer la aplicación más interactiva y dinámica.
2. **Persistencia**: Implementar la conexión con una base de datos para almacenar mensajes y gestionar usuarios de manera persistente.
3. **Seguridad**: Implementar **Spring Security** para gestionar la autenticación y autorización de usuarios, asegurando que solo los usuarios registrados puedan acceder a ciertas funcionalidades.
