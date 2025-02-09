abstract class Animal{

 public abstract Object eat();
}


class Tiger extends Animal{

    public String eat(){
        return "Eating Meat";

    }

}

class Cow extends Animal{

    public Integer eat(){
        return 2;
    }
}


public class OverRide {

    public static void main(String[] args) {
        Animal tiger = new Tiger();
        Animal cow = new Cow();

       Object  tigerEat =tiger.eat();
        Object cowEat = cow.eat();
        System.out.println(tigerEat+"........"+cowEat);

    }

}
