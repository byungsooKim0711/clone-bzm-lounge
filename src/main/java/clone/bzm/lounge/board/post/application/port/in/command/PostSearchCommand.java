package clone.bzm.lounge.board.post.application.port.in.command;

import java.time.LocalDate;

public record PostSearchCommand(

        /* BZM */
        String serviceType,

        /* EXACT, INCLUDE */
        String keywordMatchOption,
        /* ALL, TITLE, CONTENT, COMMENT */
        String keywordOption,
        String keyword,

        /* CREATED_AT, COMPLETED_AT */
        String dateOption,
        LocalDate startDate,
        LocalDate endDate,

        int currentPage,
        int pageSize,

        /* CREATOR */
        String userOption,
        Long userId,
        String userType
) {
}
