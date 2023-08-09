package com.copilot.model;

import java.util.Date;

import lombok.Data;

@Data
public class Package {
    int latitude;
    int longitude;
    int routeId;
    int stopId;
    Date shippingDate;
    Date expectedDelDate;
}
