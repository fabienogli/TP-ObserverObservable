import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class QuizzMasterService {
	private JFrame ecran;
	private JRadioButton [] lesBoutons;
	private QuizzMaster quizMaster;

	public QuizzMasterService()
	{
		this.ecran = new JFrame();
        lesBoutons = new JRadioButton [4];
        this.ecran.setSize( 450, 200 );
		// Fermeture de la fen�tre
		this.ecran.addWindowListener( new WindowAdapter() {
		public void windowClosing( WindowEvent we ) {
			QuizzMasterService.this.terminer();
		}
		} );
	}

    public QuizzMasterService(QuizzMaster quizzMaster) {
        this();
	    this.setQuizMaster(quizzMaster);
    }

    private void setPanneaux() {
        JPanel panneauCentral = new JPanel( new BorderLayout() );
        JPanel panneauChoix = new JPanel( new FlowLayout( FlowLayout.LEFT ) );
        // Le panneau central
        ecran.add( panneauCentral );
        JPanel panneauQuestion = getPanneauQuestion();
        listenerButton(getActionListener(), panneauChoix);
        panneauCentral.add( panneauChoix, BorderLayout.CENTER);
        panneauCentral.add( panneauQuestion, BorderLayout.NORTH);
    }

    private JPanel getPanneauQuestion() {
        JPanel panneauQuestion= new JPanel( new FlowLayout( FlowLayout.LEADING ) );
        panneauQuestion.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder()));
        JLabel monlabel = config();
        panneauQuestion.add(monlabel);
        return panneauQuestion;
    }

    private void listenerButton(ActionListener listener, JPanel panneauChoix) {
        ButtonGroup groupe = new ButtonGroup ();
        for(int i=0; i<4; i++)
        {
            lesBoutons[i] = new JRadioButton (quizMaster.getChoix(i));
            groupe.add(lesBoutons[i]);
            panneauChoix.add(lesBoutons[i]);
            lesBoutons[i].addActionListener(listener);
        }
    }

    private ActionListener getActionListener() {
        return new ActionListener() {
                 public void actionPerformed (ActionEvent e) {
                     AbstractButton aButton = (AbstractButton) e.getSource();
                     String message=aButton.getText();
                     if(message.equals(quizMaster.getChoix(quizMaster.getReponse())))
                         JOptionPane.showMessageDialog( ecran, "bonne r�ponse" );
                     else
                         JOptionPane.showMessageDialog( ecran, "mauvaise r�ponse" );

                 };
              };
    }

    private JLabel config() {
        //return label
        JLabel monlabel=new JLabel(quizMaster.getQuestion());
        return monlabel;
    }
	private void terminer() {
		this.ecran.dispose();			
		System.exit( 0 );
	}

    public void setQuizMaster(QuizzMaster quizzMaster) {
	    this.quizMaster = quizzMaster;
        setPanneaux();
        //setTitle
        this.ecran.setTitle(quizMaster.getType());
        this.ecran.setVisible( true );

    }
}
