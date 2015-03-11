package androidawesome.asu.squareface.androidawesomestuff.pattern.stuff;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.HeaderViewListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

import androidawesome.asu.squareface.androidawesomestuff.R;

/**
 * Created by asu on 1/19/15.
 * The listView in PatternStuffActivity use dynamic loading with footerView.
 * in onCreate we need set LisView.addFooterView "before" ListView.getAdapter, then
 * we got a listView with footer.
 * <p/>
 * And we set ListView.setOnScrollerListener to monitor scrolling information,
 * if( firstVisibleItem + visibleItemCount == totalItemCount) => we execute LoadMoreTask.
 * <p/>
 * When LoadMoreTask finished, we update our list.
 * +==Hint==+
 * After we set ListView.setFooterView / ListView.setHeaderView, we need use
 * (HeaderViewListAdapter)ListView.getAdapter).getWrappedAdapter () to get our custom adapter( extend BaseAdapter)
 */
public class PatterStuffActivity extends ActionBarActivity implements AbsListView.OnScrollListener {

    String[] items = {
            "1", "2", "3", "4", "5",
            "a", "b", "c", "d", "e",
            "6", "7", "8", "9", "1",
            "f", "g", "h", "i", "j"};
    ListView mListView;
    ArrayList<String> mItems;

    View footerView;
    // A flag for LoadMoreTask is running or not.
    boolean loadingMoreTask = false;
    int loadingCount = 0;
    // In this demo we loading more three times, and then we remove the footerView and never load
    // more.
    private static final int TOTAL_LOADING_COUNT = 3;
    PatterStuffAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patter_stuff);
        footerView = ((LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE)).inflate(R.layout.lv_loading_footer, null, false);
        mItems = new ArrayList<>();
        Collections.addAll(mItems, items);
        mAdapter = new PatterStuffAdapter(this, mItems);
        mListView = (ListView) findViewById(R.id.lvPatternStuff);
        mListView.addFooterView(footerView);
        mListView.setAdapter(mAdapter);
        mListView.setOnScrollListener(this);

    }


    //====================== onScrollListener==============================//
    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if (firstVisibleItem + visibleItemCount >= totalItemCount) {
            loadMoreData();
        }

    }
    //====================== onScrollListener==============================//

    /**
     * If our ListView display the last item, we execute LoadMoreTask AsyncTask.
     */
    private void loadMoreData() {
        if (!loadingMoreTask && loadingCount < TOTAL_LOADING_COUNT) {
            loadingMoreTask = true;
            loadingCount++;
            new LoadMoreTask(new LoadMoreTask.LoadMoreTaskListener() {
                /**
                 * Get called when LoadMoreTask is finished.
                 */
                @Override
                public void loadMoreTaskFinished() {
                    updateListView();
                }
            }).execute();
        } else if (loadingCount == TOTAL_LOADING_COUNT && !loadingMoreTask) {
            Toast.makeText(this, "All data has been downloaded", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Update ListView
     */
    private void updateListView() {
        for (String item : items) {
            mItems.add(loadingCount + " " + item);
        }
        if (loadingCount == TOTAL_LOADING_COUNT)
            mListView.removeFooterView(footerView);
        ((PatterStuffAdapter) ((HeaderViewListAdapter) mListView.getAdapter()).getWrappedAdapter()).notifyDataSetChanged();
        loadingMoreTask = false;
    }


}

class LoadMoreTask extends AsyncTask<Void, Void, Void> {
    interface LoadMoreTaskListener {
        public void loadMoreTaskFinished();
    }

    LoadMoreTaskListener mListener;

    public LoadMoreTask(LoadMoreTaskListener listener) {
        mListener = listener;
    }

    @Override
    protected Void doInBackground(Void... params) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        mListener.loadMoreTaskFinished();
    }
}
