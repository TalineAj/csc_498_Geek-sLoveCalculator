package com.lau.geekslovecalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
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
        //their visibility according to the case which does not look efficient , that is why I researched the possibility of setting image in java
        //and there was a way to do so which I used here
        Resources res = getResources();
        Random num =  new Random();
        int match = num.nextInt(100);

        if(!name_value.matches("")){
            result.setText(match+"%");
            switch (language)
            {
                case "Java":
                {

                    Drawable java_logo = ResourcesCompat.getDrawable(res, R.drawable.java, null);
                    languageimg.setImageDrawable(java_logo);
//                    languageimg.animate().rotation(360).setDuration(2000);
                }
                    break;
                case "JavaScript":
                {   Drawable js_logo = ResourcesCompat.getDrawable(res, R.drawable.js, null);
                    languageimg.setImageDrawable(js_logo);
//                    languageimg.animate().translationX(200).setDuration(1000);
                    break;
                }
                case "Python":
                {   Drawable python_logo = ResourcesCompat.getDrawable(res, R.drawable.python, null);
                    languageimg.setImageDrawable(python_logo);
//                    languageimg.animate().rotation(3600).setDuration(2000);
                    break;
                }

                case "C":
                {
                    Drawable C_logo = ResourcesCompat.getDrawable(res, R.drawable.c, null);
                    languageimg.setImageDrawable(C_logo);
//                    languageimg.animate().rotation(3300).setDuration(1000);
                    break;
                }
                case "C++":
                {
                    Drawable Cpp = ResourcesCompat.getDrawable(res, R.drawable.cpp, null);
                    languageimg.setImageDrawable(Cpp);
//                    languageimg.animate().rotation(360).setDuration(1000);
                    break;
                }
                case "C#":
                {   Drawable Csharp = ResourcesCompat.getDrawable(res, R.drawable.csharp, null);
                    languageimg.setImageDrawable(Csharp);
//                    languageimg.animate().scaleY(10).setDuration(1000);
                    break;
                }
                case "PHP":
                {   Drawable php = ResourcesCompat.getDrawable(res, R.drawable.php, null);
                    languageimg.setImageDrawable(php);
//                    languageimg.animate().translationX(-100).setDuration(1000);
                    break;
                }
                case "R":
                {   Drawable r = ResourcesCompat.getDrawable(res, R.drawable.r, null);
                    languageimg.setImageDrawable(r);
//                    languageimg.animate().translationZ(10).setDuration(1000);
                    break;
                }
            }



        }
        else{
            //Making sure user enters their name
            Toast.makeText(this, "Please enter your name", Toast.LENGTH_LONG).show();

        }


    }

}