package hr.vsite.map.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSecond();
            }
        });
    }

    private void startSecond() {
        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);
    }

    public void changeText(View v) {
        TextView tv = findViewById(R.id.fragView);
        tv.setText("Promijenjeno!");
    }
}