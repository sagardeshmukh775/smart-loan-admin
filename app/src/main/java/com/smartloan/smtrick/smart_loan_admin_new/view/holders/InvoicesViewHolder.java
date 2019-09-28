package com.smartloan.smtrick.smart_loan_admin_new.view.holders;

import android.support.v7.widget.RecyclerView;

import com.smartloan.smtrick.smart_loan_admin_new.databinding.InvoiceAdapterLayoutBinding;

public class InvoicesViewHolder extends RecyclerView.ViewHolder {
    public InvoiceAdapterLayoutBinding telecallerLeedsAdapterLayoutBinding;

    public InvoicesViewHolder(InvoiceAdapterLayoutBinding telecallerLeedsAdapterLayoutBinding) {
        super(telecallerLeedsAdapterLayoutBinding.getRoot());
        this.telecallerLeedsAdapterLayoutBinding = telecallerLeedsAdapterLayoutBinding;
    }
}
