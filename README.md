# Proyecto Programación

Este proyecto consiste en la implementación de dos operaciones CRUD (Crear, Leer, Actualizar, Borrar) utilizando Spring Boot. Las entidades principales son "Policía" y "Redada". A continuación se detallan los requisitos y funcionalidades de cada CRUD.

## CRUD de Policias

El CRUD de Policias permite realizar las siguientes operaciones:

- Agregar un policía: Permite agregar un nuevo policía a la base de datos. Los datos requeridos son:
  - Nombre (string): Nombre del policía.
  - Edad (int): Edad del policía.
  - Fecha de entrada a la institución (date): Fecha en que el policía ingresó a la institución.
  - Rango (string): Rango del policía.
  - Número de redadas en las que ha participado (int): Cantidad de redadas en las que el policía ha participado.

- Actualizar un policía: Permite actualizar los datos de un policía existente en la base de datos. Se requiere proporcionar el ID del policía a actualizar, así como todos los nuevos valores para los campos mencionados anteriormente.

- Mostrar lista de policías: Muestra todos los policías registrados en la base de datos.

- Borrar un policía: Permite eliminar un policía de la base de datos. Se requiere proporcionar el ID del policía a borrar.

## CRUD de Redadas

El CRUD de Redadas permite realizar las siguientes operaciones:

- Agregar una redada: Permite agregar una nueva redada a la base de datos. Los datos requeridos son:
  - Fecha de ejecución del operativo (string): Fecha en que se ejecutó el operativo.
  - Hora de inicio (string): Hora de inicio de la redada.
  - Hora de finalización (string): Hora de finalización de la redada.
  - Cantidad de capturados (int): Número de personas capturadas durante la redada.
  - Tipo de narcótico (string): Tipo de narcótico incautado durante la redada.
  - Peso del narcótico (double): Peso del narcótico incautado durante la redada.
  - Lista de policías que participaron (ArrayList[string]): Nombres de los policías que participaron en la redada.

- Actualizar una redada: Permite actualizar los datos de una redada existente en la base de datos. Se requiere proporcionar el ID de la redada a actualizar, así como todos los nuevos valores para los campos mencionados anteriormente.

- Mostrar lista de redadas: Muestra todas las redadas registradas en la base de datos.

- Borrar una redada: Permite eliminar una redada de la base de datos. Se requiere proporcionar el ID de la redada a borrar.

## Tecnologías utilizadas

- Spring Boot
- MySQL
## Licencia

Este proyecto no se encuentra bajo ninguna licencia.

## Autor

-Jose Sabogal
