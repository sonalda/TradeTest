package com.bank.trade.service;

import com.bank.trade.model.Trade;

public interface TradeInterface {



	Trade createTrade(Trade trade);

	Trade updateTrade(Trade trade);

	Trade getTrade(String tradeId);

}
