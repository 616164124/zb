package user;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class UserDemo2Appaction {
    public static void main(String[] args) {
        SpringApplication.run(UserDemo2Appaction.class, args);
    }
}
