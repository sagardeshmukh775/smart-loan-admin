package com.smartloan.smtrick.smart_loan_admin_new.view.adapters;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.databinding.SalesBanksubmittedLeedsAdapterLayoutBinding;
import com.smartloan.smtrick.smart_loan_admin_new.databinding.SalesReceivedLeedsAdapterLayoutBinding;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin_new.view.holders.SalesBankSubmittedLeedsViewHolder;

import java.util.ArrayList;

import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.GLOBAL_DATE_FORMATE;

public class SalesLeedsBankSubmittedAdapter extends RecyclerView.Adapter<SalesBankSubmittedLeedsViewHolder> {

    private ArrayList<LeedsModel> leedModelArrayList;
    private Context context;
    int index = -1;
    private int selectedPosition = 0;
    static int m = 0;
    private static final int REQUEST_PHONE_CALL = 1;


    public SalesLeedsBankSubmittedAdapter(Context context, ArrayList<LeedsModel> data) {
        this.leedModelArrayList = data;
        this.context = context;
    }

    @Override
    public SalesBankSubmittedLeedsViewHolder onCreateViewHolder(ViewGroup parent,
                                                                int viewType) {
        SalesBanksubmittedLeedsAdapterLayoutBinding telecallerLeedsAdapterLayoutBinding;
        telecallerLeedsAdapterLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.sales_banksubmitted_leeds_adapter_layout, parent, false);
        return new SalesBankSubmittedLeedsViewHolder(telecallerLeedsAdapterLayoutBinding);
    }

    private LeedsModel getModel(int position) {
        return leedModelArrayList.get(getItemCount() - 1 - position);
    }

    @Override
    public void onBindViewHolder(final SalesBankSubmittedLeedsViewHolder holder, final int listPosition) {
        try {

            LeedsModel leedModel2 = getModel(listPosition);

            holder.telecallerLeedsAdapterLayoutBinding.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    index = listPosition;
                    notifyDataSetChanged();
                }
            });

            LeedsModel leedModel = getModel(listPosition);
            if (!Utility.isEmptyOrNull(leedModel.getCustomerName()))
                holder.telecallerLeedsAdapterLayoutBinding.txtNameValue.setText(leedModel.getCustomerName());
            else
                holder.telecallerLeedsAdapterLayoutBinding.txtNameValue.setText(getString(R.string.na));

            if (!Utility.isEmptyOrNull(leedModel.getBanknName()))
                holder.telecallerLeedsAdapterLayoutBinding.txtContact.setText(leedModel.getBanknName());
            else
                holder.telecallerLeedsAdapterLayoutBinding.txtContact.setText(getString(R.string.na));


            holder.telecallerLeedsAdapterLayoutBinding.dots.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            holder.telecallerLeedsAdapterLayoutBinding.pin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });


//            if (leedModel.getUpdatedDateTimeLong() > 0)
//                holder.telecallerLeedsAdapterLayoutBinding.txtAssignDateTimeValue.setText(Utility.convertMilliSecondsToFormatedDate(leedModel.getUpdatedDateTimeLong(), GLOBAL_DATE_FORMATE));
//            else
//                holder.telecallerLeedsAdapterLayoutBinding.txtAssignDateTimeValue.setText(getString(R.string.na));


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

    public void reload(ArrayList<LeedsModel> leedsModelArrayList) {
        leedModelArrayList.clear();
        leedModelArrayList.addAll(leedsModelArrayList);
        notifyDataSetChanged();
    }
//
//    public void removeItem(int position) {
//        leedModelArrayList.remove(position);
//        notifyItemRemoved(position);
//    }

    public void MakeCall(LeedsModel item) {
//        leedModelArrayList.add(position, item);
//        notifyItemInserted(position);
        String number = item.getMobileNumber();
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_PHONE_CALL);
            context.startActivity(intent);
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        } else {
            context.startActivity(intent);
        }
    }

    public void restoreItem(LeedsModel item, int position) {
        leedModelArrayList.add(position, item);
        notifyItemInserted(position);
    }

    public ArrayList<LeedsModel> getData() {
        return leedModelArrayList;
    }
}