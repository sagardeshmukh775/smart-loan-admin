package com.smartloan.smtrick.smart_loan_admin.view.fragements;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.smartloan.smtrick.smart_loan_admin.R;
import com.smartloan.smtrick.smart_loan_admin.RecyclerListener.RecyclerTouchListener;
import com.smartloan.smtrick.smart_loan_admin.RecyclerListener.RecyclerTouchListener.ClickListener;
import com.smartloan.smtrick.smart_loan_admin.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin.constants.Constant;
import com.smartloan.smtrick.smart_loan_admin.databinding.TcFragmentLeadTabGeneratedleadBinding;
import com.smartloan.smtrick.smart_loan_admin.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin.preferences.AppSharedPreference;
import com.smartloan.smtrick.smart_loan_admin.repository.LeedRepository;
import com.smartloan.smtrick.smart_loan_admin.repository.impl.LeedRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin.singleton.AppSingleton;
import com.smartloan.smtrick.smart_loan_admin.view.activites.Updatelead_Activity;
import com.smartloan.smtrick.smart_loan_admin.view.adapters.TelecallerLeedsAdapter;
import com.smartloan.smtrick.smart_loan_admin.view.dialog.ProgressDialogClass;
import java.util.ArrayList;

public class Tc_fragment_lead_tab_generatedlead extends Fragment {
    AppSharedPreference appSharedPreference;
    AppSingleton appSingleton;
    long fromDate;
    int fromDay;
    int fromMonth;
    int fromYear;
    LeedRepository leedRepository;
    ArrayList<LeedsModel> leedsModelArrayList;
    ProgressDialogClass progressDialogClass;
    TcFragmentLeadTabGeneratedleadBinding tcFragmentLeadTabGeneratedleadBinding;
    TelecallerLeedsAdapter telecallerLeedsAdapter;
    long toDate;
    int toDay;
    int toMonth;
    int toYear;

    /* renamed from: com.smartloan.smtrick.smart_loan_admin.view.fragements.Tc_fragment_lead_tab_generatedlead$1 */
    class C09521 implements ClickListener {
        C09521() {
        }

        public void onClick(View view, int position) {
            LeedsModel leedsModel = Tc_fragment_lead_tab_generatedlead.this.getModel(position);
            Intent intent = new Intent(Tc_fragment_lead_tab_generatedlead.this.getActivity(), Updatelead_Activity.class);
            intent.putExtra(Constant.LEED_MODEL, leedsModel);
            Tc_fragment_lead_tab_generatedlead.this.startActivity(intent);
        }

        public void onLongClick(View view, int position) {
        }
    }

    /* renamed from: com.smartloan.smtrick.smart_loan_admin.view.fragements.Tc_fragment_lead_tab_generatedlead$2 */
    class C09532 extends CallBack {
        C09532() {
        }

        public void onSuccess(Object object) {
            if (object != null) {
                Tc_fragment_lead_tab_generatedlead tc_fragment_lead_tab_generatedlead = Tc_fragment_lead_tab_generatedlead.this;
                tc_fragment_lead_tab_generatedlead.leedsModelArrayList = (ArrayList) object;
                tc_fragment_lead_tab_generatedlead.serAdapter(tc_fragment_lead_tab_generatedlead.leedsModelArrayList);
            }
            Tc_fragment_lead_tab_generatedlead.this.progressDialogClass.dismissDialog();
        }

        public void onError(Object object) {
            Tc_fragment_lead_tab_generatedlead.this.progressDialogClass.dismissDialog();
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (this.tcFragmentLeadTabGeneratedleadBinding == null) {
            this.tcFragmentLeadTabGeneratedleadBinding = (TcFragmentLeadTabGeneratedleadBinding) DataBindingUtil.inflate(inflater, R.layout.tc_fragment_lead_tab_generatedlead, container, false);
            this.progressDialogClass = new ProgressDialogClass(getActivity());
            this.appSingleton = AppSingleton.getInstance(getActivity());
            this.leedRepository = new LeedRepositoryImpl();
            this.appSharedPreference = new AppSharedPreference(getActivity());
            this.tcFragmentLeadTabGeneratedleadBinding.recyclerViewLeeds.setHasFixedSize(true);
            this.tcFragmentLeadTabGeneratedleadBinding.recyclerViewLeeds.setLayoutManager(new LinearLayoutManager(getActivity()));
            this.tcFragmentLeadTabGeneratedleadBinding.recyclerViewLeeds.setItemAnimator(new DefaultItemAnimator());
            this.tcFragmentLeadTabGeneratedleadBinding.recyclerViewLeeds.addItemDecoration(new DividerItemDecoration(getContext(), 1));
            getteLeed();
        }
        return this.tcFragmentLeadTabGeneratedleadBinding.getRoot();
    }

    private LeedsModel getModel(int position) {
        ArrayList arrayList = this.leedsModelArrayList;
        return (LeedsModel) arrayList.get((arrayList.size() - 1) - position);
    }

    private void onClickListner() {
        this.tcFragmentLeadTabGeneratedleadBinding.recyclerViewLeeds.addOnItemTouchListener(new RecyclerTouchListener(getActivity().getApplicationContext(), this.tcFragmentLeadTabGeneratedleadBinding.recyclerViewLeeds, new C09521()));
    }

    private void getteLeed() {
        this.progressDialogClass.showDialog(getString(R.string.loading), getString(R.string.PLEASE_WAIT));
        this.leedRepository.readLeedsByStatus(Constant.STATUS_GENERATED, new C09532());
    }

    private void serAdapter(ArrayList<LeedsModel> leedsModels) {
        if (leedsModels == null) {
            return;
        }
        if (this.telecallerLeedsAdapter == null) {
            this.telecallerLeedsAdapter = new TelecallerLeedsAdapter(getActivity(), leedsModels);
            this.tcFragmentLeadTabGeneratedleadBinding.recyclerViewLeeds.setAdapter(this.telecallerLeedsAdapter);
            onClickListner();
            return;
        }
        ArrayList<LeedsModel> leedsModelArrayList = new ArrayList();
        leedsModelArrayList.addAll(leedsModels);
        this.telecallerLeedsAdapter.reload(leedsModelArrayList);
    }
}
