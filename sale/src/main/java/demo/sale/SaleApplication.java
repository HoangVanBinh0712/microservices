package demo.sale;

import common.config.OpenApiConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(value = {OpenApiConfig.class})
@EnableCaching
public class SaleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SaleApplication.class, args);
    }

}
