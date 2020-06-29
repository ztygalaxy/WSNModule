package Utils;

import Unity.Sensor;

import java.util.*;

/**
 * @Description gene graph
 * @Author Zhang Tianyu
 * @Date 2020/2/08 0018 16:30
 * @Version 1.0
 **/

public class GraphUtil {
    private int[][] graph;

    /*生成拓扑关系矩阵*/
    public static int[][] geneGraph(List<Sensor> nodeList) {
        geneNeigh(nodeList);
        int[][] graph = new int[nodeList.size()][nodeList.size()];
        for (int i = 0; i < graph.length; i++)
            for (int j = 0; j < graph[i].length; j++)
                graph[i][j] = 0;
        for (Sensor sensor : nodeList) {
            if (sensor.getsNeigh() != null) {
                for (Sensor sensor1 : sensor.getsNeigh()) {
                    graph[sensor.getnId() % nodeList.size()][sensor1.getnId() % nodeList.size()] = 1;
                }
            }
        }
        return graph;
    }

    /*寻找邻居*/
    public static void geneNeigh(List<Sensor> nodeList) {
        for (Sensor sensor0 : nodeList) {
            List<Sensor> nNeigh = new ArrayList<>();
            for (Sensor sensor1 : nodeList)
                if (sensor0.getnId() != sensor1.getnId())
                    if (CalUtil.inRadio(sensor0, sensor1))
                        nNeigh.add(sensor1);
            sensor0.setsNeigh(nNeigh);
        }
    }

//    public static void sendMessage(List<Sensor> nodeList, Message message) {
//        int send = message.getSenderId();
//        int rece = message.getReceId();
//        for (Sensor node : nodeList)
//            if (node.getnId() == rece)
//                node.setnMess(message);
//    }


    public static void main(String[] args) {
        List<Sensor> sensorList = DataUtil.readFromFile();
        int[][] a = GraphUtil.geneGraph(sensorList);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j]);
            }
            System.out.println("");
        }
    }
}