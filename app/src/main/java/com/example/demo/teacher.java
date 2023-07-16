package com.example.demo;

import static android.app.Activity.RESULT_OK;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link teacher#newInstance} factory method to
 * create an instance of this fragment.
 */
public class teacher extends Fragment {
    TextView txt1;
    EditText tname,tstream,tdesig,tedu,tabt;
    Button addt;

    public teacher() {
        // Required empty public constructor
    }
    public static teacher newInstance(String param1, String param2) {
        teacher fragment = new teacher();
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
        View view= inflater.inflate(R.layout.fragment_teacher, container, false);
        tname=view.findViewById(R.id.tname);
        tstream=view.findViewById(R.id.tstream);
        tdesig=view.findViewById(R.id.tdesig);
        tedu=view.findViewById(R.id.tedu);
        tabt=view.findViewById(R.id.tabt);
        addt=view.findViewById(R.id.addt);
        addt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String,String> n= new HashMap<>();
                n.put("name",tname.getText().toString());
                n.put("stream", tstream.getText().toString());
                n.put("designation",tdesig.getText().toString());
                n.put("education",tedu.getText().toString());
                n.put("about",tabt.getText().toString());
                FirebaseFirestore.getInstance().collection("Teachers Details").add(n).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
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