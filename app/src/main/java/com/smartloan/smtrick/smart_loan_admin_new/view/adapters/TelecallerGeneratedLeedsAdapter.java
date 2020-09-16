package com.smartloan.smtrick.smart_loan_admin_new.view.adapters;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin_new.databinding.TelecallerLeedsGeneratedAdapterLayoutBinding;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.models.User;
import com.smartloan.smtrick.smart_loan_admin_new.preferences.AppSharedPreference;
import com.smartloan.smtrick.smart_loan_admin_new.repository.UserRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.UserRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin_new.view.holders.TelecallerGeneratedLeedsViewHolder;

import java.util.ArrayList;

public class TelecallerGeneratedLeedsAdapter extends RecyclerView.Adapter<TelecallerGeneratedLeedsViewHolder> {

    private ArrayList<LeedsModel> leedModelArrayList;
    private Context context;
    AppSharedPreference appSharedPreference;
    UserRepository userRepository;
    User user;
    int index = -1;

    public TelecallerGeneratedLeedsAdapter() {
    }

    public TelecallerGeneratedLeedsAdapter(Context context, ArrayList<LeedsModel> data) {
        this.leedModelArrayList = data;
        this.context = context;
    }

    @Override
    public TelecallerGeneratedLeedsViewHolder onCreateViewHolder(ViewGroup parent,
                                                                 int viewType) {
        TelecallerLeedsGeneratedAdapterLayoutBinding telecallerLeedsAdapterLayoutBinding;
        telecallerLeedsAdapterLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.telecaller_leeds_generated_adapter_layout, parent, false);
        return new TelecallerGeneratedLeedsViewHolder(telecallerLeedsAdapterLayoutBinding);
    }

    private LeedsModel getModel(int position) {
        return leedModelArrayList.get(getItemCount() - 1 - position);
    }

    @Override
    public void onBindViewHolder(final TelecallerGeneratedLeedsViewHolder holder, final int listPosition) {
        try {
            this.appSharedPreference = new AppSharedPreference(holder.telecallerLeedsAdapterLayoutBinding.txtIdValue.getContext());
            this.userRepository = new UserRepositoryImpl();


            holder.telecallerLeedsAdapterLayoutBinding.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    index = listPosition;
                    notifyDataSetChanged();
                }
            });

            if(index==listPosition){
                holder.telecallerLeedsAdapterLayoutBinding.cardView.setBackgroundColor(Color.parseColor("#1E88E5"));
                holder.telecallerLeedsAdapterLayoutBinding.txtIdValue.setTextColor(Color.parseColor("#FFFFFF"));
                holder.telecallerLeedsAdapterLayoutBinding.txtcnamevalue.setTextColor(Color.parseColor("#FFFFFF"));
                holder.telecallerLeedsAdapterLayoutBinding.txtLoanTypeValue.setTextColor(Color.parseColor("#FFFFFF"));
                holder.telecallerLeedsAdapterLayoutBinding.txtLo.setTextColor(Color.parseColor("#FFFFFF"));
            }else{
                holder.telecallerLeedsAdapterLayoutBinding.cardView.setBackgroundColor(Color.parseColor("#FFFFFF"));
                holder.telecallerLeedsAdapterLayoutBinding.txtIdValue.setTextColor(Color.parseColor("#000000"));
                holder.telecallerLeedsAdapterLayoutBinding.txtcnamevalue.setTextColor(Color.parseColor("#000000"));
                holder.telecallerLeedsAdapterLayoutBinding.txtLoanTypeValue.setTextColor(Color.parseColor("#000000"));
                holder.telecallerLeedsAdapterLayoutBinding.txtLo.setTextColor(Color.parseColor("#000000"));
            }



            LeedsModel leedModel = getModel(listPosition);
//            readagent(leedModel.getAgentName());
            userRepository.readUserByName(leedModel.getAgentName(), new CallBack() {
                @Override
                public void onSuccess(Object object) {
                    user = (User) object;

                }

                @Override
                public void onError(Object object) {

                }
            });

            if (!Utility.isEmptyOrNull(leedModel.getCustomerName()))
                holder.telecallerLeedsAdapterLayoutBinding.txtIdValue.setText(leedModel.getCustomerName());
            else
                holder.telecallerLeedsAdapterLayoutBinding.txtIdValue.setText(getString(R.string.na));
            if (!Utility.isEmptyOrNull(leedModel.getLoanType()))
                holder.telecallerLeedsAdapterLayoutBinding.txtcnamevalue.setText(leedModel.getLoanType());
            else
                holder.telecallerLeedsAdapterLayoutBinding.txtcnamevalue.setText(getString(R.string.na));

            if (!Utility.isEmptyOrNull(leedModel.getAgentName()))
                holder.telecallerLeedsAdapterLayoutBinding.txtLoanTypeValue.setText(leedModel.getAgentName());
            else
                holder.telecallerLeedsAdapterLayoutBinding.txtLoanTypeValue.setText(getString(R.string.na));
//            if (leedModel.getCreatedDateTimeLong() > 0)
//                holder.telecallerLeedsAdapterLayoutBinding.txtDateValue.setText(Utility.convertMilliSecondsToFormatedDate(leedModel.getCreatedDateTimeLong(), GLOBAL_DATE_FORMATE));
//            else
//                holder.telecallerLeedsAdapterLayoutBinding.txtDateValue.setText(getString(R.string.na));

        } catch (Exception e) {
            e.printStackTrace();
        }

//        holder.telecallerLeedsAdapterLayoutBinding.agentCall.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                final int REQUEST_PHONE_CALL = 1;
//                Intent my_callIntent = new Intent(Intent.ACTION_CALL);
//                my_callIntent.setData(Uri.parse("tel:" + user.getMobileNumber()));
//                //here the word 'tel' is important for making a call...
//                if (ContextCompat.checkSelfPermission(holder.telecallerLeedsAdapterLayoutBinding.txtIdValue.getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//                    ActivityCompat.requestPermissions((Activity) holder.telecallerLeedsAdapterLayoutBinding.txtIdValue.getContext(), new String[]{Manifest.permission.CALL_PHONE},REQUEST_PHONE_CALL);
//                }
//                else
//                {
//                    holder.telecallerLeedsAdapterLayoutBinding.txtIdValue.getContext().startActivity(my_callIntent);
//                }
//            }
//        });
//        holder.telecallerLeedsAdapterLayoutBinding.clientCall.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                final int REQUEST_PHONE_CALL = 1;
//                LeedsModel leedModel = getModel(listPosition);
//                String mobileNo = "+91" + leedModel.getMobileNumber();
//                String uri = "tel:" + mobileNo.trim();
//                Intent intent = new Intent(Intent.ACTION_CALL);
//                intent.setData(Uri.parse(uri));
//                if (ContextCompat.checkSelfPermission(holder.telecallerLeedsAdapterLayoutBinding.txtIdValue.getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//                    ActivityCompat.requestPermissions((Activity) holder.telecallerLeedsAdapterLayoutBinding.txtIdValue.getContext(), new String[]{Manifest.permission.CALL_PHONE},REQUEST_PHONE_CALL);
//                }
//                else
//                {
//                    holder.telecallerLeedsAdapterLayoutBinding.txtIdValue.getContext().startActivity(intent);
//                }
//
//            }
//        });
    }

    private void readagent(String agentName) {
        userRepository.readUserByName(agentName, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                user = (User) object;
            }

            @Override
            public void onError(Object object) {

            }
        });
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