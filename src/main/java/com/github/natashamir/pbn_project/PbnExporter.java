package com.github.natashamir.pbn_project;

import javax.xml.bind.JAXBException;
import java.io.FileOutputStream;

public interface PbnExporter {

    void setExportFile(
            FileOutputStream oFos);

    void exportLine(
            String oString);

    void write(
            PbnGameData oGameData,
            PbnGameTags oGameTags) throws JAXBException;

    void flush();


}
