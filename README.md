# spring-bean-life-cycle

#### Module Description
This module explains the spring bean life cycle

When the spring container starts - Spring beans are needed to be instantiated and when the bean is no longer required, it will be removed from the IOC container.

***The spring bean factory is responsible for managing the life cycle of beans created through spring container***
To manipulate the bean creation and destruction, The bean factory provides callback methods
    - _Post-Initialization_ method
    - _Pre-Destroy_ method

![alt the spring bean life cycle](https://github.com/parmarakhil/spring-bean-life-cycle/blob/main/src/main/resources/templates/spring-bean-life-cycle.jpg)

#### Ways of calling the callback methods
1) Using interfaces
    - The ***AfterPropertiesSet*** method of **InitializingBean interface** can be used to implement custom logic _post initialization_ of bean
    - The ***Destroy*** method of **DisposableBean interface** can be used to implement custom logic _before the bean is destroyed_
2) Using XML configuration
    - The ***init-method*** attribute can be used to specify the _init method_
    - The ***destroy-method*** attribute can be used to specify the _destroy method_
    **Note**: The above attributes are used at _local (each bean tag) level_.
            If you want to have default methods for you _entire application beans_ you can use ***default-init-method and default-destroy-method***
3) Using annotations
    - The **@PostConstruct** annotation can be used to specify the _init method_.
    - The **@PreDestroy** annotation can be used to specify the _destroy method_.
    **Note:** To enable these annotations you either need to add ***<context:annotation-config/>*** tag or 
                ***<bean class="org.springframework.context.annotation.CommonAnnotationBeanPostProcessor"></bean>*** tag

![alt callback methods](https://github.com/parmarakhil/spring-bean-life-cycle/blob/main/src/main/resources/templates/callbackMethods.jpg)