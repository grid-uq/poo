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

<!-- Arquetipo MAVEN -->
<style scoped>
.texto:after {
    content: 'VSCode: Cree un nuevo proyecto Java';
  }
</style>

![bg 50%](capturas/93.png)

---

<!-- Arquetipo MAVEN -->
<style scoped>
.texto:after {
    content: 'Seleccionar un proyecto Maven';
  }
</style>

![bg 88%](capturas/94.png)

---

<!-- Arquetipo MAVEN -->
<style scoped>
.texto:after {
    content: 'Seleccionar "arquetipo-poo-uq"';
  }
</style>

![bg 88%](capturas/95.png)

---

<!-- Arquetipo MAVEN -->
<style scoped>
.texto:after {
    content: 'Confirmar la versión del proyecto';
  }
</style>

![bg 88%](capturas/96.png)

---

<!-- Arquetipo MAVEN -->
<style scoped>
.texto:after {
    content: 'Indicar el Group ID, por ejemplo: "co.edu.uniquindio.poo"';
  }
</style>

![bg 88%](capturas/97.png)

---

<!-- Arquetipo MAVEN -->
<style scoped>
.texto:after {
    content: 'Ingresar el nombre del proyecto';
  }
</style>

![bg 88%](capturas/98.png)

---

<!-- Arquetipo MAVEN -->
<style scoped>
.texto:after {
    content: 'Seleccionar la carpeta destino para el proyecto, por ejemplo, Workspace-Proyecto';
  }
</style>

![bg 67%](capturas/99.png)

---

<!-- Arquetipo MAVEN -->
<style scoped>
.texto:after {
    content: 'Confirmar los datos en la terminal <Enter>';
  }
</style>

![bg 80%](capturas/100.png)

---

<!-- Arquetipo MAVEN -->
<style scoped>
.texto:after {
    content: 'Esperar que el proyecto se cree correctamente...';
  }
</style>

![bg 70%](capturas/101.png)

---

<!-- Arquetipo MAVEN -->
<style scoped>
.texto:after {
    content: 'Abra el proyecto recién creado';
  }
</style>

![bg 80%](capturas/102.png)

---

<!-- Arquetipo MAVEN -->
<style scoped>
.texto:after {
    content: 'Observe la estructura del nuevo proyecto';
  }
</style>

![bg 45%](capturas/103.png)

---

<!-- Arquetipo MAVEN -->
<style scoped>
.texto:after {
    content: 'App.java';
  }
</style>

![bg 70%](capturas/104.png)

---

<!-- Arquetipo MAVEN -->
<style scoped>
.texto:after {
    content: 'AppTest.java';
  }
</style>

![bg 50%](capturas/105.png)

---

<!-- Arquetipo MAVEN -->
<style scoped>
.texto:after {
    content: 'Ejecute la prueba generada';
  }
</style>

![bg 70%](capturas/108.png)

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

<!-- Arquetipo MAVEN -->
<style scoped>
.texto:after {
    content: 'Cierre la carpeta de trabajo';
  }
</style>

![bg 25%](capturas/110.png)

---

<!-- 
_header: ''
_footer: '' 
_paginate: false
_backgroundImage: url('imagenes/gracias.png')
-->
