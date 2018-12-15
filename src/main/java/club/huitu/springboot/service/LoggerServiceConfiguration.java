package club.huitu.springboot.service;

import club.huitu.springboot.autoconfigure.AskRegisterBeanConditional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 日志打印配置类
 * @author hiutu
 * Created by huitu on 2018/12/15.
 */
@Configuration
public class LoggerServiceConfiguration {

    @Bean
    @AskRegisterBeanConditional(value = LoggerService.class)
    public LoggerService loggerService() {
        return new LoggerService();
    }

    public class LoggerService implements BaseService {

        @Override
        public void doService() {
            System.out.println("LoggerService");
        }
    }

}
