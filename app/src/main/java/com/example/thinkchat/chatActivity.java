package com.example.thinkchat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class chatActivity extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem mchat,mcall,mstatus;
    ViewPager viewPager;
    PagerAdapter pagerAdapter;
    androidx.appcompat.widget.Toolbar mtoolbar;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

       tabLayout=findViewById(R.id.include);
       mchat = findViewById(R.id.chat);
       mstatus=findViewById(R.id.status);
       mcall=findViewById(R.id.calls);
       viewPager=findViewById(R.id.fragmentcontainer);

       mtoolbar=findViewById(R.id.toolbar);
       setSupportActionBar(mtoolbar);


       Drawable drawable= ContextCompat.getDrawable(getApplicationContext(),R.drawable.ic_baseline_more_vert_24);
       mtoolbar.setOverflowIcon(drawable);





       pagerAdapter= new PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
       viewPager.setAdapter(pagerAdapter);

       tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
           @Override
           public void onTabSelected(TabLayout.Tab tab) {
               viewPager.setCurrentItem(tab.getPosition());
               if(tab.getPosition()==0 || tab.getPosition()==1 || tab.getPosition()==2 )
               {
                   pagerAdapter.notifyDataSetChanged();
               }




           }

           @Override
           public void onTabUnselected(TabLayout.Tab tab) {

           }

           @Override
           public void onTabReselected(TabLayout.Tab tab) {

           }
       });

       viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));




    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.profile:
                Intent intent=new Intent (chatActivity.this,ProfileActivity.class);
                startActivity(intent);
                break;


            case R.id.settings:
                Intent intent1=new Intent (chatActivity.this,splashscreen.class);
                startActivity(intent1);

                break;


        }





        return true;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);




        return true;

    }
}