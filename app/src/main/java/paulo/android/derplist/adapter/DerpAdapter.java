package paulo.android.derplist.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import paulo.android.derplist.R;
import paulo.android.derplist.model.ListItem;

/**
 * Created by Paulo Vila Nova on 2016-07-31.
 */
public class DerpAdapter extends RecyclerView.Adapter<DerpAdapter.DerpHolder> {


    private List<ListItem> listData;
    private LayoutInflater inflater;

    //Creating an Interface..
    private ItemClickCallBack itemClickCallBack;

    public interface ItemClickCallBack{
        void onItemClick(int p);
        void onSecondaryIconClick(int p);
    }

    public void setItemClickCallBack(ItemClickCallBack itemClickCallBack) {
        this.itemClickCallBack = itemClickCallBack;
    }

    public DerpAdapter(List<ListItem> listData, Context c) {
        this.inflater = LayoutInflater.from(c);
        this.listData = listData;
    }



    @Override
    public DerpHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.list_item, parent, false);


        return new DerpHolder(view);
    }

    @Override
    public void onBindViewHolder(DerpHolder holder, int position) {
        ListItem item = listData.get(position);
        holder.title.setText(item.getTitle());
        holder.subTitle.setText(item.getSubTitle());

        if(item.isFavourite()){
            holder.secundaryIcon.setImageResource(R.drawable.ic_star_black_24dp);
        }else{
            holder.secundaryIcon.setImageResource(R.drawable.ic_star_border_black_24dp);
        }



    }

    @Override
    public int getItemCount() {
        return listData.size();
    }



    class DerpHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView title;
        private TextView subTitle;
        private ImageView thumbnail;
        private ImageView secundaryIcon;
        private View container;

        public DerpHolder(View itemView) {
            super(itemView);

            title = (TextView)itemView.findViewById(R.id.lbl_item_text);
            subTitle = (TextView)itemView.findViewById(R.id.lbl_item_sub_title);
            thumbnail = (ImageView) itemView.findViewById(R.id.im_item_icon);
            secundaryIcon = (ImageView) itemView.findViewById(R.id.im_item_icon_secondary);
            secundaryIcon.setOnClickListener(this);
            container = itemView.findViewById(R.id.cont_item_root); //View don´t need CAST (VIEW)
            container.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {


            if(v.getId() == R.id.cont_item_root){
                itemClickCallBack.onItemClick(getAdapterPosition());

            }else{
                itemClickCallBack.onSecondaryIconClick(getAdapterPosition());
            }


//            switch (v.getId()){
//
//                case R.id.cont_item_root:
//                    Toast.makeText(v.getContext(), "CONTAINER TEST",Toast.LENGTH_SHORT).show();
//                    break;
//
//                case R.id.im_item_icon_secondary:
//                    Toast.makeText(v.getContext(), "Secundary ICON TEST",Toast.LENGTH_SHORT).show();
//                    break;
//            }

        }
    }



}
