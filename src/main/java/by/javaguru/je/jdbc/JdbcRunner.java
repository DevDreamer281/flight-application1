package by.javaguru.je.jdbc;

import by.javaguru.je.jdbc.dao.TicketDao;
import java.sql.SQLException;

public class JdbcRunner {
    public static void main(String[] args) throws SQLException {
        var ticketDao = TicketDao.getInstance();
        var ticket = ticketDao.findById(12L).get();
        System.out.println(ticket);
        ticket.setPassengerName("Alex");
        System.out.println(ticketDao.update(ticket));
        System.out.println(ticket);
    }


}
