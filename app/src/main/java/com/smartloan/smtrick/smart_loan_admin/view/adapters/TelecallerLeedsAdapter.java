package com.smartloan.smtrick.smart_loan_admin.view.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.smartloan.smtrick.smart_loan_admin.R;
import com.smartloan.smtrick.smart_loan_admin.databinding.TelecallerLeedsAdapterLayoutBinding;
import com.smartloan.smtrick.smart_loan_admin.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin.view.holders.TelecallerLeedsViewHolder;

import java.util.ArrayList;

import static com.smartloan.smtrick.smart_loan_admin.constants.Constant.GLOBAL_DATE_FORMATE;

public class TelecallerLeedsAdapter extends RecyclerView.Adapter<TelecallerLeedsViewHolder> {

    private ArrayList<LeedsModel> leedModelArrayList;
    private Context context;

    public TelecallerLeedsAdapter(Context context, ArrayList<LeedsModel> data) {
        this.leedModelArrayList = data;
        this.context = context;
    }

    @Override
    public TelecallerLeedsViewHolder onCreateViewHolder(ViewGroup parent,
                                                        int viewType) {
        TelecallerLeedsAdapterLayoutBinding telecallerLeedsAdapterLayoutBinding;
        telecallerLeedsAdapterLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.telecaller_leeds_adapter_layout, parent, false);
        return new TelecallerLeedsViewHolder(telecallerLeedsAdapterLayoutBinding);
    }

    private LeedsModel getModel(int position) {
        return leedModelArrayList.get(getItemCount() - 1 - position);
    }

    @Override
    public void onBindViewHolder(final TelecallerLeedsViewHolder holder, final int listPosition) {
        try {
            LeedsModel leedModel = getModel(listPosition);
            if (!Utility.isEmptyOrNull(leedModel.getLeedNumber()))
                holder.telecallerLeedsAdapterLayoutBinding.txtIdValue.setText(leedModel.getLeedNumber());
            else
                holder.telecallerLeedsAdapterLayoutBinding.txtIdValue.setText(getString(R.string.na));
            if (!Utility.isEmptyOrNull(leedModel.getCustomerName()))
                holder.telecallerLeedsAdapterLayoutBinding.txtcnamevalue.setText(leedModel.getCustomerName());
            else
                holder.telecallerLeedsAdapterLayoutBinding.txtcnamevalue.setText(getString(R.string.na));
            if (!Utility.isEmptyOrNull(leedModel.getBankName()))
                holder.telecallerLeedsAdapterLayoutBinding.txtBankValue.setText(leedModel.getBankName());
            else
                holder.telecallerLeedsAdapterLayoutBinding.txtBankValue.setText(getString(R.string.na));
            if (!Utility.isEmptyOrNull(leedModel.getExpectedLoanAmount()))
                holder.telecallerLeedsAdapterLayoutBinding.txtAmountValue.setText(leedModel.getExpectedLoanAmount());
            else
                holder.telecallerLeedsAdapterLayoutBinding.txtAmountValue.setText(getString(R.string.na));
            if (!Utility.isEmptyOrNull(leedModel.getAgentId()))
                holder.telecallerLeedsAdapterLayoutBinding.txtAgentValue.setText(leedModel.getAgentId());
            else
                holder.telecallerLeedsAdapterLayoutBinding.txtAgentValue.setText(getString(R.string.na));
            if (!Utility.isEmptyOrNull(leedModel.getStatus()))
                holder.telecallerLeedsAdapterLayoutBinding.txtStatusValue.setText(leedModel.getStatus());
            else
                holder.telecallerLeedsAdapterLayoutBinding.txtStatusValue.setText(getString(R.string.na));
            if (!Utility.isEmptyOrNull(leedModel.getLoanType()))
                holder.telecallerLeedsAdapterLayoutBinding.txtLoanTypeValue.setText(leedModel.getLoanType());
            else
                holder.telecallerLeedsAdapterLayoutBinding.txtLoanTypeValue.setText(getString(R.string.na));
            if (leedModel.getCreatedDateTimeLong() > 0)
                holder.telecallerLeedsAdapterLayoutBinding.txtDateValue.setText(Utility.convertMilliSecondsToFormatedDate(leedModel.getCreatedDateTimeLong(), GLOBAL_DATE_FORMATE));
            else
                holder.telecallerLeedsAdapterLayoutBinding.txtDateValue.setText(getString(R.string.na));
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