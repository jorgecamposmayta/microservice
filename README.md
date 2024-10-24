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

ejecutar el script para validar el registro de los clientes
SELECT * FROM PERSON 

ingresar a base de datos banking-product
********************************
http://localhost:8080/h2-console/login.do?jsessionid=ce2ad2f20909f0674bee2e657218b271

ejecutar los querys para validar el registro de la informacion normalizada

SELECT * FROM TYPE_MOVEMENT ;
SELECT * FROM TYPE_ACCOUNT ;
SELECT * FROM MOVEMENT ;
SELECT * FROM ACCOUNT ;
