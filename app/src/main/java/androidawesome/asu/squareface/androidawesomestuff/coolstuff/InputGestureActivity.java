package androidawesome.asu.squareface.androidawesomestuff.coolstuff;

import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.widget.TextView;

import androidawesome.asu.squareface.androidawesomestuff.R;

/**
 * Created by asu on 2/2/15.
 */
public class InputGestureActivity extends ActionBarActivity
{

    private static final String TAG = "inputGestureTag";
    private GestureDetectorCompat mDetector;

    private TextView tvTouch;

    private VelocityTracker mVelocityTracker = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_gesture);
  /*      tvTouch = (TextView) findViewById(R.id.tvTouchTest);

        tvTouch.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = MotionEventCompat.getActionMasked(event);
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        Log.d(TAG, "tvTouch Action_Down");
                        return true;
                    case MotionEvent.ACTION_MOVE:
                        Log.d(TAG, "tvTouch Action_Move");
                        return true;
                    case MotionEvent.ACTION_UP:
                        Log.d(TAG, "tvTouch Action_Up");
                        return true;
                    case MotionEvent.ACTION_CANCEL:
                        Log.d(TAG, "tvTouch Action_Cancel");
                        return true;
                    case MotionEvent.ACTION_OUTSIDE:
                        Log.d(TAG, "tvTouch Action_OutSide");
                        return true;
                    default:
                        return false;
                }

            }
        });
*/
        //mDetector = new GestureDetectorCompat(this,new MyGestureListener());

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int index = event.getActionIndex();
        int action = event.getActionMasked();
        int pointerId = event.getPointerId(index);
        switch (action){
            case MotionEvent.ACTION_DOWN:
                if(mVelocityTracker == null){
                    mVelocityTracker = VelocityTracker.obtain();
                }else{
                    mVelocityTracker.clear();
                }
                mVelocityTracker.addMovement(event);
                break;
            case MotionEvent.ACTION_MOVE:
                mVelocityTracker.addMovement(event);
                mVelocityTracker.computeCurrentVelocity(1000);
                Log.d(TAG,"velocityX:"+ VelocityTrackerCompat.getXVelocity(mVelocityTracker,pointerId)+
                        "velocityY:"+VelocityTrackerCompat.getYVelocity(mVelocityTracker,pointerId));
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                mVelocityTracker.recycle();
                mVelocityTracker = null;
                break;
        }
        //mDetector.onTouchEvent(event);
      //  return super.onTouchEvent(event);
        return true;
    }
/*
    private class MyGestureListener extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            Log.d(TAG,"onScroll ");
            return true;
        }
    }*/
}
