package clone.bzm.lounge.user.adapter.out.jpa;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Entity(name = "tb_user_login_history")
@Table()
class UserLoginHistoryJpaEntity {

    /** PK */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 로그인 한 ID */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_user_login_history_to_user"))
    private UserJpaEntity user;

    /** OS/기기 등 */
    @Column(name = "device", nullable = false, length = 30)
    private String device;

    /** 접속 IP */
    @Column(name = "ip", nullable = false, length = 15)
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

    protected UserLoginHistoryJpaEntity() {
        /* empty */
    }

    protected UserLoginHistoryJpaEntity(UserJpaEntity user, String device, String ip, String service, String type) {
        this.user = user;
        this.device = device;
        this.ip = ip;
        this.service = service;
        this.type = type;
        this.loginAt = LocalDateTime.now();
    }

    public static UserLoginHistoryJpaEntity from(UserJpaEntity user,
                                                 String device,
                                                 String ip,
                                                 String service,
                                                 String type) {
        return new UserLoginHistoryJpaEntity(user, device,ip, service,type);
    }
}
