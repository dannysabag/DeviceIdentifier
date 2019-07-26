package com.intango.identifier.utils;

import java.util.regex.Pattern;

/*
An extensible util for future validations
 */
public class Validator {
    final static String resolutionPattern = "(.*)(\\d+)(.*)";
    public static boolean isFieldValid(Object object) {
        return object != null;
    }

    public static boolean isResolutionValid(String resolution) {
       return resolution.startsWith("RES") && Pattern.matches(resolutionPattern, resolution);
    }
}
