import java.io.IOException;
import java.io.RandomAccessFile;

public class ControleTempo {

    public static void appendTempoExecucao(long tempo, String metodo) throws IOException {
        String tempoString="";
        RandomAccessFile raFile = new RandomAccessFile(".\\tempoExecução.txt", "rw");
        raFile.seek(raFile.length());
        tempoString = String.valueOf(tempo);
        tempoString = tempoString + " -- " + metodo + "\n";
        // System.out.println("current pointer = "+raFile.getFilePointer());
        raFile.write(tempoString.getBytes());
        raFile.close();

    }
}
