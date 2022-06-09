package com.lebedev.dao;

import com.lebedev.entity.MovieEntity;
import com.lebedev.entity.PlaceEntity;
import com.lebedev.entity.TicketEntity;
import com.lebedev.entity.UserEntity;
import com.lebedev.helper.Property;

import java.sql.*;
import java.util.*;
import java.util.function.Function;

public class UserDaoImpl implements UserDao {
    Properties properties = Property.getProperty().getProperties();
    private final String DB_URL = properties.getProperty("DB_URL");
    private final String DB_USER = properties.getProperty("DB_USER");
    private final String DB_PASSWORD = properties.getProperty("DB_PASSWORD");

    private static final String SELECT_ALL = "SELECT * FROM usr";
    private static final String SELECT_TICKETS = "SELECT t.cost, " +
            "t.sold, " +
            "t.id AS ticket_id, " +
            "m.id AS movie_id, " +
            "m.name AS movie_title, " +
            "m.description, " +
            "s.time, " +
            "p.id AS place_id, " +
            "p.number AS place_number, " +
            "r.number AS row_number, " +
            "h.name AS hall_title " +
            "FROM user_ticket ut " +
            "JOIN ticket t ON ut.ticket_id = t.id " +
            "JOIN show s  ON t.show_id  = s.id " +
            "JOIN movie m ON s.movie_id = m.id " +
            "JOIN place p ON t.place_id = p.id " +
            "JOIN row r ON p.row_id = r.id " +
            "JOIN hall h ON r.hall_id = h.id " +
            "where ut.user_id = ?";
    private static final String SELECT_BY_ID = "SELECT * FROM usr WHERE id = ?";
    private static final String SELECT_BY_NAME = "SELECT * FROM usr WHERE name = ?";
    private static final String SAVE_USER = "INSERT INTO usr (name, email) VALUES (?,?)";
    private static final String UPDATE = "UPDATE usr SET name = ?, email = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM usr WHERE id = ?";
    private static final String ADD_TICKET_TO_USER = "INSERT INTO user_ticket (user_id, ticket_id) VALUES(?, ?);";


    private static UserDaoImpl instance;

    private UserDaoImpl() {
    }

    public static UserDaoImpl getInstance() {
        if (Objects.isNull(instance)) {
            instance = new UserDaoImpl();
        }
        return instance;
    }


    public List<UserEntity> findAllUser() {
        return this.query(conn -> {
            try {
                PreparedStatement psu = conn.prepareStatement(SELECT_ALL);
                List<UserEntity> users = new ArrayList<>();
                ResultSet ru = psu.executeQuery();
                while (ru.next()) {
                    UserEntity u = new UserEntity();
                    u.setId(ru.getLong("id"));
                    u.setName(ru.getString("name"));
                    u.setEmail(ru.getString("email"));
                    u.setTickets(selectTickets(conn, u));
                    users.add(u);
                }
                return users;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        });
    }

    public Optional<UserEntity> findUserById(Long id) {
        return this.query(conn -> {
            try {
                PreparedStatement psu = conn.prepareStatement(SELECT_BY_ID);
                psu.setLong(1, id);
                ResultSet ru = psu.executeQuery();
                if (ru.next()) {
                    UserEntity u = new UserEntity();
                    u.setId(ru.getLong("id"));
                    u.setName(ru.getString("name"));
                    u.setEmail(ru.getString("email"));
                    u.setTickets(selectTickets(conn, u));
                    return Optional.of(u);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return Optional.empty();
        });
    }

    public Optional<UserEntity> findUserByName(String name) {
        return this.query(conn -> {
            try {
                PreparedStatement psu = conn.prepareStatement(SELECT_BY_NAME);
                psu.setString(1, name);
                ResultSet ru = psu.executeQuery();
                if (ru.next()) {
                    UserEntity u = new UserEntity();
                    u.setId(ru.getLong("id"));
                    u.setName(ru.getString("name"));
                    u.setEmail(ru.getString("email"));
                    u.setTickets(selectTickets(conn, u));
                    return Optional.of(u);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return Optional.empty();
        });
    }

    public void saveUser(UserEntity user) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            conn.setAutoCommit(false);
            PreparedStatement psa = conn.prepareStatement(SAVE_USER);
            psa.setString(1, user.getName());
            psa.setString(2, user.getEmail());
            psa.execute();
            conn.commit();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateUser(UserEntity user) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            conn.setAutoCommit(false);
            PreparedStatement psa = conn.prepareStatement(UPDATE);
            psa.setString(1, user.getName());
            psa.setString(2, user.getEmail());
            psa.setLong(3, user.getId());
            psa.execute();
            conn.commit();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteUser(UserEntity user) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            conn.setAutoCommit(false);
            PreparedStatement psa = conn.prepareStatement(DELETE);
            psa.setLong(1, user.getId());
            psa.execute();
            conn.commit();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }

    public void addTicketToUser(UserEntity user, TicketEntity ticket) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            conn.setAutoCommit(false);
            PreparedStatement psa = conn.prepareStatement(ADD_TICKET_TO_USER);
            psa.setLong(1, user.getId());
            psa.setLong(2, ticket.getId());
            psa.execute();
            conn.commit();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }

    private List<TicketEntity> selectTickets(Connection conn, UserEntity user) throws SQLException {
        PreparedStatement pst = conn.prepareStatement(SELECT_TICKETS);
        pst.setLong(1, user.getId());
        ResultSet rst = pst.executeQuery();
        List<TicketEntity> tickets = new ArrayList<>();
        while (rst.next()) {
            TicketEntity ticket = new TicketEntity();
            ticket.setId(rst.getLong("ticket_id"));
            ticket.setCost(rst.getInt("cost"));
            ticket.setIsSold(rst.getBoolean("sold"));
            ticket.setDate(rst.getTimestamp("time").toLocalDateTime());
            ticket.setMovie(
                    new MovieEntity(rst.getLong("movie_id"),
                            rst.getString("movie_title"),
                            rst.getString("description"))
            );
            ticket.setPlace(
                    new PlaceEntity(rst.getLong("place_id"),
                            rst.getInt("place_number"),
                            rst.getInt("row_number"),
                            rst.getString("hall_title"))
            );
            tickets.add(ticket);
        }
        return tickets;
    }

    private <T> T query(Function<Connection, T> s) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            return s.apply(conn);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }

}
