package simpleioc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Here is the class description
 *
 * @author : liyuanshuo
 * @version : 1.0.0
 * @date : 2021/5/11 19:26
 */
public class BeanFactory {
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }

    public void registerBeanDefinition(String name, BeanDefinition definition) {
        beanDefinitionMap.put(name, definition);
    }

}
