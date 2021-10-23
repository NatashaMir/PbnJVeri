package com.github.natashamir.pbn_project;

import java.io.FileOutputStream;

public interface PbnExporter {

    void setExportFile(
            FileOutputStream oFos);

    void exportLine(
            String oString);

    void write(
            PbnGameData oGameData,
            PbnGameTags oGameTags);

    void flush();

    void noCR(
            boolean bNoCR);

}
