package com.hr170011.fatih_arslan_final.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IphoneModel {
    @SerializedName("IphoneAdi")
    @Expose
    private String iphoneAdi;
    @SerializedName("IphoneTarihi")
    @Expose
    private String iphoneTarihi;
    @SerializedName("KapakFotoUrl")
    @Expose
    private String kapakFotoUrl;
    @SerializedName("LogoUrl")
    @Expose
    private String logoUrl;
    @SerializedName("Aciklama")
    @Expose
    private String aciklama;

    public String getIphoneAdi() {
        return iphoneAdi;
    }

    public void setIphoneAdi(String iphoneAdi) {
        this.iphoneAdi = iphoneAdi;
    }

    public String getIphoneTarihi() {
        return iphoneTarihi;
    }

    public void setIphoneTarihi(String iphoneTarihi) {
        this.iphoneTarihi = iphoneTarihi;
    }

    public String getKapakFotoUrl() {
        return kapakFotoUrl;
    }

    public void setKapakFotoUrl(String kapakFotoUrl) {
        this.kapakFotoUrl = kapakFotoUrl;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

}
