package clone.bzm.lounge.example.application.port.in;

import clone.bzm.lounge.example.adapter.in.web.dto.ExampleResponse;

import java.util.List;

public interface ExampleLoadUseCase {

    List<ExampleResponse> findExample();
    ExampleResponse findExample(String id);
}
