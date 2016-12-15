## VTM project Product-backend construction description

>Welcome to production back end function, this document will introduce the hign level components of back end.

* **GroupID:** *com.chinasofti.vtc.product*
* **SCM:** *git clone git://10.100.4.150/product-backend.git*
* **Version:** *2.0*

***********************************************************
### Project manager POM
Component | Type|Description
----------|-----|------
group-vtc-parent| POM|POM defination and dependencies manager
group-vtc-bootstrap| POM|projects build definatin


### Gateway component
Component | Type|Description
----------|-----|------
group-vtc-gateway-web | web|main entry for VTM access back end system,it contains proxy,spring Security,token,SSO etc.
group-vtc-gateway-core | jar|HTTP Client,host Mapping


### Back End Service
Component | Type|Description
----------|-----|------
group-vtc-service-web | web | provide Service entry for Service, all the service reponse return via HTTP, contains **Service interface , exception handler,Bean mapping,validation,logs,JNDI Setting**
group-vtc-service-core|jar|use spring integration exposure the service: **HTTP Client,WebService,JMS,SFTP,mail,freemaker, utility**
group-vtc-service-business|jar|Business logic,outside system integration
group-vtc-service-persist|jar| data entity defination,Dao inteface and implement,HQL/native SQL
group-vtc-service-adminConsole|jar| Manager function defination ,System infor,Log monitor)
