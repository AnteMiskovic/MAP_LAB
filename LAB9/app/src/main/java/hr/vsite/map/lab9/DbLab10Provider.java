package hr.vsite.map.lab9;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import hr.vsite.map.lab9.DbLab9Contract.User;

public class DbLab10Provider extends ContentProvider {
    public static final String AUTHORITY = "hr.vsite.map.lab9";
    public static final String PATH = User.TABLE_NAME;
    private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    static {
        uriMatcher.addURI(AUTHORITY, PATH, 1);
    }
    public DbLab10Provider(){}

    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        if( uriMatcher.match(uri) == 1 ) {
            DbLab9Helper helper = new DbLab9Helper(getContext());
            try{
                SQLiteDatabase db = helper.getReadableDatabase();
                Cursor c = db.query(User.TABLE_NAME, projection, null, null, null, null, null);
                return c;
            } catch (SQLException ex){
                ex.printStackTrace();
            }
        } else if (uriMatcher.match(uri) == UriMatcher.NO_MATCH){
            throw new IllegalArgumentException("Kriva tablica!");
        }
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        if( uriMatcher.match(uri) == 1 ) {
            DbLab9Helper helper = new DbLab9Helper(getContext());
            try (SQLiteDatabase db = helper.getWritableDatabase()){
                long id = db.insert(User.TABLE_NAME, null, values);
                return ContentUris.withAppendedId(uri, id);
            } catch (SQLException ex){
                ex.printStackTrace();
            }
        }

        return Uri.EMPTY;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
