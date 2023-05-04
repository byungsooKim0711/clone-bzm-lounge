package clone.bzm.lounge.file.adapter.out.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@EntityListeners(AuditingEntityListener.class)
@Entity(name = "tb_file")
@Table(

)
class FileJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", length = 20, nullable = false)
    private String type;

    @Column(name = "path", length = 50, nullable = false)
    private String path;

    @Column(name = "url", length = 80, nullable = false)
    private String url;

    protected FileJpaEntity() {
        /* empty */
    }

    protected FileJpaEntity(String name, String type, String path, String url) {
        this.name = name;
        this.type = type;
        this.path = path;
        this.url = url;
    }

    public static FileJpaEntity from(String name, String type, String path, String url) {
        return new FileJpaEntity(name, type, path, url);
    }

    @CreatedDate
    private LocalDateTime createdAt;

    @CreatedBy
    private Long createdBy;
}
