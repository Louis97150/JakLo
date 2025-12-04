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

    @Test
    public void thirdPair(){
        assertEquals(YatzyRules.threeTest(3,3,3,4,5), 9);
        assertEquals(YatzyRules.threeTest(3,3,4,5,6), 0);
        assertEquals(YatzyRules.threeTest(3,3,3,3,1), 9);
    }

    @Test
    public void forthPair(){
        assertEquals(YatzyRules.fourTest(2,2,2,2,5), 8);
        assertEquals(YatzyRules.fourTest(2,2,2,5,5), 0);
        assertEquals(YatzyRules.fourTest(2,2,2,2,2), 8);
    }

    @Test
    public void somme(){
        assertEquals(YatzyRules.sum(1,2,3,4,5), 15);
        assertEquals(YatzyRules.sum(2,3,4,5,6), 20);
    }

    @Test
    public void house(){
        assertEquals(YatzyRules.fullHouse(1,1,2,2,2), 8);
        assertEquals(YatzyRules.fullHouse(2,2,3,3,4), 0);
        assertEquals(YatzyRules.fullHouse(4,4,4,4,4), 0);
    }
}
