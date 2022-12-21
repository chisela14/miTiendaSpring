# miTiendaSpring
Vamos a realizar una tienda con Spring, para ello seguiremos con la misma base de datos del ejercicio anterior, pero con algunas modificaciones. 

- En primero lugar la aplicación debe llamarse miTiendaSpringPrimerApellidoNombre.
- La base de datos que creeemos debe llamarse miTiendaSpringPrimerApellidoNombre.
- El usuario y contraseña que tendrá permiso para usar las tablas de esa base de datos será primerApellidoNombre, con la misma contraseña.
- La base de datos deberá tener las siguientes tablas:
    - Una tabla usuario con los siguientes campos: usuario (que será primary key), contraseña (cifrada), nombre, correo electrónico y un campo que indique       si el usuario es administrador o no.
    - Una tabla de pedidos con número que será asignado de forma automática y que será la primary key, un campo fecha, un campo iva y una relación M:N con       el campo de artículos (el que tuviera la otra vez).
    - Una tabla de árticulos y de categorías de la otra vez, asegurándome que tengo el campo stock.
- Para este primer sprint se deberán crear los formularios correspondientes a las siguientes rutas (en azul y entre parétesis es la explicación):
    - /usuario/add (deberá añadir un usuario pidiéndo al usuario que escriba dos veces la contraseña y sin pedirle el valor para administrador o no, se           deberá crear un usuario normal).
    - /usuario/delete?id=usuario (borrar un usuario).
    - /usuario/update?id=usuario (modificar un usuario, sin posibilidad de cambiar los campos usuario ni el campo de administrador o no)
    - /usuario/admin?id=usuario (modiicar el campo admin del usuario)
    - /usuario/list (listar todos los usuarios)
    - /artiiculo/add (deberá añadir un nuevo artículo).
    - /articulo/delete?id=articulo (borrar un artículo).
    - /articulo/update?id=articulo (modificar un artículo, sin posibilidad de cambiar la primary key)
    - /articulo/list (listar todos los articulos)
    - /categoria/add (deberá añadir una categoría).
    - /categoria/delete?id=categoria (borrar una categoría).
    - /categoria/update?id=categoria (modificar una categoría, sin posibilidad de cambiar la primary key)
    - /categoria/list (listar todos las categorías)

Debes entregar un repositorio (ten en cuenta que spring crea un fichero .gitignore que ignora el .classpaht y el .profject por lo que la primera vez tendrá que hacer que estos ficheros se suban).
