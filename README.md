# microservice - hexagonal architecture

---------------------------------------
1- comando instalar y desplegar rabbitmq en docker
***********************
docker run -d --restart always --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.9-management

ingresar a la url
**********************
http://localhost:15672/#/queues
user=guest
password=guest
-------------------------------

2- desplegar ambos microservicios en springboot en local - no se tuvo tiempo para desplegarlo en docker

cada microservicio cuenta con su propia base de datos, la comunicacion es mediante rabbitMQ el ms banking  produce un mensaje a una cola de rabbitMQ esta cola es escuchado por un listener del ms customer, el ms customer luego de buscar la informacion de cliente envia el nombre a la cola en rabbitMQ esta cola es escuchada por el ms banking product al recibir el nombre del cliente procede a buscar el reporte de los movimientos y cuentas del cliente, con la informacion obtenida procede a filtrar por rango de fechas.

2.1- banking-product
2.1- customer

-------------------------------

3- ingresar a base de datos cliente
********************************
http://localhost:8081/h2-console/login.do?jsessionid=d265dc2851364adddb6de83669b3de4d
user:devsu
pass:devsu@.

ejecutar el script para validar el registro de los clientes
SELECT * FROM PERSON 

ingresar a base de datos banking-product
********************************
http://localhost:8080/h2-console/login.do?jsessionid=ce2ad2f20909f0674bee2e657218b271
user:devsu
pass:devsu@.

ejecutar los querys para validar el registro de la informacion normalizada

SELECT * FROM TYPE_MOVEMENT ;
SELECT * FROM TYPE_ACCOUNT ;
SELECT * FROM MOVEMENT ;
SELECT * FROM ACCOUNT ;

------------------------------------

como importar y exportar el set de pruebas
**************************************

contexto: el set de pruebas se ejecuta en dos parte y guia para exportar e importar:
https://www.youtube.com/watch?v=poYqCMhrgSc

las entidades principales cuenta con CRUD

para la ejecucion funcionar seguir los siguientes pasos:

1- DEVSU CLIENTE

	1.1 POST CLIENTES

2- DEVSU CUENTAS - MOVIMIENTOS

	2.1 POST TIPO-CUENTAS
	2.2 POST CUENTAS
	2.3 GET CUENTAS
	2.4 POST TIPO-MOVIMIENTO
	2.5 GET REPORTE CLIENTE CUENTAS RANGO FECHAS
		la estructura de la url tiene los siguientes parametros
			- id= id generado al crear el cliente
			- idCard= valor ingresado que representa el identificador del cliente, es un valor unico en laBD
			- fechaInicio y fechaFin= rango de fechas que se admitiran el registro de los movimientos 
		localhost:8080/movimientos/reportes?id=1&idCard=12s31s2213&fechaInicio=2024-10-24&fechaFin=2024-10-24

