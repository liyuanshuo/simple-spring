package simpleioc.factory;

import simpleioc.BeanDefinition;

/**
 * Here is the class description
 *
 * @author : liyuanshuo
 * @version : 1.0.0
 * @date : 2021/5/11 20:29
 */
public interface BeanFactory {

    /**
     * Bean的获取
     *
     * @param name BeanName
     * @return Bean
     */
    Object getBean(String name);

    /**
     * Bean的注册
     *
     * @param name       BeadName
     * @param definition BeanDefinition
     */
    void registerBeanDefinition(String name, BeanDefinition definition);
}
