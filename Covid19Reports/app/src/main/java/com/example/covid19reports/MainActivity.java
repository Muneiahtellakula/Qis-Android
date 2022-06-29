package com.example.covid19reports;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.covid19reports.databinding.ActivityMainBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        Endpoint endpoint=Covid19Instance.getInstance().create(Endpoint.class);
        Call<String> c=endpoint.getData();
        c.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i("Responds",response.body());
                try {
                    JSONArray rootAry=new JSONArray(response.body());
                    JSONObject jsonObject=rootAry.getJSONObject(rootAry.length()-1);
                    String date=jsonObject.getString("Date");
                    binding.tvDate.setText("Date :"+date);

                    String active=jsonObject.getString("Active");
                    binding.tvActive.setText("Active :"+active);

                    String Recovered=jsonObject.getString("Recovered");
                    binding.tvRecovered.setText("Recovered :"+Recovered);

                    String Deaths=jsonObject.getString("Deaths");
                    binding.tvDeath.setText("Deaths :"+Deaths);

                    String Confirmed=jsonObject.getString("Confirmed");
                    binding.tvConfirmed.setText("Confirmed :"+Confirmed);

                    String Country=jsonObject.getString("Country");
                    binding.tvCountry.setText("Country :"+Country);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "failed to load", Toast.LENGTH_SHORT).show();
            }
        });
    }
    /*Retrofit
    * It is one of Lib for fetching the backgrond opatations
    **/
}