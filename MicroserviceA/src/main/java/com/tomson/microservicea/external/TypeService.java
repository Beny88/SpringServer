package com.tomson.microservicea.external;

import com.tomson.microservicea.model.Typeable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeService {

    public List<String> getAllObjectTypes(List<Typeable> typeables) {
        return typeables.stream().map(typeable -> typeable.getType()).collect(Collectors.toList());
    }
}
