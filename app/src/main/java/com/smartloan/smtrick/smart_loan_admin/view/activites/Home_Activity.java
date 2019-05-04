package com.smartloan.smtrick.smart_loan_admin.view.activites;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.smartloan.smtrick.smart_loan_admin.callback.CallBack;
import com.google.firebase.auth.FirebaseAuth;
import com.smartloan.smtrick.smart_loan_admin.R;
import com.smartloan.smtrick.smart_loan_admin.exception.ExceptionUtil;
import com.smartloan.smtrick.smart_loan_admin.interfaces.OnFragmentInteractionListener;
import com.smartloan.smtrick.smart_loan_admin.preferences.AppSharedPreference;
import com.smartloan.smtrick.smart_loan_admin.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin.view.fragements.InvoicesTabFragement;
import com.smartloan.smtrick.smart_loan_admin.view.fragements.LeedsTabsFragment;
import com.smartloan.smtrick.smart_loan_admin.view.fragements.LoanCalculatorFragement;
import com.smartloan.smtrick.smart_loan_admin.view.fragements.ReportsTabFragment;
import com.smartloan.smtrick.smart_loan_admin.view.fragements.UnderConstrationFragement;
import com.smartloan.smtrick.smart_loan_admin.view.fragements.UserTabsFragment;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import static com.smartloan.smtrick.smart_loan_admin.constants.Constant.REQUEST_CODE;

public class Home_Activity extends AppCompatActivity
        implements
        OnFragmentInteractionListener,
        NavigationView.OnNavigationItemSelectedListener {

    TextView user_name,user_contact,user_email;
    private AppSharedPreference appSharedPreference;
    private NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //NOTE:  Checks first item in the navigation drawer initially
        navigationView.setCheckedItem(R.id.Leads);
        updateNavigationHeader();

        appSharedPreference = new AppSharedPreference(getApplicationContext());
        // get our list view
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.mainFrame, new LeedsTabsFragment());
        ft.commit();
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment = null;
        switch (id) {
            case R.id.Users:
                fragment = new UserTabsFragment();
                break;
            case R.id.Leads:
                fragment = new LeedsTabsFragment();
                break;
            case R.id.Reports:
                fragment = new ReportsTabFragment();
                break;
            case R.id.Settings:
                fragment = new UnderConstrationFragement();
                break;
            case R.id.Invices:
                fragment = new InvoicesTabFragement();
                break;
            case R.id.Calulator:
                fragment = new LoanCalculatorFragement();
                break;
            case R.id.Logout:
                clearDataWithSignOut();
                break;
        }
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.mainFrame, fragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void clearDataWithSignOut()
    {
        FirebaseAuth.getInstance().signOut();
        appSharedPreference.clear();
        logOut();
    }

    private void logOut()
    {
        Intent intent = new Intent(this, LoginScreen.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

    @Override
    public void onFragmentInteraction(String title) {
        // NOTE:  Code to replace the toolbar title based current visible fragment
        getSupportActionBar().setTitle(title);
    }


    public void updateNavigationHeader() {
        try {
            View header = navigationView.getHeaderView(0);
            TextView textViewAgentId = header.findViewById(R.id.textView_agent_id);
            TextView textViewUserName = header.findViewById(R.id.textView_user_name);
            TextView textViewEmailId = header.findViewById(R.id.text_view_email);
            TextView textViewMobileNumber = header.findViewById(R.id.textView_contact);
            final ImageView imageViewProfile = header.findViewById(R.id.image_view_profile1);
            final ImageView ivProfileLayout = header.findViewById(R.id.ivProfileLayout);
//            textViewUserName.setText(appSharedPreference.getUserName());
//            textViewEmailId.setText(appSharedPreference.getEmaiId());
//            textViewAgentId.setText(appSharedPreference.getAgeniId());
//            textViewMobileNumber.setText(appSharedPreference.getMobileNo());
//            if (!Utility.isEmptyOrNull(appSharedPreference.getProfileLargeImage())) {
//                Picasso.with(this).load(appSharedPreference.getProfileLargeImage()).resize(200, 200).centerCrop().placeholder(R.drawable.imagelogo).into(imageViewProfile);
//                Picasso.with(this)
//                        .load(appSharedPreference.getProfileLargeImage())
//                        .into(imageViewProfile, new Callback() {
//                            @Override
//                            public void onSuccess() {
//                                new Handler().postDelayed(new Runnable() {
//                                    @Override
//                                    public void run() {
//                                        Bitmap innerBitmap = ((BitmapDrawable) imageViewProfile.getDrawable()).getBitmap();
//                                        ivProfileLayout.setImageBitmap(Utility.blur(Home_Activity.this, innerBitmap));
//                                    }
//                                }, 100);
//                            }
//
//                            @Override
//                            public void onError() {
//                            }
//                        });
//            } else {
//                imageViewProfile.setImageResource(R.drawable.imagelogo);
//                ivProfileLayout.setImageResource(0);
//            }
            imageViewProfile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Home_Activity.this, UpdateProfileActivity.class);
                    startActivityForResult(intent, REQUEST_CODE);
                }
            });
        } catch (Exception ex) {
            ExceptionUtil.logException(ex);
        }
    }


    public class ImageUploadReceiver extends BroadcastReceiver {
        public static final String PROCESS_RESPONSE = "com.smartloan.smtrick.smart_loan.intent.action.UPDATE_USER_DATA";

        @Override
        public void onReceive(Context context, Intent intent) {
            updateNavigationHeader();
        }
    }
}
