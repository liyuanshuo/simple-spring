package simpleioc.aop;

import lombok.Data;
import org.aopalliance.intercept.MethodInterceptor;

/**
 * 代理相关的元数据
 *
 * @author : liyuanshuo
 * @version : 1.0.0
 * @date : 2021/5/12 21:02
 */
@Data
public class AdvisedSupport {

    private TargetSource targetSource;

    private MethodInterceptor methodInterceptor;


}
