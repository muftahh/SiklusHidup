package com.hacktivate8.siklushidup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText data1;

    public static final String TAG = "SIKLUS HIDUP ACT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "On Create", Toast.LENGTH_SHORT);
        System.out.println(TAG + " On Create");

        data1 = findViewById(R.id.data);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "On Start", Toast.LENGTH_SHORT);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "On Stop", Toast.LENGTH_SHORT);
        System.out.println(TAG + " On Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "On Destroy", Toast.LENGTH_SHORT);
        System.out.println(TAG + " On Destroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "On Pause", Toast.LENGTH_SHORT);
        System.out.println(TAG + " On Pause");

        SharedPreferences data_new = getSharedPreferences("DataBackup", MODE_PRIVATE);
        SharedPreferences.Editor my_edit = data_new.edit();

        my_edit.putString("Data", data1.getText().toString());
        my_edit.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "On Resume", Toast.LENGTH_SHORT);
        System.out.println(TAG + " On Resume");

        SharedPreferences data_beckup = getSharedPreferences("DataBackup", MODE_PRIVATE);

        String data = data_beckup.getString("Data", "");
        data1.setText(data);
    }

}
