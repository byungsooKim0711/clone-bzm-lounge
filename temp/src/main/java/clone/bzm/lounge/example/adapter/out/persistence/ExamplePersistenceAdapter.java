package clone.bzm.lounge.example.adapter.out.persistence;

import clone.bzm.lounge.example.application.port.out.ExampleLoadPort;
import clone.bzm.lounge.example.application.port.out.ExampleSavePort;
import clone.bzm.lounge.example.domain.Example;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
class ExamplePersistenceAdapter implements ExampleLoadPort, ExampleSavePort {

    private final ExampleJpaRepository exampleJpaRepository;

    @Override
    public List<Example> findAll() {
        List<ExampleJpaEntity> selected = exampleJpaRepository.findAll();

        return selected.stream()
                .map(e -> Example.withId(Example.ExampleId.of(e.getId()), e.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public Example findById(Long id) {
        ExampleJpaEntity selected = exampleJpaRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        return Example.withId(
                Example.ExampleId.of(selected.getId()),
                selected.getName()
        );
    }

    @Override
    public Example save(Example example) {
        ExampleJpaEntity saved = ExampleMapper.mapToJpaEntity(example);
        saved = exampleJpaRepository.save(saved);

        return ExampleMapper.mapToDomainEntity(saved);
    }

    @Override
    public void deleteById(Long id) {
        exampleJpaRepository.deleteById(id);
    }

    @Override
    public Example updateById(Long id, String name) {
        ExampleJpaEntity updated = exampleJpaRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        updated.updateName(name);

        return ExampleMapper.mapToDomainEntity(updated);
    }
}
