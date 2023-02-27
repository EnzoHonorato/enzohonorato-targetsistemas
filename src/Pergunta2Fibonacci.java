import java.util.Scanner;

public class Pergunta2Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numero;
        int[] fibonacci = new int[]{0, 1, 0};

        System.out.print("Digite um número inteiro e descubra se ele pertence à sequência de Fibonacci: ");
        numero = scanner.nextInt();
        scanner.close();

        if (numero == 0) {
            System.out.println("O número 0 PERTENCE à sequência de Fibonacci!");
            return;
        }

        while (true) {
            fibonacci[2] = fibonacci[0] + fibonacci[1];
            fibonacci[0] = fibonacci[1];
            fibonacci[1] = fibonacci[2];

            if (numero == fibonacci[2]) {
                System.out.println("O número " + numero + " PERTENCE à sequência de Fibonacci!");
                break;
            } else if (numero < fibonacci[2]) {
                System.out.println("O número " + numero + " NÃO pertence à sequência de Fibonacci!");
                break;
            }
        }


    }
}
