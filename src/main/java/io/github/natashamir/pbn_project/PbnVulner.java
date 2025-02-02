package io.github.natashamir.pbn_project;/*
 * File   :     PbnVulner.java
 * Author :     Tis Veugen
 * Date   :     1999-09-0612
 * PBN    :     2.0
 *
 * History
 * -------
 * 1999-05-12 add IsNS() and IsEW().
 * 1999-09-06 add equals()
 */

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Definition of Vulner
 */

@XmlRootElement(name="pbnVulner")
@XmlAccessorType(XmlAccessType.PROPERTY)

public class PbnVulner {
    public static final int IDLE = -1;
    public static final int NONE = 0;
    public static final int NS = 1;
    public static final int EW = 2;
    public static final int ALL = 3;
    public static final int EMPTY = 4;
    public static final int UNKNOWN = 5;

    public static final String S_IDLE = "_";
    public static final String S_NONE = "None";
    public static final String S_LOVE = "Love";
    public static final String S_DASH = "-";
    public static final String S_NS = "NS";
    public static final String S_EW = "EW";
    public static final String S_ALL = "All";
    public static final String S_BOTH = "Both";
    public static final String S_EMPTY = "";
    public static final String S_UNKNOWN = "?";

    private int mVulner;

    public PbnVulner() {
        mVulner = UNKNOWN;
    }

    public PbnVulner(
            int iVulner) {
        mVulner = iVulner;
    }

    public void Set(
            int iVulner) {
        mVulner = iVulner;
    }

    public void Set(
            PbnVulner oVulner) {
        mVulner = oVulner.mVulner;
    }

    public boolean equals(
            PbnVulner oVulner) {
        return mVulner == oVulner.mVulner;
    }

    public boolean Is(
            int iVulner) {
        return mVulner == iVulner;
    }

    public boolean IsIdle() {
        return mVulner == IDLE;
    }

    public boolean IsNS() {
        return (mVulner == NS) || (mVulner == ALL);
    }

    public boolean IsEW() {
        return (mVulner == EW) || (mVulner == ALL);
    }

    public String getmVulner(){
        return toString();
    }

    public void setmVulner(String s){

    }

    public String toString() {
        String string = S_IDLE;

        switch (mVulner) {
            case NONE:
                string = S_NONE;
                break;

            case NS:
                string = S_NS;
                break;

            case EW:
                string = S_EW;
                break;

            case ALL:
                string = S_ALL;
                break;

            case EMPTY:
                string = S_EMPTY;
                break;

            case UNKNOWN:
                string = S_UNKNOWN;
                break;
        }

        return string;
    }


}
