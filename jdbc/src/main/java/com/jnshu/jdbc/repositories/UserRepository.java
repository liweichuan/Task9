package com.jnshu.jdbc.repositories;

import com.jnshu.jdbc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.*;
import java.util.List;

@Repository
public class UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(readOnly = true)
    public List<User> findAll(){
        return jdbcTemplate.query("select * from users",new UserRowMapper());
    }

    @Transactional(readOnly = true)
    public User findUserById(int id){
        return jdbcTemplate.queryForObject("select * from users where id=?",new Object[]{id},new UserRowMapper());
    }

    //新增
    public User create(final User user){
        final String sql="insert into users(username,password,phone) values(?,?,?)";
        KeyHolder holder=new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps=connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1,user.getUsername());
                ps.setString(2,user.getPassword());
                ps.setString(3,user.getPhone());
                return ps;
            }
        },holder);
        int newUserId=holder.getKey().intValue();
        user.setId(newUserId);
        return user;
    }
    //删除
    public void delete(final Integer id) {
        final String sql = "delete from users where id=?";
        jdbcTemplate.update(sql,
                new Object[]{id},
                new int[]{java.sql.Types.INTEGER});
    }

    public void update(final User user) {
        jdbcTemplate.update(
                "update users set username=?,password=?,phone=? where id=?",
                new Object[]{user.getUsername(), user.getPassword(), user.getPhone(),user.getId()});
    }
}



    class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setPhone(rs.getString("phone"));

        return user;
    }
}
