package com.techelevator.dao;

import com.techelevator.dao.model.Actor;
import com.techelevator.dao.model.Customer;
import com.techelevator.dao.model.Film;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

/**
 * JDBCCustomerDao
 */
@Component
public class JDBCCustomerDao implements CustomerDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCCustomerDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


	@Override
	public List<Customer> searchAndSortCustomers(String search, String sort) {
        List<Customer> matchingCustomers = new ArrayList<>();
        String actorSearchSql = "SELECT first_name, last_name, email, activebool FROM customer WHERE first_name ILIKE ? OR last_name ILIKE ? order by " + sort;
        SqlRowSet results = jdbcTemplate.queryForRowSet(actorSearchSql, "%" + search + "%", "%" + search + "%");
        		//"%" + search + "%", sort);
        while(results.next()) {
        	matchingCustomers.add(mapRowToCustomer(results));
        }
        /*
        String actorSearchSql2 = "SELECT first_name, last_name FROM customer WHERE first_name ILIKE ? order by ?";
        SqlRowSet results2 = jdbcTemplate.queryForRowSet(actorSearchSql, "%" + search + "%", sort);
        while(results2.next()) {
        	matchingCustomers.add(mapRowToCustomer2(results2));
        }
        */
        return matchingCustomers;
	}
/*
	private Customer mapRowToCustomer(SqlRowSet results) {
		return new Customer(results.getString("first_name"), results.getString("last_name"), results.getString("email"), results.getBoolean("activebool"));
	}
*/
	/*
	
	private Customer mapRowToCustomer(SqlRowSet results) {
		Customer customerRow = new Customer();
		
		return new Customer(results.getString("first_name"), results.getString("last_name"), results.getString("email"), results.getBoolean("activebool"));
	}
	*/
	
	
	private Customer mapRowToCustomer(SqlRowSet results) {
        Customer filmRow = new Customer();
        filmRow.setFirstName(results.getString("first_name"));
        filmRow.setLastName(results.getString("last_name"));
        filmRow.setEmail(results.getString("email"));
        filmRow.setActive(results.getBoolean("activebool"));
        return filmRow;
	}
	
	/*
	private Customer mapRowToCustomer2(SqlRowSet results2) {
		return new Customer(results2.getString("first_name"), results2.getString("last_name"), results2.getString("email"), results2.getBoolean("activebool"));
	}   
	*/
}