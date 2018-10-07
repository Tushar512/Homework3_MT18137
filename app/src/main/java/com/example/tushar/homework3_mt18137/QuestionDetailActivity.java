package com.example.tushar.homework3_mt18137;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuestionDetailActivity extends AppCompatActivity {
    int currentQid=1;
    TextView question, questionId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_detail);
        question = findViewById(R.id.question);
        questionId = findViewById(R.id.questionId);
        Intent i = getIntent();
        try {
            String qid = i.getStringExtra("questionId");
            currentQid = Integer.parseInt(qid.substring(1));
            displayQuestion();
            Button nextBtn = findViewById(R.id.nextBtn);
            nextBtn.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    if(currentQid < 30) {
                        currentQid++;
                        displayQuestion();
                    }
                }
            });
            Button prevBtn = findViewById(R.id.prevBtn);
            prevBtn.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    if(currentQid > 1) {
                        currentQid--;
                        displayQuestion();
                    }
                }
            });
        } catch(Exception e) {
            Log.i("Error", e.getMessage());
        }
    }
    public void displayQuestion() {
        DatabaseHelper dh = new DatabaseHelper(this);
        Question q = dh.getQuestionById(currentQid);
        question.setText(q.getQuestion());
        questionId.setText("Q"+q.getId());

    }
}
