package ru.nsu.fit.mihanizzm;

import ru.nsu.fit.mihanizzm.domain.DailyWebsiteDifferenceCheckManager;
import ru.nsu.fit.mihanizzm.domain.impl.DailyWebsiteDifferenceCheckManagerImpl;
import ru.nsu.fit.mihanizzm.domain.DailyWebsiteOverviewCreator;
import ru.nsu.fit.mihanizzm.domain.impl.DailyWebsiteOverviewCreatorImpl;
import ru.nsu.fit.mihanizzm.domain.impl.DashWebsiteSetFormatter;
import ru.nsu.fit.mihanizzm.domain.WebsiteSetFormatter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Map<String, String> yesterday = new HashMap<>();
        Map<String, String> today = new HashMap<>();

        // Предполагаемое имя секретаря
        String secretaryFirstName = "Мария";
        String secretaryLastName = "Иванова";

        // Тестовые сайтики
        yesterday.put("https://mihanizzm.com/page1", "<html>Page 1</html>");
        yesterday.put("https://mihanizzm.com/page2", "<html>Page 2</html>");
        yesterday.put("https://mihanizzm.com/page3", "<html>Page 3</html>");

        today.put("https://mihanizzm.com/page1", "<html>Page 1</html>");
        today.put("https://mihanizzm.com/page3", "<html>Page 3 Updated</html>");
        today.put("https://mihanizzm.com/page4", "<html>Page 4</html>");

        DailyWebsiteDifferenceCheckManager differenceChecker = new DailyWebsiteDifferenceCheckManagerImpl();

        // Если бы был DI-контейнер, то не пришлось бы создавать этот форматтер вручную.
        WebsiteSetFormatter formatter = new DashWebsiteSetFormatter();
        // Могли бы создать другую реализацию форматтера (я их сделал две) и потом передать ее в создатель отчетов.
        DailyWebsiteOverviewCreator overviewCreator = new DailyWebsiteOverviewCreatorImpl(formatter);

        Set<String> disappearedPages = differenceChecker.findDisappearedPages(yesterday, today);
        Set<String> newPages = differenceChecker.findNewPages(yesterday, today);
        Set<String> changedPages = differenceChecker.findChangedPages(yesterday, today);

        String email = overviewCreator.createOverview(
                secretaryFirstName,
                secretaryLastName,
                disappearedPages,
                newPages,
                changedPages
        );
        System.out.println(email);

        // Можно еще в файлик сохранить и потом прикрепить его в письме, или вообще использовать авто-рассылку.
        // Я для примера создам email.txt
        String fileName = "email.txt";
        try (FileWriter fw = new FileWriter(fileName)) {
            fw.write(email);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}