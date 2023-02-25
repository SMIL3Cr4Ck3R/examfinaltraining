package com.example.examtraining;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.examtraining.database.ImageHolderModel;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.gson.Gson;

public class NextActivity2 extends AppCompatActivity {

    private TextView mTextView;
    private Button loadIntentDataButton;
    private Button saveSharedPrefButton;
    private Button nextActivityButton;

    private FirebaseFirestore firestoreDB = FirebaseFirestore.getInstance();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next2);
        initializeViews();

    }

    private void initializeViews() {
        mTextView = findViewById(R.id.dataExtraTextView);
        loadIntentDataButton = findViewById(R.id.loadByIntentExtraBtn);
        saveSharedPrefButton = findViewById(R.id.saveToSharedPrefBtn);
        nextActivityButton = findViewById(R.id.fireBaseExampleActivityBtn);
    }


    public void loadEntentBtnClicked(View view) {
        intentData ();
    }


    private void intentData () {
        Gson g = new Gson();
        String intentData =  getIntent().getStringExtra("imgJson");
        ImageHolderModel[] imgArr = g.fromJson(intentData, ImageHolderModel[].class);

        for (ImageHolderModel img : imgArr) {
            mTextView.append(img.getTitle() + "\n");
        }
    }


    public void saveToSharedPrefBtnClicked(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("MYSHAREDPREF",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("jsonData","a7a");
        editor.commit();
    }

    public void fireBaseExampleActivityBtnClicked(View view) {



    }
}