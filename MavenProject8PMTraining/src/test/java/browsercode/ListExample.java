package browsercode;

import java.util.ArrayList;
import java.util.List;

public class ListExample {

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();

        list.add("Aravinth");
        list.add("LearnMore");

        System.out.println(list);
        list.add("Madurai");
        System.out.println(list);

        for(String u:list){
            System.out.println(u);
        }

    }
}
