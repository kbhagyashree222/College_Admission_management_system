package com.example.demo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link login#newInstance} factory method to
 * create an instance of this fragment.
 */
public class login extends Fragment {
    TextView txt1;
    EditText email,pass,role;
    Button sub;
    public login() {
        // Required empty public constructor
    }

    public static login newInstance(String param1, String param2) {
        login fragment = new login();
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
        View view= inflater.inflate(R.layout.fragment_login, container, false);
        email = view.findViewById(R.id.email);
        pass =view.findViewById(R.id.pass);
        role =view.findViewById(R.id.role);
        sub =view.findViewById(R.id.sub);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseFirestore.getInstance().collection("Saish").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for (QueryDocumentSnapshot doc:task.getResult()){
                                String a= doc.getString("email");
                                String b= doc.getString("pass");
                                String c=doc.getString("role");
                                String a1=email.getText().toString().trim();
                                String b1=pass.getText().toString().trim();
                                String c1=role.getText().toString().trim();
                                if(a.equalsIgnoreCase(a1) & b.equalsIgnoreCase(b1)) {
                                    if(role.getText().toString().equals("student")){

                                        Toast.makeText(getContext(), "student logged in", Toast.LENGTH_SHORT).show();
                                        Fragment frg = new student_dashboard();
                                        FragmentManager fm = getActivity().getSupportFragmentManager();
                                        FragmentTransaction ft = fm.beginTransaction();
                                        ft.replace(R.id.holder, frg).addToBackStack(null).commit();
                                        Toast.makeText(getContext(), "Successfully Logged In", Toast.LENGTH_SHORT).show();

                                    }
                                    else if(role.getText().toString().equals("teacher")) {
                                        Fragment frg = new teacher();
                                        FragmentManager fm = getActivity().getSupportFragmentManager();
                                        FragmentTransaction ft = fm.beginTransaction();
                                        ft.replace(R.id.holder, frg).addToBackStack(null).commit();
                                        Toast.makeText(getContext(), "Teacher Successfully Logged In", Toast.LENGTH_SHORT).show();

                                    }

                                    else if(role.getText().toString().equals("clerk")) {
                                        Fragment frg = new clerks_dashboard();
                                        FragmentManager fm = getActivity().getSupportFragmentManager();
                                        FragmentTransaction ft = fm.beginTransaction();
                                        ft.replace(R.id.holder, frg).addToBackStack(null).commit();
                                        Toast.makeText(getContext(), "Clerk Successfully Logged In", Toast.LENGTH_SHORT).show();
                                        break;

                                    } else {
                                        Toast.makeText(getContext(), "Unsuccessful", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        }
                    }
                });

            }
        });


        return view;
    }
}