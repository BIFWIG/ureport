package cn.bif;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ImportResource;

/**
 * @author Ted Wang
 * @created 2021/1/29 10:31 上午
 */

@EnableConfigurationProperties
@SpringBootApplication
public class Application {
    
    
    public static void main (String[] args) {
        SpringApplication.run(Application.class,args);
    }
    
    
}
