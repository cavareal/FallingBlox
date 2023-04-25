package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BloxExceptionTest {

    @Test
    public void testGetType() {
        BloxException exception = new BloxException("Une collision s'est produite", BloxException.BLOX_COLLISION);
        assertEquals(BloxException.BLOX_COLLISION, exception.getType());
    }

    @Test
    public void testGetMessage() {
        BloxException exception = new BloxException("Une collision s'est produite", BloxException.BLOX_COLLISION);
        assertEquals("Une collision s'est produite", exception.getMessage());
    }
}
