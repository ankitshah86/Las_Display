package com.example.test2;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

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

                Log.d("sldkfj", "onClick: ");
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                startActivity(new Intent(MainActivity.this,LandingPage.class));
            }
        });

        Button exitButton = findViewById(R.id.exit);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
               //It seems that either one of these approaches should work just fine
                 finish();
                //System.exit(0);
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });


        Button helpButton = findViewById(R.id.help);
        helpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,HelpPage.class));
            }
        });

        Button openLasFileButton = findViewById(R.id.openLasFile);
        openLasFileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this,OpenLasPage.class));

                File f = new File("sdcard/Download/8-32IN.LAS");
               // File f  = new File("C:\\Users\\Ankit\\AndroidStudioProjects\\test2\\app\\src\\main\\res\\values\\colors.xml");
              Log.d("File Exists : ",String.valueOf(f.exists()));
             // Log.d("Canonical Path",String.valueOf(f.getCanonicalPath()));
              String line;
             /* try{

                  FileReader rdr = new FileReader(f.getName());
                  BufferedReader buf = new BufferedReader(rdr);

                  while ((line = buf.readLine()) != null){
                      Log.d("Las File", line);
                  }

              }
              catch (FileNotFoundException ex) {
                  System.out.println(ex);
              }
              catch (java.io.IOException ex) {
                  System.out.println(ex);
              }*/

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
}
