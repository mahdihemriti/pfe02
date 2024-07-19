package tn.pfe.pfe02.services;

public interface IEmailService {
    void sendSimpleMessage(String to, String subject, String text);
}
