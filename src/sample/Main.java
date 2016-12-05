package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import sun.invoke.empty.Empty;
import sun.java2d.loops.GraphicsPrimitive;

import java.awt.*;
import java.util.HashMap;

public class Main extends Application {
    Sub_zero player1 = new Sub_zero();
    Sub_zero player2 = new Sub_zero();
    Group root = new Group();
    HashMap<KeyCode,Boolean > keys = new HashMap<>();
    int movingbottom=0,right_hit=0,left_hit=0,right_hit2=0,left_hit2=0,movingbottom2=0;
    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");

        Scene scene = new Scene(root, 1980, 1020);
        primaryStage.setScene(scene);
        Image img = new Image("/background.png");
        ImageView bg = new ImageView(img);
        root.getChildren().add(bg);
        root.getChildren().add(player1);
        root.getChildren().add(player2);
        player1.setLayoutX(300);
        player1.setLayoutY(410);
        player2.setLayoutY(410);
        player2.setLayoutX(600);
        scene.setOnKeyPressed(event ->
        {
            if(event.getCode()==KeyCode.NUMPAD4) {
                right_hit2++;
                keys.put(event.getCode(), true);
            }
            else if(event.getCode()==KeyCode.NUMPAD5) {
                left_hit2++;
                keys.put(event.getCode(), true);
            }
            else if(event.getCode()==KeyCode.DOWN) {
                movingbottom2++;
                keys.put(event.getCode(), true);
            }
            else keys.put(event.getCode(), true);

            if(event.getCode()==KeyCode.K) {
                right_hit++;
                keys.put(event.getCode(), true);
            }
            else if(event.getCode()==KeyCode.L) {
                left_hit++;
                keys.put(event.getCode(), true);
            }
            else if(event.getCode()==KeyCode.S) {
                movingbottom++;
                keys.put(event.getCode(), true);
            }
            else keys.put(event.getCode(), true);
        }
        );
        scene.setOnKeyReleased(event ->
        {
            if(event.getCode()==KeyCode.NUMPAD4) {
                right_hit2=0;
                keys.put(event.getCode(), false);
            }
            else if(event.getCode()==KeyCode.NUMPAD5) {
                left_hit2=0;
                keys.put(event.getCode(), false);
            }
            else if(event.getCode()==KeyCode.DOWN) {
                movingbottom2=0;
                keys.put(event.getCode(), false);
            }
            else keys.put(event.getCode(), false);

            if(event.getCode()==KeyCode.L) {
                left_hit=0;
                keys.put(event.getCode(), false);
            }
            else if(event.getCode()==KeyCode.K) {
                right_hit=0;
                keys.put(event.getCode(), false);
            }
            else
            if(event.getCode()==KeyCode.S) {
                movingbottom=0;
                keys.put(event.getCode(), false);
            }
            else keys.put(event.getCode(), false);
        });
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {

                    update();
            }
        };
        timer.start();
        primaryStage.show();
    }
    public boolean isPressed(KeyCode key) {
        return keys.getOrDefault(key, false);
    }
    public void update()
    {
        if(isPressed(KeyCode.NUMPAD5) && left_hit2==1)
        {
            player2.getChildren().clear();
            //player1.right_hit.setCycleCount(1);
            player2.getChildren().add(player2.lefthit);

            player2.left_hit.play();
        }
        else if(isPressed(KeyCode.NUMPAD4) && right_hit2==1)
        {
            player2.getChildren().clear();
            //player1.right_hit.setCycleCount(1);
            player2.getChildren().add(player2.righthit);

            player2.right_hit.play();
        }
        else if (isPressed(KeyCode.UP)) {

        } else if (isPressed(KeyCode.DOWN) && movingbottom2==1) {
            player2.getChildren().clear();
            player2.getChildren().add(player2.duck);
            player2.ducking.play();
        }
        else if (isPressed(KeyCode.RIGHT)) {
            player2.getChildren().clear();
            player2.getChildren().add(player2.right);
            player2.right_move.play();
            player2.moveX(3);
        } else if (isPressed(KeyCode.LEFT)) {
            player2.getChildren().clear();
            player2.getChildren().add(player2.left);
            player2.left_move.play();
            player2.moveX(-3);
        }
        else{
            if(movingbottom2>0)
            {
                player2.getChildren().clear();
                player2.getChildren().add(player2.sitting);
            }
            else{ player2.getChildren().clear();
                player2.getChildren().add(player2.stand);
                player2.standing.play();}
        }

        if(isPressed(KeyCode.L) && left_hit==1)
        {
            player1.getChildren().clear();
            //player1.right_hit.setCycleCount(1);
            player1.getChildren().add(player1.lefthit);

            player1.left_hit.play();
        }
        else if(isPressed(KeyCode.K) && right_hit==1)
        {
            player1.getChildren().clear();
            //player1.right_hit.setCycleCount(1);
            player1.getChildren().add(player1.righthit);

            player1.right_hit.play();
        }
        else if (isPressed(KeyCode.W)) {

        } else if (isPressed(KeyCode.S) && movingbottom==1) {
            player1.getChildren().clear();
            player1.getChildren().add(player1.duck);
            player1.ducking.play();
        }
        else if (isPressed(KeyCode.D)) {
            player1.getChildren().clear();
            player1.getChildren().add(player1.right);
            player1.right_move.play();
            player1.moveX(3);
        } else if (isPressed(KeyCode.A)) {
            player1.getChildren().clear();
            player1.getChildren().add(player1.left);
            player1.left_move.play();
            player1.moveX(-3);
        }
        else{
            if(movingbottom>0)
            {
                player1.getChildren().clear();
                player1.getChildren().add(player1.sitting);
            }
            else{ player1.getChildren().clear();
                player1.getChildren().add(player1.stand);
                player1.standing.play();}
        }
        ////
        if(isPressed(KeyCode.L) && left_hit==1)
        {
            player1.getChildren().clear();
            //player1.right_hit.setCycleCount(1);
            player1.getChildren().add(player1.lefthit);

            player1.left_hit.play();
        }
        else if(isPressed(KeyCode.K) && right_hit==1)
        {
            player1.getChildren().clear();
            //player1.right_hit.setCycleCount(1);
            player1.getChildren().add(player1.righthit);

            player1.right_hit.play();
        }
         else if (isPressed(KeyCode.W)) {

        } else if (isPressed(KeyCode.S) && movingbottom==1) {
            player1.getChildren().clear();
            player1.getChildren().add(player1.duck);
            player1.ducking.play();
        }
         else if (isPressed(KeyCode.D)) {
            player1.getChildren().clear();
            player1.getChildren().add(player1.right);
            player1.right_move.play();
            player1.moveX(3);
        } else if (isPressed(KeyCode.A)) {
            player1.getChildren().clear();
            player1.getChildren().add(player1.left);
            player1.left_move.play();
            player1.moveX(-3);
        }
        else{
             if(movingbottom>0)
            {
                player1.getChildren().clear();
                player1.getChildren().add(player1.sitting);
            }
               else{ player1.getChildren().clear();
                player1.getChildren().add(player1.stand);
                player1.standing.play();}
        }

        if(isPressed(KeyCode.L) && left_hit==1)
        {
            player1.getChildren().clear();
            //player1.right_hit.setCycleCount(1);
            player1.getChildren().add(player1.lefthit);

            player1.left_hit.play();
        }
        else if(isPressed(KeyCode.K) && right_hit==1)
        {
            player1.getChildren().clear();
            //player1.right_hit.setCycleCount(1);
            player1.getChildren().add(player1.righthit);

            player1.right_hit.play();
        }
        else if (isPressed(KeyCode.W)) {

        } else if (isPressed(KeyCode.S) && movingbottom==1) {
            player1.getChildren().clear();
            player1.getChildren().add(player1.duck);
            player1.ducking.play();
        }
        else if (isPressed(KeyCode.D)) {
            player1.getChildren().clear();
            player1.getChildren().add(player1.right);
            player1.right_move.play();
            player1.moveX(3);
        } else if (isPressed(KeyCode.A)) {
            player1.getChildren().clear();
            player1.getChildren().add(player1.left);
            player1.left_move.play();
            player1.moveX(-3);
        }
        else{
            if(movingbottom>0)
            {
                player1.getChildren().clear();
                player1.getChildren().add(player1.sitting);
            }
            else{ player1.getChildren().clear();
                player1.getChildren().add(player1.stand);
                player1.standing.play();}
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}
