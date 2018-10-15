package com.smartloan.smtrick.smart_loan_admin.view.fragements;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.smartloan.smtrick.smart_loan_admin.R;
import com.smartloan.smtrick.smart_loan_admin.view.activites.Updatelead_Activity_Coordinator;
import com.smartloan.smtrick.smart_loan_admin.view.adapters.Co_CustumadapterLead;
import com.smartloan.smtrick.smart_loan_admin.view.holders.GetterSetterInvoice;

import java.util.ArrayList;

public class Co_fragment_lead_tab_verified extends Fragment {

    ArrayList<GetterSetterInvoice> searchResults = GetSearchResults();

    ListView listleads;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.tc_fragment_lead_tab_generatedlead, container, false);

        listleads = (ListView) view.findViewById(R.id.listleads);
        listleads.setAdapter(new Co_CustumadapterLead(getActivity(), searchResults));
        listleads.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {

                Object o = listleads.getItemAtPosition(position);


                listleads.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                        Intent i = new Intent(getActivity(), Updatelead_Activity_Coordinator.class);
                        startActivity(i);


                    }
                });

            }
        });


        return view;
    }

    private ArrayList<GetterSetterInvoice> GetSearchResults(){
        ArrayList<GetterSetterInvoice> results = new ArrayList<GetterSetterInvoice>();

        GetterSetterInvoice sr = new GetterSetterInvoice();
        sr.setName("2345");
        sr.setCityState("Mr Pratik Patel");
        sr.setPhone("AG 37383");
        results.add(sr);

        sr = new GetterSetterInvoice();
        sr.setName("2345");
        sr.setCityState("Mr Pratik Patel");
        sr.setPhone("AG 37383");
        results.add(sr);

        sr = new GetterSetterInvoice();
        sr.setName("2345");
        sr.setCityState("Mr Pratik Patel");
        sr.setPhone("AG 37383");
        results.add(sr);

        sr = new GetterSetterInvoice();
        sr.setName("2345");
        sr.setCityState("Mr Pratik Patel");
        sr.setPhone("AG 37383");
        results.add(sr);;

        sr = new GetterSetterInvoice();
        sr.setName("2345");
        sr.setCityState("Mr Pratik Patel");
        sr.setPhone("AG 37383");
        results.add(sr);

        sr = new GetterSetterInvoice();
        sr.setName("2345");
        sr.setCityState("Mr Pratik Patel");
        sr.setPhone("AG 37383");
        results.add(sr);
        return results;
    }
}
