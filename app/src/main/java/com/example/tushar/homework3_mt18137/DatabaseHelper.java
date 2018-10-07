package com.example.tushar.homework3_mt18137;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    int count=0;
    public DatabaseHelper(Context context) {
        super(context, "Quiz", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE IF NOT EXISTS Questions(id INTEGER PRIMARY KEY, question TEXT, answer INTEGER DEFAULT 0)";
        db.execSQL(query);
    }
    //Method to add all 30 T/F Questions to SQLite
    public void addAllQuestions() {
        SQLiteDatabase db = this.getWritableDatabase();
        this.insertQuestion(db, new Question(++count, "The Language that the computer can understand is called Machine Language.",1));
        this.insertQuestion(db, new Question(++count, "Magnetic Tape used random access method.",0));
        this.insertQuestion(db, new Question(++count, "Twitter is an online social networking and blogging service.",0));
        this.insertQuestion(db, new Question(++count, "Worms and trojan horses are easily detected and eliminated by antivirus software.",1));
        this.insertQuestion(db, new Question(++count, "Dot-matrix, Deskjet, Inkjet and Laser are all types of Printers.",1));
        this.insertQuestion(db, new Question(++count, "GNU / Linux is a open source operating system.",1));
        this.insertQuestion(db, new Question(++count, "Whaling / Whaling attack is a kind of phishing attacks that target senior executives and other high profile to access valuable information.",1));
        this.insertQuestion(db, new Question(++count, "Freeware is software that is available for use at no monetary cost.",1));
        this.insertQuestion(db, new Question(++count, "IPv6 Internet Protocol address is represented as eight groups of four Octal digits.",0));
        this.insertQuestion(db, new Question(++count, "The hexadecimal number system contains digits from 1 - 15.",0));
        this.insertQuestion(db, new Question(++count, "Octal number system contains digits from 0 - 7.",1));
        this.insertQuestion(db, new Question(++count, "MS Word is a hardware.",0));
        this.insertQuestion(db, new Question(++count, "CPU controls only input data of computer.",0));
        this.insertQuestion(db, new Question(++count, "CPU stands for Central Performance Unit.",0));
        this.insertQuestion(db, new Question(++count, "The Language that the computer can understand is called Machine Language.",1));
        this.insertQuestion(db, new Question(++count, "Magnetic Tape used random access method.",0));
        this.insertQuestion(db, new Question(++count, "Twitter is an online social networking and blogging service.",0));
        this.insertQuestion(db, new Question(++count, "Worms and trojan horses are easily detected and eliminated by antivirus software.",1));
        this.insertQuestion(db, new Question(++count, "Dot-matrix, Deskjet, Inkjet and Laser are all types of Printers.",1));
        this.insertQuestion(db, new Question(++count, "GNU / Linux is a open source operating system.",1));
        this.insertQuestion(db, new Question(++count, "Whaling / Whaling attack is a kind of phishing attacks that target senior executives and other high profile to access valuable information.",1));
        this.insertQuestion(db, new Question(++count, "Freeware is software that is available for use at no monetary cost.",1));
        this.insertQuestion(db, new Question(++count, "IPv6 Internet Protocol address is represented as eight groups of four Octal digits.",0));
        this.insertQuestion(db, new Question(++count, "The hexadecimal number system contains digits from 1 - 15.",0));
        this.insertQuestion(db, new Question(++count, "Octal number system contains digits from 0 - 7.",1));
        this.insertQuestion(db, new Question(++count, "MS Word is a hardware.",0));
        this.insertQuestion(db, new Question(++count, "CPU controls only input data of computer.",0));
        this.insertQuestion(db, new Question(++count, "CPU stands for Central Performance Unit.",0));
        this.insertQuestion(db, new Question(++count, "CPU stands for Central Performance Unit.",0));
        this.insertQuestion(db, new Question(++count, "The Language that the computer can understand is called Machine Language.",1));
        db.close();
    }
    //Method to add a Question at a time
    public void insertQuestion(SQLiteDatabase db, Question q) {
        ContentValues cv = new ContentValues();
        cv.put("question",q.getQuestion());
        cv.put("answer", q.getAnswer());
        cv.put("id", q.getId());
        db.insert("Questions", null, cv);
    }
    public Question getQuestionById(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query("Questions", new String[]{"id","question","answer"}, "id=?", new String[] {Integer.toString(id)},null, null, null);
        Question q = null;
        if(cursor.moveToFirst()) {
            q = new Question(cursor.getInt(0), cursor.getString(1), cursor.getInt(2));
        }
        cursor.close();
        db.close();
        return q;
    }
    public List<Question> getAllQuestions() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query("Questions", null, null, null,null, null, null);
        List<Question> questionsList = new ArrayList<Question>();
        if(cursor.moveToFirst()) {
            do {
                Question q = new Question();
                q.setId(cursor.getInt(0));
                q.setQuestion(cursor.getString(1));
                q.setAnswer(cursor.getInt(2));
                questionsList.add(q);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return questionsList;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
