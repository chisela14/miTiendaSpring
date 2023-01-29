# miTiendaSpring
Vamos a realizar una tienda con Spring, para ello seguiremos con la misma base de datos del ejercicio anterior, pero con algunas modificaciones. Debes entregar un repositorio (ten en cuenta que spring crea un fichero .gitignore que ignora el .classpaht y el .profject por lo que la primera vez tendrá que hacer que estos ficheros se suban). 

- En primero lugar la aplicación debe llamarse miTiendaSpringPrimerApellidoNombre.
- La base de datos que creeemos debe llamarse miTiendaSpringPrimerApellidoNombre.
- El usuario y contraseña que tendrá permiso para usar las tablas de esa base de datos será primerApellidoNombre, con la misma contraseña.
- La base de datos deberá tener las siguientes tablas:
    - Una tabla usuario con los siguientes campos: usuario (que será primary key), contraseña (cifrada), nombre, correo electrónico y un campo que indique       si el usuario es administrador o no.
    - Una tabla de pedidos con número que será asignado de forma automática y que será la primary key, un campo fecha, un campo iva y una relación M:N con       el campo de artículos (el que tuviera la otra vez).
    - Una tabla de árticulos y de categorías de la otra vez, asegurándome que tengo el campo stock.
- Para este primer sprint se deberán crear los formularios correspondientes a las siguientes rutas (entre paréntesis es la explicación):
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
## Segundo Sprint
- Modificar la clase de usuarios para que se pueda utilizar para loguearse con esta clase. El usuario con rol de administración tendrá acceso a  la lista de usuarios, a cambiar de administrador a usuario normal y viceversa, y a borrar y elimnar usuarios. El usuario con rol normal sólo tendrá opción a modificar sus datos y su contraseña.
- Se deberá implementar la búsqueda (por el campo que creas más interesante), paginación y ordenación para la lista de artículos y categorías.
- Sólo los usuarios administradores tendrán acceso a añadir, modificar y borrar categorías y artículos.
- Tanto el usuario normal como el administrador podrán ver la lista de categorías y artículos. Las categorías deberán tener un botón para ver la lista de artículos.
- Implementa un menú con la opción de listado de articulos, categorías y usuario (sólo para el administrador) y logout donde se muestre también el nombre del usuario y la posibilidad de cambiar el usuario.
## Tercer Sprint
- Implementar el carro de la compra con sesiones para el rol de usuario.
