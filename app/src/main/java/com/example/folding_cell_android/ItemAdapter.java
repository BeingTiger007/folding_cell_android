package com.example.folding_cell_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ramotion.foldingcell.FoldingCell;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter <ItemAdapter.ItemViewHolder> {

    private Context mContext;
    private ArrayList <Item> mListItem ;

    public ItemAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(ArrayList<Item> mList) {
        mListItem = mList ;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.folding_item,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemViewHolder holder, int position) {
        final Item item = mListItem.get(position);
        if (item == null) {
            return;
        }
        holder.titleTextView.setText(item.getTitle());
        holder.contentTextView.setText(item.getContent());
        holder.foldingCell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.foldingCell.toggle(false);
            }
        });
    }

    @Override
    public int getItemCount() {

        if (mListItem == null) {
            return  0 ;
        } else {
            return mListItem.size();
        }
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        private FoldingCell foldingCell ;
        private TextView contentTextView , titleTextView ;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            foldingCell = itemView.findViewById(R.id.folding_cell);
            contentTextView = itemView.findViewById(R.id.cell_content_Textview);
            titleTextView = itemView.findViewById(R.id.cell_title_Textview);

        }
    }
}
