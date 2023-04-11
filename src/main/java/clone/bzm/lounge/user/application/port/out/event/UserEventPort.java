package clone.bzm.lounge.user.application.port.out.event;

public interface UserEventPort {

    void publishSignInEvent(SignInEvent event);
}
