
# Laboratorio I-2024
## <sup>Asignatura: Patrones de Software y Programación </sup> <br><sup>Profesor: Daniel San Martín</sup> <br> <sup> Nombre Estudiante:</sup>
<hr>
Dado el enunciado a continuación, implemente el patrón de diseño que usted considere necesario
para dar solución al requerimiento. Además, explique porqué escogió el patrón, cual es su característica
donde se clasifica el patrón y porqué da solución a la problemática.
<hr>

# Enunciado

Una empresa de desarrollo de software ha sido contratada para implementar una 
solución que gestione el acceso a una biblioteca digital de recursos multimedia y sus
usuarios. La bilioteca incluye imágenes, vídeos y documentos donde algunos podrían encontrarse protegidos.

El sistema debe permitir buscar usuarios en distintas fuentes de datos. Además, se debe controlar 
el acceso a los archivos multimedia que están protegidos. Solo usuarios con los permisos adecuados deben 
poder abrir y visualizar los archivos protegidos.

Su tarea es diseñar una solución que permita lo siguiente:

 * Buscar un usuario en la base de datos, si este no existe, el sistema debe buscar 
en el archivo *externo.csv* de manera transparente. La clase *Util* contiene el método para 
buscar usuarios en archivos csv.
 * Controlar el acceso a los archivos protegidos para asegurar que solo usuarios con 
permisos válidos puedan visualizarlos. El sistema debe mostrar mensajes que indicando si existen 
los permisos o no, de acuerdo al archivo asignado por defecto.

## Guías

1. Utilize el paquete interfaz para implementar las interfaces que estime conveniente.
2. Puede modificar todo el código para lograr su propósito si estima conveniente. 

<hr>

## Explicación
Selección del Patrón:

Implemente el patrón Proxy. Este patrón es ideal cuando se quiere controlar el acceso a un objeto, este hace como un intermediario que regula las operaciones que pueden realizarse sobre el objeto real. 
El Proxy funciona como una capa extra que protege el acceso directo, lo que es muy útil cuando se necesita verificar antes de permitir acciones, como en este caso, donde los permisos de usuario determinan si pueden acceder a archivos protegidos.

El patrón Proxy es de tipo estructural y se utiliza para:

    -Controlar el acceso a un objeto (archivos multimedia), permitiendo o no acciones según reglas específicas, como los permisos de los usuarios.
    -Hacer una interfaz igual al objeto real, lo que significa que el usuario no sabe si está interactuando con el objeto real o con un proxy. Esto asegura que el sistema opere de forma transparente, sin que el usuario vea las verificaciones de permisos.
    -Tambien puede retrasar la creación o el acceso a recursos costosos hasta que realmente se necesiten, lo que puede generar optimizaciones adicionales si fuera necesario.

Clasificación del Patrón:

El patrón Proxy se clasifica como un patrón estructural. Los patrones estructurales tienen como propósito organizar de manera flexible las relaciones entre los objetos, permitiendo que la implementación de un objeto esté desacoplada de su uso dentro del sistema. Esto es útil cuando se busca que la lógica de acceso y control esté separada de la funcionalidad central de los objetos multimedia.

Problemática:

-Búsqueda de usuarios en múltiples fuentes de datos: (problemas)
    *El sistema debe poder buscar usuarios tanto en la base de datos como en un archivo externo (externo.csv), de manera transparente para el usuario.
    *Control de acceso a archivos protegidos: Solo los usuarios con los permisos adecuados pueden acceder y visualizar archivos protegidos.

Solucion a problematica:

-Acceso controlado a archivos: 
    *El Proxy se encarga de verificar que solo los usuarios con los permisos correctos puedan acceder y visualizar los archivos protegidos. Antes de permitir el acceso al archivo real, el Proxy revisa los permisos del usuario. 
    Si no tiene los permisos necesarios, el acceso se denega de manera controlada, mostrando un mensaje de porque se bloqueo.

-Búsqueda en distintas fuentes de datos: 
    *Aunque este no es el enfoque principal del patrón Proxy, tambien gestiona de forma transparente la búsqueda de usuarios en varias fuentes de datos. 
    Primero se intenta localizar al usuario en la base de datos, y si no se encuentra, se busca en el archivo externo (externo.csv). Esto garantiza que la búsqueda sea eficiente y automática, sin que el usuario  perciba ninguna diferencia entre las dos fuentes.

<hr>