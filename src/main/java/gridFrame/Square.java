package gridFrame;

public class Square implements Locatable{
    private int x, y;

    @Override
    public void setX(int x) { this.x = x; }
    @Override
    public void setY(int y) { this.y = y; }

    @Override
    public int getX() { return x; }
    @Override
    public int getY() { return y; }

    @Override
    public char getSymbol() { return '@'; }

    @Override
    public Locatable newObj() {
        return new Square();
    }
}
