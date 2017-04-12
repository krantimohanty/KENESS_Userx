package com.kenresource.keness.user.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.kenresource.keness.user.MyApproval;
import com.kenresource.keness.user.MyLeave;
import com.kenresource.keness.user.MyPay;
import com.kenresource.keness.user.MyTime;
import com.kenresource.keness.user.R;

public class ESSFragment extends Fragment {
public  LinearLayout approval, leave, time, pay;

    public ESSFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_es, container, false);

        approval =(LinearLayout)view.findViewById(R.id.approval);
        approval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), MyApproval.class));
            }
        });
        leave =(LinearLayout)view.findViewById(R.id.leave);
        leave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), MyLeave.class));
            }
        });
        time =(LinearLayout)view.findViewById(R.id.time);
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), MyTime.class));
            }
        });
        pay =(LinearLayout)view.findViewById(R.id.pay);
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), MyPay.class));
            }
        });



        return  view;
    }

}
