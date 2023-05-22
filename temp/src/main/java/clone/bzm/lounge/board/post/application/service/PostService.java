package clone.bzm.lounge.board.post.application.service;

import clone.bzm.lounge.board.domain.Post;
import clone.bzm.lounge.board.post.application.port.in.PostSaveUseCase;
import clone.bzm.lounge.board.post.application.port.in.PostSearchUseCase;
import clone.bzm.lounge.board.post.application.port.in.command.PostCreateCommand;
import clone.bzm.lounge.board.post.application.port.in.command.PostSearchCommand;
import clone.bzm.lounge.board.post.application.port.out.PostLoadPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
class PostService implements PostSearchUseCase, PostSaveUseCase {

    private final PostLoadPort loadPort;

    @Transactional(readOnly = true)
    @Override
    public List<Post> searchPost(PostSearchCommand condition) {
        return loadPort.findAll(condition);
    }

    @Transactional(readOnly = true)
    @Override
    public Post searchPost(Long id) {
        Post post = loadPort.findById(id);

        // mention
        // term
        // notification


        return post;
    }

    @Override
    public Post createPost(PostCreateCommand command) {

        return null;
    }
}
