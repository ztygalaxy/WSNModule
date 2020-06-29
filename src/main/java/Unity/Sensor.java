package Unity;

import java.util.List;

/**
 * @Description 传感器节点类
 * @Author Zhang Tianyu
 * @Date 2020/2/08 0018 16:31
 * @Version 1.0
 **/

public class Sensor extends Node {
    public Sensor(int nId, double nX, double nY, double battery, List<Integer> nCost, List<Integer> nGet, List<Message> messages, double nSeradio, List<Sensor> sNeigh) {
        super(nId, nX, nY, battery, nCost, nGet, messages, nSeradio, sNeigh);
    }

    @Override
    public String toString() {
        return super.getnId() + "," + super.getnX() + "," + super.getnY() + "," + super.getBattery() + "," + super.getnSeradio();
    }
}
