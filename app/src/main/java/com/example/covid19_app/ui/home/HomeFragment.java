package com.example.covid19_app.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;



import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.covid19_app.MainActivity;
import com.example.covid19_app.R;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import android.widget.SimpleAdapter;

import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.example.covid19_app.R.id.listView;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        //final TextView textView = root.findViewById(R.id.text_home);
        final TextView totalView = root.findViewById(R.id.totalCasesForCurrentLocation);
        final ListView listView = root.findViewById(R.id.listView);
        final ArrayList<String> tubeLines = new ArrayList<String>();
        final ArrayAdapter<String> arrAdapt = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1,tubeLines);
        listView.setAdapter(arrAdapt);
        List<Map<String, String>> listArray = new ArrayList<>();

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        String url = "https://api.covidactnow.org/v2/states.json?apiKey=76b2967efbb84f28bd81cb13dc645482";

        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray arr = new JSONArray(response);

                            for (int i = 0; i<arr.length();i++)
                            {
                                JSONObject line = arr.optJSONObject(i);
                                String lineName = line.optString("state");
                                String pop = line.optString("population");
                                if(line!=null)
                                    tubeLines.add(lineName);
                                tubeLines.add(pop);
                            }
                            arrAdapt.notifyDataSetChanged();


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
//                                mTextViewResult.setText(jsonObj.toString());*/
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
            }
        });

        //mTextViewResult.setText("herro there");

        requestQueue.add(request);
        return root;
    }

}