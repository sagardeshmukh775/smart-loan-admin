package com.smartloan.smtrick.smart_loan_admin.view.fragements;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.smartloan.smtrick.smart_loan_admin.R;
import com.smartloan.smtrick.smart_loan_admin.view.holders.GetterSetterInvoice;

import java.util.ArrayList;

public class Telecaller_fragment_Reports extends Fragment implements AdapterView.OnItemSelectedListener {

    // NOTE: Removed Some unwanted Boiler Plate Codes
    private OnFragmentInteractionListener mListener;
    ArrayList<GetterSetterInvoice> searchResults = GetSearchResults();

    public Telecaller_fragment_Reports() {}
    TextView sort;

   ListView Report;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.telecaller_fragment_reports, container, false);

        // NOTE : We are calling the onFragmentInteraction() declared in the MainActivity
        // ie we are sending "Fragment 1" as title parameter when fragment1 is activated
        if (mListener != null) {
            mListener.onFragmentInteraction("Reports");
        }
        Report = (ListView) view.findViewById(R.id.listreport);
        sort= (TextView) view.findViewById(R.id.Textsort);
        Report.setAdapter(new Tc_fragment_lead_Adapter(getActivity(), searchResults));

        sort.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                final Dialog dialog = new Dialog(getActivity());

                dialog.setContentView(R.layout.custumdialogboxfilter);
                dialog.setTitle("Title...");

                // set the custom dialog components - text, image and button
                //  TextView text = (TextView) dialog.findViewById(R.id.text);
                // text.setText("Android custom dialog example!");


                TextView dialogButton = (TextView) dialog.findViewById(R.id.txtleadid);
                // if button is clicked, close the custom dialog
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                TextView dialogButton2 = (TextView) dialog.findViewById(R.id.txtdate);
                // if button is clicked, close the custom dialog
                dialogButton2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                TextView dialogButton3 = (TextView) dialog.findViewById(R.id.txtbank);
                // if button is clicked, close the custom dialog
                dialogButton3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                TextView dialogButton4 = (TextView) dialog.findViewById(R.id.txtcname);
                // if button is clicked, close the custom dialog
                dialogButton4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();

            }
        });


        return view;
        }



    private ArrayList<GetterSetterInvoice> GetSearchResults(){
        ArrayList<GetterSetterInvoice> results = new ArrayList<GetterSetterInvoice>();

        GetterSetterInvoice sr = new GetterSetterInvoice();
        sr.setName("2345");
        sr.setCityState("Mr Pratik Patel");
        sr.setPhone("India Buls");
        results.add(sr);

        sr = new GetterSetterInvoice();
        sr.setName("2345");
        sr.setCityState("Mr Pratik Patel");
        sr.setPhone("India Buls");
        results.add(sr);


        sr = new GetterSetterInvoice();
        sr.setName("2345");
        sr.setCityState("Mr Pratik Patel");
        sr.setPhone("India Buls");
        results.add(sr);

        sr = new GetterSetterInvoice();
        sr.setName("2345");
        sr.setCityState("Mr Pratik Patel");
        sr.setPhone("India Buls");
        results.add(sr);

        sr = new GetterSetterInvoice();
        sr.setName("2345");
        sr.setCityState("Mr Pratik Patel");
        sr.setPhone("India Buls");
        results.add(sr);

        sr = new GetterSetterInvoice();
        sr.setName("2345");
        sr.setCityState("Mr Pratik Patel");
        sr.setPhone("India Buls");
        results.add(sr);

        sr = new GetterSetterInvoice();
        sr.setName("2345");
        sr.setCityState("Mr Pratik Patel");
        sr.setPhone("India Buls");
        results.add(sr);


        sr = new GetterSetterInvoice();
        sr.setName("2345");
        sr.setCityState("Mr Pratik Patel");
        sr.setPhone("India Buls");
        results.add(sr);

        return results;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            // NOTE: This is the part that usually gives you the error
            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    public interface OnFragmentInteractionListener {
        // NOTE : We changed the Uri to String.
        void onFragmentInteraction(String title);
    }
}
