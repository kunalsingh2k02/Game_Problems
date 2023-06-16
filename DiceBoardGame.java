package Assign;

import java.util.ArrayList;
import java.util.List;

public class DiceBoardGame {
    public static void main(String[] args) {
        int targetSum = 10;
        int numDice = 2;

        int Sum = 8;
        int dice = 2;



        List<String> combinations = findCombinations(targetSum, numDice);
        System.out.println("Possible combinations: " + combinations);

        List<String> combination = findCombinations(Sum, dice);
        System.out.println("Possible combinations: " + combination);


    }

    public static List<String> findCombinations(int targetSum, int numDice) {
        List<String> combinations = new ArrayList<>();
        findCombinationsHelper(targetSum, numDice, "", combinations);
        return combinations;
    }

    public static void findCombinationsHelper(int targetSum, int numDice, String currentCombination, List<String> combinations) {
        if (numDice == 0) {
            if (targetSum == 0) {
                combinations.add(currentCombination);
            }
            return;
        }

        for (int i = 1; i <= 6; i++) {
            if (i <= targetSum) {
                findCombinationsHelper(targetSum - i, numDice - 1, currentCombination + i, combinations);
            }
        }
    }
}





