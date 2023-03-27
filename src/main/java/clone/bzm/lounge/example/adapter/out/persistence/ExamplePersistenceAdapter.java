package clone.bzm.lounge.example.adapter.out.persistence;

import clone.bzm.lounge.example.application.port.out.ExampleLoadPort;
import clone.bzm.lounge.example.application.port.out.ExampleSavePort;
import clone.bzm.lounge.example.domain.Example;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class ExamplePersistenceAdapter implements ExampleLoadPort, ExampleSavePort {

    private final ExampleInMemoryRepository exampleInMemoryRepository;

    @Override
    public List<Example> findAll() {
        return new ArrayList<>(exampleInMemoryRepository.findAll());
    }

    @Override
    public Optional<Example> findById(String id) {
        return exampleInMemoryRepository.findById(id);
    }

    @Override
    public Example save(Example example) {
        return exampleInMemoryRepository.save(example);
    }

    @Override
    public Example deleteById(String id) {
        return exampleInMemoryRepository.deleteById(id);
    }
}
