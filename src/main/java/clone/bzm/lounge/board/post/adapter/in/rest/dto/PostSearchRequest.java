package clone.bzm.lounge.board.post.adapter.in.rest.dto;


/*
 * 게시글 리스트 조회
 * 조건
 *   - serviceType=BZM
 *   - keywordMatchOption=EXACT,INCLUDE
 *   - keywordOption=ALL,TITLE,CONTENT,COMMENT
 *   - keyword=''
 *   - dateOption=CREATED_AT,COMPLETED_AT
 *   - startDate=2023-05-08
 *   - endDate=2023-05-08
 *   - currentPage=1
 *   - pageSize=10
 *   - includeMigrationData=false
 *   - isAdminQuestion=true
 *   - userOption=CREATOR
 *   - userId=4609
 *   - userType=U
 */

import lombok.Data;

import java.time.LocalDate;

@Data
public class PostSearchRequest {

    private String serviceType = "BZM";

    private String keywordMatchOption = "EXACT";
    private String keywordOption = "ALL";
    private String keyword;

    private String dateOption = "CREATED_AT";
    private LocalDate startDate;
    private LocalDate endDate;

    private int currentPage = 1;
    private int pageSize = 10;

    private String userOption;
    private Long userId;
    private String userType;
}
