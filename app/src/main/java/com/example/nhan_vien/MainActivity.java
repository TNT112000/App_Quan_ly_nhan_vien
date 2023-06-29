package com.example.nhan_vien;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.AdapterView;
import android.widget.Spinner;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText nhap_ten,nhap_id,nhap_ngay_sinh;
    Spinner nhap_gioi_tinh , nhap_phong_ban ,nhap_chuc_vu;
    Button btn_them,btn_sua,btn_xoa;
    ListView list_nv;
    ArrayAdapter<String> arrayAdapter;
    Nhan_vien_DAO nhan_vien_dao;

    Phong_ban_DAO phong_ban_dao;
    Chuc_vu_DAO chuc_vu_dao;
    List<String> list =new ArrayList<>(), dataList= new ArrayList<>() , dataList1=new ArrayList<>();
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nhap_ten = findViewById(R.id.nhap_ten);
        nhap_id = findViewById(R.id.nhap_id);
        nhap_chuc_vu = findViewById(R.id.nhap_chuc_vu);
        nhap_phong_ban = findViewById(R.id.nhap_phong_ban);
        nhap_gioi_tinh = findViewById(R.id.nhap_gioi_tinh);
        nhap_ngay_sinh =findViewById(R.id.nhap_ngay_sinh);
        btn_them = findViewById(R.id.btn_them);
//        btn_xoa=findViewById(R.id.btn_xoa);
//        btn_sua=findViewById(R.id.btn_sua);
        list_nv=findViewById(R.id.list_pb);
        Spinner nhap_gioi_tinh = findViewById(R.id.nhap_gioi_tinh);

// Tạo danh sách dữ liệu cho giới tính
        List<String> genderList = new ArrayList<>();
        genderList.add("Chọn");
        genderList.add("Nam");
        genderList.add("Nữ");

// Tạo ArrayAdapter và liên kết nó với danh sách dữ liệu và layout mặc định
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, genderList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        context=this;
        phong_ban_dao = new Phong_ban_DAO(context);
        dataList = phong_ban_dao.getAllPhong_bansToString();
        ArrayAdapter<String> listphong_ban = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataList);
        listphong_ban.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        nhap_phong_ban.setAdapter(listphong_ban);

        context=this;
        chuc_vu_dao = new Chuc_vu_DAO(context);
        dataList1 = chuc_vu_dao.getAllChuc_vusToString();
        ArrayAdapter<String> listchuc_vu = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataList1);
        listchuc_vu.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        nhap_chuc_vu.setAdapter(listchuc_vu);

// Liên kết ArrayAdapter với Spinner
        nhap_gioi_tinh.setAdapter(adapter);
        context=this;
        list.clear();
        nhan_vien_dao = new Nhan_vien_DAO(context);
        list = nhan_vien_dao.getAllNhan_vienToString();
        arrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1,list);
        list_nv.setAdapter(arrayAdapter);

//        list_nv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                // Lấy dòng được chọn từ ListView
//
//                String selectedItem = (String) list_nv.getItemAtPosition(position);
//
//                // Phân tích chuỗi thành các thành phần dữ liệu
//                String[] itemComponents = selectedItem.split("   ");
//
//                // Lấy dữ liệu từ các thành phần và hiển thị lên EditText
//                String ma_nv = itemComponents[0];
//                String ten = itemComponents[1];
//                String gioi_tinh = itemComponents[2];
//
//                nhap_ten.setText(ten);
//                nhap_id.setText(ma_nv);
//                int spinnervalue  = genderList.indexOf(gioi_tinh);
//                nhap_gioi_tinh.setSelection(spinnervalue);
////                Nhan_vien selectedNhanVien = (Nhan_vien) list_nv.getItemAtPosition(position);
////
////                // Lấy thông tin từ dòng được chọn
////                String ten = selectedNhanVien.getTen();
////                String ngay_sinh =selectedNhanVien.getNgay_sinh();
////                String chuc_vu = selectedNhanVien.getChuc_vu();
////                String ma_nhan_vien =selectedNhanVien.getMa_nhan_vien();
////                String gioi_tinh =selectedNhanVien.getGioi_tinh();
////                String phong_ban =selectedNhanVien.getPhong_ban();
////
////
////                // Hiển thị thông tin lên EditText
////                nhap_ten.setText(ten);
////                nhap_chuc_vu.setText(chuc_vu);
////                nhap_phong_ban.setText(phong_ban);
////                nhap_ngay_sinh.setText(ngay_sinh);
////                nhap_id.setText(ma_nhan_vien);
////                int spinnervalue  = genderList.indexOf(gioi_tinh);
////                nhap_gioi_tinh.setSelection(spinnervalue);
//            }
//
//        });
//        btn_xoa.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                String delete = nhap_id.getText().toString();
//                int kq =nhan_vien_dao.deleteNhan_vien(delete);
//                if (kq == -1) {
//                    Toast.makeText(context, "Xóa thất bại", Toast.LENGTH_SHORT).show();
//                }
//                else {
//                    Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
//                    list.clear();
//                    nhan_vien_dao = new Nhan_vien_DAO(context);
//                    list = nhan_vien_dao.getAllNhan_vienToString();
//                    arrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1,list);
//                    list_nv.setAdapter(arrayAdapter);
//                    nhap_ten.setText("");
//                    nhap_chuc_vu.setSelection(0);
//                    nhap_gioi_tinh.setSelection(0);
//                    nhap_ngay_sinh.setText("");
//                    nhap_id.setText("");
//                    nhap_phong_ban.setSelection(0);
//
//                }
//
//            }
//        });
//        btn_sua.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Nhan_vien s= new Nhan_vien();
//                String ma_nhan_vien= nhap_id.getText().toString();
//                s.setMa_nhan_vien(ma_nhan_vien);
//                String nhap_chuc_vu1 = nhap_chuc_vu.getSelectedItem().toString();
//                String nhap_ten1 = nhap_ten.getText().toString();
//                s.setTen(nhap_ten1);
//                String phong_ban1 = nhap_phong_ban.getSelectedItem().toString();
//                s.setPhong_ban(phong_ban1);
//                s.setChuc_vu(nhap_chuc_vu1);
//                String nhap_ngay_sinh1 = nhap_ngay_sinh.getText().toString();
//                s.setNgay_sinh(nhap_ngay_sinh1);
//                String nhap_gioi_tinh1 = nhap_gioi_tinh.getSelectedItem().toString();
//                s.setGioi_tinh(nhap_gioi_tinh1);
//
////              Kiểm tra xem edittext có rỗng hay không
//
//                if(!(nhap_gioi_tinh1 == "Chọn")  &&  !(nhap_chuc_vu1 == "Chọn")  && !TextUtils.isEmpty(nhap_ten1)
//                        && !TextUtils.isEmpty(ma_nhan_vien) && !TextUtils.isEmpty(nhap_ngay_sinh1) && !(phong_ban1 == "Chọn"))
//                {
//                    int kq = nhan_vien_dao.updateNhan_vien(s);
//                    if (kq == -1) {
//                        Toast.makeText(context, "Sửa thất bại", Toast.LENGTH_SHORT).show();
//                    }
//                    else {
//                        Toast.makeText(context, "Sửa thành công", Toast.LENGTH_SHORT).show();
//                        list.clear();
//                        nhan_vien_dao = new Nhan_vien_DAO(context);
//                        list = nhan_vien_dao.getAllNhan_vienToString();
//                        arrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1,list);
//                        list_nv.setAdapter(arrayAdapter);
//                        nhap_ten.setText("");
//                        nhap_chuc_vu.setSelection(0);
//                        nhap_gioi_tinh.setSelection(0);
//                        nhap_ngay_sinh.setText("");
//                        nhap_id.setText("");
//                        nhap_phong_ban.setSelection(0);
//
//                    }
//                }
//
//                else {
//                    Toast.makeText(context, "Hãy nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

        btn_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Nhan_vien s= new Nhan_vien();
                String ma_nhan_vien= nhap_id.getText().toString();
                s.setMa_nhan_vien(ma_nhan_vien);
                String nhap_chuc_vu1 = nhap_chuc_vu.getSelectedItem().toString();
                String nhap_ten1 = nhap_ten.getText().toString();
                s.setTen(nhap_ten1);
                String phong_ban1 = nhap_phong_ban.getSelectedItem().toString();
                s.setPhong_ban(phong_ban1);
                s.setChuc_vu(nhap_chuc_vu1);
                String nhap_ngay_sinh1 = nhap_ngay_sinh.getText().toString();
                s.setNgay_sinh(nhap_ngay_sinh1);
                String nhap_gioi_tinh1 = nhap_gioi_tinh.getSelectedItem().toString();
                s.setGioi_tinh(nhap_gioi_tinh1);

//              Kiểm tra xem edittext có rỗng hay không

                if(!(nhap_gioi_tinh1 == "Chọn")  &&  !(nhap_chuc_vu1 == "Chọn")  && !TextUtils.isEmpty(nhap_ten1)
                && !TextUtils.isEmpty(ma_nhan_vien) && !TextUtils.isEmpty(nhap_ngay_sinh1) && !(phong_ban1 == "Chọn"))
                {
                    int kq = nhan_vien_dao.insertNhan_vien(s);
                    if (kq == -1) {
                        Toast.makeText(context, "Thêm thất bại", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(context, "Thêm thành công", Toast.LENGTH_SHORT).show();
                        list.clear();
                        nhan_vien_dao = new Nhan_vien_DAO(context);
                        list = nhan_vien_dao.getAllNhan_vienToString();
                        arrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1,list);
                        list_nv.setAdapter(arrayAdapter);
                        nhap_ten.setText("");
                        nhap_chuc_vu.setSelection(0);
                        nhap_gioi_tinh.setSelection(0);
                        nhap_ngay_sinh.setText("");
                        nhap_id.setText("");
                        nhap_phong_ban.setSelection(0);

                    }
                }

                else {
                    Toast.makeText(context, "Hãy nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                    }
            }
        });

    }
}