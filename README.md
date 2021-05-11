# simple-spring

spring的基本原理

## 1. tag-1-最基本的容器

代码检出： `git checkout tag-1-container-register-and-get`

IoC最基本的角色有两个：容器(`BeanFactory`)和Bean本身。这里使用`BeanDefinition`来封装了bean对象，这样可以保存一些额外的元信息

## 2. tag-2-将bean创建放入工厂

代码检出： `git checkout `

step1中的bean是初始化好之后再set进去的，实际使用中，希望容器来管理bean的创建。于是将bean的初始化放入BeanFactory中。为了保证扩展性，使用Extract Interface的方法，将`BeanFactory`
替换成接口，而使用`AbstractBeanFactory`和`AutowireCapableBeanFactory`作为其实现。"AutowireCapable"的意思是“可自动装配的”，为后面注入属性做准备。
