package com.wyyl1.pm.domain.org.platform;

import com.wyyl1.pm.domain.org.platform.dto.Platform;

import java.util.List;
import java.util.Map;

public interface PlatformRepository {

    List<Platform> findAll();

    Map<Integer, Platform> allPlatforms();
}
