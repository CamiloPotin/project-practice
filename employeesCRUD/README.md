## Proyecto de Empleados CRUD
Este proyecto consiste en crear una aplicación CRUD simple que sea capaz de **crear**, **leer**, **editar** y **borrar** empleados, almacenándolos en una base de datos en memoria. 


### Objetivo
El objetivo es aprender conceptos básicos de API REST con **Spring**, así como la implementacion de validaciones y el patrón de diseño **MVC**.

### Tecnologías
- **Spring Framework**
- **Spring Data JPA**
- **Thymeleaf**
- **H2 Database**

### Funcionalidades
- CRUD completo para gestionar empleados.
- Validaciones básicas de datos.

### Futuras Mejoras
1. FrontEnd: Mejora de la interfaz grafica integrando el uso de un framework de frontend (React).
2. Persistencia: Implementar el uso de una base de datos relacional como MySQL
3. Excipciones: Implementación de manejo de excepciones.

### Instalación
1. **Clona el repositorio**:
   ```bash
   git clone <URL del repositorio>
   cd <nombre del proyecto>
   ```
2. **Configura el entorno**: Asegúrate de tener Java y Maven instalados. Puedes verificarlo ejecutando:
   ```bash
   java -version
   mvn -v
   ```
3. **Ejecuta la aplicación**: Usa Maven para compilar y ejecutar la aplicación:
 ```bash
   mvn spring-boot:run
  ```
4. **Accede a la aplicación**: Abre tu navegador y dirígete a `http://localhost:8080/employees` para ver la aplicación en funcionamiento.
   
