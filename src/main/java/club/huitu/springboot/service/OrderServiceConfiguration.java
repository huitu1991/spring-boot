package club.huitu.springboot.service;

import club.huitu.springboot.autoconfigure.AskRegisterBeanConditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author hiutu
 * Created by huitu on 2018/12/13.
 */
@Configuration
public class OrderServiceConfiguration {

    @Component
    public class OrderService implements BaseService {
        @Override
        public void doService() {
            System.out.println("OrderService");
        }
    }

}
