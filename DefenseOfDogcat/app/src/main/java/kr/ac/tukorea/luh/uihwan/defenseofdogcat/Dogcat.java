package kr.ac.tukorea.luh.uihwan.defenseofdogcat;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
public class Dogcat {

    int TOTAL_NUMBER_OF_FRAMES = 2;
    Rect[] playerIDLEFrames = new Rect[TOTAL_NUMBER_OF_FRAMES];

    private static final float RADIUS_X = 2.5f;
    private static final float RADIUS_Y = 1.5f;
    private static final float SPEED = 8.0f;
    private RectF dstRect = new RectF();
    private float x, y, angle;
    private float tx, ty, dx, dy;

    private static Bitmap playerSheet;

    public Dogcat() {
        x = 8.0f;
        y = 2.0f;
        dstRect.set(x-RADIUS_X, y, x+RADIUS_X, y+2*RADIUS_Y);
        //dstRect.set(0.0f, 0.0f, 16.0f, 9.0f);

        playerIDLEFrames[0] = new Rect(0, 130, 70, 300);
        playerIDLEFrames[1] = new Rect(200, 400, 400, 600);
    }

    public static void setBitmap(Bitmap bitmap) { // Alt+Insert -> Setter
        Dogcat.playerSheet = bitmap;
    }

    public void update(float elapsedSeconds) {
        x += dx * elapsedSeconds;
        // dx 의 부호를 고려하지 않으면 왔다갔다 덜덜떨린다
        if ((dx < 0 && x < tx) || (dx > 0 && x > tx)) {
            x = tx; dx = 0;
        }
        dstRect.set(x-RADIUS_X, y, x+RADIUS_X, y+2*RADIUS_Y);
    }

    public void draw(Canvas canvas) {
        canvas.save();
        canvas.drawBitmap(playerSheet, playerIDLEFrames[0], dstRect, null);
        canvas.restore();
    }

    public void setTargetPosition(float targetX, float targetY) {
        tx = targetX;
        ty = targetY;
        float dx = tx - this.x;
        float dy = ty - this.y;
        double radian = Math.atan2(dy, dx);
        angle = (float) Math.toDegrees(radian) + 90;
        this.dx = SPEED * (float) Math.cos(radian);
        //this.dy = SPEED * (float) Math.sin(radian);
    }
}
