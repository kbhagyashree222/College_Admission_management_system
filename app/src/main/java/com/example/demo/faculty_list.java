package com.example.demo;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
 * Use the {@link faculty_list#newInstance} factory method to
 * create an instance of this fragment.
 */
public class faculty_list extends Fragment {
    TextView txt1,txt2;
    Button btn1;
    ListView list;
    private clerk ck;
    List<String> namelist=new ArrayList<>();
    ArrayList<Boolean> isBlockedList = new ArrayList<>();

    public faculty_list() {
        // Required empty public constructor
    }


    public static faculty_list newInstance(String param1, String param2) {
        faculty_list fragment = new faculty_list();
        Bundle args = new Bundle();

        fragment.setArguments(args);
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
        View view= inflater.inflate(R.layout.fragment_faculty_list, container, false);
        btn1=view.findViewById(R.id.btn1);
        list=view.findViewById(R.id.list);
        btn1.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v) {
                FirebaseFirestore.getInstance().collection("Teachers Details").addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        namelist.clear();
                        for (DocumentSnapshot s:value){
                            namelist.add(s.getString("name" ) + "      Stream"+ s.getString("stream")+"     Designation"+s.getString("designation")
                            +"      Education "+s.getString("education")+"      About"+s.getString("about"));
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