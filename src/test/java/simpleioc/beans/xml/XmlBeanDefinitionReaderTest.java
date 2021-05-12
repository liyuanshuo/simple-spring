package simpleioc.beans.xml;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import simpleioc.beans.BeanDefinition;
import simpleioc.beans.io.ResourceLoader;

import java.util.Map;

/**
 * Here is the class description
 *
 * @author : liyuanshuo
 * @version : 1.0.0
 * @date : 2021/5/12 17:01
 */
class XmlBeanDefinitionReaderTest {

    @Test
    public void xmlBeanTest() throws Exception {
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(new ResourceLoader());
        reader.loadBeanDefinitions("simpleioc.xml");
        Map<String, BeanDefinition> registry = reader.getRegistry();
        Assertions.assertTrue(registry.size() > 0);
    }

}
