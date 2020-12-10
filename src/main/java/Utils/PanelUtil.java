package Utils;

import Unity.Sensor;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
* @Description pencil
* @Author Zhang Tianyu
* @Date 2020/2/08 0018 16:31
* @Version 1.0
**/

public class PanelUtil extends JPanel {
    private int x = 0;
    private int y = 0;
    private List<Sensor> sensorList;

    public List<Sensor> getSensorList() {
        return sensorList;
    }

    public void setSensorList(List<Sensor> sensorList) {
        this.sensorList = sensorList;
    }

    @Override
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void repaint() {
        super.repaint();
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D gg = (Graphics2D) g.create();
        for (Sensor sensor : sensorList) {
            if (sensor.getBattery() > 0) {
                gg.setColor(Color.GREEN);
                gg.fillOval((int) sensor.getnX(), (int) sensor.getnY(), 10, 10);
                gg.setColor(Color.BLACK);
                gg.setFont(new Font(null, Font.PLAIN, 10));
                gg.drawString(String.valueOf(sensor.getnId()) + ":" + String.valueOf(sensor.getBattery()), (int) sensor.getnX() + 5, (int) sensor.getnY() + 5);
                gg.setColor(Color.LIGHT_GRAY);
                if (sensor.getWakeFlag()>=0)
                    gg.drawOval((int) (sensor.getnX() - sensor.getnSeradio()), (int) (sensor.getnY() - sensor.getnSeradio()), (int) sensor.getnSeradio() * 2, (int) sensor.getnSeradio() * 2);
            } else {
                gg.setColor(Color.RED);
                gg.fillOval((int) sensor.getnX(), (int) sensor.getnY(), 10, 10);
                gg.setColor(Color.BLACK);
                gg.setFont(new Font(null, Font.PLAIN, 10));
                gg.drawString(String.valueOf(sensor.getnId()) + ":" + String.valueOf(sensor.getBattery()), (int) sensor.getnX() + 5, (int) sensor.getnY() + 5);
            }
        }
    }

    public static void main(String[] args) {
        return;
    }
}
