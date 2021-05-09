package hr.vsite.map.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txtV = findViewById(R.id.vTxt2);
        txtV.setText(getIntent().getStringExtra(MainActivity.EXTRA_TEXT));
    }
}