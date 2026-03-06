package service;

import entity.Student;

public class StudentService {
    // Stub dữ liệu sinh viên
    protected Student student = new Student(
            "SV0001",
            "Nguyễn Tường Minh",
            20,
            8.5F,
            3,
            "Công nghệ thông tin"
    );

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void updateStudent(Student newStudent) {
        if (newStudent == null) {
            throw new IllegalArgumentException("Đối tượng sinh viên không được null.");
        }
        if (newStudent.getId() == null || newStudent.getId().isEmpty()) {
            throw new IllegalArgumentException("Mã sinh viên không được rỗng.");
        }
        if (newStudent.getName() == null || newStudent.getName().isEmpty()) {
            throw new IllegalArgumentException("Mã sinh viên không được rỗng.");
        }
        if (newStudent.getScore() < 0 || newStudent.getScore() > 10) {
            throw new IllegalArgumentException("Điểm trung bình phải nằm trong khoảng từ 1-10");
        }
        student.setId(newStudent.getId());
        student.setName(newStudent.getName());
        student.setScore(newStudent.getScore());
        student.setSemester(newStudent.getSemester());
        student.setMajor(newStudent.getMajor());
    }
}
