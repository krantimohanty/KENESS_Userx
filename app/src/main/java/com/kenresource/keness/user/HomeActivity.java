package com.kenresource.keness.user;

import android.support.design.widget.TabLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

//
////import com.kenresource.keness.user.Adapter.FeedAdapter;
////import com.kenresource.keness.user.Adapter.FeedItemAnimator;
//import com.kenresource.keness.user.Fragment.CommunicationFragment;
//import com.kenresource.keness.user.Fragment.ESSFragment;
//import com.kenresource.keness.user.Fragment.NewsFragment;
//import com.kenresource.keness.user.icon_util.IcoMoonIcons;
//import com.kenresource.keness.user.view.FeedContextMenu;
////import com.kenresource.keness.user.view.FeedContextMenuManager;
//import com.joanzapata.iconify.IconDrawable;

import com.kenresource.keness.user.Fragment.CommunicationFragment;
import com.kenresource.keness.user.Fragment.ESSFragment;
import com.kenresource.keness.user.Fragment.HomeFragment;
import com.kenresource.keness.user.Fragment.NewsFragment;
import com.kenresource.keness.user.Model.MainModel;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BaseActivity
//        implements FeedAdapter.OnFeedItemClickListener,
//        FeedContextMenu.OnFeedContextMenuItemClickListener
{
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private int[] tabIcons = {
            R.drawable.ic_home,
            R.drawable.ic_ess,
            R.drawable.ic_news,
            R.drawable.ic_social,
    };
//private SearchView seachview;
//    public static final String ACTION_SHOW_LOADING_ITEM = "action_show_loading_item";
//
//    private static final int ANIM_DURATION_TOOLBAR = 300;
//    private static final int ANIM_DURATION_FAB = 400;

//    @BindView(R.id.rvFeed)
//    RecyclerView rvFeed;
//    @BindView(R.id.content)
//    CoordinatorLayout clContent;
//
//    private FeedAdapter feedAdapter;
//
//    private boolean pendingIntroAnimation;
    List<MainModel> mainlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
//        setupFeed();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setIcon(R.drawable.keness_logo);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);


        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
    }
    private void setupViewPager(ViewPager viewPager) {
        {
            ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
            adapter.addFragment(new HomeFragment() , "Home");
            adapter.addFragment(new ESSFragment(), "ESS");
            adapter.addFragment(new NewsFragment(), "News");
            adapter.addFragment(new CommunicationFragment(), "Social");

            viewPager.setAdapter(adapter);
        }
    }

    public static class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {


            // Log.e("ResultPosition", "getItem: "+position );
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}

//RecyclerView recyclerView =(RecyclerView)findViewById(R.id.recyclerView_main);
//        recyclerView.setHasFixedSize(true);
//        mainlist=new ArrayList<>();
//        MainAdapter adapter = new MainAdapter(this, mainlist);
//        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
////        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(CompanyActivity.this);
//        recyclerView.setLayoutManager(mLayoutManager);
//        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        mLayoutManager.scrollToPosition(0);
////        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.setAdapter(adapter);
//
//   mainMethod();


//
//        if (savedInstanceState == null) {
//            pendingIntroAnimation = true;
//        } else {
//            feedAdapter.updateItems(false);
//        }

//public  void  mainMethod()
//{
//
//     int [] profilepic  ={
//             R.drawable.anil
//
//     };
//
//    int [] poster = {
//        R.drawable.poster6
//
//    };
//
//MainModel model = new MainModel("Anil Kumar Dash", "Monday 10.30pm", "HR Manager",  R.string.press_release1 , poster[0] , profilepic[0]);
//mainlist.add(model);
//}



