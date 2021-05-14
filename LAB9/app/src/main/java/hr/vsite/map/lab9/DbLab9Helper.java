package hr.vsite.map.lab9;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import hr.vsite.map.lab9.DbLab9Contract.User;

public class DbLab9Helper extends SQLiteOpenHelper {
    final static int DATABASE_VERSION = 1;

    public DbLab9Helper(Context context){
        super(context,DbLab9Contract.DATABASE_NAME,null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(User.CREATE_TABLE_SCRIPT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
