package com.smartloan.smtrick.smart_loan_admin_new.view.fragements;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.RecyclerListener.RecyclerTouchListener;
import com.smartloan.smtrick.smart_loan_admin_new.RecyclerListener.RecyclerTouchListener.ClickListener;
import com.smartloan.smtrick.smart_loan_admin_new.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin_new.constants.Constant;
import com.smartloan.smtrick.smart_loan_admin_new.databinding.TcFragmentLeadTabGeneratedleadBinding;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.preferences.AppSharedPreference;
import com.smartloan.smtrick.smart_loan_admin_new.repository.LeedRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.LeedRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.singleton.AppSingleton;
import com.smartloan.smtrick.smart_loan_admin_new.view.activites.Updatelead_Activity;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.TelecallerGeneratedLeedsAdapter;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.TelecallerLeedsAdapter;
import com.smartloan.smtrick.smart_loan_admin_new.view.dialog.ProgressDialogClass;
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
    TelecallerGeneratedLeedsAdapter telecallerLeedsAdapter;
    long toDate;
    int toDay;
    int toMonth;
    int toYear;
    EditText Search;

    /* renamed from: com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Tc_fragment_lead_tab_generatedlead$1 */
    class C09521 implements ClickListener {
        C09521() {
        }

        public void onClick(View view, int position) {
            LeedsModel leedsModel = Tc_fragment_lead_tab_generatedlead.this.getModel(position);
//            Intent intent = new Intent(Tc_fragment_lead_tab_generatedlead.this.getActivity(), Updatelead_Activity.class);
//            intent.putExtra(Constant.LEED_MODEL, leedsModel);
//            Tc_fragment_lead_tab_generatedlead.this.startActivity(intent);
            Bundle bundle = new Bundle();
//            bundle.putString("key","abc");
            bundle.putSerializable(Constant.LEED_MODEL, leedsModel);// Put anything what you want

            Updatelead_Fragment fragment2 = new Updatelead_Fragment();
            fragment2.setArguments(bundle);

            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.detailContainer,  fragment2);
            ft.commit();
//            getFragmentManager()
//                    .beginTransaction()
//                    .replace(R.id.detailContainer, fragment2)
//                    .commit();
        }

        public void onLongClick(View view, int position) {
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
            this.tcFragmentLeadTabGeneratedleadBinding.txtsearch1.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    if (!s.toString().isEmpty()) {
                        setAdapter(s.toString());
                    } else {
                        /*
                         * Clear the list when editText is empty
                         * */
                        leedsModelArrayList.clear();
                        tcFragmentLeadTabGeneratedleadBinding.recyclerViewLeeds.removeAllViews();

                    }
                }
            });
            getteLeed();
        }
        return this.tcFragmentLeadTabGeneratedleadBinding.getRoot();
    }

    private void setAdapter(final String toString) {

        FirebaseDatabase.getInstance().getReference("users").orderByChild("role").equalTo("SERVICE PROVIDER").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                leedsModelArrayList.clear();
                tcFragmentLeadTabGeneratedleadBinding.recyclerViewLeeds.removeAllViews();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                    LeedsModel leedsModel = snapshot.getValue(LeedsModel.class);
                    if (leedsModel.getCustomerName() != null) {
                        if (leedsModel.getCustomerName().toLowerCase().contains(toString)) {
                            leedsModelArrayList.add(leedsModel);
                        }
                    }
                }
                serAdapter(leedsModelArrayList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

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
        this.leedRepository.readLeedsByStatus(Constant.STATUS_GENERATED, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {
                    Tc_fragment_lead_tab_generatedlead tc_fragment_lead_tab_generatedlead = Tc_fragment_lead_tab_generatedlead.this;
                    tc_fragment_lead_tab_generatedlead.leedsModelArrayList = (ArrayList) object;
                    tc_fragment_lead_tab_generatedlead.serAdapter(tc_fragment_lead_tab_generatedlead.leedsModelArrayList);
                }
                Tc_fragment_lead_tab_generatedlead.this.progressDialogClass.dismissDialog();
            }

            @Override
            public void onError(Object object) {
                Tc_fragment_lead_tab_generatedlead.this.progressDialogClass.dismissDialog();

            }
        });
    }

    private void serAdapter(ArrayList<LeedsModel> leedsModels) {
        if (leedsModels == null) {
            return;
        }
        if (this.telecallerLeedsAdapter == null) {
            this.telecallerLeedsAdapter = new TelecallerGeneratedLeedsAdapter(getActivity(), leedsModels);
            this.tcFragmentLeadTabGeneratedleadBinding.recyclerViewLeeds.setAdapter(this.telecallerLeedsAdapter);
            onClickListner();
            return;
        }
        ArrayList<LeedsModel> leedsModelArrayList = new ArrayList();
        leedsModelArrayList.addAll(leedsModels);
        this.telecallerLeedsAdapter.reload(leedsModelArrayList);
    }
}
