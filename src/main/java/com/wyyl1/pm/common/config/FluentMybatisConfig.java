package com.wyyl1.pm.common.config;

import cn.org.atool.fluent.mybatis.spring.MapperFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class FluentMybatisConfig {

    @Bean
    public MapperFactory mapperFactory() {
        return new MapperFactory();
    }
}
