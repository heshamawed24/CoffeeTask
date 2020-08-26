package com.example.coffeetask.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coffeetask.R;
import com.example.coffeetask.data.models.ProductAdditionsSubAdd;
import com.example.coffeetask.databinding.SubaddtionItemListBinding;
import com.example.coffeetask.utilites.Urls;
import com.example.coffeetask.utilites.Utilities;

import java.util.List;


public class SubAddtionAdapter extends RecyclerView.Adapter<SubAddtionAdapter.ViewHolder> {

    private List<ProductAdditionsSubAdd> dataModelList;
    private Context context;
    private int lastPosition = 0;

    public SubAddtionAdapter(List<ProductAdditionsSubAdd> dataModelList, Context ctx) {
        this.dataModelList = dataModelList;
        context = ctx;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType) {
        SubaddtionItemListBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.subaddtion_item_list, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ProductAdditionsSubAdd dataModel = dataModelList.get(position);
        holder.bind(dataModel);
        holder.itemRowBinding.card.setOnClickListener(view -> {
            dataModelList.get(lastPosition).setSelected(false);
            dataModelList.get(position).setSelected(true);
            lastPosition = position;
            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public SubaddtionItemListBinding itemRowBinding;

        public ViewHolder(SubaddtionItemListBinding itemRowBinding) {
            super(itemRowBinding.getRoot());
            this.itemRowBinding = itemRowBinding;
        }

        public void bind(ProductAdditionsSubAdd obj) {
            itemRowBinding.tvSubaddition.setText(obj.getTitle());
            String imageUrl = Urls.additionImageUrl + obj.getImg();
            Utilities.loadImage(itemRowBinding.ivAddition, imageUrl);
            if (obj.isSelected()) {
                itemRowBinding.tvSubaddition.setTextColor(Color.BLACK);
                itemRowBinding.tvSubaddition.setTextSize(14);
            } else {
                itemRowBinding.tvSubaddition.setTextColor(Color.GRAY);
                itemRowBinding.tvSubaddition.setTextSize(12);
            }
            itemRowBinding.executePendingBindings();
        }
    }


}