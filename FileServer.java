import java.io.*;
import java.net.*;

public class FileServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        Socket socket = serverSocket.accept();
        InputStream in = socket.getInputStream();
        OutputStream out = new FileOutputStream("received_file.txt");
        byte[] bytes = new byte[1024];
        int count;
        while ((count = in.read(bytes)) > 0) {
            out.write(bytes, 0, count);
        }
        out.close();
        in.close();
        socket.close();
        serverSocket.close();
    }
}
