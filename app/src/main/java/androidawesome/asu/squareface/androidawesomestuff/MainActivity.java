package androidawesome.asu.squareface.androidawesomestuff;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import androidawesome.asu.squareface.androidawesomestuff.animation.stuff.AnimationStuffActivity;
import androidawesome.asu.squareface.androidawesomestuff.component.stuff.ComponentStuffActivity;
import androidawesome.asu.squareface.androidawesomestuff.coolstuff.CoolStuffActivity;
import androidawesome.asu.squareface.androidawesomestuff.layout.stuff.LayoutStuffActivity;
import androidawesome.asu.squareface.androidawesomestuff.material.design.MaterialDesignActivity;
import androidawesome.asu.squareface.androidawesomestuff.pattern.stuff.PatterStuffActivity;
import androidawesome.asu.squareface.androidawesomestuff.style.stuff.StyleActivity;


/**
 * This project is aim to help us to understand Material Design, and
 * display it.
 *
 * The category is following Material Design Spec from google.
 *  -http://www.google.com/design/spec/material-design/introduction.html
 *
 *  Interesting lib
 *  -https://github.com/navasmdc/MaterialDesignLibrary
 *  -https://github.com/keithellis/MaterialWidget
 */

public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private static String TAG = "mTag";
    private static String TAG_SF = "squareface";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Set up onClickListeners
         */
        findViewById(R.id.btn_materialDesign).setOnClickListener(this);
        findViewById(R.id.btn_style).setOnClickListener(this);
        findViewById(R.id.btn_layout).setOnClickListener(this);
        findViewById(R.id.btn_components).setOnClickListener(this);
        findViewById(R.id.btn_patterns).setOnClickListener(this);
        findViewById(R.id.btn_animations).setOnClickListener(this);
        findViewById(R.id.btn_coolStuff).setOnClickListener(this);

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

    /**
     * By view's id, start specific activity
     * @param v: Clicked view
     */
    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btn_materialDesign:
                intent = new Intent(this, MaterialDesignActivity.class);
                this.startActivity(intent);
                break;
            case R.id.btn_style:
                intent = new Intent(this, StyleActivity.class);
                this.startActivity(intent);
                break;
            case R.id.btn_layout:
                intent = new Intent(this, LayoutStuffActivity.class);
                this.startActivity(intent);
                break;
            case R.id.btn_components:
                intent = new Intent(this, ComponentStuffActivity.class);
                this.startActivity(intent);
                break;
            case R.id.btn_patterns:
                intent = new Intent(this,PatterStuffActivity.class);
                this.startActivity(intent);
                break;
            case R.id.btn_animations:
                intent = new Intent(this,AnimationStuffActivity.class);
                this.startActivity(intent);
                break;
            case R.id.btn_coolStuff:
                intent = new Intent(this, CoolStuffActivity.class);
                this.startActivity(intent);
                break;
        }

    }
}
