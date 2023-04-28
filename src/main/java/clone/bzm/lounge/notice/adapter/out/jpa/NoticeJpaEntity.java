package clone.bzm.lounge.notice.adapter.out.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@EntityListeners(AuditingEntityListener.class)
@Entity(name = "tb_notice")
@Table(

)
class NoticeJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "fix")
    private boolean fix;

    @Embedded
    private NoticePopup noticePopup;

    protected NoticeJpaEntity() {
        /* empty */
    }

    protected NoticeJpaEntity(Long categoryId, String title, String content, boolean fix, NoticePopup noticePopup) {
        this.categoryId = categoryId;
        this.title = title;
        this.content = content;
        this.fix = fix;
        this.noticePopup = noticePopup;
    }

    public static NoticeJpaEntity of(Long categoryId, String title, String content, boolean fix, NoticePopup noticePopup) {
        return new NoticeJpaEntity(categoryId, title, content, fix, noticePopup);
    }

    @Column(name = "created_by")
    @CreatedBy
    private Long createdBy;

    @Column(name = "modified_by")
    @LastModifiedBy
    private Long modifiedBy;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "modified_at")
    @LastModifiedDate
    private LocalDateTime modifiedAt;
}

