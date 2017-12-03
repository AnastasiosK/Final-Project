/***
 * Anastasios k.
 * 3/12/2017
 */
package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    /***
     * Make some declarations
     */
    public   int score = 0;
    public EditText yes_or_no,last_yesorno;
    public  int yearCheck;
    public String last;
    private  RadioGroup radiog,radiog2;
    private  RadioButton radio_choose,radio_choose2;
    private RadioButton rc,na;
    private CheckBox a,b,c,d;

    /***
     * App starts
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radiog = (RadioGroup) findViewById(R.id.radioAnswers);
        radiog2 = (RadioGroup) findViewById(R.id.radioAnswers2);
        score = 0;
    }

    /***
     * The main logic of my app
     * after the submit button is pressed,i am checking for the correct score
     * and display it
     */
    protected void getScore(View view){
        a = (CheckBox) findViewById(R.id.checkbox1_weather);
        b = (CheckBox) findViewById(R.id.checkbox2_naturalbeauty);
        c = (CheckBox) findViewById(R.id.checkbox3_Food);
        d = (CheckBox) findViewById(R.id.checkbox4_Music);
        yes_or_no = (EditText) findViewById(R.id.question3_year);
        last_yesorno = (EditText) findViewById(R.id.last_question);

        yearCheck = Integer.parseInt(yes_or_no.getText().toString());
        last = last_yesorno.getText().toString();

        int radiobuttonid = radiog.getCheckedRadioButtonId();
        int radiobuttonid2 = radiog2.getCheckedRadioButtonId();

        radio_choose = (RadioButton) findViewById(radiobuttonid);
        radio_choose2 = (RadioButton) findViewById(radiobuttonid2);

        rc = (RadioButton) findViewById(R.id.radio_1);
        na = (RadioButton) findViewById(R.id.nani);

        if (a.isChecked()&&b.isChecked()&&c.isChecked()&&d.isChecked())
        {
            score = score +1;
        }

        if(yearCheck == 2004){
            score = score +1;
        }

        if(last.equals("Yes")){
            score = score +2;
        }
        else if(last.equals("No")) {
            score = score + 1;
        }

        if (radio_choose2 == na)
        {
            score+= 1;
        }

        if (radio_choose == rc)
        {
            score = score +1;
        }

        /***
         * If the user makes a perfect score it displays a different message
         * to get a perfect score all answers must be correct and the last EditText should have
         * the Yes as an answer which gives +1 bonus point
         */
        if(score == 6){
            Toast.makeText(this,"You are the best!!! You made a perfect score of : "+score,Toast.LENGTH_LONG).show();
            score = 0;
        }
        else
        Toast.makeText(this,"This is your score: "+score,Toast.LENGTH_LONG).show();
        score = 0;

    }
}
