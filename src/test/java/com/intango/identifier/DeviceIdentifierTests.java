package com.intango.identifier;

import com.intango.identifier.devices.base.MobilePhone;
import com.intango.identifier.devices.base.SmartTv;
import com.intango.identifier.devices.factories.AbstractDeviceFactory;
import com.intango.identifier.devices.factories.MobilePhoneFactory;
import com.intango.identifier.devices.factories.SmartTvFactory;
import com.intango.identifier.devices.factories.TabletFactory;
import com.intango.identifier.devices.repo.GalaxyS10Plus;
import com.intango.identifier.devices.repo.IphoneX;
import com.intango.identifier.devices.repo.LGTV;
import com.intango.identifier.enums.*;
import com.intango.identifier.features.Features;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DeviceIdentifierTests {
    AbstractDeviceFactory mobilePhoneFactory;
    AbstractDeviceFactory tabletFactory;
    AbstractDeviceFactory smartTvFactory;

    @Before
    public void setUp() {
        mobilePhoneFactory = new MobilePhoneFactory();
        tabletFactory = new TabletFactory();
        smartTvFactory = new SmartTvFactory();
    }

    @Test
    public void CreateDeviceTest() throws Exception {
        MobilePhone galaxyS10Plus = (GalaxyS10Plus) mobilePhoneFactory.create(new Features(OS.ANDROID,
                "RES_140×250", ScreenSize.BIG_SCREEN_SIZE,
                "Samsung", Camera.FRONT_CAMERA, Camera.BACK_CAMERA,
                true, PhoneType.SMART_PHONE), GalaxyS10Plus.class.getSimpleName());

        MobilePhone iphoneX = (IphoneX) mobilePhoneFactory.create(new Features(OS.IOS,
                "RES_1870×2560", ScreenSize.BIG_SCREEN_SIZE,
                "Apple", Camera.FRONT_CAMERA, Camera.BACK_CAMERA,
                true, PhoneType.SMART_PHONE), IphoneX.class.getSimpleName());

        galaxyS10Plus.addNewFeature(galaxyS10Plus.getFeaturesMap(), "Network", "5G");
        System.out.println(galaxyS10Plus.getFeatures());
        System.out.println(iphoneX.getFeatures());
        Assert.assertNotNull(iphoneX);
        Assert.assertNotNull(galaxyS10Plus);
        Assert.assertTrue(iphoneX.getFeatures().contains(Camera.BACK_CAMERA.name()));
        Assert.assertFalse(iphoneX.getFeatures().contains("5G"));
        Assert.assertTrue(galaxyS10Plus.getFeatures().contains("5G"));
    }

    @Test
    public void updateFeaturesTest() throws Exception {
        MobilePhone iphoneX = (IphoneX) mobilePhoneFactory.create(new Features(OS.IOS,
                "RES_1870×2560", ScreenSize.BIG_SCREEN_SIZE,
                "Apple", Camera.FRONT_CAMERA, Camera.BACK_CAMERA,
                true, PhoneType.SMART_PHONE), IphoneX.class.getSimpleName());
        System.out.println("Before update: " + iphoneX.getFeatures());
        iphoneX.updateFeature(iphoneX.getFeaturesMap(),"OS", "OS14");
        Assert.assertTrue(iphoneX.getFeatures().contains(ScreenSize.BIG_SCREEN_SIZE.name()));
        iphoneX.updateFeature(iphoneX.getFeaturesMap(),"ScreenSize", ScreenSize.MEDIUM_SCREEN_SIZE.name());
        Assert.assertFalse(iphoneX.getFeatures().contains(ScreenSize.BIG_SCREEN_SIZE.name()));
        System.out.println("After update: " + iphoneX.getFeatures());
    }

    @Test
    public void getFeaturesListTest() {
        MobilePhone galaxyS10Plus = (GalaxyS10Plus) mobilePhoneFactory.create(new Features(OS.ANDROID,
                "RES_1440×2560", ScreenSize.BIG_SCREEN_SIZE,
                "Samsung", Camera.FRONT_CAMERA, Camera.BACK_CAMERA,
                true, PhoneType.SMART_PHONE), GalaxyS10Plus.class.getSimpleName());
        //[MOBILE_PHONE, FRONT_CAMERA, ANDROID, SMART_PHONE, BACK_CAMERA, Samsung, GYROSCOPE, BIG_SCREEN_SIZE, RES_1440×2560]
        Assert.assertEquals(galaxyS10Plus.getFeatures().size(), 9);
        galaxyS10Plus.removeFeature(galaxyS10Plus.getFeaturesMap(), "FrontCamera");
        Assert.assertEquals(galaxyS10Plus.getFeatures().size(), 8);

    }

    @Test
    public void createSmartTvWithNoPhoneFeaturesTest() {
        SmartTv lgTv = (LGTV) smartTvFactory.create(new Features(OS.ANDROID, "RES_2200x2800", ScreenSize.XL_SCREEN_SIZE,
                "LG", null,
                null, false, null), LGTV.class.getSimpleName());
        Assert.assertFalse(lgTv.getFeatures().contains("SMART_PHONE"));
        Assert.assertTrue(lgTv.getFeatures().contains("SMART_TV"));
        System.out.println(lgTv.getFeatures());
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void emptyDeviceAndExceptionTest() throws Exception {
        MobilePhone galaxyS10Plus = (GalaxyS10Plus) mobilePhoneFactory.create(new Features(), GalaxyS10Plus.class.getSimpleName());
        //since the only feature is mobile phone by default
        Assert.assertEquals(galaxyS10Plus.getFeatures().size(), 1);
        exceptionRule.expect(Exception.class);
        exceptionRule.expectMessage("Network does not exist in device!");
        galaxyS10Plus.removeFeature(galaxyS10Plus.getFeaturesMap(), "Network");
        galaxyS10Plus.addNewFeature(galaxyS10Plus.getFeaturesMap(),"Network", "G5");
        exceptionRule.expectMessage("G5 already exists in device!");
        galaxyS10Plus.addNewFeature(galaxyS10Plus.getFeaturesMap(),"Network", "G5");
    }
}
