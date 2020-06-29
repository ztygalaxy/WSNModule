package Utils;

import Config.Config;
import Unity.Message;
import Unity.Sensor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description 数据输入输出
 * @Author Zhang Tianyu
 * @Date 2020/2/08 0018 16:29
 * @Version 1.0
 **/

public class DataUtil {
    public static List<Sensor> readFromFile() {
        List<Integer> nCost = new ArrayList<>();
        nCost.add(10);
        nCost.add(10);
        nCost.add(10);
        nCost.add(10);
        nCost.add(10);
        nCost.add(10);
        nCost.add(10);
        nCost.add(10);
        nCost.add(10);
        nCost.add(10);
        List<Integer> nGet = new ArrayList<>();
        nGet.add(2);
        nGet.add(2);
        nGet.add(2);
        nGet.add(2);
        nGet.add(2);
        nGet.add(2);
        nGet.add(2);
        nGet.add(2);
        nGet.add(2);
        nGet.add(2);
        List<Sensor> sensorList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(Config.readFile + ".csv"));
            reader.readLine();
            String line = null;
            while ((line = reader.readLine()) != null) {
                String item[] = line.split(",");
                List<Message> messages=new ArrayList<>();
                Sensor sensor = new Sensor(Integer.parseInt(item[0]), Double.parseDouble(item[1]), Double.parseDouble(item[2]), Double.parseDouble(item[3]), nCost, nGet, messages, Double.parseDouble(item[4]), null);
                sensorList.add(sensor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sensorList;
    }

    public boolean writeToFile(List<Sensor> sensorList) {
        try {
            File csv = new File(Config.writeFIle + ".csv");
            BufferedWriter bw = new BufferedWriter(new FileWriter(csv, false));
            bw.write("id,x,y,battery,radio");
            for (Sensor sensor : sensorList) {
                bw.newLine();
                bw.write(sensor.toString());
            }
            bw.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean writeRandom(int n, String filename) {
        List<Integer> nCost = new ArrayList<>();
        nCost.add(10);
        nCost.add(8);
        nCost.add(6);
        nCost.add(4);
        List<Integer> nGet = new ArrayList<>();
        nGet.add(5);
        nGet.add(5);
        nGet.add(5);
        nGet.add(5);
        try {
            File csv = new File(filename + ".csv");
            BufferedWriter bw = new BufferedWriter(new FileWriter(csv, false));
            bw.write("id,x,y,battery,radio");
            for (int i = 0; i < n; i++) {
                bw.newLine();
                Sensor sensor = new Sensor(100000 + i, (int) (Math.random() * 1000 + 1), (int) (Math.random() * 500 + 1), 100, nCost, nGet, null, (int) (Math.random() * 10 + 50), null);
                bw.write(sensor.toString());
            }
            bw.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
//        List<Unity.Sensor> sensorList = readFromFile("data_node");
//        Unity.Sensor sensor = new Unity.Sensor(100006, Math.random() * 1000, Math.random() * 500, 100, null, null, null, 200, null);
//        sensorList.add(sensor);
//        new Utils.DataUtil().writeToFile(sensorList, "resu_node");
        new DataUtil().writeRandom(100, "data_node_100");
    }
}
