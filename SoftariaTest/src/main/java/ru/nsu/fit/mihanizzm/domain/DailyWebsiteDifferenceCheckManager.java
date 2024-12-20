package ru.nsu.fit.mihanizzm.domain;

import java.util.Map;
import java.util.Set;

public interface DailyWebsiteDifferenceCheckManager {
    Set<String> findDisappearedPages(Map<String, String> yesterday, Map<String, String> today);
    Set<String> findNewPages(Map<String, String> yesterday, Map<String, String> today);
    Set<String> findChangedPages(Map<String, String> yesterday, Map<String, String> today);
}
