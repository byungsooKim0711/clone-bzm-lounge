package clone.bzm.lounge.userhistory.adapter.out.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@EntityListeners(AuditingEntityListener.class)
@Entity(name = "tb_user_login_history")
@Table(
        indexes = {
                @Index(name = "idx_sign_in_user_id_on_user_login_history", columnList = "sign_in_user_id")
        }
)
class UserSignInHistoryJpaEntity {

    /** PK */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 로그인 한 유저 ID */
    @Column(name = "sign_in_user_id", nullable = false)
    private Long signInUserId;

    /** OS/기기 등 */
    @Column(name = "device", nullable = false, length = 255)
    private String device;

    /** 접속 IP */
    @Column(name = "ip", nullable = false, length = 39)
    private String ip;

    /** 서비스 URL? */
    @Column(name = "service", nullable = false, length = 50)
    private String service;

    /** 로그인 타입 (카카오톡 로그인, QR 로그인 등) */
    @Column(name = "type")
    private String type;

    /** 접속일시 */
    @Column(name = "login_at", nullable = false)
    private LocalDateTime loginAt;

    /** 생성일시 */
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    protected UserSignInHistoryJpaEntity() {
        /* empty */
    }

    protected UserSignInHistoryJpaEntity(Long signInUserId, String device, String ip, String service, String type) {
        this.signInUserId = signInUserId;
        this.device = device;
        this.ip = ip;
        this.service = service;
        this.type = type;
        this.loginAt = LocalDateTime.now();
    }

    public static UserSignInHistoryJpaEntity from(Long signInUserId,
                                                  String device,
                                                  String ip,
                                                  String service,
                                                  String type) {
        return new UserSignInHistoryJpaEntity(signInUserId, device,ip, service,type);
    }
}
