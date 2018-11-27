package cs.tao.tinyspringtao;

import cs.tao.tinyspringtao.context.ApplicationContext;
import cs.tao.tinyspringtao.context.ClassPathXmlApplicationContext;
import org.junit.Test;


public class BeanFactoryTest {

    @Test
    public void test() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("tinyioc.xml");
        HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}
