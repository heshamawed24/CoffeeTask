package com.example.coffeetask.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coffeetask.R;
import com.example.coffeetask.data.models.ProductAdditions;
import com.example.coffeetask.databinding.AdditionItemListBinding;

import java.util.List;

public class AdditionAdapter extends RecyclerView.Adapter<AdditionAdapter.ViewHolder> {

    private List<ProductAdditions> dataModelList;
    private Context context;

    public AdditionAdapter(List<ProductAdditions> dataModelList, Context ctx) {
        this.dataModelList = dataModelList;
        context = ctx;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType) {
        AdditionItemListBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.addition_item_list, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ProductAdditions dataModel = dataModelList.get(position);
        holder.bind(dataModel);
    }


    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public AdditionItemListBinding itemRowBinding;

        public ViewHolder(AdditionItemListBinding itemRowBinding) {
            super(itemRowBinding.getRoot());
            this.itemRowBinding = itemRowBinding;
        }

        public void bind(ProductAdditions obj) {
            itemRowBinding.textView.setText(obj.getTitle());
            itemRowBinding.rvSubaddition.setAdapter(new SubAddtionAdapter(obj.getSubAdd(), context));
            itemRowBinding.executePendingBindings();
        }
    }

}