package edu.fjnu.cse.simpleadapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends Activity{

    private String[] animals = new String[]{
            "Lion","Tiger","Monkey","Dog","Cat","Elephant"
    };
    private int[] imageIds = new int[]{
            R.drawable.lion,R.drawable.tiger,R.drawable.monkey,R.drawable.dog,R.drawable.cat,R.drawable.elephant
    };
    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < animals.length; i++){
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("picture", imageIds[i]);
            listItem.put("animal", animals[i]);
            listItems.add(listItem);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, listItems, R.layout.simple_item,
                new String[] {"animal","picture"}, new int[] {R.id.animal,R.id.picture});
        ListView list = (ListView) findViewById(R.id.mylist);
        list.setAdapter(simpleAdapter);
        list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast toast = Toast.makeText(MainActivity.this, animals[position], Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM, 0, 200);
                toast.show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
