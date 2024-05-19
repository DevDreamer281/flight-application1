package by.javaguru.je.jdbc;

import by.javaguru.je.jdbc.utills.ConnectionManager;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class JdbcRunner {
    public static void main(String[] args) throws SQLException {
        System.out.println(getFlightsBetween(
                LocalDate.of(2020, 01, 19).atStartOfDay(),
                LocalDate.of(2020, 10, 29).atStartOfDay()));
    }

    public static List<Long> getTicketsByFlightId(Long flight_id) {
        List<Long> tickets = new ArrayList<>();
        String sql = """
                select * from ticket
                where flight_id = ?;
                """;

        try (var connection = ConnectionManager.open();
             var statement = connection.prepareStatement(sql)) {
            statement.setLong(1, flight_id);
            var result = statement.executeQuery();

            while (result.next()) {
                tickets.add(result.getLong("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tickets;
    }

    public static List<Long> getFlightsBetween(LocalDateTime start, LocalDateTime end){
        List<Long> flights = new ArrayList<>();

        String sql = """
                select * from flight
                where departure_date between ? and ?;
                """;

        try (var connection = ConnectionManager.open();
             var statement = connection.prepareStatement(sql)){
            statement.setTimestamp(1, Timestamp.valueOf(start));
            statement.setTimestamp(2, Timestamp.valueOf(end));

            var result = statement.executeQuery();

            while (result.next()) {
                flights.add(result.getLong("id"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return flights;
    }
}
