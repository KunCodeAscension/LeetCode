package day13_work;

public class id_2698_1 {
    private int NUM= 0;

    public int punishmentNumber(int n) {
        for (int i = 1; i < n; i++) {
            if(is(i)) NUM += i * i;
        }
        return NUM;
    }

    public static boolean is(int i){
        String n = i * i + "";
        if (f(n,0,0,i)) return true;
        else return false;
    }

    public static boolean f(String n,int i,int num,int a){
        if(i == n.length()){
            return num == a;
        }
        boolean b = false;
        for(int j = i;j < n.length();j++){
            if(f(n,j+1,num + Integer.parseInt(n.substring(i,j+1)),a)){
                return true;
            }
        }
        return b;
    }

    public static void main(String[] args) {
        boolean b = is(10);
        System.out.println(b);
    }
}
