# AREP-Patrones
## PASO A PASO

Antes de crear la base de datos debemos crear un security group con los puertos de mysql

1. Nos dirigimos a la pestaña de Security Groups y damos click en Create Seucrity Group y le damos un nombre y una descripción

![Imagenes](https://github.com/checho1998/AREP-Patrones/blob/master/Imagenes/1.PNG)

2. Agregamos una recla al security group que creamos, esta regla va a ser de tipo Mysql y en la seccion de source ponemos anywhere.

![Imagenes](https://github.com/checho1998/AREP-Patrones/blob/master/Imagenes/2.PNG)


Ahora si procedemos a crear la base de datos la cual vamos a enlazar con el seucrity group que creamos

3. Nos dirigimos a la pestaña de RDS y damos click en crear database y creamos una instancia nueva, dejamos la configuracion estandar y escogemos una DB MySQL

![Imagenes](https://github.com/checho1998/AREP-Patrones/blob/master/Imagenes/3.PNG)

4.Ponemos la versio gratis para no generar un costo adicional

![Imagenes](https://github.com/checho1998/AREP-Patrones/blob/master/Imagenes/4.PNG)

5. Le debemos poner un nombre de usuario y una clave

![Imagenes](https://github.com/checho1998/AREP-Patrones/blob/master/Imagenes/5.PNG)

6. En configuración adicional debemos escoger el acceso publico para acceder desde internet y en las VPC escogemos el Security Group que ya habiamos creado previamente

![Imagenes](https://github.com/checho1998/AREP-Patrones/blob/master/Imagenes/6.PNG)

7. En la configuración adicional le damos un nombre y todo el resto lo dejamos por defecto.

![Imagenes](https://github.com/checho1998/AREP-Patrones/blob/master/Imagenes/7.PNG)

8. Una vez que la base de datos este disponible vamos a probar la conectividad usando DBeaver o cualquier otro programa que desee.
Ubicamos entonces el host de la DB en la configuracion y nos conectamos con esa información:

- Host: database-1.c13o4rw8e3uj.us-east-1.rds.amazonaws.com
- Name DB: DBarep

Host:

![Imagenes](https://github.com/checho1998/AREP-Patrones/blob/master/Imagenes/8.PNG)

Name:

![Imagenes](https://github.com/checho1998/AREP-Patrones/blob/master/Imagenes/9.PNG)

9. Debemos clonar este repositorio y configurar el archivo application.properties con los datos de nuestra base de datos que ya creamos previamente.

![Imagenes](https://github.com/checho1998/AREP-Patrones/blob/master/Imagenes/10.PNG)

10. Luego debemos modificar la entidad que va a ser mapeada de la base de datos (no olvide agregar los getters y setters de cada atributo y dos consutrctores, uno vacio y otro con todos los parametros)

![Imagenes](https://github.com/checho1998/AREP-Patrones/blob/master/Imagenes/11.PNG)

11. Posteriormente debemos crear la consulta que se va a realizar a la base de datos ya creada, al igual que construir el objeto a partir de esa consulta que se creara en el Entity.

![Imagenes](https://github.com/checho1998/AREP-Patrones/blob/master/Imagenes/12.PNG)

12. Al ejecutar la aplicación con el comando 

- mvn spring-boot:run

