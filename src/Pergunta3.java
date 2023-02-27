import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Row {
    public int dia;
    public double valor;

    public Row(int dia, double valor) {
        this.dia = dia;
        this.valor = valor;
    }

}

public class Pergunta3 {
    public static void main(String[] args) {

        XStream stream = new XStream(new DomDriver());
        stream.addPermission(AnyTypePermission.ANY);

        String linha, xmlString;
        StringBuilder xml;
        List<Row> rows = new ArrayList<>();

        File file = new File("src/dados.xml");
        FileReader fileReader;
        BufferedReader bufferedReader;

        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            while (bufferedReader.ready()) {
                xml = new StringBuilder("");

                for (int i = 0; i < 4; i++) {
                    linha = bufferedReader.readLine();
                    xml.append(linha);
                }

                xmlString = xml.toString();

                Row row = (Row) stream.fromXML(xmlString);

                rows.add(row);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        int numeroDiasFaturamentoMaiorQueZero = 0, somaFaturamentos = 0, numeroDiasFaturamentoMaiorQueMedia = 0;
        int diaMenorFaturamento = 0, diaMaiorFaturamento = 0;

        double mediaFaturamento;

        for (Row row : rows) {
            if (row.valor > 0) {
                numeroDiasFaturamentoMaiorQueZero++;
                somaFaturamentos += row.valor;
                if (row.valor < rows.get(diaMenorFaturamento).valor) diaMenorFaturamento = row.dia - 1;
                if (row.valor > rows.get(diaMaiorFaturamento).valor) diaMaiorFaturamento = row.dia - 1;
            }
        }

        mediaFaturamento = (double) somaFaturamentos / numeroDiasFaturamentoMaiorQueZero;

        for (Row row : rows) {
            if (row.valor > mediaFaturamento) numeroDiasFaturamentoMaiorQueMedia++;
        }

        System.out.println("Menor faturamento: " + rows.get(diaMenorFaturamento).valor + " no dia " + (diaMenorFaturamento + 1));
        System.out.println("Maior faturamento: " + rows.get(diaMaiorFaturamento).valor + " no dia " + (diaMaiorFaturamento + 1));
        System.out.println("Média de faturamento: " + mediaFaturamento);
        System.out.println("Número de dias com faturamento maior que a média: " + numeroDiasFaturamentoMaiorQueMedia);


    }
}
