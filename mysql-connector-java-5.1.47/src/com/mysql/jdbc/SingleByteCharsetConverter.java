dex
035 ��)Kcd)��m(�����	�wk��8  p   xV4        t     p      �      �      �      �      �   0    $  ,  /  d  �  �  �  �  �  �      %  +                                    	                                 d  A  M             p    #  <init> I 3Landroid/support/graphics/drawable/animated/R$bool; .Landroid/support/graphics/drawable/animated/R; "Ldalvik/annotation/EnclosingClass; Ldalvik/annotation/InnerClass; Ljava/lang/Object; R.java V abc_action_bar_embed_tabs accessFlags bool name value 
    ���d          2  8  X                                  p         �         �         �         �         �                          $        2         A        M       T        d        t                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          h of length to a string
     * using the default platform encoding.
     * 
     * @param buffer
     *            the bytes to convert
     * @param startPos
     *            the index to start at
     * @param length
     *            the number of bytes to convert
     * @return the String representation of the given bytes
     */
    public static String toStringDefaultEncoding(byte[] buffer, int startPos, int length) {
        return new String(buffer, startPos, length);
    }

    private char[] byteToChars = new char[BYTE_RANGE];

    private byte[] charToByteMap = new byte[65536];

    /**
     * Prevent instantiation, called out of static method initCharset().
     * 
     * @param encodingName
     *            a JVM character encoding
     * @throws UnsupportedEncodingException
     *             if the JVM does not support the encoding
     */
    private SingleByteCharsetConverter(String encodingName) throws UnsupportedEncodingException {
        String allBytesString = new String(allBytes, 0, BYTE_RANGE, encodingName);
        int allBytesLen = allBytesString.length();

        System.arraycopy(unknownCharsMap, 0, this.charToByteMap, 0, this.charToByteMap.length);

        for (int i = 0; i < BYTE_RANGE && i < allBytesLen; i++) {
            char c = allBytesString.charAt(i);
            this.byteToChars[i] = c;
            this.charToByteMap[c] = allBytes[i];
        }
    }

    public final byte[] toBytes(char[] c) {
        if (c == null) {
            return null;
        }

        int length = c.length;
        byte[] bytes = new byte[length];

        for (int i = 0; i < length; i++) {
            bytes[i] = this.charToByteMap[c[i]];
        }

        return bytes;
    }

    public final byte[] toBytesWrapped(char[] c, char beginWrap, char endWrap) {
        if (c == null) {
            return null;
        }

        int length = c.length + 2;
        int charLength = c.length;

        byte[] bytes = new byte[length];
        bytes[0] = this.charToByteMap[beginWrap];

        for (int i = 0; i < charLength; i++) {
            bytes[i + 1] = this.charToByteMap[c[i]];
        }

        bytes[length - 1] = this.charToByteMap[endWrap];

        return bytes;
    }

    public final byte[] toBytes(char[] chars, int offset, int length) {
        if (chars == null) {
            return null;
        }

        if (length == 0) {
            return EMPTY_BYTE_ARRAY;
        }

        byte[] bytes = new byte[length];

        for (int i = 0; (i < length); i++) {
            bytes[i] = this.charToByteMap[chars[i + offset]];
        }

        return bytes;
    }

    /**
     * Convert the given string to an array of bytes.
     * 
     * @param s
     *            the String to convert
     * @return the bytes that make up the String
     */
    public final byte[] toBytes(String s) {
        if (s == null) {
            return null;
        }

        int length = s.length();
        byte[] bytes = new byte[length];

        for (int i = 0; i < length; i++) {
            bytes[i] = this.charToByteMap[s.charAt(i)];
        }

        return bytes;
    }

    public final byte[] toBytesWrapped(String s, char beginWrap, char endWrap) {
        if (s == null) {
            return null;
        }

        int stringLength = s.length();

        int length = stringLength + 2;

        byte[] bytes = new byte[length];

        bytes[0] = this.charToByteMap[beginWrap];

        for (int i = 0; i < stringLength; i++) {
            bytes[i + 1] = this.charToByteMap[s.charAt(i)];
        }

        bytes[length - 1] = this.charToByteMap[endWrap];

        return bytes;
    }

    /**
     * Convert the given string to an array of bytes.
     * 
     * @param s
     *            the String to convert
     * @param offset
     *            the offset to start at
     * @param length
     *            length (max) to convert
     * 
     * @return the bytes that make up the String
     */
    public final byte[] toBytes(String s, int offset, int length) {
        if (s == null) {
            return null;
        }

        if (length == 0) {
            return EMPTY_BYTE_ARRAY;
        }

        byte[] bytes = new byte[length];

        for (int i = 0; (i < length); i++) {
            char c = s.charAt(i + offset);
            bytes[i] = this.charToByteMap[c];
        }

        return bytes;
    }

    /**
     * Convert the byte buffer to a string using this instance's character
     * encoding.
     * 
     * @param buffer
     *            the bytes to convert to a String
     * @return the converted String
     */
    public final String toString(byte[] buffer) {
        return toString(buffer, 0, buffer.length);
    }

    /**
     * Convert the byte buffer from startPos to a length of length to a string
     * using this instance's character encoding.
     * 
     * @param buffer
     *            the bytes to convert
     * @param startPos
     *            the index to start at
     * @param length
     *            the number of bytes to convert
     * @return the String representation of the given bytes
     */
    public final String toString(byte[] buffer, int startPos, int length) {
        char[] charArray = new char[length];
        int readpoint = startPos;

        for (int i = 0; i < length; i++) {
            charArray[i] = this.byteToChars[buffer[readpoint] - Byte.MIN_VALUE];
            readpoint++;
        }

        return new String(charArray);
    }
}
