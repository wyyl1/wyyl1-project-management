package com.wyyl1.pm.common.util;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public class ListUtils {

    public static final List<Integer> integersFor(String numbersSplitByComma) {
        if (StringUtils.isBlank(numbersSplitByComma)) {
            return List.of();
        }

        String[] strings = StringUtils.split(numbersSplitByComma, ",");

        return Arrays.stream(strings).map(Integer::valueOf).toList();
    }
}
