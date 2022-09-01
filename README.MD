# BSALE APPLICATION TEST

| Build Status                                                                                       |
|----------------------------------------------------------------------------------------------------|
|![Workflow](https://github.com/DiegoTGJ/bsale-test/actions/workflows/deploy.yaml/badge.svg) |

### About
Este es un proyecto con el fin de demostrar las habilidades tecnicas del postulante para la empresa Bsale

### Useful links
- [Link del despliegue](http://bsaleprueba-env.eba-pjw4meme.sa-east-1.elasticbeanstalk.com)
- [Documentación de la API](http://bsaleprueba-env.eba-pjw4meme.sa-east-1.elasticbeanstalk.com/docs/swagger-ui/)

### Getting Started

Para correr este proyecto de manera local debes tener instalado [Docker Compose](https://docs.docker.com/compose/install/)
crear un archivo .env con las variables definidas en config/.env-sample y ejecutar el siguiente comando dentro del root del proyecto:
```docker-compose
  docker-compose -f .\docker-compose-dev.yml up
```
Y acceder a la aplicación en : localhost:8083 [Link](http://localhost:8083) <br/>
Para ver la documentacion en local entrar a: localhost:8083/docs/swagger-ui/ [Link](http://localhost:8083/docs/swagger-ui/)
### Tecnologias utilizadas

#### Backend

- Spring Boot 2.7.3
- Java 1.8
- Swagger v2
#### Front End

- JQuery 3.6.1
- Bootstrap 5.2.0
- Font Awesome 6.0
- Vanilla JS (Por requerimiento de la prueba)

#### Deployment

- AWS Elastic Beanstalk
- GitHub Workflows (para el despliegue automático en AWS)

## Explicación del proyecto

El proyecto es una aplicación que emula una tienda de productos
en donde se muestra una lista de productos, con paginación implementada
y se tienen las opciones para filtrar por nombre de producto o categoria
del producto.

Para la comunicación entre el frontend y el backend, se utiliza nginx
como servidor de archivos staticos para servir el frontend. Spring Boot
para la creacion y despliegue de la API REST. Y para la comunicación entre
el frontend y el backend se utiliza Nginx como reverse proxy para redirigir
el tráfico a los servicios correspondientes. Todos estos servicios son manejados
a través de contenedores Docker utilizando docker-compose en ElasticBeanstalk.
La base de datos es una BDD MYSQL proveída por la empresa Bsale.
