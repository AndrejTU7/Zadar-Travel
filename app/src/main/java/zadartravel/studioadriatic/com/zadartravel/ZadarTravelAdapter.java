package zadartravel.studioadriatic.com.zadartravel;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Andrej on 24.1.2016..
 */
public class ZadarTravelAdapter extends RecyclerView.Adapter<ZadarTravelAdapter.Holder> {
    private ArrayList<ZadarModel> items;
    private int itemLayout;
    private Context mContext;
    private OnItemClickListener mListener;

    public ZadarTravelAdapter(Context context, ArrayList<ZadarModel> items, int itemLayout) {
        this.mContext = context;
        this.items = items;
        this.itemLayout = itemLayout;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        return new Holder(v);
    }


    @Override
    public void onBindViewHolder(final ZadarTravelAdapter.Holder holder, final int position) {
        final ZadarModel item = items.get(position);
        holder.zadar_naziv.setText(item.getNaziv());
        holder.zadar_brojlezajeva.setText(String.valueOf(item.getBrojlezajeva()));
        holder.zadar_odmora.setText(String.valueOf(item.getOdmora()));
        Glide.with(mContext).load(item.getImages()).into(holder.mImageView);
        holder.zadar_zvjezdice.setImageResource(R.drawable.star_5);

        holder.root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onItemClick(item);
            }
        });

        int zadar_zvjezdice = 0;
        switch (zadar_zvjezdice){
            case 5:
                item.setZvjezdice(R.drawable.star_5);
                break;
            case 4:
                item.setZvjezdice(R.drawable.star_4);
                break;
            case 3:
                item.setZvjezdice(R.drawable.star_3);
                break;
            case 2:
                item.setZvjezdice(R.drawable.star_2);
                break;
            case 1:
                item.setZvjezdice(R.drawable.star_1);
                break;
            default:
                item.setZvjezdice(R.drawable.star_5);
                break;

        }

    }



    @Override
    public int getItemCount() {
        return items.size();}
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mListener =  onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(ZadarModel model);
    }




    public class Holder extends RecyclerView.ViewHolder {
        @Bind(R.id.zadar_img)
        ImageView mImageView;
        @Bind(R.id.zadar_naziv)
        TextView zadar_naziv;
        @Bind(R.id.zadar_zvjezdice)
        ImageView zadar_zvjezdice;
        @Bind(R.id.zadar_brojlezajeva)
        TextView zadar_brojlezajeva;
        @Bind(R.id.zadar_odmora)
        TextView zadar_odmora;
        @Bind(R.id.zadar)
        RelativeLayout root;


        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}


// aaaaaaaa
