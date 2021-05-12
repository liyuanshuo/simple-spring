package simpleioc;

import org.junit.jupiter.api.Test;
import simpleioc.beans.BeanDefinition;
import simpleioc.beans.factory.AutowireCapableBeanFactory;
import simpleioc.beans.factory.BeanFactory;
import simpleioc.beans.io.ResourceLoader;
import simpleioc.beans.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * Here is the class description
 *
 * @author : liyuanshuo
 * @version : 1.0.0
 * @date : 2021/5/11 19:32
 */
class BeanFactoryTest {
    @Test
    public void factoryTestLazy() throws Exception {
        // 1. 读取配置
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(new ResourceLoader());
        reader.loadBeanDefinitions("simpleioc.xml");

        // 2. 初始化BeanFactory并注册Bean
        BeanFactory beanFactory = new AutowireCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> definitionEntry : reader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(definitionEntry.getKey(), definitionEntry.getValue());
        }

        // 3.获取Bean
        HelloWordServiceImpl helloWordService = (HelloWordServiceImpl) beanFactory.getBean("helloWordService");
        helloWordService.helloWord();
        System.out.println(helloWordService.getText());

        OutputService outputService = (OutputService) beanFactory.getBean("outputService");
        outputService.getHelloWordService().helloWord();

    }

    @Test
    public void preInstanceTest() throws Exception {
        // 1. 读取配置
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(new ResourceLoader());
        reader.loadBeanDefinitions("simpleioc.xml");

        // 2. 初始化BeanFactory并注册Bean
        BeanFactory beanFactory = new AutowireCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> definitionEntry : reader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(definitionEntry.getKey(), definitionEntry.getValue());
        }

        // 3. 初始化Bean
        beanFactory.preInstantiateSingletons();

        // 4. 获取Bean
        HelloWordServiceImpl helloWordService = (HelloWordServiceImpl) beanFactory.getBean("helloWordService");
        helloWordService.helloWord();
        System.out.println(helloWordService.getText());

        OutputService outputService = (OutputService) beanFactory.getBean("outputService");
        outputService.getHelloWordService().helloWord();
    }
}
