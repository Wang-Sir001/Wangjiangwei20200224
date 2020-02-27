package com.bawei.wangjiangwei.model.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.wangjiangwei.R;
import com.bawei.wangjiangwei.model.entity.HomeEntity;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.VH> {


    private List<HomeEntity.ResultBean> result;

    public HomeAdapter(List<HomeEntity.ResultBean> result) {

        this.result = result;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_item_layout, parent, false);

        return new VH(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Log.i("a",result.size()+"");
        Glide.with(holder.img)
                .load(result.get(position).getHeadPic())
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.img);

        holder.name.setText(result.get(position).getNickName());

        Glide.with(holder.imgs)
                .load(result.get(position).getGiftPic())
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.imgs);
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    class VH extends RecyclerView.ViewHolder {
        @BindView(R.id.img)
        ImageView img;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.imgs)
        ImageView imgs;
        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
