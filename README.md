# AREP-Patrones

## PASO A PASO

### Creación de RDS

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

### Creación Aplicación web

9. Debemos clonar este repositorio y configurar el archivo application.properties con los datos de nuestra base de datos que ya creamos previamente.

![Imagenes](https://github.com/checho1998/AREP-Patrones/blob/master/Imagenes/10.PNG)

10. Luego debemos modificar la entidad que va a ser mapeada de la base de datos (no olvide agregar los getters y setters de cada atributo y dos consutrctores, uno vacio y otro con todos los parametros)

![Imagenes](https://github.com/checho1998/AREP-Patrones/blob/master/Imagenes/11.PNG)

11. Posteriormente debemos crear la consulta que se va a realizar a la base de datos ya creada, al igual que construir el objeto a partir de esa consulta que se creara en el Entity.

![Imagenes](https://github.com/checho1998/AREP-Patrones/blob/master/Imagenes/12.PNG)

12. Al ejecutar la aplicación con el comando nos debe mostrar lo que ya previamente configuramos

- mvn spring-boot:run

![Imagenes](https://github.com/checho1998/AREP-Patrones/blob/master/Imagenes/13.PNG)

### Despliegue en EC2

Ahora vamos ahora a crear un EC2 y subir nuestra aplicacion para desde alli consumir la base de datos

13. vamos a crear una instancia de EC2 que contenga java como se ve a continuación

![Imagenes](https://github.com/checho1998/AREP-Patrones/blob/master/Imagenes/14.PNG)

14. vamos a crear otra regla como se ve acontinuacion para el acceso a este servicio que es por el puerto 8080

![Imagenes](https://github.com/checho1998/AREP-Patrones/blob/master/Imagenes/15.PNG)

15. revisar que nuestra instancia esta corriendo correctamente

![Imagenes](https://github.com/checho1998/AREP-Patrones/blob/master/Imagenes/16.PNG)

16. como podemos ver nos vamos a conectar a la instancia de EC2 que acabamos de crear con el codigo que nos muestra y desde la carpeta donde tenemos la llave que acabamos de descargar.

![Imagenes](https://github.com/checho1998/AREP-Patrones/blob/master/Imagenes/17.PNG)

17. Vamos a borrar la version de java 1.7.0 ya que necesitamos es la 8 y lo haremos con el siguiente comando.

![Imagenes](https://github.com/checho1998/AREP-Patrones/blob/master/Imagenes/18.PNG)

18. Ahora vamos a instalar el java que necesitamos que es el 1.8.0 como se puede ver.

![Imagenes](https://github.com/checho1998/AREP-Patrones/blob/master/Imagenes/19.PNG)

19. vamos a conectarnos por medio de sfpt con el mismo comando para tener acceso en ambas consolas pero en ves de ssh va a ser sftp y pasar el archivo con put y el nombre del archivo como se puede ver. 

![Imagenes](https://github.com/checho1998/AREP-Patrones/blob/master/Imagenes/20.PNG)

![Imagenes](https://github.com/checho1998/AREP-Patrones/blob/master/Imagenes/21.PNG)

20. ahora lo iniciamos con el comando java -jar y el nombre del archivo .jar q pasamos y lo ejecutamos como se puede ver.

![Imagenes](https://github.com/checho1998/AREP-Patrones/blob/master/Imagenes/22.PNG)

21. Como se puede ver sigue funcionando nuestro programa pero desde EC2 en AWS.

![Imagenes](https://github.com/checho1998/AREP-Patrones/blob/master/Imagenes/23.PNG)

### Creación de recurso estático

22. dirijimos a la seccion de S3 y creamos un nuevo Bucket

![Imagenes](https://github.com/checho1998/AREP-Patrones/blob/master/Imagenes/24.PNG)

23. En la seccion de permisos desmarcamos la opcion de bloquer el accesso publico para que quede publico.

![Imagenes](https://github.com/checho1998/AREP-Patrones/blob/master/Imagenes/25.PNG)

24. Cargamos el archivo que necesitamos cargar como este html

![Imagenes](https://github.com/checho1998/AREP-Patrones/blob/master/Imagenes/26.PNG)

25.Seleccionamos la opcion que es para todos y que se pueda leer ya que es publico

![Imagenes](https://github.com/checho1998/AREP-Patrones/blob/master/Imagenes/27.PNG)

26. para finalizar comprobamos que si sirve en AWS como se puede ver 

![Imagenes](https://github.com/checho1998/AREP-Patrones/blob/master/Imagenes/28.PNG)

### Acabamos con nuestro laboratorio


## Como Instalar y Correr el Codigo

- Debe estar en el directorio donde quiere traer el repositorio
- Para traer el repositorio a el directorio que usted desee, debe abrir la consola del PC e ingresar este codigo:
```
$ git clone https://github.com/checho1998/Libreria-Numeros-Complejos.git
```
- luego debe ingresar el siguiente codigo para limpiar y compilar el programa desde el directorio donde este el programa
```
$ mvn clean install 
```
- Podria tambien usar el siguiente codigo para provar las pruebas y ver su completa funcionalidad
```
$ mvn test
```
- Para correr el programa desde windows puede correr desde su cmd este codigo
```
mvn exec:java -Dexec.mainClass="com.example.Main" [-Dexec.args="argument1"]
```



## Construido en lenguaje
  
  - Java (V8)
  
## Ejecutar Pruebas

Las pruebas estan desarrolladas con la dependencia de JUnit 5, por lo tanto es necesario tenerla
en el pc donde se corran.

## Autor

- Sergio Alejandro Nuñez Mendivelso
