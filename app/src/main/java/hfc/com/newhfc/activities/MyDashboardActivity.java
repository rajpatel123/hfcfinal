package hfc.com.newhfc.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.gson.Gson;

import hfc.com.newhfc.R;
import hfc.com.newhfc.fragments.LeftFragment;
import hfc.com.newhfc.fragments.RightFragment;
import hfc.com.newhfc.model.LoginResponse;
import hfc.com.newhfc.model.login.NewLoginResponse;
import hfc.com.newhfc.utils.Constants;
import hfc.com.newhfc.utils.HFCPrefs;

import static hfc.com.newhfc.utils.Constants.LOGIN_DATA;

public class MyDashboardActivity extends AppCompatActivity {


    private TabLayout tabLayout;
    private ViewPager viewPager;
    private MyPagerAdapter adapterViewPager;
    private TextView name,phone,adhar,nominee,address,emails,pan,bankAcnt,relation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_dashboard);
        name=findViewById(R.id.tv_names);
        emails=findViewById(R.id.tv_emails);
        phone=findViewById(R.id.tv_phones);
        pan=findViewById(R.id.tv_pancard);
        nominee=findViewById(R.id.tv_nominee);
        relation=findViewById(R.id.tv_relations);
        address=findViewById(R.id.tv_address);
        adhar=findViewById(R.id.tv_adhar);
        bankAcnt=findViewById(R.id.tv_bank);

        NewLoginResponse loginResponse = new Gson().fromJson(HFCPrefs.getString(this,LOGIN_DATA),NewLoginResponse.class);
        if (loginResponse.getFirstName()!=null && loginResponse.getLastName()!=null){
            name.setText(" Name : " + loginResponse.getFirstName() + " " + loginResponse.getLastName());
        }
        if (loginResponse.getEmail()!=null ){
            emails.setText(" Email : " + loginResponse.getEmail() );
        }
        if (loginResponse.getPhoneNumber() != null) {
            phone.setText("Phone :" + loginResponse.getPhoneNumber());
        }
        if (loginResponse. getPanNumber() != null) {
            pan.setText("Pan :" + loginResponse.getPanNumber());
        }
        if (loginResponse.getNomineeName() != null) {
            nominee.setText("Nominee :" + loginResponse.getNomineeName());
        }
        if (loginResponse.getRelation() != null) {
            relation.setText("Relation :" + loginResponse.getRelation());
        }
        if (loginResponse.getAddress() != null) {
            address.setText("Address :" + loginResponse.getAddress());
        }
        if (loginResponse.getAdharNumber() != null) {
            adhar.setText("Adhar :" + loginResponse.getAdharNumber());
        }
        if (loginResponse.getAccountNumber() != null) {
            bankAcnt.setText("Bank A/C :" + loginResponse.getAccountNumber());
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
