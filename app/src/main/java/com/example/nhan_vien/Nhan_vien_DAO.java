package com.example.nhan_vien;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import kotlin.Pair;

public class Nhan_vien_DAO {
    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;
    private Context context;

    public  Nhan_vien_DAO(Context context){
        this.context =context;
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }
    public  int insertNhan_vien(Nhan_vien s)
    {
        ContentValues values = new ContentValues();

        values.put("ma_nhan_vien",s.getMa_nhan_vien());
        values.put("ten",s.getTen());
        values.put("chuc_vu",s.getChuc_vu());
        values.put("phong_ban",s.getPhong_ban());
        values.put("ngay_sinh",s.getNgay_sinh());
        values.put("gioi_tinh",s.getGioi_tinh());

        long kq = db.insert("Nhan_vien",null,values);
        if(kq<=0){
            return -1;
        }
        return 1;
    }

    public List<String> getAllNhan_vienToString(){
        List<String> list =new ArrayList<>();
        Cursor c = db.query("Nhan_vien",null ,null ,null ,null ,null ,"rowid DESC");
        c.moveToFirst();
        while (c.isAfterLast() == false)
        {
            Nhan_vien s = new Nhan_vien();
            s.setMa_nhan_vien(c.getString(0));
            s.setTen(c.getString(1));
            s.setPhong_ban(c.getString(2));
            s.setChuc_vu(c.getString(3));
            s.setNgay_sinh(c.getString(4));
            s.setGioi_tinh(c.getString(5));


            String data = s.getMa_nhan_vien()+"   " +
                          s.getTen() +"   " +
                          s.getGioi_tinh() ;

            list.add(data);
            c.moveToNext();
        }
        c.close();
        return list;
    }

}
