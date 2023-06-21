package gridFrame;

import java.util.HashMap;
public class GridBoard{
    final private int[] border = new int[2];
    private HashMap<Integer, Locatable> board = new HashMap<Integer, Locatable>();
    public GridBoard(int xBorder, int yBorder, Locatable squareType) {
        border[0] = xBorder;
        border[1] = yBorder;
        for (int i = 0; i < xBorder;i++) {
            for (int j = 0; j < yBorder;j++) {
                Locatable square = squareType.newObj();
                square.setX(i);
                square.setY(j);
                board.put(toInt(i, j), square);
            }
        }
    }
    // in class methods

    private int toInt(int x, int y) {
        NullPointerException npe = new NullPointerException();
        if (x < 0 || x >= border[0]) {
            throw npe;
        }
        if (y < 0 || y >= border[1]) {
            throw npe;
        }
        return (border[0] * y + x);
    }
    public int[] toLocation(int n){
        int[] location = new int[2];
        location[0] = n % border[0];
        location[1] = n / border[1];
        return location;
    }

    // Locatable Object methods

    public HashMap<Integer, Locatable> getBoard() { return board; }

    public Locatable getLocatable(int x, int y){
       return board.get(toInt(x, y));
    }
    public void setLocatable (int x, int y , Locatable newSquare) { board.put(toInt(x, y), newSquare); }
    /**
     * @param xMove 구할 지점 = 기준점 + xMove
     * @param yMove 구할 지점 = 기준점 + yMove
     * @param originPoint 지정의 기준점
     * @return 일정한 x, y 만큼 떨어진 Locatable
     */
    public Locatable getAnotherLocAble(int xMove, int yMove, Locatable originPoint){
        int anotherX = originPoint.getX() + xMove;
        int anotherY = originPoint.getY() + yMove;
        return board.get(toInt(anotherX, anotherY));
    }

    public int getX (Locatable locAble) { return locAble.getX(); }
    public int getY (Locatable locAble) { return locAble.getY(); }

    public void printBoard(){
        for (int i = 0 ; i < border[0] ; i++) {
            for (int j = 0 ; j < border[1] ; j++) {
                System.out.print(getLocatable(i, j).getSymbol());
            }
            System.out.println();
        }
    }
}
