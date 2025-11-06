package com.rajabhay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rajabhay.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long>{

}
