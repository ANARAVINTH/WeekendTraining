package browsercode;

public class ArrayExamples {

    public static void main(String[] args) {

        int [] a = {56,89,12,56}; // 0,1,2,3
        String [] b = {"abc","xyx"};

        System.out.println(a[0]);
        a[4] = 23;
        System.out.println(a[4]);

        for(int i =0 ;i < b.length ; i++){
            System.out.println(b[i]);
            
        }

        for(int oupput:a){
            System.out.println(oupput);
        }

        for(String out:b){
            System.out.println(out);
        }

    }

}
