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

            /* 通过Field注入，Spring内部实际采用的是Set方法注入*/
            Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
            declaredField.setAccessible(true);
            declaredField.set(bean, propertyValue.getValue());

            /*

              通过Set方法注入

             try {
             BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
             PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
             for (PropertyDescriptor descriptor : propertyDescriptors) {
             Object convertObject = TypeConverter.convertObject(descriptor.getPropertyType(), propertyValue.getValue());
             descriptor.getWriteMethod().invoke(bean, convertObject);
             }
             } catch (Exception e) {
             e.printStackTrace();
             }
             */
        }


    }
}
