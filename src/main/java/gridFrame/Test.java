package gridFrame;

public class Test {
    public static void main(String[] args) {
        GridBoard g = new GridBoard(10, 10, new testObj());
        testObj t1 = (testObj) g.getLocatable(3, 3);
        testObj t2 = new testObj();
        t2.newMethod();
        t1.newMethod();
    }
}
class testObj extends Square{
    int a = 0;
    @Override
    public Locatable newObj() {return new testObj();}
    void newMethod(){
        System.out.println( a + "testObj method");
    }
}