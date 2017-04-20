# Angular
Ejercicio Angular

## BACKEND

- Levantar el servidor Glasfish
- Base de datos utilizada es Derby-Remote, nombre de la base: "sun-appserv-samples"
- El script para crear las tablas se encuentra en la carpeta Backend, nombre: "script.sql"
- Compilar y ejecutar el proyecto maven Backend. 
- Los servicios se pueden consultar con los siguientes URL:

http://localhost:8080/Backend/api/user/basic/99

{  "IDENTIFICATION": 99,  "FIRST_NAME": "test",  "LAST_NAME": "test",  "GENDER": "Female",  "DATE_OF_BIRTH": "2017-12-31",  "ADDRESS": {    "ADDRESS": "Ecuador",    "ADDRESS_CITY": "Quito",    "POSTAL_CODE": "8"  }} 

http://localhost:8080/Backend/api/user/email/99

{"Email":[{"EMAIL":"pvquichimbo@utpl.edu.ec","EMAIL_TYPE":"Personal"}]}


## FRONTEND

- Ejecutar el archivo index.html
- Registrar un usuario
- Consultar el usuario utilizando su identificación
