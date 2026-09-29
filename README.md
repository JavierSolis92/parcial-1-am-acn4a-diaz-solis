# INFORME - PARCIAL 1

**Materia:** Aplicaciones Móviles  
**Docente:** Sergio Medina  
**Comisión:** ACN4A  
**Integrantes:**
* Díaz Fabrizio
* Solis Javier

**Repositorio GitHub:**  
https://github.com/JavierSolis92/parcial-1-am-acn4a-diaz-solis

---

## Descripción de la Aplicación

El proyecto es una aplicación móvil (MVP) diseñada para la gestión y organización de rutinas diarias de gimnasio.

Permite al usuario interactuar de manera dinámica con la selección de ejercicios, armar una lista personalizada en tiempo real y llevar el control visual del progreso durante el entrenamiento mediante cambios de estado en cada tarjeta de ejercicio.

---

## Flujo de Uso

1. **Inicio y Selección:** Al ingresar a la aplicación, el usuario visualiza el título principal y un selector de ejercicios (`Spinner`) con opciones realistas de entrenamiento.
2. **Incorporación a la Rutina:** El usuario selecciona el ejercicio deseado y presiona el botón **"Agregar a la Rutina"**.
3. **Generación Dinámica de Vista:** La aplicación infla un layout dinámico (`CardView`) y lo agrega automáticamente dentro de un contenedor desplazable (`ScrollView`).
4. **Interacción con la Tarjeta (Control de Estado):**
    * **Botón Listo:** Tacha el nombre del ejercicio, cambia el fondo de la tarjeta a color verde indicando que el ejercicio fue completado y deshabilita los controles de acción.
    * **Botón Saltar:** Reduce la opacidad de la tarjeta al 50% (`alpha 0.5`) para señalar que el ejercicio fue omitido.
    * **Botón Eliminar:** Remueve la tarjeta del listado principal y dispara una notificación contextual (`Toast`).

---

## Arquitectura y Componentes de Interfaz

### Layouts e Interfaz XML

* **`activity_main.xml`:**
    * **`ConstraintLayout`:** Contenedor raíz que organiza los márgenes generales y la estructura de pantalla.
    * **`LinearLayout`:** Agrupa el formulario de selección (`Spinner` y `Button`).
    * **`ScrollView`:** Permite el desplazamiento vertical dinámico al acumular múltiples tarjetas de ejercicios.

* **`item_ejercicio.xml`:**
    * **`CardView`:** Componente modular con bordes redondeados y elevación que encapsula la tarjeta de cada ejercicio.
    * **`ImageView`:** Visualiza la imagen representativa del ejercicio seleccionado.
    * **`TextView`:** Despliega el nombre y las series/repeticiones.
    * **Botones de Acción:** `btnListo`, `btnSaltar` y `btnEliminar`.

### Modularización de Recursos (Agregados de Valor)

* **`strings.xml`:** Todos los textos de la interfaz extraídos para evitar valores *hardcodeados*.
* **`colors.xml`:** Paleta de colores definida para los estados visuales (Completado, Saltar, Eliminar).
* **`dimens.xml`:** Alturas, márgenes y tamaños de texto estandarizados.

---

## Capturas / Mockups de Pantalla

* **Pantalla Principal (Selección de ejercicio):** *(Ver captura adjunta en el informe PDF)*
* **Iteración Dinámica (Tarjetas agregadas y modificadas):** *(Ver captura adjunta en el informe PDF)*