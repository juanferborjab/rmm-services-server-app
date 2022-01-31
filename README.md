README
This was developed whit:
Java 8
Maven 3.6.3
SpringBoot 2.6.3

Introduction

According to solve the requirement. The database have the list of services exposed on the request, and also a list of Customer (this table has just idCustomer)
On the other hand, The API handles a ENUM for type of Device and  serviceType (Windows, MAC, Normal).
Also, this solution has a protocol SSL and a Unit Test of the DeviceController.


REST ENDPOINT

In Spring, REST endpoints are Spring MVC controllers.


This application has two endpoints:


	DeviceController
	It handles a  request for the /device  endpoint.
        The @PutMapping annotation for maps "/device/{idCustomer}" PUT requests in a specific controller method: updateDevice 
		The @GetMapping annotation for  GET requests for maps "/device/{idCustomer}" in a specific controller method: getDevice 
		The @PostMapping annotation for maps "/device/{idCustomer}"  POST requests in a specific handler method: createDevice.
		The @DeleteMapping annotation for  DELETE "/ device/{idCustomer}/{idDevice}" map requests in a specific controller method: removeDeviceFromCustomer.
	
	ServeController
	It handles a  request for the /device  endpoint.
		The @PostMapping annotation for maps "/server/{idCustomer}/{idService}"  POST requests in a specific handler method: addServiceToCustomerAccount.
		The @DeleteMapping annotation for  DELETE "/ server/{idCustomer}/{idService}" map requests in a specific controller method: deleteServiceToCustomerAccount .
       	The @GetMapping annotation for  GET requests for maps "/server/{idCustomer}" in a specific controller method: getAllServiceToCustomerAccount .
		The @GetMapping annotation for  GET requests for maps "/server/totalCost/{idCustomer}" in a specific controller method: getTotalCostMontly.




DATABASE:
The database is running in Postgres.
The schema of the database contains:
-device
-customer_serve
-serve
-customer


SCRIPT to insert Services on DATABASE

INSERT INTO serve (cost,name,type)

VALUES
(7.00, 'Antivirus', 'Mac'),
(5.00, 'Antivirus', 'Windows'),
(3.00, 'Cloudberry', 'Normal'),
(2.00, 'PSA', 'Normal'),
(1.00, 'TeamViewer', 'Normal')


SCRIPT to insert Customer on DATABASE

INSERT INTO customer (id_customer)
values (1),(2),(3)
