package com.smartloan.smtrick.smart_loan_admin.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.smartloan.smtrick.smart_loan_admin.R;
import com.smartloan.smtrick.smart_loan_admin.models.Invoice;

import java.util.ArrayList;

public class InvoicesAdapter extends BaseAdapter {
    private static ArrayList<Invoice> searchArrayList;
    private LayoutInflater mInflater;

    public InvoicesAdapter(Context context, ArrayList<Invoice> results) {
        searchArrayList = results;
        mInflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return searchArrayList.size();
    }

    public Object getItem(int position) {
        return searchArrayList.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.sent_invoices_adapter_layout, null);
            holder = new ViewHolder();
            holder.txtName = (TextView) convertView.findViewById(R.id.txtidvalue);
            holder.txtCityState = (TextView) convertView.findViewById(R.id.txtcnamevalue);
            holder.txtPhone = (TextView) convertView.findViewById(R.id.txtbankvalue);
            holder.txtStatus = (TextView) convertView.findViewById(R.id.txt_status_value);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.txtName.setText(searchArrayList.get(position).getInvoiceId());
        holder.txtCityState.setText(searchArrayList.get(position).getCustomerName());
        holder.txtPhone.setText(searchArrayList.get(position).getPhone());
        holder.txtStatus.setText(searchArrayList.get(position).getStatus());
        return convertView;
    }

    static class ViewHolder {
        TextView txtName;
        TextView txtCityState;
        TextView txtPhone;
        TextView txtStatus;
    }
}