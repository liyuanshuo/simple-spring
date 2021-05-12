package simpleioc.factory;

import simpleioc.BeanDefinition;
import simpleioc.PropertyValue;

import java.lang.reflect.Field;

/**
 * Here is the class description
 *
 * @author : liyuanshuo
 * @version : 1.0.0
 * @date : 2021/5/11 20:36
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {
    @Override
    protected Object doCreatBean(BeanDefinition definition) throws Exception {
        Object bean = creatBeanInstance(definition);
        applyPropertyValues(bean, definition);
        return bean;
    }

    protected Object creatBeanInstance(BeanDefinition definition) throws InstantiationException, IllegalAccessException {
        return definition.getBeanClass().newInstance();
    }

    protected void applyPropertyValues(Object bean, BeanDefinition definition) throws NoSuchFieldException, IllegalAccessException {
        for (PropertyValue propertyValue : definition.getPropertyValues().getPropertyValueSet()) {
            Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
            declaredField.setAccessible(true);
            declaredField.set(bean, propertyValue.getValue());
        }
    }
}
