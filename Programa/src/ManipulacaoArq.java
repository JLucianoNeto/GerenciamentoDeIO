import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ManipulacaoArq {
    private int controleLeitura, controleEscrita;
    private String caminhoArquivo;

    public ManipulacaoArq() {
        this.controleEscrita = 0;
        this.controleLeitura = 0;
        this.caminhoArquivo = "";
    }

    public void setCaminho(String caminho) {
        this.caminhoArquivo = caminho;
    }

    public void FlushControle() {
        this.controleEscrita = 0;
        this.controleLeitura = 0;
    }

    public String toString() {
        return " Número de escritas: " + this.controleEscrita + "\n" + " Número de leituras: " + this.controleLeitura;
    }

    public void lerCompleto() {
        try { // Tratamento de erro
            FileReader arq = new FileReader(this.caminhoArquivo);
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine(); // lê a primeira linha
            while (linha != null) {
                System.out.printf("%s\n", linha); // Aqui está lendo
                linha = lerArq.readLine(); // lê da segunda até a última linha
            }
            this.controleLeitura = this.controleLeitura + 1;
            arq.close();

        } catch (IOException e) { // Tratamento de erro
            System.out.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }

    }
    /*
     * public void FechaArquivoLeitura(FileReader arq) {
     * try {
     * arq.close();
     * } catch (IOException e) {
     * System.out.printf("Erro para fechar o arquivo: %s.\n", e.getMessage());
     * }
     * }
     */

    /*
     * public FileReader AbreArquivoLeitura() {
     * try {
     * FileReader arq = new FileReader(this.caminhoArquivo);
     * return arq;
     * } catch (IOException e) {
     * System.out.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
     * return null;
     * }
     * }
     */

    public void escreverArquivo(RandomAccessFile arquivo, String mensagem) {
        
        try {
            
            // FileWriter arq = new FileWriter(this.caminhoArquivo); // Cria o objeto do
            // tipo FileWriter associado
            // ao arquivo tabuada.txt que será criado
            // RandomAccessFile arquivo = new RandomAccessFile(this.caminhoArquivo, "rw");

            // gravarArq.seek(gravarArq.length());
            mensagem = mensagem + "\n";

            arquivo.write(mensagem.getBytes());

            this.controleEscrita = this.controleEscrita + 1;

        } catch (IOException e) { // Tratamento de erro
            System.out.printf("Erro durante a escrita do arquivo: %s.\n", e.getMessage());
        }

    }
    /*
     * public void closeEscrita(RandomAccessFile arq) {
     * try {
     * arq.close();
     * } catch (IOException e) {
     * System.out.printf("Erro para fechar o arquivo: %s.\n", e.getMessage());
     * }
     * }
     */

    public RandomAccessFile abreArquivoEscrita() {
        try {
            RandomAccessFile arq = new RandomAccessFile(this.caminhoArquivo, "rw");
            return arq;
        } catch (IOException e) {
            System.out.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
            return null;
        }
    }

    

}
