package ru.nsu.fit.mihanizzm.domain.impl;

import ru.nsu.fit.mihanizzm.domain.OverviewExporter;

import java.io.FileWriter;
import java.io.IOException;

public class FileOverviewExporter implements OverviewExporter {

    @Override
    public void exportOverview(String filePath, String fileContent) throws IOException {
        try (FileWriter fw = new FileWriter(filePath)) {
            fw.write(fileContent);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
