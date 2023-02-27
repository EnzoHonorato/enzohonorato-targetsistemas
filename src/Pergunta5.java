import java.util.Scanner;

public class Pergunta5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder mensagem;
        String aux1, aux2;

        System.out.print("Digite uma mensagem para ser invertida: ");
        mensagem = new StringBuilder(scanner.nextLine());
        scanner.close();

        int esquerda = 0, direita = mensagem.length() - 1;

        while (true) {
            if (esquerda == direita || direita < esquerda) break;

            aux1 = mensagem.substring(esquerda, esquerda + 1);
            aux2 = mensagem.substring(direita, direita + 1);

            mensagem.replace(esquerda, esquerda + 1, aux2);
            mensagem.replace(direita, direita + 1, aux1);

            esquerda++;
            direita--;
        }

        System.out.println("Mensagem invertida: " + mensagem);


    }
}
