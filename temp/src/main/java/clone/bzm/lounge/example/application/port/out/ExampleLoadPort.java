package clone.bzm.lounge.example.application.port.out;

import clone.bzm.lounge.example.domain.Example;

import java.util.List;

public interface ExampleLoadPort {

    List<Example> findAll();

    Example findById(Long id);
}
