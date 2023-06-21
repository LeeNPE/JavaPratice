package javaGame.turnFight;

public class TypeDefence {
    int defenceA, defenceB, defenceC;

    TypeDefence(int defenceA, int defenceB, int defenceC){
        this.defenceA = defenceA;
        this.defenceB = defenceB;
        this.defenceC = defenceC;
    }

    int typedValue(Type type, int value){
        switch (type) {

            case A -> {
                return getTypedValue(defenceA, value);
            }

            case B -> {
                return getTypedValue(defenceB, value);
            }

            case C -> {
                return getTypedValue(defenceC, value);
            }

            default -> {
                return 0;// 오류 상황

            }

        }
    }
    private int getTypedValue (int defenceType, int value) {
        return (100 - defenceType) * value / 100;
    }


}

enum Type{
    A, B, C
}