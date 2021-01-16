/*
  Copyright (c) 2002, 2016, Oracle and/or its affiliates. All rights reserved.

  The MySQL Connector/J is licensed under the terms of the GPLv2
  <http://www.gnu.org/licenses/old-licenses/gpl-2.0.html>, like most MySQL Connectors.
  There are special exceptions to the terms and conditions of the GPLv2 as it is applied to
  this software, see the FOSS License Exception
  <http://www.mysql.com/about/legal/licensing/foss-exception.html>.

  This program is free software; you can redistribute it and/or modify it under the terms
  of the GNU General Public License as published by the Free Software Foundation; version 2
  of the License.

  This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
  See the GNU General Public License for more details.

  You should have received a copy of the GNU General Public License along with this
  program; if not, write to the Free Software Foundation, Inc., 51 Franklin St, Fifth
  Floor, Boston, MA 02110-1301  USA

 */

package com.mysql.jdbc;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.SQLXML;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stax.StAXResult;
import javax.xml.transform.stax.StAXSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXException;

public class JDBC4MysqlSQLXML implements SQLXML {

    private XMLInputFactory inputFactory;

    private XMLOutputFactory outputFactory;

    private String stringRep;

    private ResultSetInternalMethods owningResultSet;

    private int columnIndexOfXml;

    private boolean fromResultSet;

    private boolean isClosed = false;

    private boolean workingWithResult;

    private DOMResult asDOMResult;

    private SAXResult asSAXResult;

    private SimpleSaxToReader saxToReaderConverter;

    private StringWriter asStringWriter;

    private ByteArrayOutputStream asByteArrayOutputStream;

    private ExceptionInterceptor exceptionInterceptor;

    protected JDBC4MysqlSQLXML(ResultSetInternalMethods owner, int index, ExceptionInterceptor exceptionInterceptor) {
        this.owningResultSet = owner;
        this.columnIndexOfXml = index;
        this.fromResultSet = true;
        this.exceptionInterceptor = exceptionInterceptor;
    }

    protected JDBC4MysqlSQLXML(ExceptionInterceptor exceptionInterceptor) {
        this.fromResultSet = false;
        this.exceptionInterceptor = exceptionInterceptor;
    }

    public synchronized void free() throws SQLException {
        this.stringRep = null;
        this.asDOMResult = null;
        this.asSAXResult = null;
        this.inputFactory = null;
        this.outputFactory = null;
        this.owningResultSet = null;
        this.workingWithResult = false;
        this.isClosed = true;

    }

    public synchronized String getString() throws SQLException {
        checkClosed();
        checkWorkingWithResult();

        if (this.fromResultSet) {
            return this.owningResultSet.getString(this.columnIndexOfXml);
        }

        return this.stringRep;
    }

    private synchronized void checkClosed() throws SQLException {
        if (this.isClosed) {
            throw SQLError.createSQLException("SQLXMLInstance has been free()d", this.exceptionInterceptor);
        }
    }

    private synchronized void checkWorkingWithResult() throws SQLException {
        if (this.workingWithResult) {
            throw SQLError.createSQLException("Can't perform requested operation after getResult() has been called to write XML data",
                    SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
        }
    }

    /**
     * Sets the XML value designated by this SQLXML instance to the given String
     * representation. The format of this String is defined by
     * org.xml.sax.InputSource, where the characters in the stream represent the
     * unicode code points for XML according to section 2 and appendix B of the
     * XML 1.0 specification. Although an encoding declaration other than
     * unicode may be present, the encoding of the String is unicode. The
     * behavior of this method is the same as ResultSet.updateString() when the
     * designated column of the ResultSet has a type java.sql.Types of SQLXML.
     * <p>
     * The SQL XML object becomes not writeable when this method is called and may also become not readable depending on implementation.
     * 
     * @param value
     *            the XML value
     * @throws SQLException
     *             if there is an error processing the XML value. The getCause()
     *             method of the exception may provide a more detailed
     *             exception, for example, if the stream does not contain valid
     *             characters. An exception is thrown if the state is not
     *             writable.
     * @exception SQLFeatureNotSupportedException
     *                if the JDBC driver does not support this method
     * @since 1.6
     */

    public synchronized void setString(String str) throws SQLException {
        checkClosed();
        checkWorkingWithResult();

        this.stringRep = str;
        this.fromResultSet = false;
    }

    public synchronized boolean isEmpty() throws SQLException {
        checkClosed();
        checkWorkingWithResult();

        if (!this.fromResultSet) {
            return this.stringRep == null || this.stringRep.length() == 0;
        }

        return false;
    }

    public synchronized InputStream getBinaryStream() throws SQLException {
        checkClosed();
        checkWorkingWithResult();

        return this.owningResultSet.getBinaryStream(this.columnIndexOfXml);
    }

    /**
     * Retrieves the XML value designated by this SQLXML instance as a
     * java.io.Reader object. The format of this stream is defined by
     * org.xml.sax.InputSource, where the characters in the stream represent the
     * unicode code points for XML according to section 2 and appendix B of the
     * XML 1.0 specification. Although an encoding declaration other than
     * unicode may be present, the encoding of the stream is unicode. The
     * behavior of this method is the same as ResultSet.getCharacterStream()
     * when the designated column of the ResultSet has a type java.sql.Types of
     * SQLXML.
     * <p>
     * The SQL XML object becomes not readable when this method is called and may also become not writable depending on implementation.
     * 
     * @return a stream containing the XML data.
     * @throws SQLException
     *             if there is an error processing the XML value. The getCause()
     *             method of the exception may provide a more detailed
     *             exception, for example, if the stream does not contain valid
     *             characters. An exception is throwdex
035 ¥h∑'z§´⁄Qò¥ˇ:>··>wÆ(  p   xV4        d     p      ‘            ¸      \     l  ú  å  ®  ∞  ≥  ›  ˛  "  B  V  ^  a  n  x  ~  û  Ø  ƒ  ‡  ˝    5  S  r  ï  ´  Œ                                                                                                                                       T  ‰         §     p    B  <init> I (Landroid/support/mediacompat/R$drawable; Landroid/support/mediacompat/R; "Ldalvik/annotation/EnclosingClass; Ldalvik/annotation/InnerClass; Ljava/lang/Object; R.java V accessFlags drawable name notification_action_background notification_bg notification_bg_low notification_bg_low_normal notification_bg_low_pressed notification_bg_normal notification_bg_normal_pressed notification_icon_background notification_template_icon_bg !notification_template_icon_low_bg notification_tile_bg !notify_panel_notification_icon_bg value 	
    ÇÄådÅ dÇ dÉ dÑ dÖ dÜ dá dà dâ dä dã då         ’  €  H                                  p         ‘                  ¸         \        l        å        §        ®        ’         ‰               D        T        d                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          urce(builder.parse(inputSource));
            } catch (Throwable t) {
                SQLException sqlEx = SQLError.createSQLException(t.getMessage(), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
                sqlEx.initCause(t);

                throw sqlEx;
            }

        } else if (clazz.equals(StreamSource.class)) {
            Reader reader = null;

            if (this.fromResultSet) {
                reader = this.owningResultSet.getCharacterStream(this.columnIndexOfXml);
            } else {
                reader = new StringReader(this.stringRep);
            }

            return (T) new StreamSource(reader);
        } else if (clazz.equals(StAXSource.class)) {
            try {
                Reader reader = null;

                if (this.fromResultSet) {
                    reader = this.owningResultSet.getCharacterStream(this.columnIndexOfXml);
                } else {
                    reader = new StringReader(this.stringRep);
                }

                return (T) new StAXSource(this.inputFactory.createXMLStreamReader(reader));
            } catch (XMLStreamException ex) {
                SQLException sqlEx = SQLError.createSQLException(ex.getMessage(), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
                sqlEx.initCause(ex);

                throw sqlEx;
            }
        } else {
            throw SQLError.createSQLException("XML Source of type \"" + clazz.toString() + "\" Not supported.", SQLError.SQL_STATE_ILLEGAL_ARGUMENT,
                    this.exceptionInterceptor);
        }
    }

    /**
     * Retrieves a stream that can be used to write the XML value that this
     * SQLXML instance represents. The stream begins at position 0. The bytes of
     * the stream are interpreted according to appendix F of the XML 1.0
     * specification The behavior of this method is the same as
     * ResultSet.updateBinaryStream() when the designated column of the
     * ResultSet has a type java.sql.Types of SQLXML.
     * <p>
     * The SQL XML object becomes not writeable when this method is called and may also become not readable depending on implementation.
     * 
     * @return a stream to which data can be written.
     * @throws SQLException
     *             if there is an error processing the XML value. An exception
     *             is thrown if the state is not writable.
     * @exception SQLFeatureNotSupportedException
     *                if the JDBC driver does not support this method
     * @since 1.6
     */
    public synchronized OutputStream setBinaryStream() throws SQLException {
        checkClosed();
        checkWorkingWithResult();

        this.workingWithResult = true;

        return setBinaryStreamInternal();
    }

    private synchronized OutputStream setBinaryStreamInternal() throws SQLException {
        this.asByteArrayOutputStream = new ByteArrayOutputStream();

        return this.asByteArrayOutputStream;
    }

    /**
     * Retrieves a stream to be used to write the XML value that this SQLXML
     * instance represents. The format of this stream is defined by
     * org.xml.sax.InputSource, where the characters in the stream represent the
     * unicode code points for XML according to section 2 and appendix B of the
     * XML 1.0 specification. Although an encoding declaration other than
     * unicode may be present, the encoding of the stream is unicode. The
     * behavior of this method is the same as ResultSet.updateCharacterStream()
     * when the designated column of the ResultSet has a type java.sql.Types of
     * SQLXML.
     * <p>
     * The SQL XML object becomes not writeable when this method is called and may also become not readable depending on implementation.
     * 
     * @return a stream to which data can be written.
     * @throws SQLException
     *             if there is an error processing the XML value. The getCause()
     *             method of the exception may provide a more detailed
     *             exception, for example, if the stream does not contain valid
     *             characters. An exception is thrown if the state is not
     *             writable.
     * @exception SQLFeatureNotSupportedException
     *                if the JDBC driver does not support this method
     * @since 1.6
     */
    public synchronized Writer setCharacterStream() throws SQLException {
        checkClosed();
        checkWorkingWithResult();

        this.workingWithResult = true;

        return setCharacterStreamInternal();
    }

    private synchronized Writer setCharacterStreamInternal() throws SQLException {
        this.asStringWriter = new StringWriter();

        return this.asStringWriter;
    }

    /**
     * Returns a Result for setting the XML value designated by this SQLXML
     * instance.
     * <p>
     * The systemID of the Result is implementation dependent.
     * <p>
     * The SQL XML object becomes not writeable when this method is called and may also become not readable depending on implementation.
     * <p>
     * Note that SAX is a callback architecture and the returned SAXResult has a content handler assigned that will receive the SAX events based on the contents
     * of the XML. Call the content handler with the contents of the XML document to assign the values.
     * 
     * <pre>
     * SAXResult saxResult = sqlxml.setResult(SAXResult.class);
     * ContentHandler contentHandler = saxResult.getXMLReader().getContentHandler();
     * contentHandler.startDocument();
     * // set the XML elements and attributes into the result
     * contentHandler.endDocument();
     * </pre>
     * 
     * @param resultClass
     *            The class of the result, or null. If resultClass is null, a
     *            vendor specific Result implementation will be returned. The
     *            following classes are supported at a minimum:
     * 
     *            <pre>
     *    javax.xml.transform.dom.DOMResult - returns a DOMResult
     *    javax.xml.transform.sax.SAXResult - returns a SAXResult
     *    javax.xml.transform.stax.StAXResult - returns a StAXResult
     *    javax.xml.transform.stream.StreamResult - returns a StreamResult
     *            </pre>
     * 
     * @return Returns a Result for setting the XML value.
     * @throws SQLException
     *             if there is an error processing the XML value or if this
     *             feature is not supported. The getCause() method of the
     *             exception may provide a more detailed exception, for example,
     *             if an XML parser exception occurs. An exception is thrown if
     *             the state is not writable.
     * @exception SQLFeatureNotSupportedException
     *                if the JDBC driver does not support this method
     * @since 1.6
     */
    @SuppressWarnings("unchecked")
    public synchronized <T extends Result> T setResult(Class<T> clazz) throws SQLException {
        checkClosed();
        checkWorkingWithResult();

        this.workingWithResult = true;
        this.asDOMResult = null;
        this.asSAXResult = null;
        this.saxToReaderConverter = null;
        this.stringRep = null;
        this.asStringWriter = null;
        this.asByteArrayOutputStream = null;

        if (clazz == null || clazz.equals(SAXResult.class)) {
            this.saxToReaderConverter = new SimpleSaxToReader();

            this.asSAXResult = new SAXResult(this.saxToReaderConverter);

            return (T) this.asSAXResult;
        } else if (clazz.equals(DOMResult.class)) {

            this.asDOMResult = new DOMResult();
            return (T) this.asDOMResult;

        } else if (clazz.equals(StreamResult.class)) {
            return (T) new StreamResult(setCharacterStreamInternal());
        } else if (clazz.equals(StAXResult.class)) {
            try {
                if (this.outputFactory == null) {
                    this.outputFactory = XMLOutputFactory.newInstance();
                }

                return (T) new StAXResult(this.outputFactory.createXMLEventWriter(setCharacterStreamInternal()));
            } catch (XMLStreamException ex) {
                SQLException sqlEx = SQLError.createSQLException(ex.getMessage(), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
                sqlEx.initCause(ex);

                throw sqlEx;
            }
        } else {
            throw SQLError.createSQLException("XML Result of type \"" + clazz.toString() + "\" Not supported.", SQLError.SQL_STATE_ILLEGAL_ARGUMENT,
                    this.exceptionInterceptor);
        }
    }

    private Reader binaryInputStreamStreamToReader(ByteArrayOutputStream out) {

        try {
            // There's got to be an easier way to do this, but I don't feel like coding up Appendix F of the XML Spec myself, when there's a reusable way to do
            // it, and we can warn folks away from BINARY xml streams that have to be parsed to determine the character encoding :P

            String encoding = "UTF-8";

            try {
                ByteArrayInputStream bIn = new ByteArrayInputStream(out.toByteArray());
                XMLStreamReader reader = this.inputFactory.createXMLStreamReader(bIn);

                int eventType = 0;

                while ((eventType = reader.next()) != XMLStreamReader.END_DOCUMENT) {
                    if (eventType == XMLStreamReader.START_DOCUMENT) {
                        String possibleEncoding = reader.getEncoding();

                        if (possibleEncoding != null) {
                            encoding = possibleEncoding;
                        }

                        break;
                    }
                }
            } catch (Throwable t) {
                // ignore, dealt with later when the string can't be parsed into valid XML
            }

            return new StringReader(new String(out.toByteArray(), encoding));
        } catch (UnsupportedEncodingException badEnc) {
            throw new RuntimeException(badEnc);
        }
    }

    protected String readerToString(Reader reader) throws SQLException {
        StringBuilder buf = new StringBuilder();

        int charsRead = 0;

        char[] charBuf = new char[512];

        try {
            while ((charsRead = reader.read(charBuf)) != -1) {
                buf.append(charBuf, 0, charsRead);
            }
        } catch (IOException ioEx) {
            SQLException sqlEx = SQLError.createSQLException(ioEx.getMessage(), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
            sqlEx.initCause(ioEx);

            throw sqlEx;
        }

        return buf.toString();
    }

    protected synchronized Reader serializeAsCharacterStream() throws SQLException {
        checkClosed();
        if (this.workingWithResult) {
            // figure out what kind of result
            if (this.stringRep != null) {
                return new StringReader(this.stringRep);
            }

            if (this.asDOMResult != null) {
                return new StringReader(domSourceToString());
            }

            if (this.asStringWriter != null) { // stax result
                return new StringReader(this.asStringWriter.toString());
            }

            if (this.asSAXResult != null) {
                return this.saxToReaderConverter.toReader();
            }

            if (this.asByteArrayOutputStream != null) {
                return binaryInputStreamStreamToReader(this.asByteArrayOutputStream);
            }
        }

        return this.owningResultSet.getCharacterStream(this.columnIndexOfXml);
    }

    protected String domSourceToString() throws SQLException {
        try {
            DOMSource source = new DOMSource(this.asDOMResult.getNode());
            Transformer identity = TransformerFactory.newInstance().newTransformer();
            StringWriter stringOut = new StringWriter();
            Result result = new StreamResult(stringOut);
            identity.transform(source, result);

            return stringOut.toString();
        } catch (Throwable t) {
            SQLException sqlEx = SQLError.createSQLException(t.getMessage(), SQLError.SQL_STATE_ILLEGAL_ARGUMENT, this.exceptionInterceptor);
            sqlEx.initCause(t);

            throw sqlEx;
        }
    }

    protected synchronized String serializeAsString() throws SQLException {
        checkClosed();
        if (this.workingWithResult) {
            // figure out what kind of result
            if (this.stringRep != null) {
                return this.stringRep;
            }

            if (this.asDOMResult != null) {
                return domSourceToString();
            }

            if (this.asStringWriter != null) { // stax result
                return this.asStringWriter.toString();
            }

            if (this.asSAXResult != null) {
                return readerToString(this.saxToReaderConverter.toReader());
            }

            if (this.asByteArrayOutputStream != null) {
                return readerToString(binaryInputStreamStreamToReader(this.asByteArrayOutputStream));
            }
        }

        return this.owningResultSet.getString(this.columnIndexOfXml);
    }

    /*
     * The SimpleSaxToReader class is an adaptation of the SAX "Writer"
     * example from the Apache XercesJ-2 Project. The license for this
     * code is as follows:
     * 
     * Licensed to the Apache Software Foundation (ASF) under one or more
     * contributor license agreements. See the NOTICE file distributed with
     * this work for additional information regarding copyright ownership.
     * The ASF licenses this file to You under the Apache License, Version 2.0
     * (the "License"); you may not use this file except in compliance with
     * the License. You may obtain a copy of the License at
     * 
     * http://www.apache.org/licenses/LICENSE-2.0
     * 
     * Unless required by applicable law or agreed to in writing, software
     * distributed under the License is distributed on an "AS IS" BASIS,
     * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
     * See the License for the specific language governing permissions and
     * limitations under the License.
     */

    class SimpleSaxToReader extends DefaultHandler {
        StringBuilder buf = new StringBuilder();

        public void startDocument() throws SAXException {
            buf.append("<?xml version='1.0' encoding='UTF-8'?>");
        }

        public void endDocument() throws SAXException {
            // Do we need to override this?
        }

        public void startElement(String namespaceURI, String sName, String qName, Attributes attrs) throws SAXException {

            this.buf.append("<");
            this.buf.append(qName);

            if (attrs != null) {
                for (int i = 0; i < attrs.getLength(); i++) {
                    this.buf.append(" ");
                    this.buf.append(attrs.getQName(i)).append("=\"");
                    escapeCharsForXml(attrs.getValue(i), true);
                    this.buf.append("\"");
                }
            }

            this.buf.append(">");
        }

        public void characters(char buf[], int offset, int len) throws SAXException {
            if (!this.inCDATA) {
                escapeCharsForXml(buf, offset, len, false);
            } else {
                this.buf.append(buf, offset, len);
            }
        }

        public void ignorableWhitespace(char ch[], int start, int length) throws SAXException {
            characters(ch, start, length);
        }

        private boolean inCDATA = false;

        public void startCDATA() throws SAXException {
            this.buf.append("<![CDATA[");
            this.inCDATA = true;
        }

        public void endCDATA() throws SAXException {
            this.inCDATA = false;
            this.buf.append("]]>");
        }

        public void comment(char ch[], int start, int length) throws SAXException {
            // if (!fCanonical && fElementDepth > 0) {
            this.buf.append("<!--");
            for (int i = 0; i < length; ++i) {
                this.buf.append(ch[start + i]);
            }
            this.buf.append("-->");
            // }
        }

        Reader toReader() {
            return new StringReader(this.buf.toString());
        }

        private void escapeCharsForXml(String str, boolean isAttributeData) {
            if (str == null) {
                return;
            }

            int strLen = str.length();

            for (int i = 0; i < strLen; i++) {
                escapeCharsForXml(str.charAt(i), isAttributeData);
            }
        }

        private void escapeCharsForXml(char[] buf, int offset, int len, boolean isAttributeData) {

            if (buf == null) {
                return;
            }

            for (int i = 0; i < len; i++) {
                escapeCharsForXml(buf[offset + i], isAttributeData);
            }
        }

        private void escapeCharsForXml(char c, boolean isAttributeData) {
            switch (c) {
                case '<':
                    this.buf.append("&lt;");
                    break;

                case '>':
                    this.buf.append("&gt;");
                    break;

                case '&':
                    this.buf.append("&amp;");
                    break;

                case '"':

                    if (!isAttributeData) {
                        this.buf.append("\"");
                    } else {
                        this.buf.append("&quot;");
                    }

                    break;

                case '\r':
                    this.buf.append("&#xD;");
                    break;

                default:

                    if (((c >= 0x01 && c <= 0x1F && c != 0x09 && c != 0x0A) || (c >= 0x7F && c <= 0x9F) || c == 0x2028)
                            || isAttributeData && (c == 0x09 || c == 0x0A)) {
                        this.buf.append("&#x");
                        this.buf.append(Integer.toHexString(c).toUpperCase());
                        this.buf.append(";");
                    } else {
                        this.buf.append(c);
                    }
            }
        }
    }
}