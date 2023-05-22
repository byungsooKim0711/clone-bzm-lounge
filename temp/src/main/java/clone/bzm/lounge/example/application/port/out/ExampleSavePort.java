package clone.bzm.lounge.example.application.port.out;

import clone.bzm.lounge.example.domain.Example;

public interface ExampleSavePort {

    Example save(Example example);

    void deleteById(Long id);

    Example updateById(Long id, String name);
}
