package clone.bzm.lounge.example.application.port.in;

import clone.bzm.lounge.example.adapter.in.web.dto.ExampleResponse;

public interface ExampleSaveUseCase {

    ExampleResponse saveExample(String name);
    ExampleResponse deleteExample(String id);
    ExampleResponse updateExample(String id, String name);
}
