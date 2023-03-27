package clone.bzm.lounge.example.application.port.out;

import clone.bzm.lounge.example.domain.Example;

public interface ExampleSavePort {

    Example save(Example example);

    Example deleteById(String id);
}
