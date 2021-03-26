package com.hqq.colorful_life;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Qingqing.He
 */
@MapperScan("com.hqq.colorful_life.model.dao")
@SpringBootApplication
@EnableSwagger2
@EnableCaching
public class ColorfulLifeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ColorfulLifeApplication.class, args);
    }

}
