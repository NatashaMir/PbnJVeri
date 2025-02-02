package io.github.natashamir.pbn_project;/*
 * File   :     PbnDeal.java
 * Author :     Tis Veugen
 * Date   :     1999-10-02
 * PBN    :     2.0
 *
 * History
 * -------
 * 1999-01-03 Added GetHand()
 */

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="pbnDeal")
@XmlAccessorType(XmlAccessType.FIELD)

public class PbnDeal {
    private final PbnHand[] maHands;
    private final PbnNrHand[] maNrHands;

    public PbnDeal() {
        maHands = new PbnHand[PbnSide.NUMBER];
        maNrHands = new PbnNrHand[PbnSide.NUMBER];

        for (int iSide = 0; iSide < PbnSide.NUMBER; iSide++) {
            maHands[iSide] = new PbnHand();
            maNrHands[iSide] = new PbnNrHand();
            maNrHands[iSide].Compute(maHands[iSide]);
        }
    }

    public PbnDeal(
            PbnDeal oDeal) {
        maHands = new PbnHand[PbnSide.NUMBER];
        maNrHands = new PbnNrHand[PbnSide.NUMBER];

        for (int iSide = 0; iSide < PbnSide.NUMBER; iSide++) {
            maHands[iSide] = new PbnHand(oDeal.maHands[iSide]);
            maNrHands[iSide] = new PbnNrHand();
            maNrHands[iSide].Compute(maHands[iSide]);
        }
    }

    public PbnHand GetHand(
            PbnSide oSide) {
        return maHands[oSide.Get()];
    }

    public PbnRanks GetRanks(
            PbnSide oSide,
            PbnSuit oSuit) {
        return maHands[oSide.Get()].GetRanks(oSuit);
    }

    public int GetNrRanks(
            PbnSide oSide,
            PbnSuit oSuit) {
        return maNrHands[oSide.Get()].GetNrRanks(oSuit);
    }

    public int GetNrRanks(
            PbnSide oSide) {
        return maNrHands[oSide.Get()].GetNrRanks();
    }

    public void SetRanks(
            PbnSide oSide,
            PbnSuit oSuit,
            PbnRanks oRanks) {
        int iSide = oSide.Get();

        maHands[iSide].SetRanks(oSuit, oRanks);
        maNrHands[iSide].Compute(maHands[iSide]);
    }

    public boolean PlayCard(
            PbnSide oSide,
            PbnCard oCard) {
        boolean bOk;
        int iSide = oSide.Get();

        bOk = maHands[iSide].PlayCard(oCard);
        if (bOk) {
            maNrHands[iSide].PlayCard(oCard.GetSuit());
        }
        return bOk;
    }

    public boolean UnplayCard(
            PbnSide oSide,
            PbnCard oCard) {
        boolean bOk;
        int iSide = oSide.Get();

        bOk = maHands[iSide].UnplayCard(oCard);
        if (bOk) {
            maNrHands[iSide].UnplayCard(oCard.GetSuit());
        }
        return bOk;
    }
}
