package com.example.menusalertdialogs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    //for create the option menus
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    //for handling the events
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.alert:
                Toast.makeText(getApplicationContext(), "alert menu clicked", Toast.LENGTH_SHORT).show();
                showAlertDialog();
                break;
            case R.id.search:
                Toast.makeText(getApplicationContext(), "Search menu clicked", Toast.LENGTH_SHORT).show();
            break;
            case R.id.settings:
                Toast.makeText(getApplicationContext(), "Settings menu clicked", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showAlertDialog() {
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
                dialog.setTitle("Alert..!");
               dialog.setMessage("Do you want close the app..!");
               dialog.setIcon(R.drawable.ic_baseline_settings_24);
               dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i) {
                     finish();
                   }
               });
               dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i) {
                       dialogInterface.dismiss();
                   }
               });
               dialog.setCancelable(false);
               dialog.show();

    }

}