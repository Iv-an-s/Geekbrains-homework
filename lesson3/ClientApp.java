package part3.lesson3;

import part3.lesson3.history.HistoryService;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class ClientApp {

    public static void main(String[] args) {

        try{
            Socket socket = new Socket("localhost", 8189);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            //AtomicBoolean isAuthorized = new AtomicBoolean(false);
            AtomicBoolean isStopped = new AtomicBoolean(false);

            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        while (true){
                            String strFromServer = in.readUTF();
                            if (strFromServer.startsWith("/auth OK")){
                                HistoryService.printLastNLines(100);
                                break;
                            }
                            System.out.println(strFromServer);
                        }
                        while (true){
                            String strFromServer = in.readUTF();
                            if (strFromServer.equalsIgnoreCase("/end")){
                                isStopped.set(true);
                                break;
                            }
                            HistoryService.saveToHistory(strFromServer);
                            System.out.println(strFromServer);
                        }
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            });
            t.setDaemon(true);
            t.start();

            Scanner scanner = new Scanner(System.in);
            while (true) {
                if (isStopped.get()){
                    System.out.println("Client left the chat");
                    break;
                }
                try {
                    System.out.println("Please, type your message ..");
                    String message = scanner.nextLine();
                    out.writeUTF(message);
                    HistoryService.saveToHistory(message);
                } catch (IOException e) {
                    throw new RuntimeException("SWW", e);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
