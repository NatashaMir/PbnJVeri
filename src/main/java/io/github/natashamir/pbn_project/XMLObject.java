package io.github.natashamir.pbn_project;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="xmlObject")
@XmlAccessorType(XmlAccessType.FIELD)

public class XMLObject {

    List<String> versionComment = new ArrayList<>();
    //Map<PbnGameTags, PbnGameData> pbnGameDataList = new ArrayHashMap<>();

    List<PbnGameData> pbnGameData = new ArrayList<>();


    public List<String> getVersionComment() {
        return versionComment;
    }

    public void addVersionComment(String versionComment) {
        this.versionComment.add(versionComment);
    }


}
