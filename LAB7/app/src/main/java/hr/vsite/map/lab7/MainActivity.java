package hr.vsite.map.lab7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.lab7_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.ništa:
                Toast.makeText(this,"Zašto se uopće odabrali ništa?",Toast.LENGTH_LONG).show();
                return true;
            case R.id.drAktivnost:
                Intent intent = new Intent(this, SecondActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}