import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Prserver  {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(7500);
        Socket check = ss.accept();
        DataInputStream input = new DataInputStream(check.getInputStream());
        String message = input.readUTF();
        System.out.println(message);
        ss.close();
    }
}
