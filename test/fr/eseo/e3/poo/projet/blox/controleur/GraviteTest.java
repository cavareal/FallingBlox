package fr.eseo.e3.poo.projet.blox.controleur;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class GraviteTest {
	
	private Gravite gravite;

	
    @BeforeEach
    void setUp() {
        gravite = new Gravite(new VuePuits(new Puits()));
    }
	
    @Test
	void testGetSetPeriodicite() {
		gravite.setPeriodicite(5000);
		int periodicite = gravite.getPeriodicite();
        assertEquals(5000, periodicite);
    }

}

