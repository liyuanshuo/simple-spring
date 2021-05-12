package simpleioc.beans;

import lombok.Data;

/**
 * Here is the class description
 *
 * @author : liyuanshuo
 * @version : 1.0.0
 * @date : 2021/5/12 17:17
 */
@Data
public class BeanReference {

    private String name;

    private Object bean;

    public BeanReference(String name) {
        this.name = name;
    }
}
