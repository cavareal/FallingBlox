package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
    private static int meilleurScore;
    
    public JeuAffichage(VuePuits vuePuits, PanneauInformation panneauInfo) {
        this.vuePuits = vuePuits;
        this.panneauInfo = panneauInfo;
        init();
    }
    
    private void init() {
    	this.setTitle("Falling Blox");
    	
    	//PANNEAU LATERAL 
        JLabel label = new JLabel("Score :");
        JLabel labelMeilleurScore = new JLabel("Meilleur Score :");
        scoreLabel = new JLabel(String.valueOf(panneauInfo.getScore()));
        JPanel panel = new JPanel();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("meilleur_score.txt"));
            String ligne = reader.readLine();
            if(ligne != null) {
            	meilleurScore = Integer.parseInt(ligne);
            }
            reader.close();
        } catch (IOException e) {
            // Si le fichier n'existe pas ou s'il y a une erreur de lecture, on utilise le score initial de 0
        }
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(panneauInfo);
        panel.add(labelMeilleurScore);
        panel.add(new JLabel(String.valueOf(meilleurScore)));
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
        if (score > meilleurScore) {
            meilleurScore = score;
            // Écriture de la nouvelle valeur du meilleur score dans le fichier
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("meilleur_score.txt"));
                writer.write(Integer.toString(meilleurScore));
                writer.close();
            } catch (IOException e) {
                // Gestion de l'erreur d'écriture dans le fichier
            }
        }
        
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public VuePuits getVuePuits() {
		return this.vuePuits;
	}

	
}
