package com.wyyl1.pm.adapter.out.persistence.org.platform;

import com.wyyl1.pm.adapter.out.persistence.org.platform.wrapper.PlatformQuery;
import com.wyyl1.pm.domain.org.platform.PlatformRepository;
import com.wyyl1.pm.domain.org.platform.dto.Platform;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class PlatformRepositoryImpl implements PlatformRepository {

    @Override
    public List<Platform> findAll() {
        return new PlatformQuery().selectAll().orderBy().id().asc().end().to().listEntity()
                .stream().map(entity -> new Platform(entity.getId(), entity.getName()))
                .toList();
    }

    @Override
    public Map<Integer, Platform> allPlatforms() {
        return new PlatformQuery().selectAll().to().listEntity()
                .stream().map(entity -> new Platform(entity.getId(), entity.getName()))
                .collect(Collectors.toMap(Platform::getId, platform -> platform));
    }
}
