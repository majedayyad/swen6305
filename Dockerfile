FROM ubuntu:latest

RUN echo "deb http://archive.ubuntu.com/ubuntu precise main universe" > /etc/apt/sources.list
RUN apt-get update


RUN mkdir -p /var/run/sshd

RUN apt-get install -y --no-istall-recommends openjdk-7-jdk

RUN adduser --quit jenkins

RUN echo "jenkins:jenkins" | chpasswd

EXPOSE 22

CMD ["/usr/sbin/sshd", "-D"]
