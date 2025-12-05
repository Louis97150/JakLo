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

    private static HashMap<Integer, Integer> countRep(int... dices) {
        HashMap<Integer, Integer> count = new HashMap<>();
        if(valid(dices)){
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
        return count;
    }

    private static int maxPair(HashMap<Integer, Integer> count, int x, int... dices) {
        int max = 0;
        for (int i : count.keySet()) {
            if (i > max && count.get(i) >= x) {
                max = i;
            }
        }
        return max;
    }

    public static int pairs(int... dices) {
        HashMap<Integer, Integer> count = countRep(dices);
        return maxPair(count,2, dices) * 2;
    }

    public static int doublePair(int... dices) {
        HashMap<Integer, Integer> count = countRep(dices);
        int x = maxPair(count, 2, dices);
        count.remove(x);
        int y = maxPair(count, 2, dices);

        if (x != 0 && y != 0) {
            return (y + x) * 2;
        }

        return 0;
    }

    public static int threeTest(int... dices){
        HashMap<Integer, Integer> count = countRep(dices);
        int x = maxPair(count, 3, dices);

        return x*3;
    }

    public static int fourTest(int... dices){
        HashMap<Integer, Integer> count = countRep(dices);
        int x = maxPair(count, 4, dices);

        return x*4;
    }

    public static int sum(int ... dices){
        if(valid(dices)){
            int sum = 0;
            for(int i : dices){
                sum += i;
            }
            return sum;
        }

        return 0;
    }

    public static boolean suiteCorrecte(int x, int ... dices){
        if(valid(dices)){
            int comp = x;
            for(int i :dices){
                if( i != comp){
                    return false;
                }
                comp += 1;
            }
            return true;
        }
        return false;
    }

    public static int smallS(int ... dices){
        if(!suiteCorrecte(1, dices)){
            return 0;
        }
        return sum(dices);
    }

    public static int largeS(int ... dices){
        if(!suiteCorrecte(2, dices)){
            return 0;
        }
        return sum(dices);
    }

    public static int fullHouse(int ... dices){
        if(valid(dices)){
            HashMap<Integer, Integer> count = countRep(dices);
            if(count.size()==2 && count.containsValue(2)){
                return sum(dices);
            }
        }
        return 0;
    }

}
