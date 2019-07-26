package com.intango.identifier.devices.factories;

import com.intango.identifier.features.Features;

public interface AbstractDeviceFactory<T> {
    T create(Features features, String deviceName);
}
