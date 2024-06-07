package by.javaguru.je.jdbc;

import by.javaguru.je.jdbc.dao.TicketDao;
import by.javaguru.je.jdbc.entity.Ticket;

import java.math.BigDecimal;
import java.sql.SQLException;

public class JdbcRunner {
    public static void main(String[] args) throws SQLException {
        var ticketDao = TicketDao.getInstance();
        var ticket = new Ticket();
        ticket.setPassportNumber(28);
        ticket.setPassengerName("Valentine");
        ticket.setFlightId(1L);
        ticket.setSeatNumber(5);
        ticket.setCost(BigDecimal.TEN);

        System.out.println(ticketDao.findById(12L));


    }


}
