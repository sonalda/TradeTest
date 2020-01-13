package com.bank.trade.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.trade.Exception.ValidationException;
import com.bank.trade.model.Trade;
import com.bank.trade.service.TradeInterface;

@RestController
@RequestMapping("/trade")
public class TradeController {

	Map<String, String> errorMap;
	@Autowired
	private TradeInterface tradeInterface;

	@PostMapping
	public ResponseEntity<Trade> createTrade(@RequestBody Trade trade) {

		return new ResponseEntity<>(tradeInterface.createTrade(trade), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Trade> updateTrade(@RequestBody Trade trade) {

		Trade existingTrade = tradeInterface.getTrade(trade.getTradeId());

		if (trade.getVersion() > existingTrade.getVersion()) {
			return new ResponseEntity<>(tradeInterface.updateTrade(trade), HttpStatus.OK);
		} else {
			errorMap.clear();
			errorMap.put("412", "Trade version can not be lesser than existing trade version");
			throw new ValidationException(errorMap);
		}

	}

	@GetMapping("{/id}")
	public ResponseEntity<Trade> getTrade(@PathVariable String tradeId) {
		return new ResponseEntity<>(tradeInterface.getTrade(tradeId), HttpStatus.OK);
	}
}
