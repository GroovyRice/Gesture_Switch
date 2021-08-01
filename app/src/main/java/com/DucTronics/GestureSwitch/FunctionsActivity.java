package com.DucTronics.GestureSwitch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Arrays;

public class FunctionsActivity extends AppCompatActivity {

    Gestures MainGestures = new Gestures();
    Spinner SwipeUp;
    Spinner SwipeDown;
    Spinner SwipeLeft;
    Spinner SwipeRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_functions);
        retrieveData();
        SwipeUp = (Spinner) findViewById(R.id.SwipeUpSpinner);
        SwipeDown = (Spinner) findViewById(R.id.SwipeDownSpinner);
        SwipeLeft = (Spinner) findViewById(R.id.SwipeLeftSpinner);
        SwipeRight = (Spinner) findViewById(R.id.SwipeRightSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.lights, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SwipeUp.setAdapter(adapter);
        SwipeDown.setAdapter(adapter);
        SwipeLeft.setAdapter(adapter);
        SwipeRight.setAdapter(adapter);
        SwipeUp.setOnItemSelectedListener(new SpinnerSwipeUp());
        SwipeDown.setOnItemSelectedListener(new SpinnerSwipeDown());
        SwipeLeft.setOnItemSelectedListener(new SpinnerSwipeLeft());
        SwipeRight.setOnItemSelectedListener(new SpinnerSwipeRight());
    }

    public void addData() {
        DatabaseReference setGestures = FirebaseDatabase.getInstance().getReference();
        setGestures.child("setGestures").setValue(MainGestures);
    }

    public void retrieveData() {
        DatabaseReference setGestures = FirebaseDatabase.getInstance().getReference("/setGestures");
        setGestures.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Gestures readIn = dataSnapshot.getValue(Gestures.class);
                assert readIn != null;
                MainGestures.setSwipeUp(readIn.getSwipeUp());
                MainGestures.setSwipeDown(readIn.getSwipeDown());
                MainGestures.setSwipeLeft(readIn.getSwipeLeft());
                MainGestures.setSwipeRight(readIn.getSwipeRight());
                defaultSpinner(MainGestures.getSwipeUp(),MainGestures.getSwipeDown(),MainGestures.getSwipeLeft(),MainGestures.getSwipeRight());
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println("Failed.");
            }
        });
    }

    public int SwipeNumber(String text) {
        String[] lights = getResources().getStringArray(R.array.lights);
        String[] lightsEq = getResources().getStringArray(R.array.lightsEq);
        for(int i=0;i <= lights.length;i++) {
            if(text.equals(lights[i])) {
                return Integer.parseInt(lightsEq[i]);
            }
        }
        return 0;
    }

    public void defaultSpinner(String Up,String Down,String Left, String Right) {
        String[] lights = getResources().getStringArray(R.array.lights);
        SwipeUp.setSelection(Arrays.asList(lights).indexOf(Up));
        SwipeDown.setSelection(Arrays.asList(lights).indexOf(Down));
        SwipeLeft.setSelection(Arrays.asList(lights).indexOf(Left));
        SwipeRight.setSelection(Arrays.asList(lights).indexOf(Right));
    }
    public void saveButton(View view) {
        addData();
    }

    class SpinnerSwipeUp implements AdapterView.OnItemSelectedListener {
        public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
            String text = parent.getItemAtPosition(position).toString();
            MainGestures.setSwipeUp(text);
            MainGestures.setSwipeUpNum(SwipeNumber(text));
        }
        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }

    class SpinnerSwipeDown implements AdapterView.OnItemSelectedListener {
        public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
            String text = parent.getItemAtPosition(position).toString();
            MainGestures.setSwipeDown(text);
            MainGestures.setSwipeDownNum(SwipeNumber(text));
        }
        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }

    class SpinnerSwipeLeft implements AdapterView.OnItemSelectedListener {
        public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
            String text = parent.getItemAtPosition(position).toString();
            MainGestures.setSwipeLeft(text);
            MainGestures.setSwipeLeftNum(SwipeNumber(text));
        }
        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }

    class SpinnerSwipeRight implements AdapterView.OnItemSelectedListener {
        public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
            String text = parent.getItemAtPosition(position).toString();
            MainGestures.setSwipeRight(text);
            MainGestures.setSwipeRightNum(SwipeNumber(text));
        }
        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }
}
