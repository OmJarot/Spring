package spring_dasar.Configuration.BeanFactoryPostProsessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;
import spring_dasar.Data.Foo;

@Component
public class FooBeanFactoryPostProsessor implements BeanDefinitionRegistryPostProcessor {
    //membuat bean secara programmatic

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        //membuat bean
        GenericBeanDefinition definition = new GenericBeanDefinition();
        definition.setScope("singleton");
        definition.setBeanClass(Foo.class);//set class beannya

        registry.registerBeanDefinition("foo",definition);//registry dan set nama
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        //nothing
    }

}
