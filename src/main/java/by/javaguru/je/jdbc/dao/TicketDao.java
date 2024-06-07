package by.javaguru.je.jdbc.dao;

import by.javaguru.je.jdbc.entity.Ticket;
import by.javaguru.je.jdbc.exceptions.DaoException;
import by.javaguru.je.jdbc.utills.ConnectionManager;
import by.javaguru.je.jdbc.utills.SqlUtil;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class TicketDao {
    private static final TicketDao INSTANCE = new TicketDao();




    public Optional<Ticket> findById(Long id) {
        try (var connection = ConnectionManager.getConnection();
             var statement = connection.prepareStatement(SqlUtil.FIND_BY_ID_SQL)) {
            statement.setLong(1, id);
            var result = statement.executeQuery();
            Ticket ticket = null;

            if (result.next())
                ticket = buildTicket(result);

            return Optional.ofNullable(ticket);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }


    public List<Ticket> findAll() {
        try (var connection = ConnectionManager.getConnection();
             var statement = connection.prepareStatement(SqlUtil.FIND_ALL_SQL)) {

            List<Ticket> tickets = new ArrayList<>();

            var result = statement.executeQuery();
            while (result.next()) {
                tickets.add(
                        buildTicket(result)
                );
            }

            return tickets;
        } catch (SQLException e) {
            throw new DaoException(e);
        }

    }


    public Ticket save(Ticket ticket) {
        try (var connection = ConnectionManager.getConnection();
             var statement = connection.prepareStatement(SqlUtil.SAVE_SQL, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, ticket.getPassportNumber());
            statement.setString(2, ticket.getPassengerName());
            statement.setLong(3, ticket.getFlightId());
            statement.setInt(4, ticket.getSeatNumber());
            statement.setBigDecimal(5, ticket.getCost());

            statement.executeUpdate();
            var keys = statement.getGeneratedKeys();
            if (keys.next())
                ticket.setId(keys.getLong("id"));


            return ticket;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public boolean delete(Long id) {
        try (var connection = ConnectionManager.getConnection();
             var statement = connection.prepareStatement(SqlUtil.DELETE_SQL)) {


            statement.setLong(1, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    private static Ticket buildTicket(ResultSet result) throws SQLException {
        return new Ticket(
                result.getLong("id"),
                result.getInt("passport_number"),
                result.getString("passenger_name"),
                result.getLong("flight_id"),
                result.getInt("seat_number"),
                result.getBigDecimal("cost")
        );
    }

    public static TicketDao getInstance() {
        return INSTANCE;
    }

    private TicketDao() {

    }
}
