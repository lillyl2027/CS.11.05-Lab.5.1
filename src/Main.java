public class Main {

  public static int maxRetailEstimateKgPerCapitaPerYear(int[] retailEstimatesKgPerCapitaPerYear)
    {
        if (retailEstimatesKgPerCapitaPerYear == null || retailEstimatesKgPerCapitaPerYear.length == 0) {
            return -1;
        }
        int mv = retailEstimatesKgPerCapitaPerYear[0];
        for (int e : retailEstimatesKgPerCapitaPerYear) {
            if (e > mv) {
                mv = e;
            }
        }
        return mv;
    }


    public static int getCountryTotalWastePerYear(String country, String[] countries, int[] totalWasteKgPerCapitaPerYear) {
        int ind = 0;
        for (int i = 0; i < countries.length; i++) {
            if (countries[i].equals(country)) {
                ind = i;
            }
        }
        return totalWasteKgPerCapitaPerYear[ind];
        }

            public static String getCountryWithMostWastePerCapita(String[] countries, int[] totalWasteKgPerCapitaPerYear)
    {
        if (countries.length == 0 || totalWasteKgPerCapitaPerYear.length == 0) {
            return "No data available";
        }

        int maxWaste = totalWasteKgPerCapitaPerYear[0];
        String countryWithMostWaste = countries[0];

        for (int i = 1; i < totalWasteKgPerCapitaPerYear.length; i++) {
            if (totalWasteKgPerCapitaPerYear[i] > maxWaste) {
                maxWaste = totalWasteKgPerCapitaPerYear[i];
                countryWithMostWaste = countries[i];
            }
        }

        return countryWithMostWaste;
    }

    public static String[] getCountriesWithHighestPovertyPercentage(String[] countries, double[] percentagesShareInPoverty)
    {
        double highestPercentage = Double.MIN_VALUE;
        int count = 0;

        for (int i = 0; i < percentagesShareInPoverty.length; i++) {
            if (percentagesShareInPoverty[i] > highestPercentage) {
                highestPercentage = percentagesShareInPoverty[i];
                count = 1;
            } else if (percentagesShareInPoverty[i] == highestPercentage) {
                count++;
            }
        }

        String[] countriesWithHighestPoverty = new String[count];
        int index = 0;

        for (int i = 0; i < percentagesShareInPoverty.length; i++) {
            if (percentagesShareInPoverty[i] == highestPercentage) {
                countriesWithHighestPoverty[index] = countries[i];
                index++;
            }
        }

        return countriesWithHighestPoverty;
    }

    public static String[] getCountriesWithHighConfidence(String[] countries, String[] confidences)
    {
        int count = 0;
        for (int i = 0; i < confidences.length; i++) {
            if (confidences[i].equals("High Confidence")) {
                count++;
            }
        }

        String[] countriesWithHighConfidence = new String[count];
        int index = 0;
        for (int i = 0; i < confidences.length; i++) {
            if (confidences[i].equals("High Confidence")) {
                countriesWithHighConfidence[index] = countries[i];
                index++;
            }
        }

        return countriesWithHighConfidence;
    }
    }

