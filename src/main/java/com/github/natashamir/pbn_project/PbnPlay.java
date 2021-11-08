package com.github.natashamir.pbn_project;/*
 * File   :     PbnPlay.java
 * Author :     Tis Veugen
 * Date   :     1999-05-19
 * PBN    :     1.0
 *
 * History
 * -------
 * 1999-05-19 check array index in GetCard() and SetCard().
 */

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="pbnPlay")
@XmlAccessorType(XmlAccessType.FIELD)

public class PbnPlay {
    private final PbnTrick[] maTricks;
    private final PbnSide[] maFirsts;

    public PbnPlay() {
        maTricks = new PbnTrick[PbnTrick.NUMBER];
        maFirsts = new PbnSide[PbnTrick.NUMBER];

        for (int i = 0; i < PbnTrick.NUMBER; i++) {
            maTricks[i] = new PbnTrick();
            maFirsts[i] = new PbnSide();
        }
    }

    public PbnSide GetFirst(
            int iIndex) {
        return maFirsts[iIndex];
    }

    public void SetFirst(
            int iIndex,
            PbnSide oSide) {
        maFirsts[iIndex].Set(oSide);
    }

    public PbnCard GetCard(
            int iIndex,
            PbnSide oSide) {
        if (iIndex >= PbnTrick.NUMBER) { /*
         * The file is already wrong.
         */
            iIndex = PbnTrick.NUMBER - 1;
        }

        return maTricks[iIndex].Get(oSide);
    }

    public void SetCard(
            int iIndex,
            PbnSide oSide,
            PbnCard oCard) {
        if (iIndex < PbnTrick.NUMBER) {
            maTricks[iIndex].Set(oSide, oCard);
        }
    }
}
