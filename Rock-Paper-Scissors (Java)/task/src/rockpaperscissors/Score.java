package rockpaperscissors;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Score {
    private final String path = "C:\\Users\\korel\\IdeaProjects\\Rock-Paper-Scissors (Java)"
            + "\\Rock-Paper-Scissors (Java)\\task\\src\\rockpaperscissors\\rating.txt";
    File file = new File(path);

    public void readRating(Player player) {
        try (Scanner scanner = new Scanner(file)) {
            String[] temp;
            while (scanner.hasNext()) {
                temp = scanner.nextLine().split(" ");
                for (int i = 0; i < temp.length; i++) {
                    if (temp[i].equals(player.getName())) {
                        player.setScore(Integer.parseInt(temp[i + 1]));
                        break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + "rating.txt");
        }
    }
}
