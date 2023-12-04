import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DayOnePartTwo {
    public static void main(String[] args) {

        List<String> allLines;
        int calibrationValue = 0;
        String filePath = "inputFiles\\dayOne\\input.txt";  //path/to/your/textFile.txt

        try {
            allLines = Files.readAllLines(Path.of(filePath));

            for (int i = 0; i < allLines.size(); i++) { //maybe use an hashMap in the future?
                allLines.set(i, allLines.get(i).replaceAll("one", "o1e"));
                allLines.set(i, allLines.get(i).replaceAll("two", "t2"));
                allLines.set(i, allLines.get(i).replaceAll("three", "t3"));
                allLines.set(i, allLines.get(i).replaceAll("four", "4"));
                allLines.set(i, allLines.get(i).replaceAll("five", "5e"));
                allLines.set(i, allLines.get(i).replaceAll("six", "6"));
                allLines.set(i, allLines.get(i).replaceAll("seven", "7n"));
                allLines.set(i, allLines.get(i).replaceAll("eight", "e8t"));
                allLines.set(i, allLines.get(i).replaceAll("nine", "n9e"));
            }


            for (String line : allLines) {
                if (line.matches(".*\\d.*")) {
                    String numberOnly = line.replaceAll("[^0-9]", "");
                    calibrationValue += getCalibrationValue(numberOnly);

                }

            }

            System.out.println("The sum of all of the calibration values: " + calibrationValue);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static int getCalibrationValue(String numberOnly) { //Cleaner handling with a method compared to dayOnePartOne
        if (numberOnly.length() > 1) {
            String combinedStr = numberOnly.charAt(0) + "" + numberOnly.charAt(numberOnly.length() - 1); // Combine the first and last digits
            return Integer.parseInt(combinedStr);
        } else { //The number has only one digit, add it as is
            String normalStr = numberOnly + numberOnly;
            return Integer.parseInt(normalStr);
        }

    }
}