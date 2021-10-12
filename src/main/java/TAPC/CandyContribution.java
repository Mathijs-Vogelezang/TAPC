package TAPC;

import java.util.*;

public class CandyContribution {
    public static HashMap<Integer, Integer>[] countries;  // Array of countries with reachable countries

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nrCountries = scanner.nextInt();
        int nrBorders = scanner.nextInt();

        int countryWon = scanner.nextInt() - 1;
        int homeCountry = scanner.nextInt() - 1;
        int nrCandies = scanner.nextInt();

        countries = new HashMap[nrCountries];

        for (int i = 0; i < nrCountries; i++) {
            countries[i] = new HashMap<>();
        }

        for (int i = 0; i < nrBorders; i++) {
            int country1 = scanner.nextInt() - 1;
            int country2 = scanner.nextInt() - 1;
            int cost = scanner.nextInt();
            countries[country1].put(country2, cost);
            countries[country2].put(country1, cost);
        }
        System.out.println(leftoverCandies(countryWon, homeCountry, nrCandies));
    }

    public static int leftoverCandies(int startCountry, int destination, int candies) {
        return leftoverCandies(startCountry, destination, candies, new ArrayList<>());
    }

    public static int leftoverCandies(int startCountry, int destination, int candies, List<Integer> previousCountries) {
        previousCountries.add(startCountry);
        boolean canReach = false; // can reach destination (after some border crossings)
        List<Integer> candyAmounts = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : countries[startCountry].entrySet()) {
            int candiesLeft = candies - (int) Math.ceil(candies * (entry.getValue() / 100.0));

            if (previousCountries.contains(entry.getKey())) {
                continue;
            }

            canReach = true;

            if (entry.getKey() == destination) {
                candyAmounts.add(candiesLeft);
            } else {
                candyAmounts.add(leftoverCandies(entry.getKey(), destination, candiesLeft, new ArrayList<>(previousCountries)));
            }
        }

        if (canReach) {
            return Collections.max(candyAmounts);
        } else {
            return 0;
        }
    }
}
