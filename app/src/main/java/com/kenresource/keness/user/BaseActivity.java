package com.kenresource.keness.user;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kenresource.keness.user.icon_util.IcoMoonModule;
import com.joanzapata.iconify.Iconify;
;

import java.io.File;

import de.hdodenhof.circleimageview.CircleImageView;

public class BaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private final static String TAG = "BaseActivity";
    private ProgressDialog mLoginProgressDialog;


    private RelativeLayout mRelativeLayout;
    private Toolbar mActionBarToolbar;
    private DrawerLayout mDrawerLayout;
    protected NavigationView mNavigationView;
    private ActionBarDrawerToggle mToggle;
    private CircleImageView profile_pic;
    private AppCompatTextView user_name, welcome_txt;
    private AppCompatTextView user_points;
    private ContentLoadingProgressBar progressBar;
    private AppCompatButton loginButton;
    //    private GoogleApiClient mGoogleApiClient;
    private GetCatSubCatDataEventListener getCatSubCatDataEventListener;
    //    private GooglePlusLoginUtils gLogin;
    private PopupWindow mPopupWindow;
    private Context mContext;
    private Activity mActivity;
    private TextView username;
    private  String name;
    public void setGetCatSubCatDataEventListener(GetCatSubCatDataEventListener eventListener) {
        getCatSubCatDataEventListener = eventListener;
    }

    /**
     * Helper method that can be used by child classes to
     * specify that they don't want a {@link Toolbar}
     *
     * @return true
     */
    protected boolean useToolbar() {
        return true;
    }


    /**
     * Helper method to allow child classes to opt-out of having the
     * hamburger menu.
     *
     * @return
     */
    protected boolean useDrawerToggle() {
        return true;
    }


    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);

        // reloadActivity();
        getActionBarToolbar();

        setupNavDrawer();
    }//end setContentView


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Iconify.with(new IcoMoonModule());

        mContext = getApplicationContext();

        // Get the activity
        mActivity = BaseActivity.this;

    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

    }

    protected Toolbar getActionBarToolbar() {
        if (mActionBarToolbar == null) {
            mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar);
            if (mActionBarToolbar != null) {
                if (useToolbar()) {
                    setSupportActionBar(mActionBarToolbar);
                } else {
                    mActionBarToolbar.setVisibility(View.GONE);
                }

            }
        }

        return mActionBarToolbar;
    }


    private void setupNavDrawer() {


        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (mDrawerLayout == null) {
            return;
        }

        // use the hamburger menu
        if (useDrawerToggle()) {
            mToggle = new ActionBarDrawerToggle(
                    this, mDrawerLayout, mActionBarToolbar,
                    R.string.navigation_drawer_open,
                    R.string.navigation_drawer_close);
            mDrawerLayout.setDrawerListener(mToggle);
            mToggle.syncState();
        } else if (useToolbar() && getSupportActionBar() != null) {
            // Use home/back button instead
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(ContextCompat
                    .getDrawable(this, R.drawable.ic_action_navigation_arrow_back));
        }


        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        mNavigationView.setNavigationItemSelectedListener(this);

        View headerView = mNavigationView.getHeaderView(0);
        //settings icon for navigation menu
        Menu menu = mNavigationView.getMenu();
//
//        menu.findItem(R.id.about).setIcon(
//                new IconDrawable(this, IcoMoonIcons.ic_chat)
//                        .colorRes(R.color.dark_grey)
//                        .actionBarSize());
//        menu.findItem(R.id.app_form).setIcon(
//                new IconDrawable(this, IcoMoonIcons.ic_registration)
//                        .colorRes(R.color.dark_grey)
//                        .actionBarSize());
//        menu.findItem(R.id.grievances).setIcon(
//                new IconDrawable(this, IcoMoonIcons.ic_discussion)
//                        .colorRes(R.color.dark_grey)
//                        .actionBarSize());
//
//        menu.findItem(R.id.feedback).setIcon(
//                new IconDrawable(this, IcoMoonIcons.ic_feedback)
//                        .colorRes(R.color.dark_grey)
//                        .actionBarSize());
//        menu.findItem(R.id.faq).setIcon(
//                new IconDrawable(this, IcoMoonIcons.ic_voter_id)
//                        .colorRes(R.color.dark_grey)
//                        .actionBarSize());


        //menu.findItem(R.id.members_activity).setIcon(null).setTitle("").setEnabled(false);
//        if (CustomPreference.with(BaseActivity.this).getInt("LoginUserId", 0) == 0) {
//            menu.findItem(R.id.logout).setIcon(null).setTitle("").setEnabled(false);
//        } else {
//        menu.findItem(R.id.logout).setIcon(
//                new IconDrawable(this, IcoMoonIcons.ic_logout)
//                        .colorRes(R.color.dark_grey)
//                        .actionBarSize());
        //suchismita
//       loginButton = (AppCompatButton) headerView.findViewById(R.id.loginButton);
        profile_pic = (CircleImageView) headerView.findViewById(R.id.profilePic);
        profile_pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
//        profile_pic.setImageDrawable(new IconDrawable(this, IcoMoonIcons.ic_user)
//                .colorRes(R.color.white)
//                .actionBarSize());

//        progressBar = (ContentLoadingProgressBar) headerView.findViewById(R.id.progress);
//       welcome_txt = (AppCompatTextView) headerView.findViewById(R.id.welcome_txt);
//        user_name = (AppCompatTextView) headerView.findViewById(R.id.user_name);
//        user_points = (AppCompatTextView) headerView.findViewById(R.id.points);

       /* if (CustomPreference.with(BaseActivity.this).getString("LoginUserId", "").equals("")) {

        } else {

        }*/
         /*

        */
        //getting user information
        // Toast.makeText(BaseActivity.this, CustomPreference.with(BaseActivity.this).getString("LoginUserId", ""), Toast.LENGTH_LONG).show();
//        if (CustomPreference.with(BaseActivity.this).getInt("LoginUserId", 0) == 0) {
//            //user_name.setText("Guest");
//            user_name.setVisibility(View.GONE);
//            welcome_txt.setText("Welcome Guest");
//            user_points.setVisibility(View.GONE);
//            loginButton.setVisibility(View.VISIBLE);
//            loginButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intentGetMessage = new Intent(BaseActivity.this, LoginActivity.class);
//                    intentGetMessage.putExtra("activityFrom", "BaseActivity");
//                    startActivityForResult(intentGetMessage, 2);
//                    //finish();
//                    //startActivity(new Intent(BaseActivity.this, LoginActivityOldie.class).putExtra("pageFrom", "BaseActivity"));
//                    //finish();
//                }
//            });
//        } else {
//            // ServiceCalls.getUserInfo(BaseActivity.this, CustomPreference.with(BaseActivity.this).getInt("LoginUserId", 0), progressBar, user_name, profile_pic, user_points, "");
//            user_points.setVisibility(View.GONE);
//            welcome_txt.setText("Welcome to Babylonia");
//            loginButton.setVisibility(View.GONE);
//            user_name.setVisibility(View.VISIBLE);
//            user_name.setText(CustomPreference.with(BaseActivity.this).getString("name", ""));
//        }
        //changing group item color in nav menu
        // SpannableString s = new SpannableString(mNavigationView.getMenu().findItem(R.id.news_group).getTitle().toString());
        //SpannableString s1 = new SpannableString(mNavigationView.getMenu().findItem(R.id.get_involved_group).getTitle().toString());
        //SpannableString s2 = new SpannableString(mNavigationView.getMenu().findItem(R.id.others).getTitle().toString());
        //s.setSpan(new ForegroundColorSpan(Color.parseColor("#ff9800")), 0, s.length(), 0);
        //s1.setSpan(new ForegroundColorSpan(Color.parseColor("#ff9800")), 0, s1.length(), 0);
        //s2.setSpan(new ForegroundColorSpan(Color.parseColor("#ff9800")), 0, s2.length(), 0);
        //mNavigationView.getMenu().findItem(R.id.news_group).setTitle(s);
        //mNavigationView.getMenu().findItem(R.id.get_involved_group).setTitle(s1);
        //mNavigationView.getMenu().findItem(R.id.others).setTitle(s2);





    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        try {
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
        } catch (Exception e) {

        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();
//        if (id == R.id.home) {
////            startActivity(new Intent(BaseActivity.this, HomeActivity.class));
//
//        }

        if (id == R.id.myProfile) {
            startActivity(new Intent(BaseActivity.this, ProfileMainActivity.class));

        } else if (id == R.id.my_approval) {
           startActivity(new Intent(BaseActivity.this, MyApproval.class));
        } else if (id == R.id.my_leave) {
            startActivity(new Intent(BaseActivity.this, MyLeave.class));
        }
        else if (id == R.id.my_time) {
            startActivity(new Intent(BaseActivity.this, MyTime.class));

        }
        else if (id == R.id.my_pay) {
            startActivity(new Intent(BaseActivity.this, MyPay.class));

        }
        else if (id == R.id.logout) {

            AlertDialog.Builder builder = new AlertDialog.Builder(BaseActivity.this, R.style.AppCompatAlertDialogStyle);
            builder.setTitle("Logout");
            builder.setMessage("Do you want to logout ?");
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //gLogin.googlePlusLogout();
                  /*  mGoogleApiClient = getApiClient();


                        Plus.AccountApi.clearDefaultAccount(myApp.mGoogleApiClient);
                        myApp.mGoogleApiClient.disconnect();
                        myApp.mGoogleApiClient.connect();
                        Log.d("App", "isConnected");*/

                    moveTaskToBack(true);
                    android.os.Process.killProcess(android.os.Process.myPid());
                    System.exit(1);

                }

            });

            builder.show();

        }

        closeNavDrawer();
        return true;
    }


//     if (id == R.id.logout) {
//            AlertDialog.Builder builder = new AlertDialog.Builder(BaseActivity.this, R.style.AppCompatAlertDialogStyle);
//            builder.setTitle("Logout");
//            builder.setMessage("Do you want to logout ?");
//            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                }
//            });
//            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    //gLogin.googlePlusLogout();
//                  /*  mGoogleApiClient = getApiClient();
//
//
//                        Plus.AccountApi.clearDefaultAccount(myApp.mGoogleApiClient);
//                        myApp.mGoogleApiClient.disconnect();
//                        myApp.mGoogleApiClient.connect();
//                        Log.d("App", "isConnected");*/
//                    moveTaskToBack(true);
//                    android.os.Process.killProcess(android.os.Process.myPid());
//                    System.exit(1);
//
//                            }
//
//
//
//
//
//
//
//
//
//
//
//
//            });
//
//            builder.show();
//
//        }
//
//        closeNavDrawer();
//        return true;
//    }

    public void trimCache() {
        try {
            File dir = getCacheDir();
            if (dir != null && dir.isDirectory()) {
                deleteDir(dir);
                reloadActivity();

            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }


    public static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        return dir.delete();
    }

    protected boolean isNavDrawerOpen() {
        return mDrawerLayout != null && mDrawerLayout.isDrawerOpen(GravityCompat.START);
    }

    protected void closeNavDrawer() {
        if (mDrawerLayout != null) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }
    }


    /**
     * Enables back navigation for activities that are launched from the NavBar. See
     * {@code AndroidManifest.xml} to find out the parent activity names for each activity.
     *
     * @param intent
     */
    private void createBackStack(Intent intent) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            TaskStackBuilder builder = TaskStackBuilder.create(this);
            builder.addNextIntentWithParentStack(intent);
            builder.startActivities();
        } else {
            startActivity(intent);
            finish();
        }
    }

    public interface GetCatSubCatDataEventListener {
        void onDataReceive();
    }

    public void reloadActivity() {
        Intent intent = getIntent();
        overridePendingTransition(0, 0);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();
        overridePendingTransition(0, 0);
        startActivity(intent);
    }

}//end BaseActivity

