class Faturamento {
    public String estado;
    public double valor;
    public double percentual;

    public Faturamento(String estado, double valor) {
        this.estado = estado;
        this.valor = valor;
    }
}

public class Pergunta4 {
    public static void main(String[] args) {

        Faturamento[] faturamentos = new Faturamento[]{
                new Faturamento("SP", 67836.43),
                new Faturamento("RJ", 36678.66),
                new Faturamento("MG", 29229.88),
                new Faturamento("ES", 27165.48),
                new Faturamento("Outros", 19849.53)
        };

        double totalFaturamentos = 0;

        for (Faturamento faturamento : faturamentos) {
            totalFaturamentos += faturamento.valor;
        }

        System.out.println("Total dos faturamentos: " + totalFaturamentos);
        for (Faturamento faturamento : faturamentos) {
            faturamento.percentual = (faturamento.valor / totalFaturamentos) * 100;
            System.out.println("Estado " + faturamento.estado + " com faturamento " + faturamento.valor + " e com percentual de: " + faturamento.percentual + " %");
        }

    }
}
