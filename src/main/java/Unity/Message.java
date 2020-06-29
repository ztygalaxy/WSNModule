package Unity;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description Message
 * @Author Zhang Tianyu
 * @Date 2020/2/08 0018 16:30
 * @Version 1.0
 **/

public class Message {
    private int messId;     //message ID
    private int senderId;   //sender ID
    private int receId;     //receiver ID
    private String mCont;   //content
    private int finFlag;    //flag
    private int time=0;     //start time
    private List<Integer> sensorid;

    public List<Integer> getSensorid() {
        return sensorid;
    }

    public void setSensorid(List<Integer> sensorid) {
        this.sensorid = sensorid;
    }

    public Message(int messId, int senderId, int receId, String mCont, int finFlag, int time) {
        this.messId = messId;
        this.senderId = senderId;
        this.receId = receId;
        this.mCont = mCont;
        this.finFlag = finFlag;
        this.time = time;
        this.sensorid=new ArrayList<>();
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getFinFlag() {
        return finFlag;
    }

    public void setFinFlag(int finFlag) {
        this.finFlag = finFlag;
    }

    public int getMessId() {
        return messId;
    }
    public void setMessId(int messId) {
        this.messId = messId;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getReceId() {
        return receId;
    }

    public void setReceId(int receId) {
        this.receId = receId;
    }

    public String getmCont() {
        return mCont;
    }

    public void setmCont(String mCont) {
        this.mCont = mCont;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messId=" + messId +
                ", senderId=" + senderId +
                ", receId=" + receId +
                ", mCont='" + mCont + '\'' +
                ", finFlag=" + finFlag +
                ", time=" + time +
                ", sensorid=" + sensorid +
                '}';
    }
}
