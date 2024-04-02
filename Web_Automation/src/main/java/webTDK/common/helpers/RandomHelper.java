package webTDK.common.helpers;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class RandomHelper {
    public static Faker faker = new Faker(new Locale("hu"));
    public int yearNow = Year.now().getValue();


    /**
     * Read the zip numbers from an external .scv file
     * @return List of strings containing the data read from the .csv file
     */
    public List<String> readZipNumbersData(){
        List<String[]> content = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(RandomHelper.class.getResourceAsStream("/zip_numbers.csv"), "ISO-8859-1"))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                content.add(line.split(";"));
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        List<String> result = new ArrayList<>();
        for (String[] line : content){
            for (String elem : line) {
                    result.add(elem);
                }
            }
        return result;
    }

    /**
     * Weighted random number generation
     * @param min The lower limit of interval
     * @param max The upper limit of interval
     * @param target The target value towards which the method is based
     * @param weight Probability of returning the target value
     * @return A number returned between the lower and upper limits of the interval, based on a certain frequently of a target value
     */
    public static int weightedRandomNumber(int min, int max, int target, double weight){
        Random random = new Random();
        double randomNumber = random.nextDouble();
        if (randomNumber < weight) {
            return target;
        } else {
            return random.nextInt((max - min) + 1) + min;
        }
    }

    /**
     * Randomly selects a prefix string from a predefined pool of name prefixes
     * @return Selected prefix from the predefined
     */
    public String generatePrefix(){
        String[] NamePool = {"dr.", "id.", "ifj.", "özv.", "prof.", ""};
        int rnd = weightedRandomNumber(0, 5, 5, 0.5);
        return NamePool[rnd];
    }

    /**
     * Generateing a full name using an external library
     * @return Full name prefixed with "TA-"
     */
    public String generateFullName(){
        String lastName = "TA-" + faker.name().lastName();
        String firstName = faker.name().lastName();
        String fullName = lastName + " " + firstName;
        return fullName;
    }

    /**
     * Extracing the first part of a generated full name string
     * @return Separated first name
     */
    public String generateFirstName(){
        String[] parts = generateFullName().split(" ");
        String firstName = parts[0];
        return firstName;
    }

    /**
     * Extracing the second part of a generated full name string
     * @return Separated last name
     */
    public String generateLastName() {
        String[] parts = generateFullName().split(" ");
        String lastName = parts[1];
        return lastName;
    }

    /**
     * Generating a random birthdate string in the format "YYYY.MM-DD." within a specified range
     * @return Birthdate "YYYY-MM.DD." format
     */
    //TODO: refact the double digit month and days
    public String generateBirthDate(){
        GregorianCalendar gc = new GregorianCalendar();
        int year = randBetween(1930, 2004);
        gc.set(gc.YEAR, year);
        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
        gc.set(gc.DAY_OF_YEAR, dayOfYear);
        String month = "" + (gc.get(gc.MONTH) + 1);
        String day = "" + gc.get(gc.DAY_OF_MONTH);
        if ((gc.get(gc.MONTH) + 1 < 10)){
            month = "0" + (gc.get(gc.MONTH) + 1);
        }
        if (gc.get(gc.DAY_OF_MONTH) < 10){
            day = "0" + gc.get(gc.DAY_OF_MONTH);
        }
        return gc.get(gc.YEAR) + "." + month + "." + day + ".";
    }

    /**
     * Generating a radnom number from a certain interval
     * @param start The lower limit of interval
     * @param end The upper limit of interval
     * @return Random number generated between the lower and upper limit of the interval
     */
    public static int randBetween(int start, int end){
        return start + (int)Math.round(Math.random() * (end - start));
    }

    /**
     * Randomly selects a birthplace from the pool
     * @return Selected birthplace
     */
    public String generateBirthPlace(){
        String[] NamePool = {"Budapest", "Debrecen"};
        int rnd = new Random().nextInt(NamePool.length);
        return NamePool[rnd];
    }

    /**
     * Generating a valid date string in the format "YYYY.MM.DD." based on specific target
     * @return Generated date in the format "YYYY.MM.DD."
     */
    public String generateDocumentValidFrom(){
        GregorianCalendar gc = new GregorianCalendar();
        int year = randBetween(yearNow - 8, yearNow -2);
        gc.set(gc.YEAR, year);
        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
        gc.set(gc.DAY_OF_YEAR, dayOfYear);
        return gc.get(gc.YEAR) + "." + (gc.get(gc.MONTH) + 1) + "." + gc.get(gc.DAY_OF_MONTH) + ".";
    }

    /**
     * Generating a valid date string in the format "YYYY.MM.DD." based on specific target
     * @return Generated date in the format "YYYY.MM.DD."
     */
    public String generateDocumentValidTo(){
        GregorianCalendar gc = new GregorianCalendar();
        int year = randBetween(yearNow + 1, yearNow + 8);
        gc.set(gc.YEAR, year);
        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
        gc.set(gc.DAY_OF_YEAR, dayOfYear);
        return gc.get(gc.YEAR) + "." + (gc.get(gc.MONTH) + 1) + "." + gc.get(gc.DAY_OF_MONTH) + ".";
    }

    /**
     * Generating a random string that combines six digits and two uppercase alphabetic characters
     * @return String that consists of 6 random digits 2 randomly generated uppercase alphabetic characters
     */
    public String generate6and2Number(){
        String rndNum = RandomStringUtils.randomNumeric(6);
        String rndAlp = RandomStringUtils.randomAlphabetic(2).toUpperCase();
        return rndNum + rndAlp;
    }

    /**
     * Randomly selecting and returning a string representing a zip code and city
     * @return Selected zip code and city
     */
    public String generateZipCodeAndCity(){
        List<String> NamePool = readZipNumbersData();
        Random random = new Random();
        String rnd = NamePool.get(random.nextInt(NamePool.size()));
        return rnd;
    }

    /**
     * Generating a random house number as a string within the range of 0 tp 99
     * @return Randomly generated house number
     */
    public String generateHouseNumber(){
        String rnd = Integer.toString(randBetween(0, 99));
        return rnd;
    }

    /**
     *
     * @param birthDate Input parameter is a date of birth
     * @return Generated Hungarian tax number based on the given date of birth
     */
    public String generateHunTayNumber(String birthDate){
        /*
        1. szám fix 8
        2-6.-ig a születési időpont és 1867.jan.1. között eltelt napok száma
        7-9.ig véletlen generált számok
        10. szám (első számjegyek mindegyikét szorozni kell azzal a sorszámmal, ahányadik helyet foglalja el az azonosítón belül)
        majd ezt a számot kell osztani 11-el és az osztás maradéka a 10. szám
        A 7-9.ig számjegyek szerinti születési sorszám nem adható ki, ha a 11-gyel való osztás maradéka egyenlő tízzel.
         */
        String tayNum = "8";
        LocalDate dateBefore = LocalDate.parse("1867-01-01");
        LocalDate dateAfter = LocalDate.parse(birthDate.substring(0, 4) + "-" + birthDate.substring(5, 7) + "-" + birthDate.substring(8, 10));
        long dayDiffLong = ChronoUnit.DAYS.between(dateBefore, dateAfter);
        while (true){
            String daysDiff = String.valueOf(dayDiffLong);
            String rndNum = RandomStringUtils.randomNumeric(3);
            String firstNine = tayNum + daysDiff + rndNum;
            int sum = 0;
            for (int i = 0; i < firstNine.length(); i++){
                sum = sum + (Integer.parseInt(String.valueOf(firstNine.charAt(i))) * (i + 1));
            }
            if (sum % 11 != 10){
                return firstNine + Integer.toString((sum%11));
            }
        }

    }
}
