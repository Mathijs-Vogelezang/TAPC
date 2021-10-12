import TAPC.Greetings;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetingsTest {
    @Test
    public void testInput1() {
        String input = "hey";
        assertEquals("heey", Greetings.heyGen(input));
    }

    @Test
    public void testSample2() {
        String input = "heeeeey";
        assertEquals("heeeeeeeeeey", Greetings.heyGen(input));
    }

    @Test
    public void testMax() {
        String input = "h" + "e".repeat(1000) + "y";
        assertEquals(input, Greetings.heyGen(input));
    }
}
