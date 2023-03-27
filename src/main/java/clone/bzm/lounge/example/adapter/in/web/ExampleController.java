package clone.bzm.lounge.example.adapter.in.web;

import clone.bzm.lounge.example.adapter.in.web.dto.ExampleCreateRequest;
import clone.bzm.lounge.example.adapter.in.web.dto.ExampleResponse;
import clone.bzm.lounge.example.adapter.in.web.dto.ExampleUpdateRequest;
import clone.bzm.lounge.example.application.port.in.ExampleSaveUseCase;
import clone.bzm.lounge.example.application.port.in.ExampleLoadUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class ExampleController {

    private final ExampleLoadUseCase exampleLoadUseCase;
    private final ExampleSaveUseCase exampleSaveUseCase;

    @GetMapping("/api/example/{exampleId}")
    public ResponseEntity<ExampleResponse> findExample(@PathVariable String exampleId) {
        ExampleResponse selected = exampleLoadUseCase.findExample(exampleId);

        return ResponseEntity.ok(selected);
    }

    @GetMapping("/api/example")
    public ResponseEntity<List<ExampleResponse>> findExample() {
        List<ExampleResponse> selected = exampleLoadUseCase.findExample();

        return ResponseEntity.ok(selected);
    }

    @PostMapping("/api/example")
    public ResponseEntity<ExampleResponse> createExample(@RequestBody @Valid ExampleCreateRequest request,
                                                         UriComponentsBuilder uriComponentsBuilder) {

        ExampleResponse created = exampleSaveUseCase.saveExample(request.getName());

        URI location = uriComponentsBuilder.path("/api/example/{exampleId}")
                .buildAndExpand(created.getId())
                .toUri();

        return ResponseEntity.created(location)
                .body(created);
    }

    @DeleteMapping("/api/example/{exampleId}")
    public ResponseEntity<ExampleResponse> deleteExample(@PathVariable String exampleId) {
        ExampleResponse deleted = exampleSaveUseCase.deleteExample(exampleId);

        return ResponseEntity.ok(deleted);
    }

    @PutMapping("/api/example/{exampleId}")
    public ResponseEntity<ExampleResponse> updateExample(@PathVariable String exampleId,
                                                         @RequestBody ExampleUpdateRequest request) {

        ExampleResponse updated = exampleSaveUseCase.updateExample(exampleId, request.getName());

        return ResponseEntity.ok(updated);
    }
}
