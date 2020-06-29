package Unity;

import java.util.List;

/**
 * @Description BaseStation
 * @Author Zhang Tianyu
 * @Date 2020-02-20 10:44
 * @Version 1.0
 **/
public class BaseStation extends Node {
    public BaseStation(int nId, double nX, double nY, double battery, List<Integer> nCost, List<Integer> nGet, List<Message> messages, double nSeradio, List<Sensor> sNeigh) {
        super(nId, nX, nY, battery, nCost, nGet, messages, nSeradio, sNeigh);
    }
}