package com.smartloan.smtrick.smart_loan_admin.view.holders;

import android.support.v7.widget.RecyclerView;

import com.smartloan.smtrick.smart_loan_admin.databinding.TelecallerLeedsAdapterLayoutBinding;

public class TelecallerLeedsViewHolder extends RecyclerView.ViewHolder {
    public TelecallerLeedsAdapterLayoutBinding telecallerLeedsAdapterLayoutBinding;

    public TelecallerLeedsViewHolder(TelecallerLeedsAdapterLayoutBinding telecallerLeedsAdapterLayoutBinding) {
        super(telecallerLeedsAdapterLayoutBinding.getRoot());
        this.telecallerLeedsAdapterLayoutBinding = telecallerLeedsAdapterLayoutBinding;
    }
}
