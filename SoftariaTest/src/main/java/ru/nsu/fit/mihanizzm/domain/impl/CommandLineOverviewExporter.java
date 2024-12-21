package ru.nsu.fit.mihanizzm.domain.impl;

import ru.nsu.fit.mihanizzm.domain.OverviewExporter;

import java.io.IOException;

public class CommandLineOverviewExporter implements OverviewExporter {

    @Override
    public void exportOverview(String filePath, String fileContent) throws IOException {
        System.out.println(fileContent);
    }
}
