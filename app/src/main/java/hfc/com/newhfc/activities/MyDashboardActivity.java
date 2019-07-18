package hfc.com.newhfc.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.gson.Gson;

import hfc.com.newhfc.R;
import hfc.com.newhfc.fragments.LeftFragment;
import hfc.com.newhfc.fragments.RightFragment;
import hfc.com.newhfc.model.LoginResponse;
import hfc.com.newhfc.model.login.NewLoginResponse;
import hfc.com.newhfc.model.login.ResponseLogin;
import hfc.com.newhfc.utils.Constants;
import hfc.com.newhfc.utils.HFCPrefs;

import static hfc.com.newhfc.utils.Constants.LOGIN_DATA;

public class MyDashboardActivity extends AppCompatActivity {


    private TabLayout tabLayout;
    private ViewPager viewPager;
    private MyPagerAdapter adapterViewPager;
    private TextView name,phone,adhar,nominee,address,emails,pan,bankAcnt,relation,earning;
    ResponseLogin loginResponses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_dashboard);
        name=findViewById(R.id.tv_names);
        emails=findViewById(R.id.tv_emails);
        phone=findViewById(R.id.tv_phones);
        pan=findViewById(R.id.tv_pancard);
        nominee=findViewById(R.id.tv_nominee);
        relation=findViewById(R.id.tv_relation);
        address=findViewById(R.id.tv_address);
        adhar=findViewById(R.id.tv_adhar);
        bankAcnt=findViewById(R.id.tv_bank);
        earning=findViewById(R.id.tv_earnings);


        ResponseLogin loginResponses = new Gson().fromJson(HFCPrefs.getString(this,LOGIN_DATA),ResponseLogin.class);
        Log.d("mdfnv", "onCreate: "+loginResponses);
        if (loginResponses.getFirstName()!=null && loginResponses.getLastName()!=null){
            Log.d("mdfnv", "onCreate: "+loginResponses.getFirstName());
            name.setText(" Name : " + loginResponses.getFirstName() + " " + loginResponses.getLastName());
        }
        if (loginResponses.getEmail()!=null ){
            emails.setText(" Email : " + loginResponses.getEmail() );
        }
        if (loginResponses.getPhoneNumber() != null) {
            phone.setText("Phone :" + loginResponses.getPhoneNumber());
        }
        if (loginResponses. getPanNumber() != null) {
            Log.d("mdfnv", "onCreate: "+loginResponses.getPanNumber());
            pan.setText("Pan :" + loginResponses.getPanNumber());
        }
        if (loginResponses.getNomineeName() != null) {
            Log.d("mdfnv", "onCreate: "+loginResponses.getNomineeName());
            nominee.setText("Nominee :" + loginResponses.getNomineeName());
        }
        if (loginResponses.getRelation() != null) {
            relation.setText("Relation :" + loginResponses.getRelation());
        }
        if (loginResponses.getAddress() != null) {
            address.setText("Address :" + loginResponses.getAddress());
        }
        if (loginResponses.getAdharNumber() != null) {
            adhar.setText("Adhar :" + loginResponses.getAdharNumber());
        }
        if (loginResponses.getAccountNumber() != null) {
            bankAcnt.setText("Bank A/C :" + loginResponses.getAccountNumber());
        }
        if (loginResponses.getCommision() != null) {
            earning.setText("Earning :" + loginResponses.getCommision());
        }



        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }


        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);

        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapterViewPager);
        tabLayout.setupWithViewPager(viewPager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(MyDashboardActivity.this, R.color.colorAccent));
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 2;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: // Fragment # 0 - This will show FirstFragment
                    return new LeftFragment();
                case 1: // Fragment # 0 - This will show FirstFragment different title
                    return new RightFragment();

                default:
                    return null;
            }
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            if (position==0){
                return "Side A ";
            }else{
                return "Side B ";
            }
        }

    }
}
