package com.intango.identifier.features;

import com.intango.identifier.enums.*;

/*
Basic Features for Device
 */
public class Features {
    private OS os;
    private String resolution;
    private ScreenSize screenSize;
    private String manufacturer;
    private Camera frontCamera;
    private Camera backCamera;
    private boolean isGyroscopeInstalled;
    private PhoneType phoneType;

    public Features() {
    }

    public Features(OS os, String resolution, ScreenSize screenSize, String manufacturer,
                    Camera frontCamera, Camera backCamera,
                    boolean isGyroscopeInstalled, PhoneType phoneType) {
        this.os = os;
        this.resolution = resolution;
        this.screenSize = screenSize;
        this.manufacturer = manufacturer;
        this.frontCamera = frontCamera;
        this.backCamera = backCamera;
        this.isGyroscopeInstalled = isGyroscopeInstalled;
        this.phoneType = phoneType;

    }

    public OS getOs() {
        return os;
    }

    public void setOs(OS os) {
        this.os = os;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public ScreenSize getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(ScreenSize screenSize) {
        this.screenSize = screenSize;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Camera getFrontCamera() {
        return frontCamera;
    }

    public void setFrontCamera(Camera frontCamera) {
        this.frontCamera = frontCamera;
    }

    public Camera getBackCamera() {
        return backCamera;
    }

    public void setBackCamera(Camera backCamera) {
        this.backCamera = backCamera;
    }

    public boolean isGyroscopeInstalled() {
        return isGyroscopeInstalled;
    }

    public void setGyroscopeInstalled(boolean gyroscopeInstalled) {
        isGyroscopeInstalled = gyroscopeInstalled;
    }

    public PhoneType getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(PhoneType phoneType) {
        this.phoneType = phoneType;
    }
}
