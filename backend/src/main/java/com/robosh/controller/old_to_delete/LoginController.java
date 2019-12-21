package com.robosh.controller.old_to_delete;

import com.robosh.data.dto.LoginDto;
import com.robosh.data.dto.UserDto;
import com.robosh.data.entity.Parent;
import com.robosh.data.entity.Student;
import com.robosh.data.entity.Teacher;
import com.robosh.data.entity.User;
import com.robosh.exception.AuthenticationException;
import com.robosh.service.ParentService;
import com.robosh.service.StudentService;
import com.robosh.service.TeacherService;
import com.robosh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@Controller
@RestController
public class LoginController {

    private static final String TOKEN_HEADER = "Authorization";
    private static final String TOKEN_PREFIX = "Bearer ";
    private static final String ACCESS_CONTROL = "Access-Control-Expose-Headers";
    @SuppressWarnings("squid:S2068")
    private static final String MESSAGE_WRONG_PASSWORD = "Invalid password";
    private static final String MESSAGE_WRONG_LOGIN = "Invalid email";

    private final UserService userService;
    private final TeacherService teacherService;
    private final StudentService studentService;
    private final ParentService parentService;

    @Autowired
    public LoginController(UserService userService, TeacherService teacherService, StudentService studentService, ParentService parentService) {
        this.userService = userService;
        this.teacherService = teacherService;
        this.studentService = studentService;
        this.parentService = parentService;
    }

    private UserDto getAccordingUserDto(User user) {
        switch (user.getRole()) {
            case ADMIN: return userService.convertUserToDto(user);
            case TEACHER: return teacherService.convertTeacherToDto((Teacher) user);
            case STUDENT: return studentService.convertStudentToDto((Student)user);
            case PARENT: return parentService.convertParentToDto((Parent) user);
            default: return null;
        }
    }
}
