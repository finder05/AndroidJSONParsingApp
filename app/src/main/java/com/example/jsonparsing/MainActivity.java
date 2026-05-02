package com.example.jsonparsing;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends Activity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView1);

        // JSON String (Sample Data)
        String strJson = "{ \"Employee\" :[" +
                "{\"id\":101,\"name\":\"Rakave\",\"salary\":50000}," +
                "{\"id\":102,\"name\":\"Rackshi\",\"salary\":100000}" +
                "] }";

        // StringBuilder for better performance
        StringBuilder data = new StringBuilder();

        try {
            JSONObject jsonRootObject = new JSONObject(strJson);
            JSONArray jsonArray = jsonRootObject.getJSONArray("Employee");

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);

                int id = jsonObject.getInt("id");
                String name = jsonObject.getString("name");
                double salary = jsonObject.getDouble("salary");

                data.append("Node ").append(i).append(":\n")
                        .append("ID: ").append(id).append("\n")
                        .append("Name: ").append(name).append("\n")
                        .append("Salary: ").append(salary).append("\n\n");
            }

            textView.setText(data.toString());

        } catch (Exception e) {
            textView.setText("Error parsing JSON");
            e.printStackTrace();
        }
    }
}