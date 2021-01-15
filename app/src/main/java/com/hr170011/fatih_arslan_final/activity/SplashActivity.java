package com.hr170011.fatih_arslan_final.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.hr170011.fatih_arslan_final.R;
import com.hr170011.fatih_arslan_final.util.NetworkUtil;


public class SplashActivity extends AppCompatActivity {
    Context context = this;
    NetworkUtil networkUtil;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        networkUtil = new NetworkUtil();
        if (internetBaglantisiVarMi()) {
            final Thread thread;
            thread = new Thread() {
                @Override
                public void run() {
                    try {
                        synchronized (this) {
                            wait(3000);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        openListeActivity();
                    }
                }
            };
            thread.start();
        } else {
            openAlertDialog();
        }

    }

    boolean internetBaglantisiVarMi() {
        if (networkUtil.internetVarMi(this)) {
            return true;
        } else {
            return false;
        }
    }
    private void openListeActivity(){
        Intent secondActivityIntent=new Intent(getApplicationContext(),ListeActivity.class);
        startActivity(secondActivityIntent);
        finish();
    }
    private void openAlertDialog(){
        AlertDialog.Builder alert = new AlertDialog.Builder(context);
        alert.setTitle("İnternet Bağlantınız Yok");
        alert.setMessage("Uygulamayı kullanabilmek için internete bağlayın.");
        alert.setPositiveButton("Ayarlara Git", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                Intent intent = new Intent(android.provider.Settings.ACTION_SETTINGS);
                startActivityForResult(intent, 0);
                finishAffinity();
                System.exit(0);
            }
        });
        alert.setNegativeButton("Son", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                finishAffinity();
                System.exit(0);
            }
        });
        alert.show();
    }
}
