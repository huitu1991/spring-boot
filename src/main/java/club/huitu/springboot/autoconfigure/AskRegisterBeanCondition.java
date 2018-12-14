package club.huitu.springboot.autoconfigure;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.ConfigurationCondition;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.MessageFormat;
import java.util.Map;

/**
 * @author hiutu
 * Created by huitu on 2018/12/14.
 */
public class AskRegisterBeanCondition implements ConfigurationCondition {

    @Override
    public ConfigurationPhase getConfigurationPhase() {
        return ConfigurationPhase.REGISTER_BEAN;
    }

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        Map<String, Object> attributes = metadata
                .getAnnotationAttributes(AskRegisterBeanConditional.class.getName());
        Class clazz = (Class) attributes.get("value");
        System.out.println(MessageFormat.format("确定要装配[{0}]吗: [y/n]",clazz.getName()));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String retValue = "y";
        try {
            retValue = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            retValue = "n";
        }
        return retValue.equals("y");
    }

}
