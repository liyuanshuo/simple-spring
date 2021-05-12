package simpleioc.context;

import simpleioc.beans.BeanDefinition;
import simpleioc.beans.factory.AbstractBeanFactory;
import simpleioc.beans.factory.AutowireCapableBeanFactory;
import simpleioc.beans.io.ResourceLoader;
import simpleioc.beans.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * Here is the class description
 *
 * @author : liyuanshuo
 * @version : 1.0.0
 * @date : 2021/5/12 20:21
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {


    private String configLocation;

    public ClassPathXmlApplicationContext(AbstractBeanFactory beanFactory) {
        super(beanFactory);
    }

    public ClassPathXmlApplicationContext(String configLocation) throws Exception {
        this(new AutowireCapableBeanFactory(), configLocation);
    }

    public ClassPathXmlApplicationContext(AbstractBeanFactory beanFactory, String configLocation) throws Exception {
        super(beanFactory);
        this.configLocation = configLocation;
        refresh();
    }

    @Override
    public void registerBeanDefinition(String name, BeanDefinition definition) {

    }

    @Override
    public void preInstantiateSingletons() {

    }

    @Override
    public void refresh() throws Exception {
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(new ResourceLoader());
        reader.loadBeanDefinitions(configLocation);
        for (Map.Entry<String, BeanDefinition> definitionEntry : reader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(definitionEntry.getKey(), definitionEntry.getValue());
        }
    }
}
