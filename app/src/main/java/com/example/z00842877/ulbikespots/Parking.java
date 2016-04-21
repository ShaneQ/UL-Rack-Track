package com.example.z00842877.ulbikespots;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;

import java.util.HashSet;

public class Parking {
    private double latitude;
    private double longitude;
    private String location;
    private boolean coverage;
    private boolean secure;
    private String user;
    private boolean shower;
    private float color;

    public Parking(String loc,String User, double lat, double lon,
                    boolean coverage, boolean secure, boolean shower){
        this.location = loc;
        this.user = User;
        this.latitude = lat;
        this.longitude = lon;
        this.coverage = coverage;
        this.secure = secure;
        this.shower = shower;
        if(User.equalsIgnoreCase("Visitor")){
            this.color = BitmapDescriptorFactory.HUE_AZURE;
        }else if (User.equalsIgnoreCase("ALL")) {
            this.color = BitmapDescriptorFactory.HUE_GREEN;
        }else{
            this.color = BitmapDescriptorFactory.HUE_RED;
        }
    }
    public String getLocation(){
        return this.location;
    }
    public String getBuildingName(){
        return this.location;
    }
    public String getUserType(){
        return this.user;
    }
    public double getLatitude(){
        return this.latitude;
    }
    public double getLongitude(){
        return this.longitude;
    }
    public boolean isCovered(){
        return this.coverage;
    }
    public boolean isSecure(){
        return this.secure;
    }
    public boolean hasShower(){
        return this.shower;
    }
    public float getColor(){
        return this.color;
    }
    public String toString(){
        String test="";
        if(this.coverage){
            test+="-Is Covered ";
        }
        if(this.secure){
            test+="-Is Secure";
        }
        if(this.shower){
            test+="-Has Shower";
        }
        return test;
    }

}
