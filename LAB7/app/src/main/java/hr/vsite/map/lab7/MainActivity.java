package hr.vsite.map.lab7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button  = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(),"time picker");
            }
        });

    }
    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        TextView txtV = findViewById(R.id.txtView);
        txtV.setText("Sad je: " + hourOfDay + ":" + minute +" sati!");
    }
}