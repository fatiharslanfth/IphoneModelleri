package com.hr170011.fatih_arslan_final.util;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Typeface;

public class ProgressUtil {
    private static ProgressUtil util;
    private Typeface typeface;
    private ProgressDialog progressDialog;

    public static ProgressUtil getInstance(){

        if(util == null){
            util = new ProgressUtil();
        }
        return util;
    }

    public void showProgressDialog(Activity activity){

        if(progressDialog != null && progressDialog.isShowing()){
            progressDialog.dismiss();
            progressDialog = null;
        }

        if(progressDialog == null ) {
            progressDialog = new ProgressDialog(activity);
        }
        progressDialog.setMessage("Yükleniyor...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(false);

        if(!activity.isFinishing())
            progressDialog.show();
    }

    public void closeProgressDialog(){
        try {
            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
                progressDialog = null;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
