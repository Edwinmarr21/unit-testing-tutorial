# Modelo de Dominio

En el modelo de dominio se crearán las clases que representan el negocio. En nuestro caso serían las tecnlogías:

Sabemos que una tecnología estará conformada por:

- id: no especifica, por tanto, considerémoslo como ingresado por el usuario.
- nombre: debe se *único*, tener máximo *50 caracteres*, obligatorio.
- descripcion: debe tener máximo *90 caracteres*, obligatorio.


La capa del modelo de dominio no se testea, dado que no tiene una lógica relevante aparte de setters, getters, constructores,
builders, etc...

Nota: si se considera que una clase de dominio debe tener una lógica aparte de la predeterminada, debe testearse.