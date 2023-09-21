---
marp: true
header: <div class="encabezado"><img src='imagenes/franjaSuperior.png'  /><div class="titulo"><h1 class="texto"></h1></div></div>
footer: '![image](imagenes/franjaInferior.png)' 
_header: '' 
_footer: '' 
paginate: true
_paginate: false
_backgroundImage: url('imagenes/fondo.png')
style: |

  .encabezado {
    position: relative; left: 0; top:0;display: inline-block; text-align: center;
  }
  .titulo {
    position: absolute; top: 40%; left: 50%; transform: translate(0%, -50%); color: gray;
  }
  .columns {
    display: grid;
    grid-template-columns: repeat(2, minmax(0, 1fr));
    gap: 1rem;
  }
  .texto:after {
    content: 'Titulo';
  }
  
  h1 { color: black }
---

<div style="position: absolute; left: 30%; top:45%; width: 70%; text-align: left"><h1 style="color: gray">Programación Orientada a Objetos</h1></div>
<div style="position: absolute; left: 30%; top:55%; width: 70%; text-align: left"><h5 style="color: gray">Área de programación<br />
Programa de Ingeniería de Sistemas y Computación<br />
Facultad de Ingeniería
</h5></div>

<div style="position: absolute; left: 45%; top:20%; background-color: rgb(212, 231, 205); width: 550px">
<b>
Problema: <br />
Torneo deportivo - Requerimiento 01 <br />
</b>
</div>


<div style="position: absolute; left: 93%; top:10px; ">

![width:80](imagenes/licencia.png)
</div>

---


<style >
.texto:after {
    content: 'Problema:';
  }
</style>

Un importante promotor deportivo le ha solicitado que diseñe un sistema para la gestión de las inscripciones a torneos deportivos. El necesita que la aplicación permita:

---

## RQ 01

Almacenar la información de un torneo. La información que se requiere es: número máximo de equipos participantes, el nombre del torneo, el límite de edad de los jugadores (en caso de tenerlo), la fecha de inicio de las inscripciones, la fecha de cierre de las inscripciones, el valor de la inscripción y la fecha de inicio del torneo.

---
## RQ 02

Debido a la planeación de los torneos en ocasiones es necesario modificar las fechas de inscripción e inicio del mismo. Por lo anterior, el promotor solicita que exista la posibilidad de poder modificar dichos datos después de su creación. 

---
## RQ 03

Se desea incluir entre la información del torneo, el tipo de torneo según si es de carácter local, regional, nacional o mundial. 

---

## RQ 04

Se desea incluir los equipos que participaran en el torneo, para lo cual se requiere una forma de registrar cada uno de los equipos. Cada equipo se espera conocer el nombre del equipo y su representante de quien se requiere su nombre, apellido, email y número de celular. Durante el registro se debe tener en cuenta que no debe excederse el número máximo de equipos y que la inscripción se realice dentro de las fechas permitidas. Así mismo, no se permiten dos equipos con el mismo nombre en el torneo. 

---

## RQ 05

El promotor deportivo desea que cada equipo tenga un listado de sus jugadores, para lo cual se debe proporcionar un mecanismo de registro de cada jugador con la siguiente información: el nombre y apellido, fecha de nacimiento, email y el número celular. Debe validarse que la edad del jugador inscrito sea acorde con la aceptada en el torneo. Solamente se pueden inscribir jugadores si aún se está en las fechas de inscripción. Tampoco se aceptan nombre nulos o vacíos. Finalmente y para evitar confusiones, no se aceptan jugadores que tengan el mismo nombre y apellido, independiente del equipo al que pertenezcan.

---

<style scoped>
.texto:after {
    content: 'Abstracción: ¿Qué se solicita finalmente? (problema)';
  }
  section{font-size:16pt}
</style>

- Almacenar la información de un torneo
- Modificar fechas de inscripción e inicio del torneo
- Realizar inscripción de equipos para el torneo
- Almacenar la información de los equipos y su representante
  - Validar que no se debe excederse el número máximo de equipos
  - Validar que la inscripción se realice dentro de las fechas permitidas
  - Validar que no se permita registrar un equipo con el mismo nombre de uno ya registrado
- Recuperar la información de los equipos y su representante
- Almacenar la información de los jugadores de cada equipo
  - Validar que la edad del jugador no exceda el limite de edad del torneo.
  - Validar que el registro del jugador se realice dentro de las fechas permitidas
  - Validar que no se acepten nombre nulos o en blanco.
  - Validar que dos jugadores no tengan el mismo nombre y apellido, independiente del equipo.
- Recuperar la información de los jugadores  
---

<style scoped>
.texto:after {
    content: 'Abstracción: ¿Qué información es relevante dado el problema anterior?';
  }
</style>

- nombre del torneo : Texto
- fecha de inicio del torneo : Fecha
- fecha de inicio de las inscripciones : Fecha
- fecha de cierre de las inscripciones : Fecha
- número máximo de equipos participantes : Entero
- límite de edad de los jugadores (en caso de tenerlo) : Entero 
- valor de la inscripción : Entero
- tipo de torneo: Tipo de Torneo (local, regional, nacional o mundial)



---

<style scoped>
.texto:after {
    content: 'Abstracción: ¿Qué información es relevante dado el problema anterior?';
  }
</style>

- nombre del equipo 
- nombre del representante
- apellido del representante
- email del representante
- número de celular del representante

---

<style scoped>
.texto:after {
    content: 'Abstracción: ¿Qué información es relevante dado el problema anterior?';
  }
</style>

- nombre del jugador
- apellido del jugador
- email del jugador
- número de celular del jugador
- fecha nacimiento del jugador

---
<style scoped>
.texto:after {
    content: 'Abstracción: ¿Cómo se agrupa la información relevante?';
  }
</style>

- Torneo
- TipoTorneo
- Equipo
- Representante
- Jugador

<div style="position: absolute; left: 40%; top:20%; ">


![](https://yuml.me/diagram/class;scale:100;dir:lr/class/[Torneo|nombre:Texto;fechaInicio:Fecha;fechaInicioInscripciones:Fecha;fechaCierreInscripciones:Fecha;numeroParticipantes:Entero;limiteEdad:Entero;valorInscripcion:Entero]*-tipoTorneo1>[<<Enum>>;TipoTorneo|LOCAL;REGIONAL;NACIONAL;MUNDIAL],[Torneo]<>1-equipos*>[Equipo|nombre:Texto]<>1-representante1>[Representante|nombre:Texto;apellido:Texto;email:Texto;celular:Texto],[Equipo]<>1-jugador*>[Jugador|nombre:Texto;apellido:Texto;email:Texto;celular:Texto;fechaNacimiento:Fecha])
</div>

---

<style scoped>
.texto:after {
    content: 'Abstracción: ¿Cómo se agrupa la información relevante?';
  }
</style>

- Torneo
- TipoTorneo
- Equipo
- Persona
- Jugador

<div style="position: absolute; left: 23%; top:20%; ">


![](https://yuml.me/diagram/class;scale:100;dir:lr/class/[Torneo|nombre:Texto;fechaInicio:Fecha;fechaInicioInscripciones:Fecha;fechaCierreInscripciones:Fecha;numeroParticipantes:Entero;limiteEdad:Entero;valorInscripcion:Entero]*-tipoTorneo1>[<<Enum>>;TipoTorneo|LOCAL;REGIONAL;NACIONAL;MUNDIAL],[Torneo]<>1-equipos*>[Equipo|nombre:Texto]<>1-representante1>[Persona|nombre:Texto;apellido:Texto;email:Texto;celular:Texto]^-[Jugador|fechaNacimiento:Fecha],[Equipo]<>1-jugador*>[Jugador|fechaNacimiento:Fecha])
</div>

---

<style scoped>
.texto:after {
    content: 'Descomposición: ¿Cómo se distribuyen las funcionalidades?';
  }
</style>

- Almacenar la información de un torneo

![](https://yuml.me/diagram/class;scale:100;dir:lr/class/[Torneo|-nombre:Texto;-fechaInicio:Fecha;-fechaInicioInscripciones:Fecha;-fechaCierreInscripciones:Fecha;-numeroParticipantes:Entero;-limiteEdad:Entero;-valorInscripcion:Entero|+Constructor(nombre:Texto;fechaInicio:Fecha;fechaInicioInscripciones:Fecha;fechaCierreInscripciones:Fecha;numeroParticipantes:Entero;limiteEdad:Entero;valorInscripcion:Entero;tipoTorneo:TipoTorneo);+registrarEquipo(equipo:Equipo)]*-tipoTorneo1>[<<Enum>>;TipoTorneo|LOCAL;REGIONAL;NACIONAL;MUNDIAL],[Torneo]<>1-equipos*>[Equipo|nombre:Texto],[Equipo]<>1-representante1>[Persona|nombre:Texto;apellido:Texto;email:Texto;celular:Texto]^-[Jugador|fechaNacimiento:Fecha],[Equipo]<>1-jugador*>[Jugador]) 

---


<style scoped>
.texto:after {
    content: 'Descomposición: ¿Cómo se distribuyen las funcionalidades?';
  }
</style>

- Recuperar la información de un torneo

![height:450](https://yuml.me/diagram/scale:110;dir:lr/class/[Torneo|-nombre:Texto;-fechaInicio:Fecha;-fechaInicioInscripciones:Fecha;-fechaCierreInscripciones:Fecha;-numeroParticipantes:Entero;-limiteEdad:Entero;-valorInscripcion:Entero|+Constructor(nombre:Texto;fechaInicio:Fecha;fechaInicioInscripciones:Fecha;fechaCierreInscripciones:Fecha;numeroParticipantes:Entero;limiteEdad:Entero;valorInscripcion:Entero;tipoTorneo:TipoTorneo);+registrarEquipo(equipo:Equipo);+getNombre():Texto;+getFechaInicio():Fecha;+getFechaInicioInscripciones():Fecha;+getFechaCierreInscripciones():Fecha;+getNumeroParticipantes():Entero;+getLimiteEdad():Entero;+getValorInscripcion():Entero;+getTipoTorneo():TipoTorneo;+getEquipos():Equipo［*］]*-tipoTorneo1>[<<Enum>>;TipoTorneo|LOCAL;REGIONAL;NACIONAL;MUNDIAL],[Torneo]<>1-equipos*>[Equipo|nombre:Texto]<>1-representante1>[Persona|nombre:Texto;apellido:Texto;email:Texto;celular:Texto]^-[Jugador|fechaNacimiento:Fecha],[Equipo]<>1-jugadores*>[Jugador])

---


<style scoped>
.texto:after {
    content: 'Descomposición: ¿Cómo se distribuyen las funcionalidades?';
  }
</style>

<!--
_header: ''
_footer: '' 
-->


- Modificar las fechas de inscripción e inicio 
del torneo


![](https://yuml.me/diagram/scale:100;dir:lr/class/[Torneo|-nombre:Texto;-fechaInicio:Fecha;-fechaInicioInscripciones:Fecha;-fechaCierreInscripciones:Fecha;-numeroParticipantes:Entero;-limiteEdad:Entero;-valorInscripcion:Entero|+Constructor(nombre:Texto;fechaInicio:Fecha;fechaInicioInscripciones:Fecha;fechaCierreInscripciones:Fecha;numeroParticipantes:Entero;limiteEdad:Entero;valorInscripcion:Entero;tipoTorneo:TipoTorneo);+registrarEquipo(equipo:Equipo);+getNombre():Texto;+getFechaInicio():Fecha;+getFechaInicioInscripciones():Fecha;+getFechaCierreInscripciones():Fecha;+getNumeroParticipantes():Entero;+getLimiteEdad():Entero;+getValorInscripcion():Entero;+getTipoTorneo():TipoTorneo;+getEquipos():Equipo［*］;+setFechaInicio(fechaInicio:Fecha);+setFechaInicioInscripciones(fechaInicioInscripciones:Fecha);+setFechaCierreInscripciones(fechaCierreInscripciones:Fecha)]*-tipoTorneo1>[<<Enum>>;TipoTorneo|LOCAL;REGIONAL;NACIONAL;MUNDIAL],[Torneo]<>1-equipos*>[Equipo|nombre:Texto]<>1-representante1>[Persona|nombre:Texto;apellido:Texto;email:Texto;celular:Texto]^-[Jugador|fechaNacimiento:Fecha],[Equipo]<>1-jugadores*>[Jugador])


---


<style scoped>
.texto:after {
    content: 'Descomposición: ¿Cómo se distribuyen las funcionalidades?';
  }
</style>

<!--
_header: ''
_footer: '' 
-->


<div style="position: absolute; left: 5%; top:15%; ">


![](https://yuml.me/diagram/scale:100;dir:lr/class/[Torneo|-nombre:Texto;-fechaInicio:Fecha;-fechaInicioInscripciones:Fecha;-fechaCierreInscripciones:Fecha;-numeroParticipantes:Entero;-limiteEdad:Entero;-valorInscripcion:Entero|+Constructor(nombre:Texto;fechaInicio:Fecha;fechaInicioInscripciones:Fecha;fechaCierreInscripciones:Fecha;numeroParticipantes:Entero;limiteEdad:Entero;valorInscripcion:Entero;tipoTorneo:TipoTorneo);+registrarEquipo(equipo:Equipo);+getNombre():Texto;+getFechaInicio():Fecha;+getFechaInicioInscripciones():Fecha;+getFechaCierreInscripciones():Fecha;+getNumeroParticipantes():Entero;+getLimiteEdad():Entero;+getValorInscripcion():Entero;+getTipoTorneo():TipoTorneo;+getEquipos():Equipo［*］;+setFechaInicio(fechaInicio:Fecha);+setFechaInicioInscripciones(fechaInicioInscripciones:Fecha);+setFechaCierreInscripciones(fechaCierreInscripciones:Fecha);buscarEquipo(nombre:Texto):Equipo]*-tipoTorneo1>[<<Enum>>;TipoTorneo|LOCAL;REGIONAL;NACIONAL;MUNDIAL],[Torneo]<>1-equipos*>[Equipo|nombre:Texto|+Constructor(nombre:Texto;representante:Persona)]<>1-representante1>[Persona|nombre:Texto;apellido:Texto;email:Texto;celular:Texto|+Constructor(nombre:Texto;apellido:Texto;email:Texto;celular:Texto)]^-[Jugador|fechaNacimiento:Fecha],[Equipo]<>1-jugadores*>[Jugador])
</div>

<div style="position: absolute; left: 60%; top:0%; font-size: 16pt ">

- Almacenar la información de los equipos y su representante
  - Validar que no se debe excederse el número máximo de equipos
  - Validar que la inscripción se realice dentro de las fechas permitidas
  - Validar que no se permita registrar un equipo con el mismo nombre de uno ya registrado
</div>



---


<style scoped>
.texto:after {
    content: 'Descomposición: ¿Cómo se distribuyen las funcionalidades?';
  }
</style>

<!--
_header: ''
_footer: '' 
-->


<div style="position: absolute; left: 5%; top:0%; ">


![](https://yuml.me/diagram/scale:100;dir:lr/class/[Torneo|-nombre:Texto;-fechaInicio:Fecha;-fechaInicioInscripciones:Fecha;-fechaCierreInscripciones:Fecha;-numeroParticipantes:Entero;-limiteEdad:Entero;-valorInscripcion:Entero|+Constructor(nombre:Texto;fechaInicio:Fecha;fechaInicioInscripciones:Fecha;fechaCierreInscripciones:Fecha;numeroParticipantes:Entero;limiteEdad:Entero;valorInscripcion:Entero;tipoTorneo:TipoTorneo);+registrarEquipo(equipo:Equipo);+getNombre():Texto;+getFechaInicio():Fecha;+getFechaInicioInscripciones():Fecha;+getFechaCierreInscripciones():Fecha;+getNumeroParticipantes():Entero;+getLimiteEdad():Entero;+getValorInscripcion():Entero;+getTipoTorneo():TipoTorneo;+getEquipos():Equipo［*］;+setFechaInicio(fechaInicio:Fecha);+setFechaInicioInscripciones(fechaInicioInscripciones:Fecha);+setFechaCierreInscripciones(fechaCierreInscripciones:Fecha);buscarEquipo(nombre:Texto):Equipo]*-tipoTorneo1>[<<Enum>>;TipoTorneo|LOCAL;REGIONAL;NACIONAL;MUNDIAL],[Torneo]<>1-equipos*>[Equipo|nombre:Texto|+Constructor(nombre:Texto;representante:Persona);getNombre():Texto;getRepresentante():Persona;getJugadores():Jugador［*］]<>1-representante1>[Persona|nombre:Texto;apellido:Texto;email:Texto;celular:Texto|+Constructor(nombre:Texto;apellido:Texto;email:Texto;celular:Texto);getNombre():Texto;getApellido():Texto;getEmail():Texto;getCelular():Texto]^-[Jugador|fechaNacimiento:Fecha],[Equipo]<>1-jugadores*>[Jugador])
</div>

<div style="position: absolute; left: 60%; top:5%; font-size: 16pt ">

- Recuperar la información de los equipos y su representante

</div>

---


<style scoped>
.texto:after {
    content: 'Descomposición: ¿Cómo se distribuyen las funcionalidades?';
  }
img[alt~="center"] {
  display: block;
  margin: 0 auto;
}

</style>

<!--
_header: ''
_footer: '' 

-->


- Almacenar la información de los jugadores


![Alt center](https://yuml.me/diagram/scale:100;dir:lr/class/[Torneo|-nombre:Texto;-fechaInicio:Fecha;-fechaInicioInscripciones:Fecha;-fechaCierreInscripciones:Fecha;-numeroParticipantes:Entero;-limiteEdad:Entero;-valorInscripcion:Entero|+Constructor(nombre:Texto;fechaInicio:Fecha;fechaInicioInscripciones:Fecha;fechaCierreInscripciones:Fecha;numeroParticipantes:Entero;limiteEdad:Entero;valorInscripcion:Entero;tipoTorneo:TipoTorneo);+registrarEquipo(equipo:Equipo);+getNombre():Texto;+getFechaInicio():Fecha;+getFechaInicioInscripciones():Fecha;+getFechaCierreInscripciones():Fecha;+getNumeroParticipantes():Entero;+getLimiteEdad():Entero;+getValorInscripcion():Entero;+getTipoTorneo():TipoTorneo;+getEquipos():Equipo［*］;+setFechaInicio(fechaInicio:Fecha);+setFechaInicioInscripciones(fechaInicioInscripciones:Fecha);+setFechaCierreInscripciones(fechaCierreInscripciones:Fecha);buscarEquipo(nombre:Texto):Equipo;+registrarJugador(equipo:Equipo,jugador:Jugador);+registrarJugador(nombreEquipo:Texto,jugador:Jugador)]*-tipoTorneo1>[<<Enum>>;TipoTorneo|LOCAL;REGIONAL;NACIONAL;MUNDIAL],[Torneo]<>1-equipos*>[Equipo|nombre:Texto|+Constructor(nombre:Texto;representante:Persona);getNombre():Texto;getRepresentante():Persona;getJugadores():Jugador［*］;+registrarJugador(jugador:Jugador)]<>1-representante1>[Persona|nombre:Texto;apellido:Texto;email:Texto;celular:Texto|+Constructor(nombre:Texto;apellido:Texto;email:Texto;celular:Texto);getNombre():Texto;getApellido():Texto;getEmail():Texto;getCelular():Texto]^-[Jugador|fechaNacimiento:Fecha|+Constructor(nombre:Texto;apellido:Texto;email:Texto;celular:Texto;fechaNacimiento:Fecha)],[Equipo]<>1-jugadores*>[Jugador])

---


<style scoped>
.texto:after {
    content: 'Descomposición: ¿Cómo se distribuyen las funcionalidades?';
  }
img[alt~="center"] {
  display: block;
  margin: 0 auto;
}
</style>

<!--
_header: ''
_footer: '' 
-->

- Recuperar la información de los jugadores

![Alt center](https://yuml.me/diagram/scale:100;dir:lr/class/[Torneo|-nombre:Texto;-fechaInicio:Fecha;-fechaInicioInscripciones:Fecha;-fechaCierreInscripciones:Fecha;-numeroParticipantes:Entero;-limiteEdad:Entero;-valorInscripcion:Entero|+Constructor(nombre:Texto;fechaInicio:Fecha;fechaInicioInscripciones:Fecha;fechaCierreInscripciones:Fecha;numeroParticipantes:Entero;limiteEdad:Entero;valorInscripcion:Entero;tipoTorneo:TipoTorneo);+registrarEquipo(equipo:Equipo);+getNombre():Texto;+getFechaInicio():Fecha;+getFechaInicioInscripciones():Fecha;+getFechaCierreInscripciones():Fecha;+getNumeroParticipantes():Entero;+getLimiteEdad():Entero;+getValorInscripcion():Entero;+getTipoTorneo():TipoTorneo;+getEquipos():Equipo［*］;+setFechaInicio(fechaInicio:Fecha);+setFechaInicioInscripciones(fechaInicioInscripciones:Fecha);+setFechaCierreInscripciones(fechaCierreInscripciones:Fecha);buscarEquipo(nombre:Texto):Equipo;+registrarJugador(equipo:Equipo,jugador:Jugador);+registrarJugador(nombreEquipo:Texto,jugador:Jugador)]*-tipoTorneo1>[<<Enum>>;TipoTorneo|LOCAL;REGIONAL;NACIONAL;MUNDIAL],[Torneo]<>1-equipos*>[Equipo|nombre:Texto|+Constructor(nombre:Texto;representante:Persona);getNombre():Texto;getRepresentante():Persona;getJugadores():Jugador［*］;+registrarJugador(jugador:Jugador)]<>1-representante1>[Persona|nombre:Texto;apellido:Texto;email:Texto;celular:Texto|+Constructor(nombre:Texto;apellido:Texto;email:Texto;celular:Texto);getNombre():Texto;getApellido():Texto;getEmail():Texto;getCelular():Texto]^-[Jugador|fechaNacimiento:Fecha|+Constructor(nombre:Texto;apellido:Texto;email:Texto;celular:Texto;fechaNacimiento:Fecha);+getFechaNacimiento():Fecha;+calcularEdad(fecha:Fecha):Entero],[Equipo]<>1-jugadores*>[Jugador])


---

<style scoped>
.texto:after {
    content: 'Descomposición: ¿Qué debo hacer para probar las funcionalidades?';
  }
</style>

- Almacenar datos de prueba
- Recuperar los datos de prueba
- Verificar que los datos almacenados coinciden con los datos recuperados
- Modificar datos de la prueba
- Recuperar datos de la prueba
- Verificar que los datos almacenados y modificados coinciden con los datos recuperados


---


<style scoped>
.texto:after {
    content: 'Descomposición: ¿Qué debo hacer para probar las funcionalidades?';
  }
</style>

<div style="font-size: 9pt">
<!-- https://www.tablesgenerator.com/markdown_tables -->

| Prueba                                | Entrada de datos                                          | Salida (Resultado)                                                                                  |
|---------------------------------------|-----------------------------------------------------------|-----------------------------------------------------------------------------------------------------|
| Datos Completos                       | Copa Mundo\|2023-10-01\| 2023-08-01\|2023-09-15\|24\|0\|0\|LOCAL | Torneo creado con los datos proporcionados Copa Mundo\|2023-10-01\|2023-08-01\|2023-09-15\|24\|0\|0\|LOCAL |
| Con datos nullos                      | null\|null\|null\|null\|24\|0\|0\|null                          | Error, faltan datos para la creación del torneo                                                     |
| Participantes negativos               | Copa Mundo\|2023-10-01\|2023-08-01\|2023-09-15\|-24\|0\|0\|LOCAL | Error: porque no se puede crear un torneo con número negativo de participantes                      |
| Limite edad negativo                  | Copa Mundo\|2023-10-01\|2023-08-01\|2023-09-15\|24\|-1\|0\|LOCAL | Error: porque no se puede crear un torneo con número negativo en el límite de edad                  |
| Inscripción negativa                  | Copa Mundo\|2023-10-01\|2023-08-01\|2023-09-15\|24\|0\|-1\|LOCAL | Error: porque no se puede crear un torneo con número negativo en la inscripción                     |
| Fechas Inscripción tardías            | Copa Mundo\|2023-10-01\|2023-11-01\|2023-11-15\|24\|0\|0\|LOCAL  | Error: Las inscripciones no pueden ser posteriores al inicio del torneo                             |
| Cierre inscripción anterior al inicio | Copa Mundo\|2023-10-01\|2023-08-15\|2023-08-01\|24\|0\|0\|LOCAL  | Error: El cierre de las inscripciones no puede ser anterior al inicio de las inscripciones.         |

</div>

---


<style scoped>
.texto:after {
    content: 'Descomposición: ¿Qué debo hacer para probar las funcionalidades?';
  }
</style>

<div style="font-size: 9pt">
<!-- https://www.tablesgenerator.com/markdown_tables -->

| Prueba                                | Entrada de datos                                          | Salida (Resultado)                                                                                  |
|---------------------------------------|-----------------------------------------------------------|-----------------------------------------------------------------------------------------------------|
| Modificar fecha inicio, valido | Copa Mundo\|2023-10-01\| 2023-08-01\|2023-09-15\|24\|0\|0\|LOCAL  <br/> Nueva fecha de inicio 2023-10-12 | Torneo creado con los datos proporcionados Copa Mundo\|2023-10-01\|2023-08-01\|2023-09-15\|24\|0\|0\|LOCAL   <br/> Torneo con los datos modificados Copa Mundo\|2023-10-12\|2023-08-01\|2023-09-15\|24\|0\|0\|LOCAL |
| Modificar fecha inicio, con null | Copa Mundo\|2023-10-01\| 2023-08-01\|2023-09-15\|24\|0\|0\|LOCAL  <br/>  Nueva fecha de inicio null      | Torneo creado con los datos proporcionados Copa Mundo\|2023-10-01\|2023-08-01\|2023-09-15\|24\|0\|0\|LOCAL  <br/>  Error la fecha de inicio no puede ser null                                               |
| Modificar fecha inicio, con fecha de inicio anterior a las inscripciones | Copa Mundo\|2023-10-01\| 2023-08-01\|2023-09-15\|24\|0\|0\|LOCAL  Nueva fecha de inicio 2023-07-01 | Torneo creado con los datos proporcionados Copa Mundo\|2023-10-01\|2023-08-01\|2023-09-15\|24\|0\|0\|LOCAL  Error la fecha de inicio es anterior a las inscripciones                                 |
| Modificar fecha inicio de inscripciones, valido | Copa Mundo\|2023-10-01\| 2023-08-01\|2023-09-15\|24\|0\|0\|LOCAL  <br/> Nueva fecha de inicio de inscripciones 2023-08-10 | Torneo creado con los datos proporcionados Copa Mundo\|2023-10-01\|2023-08-01\|2023-09-15\|24\|0\|0\|LOCAL   <br/> Torneo con los datos modificados Copa Mundo\|2023-10-01\|2023-08-10\|2023-09-15\|24\|0\|0\|LOCAL |
| Modificar fecha inicio de inscripciones con null | Copa Mundo\|2023-10-01\| 2023-08-01\|2023-09-15\|24\|0\|0\|LOCAL  <br/>  Nueva fecha de inicio de inscripciones null      | Torneo creado con los datos proporcionados Copa Mundo\|2023-10-01\|2023-08-01\|2023-09-15\|24\|0\|0\|LOCAL  <br/>  Error la fecha de inicio de inscripciones no puede ser null                                               |


</div>

---

<style scoped>
.texto:after {
    content: 'Descomposición: ¿Qué debo hacer para probar las funcionalidades?';
  }
</style>

<div style="font-size: 9pt">
<!-- https://www.tablesgenerator.com/markdown_tables -->

| Prueba                                | Entrada de datos                                          | Salida (Resultado)                                                                                  |
|---------------------------------------|-----------------------------------------------------------|-----------------------------------------------------------------------------------------------------|
| Modificar fecha inicio de inscripciones con fecha de inicio posterior a la fecha de cierre de inscripciones | Copa Mundo\|2023-10-01\| 2023-08-01\|2023-09-15\|24\|0\|0\|LOCAL  Nueva fecha de inicio de inscripciones 2023-09-16 | Torneo creado con los datos proporcionados Copa Mundo\|2023-10-01\|2023-08-01\|2023-09-15\|24\|0\|0\|LOCAL  Error la fecha de inicio de inscripciones no puede ser posterior a la fecha de cierre                                  |
| Modificar fecha de cierre de inscripciones, valido | Copa Mundo\|2023-10-01\| 2023-08-01\|2023-09-15\|24\|0\|0\|LOCAL  <br/> Nueva fecha de cierre de inscripciones 2023-09-16 | Torneo creado con los datos proporcionados Copa Mundo\|2023-10-01\|2023-08-01\|2023-09-15\|24\|0\|0\|LOCAL   <br/> Torneo con los datos modificados Copa Mundo\|2023-10-01\|2023-08-10\|2023-09-16\|24\|0\|0\|LOCAL |
| Modificar fecha de cierre de inscripciones con null | Copa Mundo\|2023-10-01\| 2023-08-01\|2023-09-15\|24\|0\|0\|LOCAL  <br/>  Nueva fecha de cierre de inscripciones null      | Torneo creado con los datos proporcionados Copa Mundo\|2023-10-01\|2023-08-01\|2023-09-15\|24\|0\|0\|LOCAL  <br/>  Error la fecha de cierre de inscripciones no puede ser null                                               |
| Modificar fecha de cierre de inscripciones con fecha posterior a la fecha de inicio del torneo | Copa Mundo\|2023-10-01\| 2023-08-01\|2023-09-15\|24\|0\|0\|LOCAL  Nueva fecha de cierre de inscripciones 2023-10-02 | Torneo creado con los datos proporcionados Copa Mundo\|2023-10-01\|2023-08-01\|2023-09-15\|24\|0\|0\|LOCAL  Error la fecha de cierre de inscripciones no puede ser posterior a la fecha de inicio del torneo                                  |
| Modificar fecha de cierre de inscripciones con fecha anterior a la fecha de inicio de inscripciones | Copa Mundo\|2023-10-01\| 2023-08-01\|2023-09-15\|24\|0\|0\|LOCAL  Nueva fecha de cierre de inscripciones 2023-07-30 | Torneo creado con los datos proporcionados Copa Mundo\|2023-10-01\|2023-08-01\|2023-09-15\|24\|0\|0\|LOCAL  Error la fecha de cierre de inscripciones no puede ser anterior a la fecha de inicio de inscripciones                                  |

</div>

---


<style scoped>
.texto:after {
    content: 'Descomposición: ¿Qué debo hacer para probar las funcionalidades?';
  }
</style>

<div style="font-size: 9pt">
<!-- https://www.tablesgenerator.com/markdown_tables -->

| Prueba                                | Entrada de datos                                          | Salida (Resultado)                                                                                  |
|---------------------------------------|-----------------------------------------------------------|-----------------------------------------------------------------------------------------------------|
| Registrar un equipo en el torneo                       | Torneo{Copa Mundo\|fechaActual+ 1mes\| fechaActual - 15 días\|fechaActual+15 días\|24\|0\|0\|LOCAL}  Equipo{Uniquindio} Representante{Robinson,Pulgarin,rpulgarin@email.com,6067359300} | Torneo creado con los datos proporcionados Copa Mundo\|fechaActual+ 1mes\| fechaActual - 15 días\|fechaActual+15 días\|24\|0\|0\|LOCAL\|[Equipo{uniquindio,{Robinson,Pulgarin,rpulgarin@email.com,6067359300}}] |
| Registrar un equipo con nombre repetido                     | Torneo{Copa Mundo\|fechaActual+ 1mes\| fechaActual - 15 días\|fechaActual+15 días\|24\|0\|0\|LOCAL}  Equipo{Uniquindio} Representante{Robinson,Pulgarin,rpulgarin@email.com,6067359300}, Equipo{Uniquindio} Representante{Robinson,Pulgarin,rpulgarin@email.com,6067359300}                          | Error, el equipo ya existe                                                     |
| Registro cuando las inscripciones ya cerraron               | Torneo{Copa Mundo\|fechaActual+ 1mes\| fechaActual - 15 días\|fechaActual-1 día\|24\|0\|0\|LOCAL}  Equipo{Uniquindio} Representante{Robinson,Pulgarin,rpulgarin@email.com,6067359300}                           | Error: Las inscripciones ya cerraron                      |
| Registro cuando las inscripciones no han abierto  | Torneo{Copa Mundo\|fechaActual+ 1mes\| fechaActual + 1 día\|fechaActual+15 días\|24\|0\|0\|LOCAL}  Equipo{Uniquindio} Representante{Robinson,Pulgarin,rpulgarin@email.com,6067359300}                           | Error: Las inscripciones no han abierto                      |

---

<style scoped>
.texto:after {
    content: 'Descomposición: ¿Qué debo hacer para probar las funcionalidades?';
  }  
</style>

<div style="font-size: 9pt">
<!-- https://www.tablesgenerator.com/markdown_tables -->

| Prueba                                | Entrada de datos                                          | Salida (Resultado)                                                                                  |
|---------------------------------------|-----------------------------------------------------------|-----------------------------------------------------------------------------------------------------|
| Registrar un jugador en un equipo desde el equipo      | Equipo{Uniquindio} Representante{Robinson,Pulgarin,rpulgarin@email.com,6067359300} Jugador {Christian,Candela,chrcandela@email.com,6067431234, fechaActual - 15 años} | Torneo creado con los datos proporcionados Copa Mundo\|fechaActual+ 1mes\| fechaActual - 15 días\|fechaActual+15 días\|24\|18\|0\|LOCAL\|[Equipo{uniquindio,{Robinson,Pulgarin,rpulgarin@email.com,6067359300}} Jugador {Christian,Candela,chrcandela@email.com,6067431234}] |
| Registrar un jugador en un equipo desde el torneo      | Torneo{Copa Mundo\|fechaActual+ 1mes\| fechaActual - 15 días\|fechaActual+15 días\|24\|18\|0\|LOCAL}  Equipo{Uniquindio} Representante{Robinson,Pulgarin,rpulgarin@email.com,6067359300} Jugador {Christian,Candela,chrcandela@email.com,6067431234, fechaActual - 15 años} | Torneo creado con los datos proporcionados Copa Mundo\|fechaActual+ 1mes\| fechaActual - 15 días\|fechaActual+15 días\|24\|18\|0\|LOCAL\|[Equipo{uniquindio,{Robinson,Pulgarin,rpulgarin@email.com,6067359300}} Jugador {Christian,Candela,chrcandela@email.com,6067431234}] |
| Registrar un jugador en un torneo sin limite de edad (0)      | Torneo{Copa Mundo\|fechaActual+ 1mes\| fechaActual - 15 días\|fechaActual+15 días\|24\|0\|0\|LOCAL}  Equipo{Uniquindio} Representante{Robinson,Pulgarin,rpulgarin@email.com,6067359300} Jugador {Christian,Candela,chrcandela@email.com,6067431234, fechaActual - 21 años} | Torneo{Copa Mundo\|fechaActual+ 1mes\| fechaActual - 15 días\|fechaActual+15 días\|24\|0\|0\|LOCAL}  Equipo{Uniquindio} Representante{Robinson,Pulgarin,rpulgarin@email.com,6067359300} Jugador {Christian,Candela,chrcandela@email.com,6067431234, fechaActual - 21 años} |
| Registrar un jugador mayor a la edad permitida (desde el torneo)      | Torneo{Copa Mundo\|fechaActual+ 1mes\| fechaActual - 15 días\|fechaActual+15 días\|24\|18\|0\|LOCAL}  Equipo{Uniquindio} Representante{Robinson,Pulgarin,rpulgarin@email.com,6067359300} Jugador {Christian,Candela,chrcandela@email.com,6067431234, fechaActual - 21 años} | Error, el jugador es mayor a la edad límite. |

</div>

---


<style scoped>
.texto:after {
    content: 'Descomposición: ¿Qué debo hacer para probar las funcionalidades?';
  }
</style>

<div style="font-size: 9pt">
<!-- https://www.tablesgenerator.com/markdown_tables -->

| Prueba                                | Entrada de datos                                          | Salida (Resultado)                                                                                  |
|---------------------------------------|-----------------------------------------------------------|-----------------------------------------------------------------------------------------------------|
| Registro de un jugador si las inscripciones ya cerraron               | Torneo{Copa Mundo\|fechaActual+ 1mes\| fechaActual - 15 días\|fechaActual-1 día\|24\|18\|0\|LOCAL}  Equipo{Uniquindio} Representante{Robinson,Pulgarin,rpulgarin@email.com,6067359300} Jugador {Christian,Candela,chrcandela@email.com,6067431234, fechaActual - 15 años}                          | Error: Las inscripciones ya cerraron                      |
| Registrar dos jugadores con nombre y apellido idénticos en el mismo equipo (desde el equipo) | Equipo{Uniquindio} Representante{Robinson,Pulgarin,rpulgarin@email.com,6067359300}, Jugador {Christian,Candela,chrcandela@email.com,6067431234, fechaActual - 15 años}Jugador {Christian,Candela,ccandela@email.com,6067431235, fechaActual - 15 años}                         | Error, el jugador ya existe                                                     |
| Registrar dos jugadores con nombre y apellido idénticos en equipos diferentes  (desde el torneo) | Torneo{Copa Mundo\|fechaActual+ 1mes\| fechaActual - 15 días\|fechaActual+15 días\|24\|18\|0\|LOCAL}  Equipo{Uniquindio} Representante{Robinson,Pulgarin,rpulgarin@email.com,6067359300},  Jugador {Christian,Candela,chrcandela@email.com,6067431234, fechaActual - 15 años}, Jugador {Christian,Candela,ccandela@email.com,6067431235, fechaActual - 15 años}, Equipo{Quindío}    | Error, el jugador ya existe                                                     |
</div>

---

<!-- 
_header: ''
_footer: '' 
_paginate: false
_backgroundImage: url('imagenes/gracias.png')
-->
