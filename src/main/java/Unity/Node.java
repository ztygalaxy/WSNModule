package Unity;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 节点详细信息
 * @Author Zhang Tianyu
 * @Date 2020/2/08 0018 16:30
 * @Version 1.0
 **/
public class Node {
    private int nId = 1000001;      //ID
    private double nX = 1;          //X
    private double nY = 1;          //Y
    private double battery = 100;   //battery
    private List<Integer> nCost;    //cost radio, different in every slot
    private List<Integer> nGet;     //get radio
    private List<Message> nMess;          //message
    private double nSeradio = 10;   //radio
    private List<Sensor> sNeigh;    //neighborhood
    private int startTime = 0;      //start time
    private double sX = -1;         //start place x
    private double sY = -1;         //y
    private double eX = -1;         //end place x
    private double eY = -1;         //end place y

    private int wakeSlot=10000;     //wake slot
    private int wakeFlag=0;         //wake flag
    private int usedSlot=0;         //used in a slot

    public int getUsedSlot() {
        return usedSlot;
    }

    public void setUsedSlot(int usedSlot) {
        this.usedSlot = usedSlot;
    }

    public int getWakeFlag() {
        return wakeFlag;
    }

    public void setWakeFlag(int wakeFlag) {
        this.wakeFlag = wakeFlag;
    }

    public int getWakeSlot() {
        return wakeSlot;
    }

    public void setWakeSlot(int wakeSlot) {
        this.wakeSlot = wakeSlot;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public double getsX() {
        return sX;
    }

    public void setsX(double sX) {
        this.sX = sX;
    }

    public double getsY() {
        return sY;
    }

    public void setsY(double sY) {
        this.sY = sY;
    }

    public double geteX() {
        return eX;
    }

    public void seteX(double eX) {
        this.eX = eX;
    }

    public double geteY() {
        return eY;
    }

    public void seteY(double eY) {
        this.eY = eY;
    }

    public List<Sensor> getsNeigh() {
        return sNeigh;
    }

    public void setsNeigh(List<Sensor> sNeigh) {
        this.sNeigh = sNeigh;
    }

    public Node(int nId, double nX, double nY, double battery, List<Integer> nCost, List<Integer> nGet, List<Message> nMess, double nSeradio, List<Sensor> sNeigh) {
        this.nId = nId;
        this.nX = nX;
        this.nY = nY;
        this.battery = battery;
        this.nCost = nCost;
        this.nGet = nGet;
        this.nMess = nMess;
        this.nSeradio = nSeradio;
        this.sNeigh = sNeigh;
        this.sX = -1;
        this.sY = -1;
        this.eX = -1;
        this.eY = -1;
        this.startTime = -1;
        this.wakeSlot=1000;
        this.wakeFlag=0;
        this.usedSlot=0;
    }

    public int getnId() {
        return nId;
    }

    public void setnId(int nId) {
        this.nId = nId;
    }

    public double getnX() {
        return nX;
    }

    public void setnX(double nX) {
        this.nX = nX;
    }

    public double getnY() {
        return nY;
    }

    public void setnY(double nY) {
        this.nY = nY;
    }

    public double getBattery() {
        return battery;
    }

    public void setBattery(double battery) {
        this.battery = battery;
    }

    public List<Integer> getnCost() {
        return nCost;
    }

    public void setnCost(List<Integer> nCost) {
        this.nCost = nCost;
    }

    public List<Integer> getnGet() {
        return nGet;
    }

    public void setnGet(List<Integer> nGet) {
        this.nGet = nGet;
    }

    public List<Message> getnMess() {
        return nMess;
    }

    public void setnMess(List<Message> nMess) {
        this.nMess = nMess;
    }

    public double getnSeradio() {
        return nSeradio;
    }

    public void setnSeradio(double nSeradio) {
        this.nSeradio = nSeradio;
    }
}
