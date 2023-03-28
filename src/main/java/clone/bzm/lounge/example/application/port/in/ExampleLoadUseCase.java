package clone.bzm.lounge.example.application.port.in;

import clone.bzm.lounge.example.domain.Example;

import java.util.List;

public interface ExampleLoadUseCase {

    List<Example> findExample();

    Example findExample(Long id);
}
