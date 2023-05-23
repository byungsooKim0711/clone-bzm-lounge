package clone.bzm.lounge.user.adapter.out.jpa;


import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@EntityListeners(AuditingEntityListener.class)
@Entity(name = "tb_user")
@Table(
        uniqueConstraints = {
                @UniqueConstraint(name = "unq_user_on_email", columnNames = {"email"})
        }
)
class UserJpaEntity {

    /** PK */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 로그인 이메일 */
    @Embedded
    private UserEmail email;

    /** 비밀번호 */
    @Column(name = "password", nullable = false, length = 90)
    private String password;

    /** 이름 */
    @Column(name = "name", nullable = false, length = 10)
    private String name;

    /** 전화번호 */
    @Column(name = "phone_number", nullable = false, length = 20)
    private String phoneNumber;

    /** 계정 상태 (잠김(LOCK)/활성화(ACTIVE)/삭제(DELETED)/휴면(DORMANT) 등) */
    @Column(name = "status", nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    /** 계정 생성일시 */
    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    /** 계정 수정일시 */
    @LastModifiedDate
    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;

    protected UserJpaEntity() {
        /* empty */
    }

    protected UserJpaEntity(UserEmail email, String password, String name, String phoneNumber) {
        // check validation

        this.email = email;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;

        this.status = UserStatus.ACTIVE;
    }

    public static UserJpaEntity from(UserEmail email, String password, String name, String phoneNumber) {
        return new UserJpaEntity(email, password, name, phoneNumber);
    }

    public UserJpaEntity changePassword(String securedPassword) {
        this.password = securedPassword;
        return this;
    }
}
