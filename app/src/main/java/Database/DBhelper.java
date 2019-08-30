package Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBhelper extends SQLiteOpenHelper {
    public  static final String DB_NAME = "userdata.db";
    public DBhelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql_create = "CREATE TABLE " +UserMaster.User.TABLE_NAME+ " ("+
                UserMaster.User._ID+ " INTEGER_PRIMARY_KEY, "+
                UserMaster.User.COLUMN_NAME_USERNAME+" TEXT, "+
                UserMaster.User.COLUMN_NAME_PASSWORD+" TEXT); ";

        db.execSQL(sql_create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public  boolean addUser(String userName,String password){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(UserMaster.User.COLUMN_NAME_USERNAME,userName);
        contentValues.put(UserMaster.User.COLUMN_NAME_PASSWORD,password);

        long result = db.insert(UserMaster.User.TABLE_NAME,null, contentValues);
        if(result > 0){
            //success message
            return  true;
        }else{
            //error message
            return false;
        }
    }

    public List readAllInfo(){
        SQLiteDatabase db=getReadableDatabase();
        String[] projectin={UserMaster.User._ID,UserMaster.User.COLUMN_NAME_USERNAME,UserMaster.User.COLUMN_NAME_PASSWORD};
        String sortOrder =UserMaster.User.COLUMN_NAME_USERNAME+" DESC";
        Cursor values=db.query(UserMaster.User.TABLE_NAME,projectin,null,null,null,null,sortOrder);
        List userNameList = new ArrayList();
        List passwordList = new ArrayList();

        while(values.moveToNext()){
            String userName  = values.getString(values.getColumnIndexOrThrow(UserMaster.User.COLUMN_NAME_USERNAME));
            String password = values.getColumnName(values.getColumnIndexOrThrow(UserMaster.User.COLUMN_NAME_PASSWORD));

            userNameList.add(userName);
            passwordList.add(password);
        }
        return  userNameList;

    }





}
