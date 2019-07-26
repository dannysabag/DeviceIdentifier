package com.intango.identifier.devices.base;

import com.intango.identifier.enums.OS;
import com.sun.istack.internal.NotNull;

import java.util.List;
import java.util.Map;

/*
Base class for all devices, contains the mandatory methods
 */
public abstract class Device {

    protected abstract void setOs(OS os);

    public abstract List<String> getFeatures();

    protected abstract void setResolution(String resolution);

    public abstract String getType();

    public abstract Map<String, String> getFeaturesMap();

    @NotNull
    public void addNewFeature(Map<String, String> featuresMap, String featureKey, String featureValue) throws Exception {
        if (!featuresMap.containsKey(featureKey))
            featuresMap.put(featureKey, featureValue);
        else
            throw new Exception(featureKey + " already exists in device!");
    }

    @NotNull
    public void updateFeature(Map<String, String> featuresMap, String featureKey, String featureValue) throws Exception {
        featuresMap.put(featureKey, featureValue);
    }

    @NotNull
    public void removeFeature(Map<String, String> featuresMap, String featureKey) {
        if (!featuresMap.containsKey(featureKey)) {
            throw new IllegalArgumentException(featureKey + " does not exist in device!");
        }
        featuresMap.remove(featureKey);
    }
}
