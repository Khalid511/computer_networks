import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.Socket;
import java.util.Base64;

public class Sendmail {


    static DataOutputStream document;

    public static void main(String[] args) throws IOException, InterruptedException {

        int delay = 1000;
        String add = "s1910776123@ru.ac.bd";
        String pass = "dbc595fb31";
        String address = new String(Base64.getEncoder().encode(add.getBytes()));
        String password = new String(Base64.getEncoder().encode(pass.getBytes()));
        SSLSocketFactory sslsocketfact = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket s = (SSLSocket) sslsocketfact.createSocket("smtp.gmail.com", 465);
        final BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
        document = new DataOutputStream(s.getOutputStream());

        send("EHLO smtp.gmail.com\r\n");
        Thread.sleep(delay);
        System.out.println("Server: "+reader.readLine());
        System.out.println("Server: "+reader.readLine());
        System.out.println("Server: "+reader.readLine());
        System.out.println("Server: "+reader.readLine());
        System.out.println("Server: "+reader.readLine());
        System.out.println("Server: "+reader.readLine());
        System.out.println("Server: "+reader.readLine());
        System.out.println("Server: "+reader.readLine());
        System.out.println("Server: "+reader.readLine());

        send("AUTH LOGIN\r\n");
        Thread.sleep(delay);
        System.out.println("Server: "+reader.readLine());

        send(address+"\r\n");
        Thread.sleep(delay);
        System.out.println("Server: "+reader.readLine());

        send(password+"\r\n");
        Thread.sleep(delay);
        System.out.println("Server: "+reader.readLine());

        send("MAIL FROM:<s1910776123@ru.ac.bd>\r\n");
        Thread.sleep(delay);
        System.out.println("Server "+reader.readLine());

        send("RCPT TO:<shohag9438@gmail.com>\r\n");
        Thread.sleep(delay);
        System.out.println("Server "+reader.readLine());

        send("DATA\r\n");
        Thread.sleep(delay);
        System.out.println("Server: "+reader.readLine());

        Thread.sleep(delay);
        send("Subject: Mail Sending\r\n");

        //System.out.println("Server: "+reader.readLine());

        Thread.sleep(delay);
        send("Hi!!!\r\n");
        //Thread.sleep(delay);
        //System.out.println("Server: "+reader.readLine());


        send(".\r\n");
        Thread.sleep(delay);
        //System.out.println("Server: "+reader.readLine());


        send("QUIT\r\n");
    }

    private static void send(String s) throws IOException{
        document.writeBytes(s);
        System.out.println("Client "+s);
    }
}
