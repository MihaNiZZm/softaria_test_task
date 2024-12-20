package ru.nsu.fit.mihanizzm;

import java.util.Set;

public class DashWebsiteSetFormatter implements WebsiteSetFormatter {
    @Override
    public String formatSetOfWebsites(Set<String> websites) {
        if (websites == null) {
            return "-";
        }
        StringBuilder sb = new StringBuilder();
        for (String website : websites) {
            sb.append("\n- ").append(website);
        }

        return sb.toString();
    }
}
