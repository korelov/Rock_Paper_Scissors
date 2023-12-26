package rockpaperscissors;

public class Player {
    private String name;
    private int score;

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setName() {
        System.out.print("Enter your name: ");
        this.name = Game.scanner.nextLine();
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String turn() {
        return Game.scanner.nextLine();
    }
}
