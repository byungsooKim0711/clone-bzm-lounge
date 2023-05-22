package clone.bzm.lounge.board.comment.application.service;

import clone.bzm.lounge.board.comment.application.port.in.CommentSearchUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
class CommentService implements CommentSearchUseCase {

    @Override
    public List<Object> searchComment(Long postId) {
        return null;
    }
}
