package clone.bzm.lounge.board.post.application.port.in;

import clone.bzm.lounge.board.domain.Post;
import clone.bzm.lounge.board.post.application.port.in.command.PostSearchCommand;

import java.util.List;

public interface PostSearchUseCase {

    List<Post> searchPost(PostSearchCommand condition);

    Post searchPost(Long id);
}
