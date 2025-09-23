package atividades;
import java.util.Scanner;

public class TerceiroExercicio {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int delta;
        int a, b, c;
        int x1, x2;
        System.out.println("Digite o valor de A: ");
        a = sc.nextInt();
        System.out.println("Digite o valor de B: ");
        b = sc.nextInt();
        System.out.println("Digite o valor de C: ");
        c = sc.nextInt();
        delta = (b * b) - 4 * a * c;

        if (delta < 0) {
            System.out.println("Delta negativo, nao existe raizes reais");
        } else {
            x1 = (int) ((-b + Math.sqrt(delta)) / (2 * a));
            x2 = (int) ((-b - Math.sqrt(delta)) / (2 * a));
            System.out.println("O valor de X1 e: " + x1);
            System.out.println("O valor de X2 e: " + x2);
        }
        sc.close();




       
    }
}
