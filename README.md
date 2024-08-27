# Cabinas Telefónicas

Este proyecto simula un sistema de cabinas telefónicas donde los usuarios pueden gestionar cabinas, realizar llamadas y obtener informes detallados de las llamadas realizadas. Está implementado en Kotlin.

## Características

- **Crear Cabina**: Permite al usuario agregar una nueva cabina al sistema.
- **Listar Cabinas**: Muestra un listado de las cabinas creadas y permite acceder a opciones para realizar llamadas, mostrar información detallada o formatear la información de la cabina.
- **Realizar Llamadas**: Dentro de una cabina, el usuario puede realizar llamadas locales, de larga distancia o a celulares.
- **Informe de Cabinas**: Genera un informe detallado de todas las cabinas, incluyendo el número de llamadas, el costo total y el costo promedio por minuto.
- **Borrar Cabina**: Elimina una cabina seleccionada del sistema.

## Estructura del Código

El código está organizado de la siguiente manera:

- **listaCabinas**: Una lista mutable que almacena los nombres de las cabinas.
- **preciosCabinas**: Una lista mutable que almacena los valores de las llamadas realizadas en cada cabina.
- **llamadasCabinas**: Una lista mutable que almacena la cantidad de llamadas realizadas en cada cabina.

## Funcionalidades Principales

### 1. Crear Cabina
Permite al usuario ingresar el nombre de una nueva cabina que se agregará a `listaCabinas`, y se inicializan sus contadores de llamadas y precios en `llamadasCabinas` y `preciosCabinas` respectivamente.

### 2. Listar Cabinas
Muestra un listado de todas las cabinas creadas. El usuario puede seleccionar una cabina para realizar llamadas, mostrar información o formatear la información de la cabina.

### 3. Realizar Llamadas
Dentro de una cabina, el usuario puede elegir entre:
- **Llamada Local**: Costo de $50 por minuto.
- **Llamada Larga Distancia**: Costo de $350 por minuto.
- **Llamada Celular**: Costo de $150 por minuto.

### 4. Informe de Cabinas
Genera un informe con el total de llamadas, minutos, y costo promedio por minuto de todas las cabinas registradas.

### 5. Borrar Cabina
Permite eliminar una cabina seleccionada de `listaCabinas`, `preciosCabinas`, y `llamadasCabinas`.

## Pruebas Unitarias

- Se crearon mediante el uso de inteligencia artificial y se incluyeron dentro de una nueva Clase
- Se pasaron todas las pruebas unitarias 

![image](https://github.com/user-attachments/assets/34c211b1-46c0-4be4-a30f-562d7909d516)


## Ejecución del Programa

1. Se debe crear una cabina asignándole un nombre
2. Se debe listar las cabinas y entrar mediante el menú a la cabina seleccionada
3. Se realiza las llamadas necesarias y se cobra
4. Se revisa mediante el informe los valores guardados de la cabina
5. (opcional) se formatea la cabina o se elimina
6. (opcional) se revisa el informe de cabinas  

## Manejo de Excepciones

- Se capturan las excepciones de entrada inválida utilizando bloques `try-catch`.
- Los mensajes de error se muestran para ayudar al usuario a ingresar datos válidos.
- Se comprueba mediante lógica los valores para que concuerden con los límites establecidos.

## Mejoras o Adiciones

- Se podrian implementar que el tiempo dependa del tiempo de espera del usuario
- Se podria optimizar el guardado de las variables mediante un Data Class para no usar varias listas
- Se podria reducir el uso de lineas de codigo mediante funciones, para realizar la muesta de los datos y el cálculo de las variables.



