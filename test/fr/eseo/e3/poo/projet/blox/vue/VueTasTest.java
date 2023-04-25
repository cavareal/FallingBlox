package fr.eseo.e3.poo.projet.blox.vue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.Puits;

public class VueTasTest {
	
	@Test
	public void testNuance() {
		VueTas vueTas = new VueTas(new VuePuits(new Puits()));
		Color couleur = new Color(255, 0, 0); // Rouge
		Color nuanceCouleur = vueTas.nuance(couleur);
		assertNotNull(nuanceCouleur);
		assertEquals(new Color(153, 0, 0), nuanceCouleur); // Vérifie que la nuance est correcte
	}
}
