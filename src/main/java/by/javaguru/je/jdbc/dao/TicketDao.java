package by.javaguru.je.jdbc.dao;

import by.javaguru.je.jdbc.entity.Ticket;
import by.javaguru.je.jdbc.exceptions.DaoException;
import by.javaguru.je.jdbc.utills.ConnectionManager;
import by.javaguru.je.jdbc.utills.PropertiesUtil;

import java.sql.SQLException;

public class TicketDao {
    private static final TicketDao INSTANCE = new TicketDao();



    public Ticket save(Ticket ticket) {
    try (var connection = ConnectionManager.getConnection()) {
        var statement = connection.prepareStatement();
        // Set the values for the prepared statement parameters
        //...
        statement.executeUpdate();
    } catch (SQLException e) {
        throw new DaoException(e);
    }
}



    public static TicketDao getInstance(){
        return INSTANCE;
    }

    private TicketDao(){

    }
}
