package clone.bzm.lounge.example.adapter.in.web;

import clone.bzm.lounge.example.application.port.in.ExampleLoadUseCase;
import clone.bzm.lounge.example.application.port.in.ExampleSaveUseCase;
import clone.bzm.lounge.example.domain.Example;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
class ExampleController {

    private final ExampleLoadUseCase exampleLoadUseCase;
    private final ExampleSaveUseCase exampleSaveUseCase;

    @GetMapping("/api/example/{exampleId}")
    ResponseEntity<ExampleResponse> findExample(@PathVariable Long exampleId) {
        Example selected = exampleLoadUseCase.findExample(exampleId);

        return ResponseEntity.ok(ExampleResponse.of(selected));
    }

    @GetMapping("/api/example")
    ResponseEntity<List<ExampleResponse>> findExample() {
        List<Example> selected = exampleLoadUseCase.findExample();

        return ResponseEntity.ok(ExampleResponse.of(selected));
    }

    @PostMapping("/api/example")
    ResponseEntity<ExampleResponse> createExample(@RequestBody @Valid ExampleCreateRequest request,
                                                  UriComponentsBuilder uriComponentsBuilder) {

        Example created = exampleSaveUseCase.saveExample(request.getName());

        URI location = uriComponentsBuilder.path("/api/example/{exampleId}")
                .buildAndExpand(created.getId())
                .toUri();

        return ResponseEntity.created(location)
                .body(ExampleResponse.of(created));
    }

    @DeleteMapping("/api/example/{exampleId}")
    ResponseEntity<ExampleResponse> deleteExample(@PathVariable Long exampleId) {
        Example deleted = exampleSaveUseCase.deleteExample(exampleId);

        return ResponseEntity.ok(ExampleResponse.of(deleted));
    }

    @PutMapping("/api/example/{exampleId}")
    ResponseEntity<ExampleResponse> updateExample(@PathVariable Long exampleId,
                                                  @RequestBody ExampleUpdateRequest request) {

        Example updated = exampleSaveUseCase.updateExample(exampleId, request.getName());

        return ResponseEntity.ok(ExampleResponse.of(updated));
    }
}
