package simpleioc.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import simpleioc.AbstractBeanDefinitionReader;
import simpleioc.BeanDefinition;
import simpleioc.BeanReference;
import simpleioc.PropertyValue;
import simpleioc.io.ResourceLoader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.util.Objects;

/**
 * Here is the class description
 *
 * @author : liyuanshuo
 * @version : 1.0.0
 * @date : 2021/5/12 16:18
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public XmlBeanDefinitionReader(ResourceLoader resourceLoader) {
        super(resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(String location) throws Exception {
        InputStream inputStream = getResourceLoader().getResource(location).getInputStream();
        doLoadBeanDefinitions(inputStream);
    }

    protected void doLoadBeanDefinitions(InputStream inputStream) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(inputStream);
        // 解析Bean
        registerBeanDefinitions(document);

        inputStream.close();
    }

    private void registerBeanDefinitions(Document document) {
        Element element = document.getDocumentElement();
        parseBeanDefinitions(element);
    }

    private void parseBeanDefinitions(Element root) {
        NodeList nodes = root.getChildNodes();
        for (int i = 0; i < nodes.getLength(); ++i) {
            Node item = nodes.item(i);
            if (item instanceof Element) {
                Element element = (Element) item;
                processBeanDefinition(element);
            }
        }
    }

    private void processBeanDefinition(Element element) {
        String name = element.getAttribute("name");
        String className = element.getAttribute("class");
        BeanDefinition definition = new BeanDefinition();
        processProperty(element, definition);
        definition.setBeanClassName(className);
        getRegistry().put(name, definition);
    }

    private void processProperty(Element element, BeanDefinition definition) {
        NodeList properties = element.getElementsByTagName("property");
        for (int i = 0; i < properties.getLength(); ++i) {
            Node node = properties.item(i);
            if (node instanceof Element) {
                Element propertyElement = (Element) node;
                String name = propertyElement.getAttribute("name");
                String value = propertyElement.getAttribute("value");
                if (Objects.nonNull(value) && value.length() > 0) {
                    definition.getPropertyValues().addPropertyValue(new PropertyValue(name, value));
                } else {
                    String ref = propertyElement.getAttribute("ref");
                    if (Objects.isNull(ref) || ref.length() == 0) {
                        throw new IllegalArgumentException("Configuration problem: <property> element for property " + name + " must specify a ref or a value");
                    }
                    BeanReference reference = new BeanReference(ref);
                    definition.getPropertyValues().addPropertyValue(new PropertyValue(name, reference));
                }
            }
        }
    }
}
