package org.example;

import java.util.HashMap;

public class GridBoard {
    HashMap<int[], Locatable> board = new HashMap<int[], Locatable>();
    GridBoard(int xBorder, int yBoarder, Locatable[] locAbles) throws ArrayIndexOutOfBoundsException{
        for(int i = 0; i < xBorder;i++){
            for(int j = 0; j < xBorder;j++) {
                Locatable locatedObj = locAbles[xBorder * j + i];
                locatedObj.setX(i); locatedObj.setY(j);
                board.put(toArray(i,j), locatedObj);
            }
        }
    }
    private int[] toArray(int x, int y){
        int[] location = {x, y};
        return location;
    }
    Locatable getTile(int x, int y){
       return board.get(toArray(x, y));
    }
    int getX(Locatable locAble){
        return locAble.getX();
    }
    int getY(Locatable locAble){
        return locAble.getY();
    }
}
