package webTDK.common.helpers;

import org.apache.commons.lang3.RandomStringUtils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

public class RandomHelper {

    //TODO: későbbiekben ilyen formában lesz a NamePoolok felöltése.
    public List<String> readData(){
        List<String[]> content = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\geveres\\Documents\\zip_numbers.csv"), "ISO-8859-1"))) {
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

    public String generatePrefix(){
        String[] NamePool = {"dr.", "id.", "ifj.", "özv.", "prof.", ""};
        int rnd = new Random().nextInt(NamePool.length);
        return NamePool[rnd];
    }

    public String generateFirstName(){
        String[] NamePool = {"László", "test"};
        int rnd = new Random().nextInt(NamePool.length);
        return NamePool[rnd];
    }

    public String generateLastName(){
        String[] NamePool = {"Nagy", "test"};
        int rnd = new Random().nextInt(NamePool.length);
        return "TA-" + NamePool[rnd];
    }

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

    public static int randBetween(int start, int end){
        return start + (int)Math.round(Math.random() * (end - start));
    }

    public String generateBirthPlace(){
        String[] NamePool = {"Budapest", "Debrecen"};
        int rnd = new Random().nextInt(NamePool.length);
        return NamePool[rnd];
    }

    //TODO: upgrade needed
    public String generateDocumentValidFrom(){
        GregorianCalendar gc = new GregorianCalendar();
        int year = randBetween(2015, 2021);
        gc.set(gc.YEAR, year);
        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
        gc.set(gc.DAY_OF_YEAR, dayOfYear);
        return gc.get(gc.YEAR) + "." + (gc.get(gc.MONTH) + 1) + "." + gc.get(gc.DAY_OF_MONTH) + ".";
    }

    //TODO: upgrade needed
    public String generateDocumentValidTo(){
        GregorianCalendar gc = new GregorianCalendar();
        int year = randBetween(2023, 2030);
        gc.set(gc.YEAR, year);
        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
        gc.set(gc.DAY_OF_YEAR, dayOfYear);
        return gc.get(gc.YEAR) + "." + (gc.get(gc.MONTH) + 1) + "." + gc.get(gc.DAY_OF_MONTH) + ".";
    }

    public String generate6and2Number(){
        String rndNum = RandomStringUtils.randomNumeric(6);
        String rndAlp = RandomStringUtils.randomAlphabetic(2).toUpperCase();
        return rndNum + rndAlp;
    }

    public String generateZipCodeAndCity(){
        List<String> NamePool = readData();
        Random random = new Random();
        String rnd = NamePool.get(random.nextInt(NamePool.size()));
        return rnd;
    }

    public String generateHouseNumber(){
        String rnd = Integer.toString(randBetween(0, 99));
        return rnd;
    }

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
