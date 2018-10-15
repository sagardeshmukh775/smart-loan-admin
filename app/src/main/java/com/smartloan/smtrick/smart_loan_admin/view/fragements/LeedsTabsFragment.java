package com.smartloan.smtrick.smart_loan_admin.view.fragements;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smartloan.smtrick.smart_loan_admin.R;
import com.smartloan.smtrick.smart_loan_admin.view.adapters.ViewPagerAdapter;

public class LeedsTabsFragment extends Fragment {
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;

    public LeedsTabsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_tabs, container, false);
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        viewPagerAdapter.addFragement(new Add_fragment_lead_tab_generated(), "Generated");
        viewPagerAdapter.addFragement(new Add_fragment_lead_tab_generated(), "Verified");
        viewPagerAdapter.addFragement(new Add_fragment_lead_tab_generated(), "Approved");
        viewPagerAdapter.addFragement(new Add_fragment_lead_tab_generated(), "Rejected");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        tabLayout.setTabMode(0);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }
}

