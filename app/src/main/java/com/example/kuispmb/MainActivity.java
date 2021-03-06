package com.example.kuispmb;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void biodata(View view) {
        startActivity(new Intent(MainActivity.this, Biodata.class));
    }

    public void moveMaps(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("geo:-3.48323,119.1294786")).setPackage("com.google.android.apps.maps"));
    }

   public void moveTelephone(View view) {
        String nomor1 = ("082293489531");
        Intent dialnomor = new
                Intent(Intent.ACTION_DIAL);
        dialnomor.setData(Uri.fromParts("tel",nomor1,null));
        startActivity(dialnomor);
   }

    public void exit(View view) {
        logout(this);
    }

    public static void logout(Activity activity){
        AlertDialog.Builder builder= new AlertDialog.Builder(activity);
        builder.setTitle("Keluar");
        builder.setMessage("Serius Mau Keluar?");

        builder.setPositiveButton("Iye", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                activity.finishAffinity();
                System.exit(0);
            }
        });

        builder.setNegativeButton("Nda ji", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }
}
