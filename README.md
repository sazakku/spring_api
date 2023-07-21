# spring_api

# API REST clinic
## Requisitos.

* Postgresql
* Java 17
* Maven > 3.8

## Instalación.
1. Clonar repositorio.
2. Ubicarse en la raiz del repositorio.
3. Usar <code>mvn spring-boot:run</code> para instalación de dependencias y correr el proyecto.
5. ¡Listos!, el servidor estara disponible en localhost:8080

### ¿Que se puede hacer?
1. De manera inicial esta vacia nuestra base de datos, lo primero que haremos sera craer <code>especialidades</code>
2. Posterior, procedemos a crear Doctores.
3. Como siguiente paso podemos ya crear el paciente.
4. El ultimo paso es crear las citas medicas, en este punto solo con el numero de documento del paciente podemos agendar la cita medica.

### Endpoints

| endpoint                                   | metodo | parametros                                                |
| ------------------------------------------ | ------ | --------------------------------------------------------- |
| http://localhost:8080/api/specialties     | GET    | NA                                                        |
| http://localhost:8080/api/specialties     | POST   | ``` name ```                                              |
| http://localhost:8080/api/specialties/:id | PUT    | ``` name ```                                              |
| http://localhost:8080/api/specialties/:id | DELETE | NA                                                        |
| http://localhost:8080/api/doctors          | GET    | NA                                                        |
| http://localhost:8080/api/doctors/:id      | GET    | NA                                                        |
| http://localhost:8080/api/doctors          | POST   | ``` name, lastName, office, contactEmail, specialties``` |
| http://localhost:8080/api/doctors/:id      | PUT    | ``` name, lastName, office, contactEmail, specialties``` |
| http://localhost:8080/api/patients         | GET    | NA                                                        |
| http://localhost:8080/api/patients/:id     | GET    | NA                                                        |
| http://localhost:8080/api/patients         | POST   | ``` name, documentId, lastName, age, phone```             |
| http://localhost:8080/api/patients/:id     | PUT    | ``` name, documentId, lastName, age, phone```             |
| http://localhost:8080/api/appointments     | GET    | NA                                                        |
| http://localhost:8080/api/appointments/:id | GET    | NA                                                        |
| http://localhost:8080/api/appointments     | POST   | ``` patient,speciality,doctor,date,time ```               |
| http://localhost:8080/api/appointments/:id | PUT    | ``` patient,speciality,doctor,date,time ```               |
| http://localhost:8080/api/appointments/:id | DELETE | NA                                                        |

Si tienes alguna duda contactame 😃

![see you soon bro](https://media.giphy.com/media/l1J3CbFgn5o7DGRuE/giphy.gif)
