package VL01_zoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EurekaClient01ZooApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClient01ZooApplication.class, args);
        System.err.println("app started");

    }

}
