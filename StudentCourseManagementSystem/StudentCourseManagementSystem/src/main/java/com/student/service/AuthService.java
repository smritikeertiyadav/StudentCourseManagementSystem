package com.student.service;

import com.student.dto.*;

public interface AuthService {
    String register(RegisterRequest request);
    String login(LoginRequest request);
}
