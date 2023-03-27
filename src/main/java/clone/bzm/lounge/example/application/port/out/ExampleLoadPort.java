package clone.bzm.lounge.example.application.port.out;

import clone.bzm.lounge.example.domain.Example;

import java.util.List;
import java.util.Optional;

public interface ExampleLoadPort {

    List<Example> findAll();
    Optional<Example> findById(String id);
}
