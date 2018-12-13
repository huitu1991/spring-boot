package club.huitu.springboot.bootstrap;

import club.huitu.springboot.autoconfigure.AutoConfigurationServiceImportSelector;
import club.huitu.springboot.autoconfigure.EnableMyService;
import club.huitu.springboot.service.BaseService;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

@SpringBootApplication
//@Import(AutoConfigurationServiceImportSelector.class)
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

        applicationContext.close();
    }

}

