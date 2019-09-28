package com.smartloan.smtrick.smart_loan_admin_new.view.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.databinding.SalesLeedsAdapterLayoutBinding;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin_new.view.holders.SalesLeedsViewHolder;

import java.util.ArrayList;

import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.GLOBAL_DATE_FORMATE;

public class SalesLeedsAdapter extends RecyclerView.Adapter<SalesLeedsViewHolder> {

    private ArrayList<LeedsModel> leedModelArrayList;
    private Context context;

    public SalesLeedsAdapter(Context context, ArrayList<LeedsModel> data) {
        this.leedModelArrayList = data;
        this.context = context;
    }

    @Override
    public SalesLeedsViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        SalesLeedsAdapterLayoutBinding telecallerLeedsAdapterLayoutBinding;
        telecallerLeedsAdapterLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.sales_leeds_adapter_layout, parent, false);
        return new SalesLeedsViewHolder(telecallerLeedsAdapterLayoutBinding);
    }

    private LeedsModel getModel(int position) {
        return leedModelArrayList.get(getItemCount() - 1 - position);
    }

    @Override
    public void onBindViewHolder(final SalesLeedsViewHolder holder, final int listPosition) {
        try {
            LeedsModel leedModel = getModel(listPosition);
            if (!Utility.isEmptyOrNull(leedModel.getCustomerName()))
                holder.telecallerLeedsAdapterLayoutBinding.txtNameValue.setText(leedModel.getCustomerName());
            else
                holder.telecallerLeedsAdapterLayoutBinding.txtNameValue.setText(getString(R.string.na));
            if (!Utility.isEmptyOrNull(leedModel.getMobileNumber()))
                holder.telecallerLeedsAdapterLayoutBinding.txtccontactvalue.setText(leedModel.getMobileNumber());
            else
                holder.telecallerLeedsAdapterLayoutBinding.txtccontactvalue.setText(getString(R.string.na));
            if (!Utility.isEmptyOrNull(leedModel.getCurrentarea()))
                holder.telecallerLeedsAdapterLayoutBinding.txtAddress.setText(leedModel.getCurrentarea()+"\n"+leedModel.getCurrentlandmark()
                        +"\n"+leedModel.getCurrentstreet());
            else
                holder.telecallerLeedsAdapterLayoutBinding.txtAddress.setText(getString(R.string.na));
            if (!Utility.isEmptyOrNull(leedModel.getBanknName()))
                holder.telecallerLeedsAdapterLayoutBinding.txtBankValue.setText(leedModel.getBanknName());
            else
                holder.telecallerLeedsAdapterLayoutBinding.txtBankValue.setText(getString(R.string.na));
            if (!Utility.isEmptyOrNull(leedModel.getAgentName()))
                holder.telecallerLeedsAdapterLayoutBinding.txtAssignbyValue.setText(leedModel.getAgentName());
            else
                holder.telecallerLeedsAdapterLayoutBinding.txtAssignbyValue.setText(getString(R.string.na));
            if (!Utility.isEmptyOrNull(leedModel.getStatus()))
                holder.telecallerLeedsAdapterLayoutBinding.txtappointmentvalue.setText(leedModel.getAppointment());
            else
                holder.telecallerLeedsAdapterLayoutBinding.txtappointmentvalue.setText(getString(R.string.na));
//            if (!Utility.isEmptyOrNull(leedModel.getLoanType()))
//                holder.telecallerLeedsAdapterLayoutBinding.txtLoanTypeValue.setText(leedModel.getAgentName());
//            else
//                holder.telecallerLeedsAdapterLayoutBinding.txtLoanTypeValue.setText(getString(R.string.na));
            if (leedModel.getCreatedDateTimeLong() > 0)
                holder.telecallerLeedsAdapterLayoutBinding.txtAssignDatetimeValue.setText(Utility.convertMilliSecondsToFormatedDate(leedModel.getCreatedDateTimeLong(), GLOBAL_DATE_FORMATE));
            else
                holder.telecallerLeedsAdapterLayoutBinding.txtAssignDatetimeValue.setText(getString(R.string.na));
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
}