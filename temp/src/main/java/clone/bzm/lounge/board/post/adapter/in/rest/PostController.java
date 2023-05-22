package clone.bzm.lounge.board.post.adapter.in.rest;

import clone.bzm.lounge.board.domain.Post;
import clone.bzm.lounge.board.post.adapter.in.rest.dto.PostCreateRequest;
import clone.bzm.lounge.board.post.adapter.in.rest.dto.PostSearchListResponse;
import clone.bzm.lounge.board.post.adapter.in.rest.dto.PostSearchRequest;
import clone.bzm.lounge.board.post.application.port.in.PostSaveUseCase;
import clone.bzm.lounge.board.post.application.port.in.PostSearchUseCase;
import clone.bzm.lounge.board.post.application.port.in.command.PostCreateCommand;
import clone.bzm.lounge.board.post.application.port.in.command.PostSearchCommand;
import clone.bzm.lounge.common.ApiResult;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static clone.bzm.lounge.common.ApiResult.succeed;

@RequiredArgsConstructor
@RestController
class PostController {

    private final PostSearchUseCase searchUseCase;
    private final PostSaveUseCase saveUseCase;

    /*
     * 게시글 리스트 조회
     */
    @GetMapping("/api/v1/post")
    public ResponseEntity<ApiResult<?>> searchPost(@Valid PostSearchRequest request) {
        PostSearchCommand command = new PostSearchCommand(
                request.getServiceType(),

                request.getKeywordMatchOption(),
                request.getKeywordOption(),
                request.getKeyword(),

                request.getDateOption(),
                request.getStartDate(),
                request.getEndDate(),

                request.getCurrentPage(),
                request.getPageSize(),

                request.getUserOption(),
                request.getUserId(),
                request.getUserType()
        );

        List<Post> post = searchUseCase.searchPost(command);

        return ResponseEntity.ok(
                succeed(PostSearchListResponse.of(post))
        );
    }

    // 게시글 상세 조회
    @GetMapping("/api/v1/post/{postId}")
    public ResponseEntity<ApiResult<?>> searchPost(@PathVariable Long postId) {
        Post post = searchUseCase.searchPost(postId);

        return ResponseEntity.ok(
                succeed(post)
        );
    }

    /*
     * 게시글 등록
     */
    @PostMapping("/api/v1/post")
    public ResponseEntity<ApiResult<?>> createPost(@Valid @RequestBody PostCreateRequest request) {
        PostCreateCommand command = new PostCreateCommand(
                request.getTitle(),
                request.getContent(),
                request.isPrivacy(),
                request.getAttachmentIds(),
                request.getMentionedUserIds()
        );

        saveUseCase.createPost(command);


        return null;
    }

    // 게시글
}
