package rockpaperscissors;

import java.util.Scanner;

public class Game {
    public static Scanner scanner = new Scanner(System.in);
    private final Player player = new Player();
    private final Score score = new Score();
    private String[] gameOptions;

    private void setGameOptions(String[] gameOptions) {
        this.gameOptions = gameOptions;
    }

    private String computerTurn() {
        int random = (int) (Math.random() * gameOptions.length) + 1;
        return gameOptions[random - 1];
    }

    private String gamePlay(String playerInput, String computer, Player player) {
        int playerIndex = 0;
        int computerIndex = 0;
        int avr = gameOptions.length / 2;

        for (int i = 0; i < gameOptions.length; i++) {
            if (playerInput.equalsIgnoreCase(gameOptions[i])) {
                playerIndex = i;
            }
            if (computer.equalsIgnoreCase(gameOptions[i])) {
                computerIndex = i;
            }
        }
        if (playerIndex == computerIndex) {
            player.setScore(player.getScore() + 50);
            return String.format("There is a draw (%s)", computer);
        } else if (((playerIndex < computerIndex) && (playerIndex + avr + 1) > computerIndex)
                || ((playerIndex + avr) > gameOptions.length)
                && (playerIndex + avr + 1 - gameOptions.length) > computerIndex) {
            return String.format("Sorry, but the computer chose %s", computer);
        } else {
            player.setScore(player.getScore() + 100);
            return String.format("Well done. The computer chose %s and failed", computer);
        }
    }

    public void init() {
        player.setName();
        System.out.println("Hello, " + player.getName());
        try {
            score.readRating(player);
        } catch (IllegalArgumentException e) {
            System.out.println("Something went wrong with the data in the file");
        }
        String[] options = scanner.nextLine().split(",");
        if (options.length == 1) {
            setGameOptions(new String[]{"rock", "paper", "scissors"});
        } else {
            setGameOptions(options);
        }
        System.out.println("Okay, let's start");
    }

    private boolean checkHumanSelection(String player) {
        for (String gameOption : gameOptions) {
            if (player.equalsIgnoreCase(gameOption)) {
                return true;
            }
        }
        return false;
    }

    public void menu() {
        while (true) {
            String input = this.player.turn();
            if (checkHumanSelection(input)) {
                System.out.println(gamePlay(input, computerTurn(), this.player));
                continue;
            }
            if (input.equals("!exit")) {
                System.out.println("Bye!");
                break;
            } else if (input.equals("!rating")) {
                System.out.println("Your rating: " + this.player.getScore());
            } else {
                System.out.println("Invalid input");
            }
        }
    }
}
