package hr.vsite.map.lab9;

import android.provider.BaseColumns;

public class DbLab9Contract {

    private DbLab9Contract(){}
    public final static String DATABASE_NAME = "LAB9.db";

    public static abstract class User implements BaseColumns {
        public static String TABLE_NAME   = "Users";
        public static String COLUMN_NAME   = "Name";
        public static String COLUMN_EMAIL   = "Email";
        public static String COLUMN_PASSWORD   = "Password";

        public static String CREATE_TABLE_SCRIPT =
                " CREATE TABLE " + TABLE_NAME + " ( " +
                        _ID + " INTEGER PRIMARY KEY,"  +
                        COLUMN_NAME + " TEXT NOT NULL, " +
                        COLUMN_EMAIL + " TEXT NOT NULL, " +
                        COLUMN_PASSWORD + " TEXT NOT NULL " +
                        ")";
    }
}
