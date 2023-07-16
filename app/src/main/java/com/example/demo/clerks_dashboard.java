package com.example.demo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class clerks_dashboard extends Fragment {
Button faculty,student,notice,faculty_disp,student_disp,notice_disp;

    public clerks_dashboard() {
        // Required empty public constructor
    }

    public static clerks_dashboard newInstance(String param1, String param2) {
        clerks_dashboard fragment = new clerks_dashboard();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_clerks_dashboard, container, false);
        faculty = view.findViewById(R.id.faculty);
        student =view.findViewById(R.id.student);
        notice =view.findViewById(R.id.notice);
        faculty_disp =view.findViewById(R.id.faculty_disp);
        student_disp =view.findViewById(R.id.student_disp);
        notice_disp =view.findViewById(R.id.notice_disp);
        notice_disp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment frg = new disp_notice();
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.holder, frg).addToBackStack(null).commit();

            }
        });
        faculty_disp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment frg = new faculty_list();
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.holder, frg).addToBackStack(null).commit();
            }
        });
        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment frg = new Student();
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.holder, frg).addToBackStack(null).commit();
            }
        });
        student_disp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment frg = new clerk();
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.holder, frg).addToBackStack(null).commit();
            }
        });

        notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment frg = new notice();
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.holder, frg).addToBackStack(null).commit();

            }
        });
        faculty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment frg = new teacher();
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.holder, frg).addToBackStack(null).commit();
            }
        });


        return view;
    }
}