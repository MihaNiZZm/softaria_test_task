package ru.nsu.fit.mihanizzm.domain;

import java.io.IOException;

public interface OverviewExporter {
    void exportOverview(String filePath, String fileContent) throws IOException;
}
