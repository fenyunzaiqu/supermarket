package supermarket;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
@MapperScan("supermarket.mapper")
public class SupermarketApplication {
    public static void main(String[] args){
        SpringApplication.run(SupermarketApplication.class,args);
    }
}
