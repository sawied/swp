FROM ibmcom/ibm-http-server

# define share path

MAINTAINER "danan.2009@gmail.com"

WORKDIR /opt/IBM/HTTPServer/htdocs/

# copy server configuration file and deploying modules into images
ADD httpd.conf /opt/IBM/HTTPServer/conf/

ADD *.tar /opt/IBM/HTTPServer/htdocs/

VOLUME var/docker/



