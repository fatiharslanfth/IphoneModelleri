package com.hr170011.fatih_arslan_final.activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.hr170011.fatih_arslan_final.R;
import com.hr170011.fatih_arslan_final.model.IphoneModel;
import com.hr170011.fatih_arslan_final.util.Constants;
import com.hr170011.fatih_arslan_final.util.GlideUtil;
import com.hr170011.fatih_arslan_final.util.ObjectUtil;
import com.hr170011.fatih_arslan_final.util.ProgressUtil;


public class IphoneDetayActivity extends AppCompatActivity {
    ImageView imgKapak;
    TextView txtBaslik;
    TextView txtDetay;

    @Override
    public void onBackPressed() {
        ProgressUtil.getInstance().closeProgressDialog();
        IphoneDetayActivity.super.onBackPressed();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iphone_detay);



        String tasinanIphoneString =getIntent().getStringExtra(Constants.TIKANAN_BURC_TASINANIN_BASLIGI);
        IphoneModel iphoneModel = ObjectUtil.jsonStringToIphone(tasinanIphoneString);

        imgKapak =findViewById(R.id.imgKapak);
        txtBaslik =findViewById(R.id.txtBaslik);
        txtDetay =findViewById(R.id.txtDetay);

        txtBaslik.setText(iphoneModel.getIphoneAdi());
        txtDetay.setText(iphoneModel.getAciklama());
        GlideUtil.resmiIndiripGoster(getApplicationContext(),iphoneModel.getKapakFotoUrl(),imgKapak);

    }
}
