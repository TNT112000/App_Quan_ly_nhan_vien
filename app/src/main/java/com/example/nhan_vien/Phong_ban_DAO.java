package com.example.nhan_vien;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Phong_ban_DAO {
    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;
    private Context context;

    public  Phong_ban_DAO(Context context){
        this.context =context;
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }
    public  int insertPhong_ban(Phong_ban s)
    {
        ContentValues values = new ContentValues();

        values.put("phong_ban",s.getPhong_ban());
        values.put("truong_phong",s.getTruong_phong());


        long kq = db.insert("Phong_ban",null,values);
        if(kq<=0){
            return -1;
        }
        return 1;
    }

    public  int deletePhong_ban(String phong_ban){
        int kq =db.delete("Phong_ban", "phong_ban=?",new String[]{phong_ban});
        if(kq<=0){
            return -1;
        }
        return 1;
    }

    public  int updatePhong_ban(Phong_ban s)
    {
        ContentValues values = new ContentValues();

        values.put("phong_ban",s.getPhong_ban());
        values.put("truong_phong",s.getTruong_phong());


        long kq = db.update("Phong_ban",values,"phong_ban=?",new String[]{s.getPhong_ban()});

        if(kq<=0){
            return -1;
        }
        return 1;
    }






    public List<String> getAllPhong_banToString(){
        List<String> list =new ArrayList<>();
        Cursor d = db.query("Phong_ban",null ,null ,null ,null ,null ,"rowid DESC");
        d.moveToFirst();
        while (d.isAfterLast() == false)
        {
            Phong_ban s = new Phong_ban();
            s.setPhong_ban(d.getString(0));
            s.setTruong_phong(d.getString(1));


            String data = s.getPhong_ban()+"   "+
                    s.getTruong_phong() ;
            list.add(data);
            d.moveToNext();
        }
        d.close();
        return list;
    }
    public List<String> getAllPhong_bansToString(){
        List<String> dataList = new ArrayList<>();
        dataList.add("Chọn");
        Cursor d = db.query("Phong_ban",null ,null ,null ,null ,null ,"rowid DESC");
        d.moveToFirst();
        while (d.isAfterLast() == false)
        {
            Phong_ban s = new Phong_ban();
            s.setPhong_ban(d.getString(0));
            s.setTruong_phong(d.getString(1));

            String phongban = s.getPhong_ban();

            dataList.add(phongban);

            d.moveToNext();
        }
        d.close();
        return dataList;
    }
}
