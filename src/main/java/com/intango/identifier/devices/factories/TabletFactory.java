package com.intango.identifier.devices.factories;

import com.intango.identifier.devices.base.Tablet;
import com.intango.identifier.devices.repo.AsusTablet;
import com.intango.identifier.devices.repo.IpdaPro;
import com.intango.identifier.features.Features;

public class TabletFactory implements AbstractDeviceFactory {
    @Override
    public Tablet create(Features features, String deviceName) {
        switch (deviceName.toLowerCase()) {
            case "ipadpro":
                return new IpdaPro(features);
            case "asustablet":
                return new AsusTablet(features);
            default:
                System.out.println("No device entered! returning...");
                return null;
        }
    }
}
