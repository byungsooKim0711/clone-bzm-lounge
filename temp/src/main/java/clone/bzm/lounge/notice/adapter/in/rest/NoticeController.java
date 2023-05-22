package clone.bzm.lounge.notice.adapter.in.rest;

import clone.bzm.lounge.common.ApiResult;
import clone.bzm.lounge.notice.adapter.in.rest.dto.NoticeCreateRequest;
import clone.bzm.lounge.notice.application.port.in.NoticeUseCase;
import clone.bzm.lounge.notice.application.port.in.command.NoticeCreateCommand;
import clone.bzm.lounge.notice.domain.Notice;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpCookie;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

import static clone.bzm.lounge.common.ApiResult.succeed;
import static org.springframework.http.HttpHeaders.SET_COOKIE;

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
        // todo: @CookieValue(value = "popupNotice", required = false) Cookie cookie 쿠키설계
        return ResponseEntity.ok(
                succeed(useCase.getPopupNotice(LocalDate.now()))
        );
    }

    /**
     * 팝업 공지사항 읽음처리
     */
    @PostMapping("/api/v1/notice/popup/{noticeId}")
    ResponseEntity<ApiResult<Void>> readPopupNotice(@PathVariable Long noticeId) {
        HttpCookie cookie = ResponseCookie.from("popupNotice", "" + noticeId)
                .path("/")
                .maxAge(60 * 60 * 24 * 30)
                .httpOnly(true)
                .secure(true)
                .domain("localhost")
                .build();

        return ResponseEntity.ok()
                .header(SET_COOKIE, cookie.toString())
                .body(succeed());
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
                request.fix(),
                request.popup(),
                request.openDate(),
                request.closeDate()
        );

        Notice notice = useCase.createNotice(command);

        URI location = uriComponentsBuilder.path("/api/v1/notice/{noticeId}")
                .buildAndExpand(notice.getId())
                .toUri();

        return ResponseEntity.created(location)
                .body(ApiResult.succeed());
    }
}
