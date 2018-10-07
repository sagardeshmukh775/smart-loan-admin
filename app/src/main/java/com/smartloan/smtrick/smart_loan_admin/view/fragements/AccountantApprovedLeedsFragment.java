package com.smartloan.smtrick.smart_loan_admin.view.fragements;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smartloan.smtrick.smart_loan_admin.R;
import com.smartloan.smtrick.smart_loan_admin.RecyclerListener.RecyclerTouchListener;
import com.smartloan.smtrick.smart_loan_admin.interfaces.OnFragmentInteractionListener;
import com.smartloan.smtrick.smart_loan_admin.models.LeedModel;
import com.smartloan.smtrick.smart_loan_admin.view.activites.AccountantUpdateLeedsActivity;
import com.smartloan.smtrick.smart_loan_admin.view.adapters.AccountantLeedsAdapter;


public class AccountantApprovedLeedsFragment extends Fragment {
    public OnFragmentInteractionListener mListener;
    private RecyclerView recyclerView;
    AccountantLeedsAdapter accountantLeedsAdapter;

    public AccountantApprovedLeedsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (mListener != null) {
            mListener.onFragmentInteraction("Approved Leeds");
        }
        View view = inflater.inflate(R.layout.fragment_accountant_approved, container, false);
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
                startActivity(new Intent(getActivity(), AccountantUpdateLeedsActivity.class));
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
