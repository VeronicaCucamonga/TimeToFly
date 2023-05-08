package com.example.shootergame;

import static com.example.shootergame.GameView.screenRatioX;
import static com.example.shootergame.GameView.screenRatioY;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

public class Bird {

    public int speed = 20;
    public boolean wasShot = true;
    int x = 0, y, width, height, birdCounter = 1;
    Bitmap bird1, bird2;

    Bird (Resources res) {

        bird1 = BitmapFactory.decodeResource(res, R.drawable.bird_1);
        bird2 = BitmapFactory.decodeResource(res, R.drawable.bird_2);

        width = bird1.getWidth();
        height = bird1.getHeight();

        width /= 6;
        height /= 6;

        width = (int) (width * screenRatioX);
        height = (int) (height * screenRatioY);

        bird1 = Bitmap.createScaledBitmap(bird1, width, height, false);
        bird2 = Bitmap.createScaledBitmap(bird2, width, height, false);


        y = -height;
    }

    Bitmap getBird () {

        if (birdCounter == 1) {
            birdCounter++;
            return bird1;
        }

        birdCounter = 1;

        return bird2;
    }

    Rect getCollisionShape () {
        return new Rect(x, y, x + width, y + height);
    }

}
