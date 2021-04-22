package com.example.firebasedatabasekhoapham;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    TextView tvTime;
    Button btnTime;
    Button btnReduce;
    Integer count;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference(); //all
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1 : lưu dữ liệu dạng chuỗi
//        myRef
//                .child("Trung tam")
//                .setValue("Khoa Pham karik")
//                .addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        if(task.isSuccessful()){
//                            Toast.makeText(MainActivity.this, "Thanh cong", Toast.LENGTH_SHORT).show();
//                        }
//                        else{
//                            Toast.makeText(MainActivity.this, "That bai", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });

        // 2 : Lưu dữ liệu dạng Object
//        Phuongtien phuongtien = new Phuongtien("Xe dap",2);
//        myRef
//                .child("Phuongtien")
//                .setValue(phuongtien)
//                .addOnCompleteListener(new OnCompleteListener<Void>() {
//            @Override
//            public void onComplete(@NonNull Task<Void> task) {
//                        if(task.isSuccessful()){
//                            Toast.makeText(MainActivity.this, "Thanh cong", Toast.LENGTH_SHORT).show();
//                        }
//                        else{
//                            Toast.makeText(MainActivity.this, "That bai", Toast.LENGTH_SHORT).show();
//                        }
//            }
//        });

        // 3 : Lưu dữ liệu dạng Map
//        HashMap<String, String> hashMap = new HashMap<>();
//        hashMap.put("Khu vuc","Quan 1");
//        myRef.child("Dia diem").setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
//            @Override
//            public void onComplete(@NonNull Task<Void> task) {
//                        if(task.isSuccessful()){
//                            Toast.makeText(MainActivity.this, "Thanh cong", Toast.LENGTH_SHORT).show();
//                        }
//                        else{
//                            Toast.makeText(MainActivity.this, "That bai", Toast.LENGTH_SHORT).show();
//                        }
//            }
//        });

        // 4 : Lưu dữ liệu dạng danh sách
////        ArrayList<Sinhvien> sinhviens = new ArrayList<>();
////        sinhviens.add(new Sinhvien("Nguyen Van A",19));
////        sinhviens.add(new Sinhvien("Nguyen Van B",20));
////        sinhviens.add(new Sinhvien("Nguyen Van C",21));
////        sinhviens.add(new Sinhvien("Nguyen Van D",22));
////        sinhviens.add(new Sinhvien("Nguyen Van E",23));
//
//        myRef.child("Sinhvien")
//                .push()
//                .setValue(new Sinhvien("Nguyen Van C",21))
//                .addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        if(task.isSuccessful()){
//                            Toast.makeText(MainActivity.this, "Thanh cong", Toast.LENGTH_SHORT).show();
//                        }
//                        else{
//                            Toast.makeText(MainActivity.this, "That bai", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });

        // 5 : Đọc dữ liệu dạng string
        myRef.child("Trung tam").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = (String) snapshot.getValue();
                Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this, "that bai", Toast.LENGTH_SHORT).show();
            }
        });

        // 6 : Đọc dữ liệu dạng Object
//        myRef.child("Phuongtien").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                Phuongtien phuongtien = snapshot.getValue(Phuongtien.class);
//                Toast.makeText(MainActivity.this, phuongtien.ten + ", " + phuongtien.sobanh, Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                Toast.makeText(MainActivity.this, "That bai", Toast.LENGTH_SHORT).show();
//            }
//        });

        // 7 : Đọc dạng hash map
//        myRef.child("Dia diem")
//                .addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        HashMap<String, String> hashMap = (HashMap<String, String>) snapshot.getValue();
//                        Log.d("BBB",hashMap.get("Khu vuc"));
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });

        // 8 : Đọc dạng danh sách
//        myRef.child("Sinhvien").addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//                Sinhvien sinhvien = snapshot.getValue(Sinhvien.class);
//                Log.d("BBB", sinhvien.ten + ", " + sinhvien.tuoi);
//            }
//
//            @Override
//            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//                Sinhvien sinhvien = snapshot.getValue(Sinhvien.class);
//                Log.d("BBB", sinhvien.ten + ", " + sinhvien.tuoi);
//            }
//
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });

        tvTime = findViewById(R.id.tvTime);
        btnTime = findViewById(R.id.btnTime);
        btnReduce = findViewById(R.id.btnReduce);

        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child("Time").addValueEventListener(new ValueEventListener() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        Long value = (Long) snapshot.getValue();
                        count = Math.toIntExact(value);
                        tvTime.setText(count + "");
                        Toast.makeText(MainActivity.this, value + "", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(MainActivity.this, "that bai", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });


        btnReduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                count--;



                new CountDownTimer(10000, 1000){
                    @Override
                    public void onTick(long millisUntilFinished) {
                        count--;

                        myRef
                                .child("Time")
                                .setValue(count)
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if(task.isSuccessful()){
                                            Toast.makeText(MainActivity.this, "Thanh cong", Toast.LENGTH_SHORT).show();
                                        }
                                        else{
                                            Toast.makeText(MainActivity.this, "That bai", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                    }

                    @Override
                    public void onFinish() {

                    }
                }.start();
            }
        });




    }
}