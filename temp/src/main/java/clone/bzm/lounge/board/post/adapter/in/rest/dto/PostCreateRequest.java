package clone.bzm.lounge.board.post.adapter.in.rest.dto;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PostCreateRequest {

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    private boolean privacy;

    private List<Long> attachmentIds = new ArrayList<>();

    private List<Long> mentionedUserIds = new ArrayList<>();

    private List<Component> components = new ArrayList<>();

    @Data
    public static class Component {

        @NotBlank
        private String type;

        @NotNull
        private JsonNode content;
    }
}
