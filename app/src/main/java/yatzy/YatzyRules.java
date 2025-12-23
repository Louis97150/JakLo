package yatzy;

import java.util.HashMap;

public class YatzyRules {

    public int ones(int... dices) {
        return numbers(1, dices);
    }

    public int twos(int... dices) {
        return numbers(2, dices);
    }

    public int threes(int... dices) {
        return numbers(3, dices);
    }

    public int fours(int... dices) {
        return numbers(4, dices);
    }

    public int fives(int... dices) {
        return numbers(5, dices);
    }

    public int sixes(int... dices) {
        return numbers(6, dices);
    }

    public int pair(int... dices) {
        return xOfAKind(2, dices);
    }

    public int doublePair(int... dices) {
        if (!valid(dices)) {
            throw new IllegalArgumentException();
        }
        HashMap<Integer, Integer> count = countRep(dices);
        int x = maxRepeatedValue(count, 2);
        count.remove(x);
        int y = maxRepeatedValue(count, 2);
        if (y != 0 && x != 0) {
            return (y + x) * 2;
        }
        return 0;
    }

    public int threeOfAKind(int... dices) {
        return xOfAKind(3, dices);
    }

    public int fourOfAKind(int... dices) {
        return xOfAKind(4, dices);
    }

    public int smallStraight(int... dices) {
        return straight(1, dices);
    }

    public int largeStraight(int... dices) {
        return straight(2, dices);
    }

    public int fullHouse(int... dices) {
        if (!valid(dices)) {
            throw new IllegalArgumentException();
        }
        HashMap<Integer, Integer> count = countRep(dices);
        if (count.size() == 2 && count.containsValue(2) && count.containsValue(3)) {
            return sum(dices);
        }
        return 0;
    }

    private int straight(int startingNumber, int... dices) {
        if (!valid(dices)) {
            throw new IllegalArgumentException();
        }
        int comp = startingNumber;
        for (int i : dices) {
            if (i != comp) {
                return 0;
            }
            comp += 1;
        }
        return sum(dices);
    }

    private int sum(int... dices) {
        int sum = 0;
        for (int i : dices) {
            sum += i;
        }
        return sum;
    }

    private int xOfAKind(int x, int... dices) {
        if (!valid(dices)) {
            throw new IllegalArgumentException();
        }
        HashMap<Integer, Integer> count = countRep(dices);
        return maxRepeatedValue(count, x) * x;
    }

    private int maxRepeatedValue(HashMap<Integer, Integer> count, int x) {
        int max = 0;
        for (int i : count.keySet()) {
            if (i > max && count.get(i) >= x) {
                max = i;
            }
        }
        return max;
    }

    private int numbers(int number, int... dices) {
        if (!valid(dices)) {
            throw new IllegalArgumentException();
        }
        int total = 0;
        for (int i : dices) {
            total += i == number ? number : 0;
        }
        return total;
    }

    private HashMap<Integer, Integer> countRep(int... dices) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int dice : dices) {
            int currentCount = count.getOrDefault(dice, 0);
            count.put(dice, currentCount + 1);
        }
        return count;
    }

    private boolean valid(int... dices) {
        if (dices.length != 5) {
            return false;
        }

        for (int dice : dices) {
            if (dice < 1 || dice > 6) {
                return false;
            }
        }

        return true;
    }
}
