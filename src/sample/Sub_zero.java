package sample;

import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Material;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * Created by Timkabo on 06.04.2016.
 */
public class Sub_zero extends Group {
    ImageView stand = new ImageView();
    ImageView right = new ImageView();
    ImageView left = new ImageView();
    ImageView duck = new ImageView();
    ImageView sitting = new ImageView();
    ImageView righthit = new ImageView();
    ImageView lefthit = new ImageView();
    int width = 300;
    int height = 555;
    int offsetX = 0;
    int offsetY = 0;

    Rectangle removeRect = null;
    SpriteAnimation standing;
    SpriteAnimation right_move;
    SpriteAnimation left_move;
    SpriteAnimation ducking;
    SpriteAnimation left_hit;
    SpriteAnimation right_hit;
    public Sub_zero()
    {
        Image o1 = new Image("/subzero_right_hit.png");
        ImageView o2 = new ImageView(o1);
        righthit = o2;
        right_hit = new SpriteAnimation(o2,Duration.millis(500),3,3,offsetX,offsetY,500,height);
        Image o3 = new Image("/subzero_left_hit.png");
        ImageView o4 = new ImageView(o3);
        lefthit = o4;
        left_hit = new SpriteAnimation(o4,Duration.millis(500),5,5,offsetX,offsetY,500,height);

        Image standing_image = new Image("/subzero_standing.png");
        ImageView standing_animation = new ImageView(standing_image);
        stand = standing_animation;

        Image left_move1 = new Image("/subzero_left_step.png");
        ImageView move_left = new ImageView(left_move1);
        left = move_left;

        Image right_move1 = new Image("/subzero_left_step.png");
        ImageView move_right = new ImageView(right_move1);
        right = move_right;

        Image duck1 = new Image("/subzero_ducking.png");
        ImageView duck2 = new ImageView(duck1);
        duck = duck2;

        Image sit1 = new Image("/subzero_sitting.png");
        ImageView sit2 = new ImageView(sit1);
        sitting = sit2;

        standing = new SpriteAnimation(stand,Duration.millis(1100),12,12,offsetX,offsetY,width,height);
        right_move = new SpriteAnimation(right,Duration.millis(1100),9,9,offsetX,offsetY,width,height);
        left_move = new SpriteAnimation(left,Duration.millis(1100),9,9,offsetX,offsetY,width,height);
        ducking = new SpriteAnimation(duck,Duration.millis(500),3,3,offsetX,offsetY,width,height);
        stand.setViewport(new Rectangle2D(offsetX,offsetY,width,height));
        getChildren().addAll(stand);
    }
    public void moveX(int x)
    {
        boolean right = x>0?true:false;
        for(int i=0;i< Math.abs(x);i++)
        {
            if(right) this.setTranslateX(this.getTranslateX()+2);
            else this.setTranslateX(this.getTranslateX()-2);
        }
    }
    public void moveY(int y)
    {
        boolean down = y>0?true:false;
        for(int i=0;i< Math.abs(y);i++)
        {
            if(down) this.setTranslateY(this.getTranslateY()+2);
            else this.setTranslateY(this.getTranslateY()-2);
        }
    }
}
