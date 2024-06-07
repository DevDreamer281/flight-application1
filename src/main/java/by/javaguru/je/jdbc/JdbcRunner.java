package by.javaguru.je.jdbc;

import by.javaguru.je.jdbc.dao.TicketDao;
import java.sql.SQLException;

public class JdbcRunner {
    public static void main(String[] args) throws SQLException {
        var ticketDao = TicketDao.getInstance();


        System.out.println(ticketDao.findById(1L));


    }


}
