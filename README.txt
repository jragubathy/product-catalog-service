
=> Refer jpeg file for architecuture diagram
=> IDE : Eclipse Luna Service Release 2 (4.4.2)
=> J2EE Frameworks : Spring


Service URLs :
-----------------

Product Catalog Service : http://localhost:9080/product/catalog/service

Product Pricing Service : http://localhost:9081/product/pricing/service


Healthcheck URLs :
--------------------


Product Catalog Service : http://localhost:9080/product/catalog/service/healthcheck/info

Product Pricing Service : http://localhost:9081/product/pricing/service/healthcheck/info


H2 Database Console :
-----------------------

Product Catalog Service : http://localhost:9080/console

JDBC URL - jdbc:h2:mem:catalogdb
User Name - sa
Password (empty) - 


Product Pricing Service : http://localhost:9081/console

JDBC URL - jdbc:h2:mem:pricingdb
User Name - sa
Password (empty) - 



End Points for testing throw REST client:
------------------------------------------

Product Catalog Service :


1) Add a Product

POST : http://localhost:9080/product/catalog/service/products/addProduct
BODY : {"productName":"chocolate","productType":"milk product","productDescription":"milk chocolate","createdBy":"ragubathy","modifiedBy":"ragubathy"}
Header : Content-Type: application/json


2) Retrieve Products based on Product Type

GET : http://localhost:9080/product/catalog/service/products/getProducts?productType=milk%20product
Header : Content-Type: application/json


3) Remove Product based on Product Name

GET : http://localhost:9080/product/catalog/service/products/removeProduct?productName=chocolate
Header : Content-Type: application/json


Product Pricing Service :


1) Get Product Price based on product name

GET : http://localhost:9081/product/pricing/service/products/getProductPrice?productName=ghee
Header : Content-Type: application/json 




Assumption:
----------------------

Product Catalog Service :

1) Product Name is Unique
2) User can add only one product at a time
3) Product Type can be same for 'n' number of products


Product Pricing Service :

1) Product Name is Unique and details are retrieved based on it
2) Single product price can be retrieved at a time


Database :

1) Database records are added during application startup for testing purpose
2) Tables are indexed based on product name



Risks :
-----------

Product Catalog Service :

1) No limit on retrieval of products. It leads to performance issues if products grow.


General :

1) Load balancer is not configured for this services. This can be done by using HAProxy/Apache HTTPD
2) Token mechanism has to be introduced to access the services






