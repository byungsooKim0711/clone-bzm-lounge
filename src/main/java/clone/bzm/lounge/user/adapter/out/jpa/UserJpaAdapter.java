package clone.bzm.lounge.user.adapter.out.jpa;

import clone.bzm.lounge.configuration.exception.NoMatchedPasswordException;
import clone.bzm.lounge.configuration.exception.NotFoundUserException;
import clone.bzm.lounge.user.application.port.in.command.ChangePasswordCommand;
import clone.bzm.lounge.user.application.port.in.command.SignUpCommand;
import clone.bzm.lounge.user.application.port.out.jpa.UserLoadPort;
import clone.bzm.lounge.user.application.port.out.jpa.UserSavePort;
import clone.bzm.lounge.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserJpaAdapter implements UserLoadPort, UserSavePort {

    private final UserJpaRepository userJpaRepository;

    private final PasswordEncoder passwordEncoder;


    @Override
    public User findByEmail(String email) {
        return userJpaRepository.findByEmail(UserEmail.of(email))
                .map(UserMapper::mapToDomainEntity)
                .orElseThrow(() -> new NotFoundUserException(email));
    }

    @Override
    public User findUser(String email, String plainPassword) {
        return userJpaRepository.findByEmail(UserEmail.of(email))
                .map(user -> {
                    if (!passwordEncoder.matches(plainPassword, user.getPassword())) {
                        throw new NoMatchedPasswordException();
                    }
                    return user;
                })
                .map(UserMapper::mapToDomainEntity)
                .orElseThrow(() -> new NotFoundUserException(email));
    }

    @Override
    public User findById(Long id) {
        return userJpaRepository.findById(id)
                .map(UserMapper::mapToDomainEntity)
                .orElseThrow(() -> new NotFoundUserException(String.valueOf(id)));
    }

    @Override
    public boolean existsByEmail(String email) {
        return userJpaRepository.existsByEmail(UserEmail.of(email));
    }

    @Override
    public User signUp(SignUpCommand command) {
        User user = User.signUp(
                command.email(),
                encryptPassword(command.plainPassword()),
                command.name(),
                command.phoneNumber()
        );

        UserJpaEntity registeredUser = userJpaRepository.save(
                UserMapper.mapToJpaEntity(user)
        );

        return UserMapper.mapToDomainEntity(registeredUser);
    }

    @Override
    public User changePassword(ChangePasswordCommand command) {
        return userJpaRepository.findByEmail(UserEmail.of(command.email()))
                .map(user -> {
                    if (!passwordEncoder.matches(command.oldPassword(), user.getPassword())) {
                        throw new NoMatchedPasswordException();
                    }
                    return user;
                })
                .map(user -> user.changePassword(encryptPassword(command.newPassword())))
                .map(UserMapper::mapToDomainEntity)
                .orElseThrow(() -> new NotFoundUserException(command.email()));
    }

    private String encryptPassword(String plainPassword) {
        String securePassword = passwordEncoder.encode(plainPassword);

        return securePassword;
    }
}
