package club.huitu.springboot.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author hiutu
 * Created by huitu on 2018/12/13.
 */
@Configuration
public class UserServiceConfiguration {

    @Component
    public class UserService implements BaseService {
        @Override
        public void doService() {
            System.out.println("UserService");
        }
    }

}
