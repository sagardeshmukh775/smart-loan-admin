package com.smartloan.smtrick.smart_loan_admin_new.view.fragements;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.RecyclerListener.RecyclerTouchListener;
import com.smartloan.smtrick.smart_loan_admin_new.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin_new.constants.Constant;
import com.smartloan.smtrick.smart_loan_admin_new.databinding.SalesFragmentLeadTabReceivedleadBinding;
import com.smartloan.smtrick.smart_loan_admin_new.databinding.TcFragmentLeadTabGeneratedleadBinding;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.preferences.AppSharedPreference;
import com.smartloan.smtrick.smart_loan_admin_new.repository.LeedRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.LeedRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.singleton.AppSingleton;
import com.smartloan.smtrick.smart_loan_admin_new.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin_new.view.activites.Sales_Update_Activity;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.SalesLeedsAdapter;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.SalesLeedsReceivedAdapter;
import com.smartloan.smtrick.smart_loan_admin_new.view.dialog.ProgressDialogClass;

import java.util.ArrayList;

import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.LEED_MODEL;

public class Sales_fragment_lead_tab_recived extends Fragment {

    SalesLeedsReceivedAdapter telecallerLeedsAdapter;
    LeedRepository leedRepository;
    AppSingleton appSingleton;
    ProgressDialogClass progressDialogClass;
    AppSharedPreference appSharedPreference;
    SalesFragmentLeadTabReceivedleadBinding salesFragmentLeadTabGeneratedleadBinding;
    int fromYear, fromMonth, fromDay;
    int toYear, toMonth, toDay;
    long fromDate, toDate;
    String name;
    ArrayList<LeedsModel> leedsModelArrayList;
    ArrayList<LeedsModel> leedsModelArrayList1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (salesFragmentLeadTabGeneratedleadBinding == null) {
            salesFragmentLeadTabGeneratedleadBinding = DataBindingUtil.inflate(inflater, R.layout.sales_fragment_lead_tab_receivedlead, container, false);
            progressDialogClass = new ProgressDialogClass(getActivity());
            appSingleton = AppSingleton.getInstance(getActivity());
            leedRepository = new LeedRepositoryImpl();
            appSharedPreference = new AppSharedPreference(getActivity());
            salesFragmentLeadTabGeneratedleadBinding.recyclerViewLeeds.setHasFixedSize(true);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
            salesFragmentLeadTabGeneratedleadBinding.recyclerViewLeeds.setLayoutManager(layoutManager);
            salesFragmentLeadTabGeneratedleadBinding.recyclerViewLeeds.setItemAnimator(new DefaultItemAnimator());
            salesFragmentLeadTabGeneratedleadBinding.recyclerViewLeeds.addItemDecoration(new DividerItemDecoration(getContext(),
                    DividerItemDecoration.VERTICAL));

             name = appSharedPreference.getUserName();
            getteLeed();
        }
        return salesFragmentLeadTabGeneratedleadBinding.getRoot();
    }

    private LeedsModel getModel(int position) {
        return leedsModelArrayList.get(leedsModelArrayList.size() - 1 - position);
    }

    private void getteLeed() {
        progressDialogClass.showDialog(this.getString(R.string.loading), this.getString(R.string.PLEASE_WAIT));
        leedRepository.readLeedsByName(name, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {

                    leedsModelArrayList = (ArrayList<LeedsModel>) object;
                    serAdapter(leedsModelArrayList);
                }
                progressDialogClass.dismissDialog();
            }

            @Override
            public void onError(Object object) {
                progressDialogClass.dismissDialog();
                Utility.showLongMessage(getActivity(), getString(R.string.server_error));
            }
        });
    }


    private void onClickListner() {
        salesFragmentLeadTabGeneratedleadBinding.recyclerViewLeeds.addOnItemTouchListener(new RecyclerTouchListener(getActivity().getApplicationContext(), salesFragmentLeadTabGeneratedleadBinding.recyclerViewLeeds, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                LeedsModel leedsModel = getModel(position);
//                Intent intent = new Intent(getActivity(), Sales_Update_Activity.class);
//                intent.putExtra(LEED_MODEL, leedsModel);
//                startActivity(intent);
                Bundle bundle = new Bundle();
                bundle.putSerializable(Constant.LEED_MODEL, leedsModel);// Put anything what you want

                View_Sales_Received_Lead_Details_Fragment fragment2 = new View_Sales_Received_Lead_Details_Fragment();
                fragment2.setArguments(bundle);

                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container,  fragment2);
                ft.commit();
            }

            @Override
            public void onLongClick(View view, int position) {
            }

        }));
    }


    private void serAdapter(ArrayList<LeedsModel> leedsModels) {
        if (leedsModels != null) {
            if (telecallerLeedsAdapter == null) {
                telecallerLeedsAdapter = new SalesLeedsReceivedAdapter(getActivity(), leedsModels);
                salesFragmentLeadTabGeneratedleadBinding.recyclerViewLeeds.setAdapter(telecallerLeedsAdapter);
                onClickListner();
            } else {
                ArrayList<LeedsModel> leedsModelArrayList = new ArrayList<>();
                leedsModelArrayList.addAll(leedsModels);
                telecallerLeedsAdapter.reload(leedsModelArrayList);
            }
        }
    }

//    @Override
//    public void onBackPressed(){
//        FragmentManager fm = getFragmentManager();
//        if (fm.getBackStackEntryCount() > 0) {
//            Log.i("MainActivity", "popping backstack");
//            fm.popBackStack();
//        } else {
//            Log.i("MainActivity", "nothing on backstack, calling super");
//            super.onBackPressed();
//        }
//    }



}
