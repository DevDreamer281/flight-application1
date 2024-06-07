package by.javaguru.je.jdbc.utills;

public class SqlUtil {
    public static String SAVE_SQL = """
            insert into ticket (passport_number, passenger_name, flight_id, seat_number, cost) 
            VALUES (?, ?, ?, ?, ?);
            """;

    public static String DELETE_SQL = """
            delete from ticket where id = ?;
            """;

    public static String FIND_ALL_SQL = """
            select id, passport_number, passenger_name, flight_id, seat_number, cost from ticket;
            """;

    public static String FIND_BY_ID_SQL = """
            select id, passport_number, passenger_name, flight_id, seat_number, cost 
            from ticket
            where ticket.id = ?;
            """;

    public static String UPDATE_SQL = """
            update ticket 
            set passport_number =?, passenger_name =?, flight_id =?, seat_number =?, cost =?
            where id =?;
            """;
}
