package ru.nsu.fit.mihanizzm.domain.impl;

import ru.nsu.fit.mihanizzm.domain.DailyWebsiteOverviewCreator;
import ru.nsu.fit.mihanizzm.domain.WebsiteSetFormatter;

import java.util.Set;

public class DailyWebsiteOverviewCreatorImpl implements DailyWebsiteOverviewCreator {
    private WebsiteSetFormatter formatter;

    public DailyWebsiteOverviewCreatorImpl(WebsiteSetFormatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public String createOverview(
            String clientFirstName,
            String clientLastName,
            Set<String> disappearedWebsites,
            Set<String> changedWebsites,
            Set<String> newWebsites) {
        return String.format(
                """
                Здравствуйте, дорогой(ая) %s %s!
                
                За последние сутки на вверенных Вам сайтах произошли следующие изменения:
                
                Исчезли следующие страницы: %s
                
                Появились следующие страницы: %s
                
                Изменились следующие страницы: %s
                
                С уважением,
                автоматизированная система мониторинга.
                """,
                clientFirstName,
                clientLastName,
                formatter.formatSetOfWebsites(disappearedWebsites),
                formatter.formatSetOfWebsites(newWebsites),
                formatter.formatSetOfWebsites(changedWebsites)
        );
    }
}
