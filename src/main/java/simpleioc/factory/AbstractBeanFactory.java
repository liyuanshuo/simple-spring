package simpleioc.factory;

import simpleioc.BeanDefinition;

import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Here is the class description
 *
 * @author : liyuanshuo
 * @version : 1.0.0
 * @date : 2021/5/11 20:32
 */
public abstract class AbstractBeanFactory implements BeanFactory {

    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    private final HashSet<String> beanDefinitionNames = new HashSet<>();

    @Override
    public Object getBean(String name) throws Exception {
        BeanDefinition definition = beanDefinitionMap.get(name);
        if (Objects.isNull(definition)) {
            throw new IllegalArgumentException("No bean named " + name + " is defined");
        }
        Object bean = definition.getBean();
        if (Objects.isNull(bean)) {
            bean = doCreatBean(definition);
        }
        return bean;
    }

    @Override
    public void registerBeanDefinition(String name, BeanDefinition definition) {
        beanDefinitionMap.put(name, definition);
        beanDefinitionNames.add(name);
    }

    @Override
    public void preInstantiateSingletons() throws Exception {
        for (String name : beanDefinitionNames) {
            getBean(name);
        }
    }

    /**
     * 依据BeanDefinition来创建Bean
     *
     * @param definition BeanDefinition
     * @return Bean 返回创建好的Bean
     * @throws Exception 异常信息
     */
    protected abstract Object doCreatBean(BeanDefinition definition) throws Exception;
}
