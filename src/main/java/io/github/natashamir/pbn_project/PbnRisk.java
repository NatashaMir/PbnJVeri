package io.github.natashamir.pbn_project;/*
 * File   :     PbnRisk.java
 * Author :     Tis Veugen
 * Date   :     1999-05-12
 * PBN    :     1.0
 *
 * History
 * -------
 * 1999-05-12 add Is().
 */

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Definition of Risk
 */

@XmlRootElement(name="pbnRisk")
@XmlAccessorType(XmlAccessType.PROPERTY)

public class PbnRisk {
    public static final int IDLE = -1;
    public static final int NONE = 0;
    public static final int DOUBLE = 1;
    public static final int REDOUBLE = 2;
    public static final int UNKNOWN = 3;

    public static final String S_IDLE = "_";
    public static final String S_NONE = "";
    public static final String S_DOUBLE = "X";
    public static final String S_REDOUBLE = "XX";
    public static final String S_UNKNOWN = "?";

    int mRisk;

    public PbnRisk() {
        mRisk = IDLE;
    }

    public PbnRisk(int Risk) {
        mRisk = Risk;
    }

    public int Get() {
        return mRisk;
    }

    public void Set(
            int iRisk) {
        mRisk = iRisk;
    }

    public void Set(
            PbnRisk oRisk) {
        mRisk = oRisk.mRisk;
    }

    public boolean equals(
            PbnRisk oRisk) {
        return mRisk == oRisk.mRisk;
    }

    public boolean Is(
            int iRisk) {
        return mRisk == iRisk;
    }

    public String toString() {
        String string = S_IDLE;

        switch (mRisk) {
            case NONE:
                string = S_NONE;
                break;

            case DOUBLE:
                string = S_DOUBLE;
                break;

            case REDOUBLE:
                string = S_REDOUBLE;
                break;

            case UNKNOWN:
                string = S_UNKNOWN;
                break;
        }

        return string;
    }

    public String getmRisk() {
        return toString();
    }

    public void setmRisk(String s) {
    }
}
