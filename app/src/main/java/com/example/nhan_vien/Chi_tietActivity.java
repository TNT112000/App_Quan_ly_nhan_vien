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
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import android.widget.LinearLayout;
import androidx.transition.TransitionManager;
public class Chi_tietActivity extends AppCompatActivity {
    EditText nhap_ten, nhap_id, nhap_ngay_sinh;
    Spinner nhap_gioi_tinh, nhap_phong_ban, nhap_chuc_vu;
    Button btn_thoat, btn_sua, btn_xoa , btn_all , btn_search;
    ListView list_nv,listpb1;
    ArrayAdapter<String> arrayAdapter , arrayAdapter2;
    Nhan_vien_DAO nhan_vien_dao;

    LinearLayout list_search;

    Phong_ban_DAO phong_ban_dao;
    Chuc_vu_DAO chuc_vu_dao;
    List<String> list1 =new ArrayList<>(), list = new ArrayList<>(), dataList = new ArrayList<>(), dataList1 = new ArrayList<>();
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet);

        nhap_ten = findViewById(R.id.nhap_ten);
        nhap_id = findViewById(R.id.nhap_id);
        nhap_chuc_vu = findViewById(R.id.nhap_chuc_vu);
        nhap_phong_ban = findViewById(R.id.nhap_phong_ban);
        nhap_gioi_tinh = findViewById(R.id.nhap_gioi_tinh);
        nhap_ngay_sinh = findViewById(R.id.nhap_ngay_sinh);
        btn_thoat = findViewById(R.id.btn_thoat);
        btn_xoa = findViewById(R.id.btn_xoa);
        btn_sua = findViewById(R.id.btn_sua);
        btn_search = findViewById(R.id.btn_search);
        btn_all = findViewById(R.id.btn_all);
        list_nv = findViewById(R.id.list_pb);
        listpb1 = findViewById(R.id.list_pb1);
        list_search = findViewById(R.id.list_search);
        Spinner nhap_gioi_tinh = findViewById(R.id.nhap_gioi_tinh);

// Tạo danh sách dữ liệu cho giới tính
        List<String> genderList = new ArrayList<>();
        genderList.add("Chọn");
        genderList.add("Nam");
        genderList.add("Nữ");

// Tạo ArrayAdapter và liên kết nó với danh sách dữ liệu và layout mặc định
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, genderList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        nhap_gioi_tinh.setAdapter(adapter);

        context = this;
        phong_ban_dao = new Phong_ban_DAO(context);
        dataList = phong_ban_dao.getAllPhong_bansToString();
        ArrayAdapter<String> listphong_ban = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataList);
        listphong_ban.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        nhap_phong_ban.setAdapter(listphong_ban);

        context = this;
        chuc_vu_dao = new Chuc_vu_DAO(context);
        dataList1 = chuc_vu_dao.getAllChuc_vusToString();
        ArrayAdapter<String> listchuc_vu = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataList1);
        listchuc_vu.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        nhap_chuc_vu.setAdapter(listchuc_vu);

// Liên kết ArrayAdapter với Spinner

        context = this;
        list.clear();
        nhan_vien_dao = new Nhan_vien_DAO(context);
        list = nhan_vien_dao.getAllinNhan_vienToString();
        arrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, list);
        list_nv.setAdapter(arrayAdapter);

        list_nv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                LinearLayout list_detail = findViewById(R.id.list_detail);
                list_detail.setVisibility(View.VISIBLE);
                // Lấy dòng được chọn từ ListView


                String selectedItem = (String) list_nv.getItemAtPosition(position);

                // Phân tích chuỗi thành các thành phần dữ liệu
                String[] itemComponents = selectedItem.split("-");

                // Lấy dữ liệu từ các thành phần và hiển thị lên EditText
                String ma_nv = itemComponents[0];
                String ten = itemComponents[1];
                String gioi_tinh = itemComponents[2];
                String ngay_sinh = itemComponents[3];
                String chuc_vu = itemComponents[4];
                String phong_ban = itemComponents[5];

                nhap_ten.setText(ten);
                nhap_id.setText(ma_nv);
                nhap_ngay_sinh.setText(ngay_sinh);
                int gioi_tinh1 = genderList.indexOf(gioi_tinh);
                nhap_gioi_tinh.setSelection(gioi_tinh1);
                int phong_ban1 = dataList.indexOf(phong_ban);
                nhap_phong_ban.setSelection(phong_ban1);
                int chuc_vu1 = dataList1.indexOf(chuc_vu);
                nhap_chuc_vu.setSelection(chuc_vu1);

            }

        });

        listpb1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                LinearLayout list_detail = findViewById(R.id.list_detail);
                list_detail.setVisibility(View.VISIBLE);
                // Lấy dòng được chọn từ ListView


                String selectedItem = (String) listpb1.getItemAtPosition(position);

                // Phân tích chuỗi thành các thành phần dữ liệu
                String[] itemComponents = selectedItem.split("-");

                // Lấy dữ liệu từ các thành phần và hiển thị lên EditText
                String ma_nv = itemComponents[0];
                String ten = itemComponents[1];
                String gioi_tinh = itemComponents[2];
                String ngay_sinh = itemComponents[3];
                String chuc_vu = itemComponents[4];
                String phong_ban = itemComponents[5];

                nhap_ten.setText(ten);
                nhap_id.setText(ma_nv);
                nhap_ngay_sinh.setText(ngay_sinh);
                int gioi_tinh1 = genderList.indexOf(gioi_tinh);
                nhap_gioi_tinh.setSelection(gioi_tinh1);
                int phong_ban1 = dataList.indexOf(phong_ban);
                nhap_phong_ban.setSelection(phong_ban1);
                int chuc_vu1 = dataList1.indexOf(chuc_vu);
                nhap_chuc_vu.setSelection(chuc_vu1);

            }

        });
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list_nv.setVisibility(View.GONE);



                list_search.setVisibility(View.VISIBLE);

                EditText btn_tim_kiem = findViewById(R.id.nhap_tim_kiem);

                String btn_tim = btn_tim_kiem.getText().toString();

//                listpb1 = findViewById(R.id.list_pb1);
                list1.clear();

                nhan_vien_dao = new Nhan_vien_DAO(context);
                list1 = nhan_vien_dao.getSearchNhan_vienToString(btn_tim);
                arrayAdapter2 = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, list1);

                listpb1.setAdapter(arrayAdapter2);
            }
        });

        btn_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                list_nv.setVisibility(View.VISIBLE);
                list_search.setVisibility(View.GONE);

                list.clear();
                nhan_vien_dao = new Nhan_vien_DAO(context);
                list = nhan_vien_dao.getAllinNhan_vienToString();
                arrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, list);

                list_nv.setAdapter(arrayAdapter);
            }
        });
        btn_thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout list_detail = findViewById(R.id.list_detail);
                list_detail.setVisibility(View.GONE);
            }
        });
        btn_xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String delete = nhap_id.getText().toString();
                int kq = nhan_vien_dao.deleteNhan_vien(delete);
                if (kq == -1) {
                    Toast.makeText(context, "Xóa thất bại", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
                    list.clear();
                    nhan_vien_dao = new Nhan_vien_DAO(context);
                    list = nhan_vien_dao.getAllinNhan_vienToString();
                    arrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, list);
                    list_nv.setAdapter(arrayAdapter);
                    nhap_ten.setText("");
                    nhap_chuc_vu.setSelection(0);
                    nhap_gioi_tinh.setSelection(0);
                    nhap_ngay_sinh.setText("");
                    nhap_id.setText("");
                    nhap_phong_ban.setSelection(0);

                }

            }
        });

        btn_sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Nhan_vien s = new Nhan_vien();
                String ma_nhan_vien = nhap_id.getText().toString();
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

                if (!(nhap_gioi_tinh1 == "Chọn") && !(nhap_chuc_vu1 == "Chọn") && !TextUtils.isEmpty(nhap_ten1)
                        && !TextUtils.isEmpty(ma_nhan_vien) && !TextUtils.isEmpty(nhap_ngay_sinh1) && !(phong_ban1 == "Chọn")) {
                    int kq = nhan_vien_dao.updateNhan_vien(s);
                    if (kq == -1) {
                        Toast.makeText(context, "Sửa thất bại", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context, "Sửa thành công", Toast.LENGTH_SHORT).show();
                        list.clear();
                        nhan_vien_dao = new Nhan_vien_DAO(context);
                        list = nhan_vien_dao.getAllinNhan_vienToString();
                        arrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, list);
                        list_nv.setAdapter(arrayAdapter);
//                        nhap_ten.setText("");
//                        nhap_chuc_vu.setSelection(0);
//                        nhap_gioi_tinh.setSelection(0);
//                        nhap_ngay_sinh.setText("");
//                        nhap_id.setText("");
//                        nhap_phong_ban.setSelection(0);

                    }
                } else {
                    Toast.makeText(context, "Hãy nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
            }
        });

//        btn_thoat.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Nhan_vien s = new Nhan_vien();
//                String ma_nhan_vien = nhap_id.getText().toString();
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
//                if (!(nhap_gioi_tinh1 == "Chọn") && !(nhap_chuc_vu1 == "Chọn") && !TextUtils.isEmpty(nhap_ten1)
//                        && !TextUtils.isEmpty(ma_nhan_vien) && !TextUtils.isEmpty(nhap_ngay_sinh1) && !(phong_ban1 == "Chọn")) {
//                    int kq = nhan_vien_dao.insertNhan_vien(s);
//                    if (kq == -1) {
//                        Toast.makeText(context, "Thêm thất bại", Toast.LENGTH_SHORT).show();
//                    } else {
//                        Toast.makeText(context, "Thêm thành công", Toast.LENGTH_SHORT).show();
//                        list.clear();
//                        nhan_vien_dao = new Nhan_vien_DAO(context);
//                        list = nhan_vien_dao.getAllNhan_vienToString();
//                        arrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, list);
//                        list_nv.setAdapter(arrayAdapter);
//                        nhap_ten.setText("");
//                        nhap_chuc_vu.setSelection(0);
//                        nhap_gioi_tinh.setSelection(0);
//                        nhap_ngay_sinh.setText("");
//                        nhap_id.setText("");
//                        nhap_phong_ban.setSelection(0);
//
//                    }
//                } else {
//                    Toast.makeText(context, "Hãy nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
    }
}