package androidawesome.asu.squareface.androidawesomestuff.pattern.stuff;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import androidawesome.asu.squareface.androidawesomestuff.R;
import androidawesome.asu.squareface.androidawesomestuff.animation.stuff.AnimationStuffAdapter;

/**
 * Created by asu on 3/11/15.
 */
public class PatterStuffAdapter extends BaseAdapter {
    ArrayList<String> listItems;
    Context context;

    public PatterStuffAdapter(Context context, ArrayList<String> listItems){
        this.context = context;
        this.listItems = listItems;
    }

    private class  PatternStuffViewHolder{
        TextView tvPaternStuff;
    }
    @Override
    public int getCount() {
        return listItems != null ?listItems.size():0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater  = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.pattern_stuff_item,parent,false);
            PatternStuffViewHolder mViewHolder = new PatternStuffViewHolder();
            mViewHolder.tvPaternStuff = (TextView) convertView.findViewById(R.id.tv_pattern_stuff_item);
            convertView.setTag(mViewHolder);
        }

        PatternStuffViewHolder mViewHolder = (PatternStuffViewHolder) convertView.getTag();
        mViewHolder.tvPaternStuff.setText(listItems.get(position));
        return convertView;
    }
}
