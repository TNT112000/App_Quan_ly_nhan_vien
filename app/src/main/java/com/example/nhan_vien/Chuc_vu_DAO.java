package com.example.nhan_vien;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public class Chuc_vu_DAO {
    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;
    private Context context;

    public  Chuc_vu_DAO(Context context){
        this.context =context;
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }
    public  int insertChuc_vu(Chuc_vu s)
    {
        ContentValues values = new ContentValues();

        values.put("ma_chuc_vu",s.getMa_chuc_vu());
        values.put("chuc_vu",s.getChuc_vu());


        long kq = db.insert("Chuc_vu",null,values);
        if(kq<=0){
            return -1;
        }
        return 1;
    }

    public  int deleteChuc_vu(String ma_chuc_vu){
        int kq =db.delete("Chuc_vu", "ma_chuc_vu=?",new String[]{ma_chuc_vu});
        if(kq<=0){
            return -1;
        }
        return 1;
    }

    public  int updateChuc_vu(Chuc_vu s)
    {
        ContentValues values = new ContentValues();

        values.put("ma_chuc_vu",s.getMa_chuc_vu());
        values.put("chuc_vu",s.getChuc_vu());


        long kq = db.update("Chuc_vu",values,"ma_chuc_vu=?",new String[]{s.getMa_chuc_vu()});

        if(kq<=0){
            return -1;
        }
        return 1;
    }

    public List<String> getAllChuc_vuToString(){
        List<String> list =new ArrayList<>();
        Cursor d = db.query("Chuc_vu",null ,null ,null ,null ,null ,"rowid DESC");
        d.moveToFirst();
        while (d.isAfterLast() == false)
        {
            Chuc_vu s = new Chuc_vu();
            s.setMa_chuc_vu(d.getString(0));
            s.setChuc_vu(d.getString(1));


            String data = s.getMa_chuc_vu()+"   " +
                    s.getChuc_vu() ;
            list.add(data);
            d.moveToNext();
        }
        d.close();
        return list;
    }
    public List<String> getAllChuc_vusToString(){
        List<String> dataList1 = new ArrayList<>();
        dataList1.add("Chọn");
        Cursor d = db.query("Chuc_vu",null ,null ,null ,null ,null ,"rowid DESC");
        d.moveToFirst();
        while (d.isAfterLast() == false)
        {
            Chuc_vu s = new Chuc_vu();
            s.setMa_chuc_vu(d.getString(0));
            s.setChuc_vu(d.getString(1));

            String chucvu = s.getChuc_vu();

            dataList1.add(chucvu);

            d.moveToNext();
        }
        d.close();
        return dataList1;
    }
}
