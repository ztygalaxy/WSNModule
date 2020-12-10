package Utils;
import Config.Config;
import Unity.Message;
import Unity.Sensor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 算法
 * @Author Zhang Tianyu
 * @Date 2020/2/08 0018 16:27
 * @Version 1.0
 **/
public class AlgoUtil {

    /*algo interface*/
    public static void deal(List<Sensor> nodeList, int time, List<Message> messages) {
        GraphUtil.geneNeigh(nodeList);
        CalUtil.calCost(nodeList, (time % Config.slot));
        CalUtil.calGet(nodeList, (time % Config.slot));
        CalUtil.updatePosition(nodeList, time);
//        CalUtil.stateInit(nodeList);
    }

    public static void main(String[] args) {
        System.out.println("dssd");
    }
}
