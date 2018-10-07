package com.example.tushar.homework3_mt18137;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class QuestionListAdapter extends RecyclerView.Adapter<QuestionListAdapter.ViewHolder> {
    private List<Question> questionsList;
    public QuestionListAdapter(List<Question> list) {
        questionsList = list;
    }
    @NonNull
    @Override
    public QuestionListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View listItem = layoutInflater.inflate(R.layout.list_item, viewGroup, false);
        QuestionListAdapter.ViewHolder viewHolder = new QuestionListAdapter.ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionListAdapter.ViewHolder viewHolder, int i) {
        Question q = questionsList.get(i);
        viewHolder.questionId.setText("Q"+q.getId());
        viewHolder.constraintLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), QuestionDetailActivity.class);
                TextView tv = view.findViewById(R.id.questionId);
                intent.putExtra("questionId", tv.getText().toString());
                view.getContext().startActivity(intent);
                Toast.makeText(view.getContext(), "View Clicked ",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return questionsList.size();
    }

    //Class for viewholder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView questionId;
        public ConstraintLayout constraintLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            this.questionId = itemView.findViewById(R.id.questionId);
            this.constraintLayout = itemView.findViewById(R.id.constraintLayout);
        }
    }
}
