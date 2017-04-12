package com.kenresource.keness.user.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kenresource.keness.user.Adapter.ApprovedLeaveAdpater;
import com.kenresource.keness.user.Model.ApprovedLeaveModel;
import com.kenresource.keness.user.R;

import java.util.ArrayList;
import java.util.List;


public class ApprovedLeave extends Fragment {
   public List<ApprovedLeaveModel> list;
    public ApprovedLeave() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_approved_leave, container, false);

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.approved_leave_list);
        recyclerView.setHasFixedSize(true);
        list=new ArrayList<>();
        ApprovedLeaveAdpater adapter = new ApprovedLeaveAdpater(getContext(), list);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(CompanyActivity.this);
        recyclerView.setLayoutManager(mLayoutManager);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mLayoutManager.scrollToPosition(0);
//        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        approvedLeave();
        return rootView;

//
    }
public  void approvedLeave()
{
    ApprovedLeaveModel leave=new ApprovedLeaveModel("01/123", "Casual leave", "01/02/2017", "01" , "29/01/2017" , "30/01/2017");
    list.add(leave);
    leave=new ApprovedLeaveModel("01/124", "Casual leave", "12/10/2016", "01",  "09/10/2016", "10/10/2016");
    list.add(leave);

}

    }





