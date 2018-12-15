package club.huitu.springboot.autoconfigure;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.ConfigurationCondition;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.Assert;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.MessageFormat;
import java.util.Map;

/**
 * {@link ConfigurationCondition ConfigurationCondition }
 * @author hiutu
 * Created by huitu on 2018/12/14.
 */
public class AskRegisterBeanCondition implements ConfigurationCondition {

    @Override
    public ConfigurationPhase getConfigurationPhase() {
        //@Bean时进行条件判断
        return ConfigurationPhase.REGISTER_BEAN;
    }

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        Map<String, Object> attributes = metadata
                .getAnnotationAttributes(AskRegisterBeanConditional.class.getName());
        Class clazz = (Class) attributes.get("value");
        Assert.notNull(clazz,"[value] is required; it must not be null");

        System.out.println(MessageFormat.format("确定要装配[{0}]吗: [y/n]",clazz.getName()));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String retValue = "n";
        try {
            retValue = br.readLine();
            retValue = StringUtils.isEmpty(retValue) ? "n" : retValue;
        } catch (IOException e) {
            e.printStackTrace();
            retValue = "n";
        }
        return retValue.toLowerCase().startsWith("y");
    }

}
