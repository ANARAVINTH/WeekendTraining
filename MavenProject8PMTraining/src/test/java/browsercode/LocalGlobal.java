package browsercode;

public class LocalGlobal {

    int a =5; // Global variable

    public  void m1(){
         a = 5 ; //local variable

    }

    public void m2(){

        int b = a + 2 ;

    }
}
