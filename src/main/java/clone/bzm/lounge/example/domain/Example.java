package clone.bzm.lounge.example.domain;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Example {

    private final ExampleId id;

    private final String name;

    private Example(ExampleId id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Example withoutId(String name) {
        return new Example(null, name);
    }

    public static Example withId(ExampleId id, String name) {
        return new Example(id, name);
    }


    @Getter
    public static final class ExampleId {
        private final Long value;

        private ExampleId(Long value) {
            this.value = value;
        }

        public static ExampleId of(Long value) {
            return new ExampleId(value);
        }
    }
}
