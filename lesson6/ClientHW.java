package part2.lesson6;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicBoolean;

public class ClientHW {
    private Socket clientSocket;
    private DataInputStream in;
    private DataOutputStream out;

    public ClientHW (){
        try {
            System.out.println("Client is starting up ...");
            clientSocket = new Socket("localhost", 8888);
            in = new DataInputStream(clientSocket.getInputStream());
            out = new DataOutputStream(clientSocket.getOutputStream());

            AtomicBoolean isAlive = new AtomicBoolean(true);

            Thread thread = new Thread(()->{
                while (isAlive.get()){
                    try {
                        String serverMessage = in.readUTF();
                        System.out.println("Server message: " + serverMessage);
                        if (serverMessage.contains("exit")){
                            System.out.println("Server don't want to chat anymore. Bye-bye!");
                            System.out.println("Please, type any button to exit");
                            isAlive.set(false);
                            break;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true){
                if (!isAlive.get()) {
                    System.out.println("There is no one to chat..");
                    reader.close();
                    break;
                }
                System.out.println("Please type in a message ...");
                String message = reader.readLine();
                out.writeUTF(message);
                if (message.contains("exit")){
                    System.out.println("Client is leaving the chat. Bye-bye!");
                    System.out.println("...but only after Server...");
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
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
