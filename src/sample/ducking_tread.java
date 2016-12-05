package sample;

import javafx.scene.input.KeyCode;

import java.util.HashMap;

/**
 * Created by Timkabo on 16.04.2016.
 */
public class ducking_tread extends Thread implements Runnable{

    Sub_zero p;
    HashMap<KeyCode,Boolean > key;
    public ducking_tread(Sub_zero player1,HashMap<KeyCode,Boolean > k) {
    p=player1;
        key=k;
    }
    public void run()
    {
        try {
            this.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        p.getChildren().clear();
        p.getChildren().add(p.sitting);
        key.clear();
    }
}
