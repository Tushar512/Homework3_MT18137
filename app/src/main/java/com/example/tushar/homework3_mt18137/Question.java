package com.example.tushar.homework3_mt18137;

public class Question {
    private int id;
    private String question;
    private int answer;
    public Question() {

    }
    public Question(int id, String question, int answer) {
        this.setId(id);
        this.setQuestion(question);
        this.setAnswer(answer);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }
}
