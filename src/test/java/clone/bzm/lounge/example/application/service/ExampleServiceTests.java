package clone.bzm.lounge.example.application.service;

import clone.bzm.lounge.example.adapter.in.web.dto.ExampleResponse;
import clone.bzm.lounge.example.application.port.out.ExampleLoadPort;
import clone.bzm.lounge.example.application.port.out.ExampleSavePort;
import clone.bzm.lounge.example.domain.Example;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
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
        List<ExampleResponse> actual = exampleService.findExample();

        // assert
        assertEquals("test001", actual.get(0).getName());
        assertNotNull(actual.get(0).getId());
        assertEquals("test002", actual.get(1).getName());
        assertNotNull(actual.get(1).getId());
    }

    @DisplayName("예시 단건조회 테스트 - 유효한 아이디")
    @Test
    public void testFindExampleById() {
        // arrange
        when(loadPort.findById(any())).thenReturn(Optional.of(findById()));

        // act
        ExampleResponse actual = exampleService.findExample(any());

        // assert
        assertEquals("test", actual.getName());
    }

    @DisplayName("예시 단건조회 테스트 - 유효하지 않은 아이디(IllegalArgumentException이 발생한다)")
    @Test
    public void testFindExampleByIdWithWrongValue() {
        // arrange
        when(loadPort.findById(any())).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class, () -> {
            exampleService.findExample(any());
        });
    }

    @DisplayName("예시 저장 테스트")
    @Test
    public void testSaveExample() {
        // arrange
        Example expected = findById();
        when(savePort.save(any())).thenReturn(expected);

        // act
        ExampleResponse actual = exampleService.saveExample(any());

        // assert
        assertNotNull(actual.getId());
        assertEquals(expected.getName(), actual.getName());
    }

    @DisplayName("예시 삭제 테스트 - 유효한 아이디")
    @Test
    public void testDeleteExampleById() {
        // arrange
        Example expected = findById();
        when(loadPort.findById(any())).thenReturn(Optional.of(expected));
        when(savePort.deleteById(any())).thenReturn(expected);

        // act
        ExampleResponse actual = exampleService.deleteExample(any());

        // assert
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getName(), actual.getName());
    }

    @DisplayName("예시 삭제 테스트 - 유효하지 않은 아이디(IllegalArgumentException이 발생한다)")
    @Test
    public void testDeleteExampleByIdWithWrongValue() {
        // arrange
        when(loadPort.findById(any())).thenReturn(Optional.empty());

        // act
        assertThrows(IllegalArgumentException.class, () -> {
            exampleService.deleteExample(any());
        });
    }

    @DisplayName("예시 업데이트 테스트 - 유효한 하이디")
    @Test
    public void testUpdateExample() {
        // arrange
        String updateName = "update";
        Example expected = findById();
        when(loadPort.findById(any())).thenReturn(Optional.of(expected));
        when(savePort.save(any())).thenReturn(expected);

        // act
        ExampleResponse actual = exampleService.updateExample(any(), updateName);

        // assert
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getName(), actual.getName());
    }

    @DisplayName("예시 업데이트 테스트 - 유효하지 않은 아이디(IllegalArgumentException이 발생한다)")
    @Test
    public void testUpdateExampleWithWrongValue() {
        // arrange
        when(loadPort.findById(any())).thenReturn(Optional.empty());


        assertThrows(IllegalArgumentException.class, () -> {
            exampleService.updateExample("", "");
        });
    }

    private List<Example> findAll() {
        return List.of(
                Example.from("test001"),
                Example.from("test002")
        );
    }

    private Example findById() {
        return Example.from("test");
    }
}