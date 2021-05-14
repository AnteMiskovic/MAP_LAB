package hr.vsite.map.lab9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Administracija extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administracija);
        TextView v = findViewById(R.id.tUserData);
        v.setText(getIntent().getStringExtra("Users"));
    }
}