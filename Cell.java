package MazeOfItay;

class Cell{
    private int prize;
    private boolean Left_Wall;
    private boolean Right_Wall;
    private boolean Up_Wall;
    private boolean Down_Wall;
    private boolean Empty=false;
    public Cell(){
        this.Down_Wall = false;
        this.Up_Wall = false;
        this.Right_Wall = false;
        this.Left_Wall = false;
    }
    public Cell(boolean L,boolean R,boolean U,boolean D,boolean door){
        this.Down_Wall = D;
        this.Up_Wall = U;
        this.Right_Wall = R;
        this.Left_Wall = L;
    }

    public int getPrize() {
        return prize;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }

    public boolean isLeft_Wall() {
        return Left_Wall;
    }

    public void setLeft_Wall(boolean left_Wall) {
        Left_Wall = left_Wall;
    }

    public boolean isRight_Wall() {
        return Right_Wall;
    }

    public void setRight_Wall(boolean right_Wall) {
        Right_Wall = right_Wall;
    }

    public boolean isUp_Wall() {
        return Up_Wall;
    }

    public void setUp_Wall(boolean up_Wall) {
        Up_Wall = up_Wall;
    }

    public boolean isDown_Wall() {
        return Down_Wall;
    }

    public void setDown_Wall(boolean down_Wall) {
        Down_Wall = down_Wall;
    }

    public boolean isEmpty() {
        return Empty;
    }

    public void setEmpty(boolean empty) {
        Empty = empty;
    }
}