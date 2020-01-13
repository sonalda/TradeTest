package com.bank.trade.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.trade.model.Trade;
import com.bank.trade.repository.TradeRepository;

@Service
public class TradeService implements TradeInterface {

	@Autowired
	private TradeRepository tradeRepository;
	
	@Override
	public Trade createTrade(Trade trade) {
		return tradeRepository.save(trade);
	}

	@Override
	public Trade updateTrade(Trade trade) {
		return tradeRepository.save(trade);
	}

	@Override
	public Trade getTrade(String tradeId) {
		return tradeRepository.getByTradeId(tradeId);
	}

}
