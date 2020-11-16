package part2.lesson7method;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
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
                                //isAuthorized.set(true);
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
                    out.writeUTF(scanner.nextLine());
                } catch (IOException e) {
                    throw new RuntimeException("SWW", e);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
