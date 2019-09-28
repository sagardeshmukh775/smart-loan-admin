package com.smartloan.smtrick.smart_loan_admin_new.view.holders;

import android.support.v7.widget.RecyclerView;

import com.smartloan.smtrick.smart_loan_admin_new.databinding.SalespersonAdapterLayoutBinding;

public class SalesPersonViewHolder extends RecyclerView.ViewHolder {
    public SalespersonAdapterLayoutBinding telecallerLeedsAdapterLayoutBinding;

    public SalesPersonViewHolder(SalespersonAdapterLayoutBinding telecallerLeedsAdapterLayoutBinding) {
        super(telecallerLeedsAdapterLayoutBinding.getRoot());
        this.telecallerLeedsAdapterLayoutBinding = telecallerLeedsAdapterLayoutBinding;
    }
}
