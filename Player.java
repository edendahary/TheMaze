package MazeOfItay;

public class Player {
    private String Name;
    private int score =0;
    private int x,y;
    private boolean isPlayerCanPlay=true;

    public Player(String name){
        name=name.substring(0,5);
        this.Name=name;
    }
    public int getScore() {
        return score;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getName() {
        return Name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    public boolean isPlayerCanPlay()
    {
        return this.isPlayerCanPlay;
    }

    public void setPlayerCanPlay(boolean playerCanPlay) {
        isPlayerCanPlay = playerCanPlay;
    }
}
