package fr.eseo.e3.poo.projet.blox.vue;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JLabel;

import fr.eseo.e3.poo.projet.blox.modele.Tas;

public class PanneauScore extends JLabel implements PropertyChangeListener{

	private static final long serialVersionUID = 1L;
	private Tas tas;
	
	public PanneauScore(Tas tas) {
		this.tas = tas;
		tas.addPropertyChangeListener(this);
		this.setText(String.valueOf(tas.getScore()));
	}
	


	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		
		if(evt.getPropertyName().equals(Tas.MODIFICATION_SCORE)) {			
			this.setText((String) evt.getNewValue());
		}
	}

}
