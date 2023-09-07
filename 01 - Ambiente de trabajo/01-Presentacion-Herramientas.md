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
<h2>Herramientas</h2>
</b>
</div>


<div style="position: absolute; left: 93%; top:10px; ">

![width:80](imagenes/licencia.png)
</div>

---


<style scoped>
.texto:after {
    content: 'Herramientas a instalar';
  }
</style>

- OpenJDK 17 (https://adoptium.net/es) 
- Visual Studio Code Versión 1.80 (https://code.visualstudio.com/)
  - Extension Pack for Java Versión 0.25.12
  - yUML (UML diagramming tool based on  the yUML syntax) - Versión 3.5.1
  - Marp for VS Code - Versión 2.6.0
- Git (https://git-scm.com)
- Maven Apache (https://maven.apache.org)
- Instalación del arquetipo Maven de Uniquindio crear nuevos proyectos para el curso (https://sara.uniquindio.edu.co/m2/m2.zip).
- Clonado el repositorio del curso en GitHub


---
<!-- OpenJDK -->
<style scoped>
.texto:after {
    content: '';
  }
</style>

# OpenJDK 17 (https://adoptium.net/es)

Ingrese al siguiente enlace y descargue la última versión de LTS (*Long Term Support*)

---
<!-- OpenJDK -->
<style scoped>
.texto:after {
    content: 'Ingrese al sitio: https://adoptium.net/es';
  }
</style>

![bg 88%](capturas/1.png)


---
<!-- OpenJDK -->
<style scoped>
.texto:after {
    content: 'Clic sobre "Última versión de LTS"';
  }
</style>

![bg 88%](capturas/2.png)

---
<!-- OpenJDK -->
<style scoped>
.texto:after {
    content: 'Esperar hasta que descargue';
  }
</style>

![bg 88%](capturas/3.png)


---
<!-- OpenJDK -->
<style scoped>
.texto:after {
    content: 'Esperar hasta que descargue';
  }
</style>

![bg 88%](capturas/4.png)

---

<!-- OpenJDK -->
<style scoped>
.texto:after {
    content: 'Ejecute el instalador';
  }
</style>

![bg 15%](capturas/9.png)

---

<!-- OpenJDK -->
<style scoped>
.texto:after {
    content: 'Siga el asistente de instalación OpenJDK 17';
  }
</style>

![bg 50%](capturas/10.png)

---

<!-- OpenJDK -->
<style scoped>
.texto:after {
    content: 'Siga el asistente de instalación OpenJDK 17';
  }
</style>

![bg 50%](capturas/11.png)

---

<!-- OpenJDK -->
<style scoped>
.texto:after {
    content: 'Siga el asistente de instalación OpenJDK 17';
  }
</style>

![bg 45%](capturas/12.png)

---

<!-- OpenJDK -->
<style scoped>
.texto:after {
    content: 'Siga el asistente de instalación OpenJDK 17';
  }
</style>

![bg 50%](capturas/13.png)

---

<!-- OpenJDK -->
<style scoped>
.texto:after {
    content: 'Siga el asistente de instalación OpenJDK 17';
  }
</style>

![bg 50%](capturas/14.png)

---

<!-- OpenJDK -->
<style scoped>
.texto:after {
    content: 'Siga el asistente de instalación OpenJDK 17';
  }
</style>

![bg 50%](capturas/15.png)

---

<!-- OpenJDK -->
<style scoped>
.texto:after {
    content: 'Siga el asistente de instalación OpenJDK 17';
  }
</style>

![bg 50%](capturas/16.png)

---

<!-- VSCode -->
<style scoped>
.texto:after {
    content: 'Ingrese al sitio: https://code.visualstudio.com/';
  }
</style>

# Visual Studio Code (https://code.visualstudio.com/)

Ingrese al siguiente enlace y descargue la última versión haciendo clic en "Download"

---


<!-- VSCode -->
<style scoped>
.texto:after {
    content: 'Clic en "Download for Windows"';
  }
</style>

![bg 88%](capturas/31.png)


---

<!-- VSCode -->
<style scoped>
.texto:after {
    content: 'Esperar que comience la descarga';
  }
</style>

![bg 88%](capturas/32.png)

---

<!-- VSCode -->
<style scoped>
.texto:after {
    content: 'Esperar que comience la descarga';
  }
</style>

![bg 40%](capturas/33.png)

---

<!-- VSCode -->
<style scoped>
.texto:after {
    content: 'Ejecute el instalador que descargó';
  }
</style>

![bg 15%](capturas/34.png)

---

<!-- VSCode -->
<style scoped>
.texto:after {
    content: 'Acepte el acuerdo y presione "Siguiente"';
  }
</style>

![bg 50%](capturas/35.png)

---

<!-- VSCode -->
<style scoped>
.texto:after {
    content: 'Siga el asistente de instalación';
  }
</style>

![bg 50%](capturas/36.png)

---

<!-- VSCode -->
<style scoped>
.texto:after {
    content: 'Siga el asistente de instalación';
  }
</style>

![bg 50%](capturas/37.png)

---

<!-- VSCode -->
<style scoped>
.texto:after {
    content: 'Siga el asistente de instalación';
  }
</style>

![bg 50%](capturas/38.png)

---

<!-- VSCode -->
<style scoped>
.texto:after {
    content: 'Siga el asistente de instalación';
  }
</style>

![bg 50%](capturas/39.png)


---

<!-- VSCode -->
<style scoped>
.texto:after {
    content: 'Espere que la instalación termine';
  }
</style>

![bg 50%](capturas/40.png)

---

<!-- VSCode -->
<style scoped>
.texto:after {
    content: 'Espere que la instalación termine';
  }
</style>

![bg 50%](capturas/41.png)

---

<!-- VSCode -->
<style scoped>
.texto:after {
    content: 'Espere que la instalación termine';
  }
</style>

![bg 50%](capturas/42.png)

---

<!-- VSCode -->
<style scoped>
.texto:after {
    content: 'Ejecute la aplicación "Visual Studio Code"';
  }
</style>

![bg 70%](capturas/43.png)

---

<!-- VSCode -->
<style scoped>
.texto:after {
    content: '';
  }
</style>

# Instalando la extensión "**Extension Pack for Java**"

Esta extensión incluye un conjunto de extensiones de uso profesional a nivel de desarrollo en **Java**

  - Language Support for Java(TM)
  - Debugger for Java
  - Test Runner for Java
  - Maven for Java
  - Project Manager for Java
  - IntelliCode

---

<!-- VSCode: Extension Pack for Java -->
<style scoped>
.texto:after {
    content: 'Clic en extensiones (quinto icono del lado izquierdo) e instalar "Extension Pack for Java"';
  }
</style>

![bg 70%](capturas/45.png)

---

<!-- VSCode -->
<style scoped>
.texto:after {
    content: '';
  }
</style>

# Instalando la extensión "**yUML**"

Este extensión **yUML** (*UML diagramming tool based on the yUML syntax*) permite crear diagramas de **UML** (*Unified Modeling Language*) necesarios para modelar una solución antes de llegar al código.


---

<!-- VSCode:yUML -->
<style scoped>
.texto:after {
    content: 'Clic en extensiones (quinto icono del lado izquierdo) e instalar "yUML"';
  }
</style>

![bg 70%](capturas/46.png)

---

<!-- VSCode -->
<style scoped>
.texto:after {
    content: '';
  }
</style>

# Instalando la extensión "**Marp for VS Code**"

Este extensión **Marp for VS Code** permite crear presentaciones directamente en **Visual Studio Code** usando un lenguaje llamado **Markdown**.

---

<!-- VSCode: Marp -->
<style scoped>
.texto:after {
    content: 'Clic en extensiones (quinto icono del lado izquierdo) e instalar "Marp for VS Code"';
  }
</style>

![bg 70%](capturas/47.png)

---

<!-- VSCode: Marp -->
<style scoped>
.texto:after {
    content: 'Clic derecho en la extensión "Marp" y seleccionar "Extension Settings"';
  }
</style>

![bg 70%](capturas/50.png)

---

<!-- VSCode: Marp -->
<style scoped>
.texto:after {
    content: 'Active "Markdown > Marp: Enable HTML';
  }
</style>

![bg 70%](capturas/51.png)


---

<!-- VSCode -->
<style scoped>
.texto:after {
    content: '';
  }
</style>

# Al final debe terminar con 10 extensiones instaladas

Verifique que las 10 extensiones si están instaladas en su **Visual Studio Code**.

Opcionalmente puede instalar las extensiones:
- **Spanish - Code Spell Checker** (*Spanish Add-On for Code Spell Checker*) para verificar la escritura de palabras en español. 
- **vscode-pdf** (*Display pdf file in VSCode*) para poder ver los archivo **PDF** directamente en **Visual Studio Code**.
- **Git Graph** (*Git Graph extension for Visual Studio Code*) extensión para ver las ramas de Git.
---

<!-- VSCode: Extensiones -->
<style scoped>
.texto:after {
    content: 'Verifique las extensiones instaladas';
  }
</style>

![bg 95%](capturas/48.png)
![bg 95%](capturas/49.png)

---

<!-- VSCode -->
<style scoped>
.texto:after {
    content: '';
  }
</style>

# Instalando la herramienta "Git"

**Git** es una herramienta para el control de versiones tanto a nivel local como en la nube usando servios como **github** o **gitlab**. 

Esto permite llevar un control de un proyecto a nivel profesional, especialmente útil cuando se tiene un equipo de programadores.


---

<!-- VSCode: Git -->
<style scoped>
.texto:after {
    content: 'Clic en "Source Control" (tercer icono del lado izquierdo) y clic "Download Git for Windows"';
  }
</style>

![bg 70%](capturas/53.png)

---

<!-- VSCode: Git -->
<style scoped>
.texto:after {
    content: 'Clic en "Open"para abrir la página de descarga';
  }
</style>

![bg 70%](capturas/54.png)

---

<!-- VSCode: Git -->
<style scoped>
.texto:after {
    content: 'Presione "Click here to download"';
  }
</style>

![bg 88%](capturas/55.png)

---

<!-- VSCode: Git -->
<style scoped>
.texto:after {
    content: 'Esperar que descargue';
  }
</style>

![bg 45%](capturas/56.png)

---

<!-- VSCode: Git -->
<style scoped>
.texto:after {
    content: 'Ejecute la aplicación descargada';
  }
</style>

![bg 15%](capturas/57.png)

---

<!-- VSCode: Git -->
<style scoped>
.texto:after {
    content: 'Siga el asistente de instalación';
  }
</style>

![bg 49%](capturas/58.png)

---

<!-- VSCode: Git -->
<style scoped>
.texto:after {
    content: 'Siga el asistente de instalación';
  }
</style>

![bg 49%](capturas/59.png)


---

<!-- VSCode: Git -->
<style scoped>
.texto:after {
    content: 'Siga el asistente de instalación';
  }
</style>

![bg 49%](capturas/60.png)


---

<!-- VSCode: Git -->
<style scoped>
.texto:after {
    content: 'Siga el asistente de instalación';
  }
</style>

![bg 49%](capturas/61.png)


---

<!-- VSCode: Git -->
<style scoped>
.texto:after {
    content: 'Siga el asistente de instalación';
  }
</style>

![bg 49%](capturas/62.png)

---

<!-- VSCode: Git -->
<style scoped>
.texto:after {
    content: 'Siga el asistente de instalación';
  }
</style>

![bg 49%](capturas/63.png)

---

<!-- VSCode: Git -->
<style scoped>
.texto:after {
    content: 'Siga el asistente de instalación';
  }
</style>

![bg 49%](capturas/64.png)

---

<!-- VSCode: Git -->
<style scoped>
.texto:after {
    content: 'Siga el asistente de instalación';
  }
</style>

![bg 49%](capturas/65.png)

---

<!-- VSCode: Git -->
<style scoped>
.texto:after {
    content: 'Siga el asistente de instalación';
  }
</style>

![bg 49%](capturas/66.png)

---

<!-- VSCode: Git -->
<style scoped>
.texto:after {
    content: 'Siga el asistente de instalación';
  }
</style>

![bg 49%](capturas/67.png)

---

<!-- VSCode: Git -->
<style scoped>
.texto:after {
    content: 'Siga el asistente de instalación';
  }
</style>

![bg 49%](capturas/68.png)

---

<!-- VSCode: Git -->
<style scoped>
.texto:after {
    content: 'Siga el asistente de instalación';
  }
</style>

![bg 49%](capturas/69.png)

---

<!-- VSCode: Git -->
<style scoped>
.texto:after {
    content: 'Siga el asistente de instalación';
  }
</style>

![bg 49%](capturas/70.png)

---

<!-- VSCode: Git -->
<style scoped>
.texto:after {
    content: 'Siga el asistente de instalación';
  }
</style>

![bg 49%](capturas/71.png)


---

<!-- VSCode: Git -->
<style scoped>
.texto:after {
    content: 'Siga el asistente de instalación';
  }
</style>

![bg 49%](capturas/72.png)


---

<!-- VSCode: Git -->
<style scoped>
.texto:after {
    content: 'Espere hasta que termine la instalación';
  }
</style>

![bg 49%](capturas/73.png)


---

<!-- VSCode: Git -->
<style scoped>
.texto:after {
    content: 'Termine la instalación';
  }
</style>

![bg 49%](capturas/74.png)


---

<!-- VSCode: Git -->
<style scoped>
.texto:after {
    content: 'Cierre la página de "Release Notes"';
  }
</style>

![bg 49%](capturas/75.png)


---

<!-- VSCode: Git -->
<style scoped>
.texto:after {
    content: 'Paso en la instalación de Git';
  }
</style>

# Configuración básica


En una terminal del sistema o del mismo Visual Studio Code ejecute los comandos:

- Este comando registra su nombre
  ```shell
  $ git config --global user.name "escriba aquí su nombre"
  ```

- Este comando registra su correo electrónico (email)
  ```shell
  $ git config --global user.email escriba_aqui_su_correo
  ```


---

<!-- VSCode -->
<style scoped>
.texto:after {
    content: '';
  }
</style>

# La instalación de **Maven**

**Maven** es una herramienta para gestionar dependencias y es muy utilizada en la industria, pero no la utilizaremos directamente en el curso.

---
<!-- MAVEN -->
<style scoped>
.texto:after {
    content: 'Ingrese al sitio: https://maven.apache.org/';
  }
</style>

# Maven (https://maven.apache.org/)

Ingrese al siguiente enlace y descargue la última versión haciendo clic en "Download"

---

<!-- MAVEN -->
<style scoped>
.texto:after {
    content: 'Esperar hasta que descargue';
  }
</style>

![bg 88%](capturas/5.png)

---

<!-- MAVEN -->
<style scoped>
.texto:after {
    content: 'Ir a la sección (Files)';
  }
</style>

![bg 88%](capturas/6.png)

---

<!-- MAVEN -->
<style scoped>
.texto:after {
    content: 'Descargar: apache-maven-3.9.4-bin.zip';
  }
</style>

![bg 88%](capturas/7.png)

---

<!-- MAVEN -->
<style scoped>
.texto:after {
    content: 'Esperar la descarga';
  }
</style>

![bg 88%](capturas/8.png)

---

<!-- MAVEN -->
<style scoped>
.texto:after {
    content: 'Clic derecho descargado y  "Extraer todo..."';
  }
</style>


![bg 20%](capturas/17.png)
![bg 40%](capturas/18.png)


---

<!-- MAVEN -->
<style scoped>
.texto:after {
    content: 'Cambien la carpeta a "C:\\Program Files"';
  }
</style>

![bg 70%](capturas/20.png)

---

<!-- MAVEN -->
<style scoped>
.texto:after {
    content: '"Continuar" para dar permiso para descomprimir';
  }
</style>

![bg 60%](capturas/21.png)

---

<!-- MAVEN -->
<style scoped>
.texto:after {
    content: 'Esperar que se descomprima';
  }
</style>

![bg 50%](capturas/22.png)

---

<!-- MAVEN -->
<style scoped>
.texto:after {
    content: 'Buscar "Editar las variables de entorno"';
  }
</style>

![bg 40%](capturas/23.png)

---

<!-- MAVEN -->
<style scoped>
.texto:after {
    content: 'Clic en "Variables de entorno..."';
  }
</style>

![bg 40%](capturas/24.png)



---

<!-- MAVEN -->
<style scoped>
.texto:after {
    content: 'Editar "Path" de variables del sistema';
  }
</style>

![bg 40%](capturas/25.png)

---

<!-- MAVEN -->
<style scoped>
.texto:after {
    content: 'Seleccione "Nuevo"';
  }
</style>

![bg 50%](capturas/29.png)


---

<!-- MAVEN -->
<style scoped>
.texto:after {
    content: 'Seleccione la carpeta "bin"de Maven';
  }
</style>

![bg 30%](capturas/27.png)

---

<!-- MAVEN -->
<style scoped>
.texto:after {
    content: 'Verifique que "apache-maven" esté en la lista';
  }
</style>

![bg 50%](capturas/30.png)

---

<!-- VSCode -->
<style scoped>
.texto:after {
    content: '';
  }
</style>

# La instalación del **Arquetipo Maven de Uniquindio**

El arquetipo Maven de Uniquindio (**arquetipo-poo-uq**) es una plantilla lista para crear nuevo proyecto para este curso de programación orientada a objetos.


---
<!-- Arquetipo MAVEN -->
<style scoped>
.texto:after {
    content: 'Descargue el archivo: https://sara.uniquindio.edu.co/m2/m2.zip';
  }
</style>

![bg 52%](capturas/109.png)

<div style="position: absolute; left: 60%; top:50%; ">
<a href= "https://sara.uniquindio.edu.co/m2/"> https://sara.uniquindio.edu.co/m2/</a>
</div>

---

<!-- Arquetipo MAVEN -->
<style scoped>
.texto:after {
    content: 'Descomprima el archivo m2.zip';
  }
</style>

- Descomprima el archivo **m2.zip** en su directorio **HOME**.

  - **Windows**: *C:\Usuarios\SuUsuario*

  - **Linux**: */home/SuUsuario*

  - **MacOs**: */Users/SuUsuario*

  De ser necesario, sobreescriba los archivos.

--- 
<!-- Arquetipo MAVEN -->
<style scoped>
.texto:after {
    content: 'Por ejemplo en MacOS: /Users/jugutier';
  }
</style>

![bg 66%](capturas/92.png)


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
    content: 'pom.xml';
  }
</style>

![bg 70%](capturas/106.png)

---

<!-- Arquetipo MAVEN -->
<style scoped>
.texto:after {
    content: 'pom.xml';
  }
</style>

![bg 70%](capturas/107.png)

---

<!-- Arquetipo MAVEN -->
<style scoped>
.texto:after {
    content: 'Ejecute la prueba generada';
  }
</style>

![bg 70%](capturas/108.png)

---

<!-- Arquetipo MAVEN -->
<style scoped>
.texto:after {
    content: 'Cierre la carpeta de trabajo';
  }
</style>

![bg 25%](capturas/110.png)

---

<!-- VSCode -->
<style scoped>
.texto:after {
    content: '';
  }
</style>

# Clonado el repositorio del curso en GitHub

Todo el material del curso, desarrollado paso a paso se encuentra de forma pública en el repositorio de **GitHub** https://github.com/grid-uq/poo 

Allí encontrará desde esta presentación (creada enteramente con **Marp**), así como el análisis, el diseño, la codificación y las pruebas de los diferentes requisitos por cada ejercicio desarrollado en el curso.

Lo que se busca es ir explicando los conceptos que se requieren en el momento justo de tal forma que se puedan resolver los problemas propuestos con sus diferentes requisitos.

---

<!-- VSCode: Repositorio -->
<style scoped>
.texto:after {
    content: 'Clic en "Clone Git Repository"';
  }
</style>

![bg 88%](capturas/76.png)

---

<!-- VSCode: Repositorio -->
<style scoped>
.texto:after {
    content: 'Escriba "https://github.com/grid-uq/poo"';
  }
</style>

![bg 75%](capturas/77.png)

---

<!-- VSCode: Repositorio -->
<style scoped>
.texto:after {
    content: 'Cree y seleccione una carpeta de trabajo';
  }
</style>

![bg 50%](capturas/78.png)

---

<!-- VSCode: Repositorio -->
<style scoped>
.texto:after {
    content: 'Haga clic en "Open"';
  }
</style>

![bg 95%](capturas/79.png)

---

<!-- VSCode: Repositorio -->
<style scoped>
.texto:after {
    content: 'Haga clic en "Yes" para indicar que son autores de confianza';
  }
</style>

![bg 50%](capturas/80.png)

---

<!-- VSCode: Repositorio -->
<style scoped>
.texto:after {
    content: 'Confirme el resultado final';
  }
</style>

![bg 70%](capturas/81.png)

---

<!-- VSCode: Repositorio -->
<style scoped>
.texto:after {
    content: 'Clic en "main" parte inferior izquierda';
  }
</style>

![bg 70%](capturas/82.png)

---

<!-- VSCode: Repositorio -->
<style scoped>
.texto:after {
    content: 'Seleccione "origin/torneo/RQ01-01';
  }
</style>

![bg 70%](capturas/83.png)

---

<!-- VSCode: Repositorio -->
<style scoped>
.texto:after {
    content: 'Explore "torneo-deportivo" en el lado izquierdo';
  }
</style>

![bg 70%](capturas/84.png)


---

<!-- VSCode: Repositorio -->
<style scoped>
.texto:after {
    content: 'Abra "presentacion.md" y el icono "Open Preview" (dos rectangulos con una lupa)';
  }
</style>

![bg 70%](capturas/85.png)

---

<!-- VSCode: Repositorio -->
<style scoped>
.texto:after {
    content: 'Clic en el icono de "Show Quick of Marp al lado de "Open Preview" para generar PDF';
  }
</style>

![bg 70%](capturas/86.png)

---

<!-- VSCode: Repositorio -->
<style scoped>
.texto:after {
    content: 'Para generar un PDF requiere tener instalado el navegador Chrome';
  }
</style>

![bg 70%](capturas/87.png)

---

<!-- VSCode: Repositorio -->
<style scoped>
.texto:after {
    content: 'Abra "diagrama 00.yuml"';
  }
</style>

![bg 70%](capturas/88.png)


---

<!-- VSCode: Repositorio -->
<style scoped>
.texto:after {
    content: 'Abra "TorneoTest.java"';
  }
</style>

![bg 70%](capturas/90.png)

---

<!-- VSCode: Repositorio -->
<style scoped>
.texto:after {
    content: 'Cierre la carpeta "Close Folder" para terminar';
  }
</style>

![bg 70%](capturas/91.png)

---
<!-- 
_header: ''
_footer: '' 
_paginate: false
_backgroundImage: url('imagenes/gracias.png')
-->
