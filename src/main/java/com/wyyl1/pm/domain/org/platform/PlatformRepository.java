package com.wyyl1.pm.domain.org.platform;

import com.wyyl1.pm.domain.org.platform.dto.Platform;

import java.util.List;

public interface PlatformRepository {

    List<Platform> findAll();
}
