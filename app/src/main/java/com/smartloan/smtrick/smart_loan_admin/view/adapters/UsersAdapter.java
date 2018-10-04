package com.smartloan.smtrick.smart_loan_admin.view.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.smartloan.smtrick.smart_loan_admin.R;
import com.smartloan.smtrick.smart_loan_admin.models.UserModel;

import java.util.ArrayList;

public class UsersAdapter extends BaseAdapter {
    private static ArrayList<UserModel> searchArrayList;
    private LayoutInflater mInflater;
    private boolean isFromRequest;

    public UsersAdapter(Context context, ArrayList<UserModel> results, boolean isFromRequest) {
        searchArrayList = results;
        this.isFromRequest = isFromRequest;
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
            convertView = mInflater.inflate(R.layout.user_adapter_layout, null);
            holder = new ViewHolder();
            holder.txtName = (TextView) convertView.findViewById(R.id.txtidvalue);
            holder.txtType = (TextView) convertView.findViewById(R.id.txtcnamevalue);
            holder.txtcontact = (TextView) convertView.findViewById(R.id.txtbankvalue);
            holder.txtstatus = (TextView) convertView.findViewById(R.id.textview_user_status);
            holder.card_view = (CardView) convertView.findViewById(R.id.card_view);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.txtName.setText(searchArrayList.get(position).getName());
        holder.txtType.setText(searchArrayList.get(position)
                .getType());
        holder.txtcontact.setText(searchArrayList.get(position).getMobileNumber());
        if (isFromRequest) {
            holder.card_view.setVisibility(View.GONE);
        } else {
            holder.txtstatus.setText(searchArrayList.get(position).getUserStatus());
        }
        return convertView;
    }

    static class ViewHolder {
        TextView txtName;
        TextView txtType;
        TextView txtcontact;
        TextView txtstatus;
        CardView card_view;
    }
}