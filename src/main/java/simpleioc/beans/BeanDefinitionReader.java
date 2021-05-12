package simpleioc.beans;

/**
 * Here is the class description
 *
 * @author : liyuanshuo
 * @version : 1.0.0
 * @date : 2021/5/12 16:14
 */
public interface BeanDefinitionReader {
    /**
     * 从文件中读取BeanDefinitions的接口
     *
     * @param location 资源位置
     * @throws Exception IOException
     */
    void loadBeanDefinitions(String location) throws Exception;
}
