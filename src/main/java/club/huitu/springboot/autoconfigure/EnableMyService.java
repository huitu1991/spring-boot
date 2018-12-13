package club.huitu.springboot.autoconfigure;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author hiutu
 * Created by huitu on 2018/12/14.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(AutoConfigurationServiceImportSelector.class)
public @interface EnableMyService {
}
