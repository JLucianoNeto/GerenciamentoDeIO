import java.io.RandomAccessFile;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        long tempoInicial, tempoEstimado;

        ManipulacaoArq maniquivo = new ManipulacaoArq();
        Scanner scr = new Scanner(System.in);

        System.out.println("Digite o caminho do arquivo");
        String caminhoString = scr.nextLine();
        if (caminhoString == "") {
            caminhoString = ".\\teste.txt"; // caminho padrao para realizar testes
        }

        maniquivo.setCaminho(caminhoString);
        // FileWriter arquivo=maniquivo.AbreArquivoEscrita();
        tempoInicial = System.nanoTime();
        RandomAccessFile arq = maniquivo.abreArquivoEscrita();
        tempoEstimado = System.nanoTime() - tempoInicial;
        ControleTempo.appendTempoExecucao(tempoEstimado,"Abertura");

        tempoInicial = System.nanoTime();
        maniquivo.escreverArquivo(arq, "Mensagem 1");
        tempoEstimado = System.nanoTime() - tempoInicial;
        ControleTempo.appendTempoExecucao(tempoEstimado,"Escrita");

        tempoInicial = System.nanoTime();
        maniquivo.escreverArquivo(arq, "Mensagem 2");
        tempoEstimado = System.nanoTime() - tempoInicial;
        ControleTempo.appendTempoExecucao(tempoEstimado,"Escrita");

        tempoInicial = System.nanoTime();
        maniquivo.escreverArquivo(arq, "Mensagem 3");
        tempoEstimado = System.nanoTime() - tempoInicial;
        ControleTempo.appendTempoExecucao(tempoEstimado,"Escrita");

        //
        tempoInicial = System.nanoTime();
        maniquivo.lerCompleto();
        tempoEstimado = System.nanoTime() - tempoInicial;
        ControleTempo.appendTempoExecucao(tempoEstimado,"Leitura");
        // maniquivo.FechaArquivoEscrita(arquivo);
        System.out.println("\n---------------------------------\n");
        System.out.println(maniquivo.toString());

        tempoInicial = System.nanoTime();
        arq.close();
        tempoEstimado = System.nanoTime() - tempoInicial;
        ControleTempo.appendTempoExecucao(tempoEstimado,"Fechamento");


        scr.close();
    }
}

// Vou deixar para tratar erros depois que finalizar tudo

// Primeiramente, pedir o nome do arquivo //

// Criar o objeto da classe RandomAcessFile pois
// Com ele posso ter mais liberdade

// Criar a função para abrir o arquivo vai ter o tipo dele
/* abrirArquivo( FILE arq ){} E testar as coisas dele */

// Criar a função para ler o arquivo
/* No caso vou mostrar previamente o conteudo do arquivo */

// --- Criar função para buscar

// Criar a função para escrever no arquivo
/*
 * Lembrando que aqui sempre vou escrever no final do arquivo
 * 
 * Formato da mensagem
 * /n{id:1234,mensagem:"Essa é a mensagem"}/n
 * 
 *
 */

// Os dados que vou simular
// Criar a função para escrever no arquivo
/*
 * Oque vai acontecer aqui: Preciso que o proximo
 * dado seja passado no fim do arquivo
 */