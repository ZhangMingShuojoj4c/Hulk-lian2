package com.jtcode.sharedfloor;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.jtcode.sharedfloor.adapters.ViewPagerAdapter;
import com.jtcode.sharedfloor.fragments.FragmentPurchaseList;
import com.jtcode.sharedfloor.login.Activity_Login;
import com.jtcode.sharedfloor.model.PurchaseItem;
import com.jtcode.sharedfloor.presenters.PurchasePresenter;

public class Activity_Selection extends AppCompatActivity implements FragmentPurchaseList.PurchaseListInteraction{


    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private FloatingActionButton fab;

    //presenter
    PurchasePresenter purchasePresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__selection);
        init();

       // purchasePresenter= new PurchasePresenter(viewPager.);
    }
    private void init(){

        tabLayout=(TabLayout)findViewById(R.id.A_SEL_TabLayout);

        for(String title : getResources().getStringArray(R.array.titlesTabs)) {
            tabLayout.addTab(tabLayout.newTab().setText(title));
        }

        viewPager=(ViewPager) findViewById(R.id.A_SEL_ViewPager);
        adapter=new ViewPagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount(),Activity_Selection.this);
        viewPager.setAdapter(adapter);

        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        tabLayout.setupWithViewPager(viewPager);

        setIcon();

        viewPager.setPageTransformer(true, new AnimationSwip());

        //FAB
        fab=(FloatingActionButton)findViewById(R.id.A_SEL_FAB);
    }

    public void clickFAB(View view) {
        switch (viewPager.getCurrentItem()){
            case 0:
                break;

            case 1:

                break;

            case 2:

                break;

            case 3:

                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_common,menu);
        super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i=null;
        boolean close=false;
        switch (item.getItemId()){
            case R.id.action_logout:
                close=true;
                i= new Intent(Activity_Selection.this,Activity_Login.class);
                break;
            case R.id.action_about:
                i= new Intent(Activity_Selection.this,Activity_About.class);
                break;
        }
        if(i!=null){
            startActivity(i);
            if(close){
                finish();
            }
        }

        return super.onOptionsItemSelected(item);
    }

    private void setIcon(){
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_expenses);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_pruchase_list);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_clean_turn);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }


    @Override
    public boolean onPurchaseItemLongClick(PurchaseItem item) {
        boolean res=false;

        return res;
    }

}
