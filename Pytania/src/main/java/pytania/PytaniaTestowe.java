package pytania;


import java.util.LinkedHashMap;
import java.util.Map;

class Test14{
    static String s ="Instance";
    public static void method(String s){
        s+="Add";
    }
    public static void main(String a[]){
        Test14 t = new Test14();
        s = "New Instance";
        String s = "Local";
        method(s);
        System.out.println(s);
        System.out.println(t.s);
    }
}