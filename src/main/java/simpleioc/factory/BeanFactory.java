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
    Object getBean(String name) throws Exception;

    /**
     * Bean的注册
     *
     * @param name       BeadName
     * @param definition BeanDefinition
     * @throws Exception 异常
     */
    void registerBeanDefinition(String name, BeanDefinition definition) throws Exception;


    /**
     * 预创建Bean
     *
     * @throws Exception 异常
     */
    void preInstantiateSingletons() throws Exception;
}
