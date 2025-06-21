package com.plantsync.platform.profiles.domain.model.aggregates;


import com.plantsync.platform.profiles.domain.model.commands.CreateProfileCommand;
import com.plantsync.platform.profiles.domain.model.valueobjects.PersonName;
import com.plantsync.platform.profiles.domain.model.valueobjects.SubscriptionPlan;
import com.plantsync.platform.profiles.domain.model.valueobjects.UserId;
import com.plantsync.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Profile extends AuditableAbstractAggregateRoot<Profile> {

    @Embedded
    private PersonName personName;

    @Enumerated(EnumType.STRING)
    private SubscriptionPlan subscriptionPlan;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "user_id"))
    private UserId userId;

    public Profile() {
    super();
    }



    public Profile(CreateProfileCommand command) {
        this.personName = command.personName();
        this.subscriptionPlan = command.subscriptionPlan();
        this.userId = command.userId();
    }
    public Profile(PersonName name, SubscriptionPlan subscriptionPlan, UserId userId) {
        this.personName = name;
        this.subscriptionPlan = subscriptionPlan;
        this.userId = userId;
    }


}
