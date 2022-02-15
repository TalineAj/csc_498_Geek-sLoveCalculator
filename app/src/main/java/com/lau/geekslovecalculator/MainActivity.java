package com.lau.geekslovecalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.icu.number.Scale;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

//logo image added from: https://icons8.com/icon/set/heart-plus/color
public class MainActivity extends AppCompatActivity {
    EditText name;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Creating a dropdown list
        //Source: https://www.youtube.com/watch?v=urQp7KsQhW8
        Spinner mySpinner = (Spinner)  findViewById(R.id.spinner);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.languages));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

        //Changing color of status bar in android app
       // Source://https://www.geeksforgeeks.org/how-to-change-the-color-of-status-bar-in-an-android-app/
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.red));
        }
        name = (EditText) findViewById(R.id.name);
        result = (TextView ) findViewById(R.id.match);
    }
    public void calculate(View view){
        //extra stuff to handle:  if user writes special character or numbers as a name , if name_value contains a number or special character set it to "", then the toast will ask for name
        //Get same result if chose same language twice with the same name?
        Spinner mySpinner = (Spinner)  findViewById(R.id.spinner);
        String language = mySpinner.getSelectedItem().toString();//gets the selected language
        String name_value = name.getText().toString();// gets the name of the user
        ImageView languageimg = (ImageView) findViewById(R.id.languagelogo);
        //Was initially planning on using the visibility attribute as learned in class however this means creating 8 Imageviews and setting
        //their visibility according to the case which does not look efficient , that is why I decided to set the image from java
        Resources res = getResources();
        Random num =  new Random();
        int match = num.nextInt(100);

        if(!name_value.matches("")){
            result.setText(match+"%");
            switch (language)
            {
                case "Java":

                    languageimg.setImageResource(R.drawable.java);
                    RotateAnimation animation = new RotateAnimation(0,360);
                    animation.setDuration(2000);
                    languageimg.startAnimation(animation);
                    break;

                case "JavaScript":

                    languageimg.setImageResource(R.drawable.js);
                    RotateAnimation animation1 = new RotateAnimation(0,-360);
                    animation1.setDuration(2000);
                    languageimg.startAnimation(animation1);
                    languageimg.animate().rotation(360);
                    break;

                case "Python":
                    languageimg.setImageResource(R.drawable.python);
                    RotateAnimation animation2 = new RotateAnimation(0,-360);
                    animation2.setDuration(2000);
//                    ScaleAnimation animation2 = new ScaleAnimation(100,200,0,0);
//                    animation2.setDuration(2000);
                    languageimg.startAnimation(animation2);
                    break;
                ///change animations

                case "C":
                    languageimg.setImageResource(R.drawable.c);
                    RotateAnimation animation3= new RotateAnimation(0,360);
                    animation3.setDuration(2000);
                    languageimg.startAnimation(animation3);
                    break;

                case "C++":

                    languageimg.setImageResource(R.drawable.cpp);
                    RotateAnimation animation4= new RotateAnimation(0,360);
                    animation4.setDuration(2000);
                    languageimg.startAnimation(animation4);
                    break;


                case "C#":
                    languageimg.setImageResource(R.drawable.csharp);
                    RotateAnimation animation5= new RotateAnimation(0,360);
                    animation5.setDuration(2000);
                    languageimg.startAnimation(animation5);
                    break;

                case "PHP":
                    languageimg.setImageResource(R.drawable.php);
                    RotateAnimation animation6= new RotateAnimation(0,360);
                    animation6.setDuration(2000);
                    languageimg.startAnimation(animation6);
                    break;

                case "R":
                    //fix R image
                    languageimg.setImageResource(R.drawable.r);
                    RotateAnimation animation7= new RotateAnimation(0,360);
                    animation7.setDuration(2000);
                    languageimg.startAnimation(animation7);
                    break;

            }



        }
        else{
            //Making sure user enters their name
            Toast.makeText(this, "Please enter your name", Toast.LENGTH_LONG).show();

        }


    }

}