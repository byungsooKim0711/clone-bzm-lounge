package clone.bzm.lounge.example.application.service;

import clone.bzm.lounge.example.application.port.in.ExampleLoadUseCase;
import clone.bzm.lounge.example.application.port.in.ExampleSaveUseCase;
import clone.bzm.lounge.example.application.port.out.ExampleLoadPort;
import clone.bzm.lounge.example.application.port.out.ExampleSavePort;
import clone.bzm.lounge.example.domain.Example;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ExampleService implements ExampleLoadUseCase, ExampleSaveUseCase {

    private final ExampleLoadPort exampleLoadPort;
    private final ExampleSavePort exampleSavePort;

    @Transactional(readOnly = true)
    @Override
    public List<Example> findExample() {
        return exampleLoadPort.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Example findExample(Long id) {
        return exampleLoadPort.findById(id);
    }

    @Transactional
    @Override
    public Example saveExample(String name) {
        return exampleSavePort.save(Example.withoutId(name));
    }

    @Transactional
    @Override
    public Example deleteExample(Long id) {
        Example selected = exampleLoadPort.findById(id);
        exampleSavePort.deleteById(selected.getId().getValue());

        return selected;
    }

    @Transactional
    @Override
    public Example updateExample(Long id, String name) {
        return exampleSavePort.updateById(id, name);
    }
}
