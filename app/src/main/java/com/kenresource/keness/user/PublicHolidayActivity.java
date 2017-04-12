package com.kenresource.keness.user;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import butterknife.BindView;

import butterknife.ButterKnife;

import io.ken_blackboxvison.materialcalendarview.view.CalendarView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.kenresource.keness.user.Adapter.ListAdapter;
import com.kenresource.keness.user.Model.ListModel;
import com.kenresource.keness.user.logic.presenter.MainPresenter;
import com.kenresource.keness.user.logic.presenter_view.MainView;


@SuppressLint("SimpleDateFormat")
public class PublicHolidayActivity extends AppCompatActivity  implements MainView {
    private static final String DATE_TEMPLATE = "dd/MM/yyyy";
    private static final String MONTH_TEMPLATE = "MMMM yyyy";

    private final MainPresenter presenter = new MainPresenter(this);
    public List<ListModel> holidayList;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerview;

    @BindView(R.id.toolbar)
    Toolbar toolbar;


    @BindView(R.id.calendar_view)
   public CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_public_holiday);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        calendarView=(CalendarView)findViewById(R.id.calendar_view);
        getSupportActionBar().setTitle("Public Holiday List");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        initCollapsingToolbar();

        recyclerview=(RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerview.setLayoutManager(mLayoutManager);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mLayoutManager.scrollToPosition(0);
        recyclerview.setItemAnimator(new DefaultItemAnimator());
        holidayList = new ArrayList<ListModel>();
        ViewCompat.setNestedScrollingEnabled(recyclerview, false);
        ListAdapter adapter = new ListAdapter(PublicHolidayActivity.this, holidayList);
        recyclerview.setAdapter(adapter);
        recyclerview.setNestedScrollingEnabled(false);
        recyclerview.setHasFixedSize(false);
        presenter.addListView();
        presenter.addCalendarView();
        presenter.animate();



//        textView=(TextView)findViewById(R.id.textview);

        ButterKnife.bind(this);
//        presenter.addNavigationDrawer();


    }

    @Override
    public void prepareListView() {

        final String[] dates = {"January 26", "February 1" ,"February 24" , "March 24", "April 03" ,
                "May 01"  , "June 15", "June 24" , "August 15" , "August 25" };
        final String[] events = {"Republic Day", "Saraswati Puja" , "Mahashivaratri" , "Holi" ,
                "Utkal Divas" , "Labour Day", "Raja Sankranti", "Eid-Ul-Fitar" , "Independence Day" , "Ganesh Puja" };

        for(int i=0; i<dates.length; i++)
        {
            ListModel item = new ListModel(dates[i], events[i]);
            holidayList.add(item);

        }


//        textView.setText(String.format("Today is %s", formatDate(DATE_TEMPLATE, new Date(System.currentTimeMillis()))));
    }
//    private void initCollapsingToolbar() {
//        final CollapsingToolbarLayout collapsingToolbar =
//                (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
//        collapsingToolbar.setTitle(" ");
//        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.app_bar);
//        appBarLayout.setExpanded(true);
//
//        // hiding & showing the title when toolbar expanded & collapsed
//        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
//            boolean isShow = false;
//            int scrollRange = -1;
//
//            @Override
//            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
//                if (scrollRange == -1) {
//                    scrollRange = appBarLayout.getTotalScrollRange();
//                }
//                if (scrollRange + verticalOffset == 0) {
//                    collapsingToolbar.setTitle(getString(R.string.app_name));
//                    isShow = true;
//                } else if (isShow) {
//                    collapsingToolbar.setTitle(" ");
//                    isShow = false;
//                }
//            }
//        });
//    }
    @Override
    public void prepareCalendarView() {

//        disabledCal.set(Calendar.DATE, disabledCal.get(Calendar.DATE) - 1);
//        Bundle args = new Bundle();
        Calendar cal = Calendar.getInstance();
//        args.putInt(Calendar.MONTH, cal.get(Calendar.MONTH) + 1);
//        args.putInt(CaldroidFragment.YEAR, cal.get(Calendar.YEAR));
//        args.putBoolean(CaldroidFragment.ENABLE_SWIPE, true);
//

        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 26);
        Date date = cal.getTime();
//        ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.blue));
//        calendarView.setBackgroundDrawableForDate(blue, date);
//        caldroidFragment.setTextColorForDate(R.color.white, date);
//        setCustomResourceForDates(date1);

        calendarView.setFirstDayOfWeek(Calendar.MONDAY)
                .setOnDateClickListener(this::onDateClick)
                .setOnMonthChangeListener(this::onMonthChange)
                .setOnDateLongClickListener(this::onDateLongClick)
                .setOnMonthTitleClickListener(this::onMonthTitleClick)
                .setDisabledDate(cal.getTime());

        if (calendarView.isMultiSelectDayEnabled()) {
            calendarView.setOnMultipleDaySelectedListener((month, dates) -> {
                //Do something with your current selection
            });
        }

        calendarView.update(Calendar.getInstance(Locale.getDefault()));
    }


    @Override
    public void animateViews() {
        calendarView.shouldAnimateOnEnter(true);
//        animate(fab, getApplicationContext());
//        animate(textView, getApplicationContext());
    }

    private void onDateLongClick(@NonNull final Date date) {
//        textView.setText(formatDate(DATE_TEMPLATE, date));
    }

    private void onDateClick(@NonNull final Date date) {
//        textView.setText(formatDate(DATE_TEMPLATE, date));
    }

    private void onMonthTitleClick(@NonNull final Date date) {
        //Do something after month selection
    }

    private void onMonthChange(@NonNull final Date date) {
        final ActionBar actionBar = getSupportActionBar();

        if (null != actionBar) {
            String dateStr = formatDate(MONTH_TEMPLATE, date);
            dateStr = dateStr.substring(0, 1).toUpperCase() + dateStr.substring(1, dateStr.length());

            actionBar.setTitle(dateStr);
        }
    }

    private String formatDate(@NonNull String dateTemplate, @NonNull Date date) {
        return new SimpleDateFormat(dateTemplate, Locale.getDefault()).format(date);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
