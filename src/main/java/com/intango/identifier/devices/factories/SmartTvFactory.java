package com.intango.identifier.devices.factories;

import com.intango.identifier.devices.base.SmartTv;
import com.intango.identifier.devices.repo.LGTV;
import com.intango.identifier.devices.repo.SonyTv;
import com.intango.identifier.features.Features;

public class SmartTvFactory implements AbstractDeviceFactory {
    @Override
    public SmartTv create(Features features, String deviceName) {
        switch (deviceName.toLowerCase()) {
            case "sonytv":
                return new SonyTv(features);
            case "lgtv":
                return new LGTV(features);
            default:
                System.out.println("No device entered! returning...");
                return null;
        }
    }
}
