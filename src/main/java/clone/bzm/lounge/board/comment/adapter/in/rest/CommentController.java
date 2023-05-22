package clone.bzm.lounge.board.comment.adapter.in.rest;

import clone.bzm.lounge.common.ApiResult;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static clone.bzm.lounge.common.ApiResult.succeed;

@RequiredArgsConstructor
@RestController
class CommentController {

    @GetMapping("/api/v1/post/{postId}/comment")
    public ResponseEntity<ApiResult<?>> searchComment(@PathVariable Long postId) {

        return ResponseEntity.ok(
                succeed()
        );
    }

    @PostMapping("/api/v1/post/{postId}/comment")
    public ResponseEntity<ApiResult<?>> addComment(@PathVariable Long postId,
                                                   @Valid @RequestBody Object request) {
        throw new UnsupportedOperationException();
    }
}
