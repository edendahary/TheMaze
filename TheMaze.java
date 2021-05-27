package MazeOfItay;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TheMaze {
    private ArrayList<Player> players = new ArrayList<>();
    private final Scanner in = new Scanner(System.in);
    private Cell[][] maze = new Cell[4][4];
    private int cellSize = 7;
    private int locatinX,locatinY;

    public void InitMaze(int r) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                this.maze[i][j] = new Cell();
            }
        }
        CreateMaze(r);
    }

    public void set_players_position() {
        Random rnd = new Random();
        for (Player p : this.players) {
            int rand_int1 = rnd.nextInt(3);
            int rand_int2 = rnd.nextInt(3);
            while(this.maze[rand_int1][rand_int2].isEmpty() || this.maze[rand_int1][rand_int2].getPrize()!=0 ){
                rand_int1 = rnd.nextInt(3);
                rand_int2 = rnd.nextInt(3);
            }
            p.setX(rand_int1);
            if(p.getX()==0 || p.getX()==3){
                p.setY(rand_int2);
            }else{
                p.setY(0);
                if(this.maze[p.getX()][p.getY()].isEmpty() || this.maze[p.getX()][p.getY()].getPrize()!=0){
                    p.setX(p.getX()+1);
                }
            }
           }
        }
    public void Move(Player p) {
        // Check if the player can move
        if (p.isPlayerCanPlay()) {
            System.out.println(p.getName() + " Please choose option");
            System.out.println("Press U for up");

            System.out.println("Press D for down");

            System.out.println("Press L for left");

            System.out.println("Press R for right");

            System.out.println("Press s to stay");

            System.out.println("Press Q to get distance from the prize. This hint will cost you a move");

            System.out.println("Press E to get information about near room.");

            // Get the decision
            String playerMove = this.in.nextLine();

            while (playerMove.equalsIgnoreCase("u") && this.maze[p.getX()][p.getY()].isUp_Wall() ||
                    playerMove.equalsIgnoreCase("d") && this.maze[p.getX()][p.getY()].isDown_Wall() ||
                    playerMove.equalsIgnoreCase("r") && this.maze[p.getX()][p.getY()].isRight_Wall() ||
                    playerMove.equalsIgnoreCase("l") && this.maze[p.getX()][p.getY()].isLeft_Wall() ||
                    (!playerMove.equalsIgnoreCase("u") &&
                            !playerMove.equalsIgnoreCase("d") &&
                            !playerMove.equalsIgnoreCase("r") &&
                            !playerMove.equalsIgnoreCase("l") &&
                            !playerMove.equalsIgnoreCase("S") &&
                            !playerMove.equalsIgnoreCase("Q") &&
                            !playerMove.equalsIgnoreCase("E"))) {
                System.out.println("Invalid move please choose again");
                playerMove = this.in.nextLine();
            }

            if (playerMove.equalsIgnoreCase("D")) {

                if (p.getX()+1 > 3 && this.maze[p.getX()][p.getY()].isDown_Wall()==false){
                    p.setX(p.getX() + 1);
                    p.setScore(p.getScore() - 1);
                    p.setPlayerCanPlay(false);
                }
                else if(this.maze[p.getX()+1][p.getY()].isEmpty()) {
                    p.setX(p.getX() + 1);
                    p.setScore(p.getScore() - 1);
                    p.setPlayerCanPlay(false);
                } else {
                    p.setScore(p.getScore() - 1);
                    p.setX(p.getX() + 1);
                }
            }
            if (playerMove.equalsIgnoreCase("U")) {
                if (p.getX()-1<0&&this.maze[p.getX()][p.getY()].isUp_Wall()==false){
                    p.setX(p.getX() - 1);
                    p.setScore(p.getScore() - 1);
                    p.setPlayerCanPlay(false);
                }else if(this.maze[p.getX() - 1][p.getY()].isEmpty()) {
                    p.setX(p.getX() - 1);
                    p.setScore(p.getScore() - 1);
                    p.setPlayerCanPlay(false);
                }
                else {
                    p.setScore(p.getScore() - 1);
                    p.setX(p.getX() - 1);
                }
            }


            if (playerMove.equalsIgnoreCase("L")) {
                if (p.getY()-1 < 0 && this.maze[p.getX()][p.getY()].isLeft_Wall()==false){
                    p.setY(p.getY() - 1);
                    p.setScore(p.getScore() - 1 );
                    p.setPlayerCanPlay(false);
                }
                else if(this.maze[p.getX() ][p.getY()-1].isEmpty()) {
                    p.setY(p.getY() - 1);
                    p.setScore(p.getScore() - 1 );
                    p.setPlayerCanPlay(false);
                }
                else {
                    p.setScore(p.getScore() - 1);
                    p.setY(p.getY() - 1);
                }
            }
            if (playerMove.equalsIgnoreCase("R")) {

                if (p.getY()+1 > 3 && this.maze[p.getX()][p.getY()].isRight_Wall()==false){
                    p.setY(p.getY() +1 );
                    p.setScore(p.getScore() - 1);
                    p.setPlayerCanPlay(false);
                }
                else if(this.maze[p.getX() ][p.getY()+1].isEmpty()){
                    p.setY(p.getY() +1 );
                    p.setScore(p.getScore() - 1);
                    p.setPlayerCanPlay(false);
                } else {
                    p.setScore(p.getScore() - 1);
                    p.setY(p.getY() +1 );
                }
            }
            if (playerMove.equalsIgnoreCase("S")) {

            }
            if (playerMove.equalsIgnoreCase("Q")) {
                int x1 = p.getX();
                int y1 = p.getY();
                int x2 = this.locatinX;
                int y2 = this.locatinY;
                int locationPrize =(int) Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2));
                System.out.println("The air location Prize is : "+locationPrize);
                p.setScore(p.getScore() - 1);
            }
            if (playerMove.equalsIgnoreCase("E")) {
                System.out.println("Please Choose near Room : ");
                String R =this.in.nextLine();
                int yPos,xPos;
                yPos=p.getY();
                xPos=p.getX();
                if(R.equalsIgnoreCase("U")){
                    xPos--;
                }
                else if(R.equalsIgnoreCase("D")){
                    xPos++;
                }
                else if(R.equalsIgnoreCase("L")){
                    yPos--;
                }
                else if(R.equalsIgnoreCase("R")){
                    yPos++;
                }
                if(xPos>=0 &&xPos<=3 && yPos>=0 &&yPos<=3){
                    if(this.maze[xPos][yPos].isEmpty()){
                        System.out.println("The Room Is empty");
                    }
                    else if(this.maze[xPos][yPos].getPrize()!=0){
                        System.out.println("Room Contain Prize");
                    }
                }else {
                    System.out.println("Out Of Bounds");
                }

                p.setScore(p.getScore() - 1);
            }
        }
        if(p.getX()>=0 &&p.getX()<=3 && p.getY()>=0 &&p.getY()<=3) {
            if (this.maze[p.getX()][p.getY()].getPrize() != 0) {
                p.setScore(p.getScore()+this.maze[p.getX()][p.getY()].getPrize());
                for (Player p1 : this.getPlayers()) {
                    p1.setPlayerCanPlay(false);
                }
            }
        }
    }



    public void CreateMaze(int round) {
        switch (round) {
            case 1:
                this.maze[0][0].setLeft_Wall(true);
                this.maze[0][1].setUp_Wall(true);
                this.maze[0][1].setDown_Wall(true);
                this.maze[0][2].setUp_Wall(true);
                this.maze[1][0].setEmpty(true);
                this.maze[1][0].setDown_Wall(true);
                this.maze[2][1].setRight_Wall(true);
                this.maze[1][2].setUp_Wall(true);
                this.maze[2][3].setEmpty(true);
                this.maze[2][0].setLeft_Wall(true);
                this.maze[2][2].setLeft_Wall(true);
                this.maze[2][2].setLeft_Wall(true);
                this.maze[3][0].setRight_Wall(true);
                this.maze[3][1].setLeft_Wall(true);
                this.maze[3][2].setUp_Wall(true);
                this.maze[3][3].setPrize(10);
                this.locatinX=3;
                this.locatinY=3;
                break;
            case 2:
                this.maze[0][0].setEmpty(true);
                this.maze[0][1].setUp_Wall(true);
                this.maze[0][1].setLeft_Wall(true);
                this.maze[0][2].setDown_Wall(true);
                this.maze[1][3].setLeft_Wall(true);
                this.maze[1][0].setLeft_Wall(true);
                this.maze[1][0].setRight_Wall(true);
                this.maze[1][1].setUp_Wall(true);
                this.maze[1][1].setLeft_Wall(true);
                this.maze[1][2].setRight_Wall(true);
                this.maze[1][1].setUp_Wall(true);
                this.maze[2][3].setDown_Wall(true);
                this.maze[2][0].setLeft_Wall(true);
                this.maze[2][2].setDown_Wall(true);
                this.maze[2][1].setEmpty(true);
                this.maze[3][0].setDown_Wall(true);
                this.maze[3][3].setEmpty(true);
                this.maze[3][1].setUp_Wall(true);
                this.maze[1][2].setPrize(10);
                this.locatinX=1;
                this.locatinY=2;
                break;
        }
    }


    public void printMaze(ArrayList<Player> players) {
        // For all the rows
        for (int row = 0; row < 4; row++) {
            // For upper Wall
            for (int col = 0; col < 4; col++) {
                // Check upper wall if it is a door or a wall
                if (this.maze[row][col].isEmpty()== true) {
                    for (int i = 0; i < this.cellSize ; i++) {
                        System.out.print(" ");
                    }
                } else if (this.maze[row][col].isUp_Wall() == true) {
                    // print the wall
                    for (int i = 0; i < this.cellSize; i++) {
                        System.out.print("*");
                    }
                } else {
                    // print the wall
                    for (int i = 0; i < this.cellSize; i++) {
                        System.out.print("-");
                    }
                }
            }
            System.out.println("");

            for (int hight = 0; hight < this.cellSize-3 ; hight++) {
                // For left Wall
                for (int col = 0; col < 4 ; col++) {
                    Boolean isPlayerNamePrinted = false;
                    // Check left wall if it is a door or a wall
                    if (this.maze[row][col].isEmpty() == true) {
                        System.out.print(" ");
                    } else if (this.maze[row][col].isLeft_Wall() == true) {
                        // print the wall
                        System.out.print("*");
                    } else {
                        // print the wall
                        System.out.print("|");
                    }

                    // Print players
                    int playerNumberInThatRoom = 0;

                    for (Player player : players) {
                        if (player.getX() == row && player.getY() == col) {
                            if (playerNumberInThatRoom == hight) {
                                System.out.print(player.getName());
                                isPlayerNamePrinted = true;
                            }
                            playerNumberInThatRoom++;
                        }
                    }

                    if (!isPlayerNamePrinted) {
                        // Print space instead of player name
                        for (int i = 0; i < this.cellSize - 2; i++) {
                            if (i == 2 && hight == this.cellSize - 6) {
                                if (this.maze[row][col].getPrize() != 0) {
                                    System.out.print(this.maze[row][col].getPrize());
                                    if(this.maze[row][col].getPrize()>9){
                                        System.out.print(" ");
                                        break;
                                    }
                                    i++;
                                }
                            }
                            System.out.print(" ");
                        }
                    }
                    if (this.maze[row][col].isEmpty() == true) {
                        System.out.print(" ");
                    }
                    // Check right wall if it is a door or a wall
                    else if (this.maze[row][col].isRight_Wall() == true) {
                        // print the wall
                        System.out.print("*");
                    } else {
                        // print the wall
                        System.out.print("|");
                    }
                }
                System.out.println("");
            }
            // Check down wall
            for (int col = 0; col < this.maze[0].length; col++) {
                if (this.maze[row][col].isEmpty() == true) {
                    for (int i = 0; i < this.cellSize; i++) {
                        System.out.print(" ");
                    }
                }
                // Check upper wall if it is a door or a wall
                else if (this.maze[row][col].isUp_Wall() == true) {
                    // print the wall
                    for (int i = 0; i < this.cellSize; i++) {
                        System.out.print("*");
                    }
                } else {
                    // print the wall
                    for (int i = 0; i < this.cellSize; i++) {
                        System.out.print("-");
                    }
                }
            }
            System.out.println("");
        }
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}