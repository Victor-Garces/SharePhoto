package com.example.victor.sharephoto;

import android.graphics.Bitmap;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class PictureConfigurationActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private Editable writeSomething;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_configuration);

        Bitmap imageBitmap = getIntent().getParcelableExtra("thumbnail");

        ImageView thumbnailView = findViewById(R.id.thumbnail);
        thumbnailView.setImageBitmap(imageBitmap);

        //Add Location text label
        findViewById(R.id.location).setOnClickListener(this);
        // Add Location image
        findViewById(R.id.place).setOnClickListener(this);

        //Image sharing switches
        Switch facebookSwitch = findViewById(R.id.facebook_switch);
        facebookSwitch.setOnCheckedChangeListener(this);

        Switch twitterSwitch = findViewById(R.id.twitter_switch);
        twitterSwitch.setOnCheckedChangeListener(this);

        Switch instagramSwitch = findViewById(R.id.instagram_switch);
        instagramSwitch.setOnCheckedChangeListener(this);

        EditText writeSomethingEditText = findViewById(R.id.write_something);
        writeSomething = writeSomethingEditText.getText();

    }

    @Override
    public void onClick(View v) {

        int i = v.getId();

        if(i == R.id.location || i == R.id.place){
            Toast.makeText(this, "Boton activado", Toast.LENGTH_SHORT).show();
            //TODO Que hacer tras presionar el label de location
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        int b = buttonView.getId();
            //TODO Implementar la forma de compartir en estas redes sociales
        if(b == R.id.facebook_switch){
            if (isChecked) {
                // The toggle is enabled
                Toast.makeText(PictureConfigurationActivity.this, "Activado FB", Toast.LENGTH_SHORT).show();
            } else {
                // The toggle is disabled
                Toast.makeText(PictureConfigurationActivity.this, "Desactivado FB", Toast.LENGTH_SHORT).show();
            }
        }

        if(b == R.id.twitter_switch){
            if (isChecked) {
                // The toggle is enabled
                Toast.makeText(PictureConfigurationActivity.this, "Activado Twitter", Toast.LENGTH_SHORT).show();
            } else {
                // The toggle is disabled
                Toast.makeText(PictureConfigurationActivity.this, "Desactivado Twitter", Toast.LENGTH_SHORT).show();
            }


        }if(b == R.id.instagram_switch){
            if (isChecked) {
                // The toggle is enabled
                Toast.makeText(PictureConfigurationActivity.this, "Activado Instagram", Toast.LENGTH_SHORT).show();
            } else {
                // The toggle is disabled
                Toast.makeText(PictureConfigurationActivity.this, "Desactivado Instagram", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
