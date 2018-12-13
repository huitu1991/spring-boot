package club.huitu.springboot.bootstrap;

import club.huitu.springboot.autoconfigure.EnableMyService;
import club.huitu.springboot.service.BaseService;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableMyService
public class SpringbootApplication {

	public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder()
                .sources(SpringbootApplication.class)
                .web(WebApplicationType.NONE)
                .build()
                .run(args);

        applicationContext.getBeansOfType(BaseService.class)
                .forEach((key,value) -> {
                    value.doService();
                });

    }

}

