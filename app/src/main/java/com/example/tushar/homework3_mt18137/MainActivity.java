package com.example.tushar.homework3_mt18137;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseHelper dh = new DatabaseHelper(MainActivity.this);
        dh.addAllQuestions();
        //Toast.makeText(this, "Questions Added", Toast.LENGTH_LONG).show();
        //Question q = dh.getQuestionById(30);
        //Toast.makeText(this, q!=null?q.getQuestion():"Null", Toast.LENGTH_LONG).show();
        List<Question> questionsList = dh.getAllQuestions();
        QuestionListAdapter adapter = new QuestionListAdapter(questionsList);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4 ));
        recyclerView.setAdapter(adapter);
    }
}
