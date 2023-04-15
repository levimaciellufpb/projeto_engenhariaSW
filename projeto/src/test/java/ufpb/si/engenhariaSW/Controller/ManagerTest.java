package ufpb.si.engenhariaSW.Controller;

import junit.framework.TestCase;
import ufpb.si.engenhariaSW.Model.Usuario;

public class ManagerTest extends TestCase {
    Manager test = new Manager();

    public void testAddUsuario() {
        assertTrue(test.getUsuarios().isEmpty());
        Usuario testUser = new Usuario("test@gmail.com", "ILoveTests", "T3ST");
        test.addUsuario(testUser);
        assertFalse(test.getUsuarios().isEmpty());
        assertEquals(testUser, test.getUsuarios().get("T3ST"));

    }

    public void testRemoverUsuario() {
        Usuario testUser = new Usuario("test@gmail.com", "ILoveTests", "T3ST");
        test.addUsuario(testUser);
        Usuario testUser2 = test.removerUsuario("noTests");
        assertNull(testUser2);
        assertEquals(testUser, test.removerUsuario("T3ST"));
    }


}