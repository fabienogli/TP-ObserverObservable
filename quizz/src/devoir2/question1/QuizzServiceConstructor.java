package devoir2.question1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("devoir2.question1")
public class QuizzServiceConstructor {

    @Bean
    public QuizzMaster quizzMaster() {
        QuizzMaster quizz = new UMLQuizz();
        return quizz;
    }
}
