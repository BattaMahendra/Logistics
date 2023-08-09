package com.copilot.service;


import com.copilot.model.Package;
import com.copilot.model.Stop;
import com.copilot.model.StopList;

public class PackageService {

    public Stop stopNearToPackageDelivered(StopList stopList, Package pkg) {

       Stop finalStop= stopList.getStops().stream().map(stop -> 
        {
            if(stop.getStopId() == pkg.getStopId()){
                stop.setDistance(0);
            }
            else if(stop.getLat() == pkg.getLatitude() && stop.getLon() == pkg.getLongitude()){
                stop.setDistance(0);
            }
            else if(stop.getLat()> pkg.getLatitude() && stop.getLon() > pkg.getLongitude()){
                stop.setDistance((stop.getLat() - pkg.getLatitude()) + (stop.getLon() - pkg.getLongitude()));
            }
            return stop;
        }).max((stop1, stop2) -> stop1.getDistance() > stop2.getDistance() ? 1 : -1).get();
        
        return finalStop;

    }
    
}
