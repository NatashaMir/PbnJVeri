package io.github.natashamir.pbn_project;

/**************************************************************************/

class PbnExportBuffer {
    static final int MAX_LINE_LENGTH = 80;

    private final PbnExport mExport;
    private final StringBuffer mOutputLine;

    public PbnExportBuffer(
            PbnExport oExport) {
        mExport = oExport;

        mOutputLine = new StringBuffer();
    }

    public void flush() {
        if (mOutputLine.length() > 0) {
            write();
        }
    }

    public void reset() {
        mOutputLine.setLength(0);
    }

    public void text(
            String oString) {
        int BufferLength = mOutputLine.length();
        int TextLength = oString.length();
        int SpaceLength = (BufferLength == 0) ? 0 : 1;

        if (TextLength == 0) {
            return;
        }

        if ((BufferLength > 0) &&
                (BufferLength + SpaceLength + TextLength >= MAX_LINE_LENGTH)) {
            write();
            SpaceLength = 0;
        }

        if (SpaceLength != 0) {
            mOutputLine.append(" ");
        }
        mOutputLine.append(oString);

        if (oString.charAt(TextLength - 1) == PbnChar.EOL) { /*
         * The line has an 'eol' :
         * Remove the 'eol', and print it immediately.
         */
            mOutputLine.setLength(mOutputLine.length() - 1);
            write();
        }
    }

    public void write() {
        mExport.exportLine(mOutputLine.toString());
        reset();
    }
}
