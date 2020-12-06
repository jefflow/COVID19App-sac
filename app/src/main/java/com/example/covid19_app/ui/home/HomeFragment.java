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

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        //final TextView textView = root.findViewById(R.id.text_home);
        final TextView totalView = root.findViewById(R.id.totalCasesForCurrentLocation);

//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                totalView.setText("Hey there");
//            }
//        });
        totalView.setText("Hey there");
//
//        //root = inflater.inflate(R.layout.fragment_home, container, false);
//        String[] menuItems = {"Do something", "dfjsdfkljsdf", "sdfkjhsdfsdfh", "sdfkjhsdfsdfh", "sdfkjhsdfsdfh", "sdfkjhsdfsdfh", "sdfkjhsdfsdfh", "sdfkjhsdfsdfh", "sdfkjhsdfsdfh", "sdfkjhsdfsdfh", "sdfkjhsdfsdfh", "sdfkjhsdfsdfh", "sdfkjhsdfsdfh", "sdfkjhsdfsdfh", "sdfkjhsdfsdfh", "sdfkjhsdfsdfh", "sdfkjhsdfsdfh", "sdfkjhsdfsdfh", "sdfkjhsdfsdfh", "sdfkjhsdfsdfh"};
//
//        ListView listView = root.findViewById(R.id.listView);
//
//        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
//                getActivity(),
//                android.R.layout.simple_list_item_1,
//                menuItems
//        );
//
//        listView.setAdapter(listViewAdapter);

        String[] titleArray = {"State", "fdssdf", "title 3", "title 4"};
        String[] detailArray = {"detail 1", "detail 2", "detail 3", "detail 4"};

        List<Map<String, String>> listArray = new ArrayList<>();

        for(int i=0; i< titleArray.length; i++)
        {
            Map<String, String> listItem = new HashMap<>();
            listItem.put("titleKey", titleArray[i]);
            listItem.put("detailKey", detailArray[i]);
            listArray.add(listItem);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity(), listArray,
                android.R.layout.simple_list_item_2,
                new String[] {"titleKey", "detailKey" },
                new int[] {android.R.id.text1, android.R.id.text2 });

        ListView listView = root.findViewById(R.id.listView);
        listView.setAdapter(simpleAdapter);

        return root;
    }

}