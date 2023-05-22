package clone.bzm.lounge.board.post.application.port.out;

import clone.bzm.lounge.board.domain.Post;
import clone.bzm.lounge.board.post.application.port.in.command.PostSearchCommand;

import java.util.List;

public interface PostLoadPort {

    List<Post> findAll(PostSearchCommand command);

    Post findById(Long id);
}
