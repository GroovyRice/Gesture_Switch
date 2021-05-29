package com.DucTronics.GestureSwitch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        retrieveData();
    }

    Motion motion = new Motion();

    public void addData() {
        //Method One
        DatabaseReference latestMotion = FirebaseDatabase.getInstance().getReference();
        latestMotion.child("DetectedMotion").setValue(motion);
    }

    public void retrieveData() {
        DatabaseReference newMotion = FirebaseDatabase.getInstance().getReference("/DetectedMotion");
        //Listens for when data changes within Realtime Database
        newMotion.addValueEventListener(new ValueEventListener() {
            //Creates a "Picture" of the data at the specific reference point.
            //The picture is at a specific point in time.
            @SuppressLint("SetTextI18n")
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Motion readIn = dataSnapshot.getValue(Motion.class);
                assert readIn != null;
                motion.setPreviousMotion(readIn.getPreviousMotion());
                motion.setNewMotion(readIn.getNewMotion());
                changeTextView();
            }
            //When an error occurs getting Data this function will be run.
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println("Failed.");
            }
        });
    }

    public void Up(View view) {
        motion.setPreviousMotion(motion.getNewMotion());
        motion.setNewMotion("Swiped Up");
        addData();
    }

    public void Down(View view) {
        motion.setPreviousMotion(motion.getNewMotion());
        motion.setNewMotion("Swiped Down");
        addData();
    }
    @SuppressLint("SetTextI18n")
    public void changeTextView() {
        //Establish TextViews
        TextView txtMotion = findViewById(R.id.txtMotion);
        TextView txtPrevious = findViewById(R.id.txtPrevious);

        txtMotion.setText("Motion Detected: "+ motion.getNewMotion());
        txtPrevious.setText("Previous Motion: " + motion.getPreviousMotion());
    }
}



