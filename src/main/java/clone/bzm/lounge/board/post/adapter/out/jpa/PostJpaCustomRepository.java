package clone.bzm.lounge.board.post.adapter.out.jpa;

import clone.bzm.lounge.board.entity.PostJpaEntity;
import clone.bzm.lounge.board.post.application.port.in.command.PostSearchCommand;

import java.util.List;
import java.util.Optional;

public interface PostJpaCustomRepository {

    List<PostJpaEntity> searchPostList(PostSearchCommand command);
    Optional<PostJpaEntity> searchPostById(Long id);
}
