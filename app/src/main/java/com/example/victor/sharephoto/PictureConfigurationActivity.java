package com.example.victor.sharephoto;

import android.graphics.Bitmap;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class PictureConfigurationActivity extends AppCompatActivity {

    private ImageView thumbnailView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_configuration);

        Bitmap imageBitmap = getIntent().getParcelableExtra("thumbnail");

        thumbnailView = findViewById(R.id.thumbnail);
        thumbnailView.setImageBitmap(imageBitmap);
    }
}
