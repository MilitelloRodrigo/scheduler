# Proyecto Springboot

* Importa dependencias comunes del proyecto [bds-parent-springboot]
* Define la última versión disponible de springboot como base (a mayo 2020 es la 2.3.0.RELEASE)
* Sugiere la utilización de Junit para tests unitarios
* Sugiere la utilización de la especificación Swagger, mediante la implementación de Springfox, para exponer la documentación de la API


Para ejecutar el proyecto en forma local basta con ejecutar el siguiente comando:

```bash
mvn spring-boot:run -Dspring-boot.run.arguments=--spring.profiles.active=local,--spring.jackson.property-naming-strategy=LOWER_CAMEL_CASE,--clients.size=50
```


El proyecto cuenta con la posibilidad de ser levantado en un entorno containerizado similar al del banco.

Como requisito previo se requiere la instalación de [docker](https://docs.docker.com/install/).

Luego se deberán ejecutar los siguientes comandos:

```bash
mvn clean install

docker build -t nombre_imagen .

docker run -e "LOG_PROFILE=local" -e "JSON_PROPERTY_NAMING=LOWER_CAMEL_CASE" -e "CLIENTS_SIZE=50" nombre_imagen
```


* [Documentación de la API](http://localhost:8080/swagger-ui.html)
* [Springboot Docs](https://spring.io/projects/spring-boot)
* [Documentación Docker](https://docs.docker.com/)

[bds-parent-springboot]: https://github.com/gss-bds/bds-parent-springboot



MONGODB_URI=mongodb://localhost:27017/file-manager;JSON_PROPERTY_NAMING=LOWER_CAMEL_CASE;TIMEZONE=America/Buenos_Aires;LOG_PROFILE=local;LOG_LEVEL=TRACE;JAEGER_AGENT_HOST=localhost;JAEGER_AGENT_PORT=6831;TRACE_LOG_SPANS=false;SPECS_URL=/docs;BASE_ACTUATOR_ENDPOINT=/actuator;EXPOSED_ACTUATOR_ENDPOINTS=health,info,prometheus,env
