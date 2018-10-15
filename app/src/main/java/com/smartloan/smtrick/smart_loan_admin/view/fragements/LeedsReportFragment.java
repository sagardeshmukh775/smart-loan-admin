package com.smartloan.smtrick.smart_loan_admin.view.fragements;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import com.smartloan.smtrick.smart_loan_admin.R;
import com.smartloan.smtrick.smart_loan_admin.RecyclerListener.RecyclerTouchListener;
import com.smartloan.smtrick.smart_loan_admin.models.LeedModel;
import com.smartloan.smtrick.smart_loan_admin.view.activites.View_lead_admin_activity;
import com.smartloan.smtrick.smart_loan_admin.view.adapters.AccountantLeedsAdapter;

public class LeedsReportFragment extends Fragment {
    private RecyclerView recyclerView;
    AccountantLeedsAdapter accountantLeedsAdapter;

    public LeedsReportFragment() {
    }

    Spinner spinloantype, spinemptype, spinincome;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_leeds_report, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_leeds);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
       /* recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),
                DividerItemDecoration.VERTICAL));*/
        accountantLeedsAdapter = new AccountantLeedsAdapter(LeedModel.getLeedsModelList());
        recyclerView.setAdapter(accountantLeedsAdapter);
        onClickListner();
        return view;
    }

    private void onClickListner() {
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity().getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                startActivity(new Intent(getActivity(), View_lead_admin_activity.class));
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }
}
