package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import fr.eseo.e3.poo.projet.blox.modele.Observateur;

public class JeuAffichage extends JFrame implements Observateur,
													ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private static JLabel scoreLabel;
    
    private VuePuits vuePuits;
    private PanneauInformation panneauInfo;
    
    public JeuAffichage(VuePuits vuePuits, PanneauInformation panneauInfo) {
        this.vuePuits = vuePuits;
        this.panneauInfo = panneauInfo;
        init();
    }
    
    private void init() {
    	this.setTitle("Falling Blox");
    	
    	//PANNEAU LATERAL 
        JLabel label = new JLabel("Score :");
        scoreLabel = new JLabel(String.valueOf(panneauInfo.getScore()));
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(panneauInfo);
        panel.add(label);
        panel.add(scoreLabel);
        
        //MENU
        JMenuBar myMenuBar = new JMenuBar();
        JPanel panelMenu = new JPanel();
        panelMenu.add(myMenuBar);
        JMenu menuSettings = new JMenu("Settings");
        myMenuBar.add(menuSettings);
		JMenuItem menuPause = new JMenuItem("Pause");
		JMenuItem menuRestart = new JMenuItem ("Restart");
		menuSettings.add(menuPause);
		menuSettings.add(menuRestart);
		
		//ACTIONS LIEES AU MENU
		menuPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vuePuits.getGravite().stopTimer();
			}
		});
		menuRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vuePuits.getGravite().restartTimer();
			}
		});

        
		// ADD INTERFACE 
        getContentPane().add(vuePuits);
        add(vuePuits, BorderLayout.CENTER);
        add(panel, BorderLayout.EAST);
        add(panelMenu,BorderLayout.NORTH);
        
        pack();
        setLocationRelativeTo(null);
    }
    
   
    public void actualiser(int score) {
        scoreLabel.setText(String.valueOf(score));
    }
    
    public static void majScoreLabel(int score) {
        scoreLabel.setText(Integer.toString(score));
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
