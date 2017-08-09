package Connection;

import java.net.*;
import java.util.*;

public class Client {
    public static void main(String Stmt) {
        DatagramSocket ds = null;
        DatagramPacket sendDp;
        DatagramPacket receiveDp;

        String serverHost = "127.0.0.1";

        int serverPort = 10010;
        try {
            ds = new DatagramSocket();
            byte[] data = Stmt.getBytes();

            InetAddress address = InetAddress.getByName(serverHost);
            sendDp = new DatagramPacket(data, data.length, address, serverPort);

            ds.send(sendDp);
            // sent

            byte[] b = new byte[1024];

            receiveDp = new DatagramPacket(b, b.length);

            ds.receive(receiveDp);

            byte[] response = receiveDp.getData();

            int len = receiveDp.getLength();

            String s = new String(response, 0, len);

            System.out.println("feedback: " + s);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            {
                try {
                    ds.close();
                } catch (Exception e) {}
            }
        }
    }
}

