package clone.bzm.lounge.example.domain;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Example {

    private String id;

    private String name;

    protected Example() {

    }

    protected Example(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
    }

    public static Example from(String name) {
        return new Example(name);
    }

    public void updateName(String name) {
        this.name = name;
    }
}
