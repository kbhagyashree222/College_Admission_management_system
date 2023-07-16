package com.example.demo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link student_dashboard#newInstance} factory method to
 * create an instance of this fragment.
 */
public class student_dashboard extends Fragment {
    Button stud_regis,student,faculty_disp,student_disp,notice_disp,about;


    public student_dashboard() {
        // Required empty public constructor
    }


    public static student_dashboard newInstance(String param1, String param2) {
        student_dashboard fragment = new student_dashboard();
        Bundle args = new Bundle();

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
        View view= inflater.inflate(R.layout.fragment_student_dashboard, container, false);
        stud_regis =view.findViewById(R.id.stud_regis);
        student =view.findViewById(R.id.student);
        faculty_disp=view.findViewById(R.id.faculty_disp);
        student_disp=view.findViewById(R.id.student_disp);
        notice_disp=view.findViewById(R.id.notice_disp);
        about=view.findViewById(R.id.about);
        stud_regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment frg = new Student();
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.holder, frg).addToBackStack(null).commit();
            }
        });
        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment frg = new student_doc();
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
        student_disp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment frg = new clerk();
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.holder, frg).addToBackStack(null).commit();
            }
        });
        notice_disp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment frg = new disp_notice();
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.holder, frg).addToBackStack(null).commit();
            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment frg = new about();
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.holder, frg).addToBackStack(null).commit();
            }
        });


        return view;
    }
}