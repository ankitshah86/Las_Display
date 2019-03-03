package com.example.test2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Environment;
import android.provider.ContactsContract;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class LasFileExplorer extends AppCompatActivity {


    private static final int READ_REQUEST_CODE = 42;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_las_file_explorer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        textView = findViewById(R.id.textView);
        textView.setMovementMethod(new ScrollingMovementMethod());
        setSupportActionBar(toolbar);

        File root = new File( Environment.getExternalStorageDirectory().getAbsolutePath());
        Log.d("root",root.toString());

        //Log.d("list size", String.valueOf(root.listFiles().length));

       /* Log.d("testing","testing");

        Log.d("testing", Environment.getExternalStorageDirectory().listFiles().toString());
        String rootPath = getFilesDir().getPath();
        Log.d("root dir ",rootPath);


       // Log.d("files",String.valueOf(ff.length));
*/
        // browser.
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);


        // Filter to only show results that can be "opened", such as a
        // file (as opposed to a list of contacts or timezones)
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("*/*");

        // Filter to show only images, using the image MIME data type.
        // If one wanted to search for ogg vorbis files, the type would be "audio/ogg".
        // To search for all documents available via installed storage providers,
        // it would be "*/*".

         startActivityForResult(intent, READ_REQUEST_CODE) ;
       // Log.d("Selected", intent.getData().toString());


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent resultData) {
        //super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == READ_REQUEST_CODE && resultCode == Activity.RESULT_OK){

            Uri uri = resultData.getData();
            Log.d("result",uri.toString());
            try{
                readTextFromUri(uri) ;
            }
            catch (IOException io){
                Log.d("exception",io.toString());
            }

        }
    }

    private String readTextFromUri(Uri uri) throws IOException {

        InputStream inputStream = getContentResolver().openInputStream(uri);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String line;

        int i = 0;

        while((line = reader.readLine()) != null){
            stringBuilder.append(line);
           // if(i<200)
            textView.append(line+"\n");
            i++;
        }
        inputStream.close();
        reader.close();


        return stringBuilder.toString();
    }


}
