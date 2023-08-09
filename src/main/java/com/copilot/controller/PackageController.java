package com.copilot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.copilot.model.Package;
import com.copilot.model.Stop;
import com.copilot.model.StopList;
import com.copilot.service.PackageService;

public class PackageController {

    @Autowired
    PackageService service;

    @RequestMapping(value = "/stopNearToPackageDelivered", method = RequestMethod.POST)
    public Stop stopNearToPackageDelivered(@RequestBody StopList stopList,@RequestBody Package pkg){
        //create service class for finding nearest stop
        return service.stopNearToPackageDelivered(stopList, pkg);
 
    }

    @RequestMapping(value = "/isPackageDeliveredSuccessfully", method = RequestMethod.POST)
    public boolean isPackageDeliveredSuccessfully(Package pkg){
        return service.isPackageDeliveredSuccessfully(pkg);
    }
}
