# Problema

Un importante promotor deportivo le ha solicitado que diseñe un sistema para la gestión de las inscripciones a torneos deportivos. El necesita que la aplicación permita:

Almacenar la información de un torneo. La información que se requiere es: número máximo de equipos participantes, el nombre del torneo, el límite de edad de los jugadores (en caso de tenerlo), la fecha de inicio de las inscripciones, la fecha de cierre de las inscripciones, el valor de la inscripción y la fecha de inicio del torneo.

Debido a la planeación de los torneos en ocasiones es necesario modificar las fechas de inscripción e inicio del mismo. Por lo anterior, el promotor solicita que exista la posibilidad de poder modificar dichos datos después de su creación. 

Se desea incluir entre la información del torneo, el tipo de torneo según si es de carácter local, regional, nacional o mundial.

Se desea incluir los equipos que participaran en el torneo, para lo cual se requiere una forma de registrar cada uno de los equipos. Cada equipo se espera conocer el nombre del equipo y su representante de quien se requiere su nombre, apellido, email y número de celular. Durante el registro se debe tener en cuenta que no debe excederse el número máximo de equipos y que la inscripción se realice dentro de las fechas permitidas. Así mismo, no se permiten dos equipos con el mismo nombre en el torneo. 

El promotor deportivo desea que cada equipo tenga un listado de sus jugadores, para lo cual se debe proporcionar un mecanismo de registro de cada jugador con la siguiente información: el nombre y apellido, fecha de nacimiento, email y el número celular. Debe validarse que la edad del jugador inscrito sea acorde con la aceptada en el torneo. Solamente se pueden inscribir jugadores si aún se está en las fechas de inscripción. Tampoco se aceptan nombre nulos o vacíos. Finalmente y para evitar confusiones, no se aceptan jugadores que tengan el mismo nombre y apellido, independiente del equipo al que pertenezcan.

## Ejercicio
Diseñe y codifique pruebas que: 
- Permitan verificar que los datos del torneo no sean nulos y en blanco.
- Verifiquen que no se registren jugadores con el mismo correo.

## Herramientas

- [java 17](https://adoptium.net/es)
- [junit 5.10.0](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api/5.10.0)
- [maven](https://maven.apache.org)
- [yUML](https://yuml.me)
- [Marp for VS Code](https://marp.app)

### Opcional

- [Visual Studio Code Versión 1.80](https://code.visualstudio.com/)
    - Extension Pack for Java Versión 0.25.12 -- Microsoft
    - yUML (UML diagramming tool based on the yUML syntax) - Versión 3.5.1 -- Jaime Olivares

### Nota
Para visualizar adecuadamente la presentación realizada en Marp for VS Code debe habilitar la opción de aceptar HTML en la configuración de la extensión.

## Construcción y pruebas

Para compilar el proyecto puede usar el comando:

```shell
mvn clean compile
```

Para ejecutar las pruebas puede usar el comando: 

```shell
 mvn clean test
```

