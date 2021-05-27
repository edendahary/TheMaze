package MazeOfItay;
import java.util.Scanner;

public class game {
    private TheMaze m = new TheMaze();
    private final Scanner in = new Scanner(System.in);
    private boolean printMazeAfterEveryMove = true;

    public void start_game() {
        creatPlayers();
        for (int round = 1; round <= 3; round++)
        {
            System.out.println("Round " + round);
            m.InitMaze(round);
            m.set_players_position();
            // Start play the round
            playRound(round);
            // print player scores
            printPlayerScores();
        }
        printEndGame();
    }


    private void playRound(int round) {
        boolean gameOver = false;

        // While game is not over
        while (!gameOver) {
            gameOver = true;
            if (printMazeAfterEveryMove){
                this.m.printMaze(m.getPlayers());
            }
            //Do move for all player that can
            for (Player player : m.getPlayers()) {
                if (player.isPlayerCanPlay()) {
                    // Show player option to play and save the move
                    m.Move(player);
                    // Validate if player can play in the next move
                    // If none of the player can move the game is over
                    if (player.isPlayerCanPlay()){
                        gameOver = false;
                    }
                }
            }
        }
        System.out.println("Round number " + round + " ended");
    }
    private void printPlayerScores()
    {
        System.out.println("Player Scores: ");
        for (Player player : m.getPlayers()) {
            System.out.println(player.getName() + " with score: " + player.getScore());
            player.setPlayerCanPlay(true);
        }
    }

    private void printEndGame(){
        Player bestplayer = m.getPlayers().get(0);
        for (Player player : m.getPlayers()) {
            if (bestplayer.getScore() < player.getScore()){
                bestplayer = player;
            }
        }
        System.out.println("All the round over and the winner is: "+ bestplayer.getName());
        System.out.println("With score: " + bestplayer.getScore());
    }

    private void creatPlayers() {
        // how match players play the game
        System.out.println("Insert number Of players who play the game: ");
        int numberOfPlayers = in.nextInt();

        for (int i =1; i<= numberOfPlayers; i++){

            System.out.println("Insert Player "+i+" name: ");
            String name = in.next();
           // p.setName(name);
            Player p = new Player(name+"     ");
            m.getPlayers().add(p);
            //in.nextLine();
        }
        for (Player player: m.getPlayers()){
            System.out.println(player.getName());
        }
    }

    public static void main(String[] args) {
            game game = new game();
            game.start_game();
        }
    }


