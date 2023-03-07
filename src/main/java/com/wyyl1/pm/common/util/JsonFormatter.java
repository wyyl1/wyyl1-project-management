package com.wyyl1.pm.common.util;


import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONWriter;
import lombok.experimental.UtilityClass;

@UtilityClass
public class JsonFormatter {

    public static final String beautify(Object o) {
        return JSON.toJSONString(o, JSONWriter.Feature.PrettyFormat);
    }

    public static final String minify(Object o) {
        return JSON.toJSONString(o);
    }
}
