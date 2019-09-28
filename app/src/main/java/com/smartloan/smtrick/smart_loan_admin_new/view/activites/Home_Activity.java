package com.smartloan.smtrick.smart_loan_admin_new.view.activites;

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
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin_new.exception.ExceptionUtil;
import com.smartloan.smtrick.smart_loan_admin_new.interfaces.OnFragmentInteractionListener;
import com.smartloan.smtrick.smart_loan_admin_new.models.Bank;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.models.User;
import com.smartloan.smtrick.smart_loan_admin_new.preferences.AppSharedPreference;
import com.smartloan.smtrick.smart_loan_admin_new.repository.LeedRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.UserRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.LeedRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.UserRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.InvoicesTabFragement;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.UnderConstrationFragement;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.REQUEST_CODE;

public class Home_Activity extends AppCompatActivity
        implements
        OnFragmentInteractionListener,
        NavigationView.OnNavigationItemSelectedListener {

    TextView user_name, user_contact, user_email;
    private AppSharedPreference appSharedPreference;
    private NavigationView navigationView;
    private LeedRepository leedsRepository;
    private UserRepository userRepository;
    ArrayList<LeedsModel> leedsArraylist;
    ArrayList<LeedsModel> invoicesArraylist;
    ArrayList<Bank> BanksArraylist;
    ArrayList<User> UserArraylist;

    private CardView cardTotalLeeds, cardBanks, cardLoanCalculator, cardActiveUsers, cardReports,cardComission,cardBills,
    cardCheckList;
    TextView leedscount, bankscount, userscount, reportscount;


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

        leedsRepository = new LeedRepositoryImpl();
        userRepository = new UserRepositoryImpl();
        appSharedPreference = new AppSharedPreference(getApplicationContext());
        leedsArraylist = new ArrayList<>();
        BanksArraylist = new ArrayList<>();
        invoicesArraylist = new ArrayList<>();
        UserArraylist = new ArrayList<>();

        updateNavigationHeader();

        cardTotalLeeds = (CardView) findViewById(R.id.leedcardId);
        cardBanks = (CardView) findViewById(R.id.bankscardId);
        cardLoanCalculator = (CardView) findViewById(R.id.calculatorcardId);
        cardActiveUsers = (CardView) findViewById(R.id.userscardId);
        cardReports = (CardView) findViewById(R.id.reportscardId);
        cardComission = (CardView) findViewById(R.id.commissionId);
        cardBills = (CardView) findViewById(R.id.billsId);
        cardCheckList = (CardView) findViewById(R.id.checklistcardId);

        leedscount = (TextView) findViewById(R.id.txttotalLeedvalue);
        bankscount = (TextView) findViewById(R.id.txtbanksvalue);
        userscount = (TextView) findViewById(R.id.txtactiveusersvalue);
        reportscount = (TextView) findViewById(R.id.txtreportsvalue);
        // get our list view
//        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//        ft.replace(R.id.mainFrame, new LeedsTabsFragment());
//        ft.commit();

        getLeedsReport();
        getBanks();
        readUsers();

        cardTotalLeeds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Activity.this, Activity_Home_Main.class);
                intent.putExtra("value", "leeds");
                startActivity(intent);
            }
        });
        cardBanks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Activity.this, Activity_Home_Main.class);
                intent.putExtra("value", "banks");
                startActivity(intent);
            }
        });
        cardLoanCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Activity.this, Activity_Home_Main.class);
                intent.putExtra("value", "calc");
                startActivity(intent);
            }
        });
        cardActiveUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Activity.this, Activity_Home_Main.class);
                intent.putExtra("value", "user");
                startActivity(intent);
            }
        });
        cardReports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Activity.this, Activity_Home_Main.class);
                intent.putExtra("value", "report");
                startActivity(intent);
            }
        });
        cardComission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Activity.this, Activity_Home_Main.class);
                intent.putExtra("value", "comission");
                startActivity(intent);
            }
        });
        cardBills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Activity.this, Activity_Home_Main.class);
                intent.putExtra("value", "bills");
                startActivity(intent);
            }
        });
        cardCheckList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Activity.this, Activity_Home_Main.class);
                intent.putExtra("value", "checklist");
                startActivity(intent);
            }
        });


    }

    private void getLeedsReport() {
        leedsRepository.readAllLeeds(new CallBack() {
            @Override
            public void onSuccess(Object object) {

                if (object != null) {
                    leedsArraylist = (ArrayList<LeedsModel>) object;
                }
                int a = leedsArraylist.size();
                leedscount.setText( String.valueOf(a));
                getInvoiceReport();
            }

            @Override
            public void onError(Object object) {

            }
        });
    }

    private void getInvoiceReport() {
        leedsRepository.readAllInvoices(new CallBack() {
            @Override
            public void onSuccess(Object object) {

                if (object != null) {
                    invoicesArraylist = (ArrayList<LeedsModel>) object;
                }
//              int in = invoicesArraylist.size() + leedsArraylist.size();
//                reportscount.setText("Total Reports:" + String.valueOf(in));
            }

            @Override
            public void onError(Object object) {

            }
        });
    }

    private void getBanks(){
        leedsRepository.readAllBanks(new CallBack() {
            @Override
            public void onSuccess(Object object) {

                if (object != null) {
                    BanksArraylist = (ArrayList<Bank>) object;
                }

                int b = BanksArraylist.size();
                bankscount.setText( String.valueOf(b));
            }

            @Override
            public void onError(Object object) {

            }
        });
    }

    private void readUsers(){
        userRepository.readAllusers(new CallBack() {
            @Override
            public void onSuccess(Object object) {

                if (object != null) {
                    UserArraylist = (ArrayList<User>) object;
                }

                int u = UserArraylist.size();
                userscount.setText( String.valueOf(u));
            }

            @Override
            public void onError(Object object) {

            }
        });
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
//                fragment = new UserTabsFragment();
                Intent intentuser = new Intent(Home_Activity.this, Activity_Home_Main.class);
                intentuser.putExtra("value", "user");
                startActivity(intentuser);
                break;
            case R.id.Leads:
//                fragment = new LeedsTabsFragment();
                Intent intent = new Intent(Home_Activity.this, Activity_Home_Main.class);
                intent.putExtra("value", "leeds");
                startActivity(intent);
                break;
            case R.id.Reports:
//                fragment = new ReportsTabFragment();
                Intent intentreport = new Intent(Home_Activity.this, Activity_Home_Main.class);
                intentreport.putExtra("value", "report");
                startActivity(intentreport);
                break;
            case R.id.Settings:
                fragment = new UnderConstrationFragement();
                break;
            case R.id.Invices:
                fragment = new InvoicesTabFragement();
                break;
            case R.id.Calulator:
//                fragment = new LoanCalculatorFragement();
                Intent intentcalc = new Intent(Home_Activity.this, Activity_Home_Main.class);
                intentcalc.putExtra("value", "calc");
                startActivity(intentcalc);
                break;
            case R.id.Bank:
//                fragment = new AddBankFragement();
                Intent intentbank = new Intent(Home_Activity.this, Activity_Home_Main.class);
                intentbank.putExtra("value", "banks");
                startActivity(intentbank);
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

    private void clearDataWithSignOut() {
        FirebaseAuth.getInstance().signOut();
        appSharedPreference.clear();
        logOut();
    }

    private void logOut() {
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
            textViewUserName.setText(appSharedPreference.getUserName());
            textViewEmailId.setText(appSharedPreference.getEmaiId());
            textViewAgentId.setText(appSharedPreference.getAgeniId());
            textViewMobileNumber.setText(appSharedPreference.getMobileNo());
            if (!Utility.isEmptyOrNull(appSharedPreference.getProfileLargeImage())) {
                Picasso.with(this).load(appSharedPreference.getProfileLargeImage()).resize(200, 200).centerCrop().placeholder(R.drawable.imagelogo).into(imageViewProfile);
                Picasso.with(this)
                        .load(appSharedPreference.getProfileLargeImage())
                        .into(imageViewProfile, new Callback() {
                            @Override
                            public void onSuccess() {
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        Bitmap innerBitmap = ((BitmapDrawable) imageViewProfile.getDrawable()).getBitmap();
                                        ivProfileLayout.setImageBitmap(Utility.blur(Home_Activity.this, innerBitmap));
                                    }
                                }, 100);
                            }

                            @Override
                            public void onError() {
                            }
                        });
            } else {
                imageViewProfile.setImageResource(R.drawable.imagelogo);
                ivProfileLayout.setImageResource(0);
            }
            if (!Utility.isEmptyOrNull(appSharedPreference.getProfileLargeImage())) {
                Picasso.with(this).load(appSharedPreference.getProfileLargeImage()).resize(200, 200).centerCrop().placeholder(R.drawable.imagelogo).into(imageViewProfile);
                Picasso.with(this)
                        .load(appSharedPreference.getProfileLargeImage())
                        .resize(200, 200)
                        .centerCrop()
                        .into(imageViewProfile, new Callback() {
                            @Override
                            public void onSuccess() {
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        Bitmap innerBitmap = ((BitmapDrawable) imageViewProfile.getDrawable()).getBitmap();
                                        imageViewProfile.setImageBitmap(Utility.blur(Home_Activity.this, innerBitmap));
                                    }
                                }, 100);
                            }

                            @Override
                            public void onError() {
                            }
                        });
            } else {
                imageViewProfile.setImageResource(R.drawable.imagelogo);
                ivProfileLayout.setImageResource(0);
            }
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
