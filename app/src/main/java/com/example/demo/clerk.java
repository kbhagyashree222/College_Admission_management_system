package com.example.demo;

import static com.google.android.material.R.layout.support_simple_spinner_dropdown_item;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link clerk#newInstance} factory method to
 * create an instance of this fragment.
 */
public class clerk extends Fragment {
TextView txt1,txt2;
Button btn1;
ListView list;
private clerk ck;
List<String> namelist=new ArrayList<>();
ArrayList<Boolean> isBlockedList = new ArrayList<>();


    public clerk() {
        // Required empty public constructor
    }


    public static clerk newInstance(String param1, String param2) {
        clerk fragment = new clerk();

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
        View view=inflater.inflate(R.layout.fragment_clerk, container, false);
        btn1=view.findViewById(R.id.btn1);
        list=view.findViewById(R.id.list);
        btn1.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v) {
                FirebaseFirestore.getInstance().collection("Student Details").addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        namelist.clear();
                        for (DocumentSnapshot s:value){
                            namelist.add(s.getString("name" ) + ":"+ s.getString("cet marks"));
                        }
                       ArrayAdapter adapter=new ArrayAdapter<>(getActivity(),R.layout.activity_listview,namelist);
                        adapter.notifyDataSetChanged();
                        list.setAdapter(adapter);

                    }
                });
            }
        });

        return view;
    }
}
