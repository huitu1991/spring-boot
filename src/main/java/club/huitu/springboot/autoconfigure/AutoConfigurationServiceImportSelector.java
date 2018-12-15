package club.huitu.springboot.autoconfigure;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.StringUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author hiutu
 * Created by huitu on 2018/12/13.
 */
public class AutoConfigurationServiceImportSelector implements ImportSelector {

    private static final String FACTORIES_PATH = "META-INF/club.huitu.factories";

    private  static final String SERVICE_KEY = "service";

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        Properties properties = new Properties();
        try {
            properties.load(new ClassPathResource(FACTORIES_PATH).getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        String value = String.valueOf(properties.get(SERVICE_KEY));
        String[] serviceClasses = StringUtils.tokenizeToStringArray(value,",");
        return serviceClasses;
    }

}
