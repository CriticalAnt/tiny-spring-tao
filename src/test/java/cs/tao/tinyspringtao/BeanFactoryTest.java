package cs.tao.tinyspringtao;

import cs.tao.tinyspringtao.factory.AbstractBeanFactory;
import cs.tao.tinyspringtao.factory.AutowireCapableBeanFactory;
import cs.tao.tinyspringtao.io.ResourceLoader;
import cs.tao.tinyspringtao.xml.XmlBeanDefinitionReader;
import org.junit.Test;

import java.util.Map;


public class BeanFactoryTest {

    @Test
    public void test() throws Exception {

        // 1.读取配置
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc.xml");

        // 2.初始化BeanFactory并注册bean
        AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }

        // 3.初始化bean
//        beanFactory.preInstantiateSingletons();

        // 4.获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}
