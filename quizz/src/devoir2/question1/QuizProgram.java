package devoir2.question1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class QuizProgram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext context = new AnnotationConfigApplicationContext(QuizzServiceConstructor.class);
		QuizzMasterService quizMasterService = context.getBean(QuizzMasterService.class);
	}

}
