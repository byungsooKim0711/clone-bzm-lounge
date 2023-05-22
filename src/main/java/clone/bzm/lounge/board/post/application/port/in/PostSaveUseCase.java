package clone.bzm.lounge.board.post.application.port.in;

import clone.bzm.lounge.board.domain.Post;
import clone.bzm.lounge.board.post.application.port.in.command.PostCreateCommand;

public interface PostSaveUseCase {

    Post createPost(PostCreateCommand command);
}
