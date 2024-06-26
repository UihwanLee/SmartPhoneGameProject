package kr.ac.tukorea.luh.uihwan.framework.util;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import androidx.core.content.res.ResourcesCompat;
import kr.ac.tukorea.luh.uihwan.framework.view.GameView;

public class Gauge {
    private final Paint fgPaint = new Paint();
    private final Paint bgPaint = new Paint();
    public Gauge(float width, int fgColorResId, int bgColorResId) {
        bgPaint.setStyle(Paint.Style.STROKE);
        bgPaint.setStrokeWidth(width);
        // Gauge 생성 시점이 GameView.res 가 설정된 이후여야 한다.
        bgPaint.setColor(ResourcesCompat.getColor(GameView.res, bgColorResId, null));
        bgPaint.setStrokeCap(Paint.Cap.ROUND);
        fgPaint.setStyle(Paint.Style.STROKE);
        fgPaint.setStrokeWidth(width / 2);
        fgPaint.setColor(ResourcesCompat.getColor(GameView.res, fgColorResId, null));
        fgPaint.setStrokeCap(Paint.Cap.ROUND);
    }
    public void draw(Canvas canvas, float value) {
        canvas.drawLine(0, 0, 1.0f, 0.0f, bgPaint);
        if (value > 0) {
            canvas.drawLine(0, 0, value, 0.0f, fgPaint);
        }
    }
    public void draw(Canvas canvas, float x, float y, float scale, float value) {
        canvas.save();
        canvas.translate(x, y);
        canvas.scale(scale, scale);
        draw(canvas, value);
        canvas.restore();
    }
}
