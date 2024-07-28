package quiz_bkp.complex;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//public class TylerSalesmanProblem {
//
//    public static void main(String[] args) {
//
//        int totalStates = 6;
//        int statesPerCountry = 3;
//        int months = 6;
//
//        List<Integer> travelCostsPerState = Arrays.asList(2, 3, 1, 4, 1, 2);
//
//        Result result = computeTravellerPositions(totalStates, statesPerCountry, months, travelCostsPerState);
//
//        System.out.println("result = " + result);
//
//    }
//
//    public static Result computeTravellerPositions(int s, int fs, int m, List<Integer> r) {
//        int numCountries = s / fs;
//        int remainingMonths = m;
//        int currentCountry = 0;
//
//        // Create a list to store the ratings for each state
//        List<Integer> ratings = new ArrayList<>(r);
//        Collections.sort(ratings); // Sort ratings to start from the lowest
//
//        // Travel through the countries and states
//        while (currentCountry < numCountries && remainingMonths > fs) {
//            remainingMonths -= fs; // Deduct months traveled in current country
//            currentCountry++; // Move to the next country
//        }
//
//        // Calculate the final state within the current country
//        int finalCountry = currentCountry + 1; // Country numbering starts from 1
//        int finalRating;
//        if (remainingMonths > 0) {
//            finalRating = ratings.get(currentCountry * fs + remainingMonths - 1); // Get the rating for the remaining months
//        } else {
//            finalRating = ratings.get(currentCountry * fs + fs - 1); // Get the rating for the last state in the current country
//        }
//
//        return new Result(finalCountry, finalRating);
//    }
//
//    private static record Result(int country, int stateCost) {
//    }
//
//}
