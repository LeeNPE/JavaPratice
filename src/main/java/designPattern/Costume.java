package designPattern;

class test{
    public static void main(String[] args) {
        Costume body = new Costume("body");
        Costume shirt = new Costume(body, "shirt");
        Costume outwear = new Costume(shirt, "outwear");
        Costume armor = new Costume(outwear, "armor");
        Costume cloak = new Costume(armor, "cloak");
        cloak.costumeShow();
    }
}
public class Costume {
    Costume innerCostum;
    String costume;
    Costume(String costume) {
        this.costume = costume;
    }
    Costume(Costume innerCostum , String costume){
        this.innerCostum = innerCostum;
        this.costume = costume;
    }
    void costumeShow(){
        System.out.println(costume);
        if (innerCostum == null) {
            System.out.println("endShow");
        } else {
           innerCostum.costumeShow();
        }
    }
}
