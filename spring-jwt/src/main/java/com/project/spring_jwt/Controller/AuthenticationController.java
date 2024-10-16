package com.project.spring_jwt.Controller;


import com.project.spring_jwt.Model.User;
import com.project.spring_jwt.Service.JwtService;
import com.project.spring_jwt.Service.UserService;
import com.project.spring_jwt.dto.LoginUserDto;
import com.project.spring_jwt.dto.LoginResponse;
import com.project.spring_jwt.dto.RegisterUserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {



    private final JwtService jwtService;
    private  final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;
    private final UserService userService;

    public AuthenticationController(JwtService jwtService, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, UserService userService) {
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.userService = userService;

    }

    @PostMapping("/signup")
    public ResponseEntity<User> registerUser(@RequestBody RegisterUserDto registerUserDto) {
        User registeredUser = userService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        User authenticatedUser = userService.authenticate(loginUserDto);
        System.out.println(authenticatedUser);
        String jwtToken = jwtService.generateToken(authenticatedUser.getUsername());

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
        }




    @GetMapping("/user")
    public String getUser(@RequestBody User user) {
        System.out.println(user);
        return user.getName();
    }



}
