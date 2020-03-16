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

8. 
