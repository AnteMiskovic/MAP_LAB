package hr.vsite.map.lab9;
import hr.vsite.map.lab9.DbLab9Contract.User;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name, email, password;
    Button btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.etName);
        email = findViewById(R.id.etEmail);
        password = findViewById(R.id.etPassword);
        btnRegister = findViewById(R.id.btnRegister);
    }

    public void onRegister(View v){
        DbLab9Helper helper = new DbLab9Helper(this);
        if(v.getId() == R.id.btnRegister){
            try {
                SQLiteDatabase db = helper.getWritableDatabase();

                String txtName = name.getText().toString(),
                        txtEmail = email.getText().toString(),
                        txtPassword = password.getText().toString();

                ContentValues cv = new ContentValues();
                cv.put(User.COLUMN_NAME, txtName);
                cv.put(User.COLUMN_EMAIL, txtEmail);
                cv.put(User.COLUMN_PASSWORD, txtPassword);

                long id = db.insert(User.TABLE_NAME, null, cv);
                String msg = id == -1 ? "Failed to write" : "Success.";
                Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
            } catch(SQLException ex){
                ex.printStackTrace();
                Toast.makeText(this,ex.getMessage(),Toast.LENGTH_LONG).show();
            }
        }
    }





}