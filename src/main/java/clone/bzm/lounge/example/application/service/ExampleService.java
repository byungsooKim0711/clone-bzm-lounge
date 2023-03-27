package clone.bzm.lounge.example.application.service;

import clone.bzm.lounge.example.adapter.in.web.dto.ExampleResponse;
import clone.bzm.lounge.example.application.port.in.ExampleLoadUseCase;
import clone.bzm.lounge.example.application.port.in.ExampleSaveUseCase;
import clone.bzm.lounge.example.application.port.out.ExampleLoadPort;
import clone.bzm.lounge.example.application.port.out.ExampleSavePort;
import clone.bzm.lounge.example.domain.Example;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ExampleService implements ExampleLoadUseCase, ExampleSaveUseCase {

    private final ExampleLoadPort exampleLoadPort;
    private final ExampleSavePort exampleSavePort;

    @Override
    public List<ExampleResponse> findExample() {
        List<Example> selected = exampleLoadPort.findAll();

        return ExampleResponse.of(selected);
    }

    @Override
    public ExampleResponse findExample(String id) {
        Example selected = exampleLoadPort.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(String.format("Not found id. %s", id)));

        return ExampleResponse.of(selected);
    }

    @Override
    public ExampleResponse saveExample(String name) {
        Example saved = exampleSavePort.save(Example.from(name));

        return ExampleResponse.of(saved);
    }

    @Override
    public ExampleResponse deleteExample(String id) {
        Example selected = exampleLoadPort.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(String.format("Not found id. %s", id)));

        Example deleted = exampleSavePort.deleteById(selected.getId());

        return ExampleResponse.of(deleted);
    }

    @Override
    public ExampleResponse updateExample(String id, String name) {
        Example selected = exampleLoadPort.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(String.format("Not found id. %s", id)));

        selected.updateName(name);
        Example updated = exampleSavePort.save(selected);

        return ExampleResponse.of(updated);
    }
}
