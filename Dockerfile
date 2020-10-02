FROM java:8
COPY datos.sql /docker-entrypoint-initdb.d/
COPY /target/pedidos-0.0.1-SNAPSHOT.jar pedidos-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","pedidos-0.0.1-SNAPSHOT.jar"]