import java.util.ArrayList;
import java.util.List;

public class demo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("192");
        list.add("168");
        list.add("200");
        list.add("200");
        String join = String.join(".", list);
        System.out.println(join);
    }
}
