package androidawesome.asu.squareface.androidawesomestuff;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private static String TAG = "mTag";
    private static String TAG_SF = "squareface";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_materialDesign).setOnClickListener(this);
        findViewById(R.id.btn_style).setOnClickListener(this);
        findViewById(R.id.btn_layout).setOnClickListener(this);
        findViewById(R.id.btn_components).setOnClickListener(this);
        findViewById(R.id.btn_patterns).setOnClickListener(this);
        findViewById(R.id.btn_animations).setOnClickListener(this);

    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_materialDesign:
                Log.d(TAG, "material");
                break;
            case R.id.btn_style:
                Log.d(TAG, "style");
                break;
            case R.id.btn_layout:
                Log.d(TAG, "layout");
                break;
            case R.id.btn_components:
                Log.d(TAG, "components");
                break;
            case R.id.btn_patterns:
                Log.d(TAG, "patterns");
                break;
            case R.id.btn_animations:
                Log.d(TAG, "animations");
                break;
        }

    }
}
