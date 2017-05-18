package ziedkhmiri.customzodiac;

/**
 * Created by zied216 on 18/04/2017.
 */

import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;


class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<img> mimg = new ArrayList<>();
    private OnClickListener listener;
    public int position ;
    Adapter(OnClickListener listener) {
        this.position = position;
        this.listener = listener;
    }
    void addImage(img img) {
        mimg.add(img);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_adapter, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            img app = mimg.get(position);
           holder. imageView.setImageResource(app.getDrawable());
            holder.title.setText(app.getName());
           holder.ratingTextView.setText(String.valueOf(app.getDate()));
            holder.imageView.setTransitionName("transition"+app);
        }


    }



    @Override
    public int getItemCount() {
        return 12;
    }

   public class ViewHolder extends RecyclerView.ViewHolder  {
         ImageView imageView;
         TextView title;
         TextView ratingTextView;


      public   ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            title = (TextView) itemView.findViewById(R.id.title);
            ratingTextView = (TextView) itemView.findViewById(R.id.ratingTextView);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        listener.onItemClick( v, v.getTransitionName(), getAdapterPosition());
                    }
                }
            });
        }
    }

   public interface OnClickListener {
        void onItemClick(View viewById, String transitionName, int adapterPosition);
    }
}
