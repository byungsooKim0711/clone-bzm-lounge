package clone.bzm.lounge.notice.adapter.in.rest;

import clone.bzm.lounge.common.ApiResult;
import clone.bzm.lounge.notice.adapter.in.rest.dto.NoticeCreateRequest;
import clone.bzm.lounge.notice.application.port.in.NoticeUseCase;
import clone.bzm.lounge.notice.application.port.in.command.NoticeCreateCommand;
import clone.bzm.lounge.notice.domain.Notice;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static clone.bzm.lounge.common.ApiResult.succeed;

@RequiredArgsConstructor
@RestController
class NoticeController {

    private final NoticeUseCase useCase;

    /**
     * 공지사항 조회 (리스트)
     */
    @GetMapping("/api/v1/notice")
    ResponseEntity<ApiResult<List<?>>> notice() {
        return ResponseEntity.ok(
                succeed(useCase.getNotice())
        );
    }

    /**
     * 공지사항 조회 (단건)
     */
    @GetMapping("/api/v1/notice/{noticeId}")
    ResponseEntity<ApiResult<?>> notice(@PathVariable Long noticeId) {
        return ResponseEntity.ok(
                succeed(useCase.getNotice(noticeId))
        );
    }

    /**
     * 팝업 공지사항 조회 (리스트)
     */
    @GetMapping("/api/v1/notice/popup")
    ResponseEntity<ApiResult<List<?>>> popupNotice() {
        throw new UnsupportedOperationException();
    }


    /**
     * 공지사항 등록
     */
    @PostMapping("/api/v1/notice")
    ResponseEntity<ApiResult<?>> createNotice(@RequestBody @Valid NoticeCreateRequest request,
                                              UriComponentsBuilder uriComponentsBuilder) {
        NoticeCreateCommand command = new NoticeCreateCommand(
                request.title(),
                request.content(),
                request.fix()
        );

        Notice notice = useCase.createNotice(command);

        URI location = uriComponentsBuilder.path("/api/v1/notice/{noticeId}")
                .buildAndExpand(notice.getId())
                .toUri();

        return ResponseEntity.created(location)
                .body(ApiResult.succeed());
    }
}
