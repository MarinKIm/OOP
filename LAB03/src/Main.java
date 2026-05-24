import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        String s1 = "I hate going to school but I don't hate Java";
        System.out.println(s1);
        int n1 = s1.indexOf("hate");
        System.out.println(n1);
        s1 = s1.replace("hate","love");
        s1 = s1.replace("but", "and");
        System.out.println(s1);
        Scanner ky = new Scanner(System.in);
        int n2 = ky.nextInt();

        for(int i=1;i<11;i++){
            System.out.printf("%2d multiplied by %2d = %2d\n", i, n2, i*n2);
        }

    }
}
