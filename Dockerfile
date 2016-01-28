FROM ubuntu:14.04
#MAINTAINER Vijeta 
RUN echo "deb-src http://ppa.launchpad.net/natecarlson/maven3/ubuntu precise main" >> /etc/apt/sources.list
RUN echo "deb http://ppa.launchpad.net/natecarlson/maven3/ubuntu precise main" >> /etc/apt/sources.list
RUN apt-get update && apt-get install openjdk-7-jdk maven3 git -y --force-yes
RUN ln -s /usr/share/maven3/bin/mvn /usr/bin/mvn
RUN apt-get update && apt-get install tomcat7 -y 
#ADD run_script /bin/
