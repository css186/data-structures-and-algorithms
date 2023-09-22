import java.util.ArrayList;

public class ArrayListDemo {

    public static void main(String[] args) {
        ArrayList<String> list;
        list = new ArrayList<>();

        list.add("item1");
        list.add("item2");

        System.out.println(list);

        int position = list.indexOf("item2");
        System.out.println(position);

        boolean check = list.isEmpty();
        System.out.println(check);

        String item = list.get(0);
        System.out.println(item);


        for (String str: list) {
            System.out.println(str);
        }

        String[] newArray = new String[list.size()];

        list.toArray(newArray);

        // this will print out the address
        System.out.println(newArray);

        for (String str : newArray) {
            System.out.println(str);
        }
    }

}
