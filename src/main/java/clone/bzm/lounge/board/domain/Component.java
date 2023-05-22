package clone.bzm.lounge.board.domain;

import com.fasterxml.jackson.databind.JsonNode;

import java.time.LocalDateTime;

public class Component {

    private Long id;

    private Long postId;

    // SERIAL_NUMBER, TEMPLATE, SENDER, ...
    private JsonNode code;

    private String content;

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
