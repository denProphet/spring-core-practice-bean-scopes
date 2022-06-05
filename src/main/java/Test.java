import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        Test test = new Test();
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        test.testPrototypeScope(context);
        test.testSingletonScope(context);
    }

    /**
     * Testing bean scope: prototype type
     * Every new getBean() method invocation creates new Cat instance
     * result: objects have different states
     * */

    public void testPrototypeScope(ClassPathXmlApplicationContext context) {

        Cat cat1 = context.getBean("cat", Cat.class);
        Cat cat2 = context.getBean("cat", Cat.class);
        Cat cat3 = context.getBean("cat", Cat.class);

        cat1.setName("Monya");
        cat2.setName("Bonya");
        cat3.setName("Peach");

        for (Cat cat : Arrays.asList(cat1, cat2, cat3)) {
            System.out.println(" {");
            cat.showCatInfo();
            System.out.println(" }");
        }
    }

    /**
     * Testing bean scope: singleton type
     * Every new getBean() method invocation references to the same Zoo object
     * result: objects have equal states
     * */

    public void testSingletonScope(ClassPathXmlApplicationContext context) {

        Zoo zoo1 = context.getBean("zoo", Zoo.class);
        Zoo zoo2 = context.getBean("zoo", Zoo.class);
        Zoo zoo3 = context.getBean("zoo", Zoo.class);

        zoo1.setName("West zoo");
        zoo2.setName("East zoo");
        zoo3.setName("Meredian zoo");

        for (Zoo zoo : Arrays.asList(zoo1, zoo2, zoo3)) {
            System.out.println(" {");
            System.out.println(zoo.getName());
            System.out.println(" }");
        }
    }
}
