package yatzy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class YatzyTest {

    @Test
    public void unValide() {
        assertEquals(YatzyRules.ones(3, 3, 3, 4, 5), 0);
        assertEquals(YatzyRules.fours(1, 1, 2, 4, 4), 8);
        assertEquals(YatzyRules.twos(2, 3, 2, 5, 1), 4);
    }

    @Test
    public void pairValid() {
        assertEquals(YatzyRules.pairs(1, 2, 3, 4, 5), 0);
        assertEquals(YatzyRules.pairs(3, 3, 3, 4, 4), 8);
        assertEquals(YatzyRules.pairs(1, 1, 6, 2, 6), 12);
        assertEquals(YatzyRules.pairs(3, 3, 3, 4, 1), 6);
        assertEquals(YatzyRules.pairs(3, 3, 3, 3, 1), 6);
    }

    @Test
    public void doublPair() {
        assertEquals(YatzyRules.doublePair(1, 1, 2, 3, 3), 8);
        assertEquals(YatzyRules.doublePair(1, 1, 2, 3, 4), 0);
        assertEquals(YatzyRules.doublePair(1, 1, 2, 2, 2), 6);
        assertEquals(YatzyRules.doublePair(3, 3, 3, 3, 1), 0);
    }
}
