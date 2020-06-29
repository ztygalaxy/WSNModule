package Utils;

import Config.Config;
import Unity.Sensor;

import java.util.List;

/**
 * @Description 公式计算
 * @Author Zhang Tianyu
 * @Date 2020/2/08 0018 16:29
 * @Version 1.0
 **/
public class CalUtil {

    public static double calDistance(Sensor node1, Sensor node2) {
        return Math.sqrt(Math.pow(node1.getnX() - node2.getnX(), 2) + Math.pow(node1.getnY() - node2.getnY(), 2));
    }

    public static double calDistance(int x, int y, int x1, int y1) {
        return Math.sqrt(Math.pow(x1 - x, 2) + Math.pow(y1 - y, 2));
    }

    public static boolean inRadio(Sensor node1, Sensor node2) {
        if (calDistance(node1, node2) <= node1.getnSeradio())
            return true;
        return false;
    }

    public static int calLive(List<Sensor> sensorList) {
        int i = 0;
        for (Sensor sensor : sensorList)
            if (sensor.getBattery() > 0)
                i++;
        return i;
    }

    public static void updatePosition(List<Sensor> nodeList, int t) {
        for (Sensor sensor : nodeList) {
            if (sensor.geteX() == -1 || sensor.geteY() == -1 || sensor.getBattery() <= 0) {
                sensor.setStartTime(t);
                sensor.setsX(sensor.getnX());
                sensor.setsX(sensor.getnX());
            } else {
                int time = (int) (CalUtil.calDistance((int) sensor.getsX(), (int) sensor.getsY(), (int) sensor.geteX(), (int) sensor.geteY()) / Config.speed);
                if (sensor.getStartTime() > t) {
                    sensor.setsX(sensor.getnX());
                    sensor.setsY(sensor.getnY());
                    continue;
                } else if ((sensor.getStartTime() + time) <= t) {
                    sensor.setnX(sensor.geteX());
                    sensor.setnY(sensor.geteY());
                    sensor.setsX(sensor.geteX());
                    sensor.setsY(sensor.geteY());
                    sensor.seteX(-1);
                    sensor.seteY(-1);
                } else {
                    sensor.setnX(sensor.getsX() + (sensor.geteX() - sensor.getsX()) / time * (t - sensor.getStartTime()));
                    sensor.setnY(sensor.getsY() + (sensor.geteY() - sensor.getsY()) / time * (t - sensor.getStartTime()));
                }
            }
        }
    }

    public static void calCost(List<Sensor> nodeList, int slot) {
        for (Sensor node : nodeList) {
            if (node.getWakeSlot()<=slot) {
                node.setWakeFlag(1);
                int battery = (int) (node.getBattery());
                if (battery <= 0)
                    battery = 0;
                else battery -= node.getnCost().get(slot);
                node.setBattery(battery);
            }
        }
    }

    public static void calGet(List<Sensor> nodeList, int slot) {
        for (Sensor node : nodeList) {
            if (node.getsNeigh() != null && CalUtil.calLive(node.getsNeigh()) > 0) {
                if (slot==0) {
                    node.setWakeSlot(wakeTime(node));
                    node.setWakeFlag(0);
                }
                if (slot<node.getWakeSlot()&&node.getBattery()>0) {
                    int battery = (int) (node.getBattery());
                    if (battery <= 0)
                        battery = 0;
                    else battery += node.getnGet().get(slot);
                    if (battery >= 100) battery = 100;
                    node.setBattery(battery);
                }
            }
        }
    }

    public static void stateInit(List<Sensor> sensorList){
        for (Sensor sensor: sensorList)
            sensor.setUsedSlot(0);
    }

    public static int wakeTime(Sensor sensor){
        int getEnergy=0;
        int slot=1000;
        for (int i = 0; i< Config.slot; i++)
            if (getEnergy(sensor,i)>=costEnergy(sensor,i)){
                slot=i;
                break;
            }
        return slot;
    }
    public static int getEnergy(Sensor sensor, int i){
        int sum=0;
        for (int j=0;j<i;j++){
            sum+=sensor.getnGet().get(j);
        }
        return sum;
    }
    public static int costEnergy(Sensor sensor, int i){
        int sum=0;
        for (int j = i; j< Config.slot; j++){
            sum+=sensor.getnGet().get(j);
        }
        return sum;
    }

    public static void main(String[] args) {
        return;
    }
}
