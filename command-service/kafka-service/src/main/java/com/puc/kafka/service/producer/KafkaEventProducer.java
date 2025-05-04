package com.puc.kafka.service.producer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.puc.ecommerce.output.boundary.kafka.EventProducer;
import com.puc.ecommerce.output.boundary.kafka.dto.EventDto;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaEventProducer implements EventProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    private final ObjectMapper objectMapper;

    @Override
    public void enviarEvento(EventDto evento) {
        try {
            objectMapper.writeValueAsString(evento);
            String topic = evento.getAction().name();
//            kafkaTemplate.send(topic, evento);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao enviar evento para o Kafka: " + e.getMessage(), e);
        }
    }

}
