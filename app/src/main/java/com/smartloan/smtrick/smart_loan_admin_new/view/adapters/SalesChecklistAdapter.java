package com.smartloan.smtrick.smart_loan_admin_new.view.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.models.Item;
import com.smartloan.smtrick.smart_loan_admin_new.models.User;
import com.smartloan.smtrick.smart_loan_admin_new.view.activites.Update_User_Activity;

import java.util.List;

public class SalesChecklistAdapter extends RecyclerView.Adapter<SalesChecklistAdapter.ViewHolder> {

    private static List<String> searchArrayList;
    private Context context;
    private boolean isFromRequest;

    public SalesChecklistAdapter(Context context, List<String> userArrayList) {
        this.context = context;
        this.searchArrayList = userArrayList;

    }

    @Override
    public SalesChecklistAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sales_checklist_adapter_layout, parent, false);
        SalesChecklistAdapter.ViewHolder viewHolder = new ViewHolder(v);
        //  context = parent.getContext();
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(final SalesChecklistAdapter.ViewHolder holder, int position) {
        final String item = searchArrayList.get(position);

        holder.Item.setText(item);

        holder.Item.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    holder.Item.setEnabled(false);
                }else {
                    holder.Item.setEnabled(true);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return searchArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        CardView card_view;
        CheckBox Item;

        public ViewHolder(View itemView) {
            super(itemView);

            Item = (CheckBox) itemView.findViewById(R.id.checklistitem);
            card_view = (CardView) itemView.findViewById(R.id.card_view_checklist);

        }
    }

}