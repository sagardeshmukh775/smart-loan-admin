package com.smartloan.smtrick.smart_loan_admin_new.view.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.databinding.AdminInvoiceAdapterLayoutBinding;
import com.smartloan.smtrick.smart_loan_admin_new.databinding.InvoiceAdapterLayoutBinding;
import com.smartloan.smtrick.smart_loan_admin_new.models.Invoice;
import com.smartloan.smtrick.smart_loan_admin_new.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin_new.view.holders.AdminInvoicesViewHolder;
import com.smartloan.smtrick.smart_loan_admin_new.view.holders.InvoicesViewHolder;

import java.util.ArrayList;

public class AdminInvoiceAdapter extends RecyclerView.Adapter<AdminInvoicesViewHolder> {

    private ArrayList<Invoice> leedModelArrayList;
    private Context context;

    public AdminInvoiceAdapter(){}

    public AdminInvoiceAdapter(Context context, ArrayList<Invoice> data) {
        this.leedModelArrayList = data;
        this.context = context;
    }

    @Override
    public AdminInvoicesViewHolder onCreateViewHolder(ViewGroup parent,
                                                        int viewType) {
        AdminInvoiceAdapterLayoutBinding adminInvoiceAdapterLayoutBinding;
        adminInvoiceAdapterLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.admin_invoice_adapter_layout, parent, false);
        return new AdminInvoicesViewHolder(adminInvoiceAdapterLayoutBinding);
    }

    private Invoice getModel(int position) {
        return leedModelArrayList.get(getItemCount() - 1 - position);
    }

    @Override
    public void onBindViewHolder(final AdminInvoicesViewHolder holder, final int listPosition) {
        try {
            Invoice leedModel = getModel(listPosition);
            if (!Utility.isEmptyOrNull(leedModel.getCustomerName()))
                holder.adminInvoiceAdapterLayoutBinding.txtCustomerValue.setText(leedModel.getCustomerName());
            else
                holder.adminInvoiceAdapterLayoutBinding.txtCustomerValue.setText(getString(R.string.na));
            if (!Utility.isEmptyOrNull(leedModel.getLoanapprovedaamount()))
                holder.adminInvoiceAdapterLayoutBinding.txtapprovedloanvalue.setText(leedModel.getLoanapprovedaamount());
            else
                holder.adminInvoiceAdapterLayoutBinding.txtapprovedloanvalue.setText(getString(R.string.na));
            if (!Utility.isEmptyOrNull(leedModel.getLoandisbussedamount()))
                holder.adminInvoiceAdapterLayoutBinding.txtTxtDisbussloanValue.setText(leedModel.getLoandisbussedamount());
            else
                holder.adminInvoiceAdapterLayoutBinding.txtTxtDisbussloanValue.setText(getString(R.string.na));

            if (!Utility.isEmptyOrNull(leedModel.getCommisionwithtdsAmount()))
                holder.adminInvoiceAdapterLayoutBinding.txtTxtCommissionValue.setText(leedModel.getCommisionwithtdsAmount());
            else
                holder.adminInvoiceAdapterLayoutBinding.txtTxtCommissionValue.setText(getString(R.string.na));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getString(int id) {
        return context.getString(id);
    }

    @Override
    public int getItemCount() {
        return leedModelArrayList.size();
    }

    public void reload(ArrayList<Invoice> leedsModelArrayList) {
        leedModelArrayList.clear();
        leedModelArrayList.addAll(leedsModelArrayList);
        notifyDataSetChanged();
    }
}