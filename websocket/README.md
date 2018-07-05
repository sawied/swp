# How to establish connection with RabbitMQ over websocket and stomp, then publish log4j2 logs to front page?

#### create an exchange in rabbitmq manager console, and do settings in log4j2 configuation file.

```xml
	<RabbitMQ name="RabbitMQ"
        addresses="192.168.88.8:5672" user="danan" password="danan" virtualHost="/rabbitmqm"
        exchange="log4j2" exchangeType="topic" declareExchange="false" durable="true" autoDelete="false"
        applicationId="websocket"
        routingKeyPattern="logger.%X{applicationId}.%c.%p"
        contentType="text/plain" contentEncoding="UTF-8" generateId="true" deliveryMode="NON_PERSISTENT" 
        charset="UTF-8"
        senderPoolSize="3" maxSenderRetries="5">
        <PatternLayout pattern="%d{ISO8601} %X{applicationId} [%t] %-5level %logger{36} %L - %msg%n"/>
    </RabbitMQ>
```

#### create page for logs's show. firstly ,import socketjs and stomp.js


```
   $(document).ready(function(){
	var client=null;
	var topic =  "/exchange/log4j2"; 
	var tid= null;
	var logSubscribe=null;
	
	$("#connect").click(function(){
		if(!client||!client.connected){			
			//init sockjs instance and estiblish connection with server
	        // bind connection 
			var sock = new SockJS('http://localhost:8000/endpoint'/**,null,{ transports: "eventsource" }**/);
			client =Stomp.over(sock);
			
			client.heartbeat.outgoing = 4000; // client will send heartbeats every 5000ms
			client.heartbeat.incoming = 4000;     // client does not want to receive heartbeats
			                                   // from the server
			client.connect({}, function(e){
			  		console.log("connected");
					tid="T-sub-"+Math.floor(Math.random()*1000000);                                   
					logSubscribe=client.subscribe(topic+"/logger.#", function(e){
						$("#logger-panel").append("<li>"+e.body+"</li>");
					},{id:tid});
			  });
		}
	});
	
	$("#disconnect").click(function(){
		if(logSubscribe){
			logSubscribe.unsubscribe();
		}
		if(client){
			client.disconnect();
		}
	});
	
  
});

```
Note:you can match the queue with pattern. similar as above:**/exchange/log4j2/logger.#**
