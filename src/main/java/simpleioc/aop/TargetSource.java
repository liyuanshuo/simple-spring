package simpleioc.aop;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 被代理的对象，封装了一层，方便获取被代理对象的Class
 *
 * @author : liyuanshuo
 * @version : 1.0.0
 * @date : 2021/5/12 21:01
 */
@Data
@AllArgsConstructor
public class TargetSource {

    private Class<?> targetClass;

    private Object target;
}
