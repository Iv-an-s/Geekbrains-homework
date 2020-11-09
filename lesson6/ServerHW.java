package part2.lesson6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicBoolean;

public class ServerHW {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private DataInputStream in;
    private DataOutputStream out;

    public ServerHW(){
        try {
            System.out.println("Server is starting up...");
            serverSocket = new ServerSocket(8888);
            System.out.println("Server is waiting for connection...");
            clientSocket = serverSocket.accept();
            System.out.println();
            System.out.println("Client connected: " + clientSocket);

            in = new DataInputStream(clientSocket.getInputStream());
            out = new DataOutputStream(clientSocket.getOutputStream());

            AtomicBoolean isAlive = new AtomicBoolean(true);

            Thread thread = new Thread(()->{
                while (isAlive.get()){
                    String incomingMessage = null;
                    try {
                        incomingMessage = in.readUTF();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Client message: " + incomingMessage);
                    if (incomingMessage.contains("exit")){
                        isAlive.set(false);
                        System.out.println("Client left the chat");
                        System.out.println("Please, type any button to exit");
                        break;
                    }
                }
            });
            thread.start();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            while (true){
                if (!isAlive.get()){
                    bufferedReader.close();
                    break;
                }
                System.out.println("Please, type a message ...");
                String serverMessage = bufferedReader.readLine();
                out.writeUTF(serverMessage);
                if (serverMessage.contains("exit")){
                    System.out.println("Server is leaving the chat. Bye-bye!");
                    System.out.println("...but only after Client...");
                    isAlive.set(false);
                    break;
                }
            }
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        closeResources();
    }

    public void closeResources(){
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
