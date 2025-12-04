package yatzy;

import java.util.HashMap;

public class YatzyRules {

    public static boolean valid(int... dice) {
        if (dice.length != 5) {
            return false;
        }

        for (int des : dice) {
            if (des < 1 || des > 6) {
                return false;
            }
        }

        return true;
    }

    private static int numbers(int number, int... dices) {
        boolean valide = valid(dices);

        if (valide) {
            int total = 0;
            for (int i : dices) {
                total += i == number ? 1 : 0;
            }
            return total * number;
        }

        return -1;
    }

    public static int ones(int... dices) {
        return numbers(1, dices);
    }

    public static int twos(int... dices) {
        return numbers(2, dices);
    }

    public static int threes(int... dices) {
        return numbers(3, dices);
    }

    public static int fours(int... dices) {
        return numbers(4, dices);
    }

    public static int fives(int... dices) {
        return numbers(5, dices);
    }

    public static int sixes(int... dices) {
        return numbers(6, dices);
    }

    private static HashMap<Integer, Integer> count(int... dices) {
        HashMap<Integer, Integer> count = new HashMap<>();

        for (int i : dices) {
            if (count.containsKey(i)) {
                count.put(i, count.get(i) + 1);
            }

            else {
                count.put(i, 1);
            }
        }

        return count;
    }

    private static int maxPair(HashMap<Integer, Integer> count, int... dices) {
        int max = 0;
        for (int i : count.keySet()) {
            if (i > max && count.get(i) >= 2) {
                max = i;
            }
        }
        return max;
    }

    public static int pairs(int... dices) {
        HashMap<Integer, Integer> count = count(dices);
        return maxPair(count, dices) * 2;
    }

    public static int doublePair(int... dices) {
        HashMap<Integer, Integer> count = count(dices);
        int x = maxPair(count, dices);
        count.remove(x);
        int y = maxPair(count, dices);

        if (x != 0 && y != 0) {
            return (y + x) * 2;
        }

        return 0;
    }

}
