package io.github.natashamir.pbn_project;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class XMLExport implements PbnExporter{

    private DataOutputStream mExpOs;
    private boolean mbNoCR;
    private XMLObject xmlObject = new XMLObject();

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
            xmlObject.addVersionComment(oString);
/*            try {

                mExpOs.writeBytes(oString);
                if (!mbNoCR) {
                    mExpOs.writeByte('\r');
                }
                mExpOs.writeByte('\n');
            } catch (Exception e) {
                System.err.println("Can't write to export file");
            }*/
        }
    }

    @Override
    public void write(PbnGameData oGameData, PbnGameTags oGameTags) {

        xmlObject.pbnGameData.add(oGameData);

    }

    @Override
    public void flush() {

        try {
            JAXBContext jc = JAXBContext.newInstance(XMLObject.class);
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(xmlObject, mExpOs);
        } catch (JAXBException e) {
            e.printStackTrace(); //TODO write to log file
        }

        try {
            mExpOs.flush();
        } catch (Exception e) {
            System.err.println("Can't flush exportfile");
        }

    }
}
