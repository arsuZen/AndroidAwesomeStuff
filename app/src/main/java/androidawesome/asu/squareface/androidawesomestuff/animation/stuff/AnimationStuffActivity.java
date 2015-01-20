package androidawesome.asu.squareface.androidawesomestuff.animation.stuff;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

import androidawesome.asu.squareface.androidawesomestuff.R;

/**
 * Created by asu on 1/19/15.
<<<<<<< HEAD
 * Create a ListViewFragment ,GridViewFragment or any kinds of stuff can
 * show different stuff.
=======
 * Use CardView & RecyclerView to display topics.
>>>>>>> asuBranch
 */
public class AnimationStuffActivity extends ActionBarActivity implements AnimationStuffAdapter.OnItemClickListener{

    private static final String TAG = "asaTag";

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    AnimationStuffAdapter mAdapter;


    private String[] topics = {"Topic A", "Topic B", "Topic C", "Topic D", "Topic E"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_stuff);
        mRecyclerView = (RecyclerView) findViewById(R.id.mRecyclerView);

        /**
         *  use this setting to improve performance if you know that changes
         *  in content do not change the layout size of the RecyclerView
         */
        mRecyclerView.setHasFixedSize(true);

        /**
         * LinearLayoutManager shows items in a vertical or horizontal scrolling list.
         * GridLayoutManager shows items in a grid.
         * StaggeredGridLayoutManager shows items in a staggered grid.
         */
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);


        //Set array topic into ArrayList mDataSet
        ArrayList<String> mDataSet = new ArrayList<>();
        Collections.addAll(mDataSet, topics);

        //init mAdapter
        mAdapter = new AnimationStuffAdapter(mDataSet);
        mAdapter.setOnItemClickListener(this);
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public void onOnItemClicked(View itemView, int position) {
        Toast.makeText(this,String.valueOf(position)+" was clicked!",Toast.LENGTH_SHORT).show();
        // startActivity about those topic
        switch(position){
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            //......
        }

    }
}
