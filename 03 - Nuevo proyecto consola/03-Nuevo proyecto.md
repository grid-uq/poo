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
<h2>Creando un nuevo proyecto desde la terminal</h2>

</b>
</div>


<div style="position: absolute; left: 93%; top:10px; ">

![width:80](imagenes/licencia.png)
</div>

---

<!--  -->
<style scoped>
.texto:after {
    content: 'Abra una terminal (power shell en windows)';
  }
</style>

 

![bg 90%](capturas/01.png)

---

<!--  -->
<style scoped>
.texto:after {
    content: 'Listar las plantillas';
  }
</style>

```shell
mvn archetype:generate
```

![width:1200](capturas/02.png)
Al presionar enter seleccionará el archetype por defecto 2072 (quick start).

---


<!--  -->
<style scoped>
.texto:after {
    content: 'Seleccione la Versión más actual, en este caso 1.4';
  }
</style>

![width:1200](capturas/03.png)

Al presionar enter seleccionará la versión por defecto 8 (1.4)


---

<!--  -->
<style scoped>
.texto:after {
    content: 'Escriba el "group id" para el caso co.edu.uniquindio.poo';
  }
</style>

![width:1200](capturas/04.png)

Tras ingresar el group id presione enter.

---

<!--  -->
<style scoped>
.texto:after {
    content: 'Escriba el nombre del proyecto, por ejemplo "nombreproyecto"';
  }
</style>

![width:1200](capturas/05.png)

Tras ingresar el nombre del proyecto (artifact id) presione enter.

---


<!--  -->
<style scoped>
.texto:after {
    content: 'Ingrese la versión del proyecto, por ejemplo 1.0';
  }
</style>

![width:1200](capturas/06.png)

Tras ingresar la versión del proyecto presione enter.

---

<!--  -->
<style scoped>
.texto:after {
    content: 'Acepte la creación del paquete "co.edu.uniquindio.poo"';
  }
</style>

![width:1200](capturas/07.png)

Al presionar enter aceptara el paquete por defecto (co.edu.uniquindio.poo)


---

<!--  -->
<style scoped>
.texto:after {
    content: 'Confirme los datos de creación';
  }
</style>

![width:1200](capturas/08.png)

Al presionar enter confirmará los datos.

---

<!--  -->
<style scoped>
.texto:after {
    content: 'Proyecto creado';
  }
</style>

![width:1200](capturas/09.png)

El proyecto ha sido creado, abralo en el Visual Studio Code.


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
  section{
    font-size:20pt
  }
</style>


# Actualizando el archivo de configuración **pom.xml**


- Número de la versión a de Java que se utilizará, para nuestro caso, 17.

- Cambiar la versión del componente de pruebas a **JUnit Jupiter**.

  - Actualizar el ejemplo de la prueba a la nueva versión

- Elimine los *plugins* que no usaremos, dejando solamente:
  - *maven-compiler-plugin* (utilizado para compilar el proyecto) v. 3.11.0
    <div style="font-size:12pt">

    https://mvnrepository.com/artifact/org.apache.maven.plugins/maven-compiler-plugin
    </div>

  - *maven-surefire-plugin* (utilizado para ejecutar las pruebas) v. 3.1.2
    <div style="font-size:12pt">

    https://mvnrepository.com/artifact/org.apache.maven.plugins/maven-surefire-plugin
    </div>

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
