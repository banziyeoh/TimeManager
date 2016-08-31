package nekrolime.timemanage.com.timemanager.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqlHelper extends SQLiteOpenHelper{
    public static final String DATABASE_NAME="Task.db";
    public static final String TABLE_NAME="Task_table";
    public static final String TASK="TASK";
    public static final String ID="ID";
    public SqlHelper(Context context ) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,TASK TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(sqLiteDatabase);

    }
    public boolean insertData(String task){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TASK, task);
        long result = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        if (result == -1)
            return false;
        else
            return true;


    }
    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME,null);
        res.close();
        return res;
    }
    public Cursor gettaskdata(){
        SQLiteDatabase db = this.getReadableDatabase();
        String [] columns  = {TASK};
        Cursor c = db.query(TABLE_NAME,columns,null,null,null,null,null);
        return c;
    }

    //public boolean removeData(String task){
       // SQLiteDatabase d = this.getReadableDatabase();

       // return d.delete(TABLE_NAME,)

    //}
    public Cursor  gettask(String[] args){
        SQLiteDatabase d = this.getReadableDatabase();
        String query = "SELECT " + TASK + " FROM " + TABLE_NAME + " WHERE " + TASK + " =?";
        Cursor c = d.rawQuery(query, args);
        return c;

    }


}
