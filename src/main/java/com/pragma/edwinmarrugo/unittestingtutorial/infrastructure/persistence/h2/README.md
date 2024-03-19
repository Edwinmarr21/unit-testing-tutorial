# Capa de Persistencia

Ahora vamos a desarrollar la capa de persistencia.

Primero, creamos la entidad:

![img.png](../../../../../../../../resources/persistenceImages/entidadBd.png) 

Ahora, creamos el repositorio de JPA: 

![img.png](../../../../../../../../resources/persistenceImages/repository.png)  

Configuramos la base de datos:

![img.png](../../../../../../../../resources/persistenceImages/properties.png)  

Creamos una clase de configuración: 

![img.png](../../../../../../../../resources/persistenceImages/DbConfig.png)  

Y ahora sí, a desarrollar la lógica de la persistencia que para este caso, iré más rápido:

Extendemos del puerto que expusimos en el dominio y retornamos algo para empezar:

![img.png](../../../../../../../../resources/persistenceImages/CreacionDeAdaptador.png)

Ahora creamos el test que sabemos fallará:

![img.png](../../../../../../../../resources/persistenceImages/deberiaInsertarTecnologiaTest.png)  

Y ahora lo hacemos pasar:

![img.png](../../../../../../../../resources/persistenceImages/implementacionMetodoPersistencia.png)

![img.png](../../../../../../../../resources/persistenceImages/passedFirstTest.png)

Hagamos los demás tests:

![img.png](../../../../../../../../resources/persistenceImages/moreTests.png)

Es claro que van a fallar, por lo tanto, sabemos que al correrlos el color será "red".

Ahora refactorizamos y pasan bien:

![img.png](../../../../../../../../resources/persistenceImages/refactoredPort.png)

![img.png](../../../../../../../../resources/persistenceImages/TheOtherTest.png) 

![img.png](../../../../../../../../resources/persistenceImages/TheRepeatedTest.png) 

## Terminamos la persistencia.

