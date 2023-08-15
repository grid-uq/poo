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


<style scoped>
.texto:after {
    content: 'Problema:';
  }
</style>

Un importante promotor deportivo le ha solicitado que diseñe un sistema para la gestión de las inscripciones a torneos deportivos. El necesita que la aplicación permita:



Almacenar la información de un torneo. La información que se requiere es: número máximo de equipos participantes, el nombre del torneo, el límite de edad de los jugadores (en caso de tenerlo), la fecha de inicio de las inscripciones, la fecha de cierre de las inscripciones, el valor de la inscripción y la fecha de inicio del torneo.


---

<style scoped>
.texto:after {
    content: 'Abstracción: ¿Qué se solicita finalmente? (problema)';
  }
</style>

- Almacenar la información de un torneo


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



---

<style scoped>
.texto:after {
    content: 'Abstracción: ¿Cómo se agrupa la información relevante?';
  }
</style>

- Torneo

<div style="position: absolute; left: 40%; top:30%; ">


![](https://yuml.me/diagram/class;scale:150/class/[Torneo|nombre:Texto;fechaInicio:Fecha;fechaInicioInscripciones:Fecha;fechaCierreInscripciones:Fecha;numeroParticipantes:Entero;limiteEdad:Entero;valorInscripcion:Entero])
</div>

---


<style scoped>
.texto:after {
    content: 'Abstracción: ¿Qué solicitan finalmente?';
  }
</style>

- Almacenar la información de un torneo
- Recuperar la información de un torneo



---


<style scoped>
.texto:after {
    content: 'Descomposición: ¿Cómo se distribuyen las funcionalidades?';
  }
</style>

- Almacenar la información de un torneo

<div style="position: absolute; left: 60%; top:30%; ">


![](https://yuml.me/diagram/class;scale:100/class/[Torneo|-nombre:Texto;-fechaInicio:Fecha;-fechaInicioInscripciones:Fecha;-fechaCierreInscripciones:Fecha;-numeroParticipantes:Entero;-limiteEdad:Entero;-valorInscripcion:Entero|+Constructor(nombre:Texto;fechaInicio:Fecha;fechaInicioInscripciones:Fecha;fechaCierreInscripciones:Fecha;numeroParticipantes:Entero;limiteEdad:Entero;valorInscripcion:Entero)])
</div>

---


<style scoped>
.texto:after {
    content: 'Descomposición: ¿Cómo se distribuyen las funcionalidades?';
  }
</style>

- Recuperar la información de un torneo

<div style="position: absolute; left: 60%; top:15%; ">


![](https://yuml.me/diagram/class;scale:100/class/[Torneo|-nombre:Texto;-fechaInicio:Fecha;-fechaInicioInscripciones:Fecha;-fechaCierreInscripciones:Fecha;-numeroParticipantes:Entero;-limiteEdad:Entero;-valorInscripcion:Entero|+Constructor(nombre:Texto;fechaInicio:Fecha;fechaInicioInscripciones:Fecha;fechaCierreInscripciones:Fecha;numeroParticipantes:Entero;limiteEdad:Entero;valorInscripcion:Entero);+getNombre():Texto;+getFechaInicio():Fecha;+getFechaInicioInscripciones():Fecha;+getFechaCierreInscripciones():Fecha;+getNumeroParticipantes():Entero;+getLimiteEdad():Entero;+getValorInscripcion():Entero])
</div>

---

<style scoped>
.texto:after {
    content: 'Descomposición: ¿Qué debo hacer para probar las funcionalidades?';
  }
</style>

- Almacenar datos de prueba
- Recuperar los datos de prueba
- Verificar que los datos almacenados coinciden con los datos recuperados


---


<style scoped>
.texto:after {
    content: 'Descomposición: ¿Qué debo hacer para probar las funcionalidades?';
  }
</style>

<div style="font-size: 9pt">

| Prueba                                | Entrada de datos                                          | Salida (Resultado)                                                                                  |
|---------------------------------------|-----------------------------------------------------------|-----------------------------------------------------------------------------------------------------|
| Datos Completos                       | Copa Mundo\|2023-10-01\| 2023-08-01\|2023-09-15\|24\|0\|0 | Torneo creado con los datos proporcionados Copa Mundo\|2023-10-01\|2023-08-01\|2023-09-15\|24\|0\|0 |
| Con datos nullos                      | null\|null\|null\|null\|24\|0\|0                          | Error, faltan datos para la creación del torneo                                                     |
| Participantes negativos               | Copa Mundo\|2023-10-01\|2023-08-01\|2023-09-15\|-24\|0\|0 | Error: porque no se puede crear un torneo con número negativo de participantes                      |
| Limite edad negativo                  | Copa Mundo\|2023-10-01\|2023-08-01\|2023-09-15\|24\|-1\|0 | Error: porque no se puede crear un torneo con número negativo en el límite de edad                  |
| Inscripción negativa                  | Copa Mundo\|2023-10-01\|2023-08-01\|2023-09-15\|24\|0\|-1 | Error: porque no se puede crear un torneo con número negativo en la inscripción                     |
| Fechas Inscripción tardías            | Copa Mundo\|2023-10-01\|2023-11-01\|2023-11-15\|24\|0\|0  | Error: Las inscripciones no pueden ser posteriores al inicio del torneo                             |
| Cierre inscripción anterior al inicio | Copa Mundo\|2023-10-01\|2023-08-15\|2023-08-01\|24\|0\|0  | Error: El cierre de las inscripciones no puede ser anterior al inicio de las inscripciones.         |

</div>

---


<style scoped>
.texto:after {
    content: 'Reconocimiento de patrones: ¿Qué puede reutilizar?';
  }
</style>

- No aplica


---

<style scoped>
.texto:after {
    content: 'Codificación: ';
  }
</style>

<h1>Usando un registro</h1>
Constructor con todos los atributos + métodos gets


<div style="position: absolute; left: 60%; top:15%; ">


![](https://yuml.me/diagram/class;scale:100/class/[Torneo|-nombre:Texto;-fechaInicio:Fecha;-fechaInicioInscripciones:Fecha;-fechaCierreInscripciones:Fecha;-numeroParticipantes:Entero;-limiteEdad:Entero;-valorInscripcion:Entero|+Constructor(nombre:Texto;fechaInicio:Fecha;fechaInicioInscripciones:Fecha;fechaCierreInscripciones:Fecha;numeroParticipantes:Entero;limiteEdad:Entero;valorInscripcion:Entero);+getNombre():Texto;+getFechaInicio():Fecha;+getFechaInicioInscripciones():Fecha;+getFechaCierreInscripciones():Fecha;+getNumeroParticipantes():Entero;+getLimiteEdad():Entero;+getValorInscripcion():Entero])
</div>

---

<style scoped>
.texto:after {
    content: 'Codificación: ¿Cómo pruebo la solución en JAVA?';
  }
</style>

```java
/**
* Clase para probar el funcionamiento del Torneo
* @author Área de programación UQ
* @since 2023-08
*
* Licencia GNU/GPL V3.0 (https://www.gnu.org/licenses/lgpl-3.0.html#license-text)
*/
package co.edu.uniquindio.poo.torneodeportivo;
import java.util.logging.Logger;

public class TorneoTest {
   /**
    * Instacia para el menejo de logs
    */
   private static final Logger LOG = Logger.getLogger(TorneoTest.class.getName());
}
```



---

<!-- 
_header: ''
_footer: '' 
_paginate: false
_backgroundImage: url('imagenes/gracias.png')
-->
