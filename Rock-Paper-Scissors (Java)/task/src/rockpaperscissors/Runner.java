package rockpaperscissors;

import java.util.Arrays;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
       Game game = new Game();
       game.init();
       game.menu();
    }
}
