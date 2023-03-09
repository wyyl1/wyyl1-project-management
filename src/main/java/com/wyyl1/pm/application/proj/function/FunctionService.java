package com.wyyl1.pm.application.proj.function;

import com.wyyl1.pm.domain.proj.function.FunctionRepository;
import com.wyyl1.pm.domain.proj.function.pojo.dto.Function;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FunctionService {

    private FunctionRepository repository;

    public final void save(Function function) {
        repository.save(function);
    }
}
