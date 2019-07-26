package com.intango.identifier.devices.base;

import com.intango.identifier.enums.DeviceType;
import com.intango.identifier.enums.OS;
import com.intango.identifier.features.Features;
import com.intango.identifier.utils.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SmartTv extends Device {
    private Map<String, String> featuresMap;
    private Features features;

    public SmartTv(Features features) {
        this.features = features;
        setFeatures(features); //init
    }

    @Override
    protected void setOs(OS os) {
        features.setOs(os);
    }

    @Override
    public List<String> getFeatures() {
        return new ArrayList<>(featuresMap.values());
    }

    @Override
    protected void setResolution(String resolution) {
        features.setResolution(resolution);
    }

    @Override
    public String getType() {
        return DeviceType.SMART_TV.name();
    }

    @Override
    public Map<String, String> getFeaturesMap() {
        return featuresMap;
    }

    private void setFeatures(Features features) {
        featuresMap = new ConcurrentHashMap<>();
        featuresMap.put("DeviceType", getType());
        if (Validator.isFieldValid(features.getResolution()) &&
                !features.getResolution().isEmpty() &&
                Validator.isResolutionValid(features.getResolution()))
            featuresMap.put("Resolution", features.getResolution());
        if (Validator.isFieldValid(features.getOs()))
            featuresMap.put("OS", features.getOs().name());
        if (Validator.isFieldValid(features.getScreenSize()))
            featuresMap.put("ScreenSize", features.getScreenSize().name());
        if (Validator.isFieldValid(features.getManufacturer()))
            featuresMap.put("Manufacturer", features.getManufacturer());
    }
}
