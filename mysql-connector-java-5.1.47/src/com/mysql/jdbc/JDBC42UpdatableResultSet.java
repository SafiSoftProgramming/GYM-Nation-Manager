/*
  Copyright (c) 2015, 2017, Oracle and/or its affiliates. All rights reserved.

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

import java.sql.Date;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Struct;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.format.DateTimeParseException;

import com.mysql.jdbc.Field;
import com.mysql.jdbc.RowData;
import com.mysql.jdbc.SQLError;

public class JDBC42UpdatableResultSet extends JDBC4UpdatableResultSet {

    public JDBC42UpdatableResultSet(String catalog, Field[] fields, RowData tuples, MySQLConnection conn, StatementImpl creatorStmt) throws SQLException {
        super(catalog, fields, tuples, conn, creatorStmt);
    }

    /*
     * Helper methods.
     */

    private int translateAndCheckSqlType(SQLType sqlType) throws SQLException {
        return JDBC42Helper.translateAndCheckSqlType(sqlType, getExceptionInterceptor());
    }

    /**
     * Support for java.time.LocalDate, java.time.LocalTime, java.time.LocalDateTime, java.time.OffsetTime and java.time.OffsetDateTime.
     * 
     * @param columnIndex
     * @param type
     * @return
     * @throws SQLException
     */
    public <T> T getObject(int columnIndex, Class<T> type) throws SQLException {
        synchronized (checkClosed().getConnectionMutex()) {
            if (type == null) {
                throw SQLError.createSQLException("Type parameter can not be null", SQLError.SQL_STATE_ILLEGAL_ARGUMENT, getExceptionInterceptor());
            }

            if (type.equals(LocalDate.class)) {
                return type.cast(getDate(columnIndex).toLocalDate());
            } else if (type.equals(LocalDateTime.class)) {
                return type.cast(getTimestamp(columnIndex).toLocalDateTime());
            } else if (type.equals(LocalTime.class)) {
                return type.cast(getTime(columnIndex).toLocalTime());
            } else if (type.equals(OffsetDateTime.class)) {
                try {
                    return type.cast(OffsetDateTime.parse(getString(columnIndex)));
                } catch (DateTimeParseException e) {
                    // Let it continue and try by object deserialization.
                }
            } else if (type.equals(OffsetTime.class)) {
                try {
                    return type.cast(OffsetTime.parse(getString(columnIndex)));
                } catch (DateTimeParseException e) {
                    // Let it continue and try by object deserialization.
                }
            }

            return super.getObject(columnIndex, type);
        }
    }

    /**
     * Support for java.time.LocalDate, java.time.LocalTime, java.time.LocalDateTime, java.time.OffsetTime and java.time.OffsetDateTime.
     * 
     * @param columnIndex
     * @param x
     * @throws SQLException
     */
    @Override
    public void updateObject(int columnIndex, Object x) throws SQLException {
        super.updateObject(columnIndex, JDBC42Helper.convertJavaTimeToJavaSql(x)dex
035 V�+��A��#� a��������X  p   xV4        �     p      �      �      �      �      �   D    0  8  ;  d  �  �  �  �  �  �  �        D                                    
                                       �  Z  h       ,     p    t  <init> I 'Landroid/support/mediacompat/R$integer; Landroid/support/mediacompat/R; "Ldalvik/annotation/EnclosingClass; Ldalvik/annotation/InnerClass; Ljava/lang/Object; R.java V accessFlags cancel_button_image_alpha integer name #status_bar_notification_info_maxnum value 	    ���d d         K  Q  x                                  p         �         �         �         �         �                 ,        0        K         Z        h       t        �        �                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      