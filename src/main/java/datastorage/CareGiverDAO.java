package datastorage;

import model.CareGiver;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CareGiverDAO extends DAOimp<CareGiver> {

    public CareGiverDAO(Connection conn) {
        super(conn);
    }

    /**
     * generates a <code>INSERT INTO</code>-Statement for a given patient
     * @param careGiver for which a specific INSERT INTO is to be created
     * @return <code>String</code> with the generated SQL.
     */
    @Override
    protected String getCreateStatementString(CareGiver careGiver) {
        return String.format("INSERT INTO caregiver (firstname, surname, phonenumber) VALUES ('%s', '%s', '%s')",
                careGiver.getFirstName(), careGiver.getSurname(), careGiver.getPhonenumber());
    }

    @Override
    protected String getReadByIDStatementString(long key) {
        return String.format("SELECT * FROM caregiver WHERE cgid = %d", key);
    }

    @Override
    protected CareGiver getInstanceFromResultSet(ResultSet result) throws SQLException {
        CareGiver cg = null;
        cg = new CareGiver(result.getInt(1), result.getString(2),
                result.getString(3), result.getString(4));
        return cg;
    }

    /**
     * generates a <code>SELECT</code>-Statement for all care giver.
     * @return <code>String</code> with the generated SQL.
     */
    @Override
    protected String getReadAllStatementString() {
        return  String.format("SELECT * FROM caregiver");
    }

    /**
     * maps a <code>ResultSet</code> to a <code>CareGiver-List</code>
     * @param result ResultSet with a multiple rows. Data will be mapped to caregiver-object.
     * @return ArrayList with caregivers from the resultSet.
     */
    @Override
    protected ArrayList<CareGiver> getListFromResultSet(ResultSet result) throws SQLException {
        ArrayList<CareGiver> list = new ArrayList<CareGiver>();
        CareGiver cg = null;
        while (result.next()) {
            cg = new CareGiver(result.getInt(1), result.getString(2),
                    result.getString(3), result.getString(4));
            list.add(cg);
        }
        return list;
    }

    /**
     * generates a <code>UPDATE</code>-Statement for a given care giver
     * @param careGiver for which a specific update is to be created
     * @return <code>String</code> with the generated SQL.
     */
    @Override
    protected String getUpdateStatementString(CareGiver careGiver) {
        return String.format("UPDATE caregiver SET firstname = '%s', surname = '%s', phonenumber = '%s'WHERE cgid = %d",
                careGiver.getFirstName(), careGiver.getSurname(), careGiver.getPhonenumber(),
                careGiver.getCgid());
    }


    /**
     * generates a <code>delete</code>-Statement for a given key
     * @param key for which a specific DELETE is to be created
     * @return <code>String</code> with the generated SQL.
     */
    @Override
    protected String getDeleteStatementString(long key) {
        return String.format("Delete FROM caregiver WHERE cgid=%d", key);
    }
}
