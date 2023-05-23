package clone.bzm.lounge.user.adapter.out.jpa;

import lombok.Getter;

@Getter
enum UserStatus {

    /** 활성화 */
    ACTIVE,

    /** 삭제상태 */
    DELETED,

    /** 휴면상태 */
    DORMANT,

    /** 잠김상태 */
    LOCK,
    ;
}
