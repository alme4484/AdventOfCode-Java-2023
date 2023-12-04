import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DayOnePartOne {
    public static void main(String[] args) {

        List<String> allLines;
        int calibrationValue = 0;
        String filePath = "inputFiles\\dayOne\\input.txt";  //Try to fetch the input importing Class URL

        try {

            allLines = Files.readAllLines(Path.of(filePath));

            for (String line : allLines) {
                if (line.matches(".*\\d.*")) {
                    String numberOnly = line.replaceAll("[^0-9]", "");
                    if (numberOnly.length() > 1) {
                        String combinedStr = numberOnly.charAt(0) + "" + numberOnly.charAt(numberOnly.length() - 1); // Combine the first and last digits
                        calibrationValue += Integer.parseInt(combinedStr);

                    } else { // If the number has only one digit, add it as is
                        String normalStr = numberOnly + numberOnly;
                        calibrationValue += Integer.parseInt(normalStr);
                    }

                }

            }

            System.out.println("The sum of all of the calibration values: " + calibrationValue);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}