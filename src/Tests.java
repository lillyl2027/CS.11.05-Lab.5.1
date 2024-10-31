import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;

import org.junit.*;
import java.util.Arrays;
import java.util.List;

public class Tests {

    String[] countries;
    int[] totalWasteKgPerCapitaPerYear;
    int[] householdEstimatesKgPerCapitaPerYear;
    int[] householdEstimatesTonnesPerYear;
    int[] retailEstimatesKgPerCapitaPerYear;
    int[] retailEstimatesTonnesPerYear;
    int[] foodServiceEstimatesKgPerCapitaPerYear;
    int[] foodServiceEstimatesTonnesPerYear;
    String[] confidences;
    String[] regions;
    String[] years;
    double[] percentagesShareInPoverty;

    @Before
    public void setUp()
    {
        CSVReader.populateArrays();

        countries = CSVReader.countries.toArray(new String[CSVReader.countries.size()]);
        totalWasteKgPerCapitaPerYear = CSVReader.totalWasteKgPerCapitaPerYear.stream().mapToInt(i -> i).toArray();
        householdEstimatesKgPerCapitaPerYear = CSVReader.householdEstimatesKgPerCapitaPerYear.stream().mapToInt(i -> i).toArray();
        householdEstimatesTonnesPerYear = CSVReader.householdEstimateTonnesPerYear.stream().mapToInt(i -> i).toArray();
        retailEstimatesKgPerCapitaPerYear = CSVReader.retailEstimateKgPerCapitaPerYear.stream().mapToInt(i -> i).toArray();
        retailEstimatesTonnesPerYear = CSVReader.retailEstimateTonnesPerYear.stream().mapToInt(i -> i).toArray();
        foodServiceEstimatesKgPerCapitaPerYear = CSVReader.foodServiceEstimateKgPerCapitaPerYear.stream().mapToInt(i -> i).toArray();
        foodServiceEstimatesTonnesPerYear = CSVReader.foodServiceEstimateTonnesPerYear.stream().mapToInt(i -> i).toArray();
        confidences = CSVReader.confidence.toArray(new String[CSVReader.confidence.size()]);
        regions = CSVReader.region.toArray(new String[CSVReader.region.size()]);
        years = CSVReader.year.toArray(new String[CSVReader.year.size()]);
        percentagesShareInPoverty = CSVReader.percentageShareInPoverty.stream().mapToDouble(i -> i).toArray();

    }

    /**************************************************************************************************************
     * Testing for the averages
     **************************************************************************************************************/
/**
    @Test
    public void meanTotalWasteKgPerCapitaPerYear()
    {
        assertEquals(129, Main.meanTotalWasteKgPerCapitaPerYear(totalWasteKgPerCapitaPerYear));
    }

    @Test
    public void meanHouseholdEstimatesKgPerCapitaPerYear()
    {
        assertEquals(86, Main.meanHouseholdEstimateKgPerCapitaPerYear(householdEstimatesKgPerCapitaPerYear));
    }

    @Test
    public void householdEstimateTonnesPerYear()
    {
        assertEquals(3383046, Main.meanHouseholdEstimateTonnesPerYear(householdEstimatesTonnesPerYear));
    }

    @Test
    public void meanRetailEstimateKgPerCapitaPerYear()
    {
        assertEquals(16, Main.meanRetailEstimateKgPerCapitaPerYear(retailEstimatesKgPerCapitaPerYear));
    }

    @Test
    public void meanRetailEstimateTonnesPerYear()
    {
        assertEquals(707335, Main.meanRetailEstimateTonnesPerYear(retailEstimatesTonnesPerYear));
    }

    @Test
    public void meanFoodServiceEstimateKgPerCapitaPerYear()
    {
        assertEquals(28, Main.meanFoodServiceEstimateKgPerCapitaPerYear(foodServiceEstimatesKgPerCapitaPerYear));
    }

    @Test
    public void meanFoodServiceEstimateTonnesPerYear()
    {
        assertEquals(1480947, Main.meanFoodServiceEstimateTonnesPerYear(foodServiceEstimatesTonnesPerYear));
    }

    /**************************************************************************************************************
     * Testing for the medians
     **************************************************************************************************************/
/**
    @Test
    public void medianTotalWasteKgPerCapitaPerYear()
    {
        assertEquals(127, Main.medianTotalWasteKgPerCapitaPerYear(totalWasteKgPerCapitaPerYear));
    }

    @Test
    public void medianHouseholdEstimatesKgPerCapitaPerYear()
    {
        assertEquals(84, Main.medianHouseholdEstimateKgPerCapitaPerYear(householdEstimatesKgPerCapitaPerYear));
    }

    @Test
    public void medianHouseholdEstimateTonnesPerYear()
    {
        assertEquals(830017, Main.medianHouseholdEstimateTonnesPerYear(householdEstimatesTonnesPerYear));
    }

    @Test
    public void medianRetailEstimateKgPerCapitaPerYear()
    {
        assertEquals(16, Main.medianRetailEstimateKgPerCapitaPerYear(retailEstimatesKgPerCapitaPerYear));
    }

    @Test
    public void medianRetailEstimateTonnesPerYear()
    {
        assertEquals(137260, Main.medianRetailEstimateTonnesPerYear(retailEstimatesTonnesPerYear));
    }

    @Test
    public void medianFoodServiceEstimateKgPerCapitaPerYear()
    {
        assertEquals(28, Main.medianFoodServiceEstimateKgPerCapitaPerYear(foodServiceEstimatesKgPerCapitaPerYear));
    }

    @Test
    public void medianFoodServiceEstimateTonnesPerYear()
    {
        assertEquals(261488, Main.medianFoodServiceEstimateTonnesPerYear(foodServiceEstimatesTonnesPerYear));
    }

    /**************************************************************************************************************
     * Testing for the minimums
     **************************************************************************************************************/
/**
    @Test
    public void minTotalWasteKgPerCapitaPerYear()
    {
        assertEquals(61, Main.minTotalWasteKgPerCapitaPerYear(totalWasteKgPerCapitaPerYear));
    }

    @Test
    public void minHouseholdEstimatesKgPerCapitaPerYear()
    {
        assertEquals(34, Main.minHouseholdEstimateKgPerCapitaPerYear(householdEstimatesKgPerCapitaPerYear));
    }

    @Test
    public void minHouseholdEstimateTonnesPerYear()
    {
        assertEquals(850, Main.minHouseholdEstimateTonnesPerYear(householdEstimatesTonnesPerYear));
    }

    @Test
    public void minRetailEstimateKgPerCapitaPerYear()
    {
        assertEquals(4, Main.minRetailEstimateKgPerCapitaPerYear(retailEstimatesKgPerCapitaPerYear));
    }

    @Test
    public void minRetailEstimateTonnesPerYear()
    {
        assertEquals(138, Main.minRetailEstimateTonnesPerYear(retailEstimatesTonnesPerYear));
    }

    @Test
    public void minFoodServiceEstimateKgPerCapitaPerYear()
    {
        assertEquals(3, Main.minFoodServiceEstimateKgPerCapitaPerYear(foodServiceEstimatesKgPerCapitaPerYear));
    }

    @Test
    public void minFoodServiceEstimateTonnesPerYear()
    {
        assertEquals(276, Main.minFoodServiceEstimateTonnesPerYear(foodServiceEstimatesTonnesPerYear));
    }

    /**************************************************************************************************************
     * Testing for the maximums
     **************************************************************************************************************/
/**
    @Test
    public void maxTotalWasteKgPerCapitaPerYear()
    {
        assertEquals(260, Main.maxTotalWasteKgPerCapitaPerYear(totalWasteKgPerCapitaPerYear));
    }

    @Test
    public void maxHouseholdEstimatesKgPerCapitaPerYear()
    {
        assertEquals(189, Main.maxHouseholdEstimateKgPerCapitaPerYear(householdEstimatesKgPerCapitaPerYear));
    }

    @Test
    public void maxHouseholdEstimateTonnesPerYear()
    {
        assertEquals(91646213, Main.maxHouseholdEstimateTonnesPerYear(householdEstimatesTonnesPerYear));
    }
**/
    @Test
    public void maxRetailEstimateKgPerCapitaPerYear()
    {
        assertEquals(79, Main.maxRetailEstimateKgPerCapitaPerYear(retailEstimatesKgPerCapitaPerYear));
    }
/**
    @Test
    public void maxRetailEstimateTonnesPerYear()
    {
        assertEquals(22424705, Main.maxRetailEstimateTonnesPerYear(retailEstimatesTonnesPerYear));
    }

    @Test
    public void maxFoodServiceEstimateKgPerCapitaPerYear()
    {
        assertEquals(90, Main.maxFoodServiceEstimateKgPerCapitaPerYear(foodServiceEstimatesKgPerCapitaPerYear));
    }

    @Test
    public void maxFoodServiceEstimateTonnesPerYear()
    {
        assertEquals(65377741, Main.maxFoodServiceEstimateTonnesPerYear(foodServiceEstimatesTonnesPerYear));
    }

    /**************************************************************************************************************
     * Misc Tests
     **************************************************************************************************************/

    @Test
    public void getCountryTotalWastePerYear()
    {
        assertEquals(127, Main.getCountryTotalWastePerYear("Albania", countries, totalWasteKgPerCapitaPerYear));
        assertEquals(97, Main.getCountryTotalWastePerYear("Belize", countries, totalWasteKgPerCapitaPerYear));
        assertEquals(139, Main.getCountryTotalWastePerYear("United States of America", countries, totalWasteKgPerCapitaPerYear));
    }

    @Test
    public void getCountryWithMostWastePerCapita()
    {
        assertEquals("Malaysia", Main.getCountryWithMostWastePerCapita(countries, totalWasteKgPerCapitaPerYear));
    }

    @Test
    public void getCountriesWithHighestPovertyPercentage()
    {
        List<String> countries = Arrays.asList(Main.getCountriesWithHighestPovertyPercentage(this.countries, percentagesShareInPoverty));
        assertTrue(countries.contains("Guinea-Bissau"));
        assertTrue(countries.contains("Madagascar"));
        assertTrue(countries.contains("Mali"));
        assertTrue(countries.contains("Somalia"));
        assertEquals(4, countries.size());
    }

    @Test
    public void getCountriesWithHighConfidence()
    {
        List<String> countries = Arrays.asList(Main.getCountriesWithHighConfidence(this.countries, confidences));
        assertTrue(countries.contains("Australia"));
        assertTrue(countries.contains("Austria"));
        assertTrue(countries.contains("Denmark"));
        assertTrue(countries.contains("Germany"));
        assertTrue(countries.contains("Italy"));
        assertTrue(countries.contains("Sweden"));
        assertTrue(countries.contains("United Kingdom"));
        assertTrue(countries.contains("United States of America"));

        assertEquals(8, countries.size());
    }
    
}
