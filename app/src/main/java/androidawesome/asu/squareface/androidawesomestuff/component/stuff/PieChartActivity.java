package androidawesome.asu.squareface.androidawesomestuff.component.stuff;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Toast;

import androidawesome.asu.squareface.androidawesomestuff.R;
import androidawesome.asu.squareface.androidawesomestuff.component.stuff.charting.PieChart;

/**
 * Created by asu on 3/5/15.
 */
public class PieChartActivity extends ActionBarActivity {
    PieChart pie ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);
        Resources res = this.getResources();
        pie =  (PieChart) findViewById(R.id.Pie);
        pie.addItem("Agamemnon", 2, res.getColor(R.color.seafoam));
        pie.addItem("Bocephus", 3.5f, res.getColor(R.color.chartreuse));
        pie.addItem("Calliope", 2.5f, res.getColor(R.color.emerald));
        pie.addItem("Daedalus", 3, res.getColor(R.color.bluegrass));
        pie.addItem("Euripides", 1, res.getColor(R.color.turquoise));
        pie.addItem("Ganymede", 3, res.getColor(R.color.slate));

        pie.setOnCurrentItemChangedListener(new PieChart.OnCurrentItemChangedListener() {
            @Override
            public void OnCurrentItemChanged(PieChart source, int currentItem) {
                Toast.makeText(PieChartActivity.this,"Item changed:"+currentItem,Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void resetPieChart(View view){
        pie.setCurrentItem(0);
    }
}
