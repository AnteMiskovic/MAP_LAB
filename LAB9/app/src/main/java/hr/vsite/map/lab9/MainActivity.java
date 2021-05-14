package hr.vsite.map.lab9;
import hr.vsite.map.lab9.DbLab9Contract.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name, email, password;
    Button btnRegister;
    DbLab9Helper helper = new DbLab9Helper(this);
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.admin:
                Intent intent = new Intent(this, Administracija.class);
                intent.putExtra("Users",writeData());
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private String writeData() {
        SQLiteDatabase db = helper.getReadableDatabase();
        String[] columns = new String[]{ User.COLUMN_NAME,User.COLUMN_EMAIL};
        Cursor cur = db.query(User.TABLE_NAME,columns,null,null,null,null,null);
        StringBuilder sb = new StringBuilder();
        while(cur.moveToNext()){
            sb.append("\n");
            sb.append(cur.getString(cur.getColumnIndex((User.COLUMN_NAME))));
            sb.append(" | ");
            sb.append(cur.getString(cur.getColumnIndex((User.COLUMN_EMAIL))));
        }
        return sb.toString();
    }


}