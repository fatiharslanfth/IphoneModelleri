package com.hr170011.fatih_arslan_final.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.hr170011.fatih_arslan_final.R;
import com.hr170011.fatih_arslan_final.adaptor.IphoneAdaptor;
import com.hr170011.fatih_arslan_final.model.IphoneModel;
import com.hr170011.fatih_arslan_final.network.Service;
import com.hr170011.fatih_arslan_final.util.Constants;
import com.hr170011.fatih_arslan_final.util.ObjectUtil;
import com.hr170011.fatih_arslan_final.util.ProgressUtil;


import java.util.ArrayList;
import java.util.List;


import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ListeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressDialog progressDialog;
    ProgressBar pb_1;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste);

        init();
    }


    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Uygulama Kapatılacak")
                .setMessage("Çıkmak için 'OK'a basınız.")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        ListeActivity.super.onBackPressed();
                    }
                }).create().show();
    }

    private  void  init()
    {
        iphoneGetir();
    }

    void  iphoneGetir()
    {
        new Service().getServiceApi().iphonelariGetir().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<IphoneModel>>() {

                    List<IphoneModel> iphone=new ArrayList<>();

                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("RETROFIT","onSubscribe : ");
                    }

                    @Override
                    public void onNext(List<IphoneModel> iphoneList) {
                        Log.e("RETROFIT","onNext : ");
                        iphone=iphoneList;
                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.e("RETROFIT","onError : " + e.getLocalizedMessage());
                    }

                    @Override
                    public void onComplete()
                    {
                        Log.e("RETROFIT","onComplete : ");

                        if(iphone.size()>0) {



                            initRecycleView(iphone);
                        }
                    }
                });
    }


    private  void  initRecycleView(List<IphoneModel> iphoneList)
    {
        recyclerView =findViewById(R.id.rcvModeller);
        IphoneAdaptor iphoneAdaptor =new IphoneAdaptor(iphoneList, getApplicationContext(), new IphoneAdaptor.OnItemClickListener() {
            @Override
            public void onClik(int position) {

                IphoneModel tiklananIphone =iphoneList.get(position);
                Toast.makeText(getApplicationContext(), "TIKLANAN ADI : " + tiklananIphone.getIphoneAdi(), Toast.LENGTH_SHORT).show();
                ProgressUtil.getInstance().showProgressDialog((Activity) context);
                opennextActivity(tiklananIphone);
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(iphoneAdaptor);

    }
    private void opennextActivity(IphoneModel tiklananIphone){

        Intent secondActivityIntent=new Intent(getApplicationContext(), IphoneDetayActivity.class);
        String tiklananIphoneString= ObjectUtil.iphoneToJsonString(tiklananIphone);
        secondActivityIntent.putExtra(Constants.TIKANAN_BURC_TASINANIN_BASLIGI,tiklananIphoneString);
        startActivity(secondActivityIntent);

    }


}