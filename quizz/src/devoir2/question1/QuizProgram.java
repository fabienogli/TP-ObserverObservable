package devoir2.question1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QuizProgram {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.setProperty("spring.profiles.active", "constructor");

//        ApplicationContext quizz = new ClassPathXmlApplicationContext("devoir2/question1/QuizzBeans.xml");
        ApplicationContext context = new ClassPathXmlApplicationContext("devoir2/question1/BeanFactory.xml");
        QuizzMasterService quizzMasterService = (QuizzMasterService) context.getBean("quizzConstructor");
    }

}
