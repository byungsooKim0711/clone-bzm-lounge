package clone.bzm.lounge.example.adapter.out.persistence;

import clone.bzm.lounge.example.domain.Example;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ExampleInMemoryRepository {

    private final Map<String, Example> DB = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        Example dummy1 = Example.from("dummy_001");
        Example dummy2 = Example.from("dummy_002");
        Example dummy3 = Example.from("dummy_003");
        Example dummy4 = Example.from("dummy_004");
        Example dummy5 = Example.from("dummy_005");

        DB.put(dummy1.getId(), dummy1);
        DB.put(dummy2.getId(), dummy2);
        DB.put(dummy3.getId(), dummy3);
        DB.put(dummy4.getId(), dummy4);
        DB.put(dummy5.getId(), dummy5);
    }

    public Collection<Example> findAll() {
        return DB.values();
    }

    public Optional<Example> findById(String id) {
        return Optional.ofNullable(DB.get(id));
    }

    public Example save(Example example) {
        DB.put(example.getId(), example);
        return example;
    }

    public Example deleteById(String id) {
        return DB.remove(id);
    }
}
