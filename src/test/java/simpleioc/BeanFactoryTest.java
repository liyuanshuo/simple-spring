package simpleioc;

import org.junit.jupiter.api.Test;

/**
 * Here is the class description
 *
 * @author : liyuanshuo
 * @version : 1.0.0
 * @date : 2021/5/11 19:32
 */
class BeanFactoryTest {
    @Test
    public void factoryTest() {
        // 1. 初始化BeanFactory
        BeanFactory beanFactory = new BeanFactory();

        // 2. 注入Bean
        BeanDefinition definition = new BeanDefinition(new HelloWordService());
        beanFactory.registerBeanDefinition("helloWord", definition);

        // 3. 获取Bean
        HelloWordService helloWord = (HelloWordService) beanFactory.getBean("helloWord");
        helloWord.helloWord();
    }
}
