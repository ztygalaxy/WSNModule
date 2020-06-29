package Utils;

import Unity.Message;
import Unity.Sensor;
import sun.awt.AWTAccessor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Description TODO
 * @Author Zhang Tianyu
 * @Date 2020-03-14 11:34
 * @Version 1.0
 **/
public class MessUtil {
    public static int succNum(List<Message> messageList){
        int sum=0;
        for (Message message:messageList)
            if (message.getFinFlag()>0)
                sum++;
        return sum;
    }
    public static void messComu(List<Sensor> sensorList){
        for (Sensor sensor:sensorList){
            for (Message message:sensor.getnMess()){
                for (Sensor sensor1:sensor.getsNeigh()){
                }
            }
        }
    }
    public static void sendMessage(List<Sensor> nodeList, Message message) {
        int send = message.getSenderId();
        int rece = message.getReceId();
        for (Sensor node : nodeList)
            if (node.getnId() == rece) {
                if (node.getnMess() == null) {
                    List<Message> messageList = new ArrayList<>();
                    node.setnMess(messageList);
                }
                List<Message> messageList1=node.getnMess();
                messageList1.add(message);
                node.setnMess(messageList1);
            }
    }

    //water
    public static void sendMess(Sensor sensor, List<Sensor> nodeList, List<Message> messages, int sourceid) {
        if (sensor.getWakeFlag()>0) {
            if (sensor.getnMess()==null||sensor.getsNeigh()==null||sensor.getnMess().size()==0||sensor.getsNeigh().size()<1)
                return;
            for (Message message:sensor.getnMess()) {
                for (Message message1:messages)
                    if (message.getMessId()==message1.getMessId()) {
                        message=message1;
                        messages.get(messages.indexOf(message)).getSensorid().add(sensor.getnId());
                    }
                if (message.getFinFlag()==0) {
                    for (Sensor sensor1 : nodeList.get(nodeList.indexOf(sensor)).getsNeigh()) {
                        //先判断该消息是否已经去过sensor1
                        if (messages.get(messages.indexOf(message)).getSensorid().contains(sensor1.getnId())) continue;
                        if (sensor1.getWakeFlag() > 0 && sensor1.getnId() != sourceid) {
                            List<Message> messages1 = sensor1.getnMess();
                            messages1.add(message);
                            List<Message> listWithoutDup = new ArrayList<>(new HashSet<>(messages1));
                            sensor1.setnMess(listWithoutDup);
                            if (sensor1.getnId() == message.getReceId() && messages.get(messages.indexOf(message)).getFinFlag() == 0) {
                                System.out.println("Message" + message.getMessId() + "success");
                                messages.get(messages.indexOf(message)).setFinFlag(1);
                                return;
                            }
                            sendMess(sensor1, nodeList, messages, sensor.getnId());
                        }
                    }
                }
            }
        }
        else return;
    }

    //water
    public static Sensor sendMessSingle(Sensor sensor, List<Sensor> nodeList, List<Message> messages, Message message) {
        Sensor minSensor=null;
        if (sensor.getnMess().get(0).getReceId()==message.getReceId()) {
            messages.get(messages.indexOf(message)).setFinFlag(1);
            System.out.println(message.getMessId()+" succ");
            return sensor;
        }
        if (sensor.getWakeFlag()==0) return sensor;
        if (sensor.getnMess()==null||sensor.getnMess().size()==0) return sensor;
        double distance = 10000000000000.00;
        for (Sensor sensor2:sensor.getsNeigh()) {
            if (sensor2.getUsedSlot()==0&&CalUtil.calDistance(sensor2,nodeList.get(message.getReceId()%1000))<=distance){
                minSensor=sendMessSingle(sensor2,nodeList,messages,message);
                distance=CalUtil.calDistance(sensor2,nodeList.get(message.getReceId()%1000));
            }
        }
        nodeList.get(minSensor.getnId()%1000).setUsedSlot(1);
        return minSensor;
    }
}