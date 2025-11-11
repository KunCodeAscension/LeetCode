import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        String p = "a.*";
        String[] split = p.split("\\.",1);
        System.out.println(Arrays.toString(split));
    }
}