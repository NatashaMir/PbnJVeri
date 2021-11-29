package io.github.natashamir.pbn_project;/*
 * File   :     PbnNrHand.java
 * Author :     Tis Veugen
 * Date   :     1998-10-11
 * PBN    :     1.0
 */

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="pbnNrHand")
@XmlAccessorType(XmlAccessType.FIELD)

public class PbnNrHand {
    private final int[] maNrRanks;

    public PbnNrHand() {
        maNrRanks = new int[PbnSuit.NUMBER];
    }

    public int GetNrRanks(
            PbnSuit oSuit) {
        return maNrRanks[oSuit.Get()];
    }

    // Get number of ranks of all suits.
    public int GetNrRanks() {
        int iNrRanks = 0;

        for (int iSuit = 0; iSuit < PbnSuit.NUMBER; iSuit++) {
            iNrRanks += maNrRanks[iSuit];
        }

        return iNrRanks;
    }

    public boolean PlayCard(
            PbnSuit oSuit) {
        int iSuit = oSuit.Get();

        if (maNrRanks[iSuit] == 0) {
            return false;
        }

        maNrRanks[iSuit]--;
        return true;
    }

    public boolean UnplayCard(
            PbnSuit oSuit) {
        int iSuit = oSuit.Get();

        if (maNrRanks[iSuit] >= PbnRank.NUMBER) {
            return false;
        }

        maNrRanks[iSuit]++;
        return true;
    }

    public void Compute(
            PbnHand oHand) {
        for (int iSuit = 0; iSuit < PbnSuit.NUMBER; iSuit++) {
            maNrRanks[iSuit] = oHand.GetNrRanks(iSuit);
        }
    }

}
