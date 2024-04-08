package kr.ac.tukorea.luh.uihwan.defenseofdogcat;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
public class Dogcat {

    int TOTAL_NUMBER_OF_FRAMES = 2;
    Rect[] playerIDLEFrames = new Rect[TOTAL_NUMBER_OF_FRAMES];

    private float playerPosX;
    private float playerPosY;
    private float playerEndX;
    private float playerEndY;

    private static Bitmap playerSheet;

    public Dogcat() {
        playerPosX = 5.0f;
        playerPosY = 5.0f;
        playerEndX = playerPosX + 5.0f;
        playerEndY = playerPosY + 4.0f;

        playerIDLEFrames[0] = new Rect(0, 0, 600, 600);
        playerIDLEFrames[1] = new Rect(200, 400, 400, 600);
    }

    public static void setBitmap(Bitmap bitmap) { // Alt+Insert -> Setter
        Dogcat.playerSheet = bitmap;
    }

    public void update() {

    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(playerSheet, playerIDLEFrames[0], new RectF(playerPosX, playerPosY, playerEndX, playerEndY), null);
    }
}
