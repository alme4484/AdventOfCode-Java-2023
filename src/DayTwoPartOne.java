import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DayTwoPartOne {

    public static void main(String[] args) {


        List<String> allLines;
        String filePath = "inputFiles\\dayTwo\\input.txt";
        final int RED = 12; //Should be static outside of main but fak it no time
        final int GREEN = 13;
        final int BLUE = 14;
        int gameNr = 0;
        int gameNrSum = 0;
        boolean changed = true;
        int gameRed;
        int gameGreen;
        int gameBlue;


        try {
            allLines = Files.readAllLines(Path.of(filePath));


            for (String line : allLines) {    //My Nr1 mistake but hey it works and was 2 hours deep


                List<String> hands = List.of(line.split(";"));

                for (String ln : hands) {

                    List<String> cubes = List.of(ln.split(","));


                    for (String cub : cubes) {

                        List<String> result = List.of(cub.split(":"));
                        for (String rs : result) { //No comment

                            Pattern gameP = Pattern.compile("Game (\\d+)");
                            Pattern redP = Pattern.compile("(\\d+) red");
                            Pattern greenP = Pattern.compile("(\\d+) green");
                            Pattern blueP = Pattern.compile("(\\d+) blue");

                            Matcher gameMatcher = gameP.matcher(rs);
                            Matcher redMatcher = redP.matcher(rs);
                            Matcher greenMatcher = greenP.matcher(rs);
                            Matcher blueMatcher = blueP.matcher(rs);


                            if (gameMatcher.find()) {
                                gameNr = Integer.parseInt(gameMatcher.group(1));
                            }


                            if (redMatcher.find()) {     //Should be one if statement with longer condition no time
                                gameRed = Integer.parseInt(redMatcher.group(1));

                                if (RED >= gameRed && changed) {
                                    changed = true;
                                } else {
                                    changed = false;
                                }
                            }

                            if (greenMatcher.find()) {
                                gameGreen = Integer.parseInt(greenMatcher.group(1));

                                if (GREEN >= gameGreen && changed) {
                                    changed = true;

                                } else {
                                    changed = false;
                                }

                            }

                            if (blueMatcher.find()) {
                                gameBlue = Integer.parseInt(blueMatcher.group(1));

                                if (BLUE >= gameBlue && changed) {
                                    changed = true;

                                } else {
                                    changed = false;
                                }


                            }


                        }


                    }


                }

                if (changed) {
                    gameNrSum += gameNr;
                }
                changed = true;
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(gameNrSum);
    }


}