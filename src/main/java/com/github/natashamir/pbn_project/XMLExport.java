package com.github.natashamir.pbn_project;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.sax.TransformerHandler;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class XMLExport implements PbnExporter{

    private DataOutputStream mExpOs;
    private boolean mbNoCR;
    TransformerHandler th;

    public XMLExport(boolean mbNoCR) {
        this.mbNoCR = mbNoCR;
        mExpOs = null;
    }


    @Override
    public void setExportFile(FileOutputStream oFos) {
        BufferedOutputStream lBos = new BufferedOutputStream(oFos);
        DataOutputStream lDos = new DataOutputStream(lBos);
        mExpOs = lDos;
    }

    @Override
    public void exportLine(String oString) {
        if (mExpOs != null) {
            try {
                mExpOs.writeBytes(oString);
                if (!mbNoCR) {
                    mExpOs.writeByte('\r');
                }
                mExpOs.writeByte('\n');
            } catch (Exception e) {
                System.err.println("Can't write to export file");
            }
        }
    }

    @Override
    public void write(PbnGameData oGameData, PbnGameTags oGameTags) {

        JAXBContext jc = null;
        try {
            jc = JAXBContext.newInstance(PbnGameData.class);
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(oGameData, mExpOs);
        } catch (JAXBException e) {
            e.printStackTrace(); //TODO write to log file
        }
    }

    @Override
    public void flush() {
        try {
            mExpOs.flush();
        } catch (Exception e) {
            System.err.println("Can't flush exportfile");
        }
    }
}
