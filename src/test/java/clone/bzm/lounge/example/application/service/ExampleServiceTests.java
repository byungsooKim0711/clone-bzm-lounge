package clone.bzm.lounge.example.application.service;

import clone.bzm.lounge.example.application.port.out.ExampleLoadPort;
import clone.bzm.lounge.example.application.port.out.ExampleSavePort;
import clone.bzm.lounge.example.domain.Example;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

class ExampleServiceTests {

    @InjectMocks
    private ExampleService exampleService;

    @Mock
    private ExampleLoadPort loadPort;

    @Mock
    private ExampleSavePort savePort;

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

    @DisplayName("예시 전체조회 테스트")
    @Test
    public void testFindAll() {
        // arrange
        List<Example> examples = findAll();
        when(loadPort.findAll()).thenReturn(examples);

        // act
        List<Example> actual = exampleService.findExample();

        // assert
        assertEquals("test001", actual.get(0).getName());
        assertEquals(1L, actual.get(0).getId().getValue());
        assertEquals("test002", actual.get(1).getName());
        assertEquals(2L, actual.get(1).getId().getValue());

    }

    @DisplayName("예시 단건조회 테스트 - 유효한 아이디")
    @Test
    public void testFindExampleById() {
        // arrange
        long expectedId = 3L;
        Example expected = findById(expectedId);
        when(loadPort.findById(any())).thenReturn(expected);

        // act
        Example actual = exampleService.findExample(any());

        // assert
        assertEquals(expected.getId().getValue(), actual.getId().getValue());
        assertEquals(expected.getName(), actual.getName());
    }

    @DisplayName("예시 저장 테스트")
    @Test
    public void testSaveExample() {
        // arrange
        long expectedId = 3L;
        Example expected = findById(expectedId);
        when(savePort.save(any())).thenReturn(expected);

        // act
        Example actual = exampleService.saveExample(any());

        // assert
        assertNotNull(actual.getId());
        assertEquals(expected.getName(), actual.getName());
    }

    @DisplayName("예시 삭제 테스트 - 유효한 아이디")
    @Test
    public void testDeleteExampleById() {
        // arrange
        Example expected = findById(3L);
        when(loadPort.findById(any())).thenReturn(expected);

        // act
        Example actual = exampleService.deleteExample(any());

        // assert
        verify(savePort, times(1)).deleteById(3L);
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getName(), actual.getName());
    }

    @DisplayName("예시 업데이트 테스트 - 유효한 하이디")
    @Test
    public void testUpdateExample() {
        // arrange
        long expectedId = 3L;
        String updateName = "update";
        Example expected = findById(expectedId);
        when(savePort.updateById(expectedId, updateName)).thenReturn(expected);

        // act
        exampleService.updateExample(expectedId, updateName);

        // assert
        verify(savePort, times(1)).updateById(expectedId, updateName);
    }

    private List<Example> findAll() {
        return List.of(
                Example.withId(Example.ExampleId.of(1L), "test001"),
                Example.withId(Example.ExampleId.of(2L), "test002")
        );
    }

    private Example findById(Long id) {
        return Example.withId(Example.ExampleId.of(id), "test003");
    }
}