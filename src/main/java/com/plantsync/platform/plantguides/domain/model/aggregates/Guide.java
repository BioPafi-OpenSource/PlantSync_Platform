package com.plantsync.platform.plantguides.domain.model.aggregates;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import com.plantsync.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Guide extends AuditableAbstractAggregateRoot<Guide> {

    @NotBlank
    @Size(max = 100)
    private String title;

    @NotBlank
    @Size(max = 100)
    private String name;

    @NotBlank
    @Size(max = 1000)
    private String description;

    @NotBlank
    @Size(max = 50)
    private String topic;

    @NotBlank
    @Size(max = 50)
    private String type;

    @NotBlank
    @Size(max = 255)
    private String imageUrl;

    public Guide() {}

    public Guide(String title, String name, String description, String topic, String type, String imageUrl) {
        this.title = title;
        this.name = name;
        this.description = description;
        this.topic = topic;
        this.type = type;
        this.imageUrl = imageUrl;
    }
}
