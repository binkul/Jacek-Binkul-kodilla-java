package com.kodilla.jdbc;

import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertEquals;

public class StoredProcTestSuite {

    @Test
    public void testUpdateVipLevels() throws SQLException {
        // Given
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "UPDATE readers SET Vip_Level=\"Not Set\"";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);
        // When
        String sqlProcedureCall = "CALL UpdateVipLevels()";
        statement.execute(sqlProcedureCall);
        // Then
        String sqlCheckTable = "SELECT COUNT(*) AS How_Many FROM readers WHERE Vip_Level=\"Not Set\"";
        ResultSet rs = statement.executeQuery(sqlCheckTable);
        int howMany = -1;
        if (rs.next()) {
            howMany = rs.getInt("How_Many");
        }
        assertEquals(0, howMany);
    }

    @Test
    public void testUpdateBestsellers() throws SQLException {
        // Given
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "UPDATE books SET Bestseller=null";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);

        // When
        String sqlProcedureCall = "CALL UpdateBestsellers()";
        statement.execute(sqlProcedureCall);

        // Then
        String sqlCheckRecords = "SELECT COUNT(*) AS Null_Rows FROM books WHERE Bestseller IS NULL";
        ResultSet rs = statement.executeQuery(sqlCheckRecords);
        int howMany = -1;
        if (rs.next()) {
            howMany = rs.getInt("Null_Rows");
        }
        assertEquals(0, howMany);
    }
}
