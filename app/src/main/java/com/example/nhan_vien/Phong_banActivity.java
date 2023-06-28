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

public class Phong_banActivity extends AppCompatActivity {
    EditText nhap_phong_ban,nhap_truong_phong;
    Button btn_them,btn_sua,btn_xoa;
    ListView list_pb;

    ArrayAdapter<String> arrayAdapter;

    Phong_ban_DAO phong_ban_DAO;
    List<String> list =new ArrayList<>();
    Context context;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phong_ban);

        nhap_truong_phong = findViewById(R.id.nhap_ten);
        nhap_phong_ban = findViewById(R.id.nhap_phong_ban);
        btn_them = findViewById(R.id.btn_them);
        btn_xoa = findViewById(R.id.btn_xoa);
        btn_sua = findViewById(R.id.btn_sua);

        list_pb = findViewById(R.id.list_pb);

        context=this;
        list.clear();
        phong_ban_DAO = new Phong_ban_DAO(context);
        list = phong_ban_DAO.getAllPhong_banToString();
        arrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1,list);
        list_pb.setAdapter(arrayAdapter);

        list_pb.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Lấy dòng được chọn từ ListView
                String selectedItem = (String) list_pb.getItemAtPosition(position);

                // Phân tích chuỗi thành các thành phần dữ liệu
                String[] itemComponents = selectedItem.split("   ");

                // Lấy dữ liệu từ các thành phần và hiển thị lên EditText
                String phong_ban = itemComponents[0];
                String truong_phong = itemComponents[1];


                nhap_phong_ban.setText(phong_ban);
                nhap_truong_phong.setText(truong_phong);

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
//                nhap_phong_ban.setText(phong_ban);
//                nhap_ngay_sinh.setText(ngay_sinh);
//                nhap_id.setText(ma_nhan_vien);
//                int spinnervalue  = genderList.indexOf(gioi_tinh);
//                nhap_gioi_tinh.setSelection(spinnervalue);
            }

        });
        btn_xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tnt = nhap_phong_ban.getText().toString();
                int kq =phong_ban_DAO.deletePhong_ban(tnt);
                if (kq == -1) {
                    Toast.makeText(context, "Xóa thất bại", Toast.LENGTH_SHORT).show();
                } if (kq == 1){
                    Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
                    nhap_truong_phong.setText("");
                    nhap_phong_ban.setText("");


                    list.clear();
                    phong_ban_DAO = new Phong_ban_DAO(context);
                    list = phong_ban_DAO.getAllPhong_banToString();
                    arrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, list);
                    list_pb.setAdapter(arrayAdapter);
                }
            }
        });

        btn_sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Phong_ban s= new Phong_ban();
                String phong_ban1= nhap_phong_ban.getText().toString();
                s.setPhong_ban(phong_ban1);
                String truong_phong1 = nhap_truong_phong.getText().toString();
                s.setTruong_phong(truong_phong1);

                if(!TextUtils.isEmpty(phong_ban1)  && !TextUtils.isEmpty(truong_phong1)) {
                    int kq = phong_ban_DAO.updatePhong_ban(s);
                    if (kq == -1) {
                        Toast.makeText(context, "Sửa thất bại", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context, "Sửa thành công", Toast.LENGTH_SHORT).show();

                        nhap_truong_phong.setText("");
                        nhap_phong_ban.setText("");


                        list.clear();
                        phong_ban_DAO = new Phong_ban_DAO(context);
                        list = phong_ban_DAO.getAllPhong_banToString();
                        arrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, list);
                        list_pb.setAdapter(arrayAdapter);
                    }
                }
                else {
                    Toast.makeText(context, "Hãy nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Phong_ban s= new Phong_ban();



                String phong_ban1= nhap_phong_ban.getText().toString();
                s.setPhong_ban(phong_ban1);
                String truong_phong1 = nhap_truong_phong.getText().toString();
                s.setTruong_phong(truong_phong1);

                if(!TextUtils.isEmpty(phong_ban1)  && !TextUtils.isEmpty(truong_phong1)) {
                    int kq = phong_ban_DAO.insertPhong_ban(s);
                    if (kq == -1) {
                        Toast.makeText(context, "Thêm thất bại", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context, "Thêm thành công", Toast.LENGTH_SHORT).show();

                        nhap_truong_phong.setText("");
                        nhap_phong_ban.setText("");


                        list.clear();
                        phong_ban_DAO = new Phong_ban_DAO(context);
                        list = phong_ban_DAO.getAllPhong_banToString();
                        arrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, list);
                        list_pb.setAdapter(arrayAdapter);
                    }
                }
                else {
                    Toast.makeText(context, "Hãy nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}