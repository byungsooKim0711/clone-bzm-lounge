package clone.bzm.lounge.board.post.adapter.out.jpa;

import clone.bzm.lounge.board.domain.Post;
import clone.bzm.lounge.board.entity.PostMapper;
import clone.bzm.lounge.board.post.application.port.in.command.PostSearchCommand;
import clone.bzm.lounge.board.post.application.port.out.PostLoadPort;
import clone.bzm.lounge.common.exception.NotFoundPostException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
class PostJpaAdapter implements PostLoadPort {

    private final PostJpaRepository repository;

    @Override
    public List<Post> findAll(PostSearchCommand command) {
        return repository.searchPostList(command)
                .stream()
                .map(PostMapper::mapToDomainEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Post findById(Long id) {
        return repository.searchPostById(id)
                .map(PostMapper::mapToDomainEntity)
                .orElseThrow(() -> new NotFoundPostException(id));
    }
}
