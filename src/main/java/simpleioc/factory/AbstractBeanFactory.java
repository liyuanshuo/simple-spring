package simpleioc.factory;

import simpleioc.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Here is the class description
 *
 * @author : liyuanshuo
 * @version : 1.0.0
 * @date : 2021/5/11 20:32
 */
public abstract class AbstractBeanFactory implements BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    @Override
    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }

    @Override
    public void registerBeanDefinition(String name, BeanDefinition definition) throws Exception {
        Object bean = doCreatBean(definition);
        definition.setBean(bean);
        beanDefinitionMap.put(name, definition);
    }

    /**
     * 依据BeanDefinition来创建Bean
     *
     * @param definition BeanDefinition
     * @return Bean
     */
    protected abstract Object doCreatBean(BeanDefinition definition) throws Exception;
}
