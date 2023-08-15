package practice;

import javaGame.chess.Test;

public class TestObjectDelete {
    public static void main(String[] args) {
        for (int i = 0 ; i < 3 ; i++) {
            Tester tester = new Tester();
            System.out.println(tester);
        }
        int a = 10;
        System.out.println(new Tester().plus(a));
        System.out.println(a);
    }
}
class Tester{
    int plus(int i) {
        i++;
        return i;
    }
}