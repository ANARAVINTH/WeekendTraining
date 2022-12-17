package browsercode;

import org.checkerframework.checker.units.qual.K;

public class KeywordsExample extends NewClass {

    int a = 3 ; //global varialble
    final double pie = 3.14;
    String b= "learnMore";
    public static void main(String[] args) {

        KeywordsExample k = new KeywordsExample();
        k.m2();

    }

    public void m2(){

        final int a = 1 ;

        System.out.println(a);
        System.out.println(this.a);
        System.out.println(this.b);
        System.out.println(a);
        System.out.println(super.a);

    }
}
