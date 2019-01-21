# README #

This application is built with Spring boot. 
The application runs at port 8082.

### Requirement

1. Java 1.8+ JRE
2. Java 1.8+ JDK for development
3. gradle

### Matching
The system will calculate the score for each job and return top 3 in the list. If the scores are the same,
the higher bill rate will come first. 

### How do I get set up? ###

1. Download the source code from the git hub


2. go to project root and run the following command to generate the artifact.
`./gradlew clean build`

You can skip testing by running 
`./gradlew clean build -x test`

3. You can run the application by the following command 
`java -jar /project_root/build/libs/demo-0.0.0.jar`.

or
`./gradlew bootRun`

Alternative, you can run it via your IDE.
The main class is 
`com.match.demo.DemoApplication`

### Deployment

You can run the application as service.
In linux 
```[Unit]
   Description=match
   
   [Service]
   User=[user]
   Group=[group]
   ExecStart=/usr/bin/java -jar -Xms64M -Xmx256M /path/demo-0.0.0.jar
   ExecReload=/bin/kill -s HUP $MAINPID
   ExecStop=/bin/kill -S TERM $MAINPID
   #Restart=on-failure
   PrivateTmp=true
   [Install]
   WantedBy=multi-user.target

```


### Endpoint
`/find_jobs/worker/{id}`


### Demo
Demo API : `http://188.166.243.95:8082`

Swagger documentation 
`http://188.166.243.95:8082/swagger-ui.html`



