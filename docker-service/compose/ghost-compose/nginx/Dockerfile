FROM nginx:latest

# define share path

MAINTAINER "danan.2009@gmail.com"

# copy server configuration file and deploying modules into images
ADD default.conf /etc/nginx/conf.d/default.conf

ADD *.tar /usr/share/nginx/html/

