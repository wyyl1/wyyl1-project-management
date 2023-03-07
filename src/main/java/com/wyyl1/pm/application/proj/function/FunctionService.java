package com.wyyl1.pm.application.proj.function;

import com.wyyl1.pm.domain.proj.function.FunctionRepository;
import com.wyyl1.pm.domain.proj.function.dto.Function;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FunctionService {

    private FunctionRepository repository;

    public final Integer save(Function function) {
        return repository.save(function);
    }
}
