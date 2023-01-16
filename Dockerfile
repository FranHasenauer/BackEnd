
# Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
# Click nbfs://nbhost/SystemFileSystem/Templates/Other/Dockerfile to edit this template

FROM amazoncorretto:11-alpine-jdk
MAINTAINER FranH
COPY target/Fran-0.0.1-SNAPSHOT.jar Fran-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/Fran-0.0.1-SNAPSHOT.jar"]

CMD ["/bin/sh"]

