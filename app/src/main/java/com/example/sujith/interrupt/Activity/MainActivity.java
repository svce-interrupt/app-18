package com.example.sujith.interrupt.Activity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.app.Fragment;
import android.widget.Toast;

import java.util.Arrays;

import com.example.sujith.interrupt.Fragment.AboutUs;
import com.example.sujith.interrupt.Fragment.ChatBot;
import com.example.sujith.interrupt.Fragment.Events;
import com.example.sujith.interrupt.Fragment.Home;
import com.example.sujith.interrupt.Menu.DrawerAdapter;
import com.example.sujith.interrupt.Menu.DrawerItem;
import com.example.sujith.interrupt.Menu.SimpleItem;
import com.example.sujith.interrupt.Menu.SpaceItem;
import com.example.sujith.interrupt.R;
import com.example.sujith.interrupt.Fragment.Text;
import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;

public class MainActivity extends AppCompatActivity implements DrawerAdapter.OnItemSelectedListener {

    private static final int POS_HOME = 0;
    private static final int POS_EVENTS =1;
    private static final int POS_ABOUT_US =2;
    private static final int POS_CHATBOT =3;
    private static final int POS_LOGOUT = 5;

    private String[] screenTitle;
    private Drawable[] screenIcons;

    private SlidingRootNav slidingRootNav;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Home");
        setSupportActionBar(toolbar);


        slidingRootNav = new SlidingRootNavBuilder(this)
                .withToolbarMenuToggle(toolbar)
                .withMenuOpened(false)
                .withContentClickableWhenMenuOpened(false)
                .withSavedState(savedInstanceState)
                .withMenuLayout(R.layout.menu_left_drawer)
                .inject();


        screenIcons = loadScreenIcons();
        screenTitle = loadScreenTitles();
        //This part...!!
        DrawerAdapter adapter = new DrawerAdapter(Arrays.asList(
                createItemFor(POS_HOME),
                createItemFor(POS_EVENTS),
                createItemFor(POS_ABOUT_US),
                createItemFor(POS_CHATBOT),
                new SpaceItem(48),
                createItemFor(POS_LOGOUT)
        ));
        adapter.setListener(this);

        RecyclerView list = findViewById(R.id.list);
        list.setNestedScrollingEnabled(false);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(adapter);

        adapter.setSelected(POS_HOME);
    }

    @Override
    public void onItemSelected(int position) {
        switch(position){
            case POS_HOME :
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.activityMain, new Home())
                        .commit();
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
                break;
            case POS_EVENTS :
                Intent intent = new Intent(MainActivity.this,Event.class);
                startActivity(intent);
                Toast.makeText(this,"Events",Toast.LENGTH_SHORT).show();
                break;
            case POS_ABOUT_US :
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.activityMain, new AboutUs())
                        .commit();
                Toast.makeText(this,"About Us",Toast.LENGTH_SHORT).show();
                break;
            case POS_CHATBOT :
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.activityMain, new ChatBot())
                        .commit();
                Toast.makeText(this,"ChatBot",Toast.LENGTH_SHORT).show();
                break;
            case POS_LOGOUT :
                finish();
                Toast.makeText(this,"You are logged out",Toast.LENGTH_SHORT).show();
                break;
        }

        slidingRootNav.closeMenu();
        Fragment selectedScreen = Text.createFor(screenTitle[position]);
        showFragment(selectedScreen);
    }

    private void showFragment(Fragment fragment){
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.Container, fragment)
                .commit();
    }
    private DrawerItem createItemFor(int position) {
        return new SimpleItem(screenIcons[position], screenTitle[position])
                .withIconTint(color(R.color.textSecondaryColorDark))
                .withTextTint(color(R.color.colorPrimary))
                .withSelectedIconTint(color(R.color.colorAccent))
                .withSelectedTextTint(color(R.color.colorAccent));
    }

    private  String[] loadScreenTitles(){
        return getResources().getStringArray(R.array.id_activityScreenTitles);
    }

    private Drawable[] loadScreenIcons(){
        TypedArray ta = getResources().obtainTypedArray(R.array.id_activityScreenIcons);
        Drawable[] icons = new Drawable[ta.length()];
        for(int i=0; i < ta.length(); i++){
            int id = ta.getResourceId(i,0);
            if(id != 0){
                icons[i] = ContextCompat.getDrawable(this, id);
            }
        }
        ta.recycle();
        return icons;
    }

    @ColorInt
    private int color(@ColorRes int res){
        return ContextCompat.getColor(this, res);
    }


}
