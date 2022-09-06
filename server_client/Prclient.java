import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Prclient {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("127.0.0.1", 7500);
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        out.writeUTF("How you d'oin!!");
        out.flush();
        out.close();
        s.close();
    }
}
