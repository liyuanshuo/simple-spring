package simpleioc;

import lombok.Data;
import simpleioc.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * Here is the class description
 *
 * @author : liyuanshuo
 * @version : 1.0.0
 * @date : 2021/5/12 16:15
 */
@Data
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    private Map<String, BeanDefinition> registry;

    private ResourceLoader resourceLoader;

    public AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
        registry = new HashMap<>();
        this.resourceLoader = resourceLoader;
    }
}
