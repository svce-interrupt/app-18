package com.example.sujith.interrupt.Activity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.widget.Toast;

import com.example.sujith.interrupt.Fragment.AboutUs;
import com.example.sujith.interrupt.Fragment.ChatBot;
import com.example.sujith.interrupt.Fragment.Events;
import com.example.sujith.interrupt.Fragment.EventsFrag.PitchPerfect;
import com.example.sujith.interrupt.Fragment.Home;
import com.example.sujith.interrupt.Fragment.Text;
import com.example.sujith.interrupt.Menu.DrawerAdapter;
import com.example.sujith.interrupt.Menu.DrawerItem;
import com.example.sujith.interrupt.Menu.SimpleItem;
import com.example.sujith.interrupt.Menu.SpaceItem;
import com.example.sujith.interrupt.R;
import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;

import java.util.Arrays;

import de.hdodenhof.circleimageview.CircleImageView;

public class Event extends AppCompatActivity implements DrawerAdapter.OnItemSelectedListener{

    private static final int POS_HOME = 0;
    private static final int POS_EVENTS =1;
    private static final int POS_ABOUT_US =2;
    private static final int POS_CHATBOT =3;
    private static final int POS_LOGOUT = 5;

    private String[] screenTitle;
    private Drawable[] screenIcons;

    private SlidingRootNav slidingRootNav;

    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        Toolbar toolbar = (Toolbar) findViewById(R.id.evetoolbar);
        toolbar.setTitle("Events");
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

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

        adapter.setSelected(POS_EVENTS);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }
    @Override
    public void onItemSelected(int position) {
        switch(position){
            case POS_HOME :
//                getSupportFragmentManager()
//                        .beginTransaction()
//                        .replace(R.id.container, new Home())
//                        .commit();
                Intent intent = new Intent(Event.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
                break;

            case POS_EVENTS :
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.activity_Event, new Events())
                        .detach(new Events())
                        .commit();

                Toast.makeText(this,"Events",Toast.LENGTH_SHORT).show();
                break;


            case POS_ABOUT_US :
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.activity_Event, new AboutUs())
                        .commit();
                Toast.makeText(this,"About Us",Toast.LENGTH_SHORT).show();
                break;
            case POS_CHATBOT :
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.activity_Event, new ChatBot())
                        .commit();
                Toast.makeText(this,"ChatBot",Toast.LENGTH_SHORT).show();
                break;
            case POS_LOGOUT :
                finish();
                Toast.makeText(this,"You are logged out",Toast.LENGTH_SHORT).show();
                break;
        }

        slidingRootNav.closeMenu();
        android.app.Fragment selectedScreen = Text.createFor(screenTitle[position]);
        showFragment(selectedScreen);
    }


    private void showFragment(android.app.Fragment fragment){
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_event, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_event, container, false);
            //TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            //textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));

            ImageView leftArrow = rootView.findViewById(R.id.left);
            ImageView rightArrow = rootView.findViewById(R.id.right);
            RelativeLayout relativeLayout = rootView.findViewById(R.id.Event_frag);

            CircleImageView imageView = rootView.findViewById(R.id.image);
            switch(getArguments().getInt(ARG_SECTION_NUMBER)){
                case 1: {
                    imageView.setImageResource(R.drawable.ic_launcher_background);
                    leftArrow.setVisibility(View.INVISIBLE);
                    imageView.setBorderColor(Color.BLACK);
                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            FragmentManager fragmentManager = getFragmentManager();
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            PitchPerfect pitchPerfect = new PitchPerfect();
                            fragmentTransaction.add(R.id.activity_Event,pitchPerfect);
                            fragmentTransaction.replace(R.id.activity_Event,pitchPerfect);
                            fragmentTransaction.commit();
                        }
                    });

                    break;
                }
                case 2: {
                    imageView.setImageResource(R.drawable.silicon);
                    break;
                }
                case 3: {
                    imageView.setImageResource(R.drawable.siliconchar);
                    break;
                }
                case 11: {
                    imageView.setImageResource(R.drawable.ic_launcher_foreground);
                    rightArrow.setVisibility(View.INVISIBLE);
                    break;
                }
                default: {break;}
            }

            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 11;
        }

    }


}