import Unity.Message;
import Unity.Sensor;
import Utils.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description 主类
 * @Author Zhang Tianyu
 * @Date 2020/2/08 0018 16:26
 * @Version 1.0
 **/
public class Main {
    public static void go() throws InterruptedException {
        List<Sensor> sensorList = DataUtil.readFromFile();
        sensorList.get(2).setStartTime(10);
        sensorList.get(2).seteX(10);
        sensorList.get(2).seteY(10);
        sensorList.get(3).setStartTime(10);
        sensorList.get(3).seteX(10);
        sensorList.get(3).seteY(40);
        GuiUtil guiUtil = new GuiUtil();
        PanelUtil panelUtil = new PanelUtil();
        panelUtil.setSensorList(sensorList);
        JFrame jFrame = GuiUtil.init(panelUtil);
        for (int i = 0; i < 100; i++) {
            Thread.sleep(500);
            AlgoUtil.deal(sensorList, i, null);
            guiUtil.updateUI(sensorList, jFrame, panelUtil, i);
        }
    }

    public static void main(String[] args) {
        try {
            go();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
