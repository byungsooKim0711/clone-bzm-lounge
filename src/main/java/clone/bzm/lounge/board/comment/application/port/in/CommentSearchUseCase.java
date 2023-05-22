package clone.bzm.lounge.board.comment.application.port.in;

import java.util.List;

public interface CommentSearchUseCase {

    List<Object> searchComment(Long postId);
}
