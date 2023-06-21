package gridFrame;

public interface Locatable {

    void setX(int x);
    void setY(int y);

    int getX();
    int getY();

    char getSymbol();

    /**
     * "격자판위에 객체를 생성" 용도
     */
    Locatable newObj();
}
