Práctica cuatro para la asignatura de Digitalización que consiste en desarrollar una gesti´on de citas para un taller mecánico.
Se ha utilizado Git y GitHub para el desarrollo del proyecto.


Estructura de Ramas y Flujo de Trabajo

El desarrollo se ha estructurado en las siguientes ramas de Git:
main: Rama principal de producción donde reside la versión estable del proyecto.
feature/registro-cita: (Desarrollada por Julen) Implementación de la captura de datos del vehículo y validación inicial de fechas.
feature/calculo-coste: (Desarrollada por Isabella) Algoritmo de cálculo de coste y descuentos según matrícula.
feature/formato-fechas: (Desarrollada por Alazne) Función auxiliar para el formateo personalizado de fechas en español.
bugfix/limpieza-matricula: (Desarrollada por Omar) Corrección de errores (hotfix) para sanear la entrada de matrículas eliminando espacios en blanco no deseados.


Fases del Desarrollo

Fase 1: Configuración Inicial
Creación del repositorio taller-citas-daw por parte de Julen.
Estructura inicial del menú en Main.java e inclusión del .gitignore y README.md.
Configuración del tablero del proyecto (GitHub Projects) y creación de Issues.

Fase 2: Clonación del Repositorio
Isabella, Alazne y Omar aceptan la invitación e integran el proyecto localmente.

Fase 3: Desarrollo de Features
Trabajo independiente en ramas locales y seguimiento mediante el tablero de proyecto.

Fase 4: Pull Requests y Resolución de Conflictos
Integración exitosa de feature/formato-fechas y feature/registro-cita.
Detección y resolución en equipo del conflicto de fusión en Main.java al intentar integrar feature/calculo-coste.

Fase 5: Hotfix y Versionado
Creación de la rama bugfix/limpieza-matricula por Omar para corregir la validación de matrículas.
Fusión final a main y etiquetado de la versión estable v1.0

Requisitos e Instalación
Java JDK: 11 o superior.
IDE: IntelliJ IDEA / Eclipse / NetBeans.
Control de versiones: Git.

Versión actual: v1.0
