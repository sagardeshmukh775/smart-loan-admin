package com.smartloan.smtrick.smart_loan_admin_new.view.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.databinding.ChecklistAdapterLayoutBinding;
import com.smartloan.smtrick.smart_loan_admin_new.databinding.SalespersonAdapterLayoutBinding;
import com.smartloan.smtrick.smart_loan_admin_new.models.CheckList;
import com.smartloan.smtrick.smart_loan_admin_new.models.User;
import com.smartloan.smtrick.smart_loan_admin_new.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin_new.view.holders.CheckListViewHolder;
import com.smartloan.smtrick.smart_loan_admin_new.view.holders.SalesPersonViewHolder;

import java.util.ArrayList;

public class CheckListAdapter extends RecyclerView.Adapter<CheckListViewHolder> {

    private ArrayList<CheckList> leedModelArrayList;
    private ArrayList<String> checkedArrayList;
    private Context context;

    public CheckListAdapter(Context context, ArrayList<CheckList> data, ArrayList<String> checked) {
        this.leedModelArrayList = data;
        this.context = context;
        this.checkedArrayList = checked;
    }

    @Override
    public CheckListViewHolder onCreateViewHolder(ViewGroup parent,
                                              int viewType) {
        ChecklistAdapterLayoutBinding telecallerLeedsAdapterLayoutBinding;
        telecallerLeedsAdapterLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.checklist_adapter_layout, parent, false);
        return new CheckListViewHolder(telecallerLeedsAdapterLayoutBinding);
    }



    private CheckList getModel(int position) {
        return leedModelArrayList.get(getItemCount() - 1 - position);
    }

    @Override
    public void onBindViewHolder(final CheckListViewHolder holder, final int listPosition) {
        try {
            final CheckList leedModel = getModel(listPosition);
            if (!Utility.isEmptyOrNull(leedModel.getRule()))
                holder.checklistAdapterLayoutBinding.checklistitem.setText(leedModel.getRule());
            else
                holder.checklistAdapterLayoutBinding.checklistitem.setText(getString(R.string.na));

//            holder.checklistAdapterLayoutBinding.checklistitem.setOnCheckedChangeListener(
//                    new CompoundButton.OnCheckedChangeListener() {
//                        @Override
//                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                            if (isChecked){
//                                checkedArrayList.add(leedModel.getRule());
//                                Toast.makeText(holder.checklistAdapterLayoutBinding.checklistitem.getContext(),
//                                        String.valueOf(checkedArrayList.size()), Toast.LENGTH_SHORT).show();
//                            }else if (!isChecked){
//                                int i = checkedArrayList.indexOf(leedModel.getRule());
//                                checkedArrayList.remove(i);
//                                Toast.makeText(holder.checklistAdapterLayoutBinding.checklistitem.getContext(),
//                                        String.valueOf(checkedArrayList.size()), Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                    }
//            );

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

    public void reload(ArrayList<CheckList> leedsModelArrayList) {
        leedModelArrayList.clear();
        leedModelArrayList.addAll(leedsModelArrayList);
        notifyDataSetChanged();
    }
}