package com.example.demo;

import static com.example.demo.R.id.firstn;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Student#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Student extends Fragment {
    TextView txt1;
    EditText firstn,cet,marks,gradclg,gradm,pnr,addre,mobi;
    Button register;

    public Student() {
        // Required empty public constructor
    }


    public static Student newInstance(String param1, String param2) {
        Student fragment = new Student();

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
        View view = inflater.inflate(R.layout.fragment_student, container, false);
        firstn = view.findViewById(R.id.firstn);
        cet = view.findViewById(R.id.cet);
        marks=view.findViewById(R.id.marks);
        gradclg =view.findViewById(R.id.gradclg);
        gradm =view.findViewById(R.id.gradm);
        pnr =view.findViewById(R.id.pnr);
        addre =view.findViewById(R.id.addre);
        mobi =view.findViewById(R.id.mobi);
        register=view.findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String,String> n= new HashMap<>();
                n.put("name",firstn.getText().toString());
                n.put("cet roll no.", cet.getText().toString());
                n.put("cet marks",marks.getText().toString());
                n.put("graduation college",gradclg.getText().toString());
                n.put("graduation marks",gradm.getText().toString());
                n.put("pnr",pnr.getText().toString());
                n.put("address",addre.getText().toString());
                n.put("mobile",mobi.getText().toString());
                FirebaseFirestore.getInstance().collection("Student Details").add(n).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        Toast.makeText(getContext(), "Your Data has been recorded", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });



        return view;
    }
}