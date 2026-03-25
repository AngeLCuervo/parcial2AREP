# parcial2AREP

Ayuda
Para invocar un servicios get desde java puede hacerlo de manera fácil con:
     
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConnectionExample {

    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String GET_URL = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=fb&apikey=Q1QZFVJQ21K7C6XM";

    public static void main(String[] args) throws IOException {

        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        
        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
        } else {
            System.out.println("GET request not worked");
        }
        System.out.println("GET DONE");
    }

} 
     
Para invocar servicios rest de forma asíncrona desde un cliente JS
<!DOCTYPE html>
<html>
<head>
<title>Form Example</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<h1>Form with GET</h1>
<form action="/hello">
<label for="name">Name:</label><br>
<input type="text" id="name" name="name" value="John"><br><br>
<input type="button" value="Submit" onclick="loadGetMsg()">
</form>
<div id="getrespmsg"></div>
<script>
function loadGetMsg() {
let nameVar = document.getElementById("name").value;
const xhttp = new XMLHttpRequest();
xhttp.onload = function() {
document.getElementById("getrespmsg").innerHTML =
this.responseText;
}
xhttp.open("GET", "/hello?name="+nameVar);
xhttp.send();
}
</script>
<h1>Form with POST</h1>
<form action="/hellopost">
<label for="postname">Name:</label><br>
<input type="text" id="postname" name="name" value="John"><br><br>
<input type="button" value="Submit" onclick="loadPostMsg(postname)">
</form>
<div id="postrespmsg"></div>
<script>
function loadPostMsg(name){
let url = "/hellopost?name=" + name.value;
fetch (url, {method: 'POST'})
.then(x => x.text())
.then(y => document.getElementById("postrespmsg").innerHTML = y);
}
</script>
</body>
</html>
3. Aplicación Spring mínima

-------
package co.edu.eci.lambda.springrest;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

private static final String template = "Hello, %s!";
private final AtomicLong counter = new AtomicLong();

@GetMapping("/greeting")
public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
return new Greeting(counter.incrementAndGet(), String.format(template, name));
}
}
-------
package co.edu.eci.lambda.springrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestServiceApplication {

public static void main(String[] args) {
SpringApplication.run(RestServiceApplication.class, args);
}

}
---------
package co.edu.eci.lambda.springrest;


public record Greeting(long id, String content) { }

    4. Ejemplo pom.xml de Spring con plugins
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
<modelVersion>4.0.0</modelVersion>
<parent>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-parent</artifactId>
<version>3.3.0</version>
<relativePath/> <!-- lookup parent from repository -->
</parent>
<groupId>com.example</groupId>
<artifactId>rest-service-complete</artifactId>
<version>0.0.1-SNAPSHOT</version>
<name>rest-service-complete</name>
<description>Demo project for Spring Boot</description>
<properties>
<java.version>17</java.version>
</properties>
<dependencies>
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-web</artifactId>
</dependency>

<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-test</artifactId>
<scope>test</scope>
</dependency>
</dependencies>

<build>
<plugins>
<plugin>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-maven-plugin</artifactId>
</plugin>
</plugins>
</build>

</project>
