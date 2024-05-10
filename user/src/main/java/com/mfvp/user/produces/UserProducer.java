package com.mfvp.user.produces;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mfvp.user.dtos.EmailDto;
import com.mfvp.user.models.UserModel;

@Component
public class UserProducer {
    private final RabbitTemplate rabbitTemplate;

    public UserProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${broker.queue.email.name}")
    private String routingKey;

    public void publishMessageEmail(UserModel userModel) {
        var emailDto = new EmailDto();
        emailDto.setUserId(userModel.getId());
        emailDto.setEmailTo(userModel.getEmail());
        emailDto.setSubject("Cadastro realizado com sucesso!");
        emailDto.setText(userModel.getFirstName() + ", seja bem vindo! \nAgradecemos o seu cadastro, aproveite agora todos os recursos da plataforma!");

        rabbitTemplate.convertAndSend("", routingKey, emailDto);
    }
}
