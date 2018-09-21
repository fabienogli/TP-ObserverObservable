package devoir2.question1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@Component
public class QuizzMasterService {
	private JFrame ecran;
	private JRadioButton [] lesBoutons;
	private QuizzMaster quizMaster;

	@Autowired
	public QuizzMasterService(QuizzMaster quizzMaster)
	{
	    this.quizMaster = quizzMaster;
		this.ecran = new JFrame();
		lesBoutons = new JRadioButton [4];
		ecran.setSize( 450, 200 );
		this.ecran.setTitle(quizMaster.getType());
		// Fermeture de la fen�tre
		ecran.addWindowListener( new WindowAdapter() {
		public void windowClosing( WindowEvent we ) {
			QuizzMasterService.this.terminer();
		}
		} );
		// Le panneau central
		JPanel panneauCentral = new JPanel( new BorderLayout() );
		ecran.add( panneauCentral );
		ActionListener listener = new ActionListener() {
	         public void actionPerformed (ActionEvent e) {
	        	 AbstractButton aButton = (AbstractButton) e.getSource();
	        	 String message=aButton.getText();
	        	 if(message.equals(quizMaster.getChoix(quizMaster.getReponse())))
	        		 JOptionPane.showMessageDialog( ecran, "bonne r�ponse" );
	        	 else
	        		 JOptionPane.showMessageDialog( ecran, "mauvaise r�ponse" );         
	        	 
	         };
	      };
		JPanel panneauQuestion= new JPanel( new FlowLayout( FlowLayout.LEADING ) );
		panneauQuestion.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder()));
		JLabel monlabel=new JLabel(quizMaster.getQuestion());
		panneauQuestion.add(monlabel);
		panneauCentral.add( panneauQuestion, BorderLayout.NORTH );
		JPanel panneauChoix = new JPanel( new FlowLayout( FlowLayout.LEFT ) );
		ButtonGroup groupe = new ButtonGroup ();
		for(int i=0; i<4; i++)
		{
			lesBoutons[i] = new JRadioButton (quizMaster.getChoix(i));
			groupe.add(lesBoutons[i]);
			panneauChoix.add(lesBoutons[i]);
			lesBoutons[i].addActionListener(listener);
		}
		panneauCentral.add( panneauChoix, BorderLayout.CENTER);
		ecran.setVisible( true );
	}
	private void terminer() {
		
		this.ecran.dispose();			
		System.exit( 0 );
	}
}
