1. try run the app in localhost

2. create a database and establish a connection with your Spring Boot project using MySQL
   1. Log in to MySQL:
      "mysql -u root -p"
   2. Create a Database:
      "CREATE DATABASE your_database_name;"
   3.Create a User and Grant Privileges:
     CREATE USER 'your_username'@'localhost' IDENTIFIED BY 'your_password';
     GRANT ALL PRIVILEGES ON your_database_name.* TO 'your_username'@'localhost';
     FLUSH PRIVILEGES;
3.  Configure Spring Boot to Connect to MySQL
   1.  Add MySQL Dependency in pom.xml
        <dependency>
          <groupId>mysql</groupId>
          <artifactId>mysql-connector-java</artifactId>
           <version>8.0.26</version>
       </dependency>

    2.Configure application.properties
       spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect 

4. add data in database
   mysql -u user-name -p
   USE your_database_name;
   INSERT INTO event (country, domain, email, ip, message, request_headers, response_headers, sessionuuid, severity, timestamp, uri)
  VALUES ('USA', 'example.com', 'john@example.com', '192.168.1.1', 'Some message', '...', '...', '123abc', 'INFO', '2024-05-25 12:00:00', '/page');
 **** event is a table in mydatabase 

5. deploy your Spring Boot project and run it behind an Nginx server
   1.  Package Your Spring Boot Application   " ./mvnw clean package " This will create a JAR file in the target directory.
   2.  Configure Nginx " sudo apt install nginx "
   3.  Create a new configuration file for your application in the /etc/nginx/sites-available/ directory.
      "  sudo nano /etc/nginx/sites-available/your_app "

server {
    listen 80;
    server_name your_domain.com;

    location / {
        proxy_pass http://localhost:8081;
        proxy_set_header Host $host;
        proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_set_header X-Forwarded-Proto $scheme;
    }
}

 4. Test Nginx Configuration: " sudo nginx -t "
 5. Restart Nginx:    " sudo systemctl restart nginx " 

 6.Run Your Spring Boot Application 
    1. Run the JAR file: "java -jar /path/to/your/app/your-app.jar " 

    now you can apen project in nginx server and can view the project out the local vm 
