package com.example.test2;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Environment;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;

import java.io.File;

public class LasFileExplorer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_las_file_explorer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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

        startActivityForResult(intent, 42);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });



    }


}
