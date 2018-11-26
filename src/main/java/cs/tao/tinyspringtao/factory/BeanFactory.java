package cs.tao.tinyspringtao.factory;

import cs.tao.tinyspringtao.BeanDefinition;

public interface BeanFactory {

    Object getBean(String name) throws Exception;

    void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception;
}
