package com.bank.trade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.trade.model.Trade;

@Repository
public interface TradeRepository extends JpaRepository<Trade, String> {

	Trade getByTradeId(String tradeId);
}
