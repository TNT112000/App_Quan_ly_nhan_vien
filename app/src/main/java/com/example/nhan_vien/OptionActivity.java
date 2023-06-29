package com.example.nhan_vien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);

        Button phong_ban =findViewById(R.id.btn_phong_ban);
        phong_ban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OptionActivity.this, Phong_banActivity.class);
                startActivity(intent);
            }
        });
        Button chuc_vu =findViewById(R.id.btn_chuc_vu);
        chuc_vu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OptionActivity.this, Chuc_vuActivity.class);
                startActivity(intent);
            }
        });
        Button chi_tiet =findViewById(R.id.btn_chi_tiet);
        chi_tiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OptionActivity.this, Chi_tietActivity.class);
                startActivity(intent);
            }
        });
        Button nextButton = findViewById(R.id.btn_quan_ly);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OptionActivity.this, MainActivity.class);
                startActivity(intent);
            }

        });

    }

}