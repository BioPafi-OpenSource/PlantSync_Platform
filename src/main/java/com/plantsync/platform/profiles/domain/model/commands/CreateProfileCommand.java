package com.plantsync.platform.profiles.domain.model.commands;

import com.plantsync.platform.profiles.domain.model.valueobjects.PersonName;
import com.plantsync.platform.profiles.domain.model.valueobjects.SubscriptionPlan;
import com.plantsync.platform.profiles.domain.model.valueobjects.UserId;

public record CreateProfileCommand (
        PersonName personName,
        SubscriptionPlan subscriptionPlan,
        UserId userId


){
}
