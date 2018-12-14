package com.algonquincollege.skai0001.democamera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;
/*
* @author Hasan Skaiky
* This App will run on API 27
* */
public class MainActivity extends AppCompatActivity {

    private final static int CAMERA_REQUEST_CODE=100;
    private ImageView photoImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           //     Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
             //           .setAction("Action", null).show();
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,CAMERA_REQUEST_CODE);
            }
        });
        photoImageView =(ImageView) findViewById(R.id.photoImageView);
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

    @Override
    protected void  onActivityResult(int requestCode, int resultCode, Intent resultIntent){
        Bundle extras;
        Bitmap imageBitmap;

        if (resultCode == RESULT_CANCELED){
            Toast.makeText(getApplicationContext(),"Cancelled",Toast.LENGTH_LONG).show();
            return;
        }

        switch (requestCode){
            case CAMERA_REQUEST_CODE:
                extras = resultIntent.getExtras();
                imageBitmap = (Bitmap) extras.get("data");

                if (imageBitmap !=null){
                    photoImageView.setImageBitmap(imageBitmap);
                }
                break;
        }
    }
} // end of class MainActivity