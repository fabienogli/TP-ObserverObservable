import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QuizProgram {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.setProperty("spring.profiles.active", "constructor");

        ApplicationContext context = new ClassPathXmlApplicationContext("BeanFactory.xml");
        QuizzMasterService quizzMasterService = (QuizzMasterService) context.getBean("quizzConstructor");
    }

}
