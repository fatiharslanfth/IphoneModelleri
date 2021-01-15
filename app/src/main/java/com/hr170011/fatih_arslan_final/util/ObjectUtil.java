package com.hr170011.fatih_arslan_final.util;

import com.google.gson.Gson;
import com.hr170011.fatih_arslan_final.model.IphoneModel;


public class ObjectUtil {

    public  static String iphoneToJsonString(IphoneModel iphoneModel)
    {
        Gson gson = new Gson();
        return   gson.toJson(iphoneModel);
    }

    public  static IphoneModel jsonStringToIphone(String jsonString)
    {
        Gson gson = new Gson();
        return  gson.fromJson(jsonString, IphoneModel.class);
    }
}