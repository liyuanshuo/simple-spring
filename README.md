# simple-spring

spring的基本原理

# 第一部分 IOC容器部分

## 1. tag-1-最基本的容器

代码检出： `git checkout tag-1-container-register-and-get`

IoC最基本的角色有两个：容器(`BeanFactory`)和Bean本身。这里使用`BeanDefinition`来封装了bean对象，这样可以保存一些额外的元信息

## 2. tag-2-将bean创建放入工厂

代码检出： `git checkout tag-2-abstract-beanfactory-and-do-bean-initilizing`

step1中的bean是初始化好之后再set进去的，实际使用中，希望容器来管理bean的创建。于是将bean的初始化放入BeanFactory中。为了保证扩展性，使用Extract Interface的方法，将`BeanFactory`
替换成接口，而使用`AbstractBeanFactory`和`AutowireCapableBeanFactory`作为其实现。"AutowireCapable"的意思是“可自动装配的”，为后面注入属性做准备。

## 3. tag-3-inject-bean-with-property

代码检出： `git checkout tag-3-inject-bean-with-property`

想要为bean注入属性。选择将属性注入信息保存成`PropertyValue`对象，并且保存到`BeanDefinition`
中。这样在初始化bean的时候，可以根据PropertyValue来进行bean属性的注入。Spring本身使用了setter来进行注入，这里使用Field的形式来注入。

## 4. tag-4-读取xml配置来初始化bean

代码检出： `git checkout tag-4-config-beanfactory-with-xml`

## 5. tag-5-为Bean注入Bean

代码检出 `git checkout tag-5-inject-bean-to-bean`

## 6. tag-6-ApplicationContext

代码检出：`git checkout tag-6-invite-application-context`

`BeanFactory`的功能齐全了，但是使用起来有点麻烦。引入熟悉的`ApplicationContext`接口，并在`AbstractApplicationContext`的`refresh()`方法中进行bean的初始化工作。

# 第二部分 AOP部分

AOP分为配置(Pointcut，Advice)，织入(Weave)两部分工作，当然还有一部分是将AOP整合到整个容器的生命周期中。、

## 7. tag-7-使用JDK动态代理实现AOP织入

代码检出：`git checkout tag-7-method-interceptor-by-jdk-dynamic-proxy`

织入（weave）相对简单, Spring AOP的织入点是`AOPProxy`，它包含一个方法`Object getProxy()`来获取代理后的对象

在Spring AOP中，两个很重要的角色`MethodInterceptor`和`MethodInvocation`（这两个角色是AOP联盟标准），它们对应AOP中的两个基本角色`Advice`和`Joinpoint`。`Advice`
定义了在切点指定的逻辑，而`Joinpoint`则代表切点


