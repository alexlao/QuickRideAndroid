package com.alexanderlao.quickride.quickrideandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainRide extends AppCompatActivity {
    private EditText name;
    private Button go;
    private Button post;

    private String php;
    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ride);
        name = (EditText) findViewById(R.id.addressText);
        go = (Button) findViewById(R.id.button);
        go.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                getInfo();
            }
        });
        queue = Volley.newRequestQueue(this);
        php = "http://alexanderlao.com/getRide.php";
        post = (Button) findViewById(R.id.button2);
        post.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                postInfo();
            }
        });
    }

    public void getInfo(){
        Log.e("Pressed", "BUTTON PRESSED");
        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET, php, null, new Response.Listener<JSONObject>(){
            public void onResponse(JSONObject response){
                Log.e("RESPONSE", "GOT RESPONSE");
                try{
                    name.setText(response.getString("response"));
                }
                catch(Exception e){
                    Log.e("Exeception", e.getMessage());
                }

            }
        }, new Response.ErrorListener(){
            public void onErrorResponse(VolleyError error){
                Log.e("RESPONSE", "response error!");

                Log.e("Error Response: ", error.getMessage());

            }
        });
        queue.add(jsObjRequest);
    }

    public void postInfo(){
        Log.e("Pressed", "Button Pressed");
        Map<String, String> params = new HashMap();
        params.put("name", "alex");
        params.put("address", "4628 fillingame drive");
        params.put("userGroup", "myGroup");
        CustomRequest jsObjRequest = new CustomRequest(Request.Method.POST, php, params, new Response.Listener<JSONObject>(){
            public void onResponse(JSONObject response) {
                try {
                    name.setText(response.getString("response"));
                }
                catch(Exception e){
                    Log.e("Exception", e.getMessage());
                }
            }
        }, new Response.ErrorListener(){
            public void onErrorResponse(VolleyError error){
                Log.e("RESPONSE ERROR", error.getMessage());
            }
        });

        queue.add(jsObjRequest);
    }

}
