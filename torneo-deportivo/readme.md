# Problema

Un importante promotor deportivo le ha solicitado que diseñe un sistema para la gestión de las inscripciones a torneos deportivos. El necesita que la aplicación permita:

Almacenar la información de un torneo. La información que se requiere es: número máximo de equipos participantes, el nombre del torneo, el límite de edad de los jugadores (en caso de tenerlo), la fecha de inicio de las inscripciones, la fecha de cierre de las inscripciones, el valor de la inscripción y la fecha de inicio del torneo.

Debido a la planeación de los torneos en ocasiones es necesario modificar las fechas de inscripción e inicio del mismo. Por lo anterior, el promotor solicita que exista la posibilidad de poder modificar dichos datos después de su creación. 

Se desea incluir entre la información del torneo, el tipo de torneo según si es de carácter local, regional, nacional o mundial.

Se desea incluir los equipos que participaran en el torneo, para lo cual se requiere una forma de registrar cada uno de los equipos. Cada equipo se espera conocer el nombre del equipo y su representante de quien se requiere su nombre, apellido, email y número de celular. Durante el registro se debe tener en cuenta que no debe excederse el número máximo de equipos y que la inscripción se realice dentro de las fechas permitidas. Así mismo, no se permiten dos equipos con el mismo nombre en el torneo. 

El promotor deportivo desea que cada equipo tenga un listado de sus jugadores, para lo cual se debe proporcionar un mecanismo de registro de cada jugador con la siguiente información: el nombre y apellido, fecha de nacimiento, email y el número celular. Debe validarse que la edad del jugador inscrito sea acorde con la aceptada en el torneo. Solamente se pueden inscribir jugadores si aún se está en las fechas de inscripción. Tampoco se aceptan nombre nulos o vacíos. Finalmente y para evitar confusiones, no se aceptan jugadores que tengan el mismo nombre y apellido, independiente del equipo al que pertenezcan.

Se desea ampliar la variedad de torneos, permitiendo no solo torneos de grupos sino también torneos de carácter individual. Esto implica que los participantes en un torneo pueden ser grupos (si es grupal) o jugadores si es un torneo individual.

El promotor deportivo desea que exista la posibilidad de registrar diversas estadísticas a los participantes de los torneo. Entre las estadísticas por ejemplo se desea llevar un registro del número de torneos ganados y todas aquellas estadísticas relevantes como lo son enfrentamientos ganados, perdidos entre otros (Cada estadística tiene un nombre, un valor y un tipo que indica si la estadística por si misma implica algo Positivo, Negativo o es Neutra).

Adicionalmente, basado en dichas estadísticas se desea tener la posibilidad de proporcionar:

- Listado de participantes ordenado según la estadística.
- Dada una estadística obtener el participante con la mayor valor en dicha estadística.
- Dada una estadística y un valor obtener los participantes con dicha estadística superior o igual a la dada.
- Dada una estadística y un valor obtener los participantes con dicha estadística inferior a la dada.
- Dada una estadística obtener la media de dicha estadística entre los participantes del torneo.
- Dado un participante devolver las estadísticas de dicho participante
- Comparar una estadística presente en dos participantes (A,B) (Retornando un número positivo si el Participante A tiene mejor estadística que B, en el caso de las estadísticas positivas y neutras implica que la estadística de A sea mayor que la de B, en las negativas que la estadística de A sea inferior a la de B. Retorna 0 si las estadísticas son iguales, en caso contrario retorna un número negativo).
- Se desea dados dos participantes (A,B) generar un reporte con las estadísticas de ambos participantes. El reporte contendrá N registros, donde N es el número de estadísticas. Cada registro indicará la estadística, el valor del participante A en dicha estadística y el valor del participante B en dicha estadística. En el caso de que una estadística aparezca solo en un participante el registro en el reporte aparecerá con el valor de la estadística del participante que la tiene y un valor que indique que el otro participante no la tiene. 

## PROYECTO FINAL - PARTE 1
Se desea realizar torneos que permitan la inclusión de diversos géneros, torneos solo para hombres, torneos solo para mujeres o torneos mixtos. Para ello deberá incluir en la información del torneo el genero. Así mismo también deberá incluirse este dato en los jugadores y validarlo al momento de su registro.

## PROYECTO FINAL - PARTE 2
Se quiere poder tener un registro de los jueces que participarán en el torneo. De cada uno de ellos se cuenta con la siguiente información:  licencia de juez, el nombre y apellido, email y el número celular.

## PROYECTO FINAL - PARTE 3

Se desea poder agendar los enfrentamientos, indicando el lugar donde se realizará el enfrentamiento (nombre, ubicación), la fecha y hora del enfrentamiento, los equipos que se enfrentarán, el juez o jueces que arbitraran el encuentro, el resultado del enfrentamiento cuando haya concluido (puntos realizados por cada equipo) y el estado del enfrentamiento. Los posibles estados de un enfrentamiento son:

- PENDIENTE: Estado inicial de un enfrentamiento, será posible asignarlo a los enfrentamientos que se registran pero que según su fecha y hora programada aun no se han jugado.
- EN JUEGO: Estado que indica que el enfrentamiento ya inició. Solo es posible asignar este estado si según la fecha y hora de inicio del enfrentamiento es oportuno hacerlo.
- FINALIZADO: Estado que indica que el enfrentamiento ha concluido, el sistema debe cambiar de forma automática a dicho estado cuando se registra el resultado del enfrentamiento. Sin dicho resultado no es posible asignar éste estado.
- APLAZADO: Este estado indica que por alguna razón el enfrentamiento no se puede jugar.

Se desea brindar información de sus enfrentamientos a cada equipo, por lo que se espera poder obtener un listado de los enfrentamiento de un equipos dado su nombre.

Así mismo es importante brindar a los jueces información relacionada con los enfrentamientos de los cuales hará parte, por lo que se debe poder obtener un listado de los enfrentamientos en que participará un juez basado en su número de licencia.

Por último, se desea poder obtener un listado de los equipos y el número total de enfrentamientos ganados, empatados y perdidos. Dicho listado debe estar en orden descendente según el número de victorias, empates y perdidas.

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

