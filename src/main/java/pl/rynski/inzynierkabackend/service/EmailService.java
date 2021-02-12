package pl.rynski.inzynierkabackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender email;
    @Value("${spring.mail.username}")
    private String sourceEmail;

    public void sendEmail(String content, String ideaExplanation, LocalDateTime sendingTime, String targetEmail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(sourceEmail);
        message.setTo(targetEmail);
        message.setSubject("Odpowiedź na zgłoszenie z dnia " + sendingTime.toLocalDate());
        message.setText("W dniu " + sendingTime.toLocalDate() + " zostało wysłane zgłoszenie dotyczące zmian w planie studiów o następującej treści:\n" +
                ideaExplanation + "\n" +
                "Odpowiedź:\n" +
                content);
        email.send(message);
    }
}
