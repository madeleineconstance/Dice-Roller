package com.example.diceroller;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.EditText;
import android.text.Editable;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    TextView tvScore;

    int score = 0;

    public void on_button_click(View view){

        TextView tv = this.findViewById(R.id.textView);

        int number = getRandomN();

        tv.setText(String.valueOf(number));

        EditText  mEdit = findViewById(R.id.editText);
        Editable guessedNumber = mEdit.getText();

        TextView tvc = this.findViewById(R.id.congrats);


        int guessedN = Integer.parseInt(guessedNumber.toString());
        if (guessedN == number){
            tvc.setText("Congrats");

            tvScore = findViewById(R.id.score);
            score = score + 1;
            tvScore.setText(String.valueOf(score));

        }
        else {
            tvc.setText("Try Again");
        }


    }

    public int getRandomN(){

        TextView tv = this.findViewById(R.id.textView);
        Random r = new Random();
        int number = r.nextInt(6);
        tv.setText(Integer.toString(number));

        return number;
    }




}
