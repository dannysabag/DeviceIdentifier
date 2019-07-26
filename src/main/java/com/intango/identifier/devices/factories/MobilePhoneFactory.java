package com.intango.identifier.devices.factories;

import com.intango.identifier.devices.base.MobilePhone;
import com.intango.identifier.devices.repo.GalaxyS10Plus;
import com.intango.identifier.devices.repo.IphoneX;
import com.intango.identifier.devices.repo.LGG5;
import com.intango.identifier.features.Features;

public class MobilePhoneFactory implements AbstractDeviceFactory {
    @Override
    public MobilePhone create(Features features, String deviceName) {
        switch (deviceName.toLowerCase()) {
            case "galaxys10plus":
                return new GalaxyS10Plus(features);
            case "iphonex":
                return new IphoneX(features);
            case "lgg5":
                return new LGG5(features);
            default:
                System.out.println("No device entered! returning...");
                return null;
        }
    }
}
