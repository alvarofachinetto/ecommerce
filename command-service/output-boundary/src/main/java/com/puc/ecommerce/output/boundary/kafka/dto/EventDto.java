package com.puc.ecommerce.output.boundary.kafka.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EventDto {
    private ActionEvent action;
    private Object data;
}
