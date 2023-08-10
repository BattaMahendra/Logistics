package com.copilot.service;




import java.util.Date;

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

    public boolean isPackageDeliveredSuccessfully(Package pkg) {
        Date newDate=new Date();
        if(newDate.after(pkg.getShippingDate()) && newDate.after(pkg.getExpectedDelDate()))
            return true;
        else if(newDate.after(pkg.getShippingDate()) && newDate.before(pkg.getExpectedDelDate())){
            return false;
        }else{
            return false;
        }
    }

    public Double findCostOfPackage(Package pkg) {
        Double selldiscount = (pkg.getCostPrice()*pkg.getDiscount())/100;
        Double bankDiscount=(pkg.getCostPrice()*pkg.getBankDiscount())/100;
        if(bankDiscount>1500){
            bankDiscount=1500.0;
        }
        Double finalPrice=pkg.getCostPrice()-(selldiscount+bankDiscount+pkg.getExchangePrice()>5000?5000:5000);
        return finalPrice;
    }
    
}
