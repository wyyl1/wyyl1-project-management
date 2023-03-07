package com.wyyl1.pm.adapter.out.persistence.org.platform;

import com.wyyl1.pm.adapter.out.persistence.org.platform.wrapper.PlatformQuery;
import com.wyyl1.pm.domain.org.platform.PlatformRepository;
import com.wyyl1.pm.domain.org.platform.dto.Platform;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlatformRepositoryImpl implements PlatformRepository {

    @Override
    public List<Platform> findAll() {
        return new PlatformQuery().selectAll().orderBy().id().asc().end().to().listEntity()
                .stream().map(entity -> new Platform(entity.getId(), entity.getName()))
                .toList();
    }
}
