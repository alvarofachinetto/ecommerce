package com.puc.ecommerce.output.boundary.kafka;

import com.puc.ecommerce.output.boundary.kafka.dto.EventDto;

public interface EventProducer {
    void enviarEvento(EventDto evento);
}
