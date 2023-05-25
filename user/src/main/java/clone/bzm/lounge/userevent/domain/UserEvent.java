package clone.bzm.lounge.userevent.domain;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import org.springframework.core.ResolvableType;
import org.springframework.core.ResolvableTypeProvider;

@Getter
public class UserEvent<T> extends ApplicationEvent implements ResolvableTypeProvider {

    private final T data;

    public UserEvent(@NotNull Object source, @NotNull T data) {
        super(source);
        this.data = data;
    }

    // 제네릭 타입 이벤트는 Listener 에서 KafkaMessageEvent<Object> 로 인식하므로 아래 설정 추가
    @Override
    public ResolvableType getResolvableType() {
        return ResolvableType.forClassWithGenerics(
                getClass(),
                ResolvableType.forInstance(this.data)
        );
    }
}
