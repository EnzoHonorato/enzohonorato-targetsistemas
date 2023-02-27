public class Pergunta3 {
    public static void main(String[] args) {
        int[] faturamentos = new int[]{14000, 0, 4000, 15000, 16000, 0, 17000, 18000, 19000};
        int numeroDiasFaturamentoMaiorQueZero = 0, somaFaturamentos = 0, numeroDiasFaturamentoMaiorQueMedia = 0;
        int menorFaturamento = faturamentos[0], maiorFaturamento = faturamentos[0];

        float mediaFaturamento;

        for (int i = 0; i < faturamentos.length; i++) {
            if (faturamentos[i] > 0) {
                numeroDiasFaturamentoMaiorQueZero++;
                somaFaturamentos += faturamentos[i];
                if (faturamentos[i] < menorFaturamento) menorFaturamento = faturamentos[i];
                if (faturamentos[i] > maiorFaturamento) maiorFaturamento = faturamentos[i];
            }
        }

        mediaFaturamento = (float) somaFaturamentos / numeroDiasFaturamentoMaiorQueZero;

        for (int i = 0; i < faturamentos.length; i++) {
            if (faturamentos[i] > mediaFaturamento) numeroDiasFaturamentoMaiorQueMedia++;
        }

        System.out.println("Menor faturamento: " + menorFaturamento);
        System.out.println("Maior faturamento: " + maiorFaturamento);
        System.out.println("Média de faturamento: " + mediaFaturamento);
        System.out.println("Número de dias com faturamento maior que a média: " + numeroDiasFaturamentoMaiorQueMedia);


    }
}
