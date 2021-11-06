package com.github.natashamir.pbn_project;

class PbnExportAdmin {
    public PbnDeal mDeal;
    public PbnHand mUnknownHand;
    public boolean[] mabUnknownSides;
    public char[][] maacIllegals;

    public PbnExportAdmin(
            PbnDeal oDeal) {
        mDeal = new PbnDeal(oDeal);
        mUnknownHand = new PbnHand();

        mabUnknownSides = new boolean[PbnSide.NUMBER];
        maacIllegals = new char[PbnTrick.NUMBER][PbnSide.NUMBER];

        /*
         * Hands with no cards are considered as unknown hands.
         */
        PbnSide lSide = new PbnSide(PbnSide.SOUTH);
        for (int iSide = 0; iSide < PbnSide.NUMBER; iSide++) {
            mabUnknownSides[iSide] = (mDeal.GetNrRanks(lSide) == 0);
            lSide.Next();

            for (int iTrick = 0; iTrick < PbnTrick.NUMBER; iTrick++) {
                maacIllegals[iTrick][iSide] = ' ';
            }
        }
    }
}
