package com.example.baikiemtralan2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class add extends AppCompatActivity {

    EditText tenkhoahoc, tenthuonggoi, dactinh, congdung, url;
    Button btn_save, btn_back;
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        connectID();

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Map<String , Object > add = new HashMap<>();
//                add.put("tenkhoahoc",tenkhoahoc.getText().toString());
//                add.put("tenkhoahoc",tenkhoahoc.getText().toString());
//                add.put("tenkhoahoc",tenkhoahoc.getText().toString());
//                add.put("tenkhoahoc",tenkhoahoc.getText().toString());
//                add.put("tenkhoahoc",tenkhoahoc.getText().toString());
//
//
//                db.

                insertData();
                ClearAll();
            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void connectID(){
        tenkhoahoc = (EditText) findViewById(R.id.tenkhoahoc_add);
        tenthuonggoi = (EditText) findViewById(R.id.tenthuonggoi_add);
        dactinh = (EditText) findViewById(R.id.dactinh_add);
        congdung = (EditText) findViewById(R.id.congdung_add);
        url = (EditText) findViewById(R.id.url_add);
        btn_back = (Button) findViewById(R.id.btn_Back);
        btn_save = (Button) findViewById(R.id.btn_Add);
    }

    private void insertData(){
        Map<String, Object> map = new HashMap<>();
        map.put("tenkhoahoc", tenkhoahoc.getText().toString());
        map.put("tenthuonggoi", tenthuonggoi.getText().toString());
        map.put("dactinh", dactinh.getText().toString());
        map.put("congdung", congdung.getText().toString());
        map.put("url", url.getText().toString());

        FirebaseDatabase.getInstance().getReference().child("tree").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(add.this, "Data Inserted Successfully.", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(add.this, "Error While Insertion.", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void ClearAll(){
        tenkhoahoc.setText("");
        tenthuonggoi.setText("");
        dactinh.setText("");
        congdung.setText("");
        url.setText("");
    }
}