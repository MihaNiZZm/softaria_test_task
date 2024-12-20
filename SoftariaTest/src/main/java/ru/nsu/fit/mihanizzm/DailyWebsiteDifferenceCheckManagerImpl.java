package ru.nsu.fit.mihanizzm;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DailyWebsiteDifferenceCheckManagerImpl implements DailyWebsiteDifferenceCheckManager{

    @Override
    public Set<String> findDisappearedPages(Map<String, String> yesterday, Map<String, String> today) {
        Set<String> disappearedPages = new HashSet<>(yesterday.keySet());
        disappearedPages.removeAll(today.keySet());
        return disappearedPages;
    }

    @Override
    public Set<String> findNewPages(Map<String, String> yesterday, Map<String, String> today) {
        Set<String> newPages = new HashSet<>(today.keySet());
        newPages.removeAll(yesterday.keySet());
        return newPages;
    }

    @Override
    public Set<String> findChangedPages(Map<String, String> yesterday, Map<String, String> today) {
        Set<String> changedPages = new HashSet<>();
        for (String url : yesterday.keySet()) {
            if (today.containsKey(url) && !yesterday.get(url).equals(today.get(url))) {
                changedPages.add(url);
            }
        }
        return changedPages;
    }
}
