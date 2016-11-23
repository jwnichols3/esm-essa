/*

   Derby - Class org.apache.derby.jdbc.Driver169

   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

 */

package org.apache.derby.jdbc;


import org.apache.derby.iapi.sql.ResultSet;

import org.apache.derby.impl.jdbc.*;

import java.sql.Connection;
import java.sql.SQLException;

import java.util.Properties;


/**
    Driver169 - JDBC "driver" for J2ME/CDC/Foundation/JSR169, really
    the JDBC object factory for the JSR169 environment.
    
    WORK IN PROGRESS


	@author djd
*/

public class Driver169 extends InternalDriver {

	public Driver169() {
	}

	/*
		Methods to be overloaded in sub-implementations such as
		a tracing driver.
	 */
	protected EmbedConnection getNewEmbedConnection(String url, Properties info) 
		 throws SQLException
	{
		// make a new local connection with a new transaction resource
		return new EmbedConnection30(this, url, info);
	}


	/**
 	 * Get a new nested connection.
	 *
	 * @param conn	The EmbedConnection.
	 *
	 * @return A nested connection object.
	 *
	 */
	public Connection getNewNestedConnection(EmbedConnection conn)
	{
		return new EmbedConnection30(conn);
	}

	/*
	** methods to be overridden by subimplementations wishing to insert
	** their classes into the mix.
	*/

	public java.sql.Statement newEmbedStatement(
				EmbedConnection conn,
				boolean forMetaData,
				int resultSetType,
				int resultSetConcurrency,
				int resultSetHoldability)
	{
		return new EmbedStatement(conn, forMetaData, resultSetType, resultSetConcurrency,
		resultSetHoldability);
	}
	/**
	 	@exception SQLException if fails to create statement
	 */
	public java.sql.PreparedStatement newEmbedPreparedStatement(
				EmbedConnection conn,
				String stmt, 
				boolean forMetaData, 
				int resultSetType,
				int resultSetConcurrency,
				int resultSetHoldability,
				int autoGeneratedKeys,
				int[] columnIndexes,
				String[] columnNames)
		throws SQLException

		{
			return new EmbedPreparedStatement169(conn, stmt, forMetaData,
				resultSetType, resultSetConcurrency, resultSetHoldability,
				autoGeneratedKeys, columnIndexes, columnNames);
		}
	/**
	 	@exception SQLException if fails to create statement
	 */
	public java.sql.CallableStatement newEmbedCallableStatement(
				EmbedConnection conn,
				String stmt, 
				int resultSetType,
				int resultSetConcurrency,
				int resultSetHoldability)
		throws SQLException
    {
       return new EmbedCallableStatement169(conn,stmt, resultSetType,
            resultSetConcurrency, resultSetHoldability);
    }


	public EmbedResultSet
		newEmbedResultSet(EmbedConnection conn, ResultSet results, boolean forMetaData, EmbedStatement statement, boolean isAtomic)
	throws SQLException
	{
	    return new EmbedResultSet169(conn, results, forMetaData, statement, isAtomic);
	}



}



