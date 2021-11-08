package com.github.natashamir.pbn_project;/*
 * File   :     PbnSituation.java
 * Author :     Tis Veugen
 * Date   :     1998-10-11
 * PBN    :     1.0
 */

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="pbnSituation")
@XmlAccessorType(XmlAccessType.FIELD)

public class PbnSituation {

    private final PbnSide mDealer;

    private final PbnVulner mVulner;

    public PbnSituation() {
        mDealer = new PbnSide();
        mVulner = new PbnVulner();
    }

    public PbnSide GetDealer() {
        return mDealer;
    }

    public PbnVulner GetVulner() {
        return mVulner;
    }
}
