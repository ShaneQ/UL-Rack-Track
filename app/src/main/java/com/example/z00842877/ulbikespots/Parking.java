package com.example.z00842877.ulbikespots;

import java.util.HashSet;

public class Parking {
    private double latitude;
    private double longitude;
    private String location;
    private boolean coverage;
    private boolean secure;
    private String user;
    private boolean shower;

    public static void main(String[]args) {
        HashSet<Parking> parkingspots = new HashSet<>();
        parkingspots.add(new Parking("KBS Back", "ALL", 52.67246556, -8.577017782, false, false, true));
        parkingspots.add(new Parking("KBS Front", "ALL", 52.67272578, -8.577339647, false, false, true));
        parkingspots.add(new Parking("CSIS Carpark", "ALL", 52.67436516, -8.575156329, false, false, false));
        parkingspots.add(new Parking("Foundation Carpark", "STAFF", 52.67457334, -8.57491493, true, true, true));
        parkingspots.add(new Parking("ERG Carpark", "STAFF", 52.67542553, -8.573032019, true, true, true));
        parkingspots.add(new Parking("Stokes Research Institute", "ALL", 52.67484005, -8.572710154, true, false, true));
        parkingspots.add(new Parking("Library Entrance", "ALL", 52.67338284, -8.573176858, false, false, true));
        parkingspots.add(new Parking("Sundial", "ALL", 52.6733308, -8.571438787, false, false, false));
        parkingspots.add(new Parking("Visitor Carpark", "VISITOR", 52.67302178, -8.571642635, false, false, false));
        parkingspots.add(new Parking("Student Union", "ALL", 52.67332755, -8.570135233, true, false, false));
        parkingspots.add(new Parking("Analog Devices", "ALL", 52.67306732, -8.568869231, false, false, false));
        parkingspots.add(new Parking("Arena Carpark", "ALL", 52.6728689, -8.56509268, true, false, true));
        parkingspots.add(new Parking("Arena", "ALL", 52.67326249, -8.564985392, false, false, true));
        parkingspots.add(new Parking("PESS", "ALL", 52.67442209, -8.568005559, false, false, true));
        parkingspots.add(new Parking("Health Sciences", "ALL", 52.67766814, -8.569266198, false, false, true));
        parkingspots.add(new Parking("Irish World Academy", "ALL", 52.67823081, -8.569700715, false, false, true));
        parkingspots.add(new Parking("Graduate Medical School", "ALL", 52.67823406, -8.568080661, false, false, true));
        parkingspots.add(new Parking("Pavillion", "ALL", 52.67872517, -8.569867012, false, false, true));
        parkingspots.add(new Parking("Schuman", "ALL", 52.67356012, -8.577715156, false, false, true));
        for (Parking x : parkingspots){
            System.out.println(x.getLatitude());
        }
    }

    public Parking(String loc,String User, double lat, double lon,
                    boolean coverage, boolean secure, boolean shower){
        this.location = loc;
        this.user = User;
        this.latitude = lat;
        this.longitude = lon;
        this.coverage = coverage;
        this.secure = secure;
        this.shower = shower;
    }
    public String getLocation(){
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

}
