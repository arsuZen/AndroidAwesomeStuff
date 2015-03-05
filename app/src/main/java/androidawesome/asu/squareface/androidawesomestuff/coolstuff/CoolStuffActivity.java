package androidawesome.asu.squareface.androidawesomestuff.coolstuff;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

import androidawesome.asu.squareface.androidawesomestuff.R;

/**
 * Created by asu on 1/22/15.
 */
public class CoolStuffActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cool_stuff);

    }

    public void btnGoToInputGestureClicked(View view){
        Intent i = new Intent(this, InputGestureActivity.class);
        this.startActivity(i);
    }
}
