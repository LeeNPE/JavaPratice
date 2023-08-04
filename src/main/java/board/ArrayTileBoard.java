package board;

import java.util.ArrayList;

public class ArrayTileBoard<T> {

    private final ArrayList<T> board;

    public final int SIZE_X;
    public final int SIZE_Y;

    public ArrayTileBoard(int borderX, int boarderY){
        this.SIZE_X = borderX;
        this.SIZE_Y = boarderY;
        board = new ArrayList<T>(SIZE_X * SIZE_Y);
    }

    public T getCell (int x, int y) {
        int location = toBoardLocation(x, y);
        return board.get(location);
    }

    private int toBoardLocation (int x, int y) {
        
        if(x >= SIZE_X) throw new ArrayIndexOutOfBoundsException();
        if(y >= SIZE_Y) throw new ArrayIndexOutOfBoundsException();

        return x * SIZE_Y + y;
    }
    
}