package club.huitu.springboot.autoconfigure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * {@link AskRegisterBeanCondition AskRegisterBeanCondition} 前询问是否加载的装配条件
 * @author hiutu
 * Created by huitu on 2018/12/14.
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(AskRegisterBeanCondition.class)
public @interface AskRegisterBeanConditional {
    Class value();
}
