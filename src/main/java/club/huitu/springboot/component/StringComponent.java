package club.huitu.springboot.component;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

/**
 * @author hiutu
 * Created by huitu on 2018/12/13.
 */
public class StringComponent {

    @Bean
    public String hello() {
        return "hello!";
    }

}
