package devoir2.question1;

public class UMLQuizz implements QuizzMaster {
	private String type;
	private String question;
    private String [] choix;
    private int reponse;

    public UMLQuizz ()
    {
    	type="Question sur UML";
    	choix = new String [4];
    	question = "Parmi les diagrammes suivants, lequel a été introduit dans UML2 ?";
    	choix[0] = "Diagramme d'activité";
    	choix[1] = "Diagramme de Classes";
    	choix[2] = "Diagramme de Temps";
    	choix[3] = "Diagramme des cas d'utilisation";
    	reponse = 2;
     }

	@Override
	public String getChoix(int indice) {
		// TODO Auto-generated method stub
		return choix[indice];
	}

	@Override
	public String getQuestion() {
		// TODO Auto-generated method stub
		return question;
	}

	@Override
	public int getReponse() {
		// TODO Auto-generated method stub
		return (reponse);
	}
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}

}
