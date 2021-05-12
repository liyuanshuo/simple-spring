package simpleioc.context;

import org.junit.jupiter.api.Test;
import simpleioc.HelloWordServiceImpl;

/**
 * Here is the class description
 *
 * @author : liyuanshuo
 * @version : 1.0.0
 * @date : 2021/5/12 20:27
 */
class ApplicationContextTest {

    @Test
    public void applicationTest() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("simpleioc.xml");
        HelloWordServiceImpl helloWordService = (HelloWordServiceImpl) applicationContext.getBean("helloWordService");
        helloWordService.helloWord();
        System.out.println(helloWordService.getText());
    }

}
