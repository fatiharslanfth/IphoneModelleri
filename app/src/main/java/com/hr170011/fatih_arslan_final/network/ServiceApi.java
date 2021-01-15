package com.hr170011.fatih_arslan_final.network;




import com.hr170011.fatih_arslan_final.model.IphoneModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ServiceApi {

    //base url
    //
    @GET("IphoneModelleriApi.json")
    Observable<List<IphoneModel>> iphonelariGetir();
}
