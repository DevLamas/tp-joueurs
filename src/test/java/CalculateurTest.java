import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.logging.*;

import static org.junit.Assert.assertEquals;

public class CalculateurTest {

    @Mock
    Calculateur calculateur;
    static Logger logger = Logger.getLogger(CalculateurTest.class.getName());



    @Test
    public void multiple(String parameter) {

        Calculateur tester = Mockito.mock(Calculateur.class); // MyClass is tested

        // assert statements
        assertEquals(0, tester.multiplyV2(10, 2));
        Mockito.when(tester.multiplyV2(10,2)).thenReturn(20);
        assertEquals(tester.multiplyV2(10,2), 20);
    }

    @Test
    public void additionner() {
        Calculateur testerDiv = Mockito.mock(Calculateur.class);// MyClass is tested

        // assert statements
        assertEquals(0, testerDiv.add(10, 2));
        Mockito.when(testerDiv.add(10,2)).thenReturn(12);
        Assert.assertEquals(testerDiv.add(10,2), 12);
    }
}
