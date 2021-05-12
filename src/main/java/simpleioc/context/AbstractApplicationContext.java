package simpleioc.context;

import lombok.AllArgsConstructor;
import lombok.Data;
import simpleioc.beans.factory.AbstractBeanFactory;

/**
 * Here is the class description
 *
 * @author : liyuanshuo
 * @version : 1.0.0
 * @date : 2021/5/12 20:19
 */
@Data
@AllArgsConstructor
public abstract class AbstractApplicationContext implements ApplicationContext {

    protected AbstractBeanFactory beanFactory;

    @Override
    public Object getBean(String name) throws Exception {
        return beanFactory.getBean(name);
    }

    public void refresh() throws Exception {

    }
}
