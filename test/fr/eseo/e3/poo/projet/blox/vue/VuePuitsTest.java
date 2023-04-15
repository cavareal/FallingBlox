package fr.eseo.e3.poo.projet.blox.vue;


import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import fr.eseo.e3.poo.projet.blox.modele.Puits;

public class VuePuitsTest {

	
    private VuePuits vuePuits;
    private Puits puits;

    @BeforeEach
    // méthode exécutée avant chaque méthode de test
    void setUp() /*throws Exception*/ {
        puits = new Puits(10, 20);
        vuePuits = new VuePuits(puits);
    }

    @Test
    void testConstructeurAvecUnSeulParametre() {
        assertNotNull(vuePuits);
        assertEquals(puits, vuePuits.getPuits(),"puits différents");
        assertEquals(VuePuits.TAILLE_PAR_DEFAUT, vuePuits.getTaille(),"tailles différentes");
    }

    @Test
    void testConstructeurAvecDeuxParametres() {
        int taille = 30;
        vuePuits = new VuePuits(puits, taille);
        
        assertNotNull(vuePuits);
        assertEquals(puits, vuePuits.getPuits(),"puits différents");
        assertEquals(taille, vuePuits.getTaille(),"tailles différentes");
    }

    @Test
    void testSetPuits() {
        Puits newPuits = new Puits(15, 25);
        vuePuits.setPuits(newPuits);
        
        assertEquals(newPuits, vuePuits.getPuits(),"puits différents");
    }

    @Test
    void testSetTaille() {
        int nouvelleTaille = 25;
        vuePuits.setTaille(nouvelleTaille);
        
        assertEquals(nouvelleTaille, vuePuits.getTaille(),"tailles différentes");
    }
	

}
