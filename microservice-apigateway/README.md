>***There are multiple situations HTTP timeout.***
>For HTTP Client have mainly two options for it.

**SO_TIMEOUT**

Defines the default socket timeout (SO_TIMEOUT) in milliseconds which is the timeout for waiting for data. A timeout value of zero is interpreted as an infinite timeout. This value is used when no socket timeout is set in the HTTP method parameters.

**CONNECTION_TIMEOUT**

Determines the timeout until a connection is etablished. A value of zero means the timeout is not used. The default value is zero.
This parameter expects a value of type Integer.

>**For Apache HTTP server, I find a configuration parameter for 'timeout'**
>

##TimeOut Directive

* Description:	Amount of time the server will wait for   certain events before failing a request
* Syntax:	TimeOut seconds
* Default:	TimeOut 300
* Context:	server config, virtual host
* Status:	Core
* Module:	core

The TimeOut directive defines the length of time Apache will wait for I/O in various circumstances:

1. When reading data from the client, the length of time to wait for a TCP packet to arrive if the read buffer is empty.
2. When writing data to the client, the length of time to wait for an acknowledgement of a packet if the send buffer is full.
3. In mod_cgi, the length of time to wait for output from a CGI script.
4. In mod_ext_filter, the length of time to wait for output from a filtering process.
5. In mod_proxy, the default timeout value if ProxyTimeout is not configured.

> but I don't have a solution to solve timeout for a request that the entire request must not last longer than  specific seconds.
> 

Consult many references, the only solution is define the timeout of execution thread in processing thread.for example:

```JAVA
HttpGet getMethod = new HttpGet(
  "http://localhost:8080/spring-security-rest-template/api/bars/1");
 
int hardTimeout = 5; // seconds
TimerTask task = new TimerTask() {
    @Override
    public void run() {
        if (getMethod != null) {
            getMethod.abort();
        }
    }
};
new Timer(true).schedule(task, hardTimeout * 1000);
 
HttpResponse response = httpClient.execute(getMethod);
System.out.println(
  "HTTP Status of response: " + response.getStatusLine().getStatusCode());
```

#Conclusion

It's better to understand TCP/IP protocol.



