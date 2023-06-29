package com.example.nhan_vien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Chuc_vuActivity extends AppCompatActivity {
    EditText nhap_ma,nhap_chuc_vu;
    Button btn_them,btn_sua,btn_xoa;
    ListView list_pb;

    ArrayAdapter<String> arrayAdapter;

    Chuc_vu_DAO chuc_vu_dao;
    List<String> list =new ArrayList<>();
    Context context;

    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chuc_vu);
        nhap_chuc_vu = findViewById(R.id.nhap_chuc_vu);
        nhap_ma = findViewById(R.id.nhap_id);
        btn_them = findViewById(R.id.btn_them);
        btn_xoa = findViewById(R.id.btn_xoa);
        btn_sua = findViewById(R.id.btn_sua);

        list_pb = findViewById(R.id.list_pb);

        context=this;
        list.clear();
        chuc_vu_dao = new Chuc_vu_DAO(context);
        list = chuc_vu_dao.getAllChuc_vuToString();
        arrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1,list);
        list_pb.setAdapter(arrayAdapter);

        list_pb.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Lấy dòng được chọn từ ListView
                String selectedItem = (String) list_pb.getItemAtPosition(position);

                // Phân tích chuỗi thành các thành phần dữ liệu
                String[] itemComponents = selectedItem.split("   ");

                // Lấy dữ liệu từ các thành phần và hiển thị lên EditText
                String ma_chuc_vu = itemComponents[0];
                String chuc_vu = itemComponents[1];


                nhap_ma.setText(ma_chuc_vu);
                nhap_chuc_vu.setText(chuc_vu);

//                Nhan_vien selectedNhanVien = (Nhan_vien) list_nv.getItemAtPosition(position);
//
//                // Lấy thông tin từ dòng được chọn
//                String ten = selectedNhanVien.getTen();
//                String ngay_sinh =selectedNhanVien.getNgay_sinh();
//                String chuc_vu = selectedNhanVien.getChuc_vu();
//                String ma_nhan_vien =selectedNhanVien.getMa_nhan_vien();
//                String gioi_tinh =selectedNhanVien.getGioi_tinh();
//                String phong_ban =selectedNhanVien.getPhong_ban();
//
//
//                // Hiển thị thông tin lên EditText
//                nhap_ten.setText(ten);
//                nhap_chuc_vu.setText(chuc_vu);
//                nhap_ma.setText(phong_ban);
//                nhap_ngay_sinh.setText(ngay_sinh);
//                nhap_id.setText(ma_nhan_vien);
//                int spinnervalue  = genderList.indexOf(gioi_tinh);
//                nhap_gioi_tinh.setSelection(spinnervalue);
            }

        });
        btn_xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ma_chuc_vu = nhap_ma.getText().toString();
                int kq = chuc_vu_dao.deleteChuc_vu(ma_chuc_vu);
                if (kq == -1) {
                    Toast.makeText(context, "Xóa thất bại", Toast.LENGTH_SHORT).show();
                } if (kq == 1){
                    Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
                    nhap_chuc_vu.setText("");
                    nhap_ma.setText("");


                    list.clear();
                    chuc_vu_dao = new Chuc_vu_DAO(context);
                    list = chuc_vu_dao.getAllChuc_vuToString();
                    arrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, list);
                    list_pb.setAdapter(arrayAdapter);
                }


            }
        });
        btn_sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Chuc_vu s= new Chuc_vu();
                String nhap_ma1= nhap_ma.getText().toString();
                s.setMa_chuc_vu(nhap_ma1);
                String nhap_chuc_vu1 = nhap_chuc_vu.getText().toString();
                s.setChuc_vu(nhap_chuc_vu1);

                if(!TextUtils.isEmpty(nhap_ma1)  && !TextUtils.isEmpty(nhap_chuc_vu1)){

                    int kq = chuc_vu_dao.updateChuc_vu(s);
                    if (kq == -1) {
                        Toast.makeText(context, "Thêm thất bại", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context, "Thêm thành công", Toast.LENGTH_SHORT).show();

                        nhap_chuc_vu.setText("");
                        nhap_ma.setText("");


                        list.clear();
                        chuc_vu_dao = new Chuc_vu_DAO(context);
                        list = chuc_vu_dao.getAllChuc_vuToString();
                        arrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, list);
                        list_pb.setAdapter(arrayAdapter);
                    }
                }

                else {
                    Toast.makeText(context, "Hãy nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Chuc_vu s= new Chuc_vu();
                String nhap_ma1= nhap_ma.getText().toString();
                s.setMa_chuc_vu(nhap_ma1);
                String nhap_chuc_vu1 = nhap_chuc_vu.getText().toString();
                s.setChuc_vu(nhap_chuc_vu1);

                if(!TextUtils.isEmpty(nhap_ma1)  && !TextUtils.isEmpty(nhap_chuc_vu1)){

                    int kq = chuc_vu_dao.insertChuc_vu(s);
                    if (kq == -1) {
                        Toast.makeText(context, "Thêm thất bại", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context, "Thêm thành công", Toast.LENGTH_SHORT).show();

                        nhap_chuc_vu.setText("");
                        nhap_ma.setText("");


                        list.clear();
                        chuc_vu_dao = new Chuc_vu_DAO(context);
                        list = chuc_vu_dao.getAllChuc_vuToString();
                        arrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, list);
                        list_pb.setAdapter(arrayAdapter);
                    }
                }

                else {
                    Toast.makeText(context, "Hãy nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                }
            }
        });
    
    }
}