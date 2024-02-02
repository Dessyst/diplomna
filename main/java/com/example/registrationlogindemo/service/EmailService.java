package com.example.registrationlogindemo.service;

public interface EmailService {
    void sendEmail(String to, String subject, String text);
}
