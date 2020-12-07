package com.example.menu_dialog_animation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_no, btn_yes;
    Dialog dialog;
    ImageView bear;
    Animation  animRotate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    //menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            //button anim in menu
            case R.id.menu_anim:

                Toast.makeText(this, "Your picture is moving", Toast.LENGTH_SHORT).show();

                bear = findViewById(R.id.bear);

                animRotate = AnimationUtils.loadAnimation(this, R.anim.animation_pic);
                animRotate.setDuration(3000);

                bear.startAnimation(animRotate);

                return true;
                //button exit in menu
            case R.id.menu_exit:
                dialog = new Dialog(this);
                dialog.setContentView(R.layout.dialog_layout);

                btn_no = dialog.findViewById(R.id.btn_no);
                btn_yes = dialog.findViewById(R.id.btn_yes);

                //button no in dialog
                btn_no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                //button yes in dialog
                btn_yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                        System.exit(0);
                    }
                });

                //cancel clickable on screen while dialog is open
                dialog.setCancelable(false);

                dialog.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}