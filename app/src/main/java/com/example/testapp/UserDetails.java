package com.example.testapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class UserDetails extends AppCompatActivity {

    private TextView id,emri,mbiemri,email;
    private ImageView avatar;
    private ImageView previous,next;
    int img[] = {R.drawable.id_1,R.drawable.id_2,R.drawable.id_3,R.drawable.id_4,R.drawable.id_5,
            R.drawable.id_6,R.drawable.id_7,R.drawable.id_8,R.drawable.id_9,R.drawable.id_10,R.drawable.id_11,
            R.drawable.id_12};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);


        getSupportActionBar().setHomeButtonEnabled(true);
        id = findViewById(R.id.id);
        emri = findViewById(R.id.emri);
        mbiemri = findViewById(R.id.mbiemri);
        email = findViewById(R.id.email);
        avatar = findViewById(R.id.avatar);
        previous = findViewById(R.id.previous);
        next = findViewById(R.id.next);
        fillDetails(MainActivity.position);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.position = (MainActivity.position - 1)%12;
                if(MainActivity.position < 0 ){
                    MainActivity.position = 11;
                }
                Intent userDetails = new Intent(getApplicationContext(), UserDetails.class);
                startActivity(userDetails);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.position = (MainActivity.position + 1)%12;
                Intent userDetails = new Intent(getApplicationContext(), UserDetails.class);
                startActivity(userDetails);
            }
        });

        }

    private void fillDetails(int position){

        int ajdi = MainActivity.id.get(position) + 1;
        String idS = String.valueOf(ajdi);
        getSupportActionBar().setTitle(MainActivity.first_last.get(position));
        id.setText(idS);
        emri.setText(MainActivity.first_name.get(position));
        mbiemri.setText(MainActivity.last_name.get(position));
        email.setText(MainActivity.email.get(position));
        avatar.setImageResource(img[position]);
    }


}
