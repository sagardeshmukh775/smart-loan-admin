package com.smartloan.smtrick.smart_loan_admin.view.fragements;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;

import com.smartloan.smtrick.smart_loan_admin.R;
import com.smartloan.smtrick.smart_loan_admin.models.Item;
import com.smartloan.smtrick.smart_loan_admin.view.adapters.FoldingCellListAdapter;

import java.util.ArrayList;

public class LeedsReportFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    private LeedsReportFragment.OnFragmentInteractionListener mListener;
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
        if (mListener != null) {
            mListener.onFragmentInteraction("Report");
        }
        ListView theListView = view.findViewById(R.id.listreport);
        final ArrayList<Item> items = Item.getTestingList();
        items.get(0).setRequestBtnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        final FoldingCellListAdapter adapter = new FoldingCellListAdapter(this.getActivity(), items);
        adapter.setDefaultRequestBtnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        theListView.setAdapter(adapter);
        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                // toggle clicked cell state
               /* ((FoldingCell) view).toggle(false);
                // register in adapter that state for selected cell is toggled
                adapter.registerToggle(pos);*/
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof LeedsReportFragment.OnFragmentInteractionListener) {
            mListener = (LeedsReportFragment.OnFragmentInteractionListener) context;
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
