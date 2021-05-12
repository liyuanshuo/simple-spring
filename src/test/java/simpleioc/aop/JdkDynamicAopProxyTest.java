package simpleioc.aop;

import org.junit.jupiter.api.Test;
import simpleioc.HelloWordService;
import simpleioc.HelloWordServiceImpl;
import simpleioc.context.ApplicationContext;
import simpleioc.context.ClassPathXmlApplicationContext;

/**
 * Here is the class description
 *
 * @author : liyuanshuo
 * @version : 1.0.0
 * @date : 2021/5/12 21:13
 */
class JdkDynamicAopProxyTest {

    @Test
    public void interceptorTest() throws Exception {

        /* 不使用AOP的用法*/
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("simpleioc.xml");
        HelloWordService helloWordService = (HelloWordService) applicationContext.getBean("helloWordService");
        helloWordService.helloWord();

        /* 使用AOP */
        /* 1. 设置被代理的对象，Joinpoint */
        AdvisedSupport advisedSupport = new AdvisedSupport();
        TargetSource targetSource = new TargetSource(HelloWordService.class, helloWordService);
        advisedSupport.setTargetSource(targetSource);

        /* 2. 设置拦截器Advice*/
        TimerInterceptor interceptor = new TimerInterceptor();
        advisedSupport.setMethodInterceptor(interceptor);

        /* 3. 创建代理Proxy */
        JdkDynamicAopProxy proxy = new JdkDynamicAopProxy(advisedSupport);
        HelloWordService serviceProxy = (HelloWordService) proxy.getProxy();

        /* 4. 基于AOP的调用 */
        serviceProxy.helloWord();


    }
}
