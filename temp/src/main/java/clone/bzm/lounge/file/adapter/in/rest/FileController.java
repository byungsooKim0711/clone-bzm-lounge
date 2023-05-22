package clone.bzm.lounge.file.adapter.in.rest;

import clone.bzm.lounge.common.ApiResult;
import clone.bzm.lounge.file.adapter.in.rest.dto.FileResponse;
import clone.bzm.lounge.file.application.port.in.FileUseCase;
import clone.bzm.lounge.file.application.port.in.command.FileUploadCommand;
import clone.bzm.lounge.file.domain.File;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import static clone.bzm.lounge.common.ApiResult.succeed;

@RequiredArgsConstructor
@RestController
class FileController {

    private final FileUseCase useCase;

    @PostMapping("/api/v1/attachment/post")
    public ResponseEntity<ApiResult<FileResponse>> uploadPostFile(@RequestBody MultipartFile file) {
        FileUploadCommand command = new FileUploadCommand(
                file
        );


        File uploaded = useCase.save(command);

        return ResponseEntity.ok(
                succeed(FileResponse.of(uploaded))
        );
    }
}
