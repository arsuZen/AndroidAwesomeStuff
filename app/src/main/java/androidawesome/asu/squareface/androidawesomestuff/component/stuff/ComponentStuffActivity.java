package androidawesome.asu.squareface.androidawesomestuff.component.stuff;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import androidawesome.asu.squareface.androidawesomestuff.R;

/**
 * Created by asu on 1/19/15.
 */
public class ComponentStuffActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_component_stuff);
    }

    public void goToPieChartActivity(View view){
        Intent i = new Intent(this, PieChartActivity.class);
        this.startActivity(i);
    }
}
