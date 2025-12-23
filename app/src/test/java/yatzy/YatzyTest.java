package yatzy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class YatzyTest {

    private YatzyRules yatzy;

    public YatzyTest() {
        this.yatzy = new YatzyRules();
    }

    @Test
    public void ones() {
        assertEquals(yatzy.ones(1, 1, 1, 4, 5), 3);
        assertEquals(yatzy.ones(3, 3, 3, 4, 5), 0);
        assertEquals(yatzy.ones(1, 2, 1, 1, 1), 4);
    }

    @Test
    public void twos() {
        assertEquals(yatzy.twos(2, 3, 2, 5, 1), 4);
        assertEquals(yatzy.twos(1, 1, 1, 1, 1), 0);
        assertEquals(yatzy.twos(2, 2, 2, 2, 2), 10);
    }

    @Test
    public void threes() {
        assertEquals(yatzy.threes(3, 3, 3, 4, 5), 9);
        assertEquals(yatzy.threes(1, 2, 4, 5, 6), 0);
        assertEquals(yatzy.threes(3, 3, 1, 2, 6), 6);
    }

    @Test
    public void fours() {
        assertEquals(yatzy.fours(1, 1, 2, 4, 4), 8);
        assertEquals(yatzy.fours(4, 4, 4, 4, 4), 20);
        assertEquals(yatzy.fours(1, 2, 3, 5, 6), 0);
    }

    @Test
    public void fives() {
        assertEquals(yatzy.fives(5, 5, 5, 4, 3), 15);
        assertEquals(yatzy.fives(1, 2, 3, 4, 6), 0);
        assertEquals(yatzy.fives(5, 1, 2, 3, 6), 5);
    }

    @Test
    public void sixes() {
        assertEquals(yatzy.sixes(6, 6, 6, 4, 5), 18);
        assertEquals(yatzy.sixes(1, 2, 3, 4, 5), 0);
        assertEquals(yatzy.sixes(6, 6, 1, 2, 3), 12);
    }

    @Test
    public void pairValid() {
        assertEquals(yatzy.pair(1, 2, 3, 4, 5), 0);
        assertEquals(yatzy.pair(3, 3, 3, 4, 4), 8);
        assertEquals(yatzy.pair(1, 1, 6, 2, 6), 12);
        assertEquals(yatzy.pair(3, 3, 3, 4, 1), 6);
        assertEquals(yatzy.pair(3, 3, 3, 3, 1), 6);
    }

    @Test
    public void doublPair() {
        assertEquals(yatzy.doublePair(1, 1, 2, 3, 3), 8);
        assertEquals(yatzy.doublePair(1, 1, 2, 3, 4), 0);
        assertEquals(yatzy.doublePair(1, 1, 2, 2, 2), 6);
        assertEquals(yatzy.doublePair(3, 3, 3, 3, 1), 0);
    }

    @Test
    public void thirdPair() {
        assertEquals(yatzy.threeOfAKind(3, 3, 3, 4, 5), 9);
        assertEquals(yatzy.threeOfAKind(3, 3, 4, 5, 6), 0);
        assertEquals(yatzy.threeOfAKind(3, 3, 3, 3, 1), 9);
    }

    @Test
    public void forthPair() {
        assertEquals(yatzy.fourOfAKind(2, 2, 2, 2, 5), 8);
        assertEquals(yatzy.fourOfAKind(2, 2, 2, 5, 5), 0);
        assertEquals(yatzy.fourOfAKind(2, 2, 2, 2, 2), 8);
    }

    @Test
    public void smallS() {
        assertEquals(yatzy.smallStraight(1, 2, 3, 4, 5), 15);
    }

    @Test
    public void largeS() {
        assertEquals(yatzy.largeStraight(2, 3, 4, 5, 6), 20);
    }

    @Test
    public void house() {
        assertEquals(yatzy.fullHouse(1, 1, 2, 2, 2), 8);
        assertEquals(yatzy.fullHouse(2, 2, 3, 3, 4), 0);
        assertEquals(yatzy.fullHouse(4, 4, 4, 4, 4), 0);
        assertEquals(yatzy.fullHouse(4, 4, 4, 4, 2), 0);
        assertEquals(yatzy.fullHouse(6, 6, 6, 5, 5), 28);
    }

    @Test
    public void yatzy() {
        assertEquals(yatzy.ones(1, 1, 1, 1, 1), 5);
        assertEquals(yatzy.fours(4, 4, 4, 4, 4), 20);
        assertEquals(yatzy.sixes(6, 6, 6, 6, 6), 30);
    }

    @Test
    public void invalidDiceCount() {
        assertThrows(IllegalArgumentException.class, () -> {
            yatzy.ones(1, 2, 3, 4);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            yatzy.ones(1, 2, 3, 4, 5, 6);
        });
    }

    @Test
    public void invalidDiceValues() {
        assertThrows(IllegalArgumentException.class, () -> {
            yatzy.ones(0, 1, 2, 3, 4);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            yatzy.ones(1, 2, 3, 4, 7);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            yatzy.ones(1, 2, 3, 4, -1);
        });
    }

    @Test
    public void pairEdgeCases() {
        assertEquals(yatzy.pair(6, 6, 6, 6, 6), 12);
        assertEquals(yatzy.pair(2, 2, 1, 1, 3), 4);
        assertEquals(yatzy.pair(1, 2, 3, 4, 5), 0);
    }

    @Test
    public void doublePairEdgeCases() {
        assertEquals(yatzy.doublePair(1, 1, 2, 2, 3), 6);
        assertEquals(yatzy.doublePair(5, 5, 6, 6, 4), 22);
    }

    @Test
    public void straightEdgeCases() {
        assertEquals(yatzy.smallStraight(1, 2, 3, 4, 5), 15);
        assertEquals(yatzy.largeStraight(2, 3, 4, 5, 6), 20);
        assertEquals(yatzy.smallStraight(1, 3, 2, 5, 4), 0);
        assertEquals(yatzy.largeStraight(1, 2, 3, 4, 5), 0);
    }
}
