package com.example.sujith.interrupt.Activity;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.transition.Fade;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.sujith.interrupt.Fragment.EventsFrag.Description;
import com.example.sujith.interrupt.Menu.GridMenuFragment1;
import com.example.sujith.interrupt.R;
import com.goka.blurredgridmenu.GridMenu;
import com.goka.blurredgridmenu.GridMenuFragment;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class EventActivity extends AppCompatActivity {


    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private GestureDetector gestureDetector;
    private DotsIndicator dotsIndicator;
    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());



        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        dotsIndicator = (DotsIndicator) findViewById(R.id.dots_indicator);
        dotsIndicator.setHorizontalGravity(Gravity.CENTER_HORIZONTAL);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        dotsIndicator.setViewPager(mViewPager);
        mViewPager.setOffscreenPageLimit(10);

        PlaceholderFragment placeholderFragment = new PlaceholderFragment();
        placeholderFragment.view(mViewPager);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }




//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main2, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private ImageButton button;
        public static final String ARG_SECTION_NUMBER = "section_number";
        public GridMenuFragment1 mGridMenuFragment;
        private static ViewPager viewPager;

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Fade fade = new Fade();
            fade.setDuration(100);
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public void view(ViewPager mViewPager){
            viewPager = mViewPager;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_event, container, false);

            TextView title = rootView.findViewById(R.id.EventTitle);
            CircleImageView icon = rootView.findViewById(R.id.EventIcon);
            RelativeLayout relativeLayout = rootView.findViewById(R.id.rel2);
            mGridMenuFragment = GridMenuFragment1.newInstance(R.drawable.silicon);
            button = rootView.findViewById(R.id.context_menu1);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FragmentTransaction tx = getChildFragmentManager().beginTransaction();
                    tx.replace(R.id.dummy, mGridMenuFragment);
                    tx.addToBackStack(null);
                    tx.commit();

                }
            });

            setupGridMenu();




            mGridMenuFragment.setOnClickMenuListener(new GridMenuFragment.OnClickMenuListener() {
                @Override
                public void onClickMenu(GridMenu gridMenu, int position) {
                    switch (position){
                        case 0: {
                            viewPager.setCurrentItem(0,true);
                            break;
                        }
                        case 1: {
                            viewPager.setCurrentItem(1,true);
                            break;
                        }
                        case 2:{
                            viewPager.setCurrentItem(2,true);
                            break;
                        }
                        case 3:{
                            viewPager.setCurrentItem(3,true);
                            break;
                        }
                        case 4:{
                            viewPager.setCurrentItem(4,true);
                            break;
                        }
                        case 5:{
                            viewPager.setCurrentItem(5,true);
                            break;
                        }
                        case 6:{
                            viewPager.setCurrentItem(6,true);
                            break;
                        }
                        case 7:{
                            viewPager.setCurrentItem(7,true);
                            break;
                        }
                        case 8:{
                            viewPager.setCurrentItem(8,true);
                            break;
                        }
                        case 9:{
                            viewPager.setCurrentItem(9,true);
                            break;
                        }
                        case 10:{
                            viewPager.setCurrentItem(10,true);
                            break;
                        }
                    }
                }
            });


            switch(getArguments().getInt(ARG_SECTION_NUMBER)){

                case 1: {
                    title.setText("Pitch Perfect");
                    icon.setImageResource(R.drawable.ic_launcher_background);
                    relativeLayout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Description fragment = new Description();
                            fragment.setDes("Hello this is the description","Hello this are the Rules");
                            getChildFragmentManager()
                                    .beginTransaction()
                                    .setCustomAnimations(R.anim.slide_up,R.anim.slide_down)
                                    .replace(R.id.dummy,new Description())
                                    .commit();
                        }
                    });
                    break;
                }
                case 2: {
                    title.setText("Event 2");
                    icon.setImageResource(R.drawable.silicon);
                    relativeLayout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Description fragment = new Description();
                            fragment.setDes("Hello this is the description","Hello this are the Rules");
                            getChildFragmentManager()
                                    .beginTransaction()
                                    .setCustomAnimations(R.anim.slide_up,R.anim.slide_down)
                                    .replace(R.id.dummy,new Description())
                                    .commit();
                        }
                    });
                    break;
                }
                case 11: {
                    title.setText("Event 11");
                    icon.setImageResource(R.drawable.siliconchar);
                    relativeLayout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Description fragment = new Description();
                            fragment.setDes("Hello this is the description","Hello this are the Rules");
                            getChildFragmentManager()
                                    .beginTransaction()
                                    .setCustomAnimations(R.anim.slide_up,R.anim.slide_down)
                                    .replace(R.id.dummy,new Description())
                                    .commit();
                        }
                    });
                    break;
                }

            }

            return rootView;
        }

        private void setupGridMenu() {
            List<GridMenu> menus = new ArrayList<>();
            menus.add(new GridMenu("Pitch Perfect", R.drawable.ic_event_note_black_24dp));
            menus.add(new GridMenu("Event 2", R.drawable.ic_event_note_black_24dp));
            menus.add(new GridMenu("Event 3", R.drawable.ic_event_note_black_24dp));
            menus.add(new GridMenu("Event 4", R.drawable.ic_event_note_black_24dp));
            menus.add(new GridMenu("Event 5", R.drawable.ic_event_note_black_24dp));
            menus.add(new GridMenu("Event 6", R.drawable.ic_event_note_black_24dp));
            menus.add(new GridMenu("Event 7", R.drawable.ic_event_note_black_24dp));
            menus.add(new GridMenu("Event 8", R.drawable.ic_event_note_black_24dp));
            menus.add(new GridMenu("Event 9", R.drawable.ic_event_note_black_24dp));
            menus.add(new GridMenu("Event 10", R.drawable.ic_event_note_black_24dp));
            menus.add(new GridMenu("Event 11", R.drawable.ic_event_note_black_24dp));

            mGridMenuFragment.setupMenu(menus);
        }


        public boolean subFunc() {
            if (isAdded()) {
                if (0 == getChildFragmentManager().getBackStackEntryCount()) {
                    return true;
                } else {
                    getChildFragmentManager().popBackStack();
                    return false;
                }
            }
            Log.d("Tag","Not Working");
            return true;
        }


    }

    PlaceholderFragment placeholderFragment = new PlaceholderFragment();
    @Override
    public void onBackPressed() {
        if(placeholderFragment.subFunc()){
            super.onBackPressed();
        }else{
            getSupportFragmentManager().popBackStack();
        }
    }

//    @Override
//    public boolean onContextItemSelected(final MenuItem item) {
//
//        setFinishOnTouchOutside(true);
//        switch(item.getItemId()){
//            case R.id.action_event1: {
//                mViewPager.setCurrentItem(0,true);
//                break;
//            }
//            case R.id.action_event2: {
//                mViewPager.setCurrentItem(1,true);
//                break;
//            }
//            case R.id.action_event3:{
//                mViewPager.setCurrentItem(2,true);
//                break;
//            }
//            case R.id.action_event4:{
//                mViewPager.setCurrentItem(3,true);
//                break;
//            }
//            case R.id.action_event5:{
//                mViewPager.setCurrentItem(4,true);
//                break;
//            }
//            case R.id.action_event6:{
//                mViewPager.setCurrentItem(5,true);
//                break;
//            }
//            case R.id.action_event7:{
//                mViewPager.setCurrentItem(6,true);
//                break;
//            }
//            case R.id.action_event8:{
//                mViewPager.setCurrentItem(7,true);
//                break;
//            }
//            case R.id.action_event9:{
//                mViewPager.setCurrentItem(8,true);
//                break;
//            }
//            case R.id.action_event10:{
//                mViewPager.setCurrentItem(9,true);
//                break;
//            }
//            case R.id.action_event11:{
//                mViewPager.setCurrentItem(10,true);
//                break;
//            }
//
//
//        }
//
//        return super.onContextItemSelected(item);
//    }
//
//    @Override
//    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//        super.onCreateContextMenu(menu, v, menuInfo);
//
//        MenuInflater menuInflater = getMenuInflater();
//        menuInflater.inflate(R.menu.context_menu,menu);
//
//    }


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
