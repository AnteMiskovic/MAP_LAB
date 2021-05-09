package hr.vsite.map.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_TEXT ="hr.vsite.map.lab4.EXTRA_TEXT";
    private static final int RESULT_PICK_CONTACT = 12345;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.btn);
        Button btn2 = findViewById(R.id.btn2);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openSecondActivity();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                selectContact();
            }
        });
    }

    private void selectContact() {
        Intent contactPickerIntent = new Intent(Intent.ACTION_PICK,  ContactsContract.Contacts.CONTENT_URI);
        startActivityForResult(contactPickerIntent, RESULT_PICK_CONTACT);
    }
    @Override
    public void onActivityResult(int reqCode, int resultCode, Intent data) {
        super.onActivityResult(reqCode, resultCode, data);
        TextView tv = findViewById(R.id.vTxt2);
        switch (reqCode) {
            case (RESULT_PICK_CONTACT):
                if (resultCode == MainActivity.RESULT_OK)
                    tv.setText("Kontakt je dohvaćen");
                break;
             default:
                 tv.setText("Kontakt nije dohvaćen");
                }
        }


    private void openSecondActivity() {
        EditText eTxt = findViewById(R.id.eTxt);
        String txt = eTxt.getText().toString();
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(EXTRA_TEXT,txt);
        startActivity(intent);
    }
}