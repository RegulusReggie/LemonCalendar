package Connection;

import Entity.*;
import Util.Commons;
import Util.JSONObject;

import java.net.*;

public class Client {

    public static Object requestHanlder(JSONObject reqobj) {
        Object respObj = null;

        DatagramSocket ds = null;
        DatagramPacket sendDp;
        DatagramPacket receiveDp;

        String serverHost = "172.20.10.10";
        int serverPort = 10010;

        try {
            ds = new DatagramSocket();
            byte[] data = reqobj.toString().getBytes();

            InetAddress address = InetAddress.getByName(serverHost);
            sendDp = new DatagramPacket(data, data.length, address, serverPort);

            byte[] b = new byte[1024];
            receiveDp = new DatagramPacket(b, b.length);
            ds.setSoTimeout(5000);

            // sent

            while (true) {
                try {
                    ds.send(sendDp);
                    ds.receive(receiveDp);
                } catch (SocketTimeoutException ste) {
                    System.err.println("Request Time Out " + data);
                    continue;
                }
                break;
            }

            byte[] response = receiveDp.getData();

            int len = receiveDp.getLength();

            String s = new String(response, 0, len);

            JSONObject respobj = Commons.parseJSONObjectFromString(s);

            switch (Integer.valueOf(respobj.getField(Commons.TYPE))) {
                case Commons.RESPOND_CALENDAR:
                    respObj = Calendar.parseJSON(respobj);
                    break;
                case Commons.RESPOND_EVENT:
                    respObj = Event.parseJSON(respobj);
                    break;
                case Commons.RESPOND_USER:
                    respObj = User.parseJSON(respobj);
                    break;
                case Commons.RESPOND_GROUP:
                    respObj = Group.parseJSON(respobj);
                    break;
                case Commons.RESPOND_CALENDAR_ID:
                    respObj = Integer.valueOf(respobj.getField(Commons.CALENDAR_ID));
                    break;
                case Commons.RESPOND_USER_ID:
                    respObj = Integer.valueOf(respobj.getField(Commons.USER_ID));
                    break;
                case Commons.RESPOND_EVENT_ID:
                    respObj = Integer.valueOf(respobj.getField(Commons.EVENT_ID));
                    break;
                case Commons.RESPOND_GROUP_ID:
                    respObj = Integer.valueOf(respobj.getField(Commons.GROUP_ID));
                    break;
                case Commons.RESPOND_GROUP_IDS:
                    respObj = respobj.getField(Commons.GROUP_IDS);
                    break;
                case Commons.SUCCESS:
                    System.out.println("Request Succuess");
                    break;
                case Commons.FAIL:
                    System.out.println("Request Failed");
                    break;
                case Commons.NOT_FOUND:
                    System.out.println("Item Not Found");
                    break;
                case Commons.REQ_NOT_FOUND:
                    System.out.println("Request Not Found");
                    break;
                default:
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            {
                try {
                    ds.close();
                } catch (Exception e) {}
            }
        }
        return respObj;
    }
}

