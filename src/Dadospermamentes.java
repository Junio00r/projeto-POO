import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Dadospermamentes {
    public static String Reader(String caminho) {
        String dados = "";

        try {

            FileReader arq = new FileReader(caminho);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = "";

            try {

                linha = lerArq.readLine();
                while (linha != null) {
                    dados += linha;
                    linha = lerArq.readLine();
                }
                arq.close();
                return dados;
            } catch (IOException e) {
                System.out.println("Erro: Não foi possível ler o arquivo!");
                return "";
            }

        } catch (FileNotFoundException e) {
            System.out.println("Erro: Arquivo não encontrado!");
            return "";
        }
    }

    public static boolean Write(String caminho, String texto) {

        try {

            FileWriter arq = new FileWriter(caminho, true);
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.println(texto);
            gravarArq.close();

            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
