package com.example.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
TextView tv;
Button t_button,c_button;
int c=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.text_Label);
        t_button=findViewById(R.id.toast_button);
        t_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Count is "+tv.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
//        c_button=findViewById(R.id.count_button);
    }


  /*  public void showToast(View view) {
    }*/

    public void increaseCount(View view) {
        c++;
        tv.setText(String.valueOf(c));
    }
}
/*LifeCycle Activitys*/