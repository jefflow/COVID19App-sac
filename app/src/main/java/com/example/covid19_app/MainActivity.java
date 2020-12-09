package com.example.covid19_app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

     TextView mTextViewResult;
     String data, dataParsed, singleParsed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextViewResult = findViewById(R.id.text_total_confirmed);

/*        fetchData();*/

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }
/*
    private void fetchData(){

        String url = "https://api.covidactnow.org/v2/states.json?apiKey=76b2967efbb84f28bd81cb13dc645482";

        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray arr = new JSONArray(response);
                            ArrayList<String> tubeLines = new ArrayList<String>();
                            for (int i = 0; i<response.length();i++)
                            {
                                JSONObject line = arr.getJSONObject(i);
                                String lineName = line.optString("fips","N/A");
                                tubeLines.add(lineName);
                            }
                            ListView m

                           */
/* JSONObject jsonObject = new JSONObject(jsonObj);
//                            JSONObject jsonObj = new JSONObject(response);
//                            JSONArray jsonArr = jsonObj.getJSONArray("fips");
//                            for (int i = 0; i < jsonArr.length(); i++)
//                            {
//                                JSONObject f = jsonArr.getJSONObject(i);
//                                String county = f.getString("county");
//                                String state = f.getString("state");
//                                String population = f.getString("population");
//
//                                JSONObject density = f.getJSONObject("metrics");
//                                String testPositivityRatio = density.getString("testPositivityRatio");
//
//                                HashMap<String, String> st = new HashMap<>();
//
//                                st.put("county",county);
//                                st.put("state",state);
//                                st.put("population",population);
//                                st.put("testPositivityRatio",testPositivityRatio);
//                                System.out.println(st);
//                            JSONObject jsonArr = new JSONObject(response);
//                            JSon
//                            JSONArray jsonArr = jsonObj.getJSONObject(response);
//                            for (int i = 0; i < jsonArr.length(); i++)
//                            {
//
//                              /*  for(int j =0; j<i;j++){
//                                    System.out.println(jsonArr.getJSONObject(j));
//                                }
//
//                                mTextViewResult.setText(jsonObj.toString());*//*

//                            }
//                           /* JSONObject jsonObject = new JSONObject(jsonObj);


                          // mTextViewResult.setText(jsonObject.getString("country"));



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

        //mTextViewResult.setText("herro there");
       RequestQueue requestQueue = Volley.newRequestQueue(this);
       requestQueue.add(request);
    }
*/


}