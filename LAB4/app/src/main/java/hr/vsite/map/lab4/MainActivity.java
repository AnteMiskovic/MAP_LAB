package hr.vsite.map.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_TEXT ="hr.vsite.map.lab4.EXTRA_TEXT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openSecondActivity();
            }
        });
    }

    private void openSecondActivity() {
        EditText eTxt = findViewById(R.id.eTxt);
        String txt = eTxt.getText().toString();

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(EXTRA_TEXT,txt);
        startActivity(intent);
    }
}