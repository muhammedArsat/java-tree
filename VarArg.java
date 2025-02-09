public class VarArg {

    public  void m1(int...a){

        for(int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
    }

    public static void main(String[] args) {
        VarArg v = new VarArg();
       v. m1(1,2,3);
        v.m1(new int[]{1,2,3});
    }
}
