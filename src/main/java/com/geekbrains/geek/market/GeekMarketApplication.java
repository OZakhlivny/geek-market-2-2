package com.geekbrains.geek.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class GeekMarketApplication {
	// Домашнее задание:
	// 1. Оформление заказов
	// 2. Попробуйте сделать регистрацию новых пользователей без валидации

	// Планы на следующие занятия:
	// - Вернуться к вопросу об изменении цены товара перед оформлением заказа

	public static void main(String[] args) {
		SpringApplication.run(GeekMarketApplication.class, args);
	}
}
