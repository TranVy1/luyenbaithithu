import entity.Student;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import service.StudentService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StudentServiceTest {
    protected static Student student;
    protected static StudentService studentService;
    @BeforeAll
    public static void setUp() {
        studentService = new StudentService();
    }
    // Điểm hợp lệ
    @Test
    void testUpdateScoreNormal(){
        // Stub dữ liệu
        student = new Student(
                "SV0001",
                "Nguyễn Tường Minh",
                20,
                7.5F,
                3,
                "Công nghệ thông tin"
        );
        studentService.updateStudent(student);
        assertEquals(7.5F, studentService.getStudent().getScore());
    }
    // Điểm nhỏ hơn 0
    @Test
    void testUpdateScoreLessThan0(){
        // Stub dữ liệu
        student = new Student(
                "SV0001",
                "Nguyễn Tường Minh",
                20,
                -1F,
                3,
                "Công nghệ thông tin"
        );
        Exception exception = assertThrows(IllegalArgumentException.class, () -> studentService.updateStudent(student));
        assertEquals("Điểm trung bình phải nằm trong khoảng từ 1-10", exception.getMessage());
    }
    // Điểm nhỏ hơn 0
    @Test
    void testUpdateScoreGreaterThan10(){
        // Stub dữ liệu
        student = new Student(
                "SV0001",
                "Nguyễn Tường Minh",
                20,
                11F,
                3,
                "Công nghệ thông tin"
        );
        Exception exception = assertThrows(IllegalArgumentException.class, () -> studentService.updateStudent(student));
        assertEquals("Điểm trung bình phải nằm trong khoảng từ 1-10", exception.getMessage());
    }

    // Điểm bằng 0
    @Test
    void testUpdateScoreEqual0(){
        // Stub dữ liệu
        student = new Student(
                "SV0001",
                "Nguyễn Tường Minh",
                20,
                0F,
                3,
                "Công nghệ thông tin"
        );
        studentService.updateStudent(student);
        assertEquals(0F, studentService.getStudent().getScore());
    }
    // Điểm bằng 10
    @Test
    void testUpdateScoreEqual10(){
        // Stub dữ liệu
        student = new Student(
                "SV0001",
                "Nguyễn Tường Minh",
                20,
                10F,
                3,
                "Công nghệ thông tin"
        );
        studentService.updateStudent(student);
        assertEquals(10F, studentService.getStudent().getScore());
    }
}
