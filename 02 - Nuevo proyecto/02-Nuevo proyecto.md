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

<div style="position: absolute; left: 45%; top:20%; background-color: rgb(212, 231, 205); width: 550px; display:table-cell; text-align: center; padding: 30px 0;">
<b>
<h2>Creando un nuevo proyecto</h2>
</b>
</div>


<div style="position: absolute; left: 93%; top:10px; ">

![width:80](imagenes/licencia.png)
</div>

---

<!--  -->
<style scoped>
.texto:after {
    content: 'Ingrese a Visual Studio Code';
  }
</style>

![bg 80%](capturas/01.png)

---

<!--  -->
<style scoped>
.texto:after {
    content: 'Clic "Create Java Project" en la opción  "EXPLORER" (primer icono de la izquierda)';
  }
</style>

![bg 80%](capturas/02.png)

---

<!--  -->
<style scoped>
.texto:after {
    content: 'Seleccione "Maven create from archetype"';
  }
</style>

![bg 80%](capturas/04.png)



---

<!--  -->
<style scoped>
.texto:after {
    content: 'Seleccione "maven-archetype-quickstart"';
  }
</style>

![bg 80%](capturas/06.png)

---

<!--  -->
<style scoped>
.texto:after {
    content: 'Seleccione la Versión más actual, en este caso 1.4';
  }
</style>

![bg 80%](capturas/08.png)

---

<!--  -->
<style scoped>
.texto:after {
    content: 'Escriba el "group id" para el caso co.edu.uniquindio.poo';
  }
</style>

![bg 80%](capturas/09.png)

---

<!--  -->
<style scoped>
.texto:after {
    content: 'Escriba el nombre del proyecto, por ejemplo "nombreproyecto"';
  }
</style>

![bg 80%](capturas/10.png)


---

<!--  -->
<style scoped>
.texto:after {
    content: 'Cree una carpeta de trabajo, por ejemplo "Proyecto"';
  }
</style>

![bg 80%](capturas/11.png)


---

<!--  -->
<style scoped>
.texto:after {
    content: 'Seleccione la carpeta de trabajo para el caso "Proyecto"';
  }
</style>

![bg 80%](capturas/12.png)


---

<!--  -->
<style scoped>
.texto:after {
    content: 'Espere mientras se creen el proyecto';
  }
</style>

![bg 80%](capturas/13.png)


---

<!--  -->
<style scoped>
.texto:after {
    content: 'Espere mientras se descargan ciertos elementos necesarios';
  }
</style>

![bg 80%](capturas/14.png)


---

<!--  -->
<style scoped>
.texto:after {
    content: 'Ingrese la versión del proyecto, por ejemplo 1.0 (parte inferior en la TERMINAL)';
  }
</style>

![bg 80%](capturas/15.png)


---

<!--  -->
<style scoped>
.texto:after {
    content: 'Acepte la creación del paquete "co.edu.uniquindio.poo" (parte inferior)';
  }
</style>

![bg 80%](capturas/16.png)


---

<!--  -->
<style scoped>
.texto:after {
    content: 'Espere mientras se terminan de crear y configurar el proyecto';
  }
</style>

![bg 80%](capturas/17.png)


---

<!--  -->
<style scoped>
.texto:after {
    content: 'Clic "Open Folder" en la opción  "EXPLORER" y seleccione la carpeta del proyecto';
  }
</style>

![bg 80%](capturas/18.png)


---

<!--  -->
<style scoped>
.texto:after {
    content: 'Observe al lado izquierdo (nombre del proyecto, carpeta src y un archivo pom.xml)';
  }
</style>

![bg 80%](capturas/19.png)


---

<!--  -->
<style scoped>
.texto:after {
    content: 'Dentro de la carpeta src está un ejemplo "App.java" y "AppTest.java"';
  }
</style>

![bg 80%](capturas/20.png)


---

<!--  -->
<style scoped>
.texto:after {
    content: '"App.java" es un ejemplo que imprime en pantalla "Hello World!"';
  }
</style>

![bg 80%](capturas/21.png)


---

<!--  -->
<style scoped>
.texto:after {
    content: 'Si lo desea lo puede ejecutar el ejemplo con el icono en forma triángulo parte superior derecha';
  }
</style>

![bg 80%](capturas/22.png)


---

<!--  -->
<style scoped>
.texto:after {
    content: '"AppTest.java" es un ejemplo de una prueba';
  }
</style>

![bg 80%](capturas/23.png)


---

<!--  -->
<style scoped>
.texto:after {
    content: 'Puede ejecutar la prueba usando el icono en forma de botella de laboratorio (a la izquierda y en el medio) y en el triángulo de la prueba';
  }
</style>

![bg 80%](capturas/24.png)


---

<!--  -->
<style scoped>
.texto:after {
    content: 'Observe el archivo de configuración del proyecto Maven (pom.xml)';
  }
</style>

![bg 80%](capturas/25.png)


---
<style scoped>
.texto:after {
    content: '';
  }
</style>


# Actualizando el archivo de configuración **pom.xml**


- Número de la versión a de Java que se utilizará, para nuestro caso, 17.

- Cambiar la versión del componente de pruebas a **JUnit Jupiter**.

  - Actualizar el ejemplo de la prueba a la nueva versión

- (opcionalmente) eliminar los *plugins* que no usaremos, dejando solamente:
  - *maven-compiler-plugin* (utilizado para compilar el proyecto) v. 3.11.0
  - *maven-surefire-plugin* (utilizado para ejecutar las pruebas) v. 3.1.2

---

<!--  -->
<style scoped>
.texto:after {
    content: 'Actualice el número de la versión de Java a utilizar, para nosotros será 17';
  }
</style>

![bg 80%](capturas/26.png)


---

<!--  -->
<style scoped>
.texto:after {
    content: 'Busque en Internet "junit-jupiter maven"';
  }
</style>

![bg 80%](capturas/29.png)


---

<!--  -->
<style scoped>
.texto:after {
    content: 'Clic en la última versión, para el caso 5.10.0';
  }
</style>

![bg 80%](capturas/30.png)


---

<!--  -->
<style scoped>
.texto:after {
    content: 'Seleccione y copie las líneas para la configuración Maven ';
  }
</style>

![bg 80%](capturas/32.png)


---

<!--  -->
<style scoped>
.texto:after {
    content: 'Elimine del archivo pom.xml la dependencia junit 4.11';
  }
</style>

![bg 80%](capturas/33.png)


---

<!--  -->
<style scoped>
.texto:after {
    content: 'Pegue en el mismo lugar del archivo pom.xml las líneas que copió de Internet junit-jupiter';
  }
</style>

![bg 80%](capturas/34.png)


---

<!--  -->
<style scoped>
.texto:after {
    content: 'Seleccione "Always" para sincronizar los cambios en el proyecto';
  }
</style>

![bg 80%](capturas/35.png)

---

<!--  -->
<style scoped>
.texto:after {
    content: 'Deje los plugins que utilizaremos y actualice la versión según la imágen';
  }
</style>

![bg 80%](capturas/41.png)

---

<!--  -->
<style scoped>
.texto:after {
    content: 'Ajuste el archivo de la prueba para nueva versión';
  }
</style>

![bg 80%](capturas/36.png)


---

<!--  -->
<style scoped>
.texto:after {
    content: 'Ejecute nuevamente la prueba';
  }
</style>

![bg 80%](capturas/38.png)


---


<!--  -->
<style scoped>
.texto:after {
    content: 'Modifique la prueba con este ejemplo';
  }
</style>

![bg 80%](capturas/39.png)


---

<!--  -->
<style scoped>
.texto:after {
    content: 'Finalmente haga que la prueba falle usando un valor diferente para la variable obtenido';
  }
</style>

![bg 80%](capturas/40.png)

---

<!-- 
_header: ''
_footer: '' 
_paginate: false
_backgroundImage: url('imagenes/gracias.png')
-->
