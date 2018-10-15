package com.smartloan.smtrick.smart_loan_admin.view.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smartloan.smtrick.smart_loan_admin.R;
import com.smartloan.smtrick.smart_loan_admin.models.LeedModel;
import com.smartloan.smtrick.smart_loan_admin.view.holders.LeedsViewHolder;

import java.util.ArrayList;

public class AccountantLeedsAdapter extends RecyclerView.Adapter<LeedsViewHolder> {

    private ArrayList<LeedModel> leedModelArrayList;

    public AccountantLeedsAdapter(ArrayList<LeedModel> data) {
        this.leedModelArrayList = data;
    }

    @Override
    public LeedsViewHolder onCreateViewHolder(ViewGroup parent,
                                              int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.accountant_leeds_adapter_layout, parent, false);
        //view.setOnClickListener(MainActivity.myOnClickListener);
        return new LeedsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final LeedsViewHolder holder, final int listPosition) {
        try {
            LeedModel leedModel = leedModelArrayList.get(listPosition);
            holder.txtLeedId.setText(leedModel.getLeedId());
            holder.txtCustomerName.setText(leedModel.getCustomerName());
            holder.txtBank.setText(leedModel.getBankName());
            holder.txtTotalAmount.setText(leedModel.getTotalAmount());
            holder.txtAgentID.setText(leedModel.getAgentId());
            holder.txtLoanType.setText(leedModel.getLoanType());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return leedModelArrayList.size();
    }
}