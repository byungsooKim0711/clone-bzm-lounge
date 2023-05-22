package clone.bzm.lounge.example.application.port.in;

import clone.bzm.lounge.example.domain.Example;

public interface ExampleSaveUseCase {

    Example saveExample(String name);

    Example deleteExample(Long id);

    Example updateExample(Long id, String name);
}
