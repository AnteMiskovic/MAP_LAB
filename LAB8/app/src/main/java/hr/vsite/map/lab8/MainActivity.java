package hr.vsite.map.lab8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("animal","");
        editor.putString("bird","");

    }



    public void onSave(View v) throws IOException {
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        String orAnim=sharedPref.getString("animal","");;
        String orBird=sharedPref.getString("bird","");
        EditText e = findViewById(R.id.etxt);
        String anim = e.getText().toString() + "\n";
        EditText e2 = findViewById(R.id.etxt2);
        String bird = e2.getText().toString() + "\n";

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("animal",anim);
        editor.putString("bird",bird);
        editor.commit();

        String msg = "Promijenili ste zivotinju iz " + orAnim + " u" + anim + "\n" +
                ",a pticu iz " + orBird + " u" + bird;
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
        SaveAnimals(new String[]{ anim, bird });

    }

    public void onZapamti(View v){
        try(FileInputStream fis = openFileInput("jaaoj.txt")) {
            StringBuilder builder = new StringBuilder();
            int c;
            while((c = fis.read()) != -1) {
                builder.append((char) c);
            }
            String saved = builder.toString();
            TextView tView = findViewById(R.id.txtView);
            tView.setText(saved);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void SaveAnimals(String[] values) throws IOException{
        StringBuilder builder = new StringBuilder();
        FileOutputStream fos = null;
        for(String s : values){
            builder.append(s + "\n");
        }
        String s = builder.toString();
        try {
            fos = openFileOutput("jaaoj.txt", Context.MODE_APPEND);
            fos.write(s.getBytes());
            Toast.makeText(this, s, Toast.LENGTH_SHORT).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fos.close();
        }
    }
}