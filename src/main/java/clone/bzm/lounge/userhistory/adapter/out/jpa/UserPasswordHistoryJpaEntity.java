package clone.bzm.lounge.userhistory.adapter.out.jpa;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Entity(name = "tb_user_password_history")
@Table(
        indexes = {
                @Index(name = "idx_user_id_on_user_password_history", columnList = "user_id")
        }
)
class UserPasswordHistoryJpaEntity {

    /**
     * PK
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 로그인 한 유저 ID
     */
    @Column(name = "user_id", nullable = false)
    private Long userId;

    /**
     * 비밀번호 변경 시간 (테이블에 insert 된 시간 아님)
     */
    @Column(name = "password_modified_at")
    private LocalDateTime passwordModifiedAt;

    protected UserPasswordHistoryJpaEntity() {
        /* empty */
    }

    protected UserPasswordHistoryJpaEntity(Long userId, LocalDateTime passwordModifiedAt) {
        this.userId = userId;
        this.passwordModifiedAt = passwordModifiedAt;
    }

    public static UserPasswordHistoryJpaEntity from(Long userId, LocalDateTime passwordModifiedAt) {
        return new UserPasswordHistoryJpaEntity(userId, passwordModifiedAt);
    }
}
