package androidawesome.asu.squareface.androidawesomestuff.animation.stuff;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidawesome.asu.squareface.androidawesomestuff.R;

/**
 * Created by asu on 1/20/15.
 * RecyclerView ref:http://www.vogella.com/tutorials/AndroidRecyclerView/article.html.
 *
 * ViewHolder:init or findViewById from displayed itemView.
 */
public class AnimationStuffAdapter extends RecyclerView.Adapter<AnimationStuffAdapter.MyViewHolder> {

    ArrayList<String> mDataSet;

    public interface OnItemClickListener{
        public void onOnItemClicked(View itemView, int position);
    }

    private OnItemClickListener mItemClickListener;

    // Provide a suitable constructor (depends on the kind of dataset)
    public AnimationStuffAdapter(ArrayList<String> dataSet) {
        mDataSet = dataSet;
    }

    /**
     * @param parent   : displayed itemView container
     * @param viewType : viewType you define~ maybe is header or something.
     * @return : by using itemView (init in this function), create a viewHolder.
     */
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.animation_stuff_adapter_cell,
                parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(itemView);
        return myViewHolder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int position) {
        // - get element from your dataSet at this position
        // - replace the contents of the view with that element
        final String description = mDataSet.get(position);
        myViewHolder.tvDescription.setText(description);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataSet == null ? 0 : mDataSet.size();
    }



    public void setOnItemClickListener(final OnItemClickListener mItemClickListener){
        this.mItemClickListener = mItemClickListener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{



        public TextView tvDescription;
        public ImageView imgTopic;

        /**
         * FindViewByID~
         *
         * @param itemView: displayed item.
         */
        public MyViewHolder(View itemView) {
            super(itemView);
            tvDescription = (TextView) itemView.findViewById(R.id.tvDescription);
            imgTopic = (ImageView) itemView.findViewById(R.id.imgTopic);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if(mItemClickListener != null)
                mItemClickListener.onOnItemClicked(v,getPosition());
        }
    }



}
