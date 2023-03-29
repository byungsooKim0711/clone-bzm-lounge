package clone.bzm.lounge.example.adapter.out.persistence;

import clone.bzm.lounge.example.domain.Example;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

class ExamplePersistenceAdapterTests {

    @InjectMocks
    private ExamplePersistenceAdapter examplePersistenceAdapter;

    @Mock
    private ExampleJpaRepository exampleJpaRepository;

    @BeforeAll
    public static void setUp() {

    }

    @BeforeEach
    public void init() {
        openMocks(this);
    }

    @AfterEach
    public void clear() {
    }

    @AfterAll
    public static void tearDown() {

    }


    @DisplayName("예시 데이터 전체 조회, 데이터가 존재할 때")
    @Test
    void findAll() {
        // arrange
        List<ExampleJpaEntity> list = List.of(
                ExampleJpaEntity.from(1L, "test001"),
                ExampleJpaEntity.from(2L, "test002")
        );

        when(exampleJpaRepository.findAll()).thenReturn(list);

        // act
        List<Example> actual = examplePersistenceAdapter.findAll();

        // assert
        assertEquals(list.get(0).getName(), actual.get(0).getName());
        assertEquals(list.get(0).getId(), actual.get(0).getId().getValue());
        assertEquals(list.get(1).getName(), actual.get(1).getName());
        assertEquals(list.get(1).getId(), actual.get(1).getId().getValue());
    }

    @DisplayName("예시 데이터 전체 조회, 데이터가 존재하지 않을 때")
    @Test
    void findAllWithEmptyList() {
        // arrange
        List<ExampleJpaEntity> list = Collections.emptyList();

        when(exampleJpaRepository.findAll()).thenReturn(list);

        // act
        List<Example> actual = examplePersistenceAdapter.findAll();

        // assert
        org.assertj.core.api.Assertions.assertThat(actual)
                .isEmpty();
    }


    @DisplayName("예시 데이터 ID 조회, 데이터가 존재할 때")
    @Test
    void findById() {
        // arrange
        ExampleJpaEntity expected = ExampleJpaEntity.from(1L, "test");
        when(exampleJpaRepository.findById(expected.getId()))
                .thenReturn(Optional.of(expected));

        // act
        Example actual = examplePersistenceAdapter.findById(expected.getId());

        // assert
        assertEquals(expected.getId(), actual.getId().getValue());
        assertEquals(expected.getName(), actual.getName());
    }

    @DisplayName("예시 데이터 ID 조회, 데이터가 존재하지 않을 때 EntityNotFoundException 이 발생한다.")
    @Test
    void findByIdWithEmptyData() {
        // arrange
        when(exampleJpaRepository.findById(any()))
                .thenReturn(Optional.empty());

        // act
        assertThrows(EntityNotFoundException.class, () -> {
            examplePersistenceAdapter.findById(any());
        });
    }

    @DisplayName("예시 데이터 저장 테스트")
    @Test
    void save() {
        // arrange
        Example expected = Example.withId(Example.ExampleId.of(1L), "test");

        when(exampleJpaRepository.save(any()))
                .thenReturn(ExampleMapper.mapToJpaEntity(expected));

        // act
        Example actual = examplePersistenceAdapter.save(expected);

        // assert
        assertEquals(expected.getId().getValue(), actual.getId().getValue());
        assertEquals(expected.getName(), actual.getName());
    }

    @DisplayName("예시 데이터 삭제 테스트")
    @Test
    void deleteById() {
        // arrange
        long deletedId = 1L;

        // act
        examplePersistenceAdapter.deleteById(deletedId);

        // assert
        verify(exampleJpaRepository, times(1)).deleteById(deletedId);
    }

    @DisplayName("예시 데이터 업데이트 테스트")
    @Test
    void updateById() {
        // arrange
        long updatedId = 1L;
        String updatedName = "updated...";
        ExampleJpaEntity expected = ExampleJpaEntity.from(updatedId, "test");
        when(exampleJpaRepository.findById(any())).thenReturn(Optional.of(expected));

        // act
        Example actual = examplePersistenceAdapter.updateById(updatedId, updatedName);

        // assert
        assertEquals(expected.getId(), actual.getId().getValue());
        assertEquals(expected.getName(), actual.getName());
    }

    @DisplayName("예시 데이터 업데이트 테스트, 업데이트 할 데이터가 없을 때 EntityNotFoundException 이 발생한다.")
    @Test
    void updateByIdWithEmptyData() {
        // arrange
        when(exampleJpaRepository.findById(any())).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> {
            examplePersistenceAdapter.updateById(any(), "");
        });
    }
}