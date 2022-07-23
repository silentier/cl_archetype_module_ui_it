package ${package};

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class Rest {

    public static void main(String[] args) {
        SpringApplication.run(Rest.class, args);
    }

}

