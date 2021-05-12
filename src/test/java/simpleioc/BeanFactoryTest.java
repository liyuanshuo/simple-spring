package simpleioc;

import org.junit.jupiter.api.Test;
import simpleioc.factory.AutowireCapableBeanFactory;
import simpleioc.factory.BeanFactory;

/**
 * Here is the class description
 *
 * @author : liyuanshuo
 * @version : 1.0.0
 * @date : 2021/5/11 19:32
 */
class BeanFactoryTest {
    @Test
    public void factoryTest() throws Exception {
        // 1. 初始化BeanFactory
        BeanFactory beanFactory = new AutowireCapableBeanFactory();

        // 2. Bean定义
        BeanDefinition definition = new BeanDefinition();
        definition.setBeanClassName("simpleioc.HelloWordService");

        // 3.设置属性
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("text", "Hello Simple Spring"));
        definition.setPropertyValues(propertyValues);

        // 4.生成Bean
        beanFactory.registerBeanDefinition("helloWordService", definition);

        // 5. 获取Bean
        HelloWordService service = (HelloWordService) beanFactory.getBean("helloWordService");
        service.helloWord();
        System.out.println(service.getText());
    }
}
