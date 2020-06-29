package Utils;

import Unity.Sensor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * @Description gui
 * @Author Zhang Tianyu
 * @Date 2020/2/08 0018 16:30
 * @Version 1.0
 **/
public class GuiUtil {

    /*面板初始化，控件添加*/
    public static JFrame init(PanelUtil panelUtil) {
        JFrame jFrame = new JFrame();
        jFrame.setTitle("WSN");
        jFrame.setSize(1000, 500);
        panelUtil.setSize(1000, 500);
        Button button = new Button("STOP");
        button.setBounds(900, 10, 100, 50);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (button.getLabel().equals("STOP")) {
                    button.setLabel("START");
                } else {
                    button.setLabel("STOP");
                }
            }
        });
        jFrame.add(panelUtil);
        jFrame.setVisible(true);
        return jFrame;
    }

    /*根据当前节点信息更新显示信息*/
    public void updateUI(java.util.List<Sensor> sensorList, JFrame jFrame, PanelUtil panelUtil, int i) throws InterruptedException {
        panelUtil.setSensorList(sensorList);
        jFrame.setTitle("Time:" + String.valueOf(i) + " Live:" + String.valueOf(CalUtil.calLive(sensorList)));
        jFrame.repaint();
    }

    public static void main(String[] args) throws InterruptedException {
        List<Sensor> sensorList = DataUtil.readFromFile();
        PanelUtil panelUtil = new PanelUtil();
        panelUtil.setSensorList(sensorList);
        JFrame jFrame = init(panelUtil);
        jFrame.setVisible(true);
        for (int i = 0; i < 100; i++) {
            Thread.sleep(500);
            for (Sensor sensor : sensorList) {
                sensor.setnX(sensor.getnX() + i * 10);
                sensor.setBattery(sensor.getBattery() - 10);
            }
            panelUtil.setSensorList(sensorList);
            jFrame.repaint();
        }
    }
}
