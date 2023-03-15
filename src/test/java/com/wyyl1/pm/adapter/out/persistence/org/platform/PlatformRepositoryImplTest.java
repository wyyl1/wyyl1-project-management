package com.wyyl1.pm.adapter.out.persistence.org.platform;

import com.wyyl1.pm.domain.org.platform.PlatformRepository;
import com.wyyl1.pm.domain.org.platform.dto.Platform;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import test.BaseTest;

import javax.annotation.Resource;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PlatformRepositoryImplTest extends BaseTest {

    @Resource
    private PlatformRepository repository;

    @DisplayName("获得所有平台列表")
    @Nested
    class FindAll {

        @DisplayName("总数为 3")
        @Test
        void count_is_3() {
            int size = repository.findAll().size();

            assertThat(size).isEqualTo(3);
        }

        @DisplayName("检查 id、name 是正确的")
        @ParameterizedTest
        @CsvSource({"1,Web","2,安卓","3,苹果"})
        void check_id_name(int id, String name) {
            var platform = repository.findAll().stream().filter(p -> p.getId() == id).findFirst().get();

            assertThat(platform.getName()).isEqualTo(name);
        }
    }

    @DisplayName("获得所有平台 Map")
    @Nested
    class AllPlatforms {
        @DisplayName("检查 id、name 是正确的")
        @ParameterizedTest
        @CsvSource({"1,Web","2,安卓","3,苹果"})
        void check_id_name(int id, String name) {
            Map<Integer, Platform> platforms = repository.allPlatforms();

            assertThat(platforms.get(id).getName()).isEqualTo(name);
        }
    }

}