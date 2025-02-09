 interface  Engine {

    public void start();
}

class PetrolEngine implements Engine{


    public void start(){
            System.out.println("Petrol Engine is Started....");
    }
}

class DieselEngine implements Engine{
    public void start(){
        System.out.println("Diesel Engine is Started....");
    }
}

class EngineFactory{
    String engineType = "";

    EngineFactory(String engineType)
    {
       this. engineType = engineType;
    }

    public static Engine  getEngine(String engineType){
    Engine e ;
        if(engineType.equals("Petrol")){
            e = new PetrolEngine();
    }else{
        e = new DieselEngine();
    }

    return e;
    }



}
class Car{
    Engine e;
    Car(Engine e){
        this.e = e;
    }


void move(){
    e.start();
    System.out.println("Car is Moving");
}

}

 class LooslyCoupling {
    public static void main(String[] args) {
    Engine getEngine =EngineFactory.getEngine("Diesel");
    Car car = new Car(getEngine);
    car.move();
    }



}
