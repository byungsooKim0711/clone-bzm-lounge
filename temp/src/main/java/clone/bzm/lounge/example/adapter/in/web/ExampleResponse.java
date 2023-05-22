package clone.bzm.lounge.example.adapter.in.web;

import clone.bzm.lounge.example.domain.Example;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
class ExampleResponse {

    private Long id;

    private String name;

    @Builder
    ExampleResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    static ExampleResponse of(Example example) {
        return ExampleResponse.builder()
                .id(example.getId().getValue())
                .name(example.getName())
                .build();
    }

    static List<ExampleResponse> of(List<Example> examples) {
        return examples.stream()
                .map(ExampleResponse::of)
                .collect(Collectors.toList());
    }
}
