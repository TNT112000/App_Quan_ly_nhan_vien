package com.example.nhan_vien;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

    public class DatabaseHelper extends SQLiteOpenHelper {

        public static  final  String SQL_Phong_ban="Create table Phong_ban("+
                "phong_ban text PRIMARY KEY ,"+
                "truong_phong text)";

        public static  final  String SQL_Chuc_vu="Create table Chuc_vu("+
                "ma_chuc_vu text PRIMARY KEY ,"+
                "chuc_vu text)";
        public static  final  String SQL_Nhan_vien="Create table Nhan_vien("+

                "ma_nhan_vien text PRIMARY KEY ,"+
                "ten text,"+
                "phong_ban text,"+
                "chuc_vu text,"+
                "ngay_sinh text,"+
                "gioi_tinh text)";

        public void onCreate(SQLiteDatabase db){
//        Tạo bảng dữ liệu
            db.execSQL(SQL_Phong_ban);
            db.execSQL(SQL_Nhan_vien);
            db.execSQL(SQL_Chuc_vu);

        }
        public DatabaseHelper(Context context) {
            super(context, "quan_ly_nhan_vien10.db", null, 1);
        }
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        Xóa bảng cũ tạo bảng mới
            db.execSQL("DROP TABLE IF EXISTS Phong_ban");
            db.execSQL("DROP TABLE IF EXISTS Nhan_vien");
            db.execSQL("DROP TABLE IF EXISTS Chuc_vu");
        }

    }
