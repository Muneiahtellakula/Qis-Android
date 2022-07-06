package com.example.sqltedb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.sqltedb.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
MyOpenHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
helper=new MyOpenHelper(this);
       binding.buttonSave.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String name=binding.editTextTextPersonName.getText().toString();
               String rollNum=binding.editTextNumber.getText().toString();

               ContentValues cn=new ContentValues();
               cn.put(helper.COL_1,name);
               cn.put(helper.COL_2,rollNum);
               //Toast.makeText(getApplicationContext(), ""+rollNum +name, Toast.LENGTH_SHORT).show();
               long rowdata=helper.saveData(cn);
               Toast.makeText(getApplicationContext(),rowdata+" you entered Name :"+ name, Toast.LENGTH_SHORT).show();
           }
       });
       binding.buttonRetrive.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Cursor cursor=helper.retriveData();
               StringBuilder sb=new StringBuilder();
               while (cursor.moveToNext()){
                 //  sb.append(cursor.getInt(0)+"\t");
                   sb.append(cursor.getInt(1)+"\t");
                   sb.append(cursor.getInt(2)+"\n");
               }
               binding.textViewResult.setText(sb);
           }
       });
    }
}