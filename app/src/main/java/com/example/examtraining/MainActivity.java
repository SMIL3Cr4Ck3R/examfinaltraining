package com.example.examtraining;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.examtraining.database.ExamDatabase;
import com.example.examtraining.database.ImageHolderModel;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView mImageView;
    private TextView mTextView;
    private Button loadApiButton;
    private Button nextActivityButton;

    private RequestQueue mRequestQueue;

    private ArrayList<ImageHolderModel> imgs;

    private Gson gson ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initiateViews();
        mRequestQueue = Volley.newRequestQueue(this);
        readData ("https://jsonplaceholder.typicode.com/photos");

    }

    private void initiateViews() {
        mImageView = findViewById(R.id.imgLoadApi);
        mTextView = findViewById(R.id.imgInfoArea);
        loadApiButton = findViewById(R.id.loadApiBtn);
        nextActivityButton = findViewById(R.id.nextActivityBtn);
    }

    private void readData (String apiURL) {


        JsonArrayRequest req = new JsonArrayRequest(Request.Method.GET, apiURL, null,

                response -> {
                    try {
                         imgs = new ArrayList<>();
                        for (int i = 0; i < response.length(); i++) {
                            JSONObject obj = response.getJSONObject(i);
                            int id = obj.getInt("id");
                            String title = obj.getString("title");
                            String url = obj.getString("url");
                            imgs.add(new ImageHolderModel(id,title,url));

                        }
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                },

                error -> Log.e("ramadan",error.toString()));
        mRequestQueue.add(req);
    }

    public void loadApiButtonClicked(View view) {
        plotRandomData (imgs);
    }

    public void plotRandomData (ArrayList<ImageHolderModel> imgList) {

        int randomInt = (int) (Math.random() * (imgList.size() - 1)) + 1;
        ImageHolderModel imgObj = imgList.get(randomInt);
        Glide.with(this).load(imgObj.getUrl()).into(mImageView);
        mTextView.setText(imgObj.toString());

    }

    public void loadNewActivityBtnClicked(View view) {
        gson = new Gson();

        Intent intent = new Intent(MainActivity.this,NextActivity2.class);
        String jsonImgsObj = gson.toJson(imgs);
        intent.putExtra("imgJson",jsonImgsObj);
        startActivity(intent);

    }
}