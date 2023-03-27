package clone.bzm.lounge.example.adapter.in.web.dto;

import clone.bzm.lounge.example.domain.Example;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ExampleResponse {

    private String id;

    private String name;

    @Builder
    protected ExampleResponse(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public static ExampleResponse of(Example example) {
        return ExampleResponse.builder()
                .id(example.getId())
                .name(example.getName())
                .build();
    }

    public static List<ExampleResponse> of(List<Example> examples) {
        return examples.stream()
                .map(ExampleResponse::of)
                .collect(Collectors.toList());
    }
}
