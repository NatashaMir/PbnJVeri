package com.github.natashamir.pbn_project;/*
 * File   :     PbnTrick.java
 * Author :     Tis Veugen
 * Date   :     1998-10-11
 * PBN    :     1.0
 */

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="pbnTrick")
@XmlAccessorType(XmlAccessType.FIELD)

public class PbnTrick {
    static final int NUMBER = 13;

    private final PbnCard[] maCards;

    public PbnTrick() {
        maCards = new PbnCard[PbnSide.NUMBER];

        for (int i = 0; i < PbnSide.NUMBER; i++) {
            maCards[i] = new PbnCard();
        }
    }

    public PbnCard Get(
            PbnSide oSide) {
        return maCards[oSide.Get()];
    }

    public void Set(
            PbnSide oSide,
            PbnCard oCard) {
        maCards[oSide.Get()].Set(oCard);
    }
}
