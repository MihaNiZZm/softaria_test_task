package ru.nsu.fit.mihanizzm.domain;

import java.util.Set;

public interface DailyWebsiteOverviewCreator {
    String createOverview(
            String clientFirstName,
            String clientLastName,
            Set<String> disappearedWebsites,
            Set<String> changedWebsites,
            Set<String> newWebsites);
}
