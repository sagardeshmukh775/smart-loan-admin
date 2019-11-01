package com.smartloan.smtrick.smart_loan_admin_new.view.fragements;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.RecyclerListener.RecyclerTouchListener;
import com.smartloan.smtrick.smart_loan_admin_new.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin_new.constants.Constant;
import com.smartloan.smtrick.smart_loan_admin_new.databinding.TcFragmentLeadTabGeneratedleadBinding;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.preferences.AppSharedPreference;
import com.smartloan.smtrick.smart_loan_admin_new.repository.LeedRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.LeedRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.singleton.AppSingleton;
import com.smartloan.smtrick.smart_loan_admin_new.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin_new.view.activites.Sales_Update_Activity;
import com.smartloan.smtrick.smart_loan_admin_new.view.activites.ViewLead_Sales_Activity;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.SalesLeedsAdapter;
import com.smartloan.smtrick.smart_loan_admin_new.view.dialog.ProgressDialogClass;
import com.smartloan.smtrick.smart_loan_admin_new.view.holders.GetterSetterInvoice;

import java.util.ArrayList;

import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.LEED_MODEL;
import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.STATUS_REJECTED;

public class Sales_fragment_lead_tab_rejected extends Fragment {

//    ArrayList<GetterSetterInvoice> searchResults = GetSearchResults();
SalesLeedsAdapter telecallerLeedsAdapter;
    LeedRepository leedRepository;
    AppSingleton appSingleton;
    ProgressDialogClass progressDialogClass;
    AppSharedPreference appSharedPreference;
    TcFragmentLeadTabGeneratedleadBinding tcFragmentLeadTabGeneratedleadBinding;
    int fromYear, fromMonth, fromDay;
    int toYear, toMonth, toDay;
    long fromDate, toDate;
    String name;
    ArrayList<LeedsModel> leedsModelArrayList;
    ArrayList<LeedsModel> leedsModelArrayList1;

    ListView listleads;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (tcFragmentLeadTabGeneratedleadBinding == null) {
            tcFragmentLeadTabGeneratedleadBinding = DataBindingUtil.inflate(inflater, R.layout.tc_fragment_lead_tab_generatedlead, container, false);
            progressDialogClass = new ProgressDialogClass(getActivity());
            appSingleton = AppSingleton.getInstance(getActivity());
            leedRepository = new LeedRepositoryImpl();
            appSharedPreference = new AppSharedPreference(getActivity());
            tcFragmentLeadTabGeneratedleadBinding.recyclerViewLeeds.setHasFixedSize(true);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
            tcFragmentLeadTabGeneratedleadBinding.recyclerViewLeeds.setLayoutManager(layoutManager);
            tcFragmentLeadTabGeneratedleadBinding.recyclerViewLeeds.setItemAnimator(new DefaultItemAnimator());
            tcFragmentLeadTabGeneratedleadBinding.recyclerViewLeeds.addItemDecoration(new DividerItemDecoration(getContext(),
                    DividerItemDecoration.VERTICAL));

            name = appSharedPreference.getUserName();
            getteLeed();
        }
        return tcFragmentLeadTabGeneratedleadBinding.getRoot();
    }


private void getteLeed() {
    progressDialogClass.showDialog(this.getString(R.string.loading), this.getString(R.string.PLEASE_WAIT));
    leedRepository.readLeedsByStatus(STATUS_REJECTED, new CallBack() {
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

    private void serAdapter(ArrayList<LeedsModel> leedsModels) {
        if (leedsModels != null) {
            if (telecallerLeedsAdapter == null) {
                telecallerLeedsAdapter = new SalesLeedsAdapter(getActivity(), leedsModels);
                tcFragmentLeadTabGeneratedleadBinding.recyclerViewLeeds.setAdapter(telecallerLeedsAdapter);
                onClickListner();
            } else {
                ArrayList<LeedsModel> leedsModelArrayList = new ArrayList<>();
                leedsModelArrayList.addAll(leedsModels);
                telecallerLeedsAdapter.reload(leedsModelArrayList);
            }
        }
    }
    private void onClickListner() {
        tcFragmentLeadTabGeneratedleadBinding.recyclerViewLeeds.addOnItemTouchListener(new RecyclerTouchListener(getContext(), tcFragmentLeadTabGeneratedleadBinding.recyclerViewLeeds, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                LeedsModel leedsModel = getModel(position);
//                Intent intent = new Intent(getActivity(), Sales_Update_Activity.class);
//                intent.putExtra(LEED_MODEL, leedsModel);
//                startActivity(intent);

                Bundle bundle = new Bundle();
                bundle.putSerializable(Constant.LEED_MODEL, leedsModel);// Put anything what you want
                View_Rejected_Lead_Details_Fragment fragment2 = new View_Rejected_Lead_Details_Fragment();
                fragment2.setArguments(bundle);
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.detailContainer,  fragment2);
                ft.commit();
            }

            @Override
            public void onLongClick(View view, int position) {
            }

        }));
    }
    private LeedsModel getModel(int position) {
        return leedsModelArrayList.get(leedsModelArrayList.size() - 1 - position);
    }
}
