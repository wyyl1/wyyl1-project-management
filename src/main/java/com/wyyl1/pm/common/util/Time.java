package com.wyyl1.pm.common.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Time {

    public static long now() {
        return System.currentTimeMillis();
    }
}
