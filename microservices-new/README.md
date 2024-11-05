## Microservices Architecture with Spring Cloud (API Gateway, Eureka Discovery, and H2 Database)

Este proyecto tiene como objetivo proporcionar una implementación básica de una **arquitectura de microservicios** utilizando **Spring Cloud**. Los componentes principales incluyen:

- **API Gateway** (Spring Cloud Gateway)
- **Discovery Service** (Eureka)
- **Microservicios** que se comunican entre sí, con H2 como base de datos de pruebas.

Este es un proyecto educativo para aprender sobre las tecnologías y las mejores prácticas de arquitectura de microservicios.

## Tecnologías Utilizadas

- **Spring Boot**: Para la creación de aplicaciones Java basadas en microservicios.
- **Spring Cloud Gateway**: Actúa como el punto de entrada único (API Gateway) que enruta las solicitudes a los microservicios correspondientes.
- **Eureka**: Servicio de descubrimiento que permite a los microservicios encontrar y comunicarse entre sí.
- **Spring Data JPA**: Para la interacción con bases de datos.
- **H2 Database**: Base de datos en memoria utilizada para pruebas y desarrollo.
- **Spring Cloud Config** (opcional): Para la gestión centralizada de la configuración de los microservicios.

## Estructura del Proyecto

El proyecto está dividido en varios servicios:

1. **API Gateway**: Enruta las solicitudes de los clientes a los microservicios correspondientes.
2. **Discovery Service (Eureka)**: Servicio de descubrimiento para permitir la comunicación entre microservicios.
3. **Microservicio A**: Un microservicio que ofrece un endpoint de ejemplo (puede ser un servicio de productos, por ejemplo).
4. **Microservicio B**: Otro microservicio que depende del servicio A (puede ser un servicio de pedidos).
5. **Base de Datos H2**: Cada microservicio utiliza H2 como base de datos en memoria para pruebas.




## Propósito del Proyecto
Este proyecto tiene como objetivo proporcionar una estructura básica para:

1. Comprender la arquitectura de microservicios.
2. Explorar el uso de Spring Cloud Gateway como API Gateway para enrutar solicitudes.
3. Aprender a configurar Eureka como servidor de descubrimiento para la comunicación entre microservicios.
4. Implementar una base de datos H2 en memoria para pruebas rápidas sin necesidad de una base de datos externa.


## Futuras Posibles Mejoras
- **Persistencia**: Reemplazar H2 por una base de datos relacional como **MySQL** y  y una base de datos no relacional como **MongoDB** para diversificar las opciones de almacenamiento de datos..
- **Seguridad**: Implementar **Spring Security** para asegurar los microservicios y API Gateway, controlando el acceso mediante autenticación y autorización.
- **Escalabilidad**: Configurar un clúster de Eureka para mejorar la disponibilidad y escalabilidad de los microservicios.
- **Resiliencia**: Implementar patrones de resiliencia como **Circuit Breaker** con **Hystrix** o **Resilience4j** para manejar fallos y mejorar la robustez de los microservicio
- **Monitoreo**: Implementar soluciones de monitoreo como **Spring Boot Actuator** y **Prometheus**.
- **Dockerización**: Usar **Docker** para contenerizar los microservicios junto con las bases de datos y facilitar la implementación.


