package quiz_bkp.complex;

import java.util.Arrays;

public class TempSalesman {

    public static void main(String[] args) {
        int s = 6; // total states
        int fs = 3; // fixed number of states per country
        int m = 6; // number of months Tyler can travel
        int[] r = {2, 3, 1, 4, 1, 2}; // ratings of each state grouped by countries

        int[] result = findFinalState(s, fs, m, r);
        System.out.println("Final Country: " + result[0] + ", Final Rating: " + result[1]);
    }

    public static int[] findFinalState(int s, int fs, int m, int[] r) {
        int numCountries = s / fs;
        int remainingMonths = m % fs;

        // Create an array to store the total ratings for each country
        int[] countryRatings = new int[numCountries];

        // Calculate the total ratings for each country
        for (int i = 0; i < numCountries; i++) {
            int countryStartIndex = i * fs;
            int[] countryStates = Arrays.copyOfRange(r, countryStartIndex, countryStartIndex + fs);
            Arrays.sort(countryStates); // Sort the ratings for each country
            countryRatings[i] = countryStates[0]; // Store the lowest rating for each country
        }

        // Find the country with the lowest rating
        int lowestRatingCountry = 0;
        for (int i = 1; i < numCountries; i++) {
            if (countryRatings[i] < countryRatings[lowestRatingCountry]) {
                lowestRatingCountry = i;
            }
        }

        // Calculate the final position after given months
        int finalCountry = lowestRatingCountry + 1; // Country numbering starts from 1
        int finalRating = countryRatings[lowestRatingCountry];

        // Adjust final position based on remaining months
        int remainingStates = fs - remainingMonths;
        if (remainingMonths > 0) {
            int[] remainingStatesArray = Arrays.copyOfRange(r, lowestRatingCountry * fs, lowestRatingCountry * fs + fs);
            Arrays.sort(remainingStatesArray);
            finalRating = remainingStatesArray[remainingStates];
            finalCountry = lowestRatingCountry + 1; // Country numbering starts from 1
        }

        return new int[]{finalCountry, finalRating};
    }

}
