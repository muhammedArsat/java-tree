class Student{

    int id;
    String name;
    Student(int id, String Name){
        this.id = id;
        this.name = Name;
    }

  public  String toString(){
    return "Student[id + ]"+id+", name =  "+name+".";
    }


}

public class Child{
    public static void main(String[] args) {
        Student s1 = new Student(101, "arsath");
        System.out.println(s1);
    }
}
