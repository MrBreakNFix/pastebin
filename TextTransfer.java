import java.io.*;
import java.net.*;

public class TextTransfer {
    public static void main(String[] args) throws IOException {
        // Get the IP address of the destination computer
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the IP address of the destination computer: ");
        String ipAddress = reader.readLine();

        // Connect to the server
        Socket socket = new Socket(ipAddress, 8000);

        // Open the input and output streams
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

        // Get the text to send from the console
        System.out.print("Enter the text to send: ");
        String text = reader.readLine();

        // Send the text
        output.println(text);

        // Receive the response from the server and print it to the console
        String response = input.readLine();
        System.out.println("Response from server: " + response);

        // Close the streams and socket
        input.close();
        output.close();
        socket.close();
    }
}
