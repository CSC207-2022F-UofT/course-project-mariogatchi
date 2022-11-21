package mariogatchi;

import java.io.*;
import java.text.*;
import java.time.*;

public class TimeRunner implements Serializable {

    private long time;
    public TimeRunner(){
        this.time = System.currentTimeMillis();
    }
    public long difference(int time){
        long  diff = 0;

        diff = (System.currentTimeMillis() - time)/1000;
        return diff;

    }

    public String displayTime(){

        String time = LocalDateTime.now().toString();
        return time;

    }

}
