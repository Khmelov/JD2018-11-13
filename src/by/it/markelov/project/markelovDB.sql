-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1:2016
-- Время создания: Фев 01 2019 г., 17:29
-- Версия сервера: 10.1.10-MariaDB
-- Версия PHP: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `markelov`
--

-- --------------------------------------------------------

--
-- Структура таблицы `orders`
--

CREATE TABLE `orders` (
  `ID` int(11) NOT NULL,
  `Shoe_name` varchar(45) DEFAULT NULL,
  `Shoe_size` int(11) DEFAULT NULL,
  `Shoe_colour` varchar(45) DEFAULT NULL,
  `Price` double DEFAULT NULL,
  `users_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `orders`
--

INSERT INTO `orders` (`ID`, `Shoe_name`, `Shoe_size`, `Shoe_colour`, `Price`, `users_ID`) VALUES
(1, 'Sneakers', 42, 'Green', 62.5, 2),
(2, 'Boots', 36, 'Black', 70.35, 2),
(3, 'Sandals', 40, 'White', 40, 2);

-- --------------------------------------------------------

--
-- Структура таблицы `roles`
--

CREATE TABLE `roles` (
  `ID` int(11) NOT NULL,
  `Role` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `roles`
--

INSERT INTO `roles` (`ID`, `Role`) VALUES
(1, 'Administrator'),
(2, 'User');

-- --------------------------------------------------------

--
-- Структура таблицы `shoe_colours`
--

CREATE TABLE `shoe_colours` (
  `ID` int(11) NOT NULL,
  `Shoe_colour` varchar(45) DEFAULT NULL,
  `orders_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `shoe_colours`
--

INSERT INTO `shoe_colours` (`ID`, `Shoe_colour`, `orders_ID`) VALUES
(1, 'Green', 1),
(2, 'Black', 2),
(3, 'White', 3);

-- --------------------------------------------------------

--
-- Структура таблицы `shoe_names`
--

CREATE TABLE `shoe_names` (
  `ID` int(11) NOT NULL,
  `Shoe_name` varchar(45) DEFAULT NULL,
  `orders_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `shoe_names`
--

INSERT INTO `shoe_names` (`ID`, `Shoe_name`, `orders_ID`) VALUES
(1, 'Sneakers', 1),
(2, 'Boots', 2),
(3, 'Sandals', 3);

-- --------------------------------------------------------

--
-- Структура таблицы `shoe_sizes`
--

CREATE TABLE `shoe_sizes` (
  `ID` int(11) NOT NULL,
  `Shoe_size` double DEFAULT NULL,
  `orders_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `shoe_sizes`
--

INSERT INTO `shoe_sizes` (`ID`, `Shoe_size`, `orders_ID`) VALUES
(1, 42, 1),
(2, 36, 2),
(3, 40, 3);

-- --------------------------------------------------------

--
-- Структура таблицы `users`
--

CREATE TABLE `users` (
  `ID` int(11) NOT NULL,
  `Login` varchar(45) DEFAULT NULL,
  `Password` varchar(45) DEFAULT NULL,
  `E-Mail` varchar(45) DEFAULT NULL,
  `roles_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `users`
--

INSERT INTO `users` (`ID`, `Login`, `Password`, `E-Mail`, `roles_ID`) VALUES
(1, 'Admin', 'PAdmin', 'Admin@gmail.com', 1),
(2, 'User', 'PUser', 'User@gmail.com', 2),
(9, 'TestUser1', 'TestPassword', 'Testemail@email.com', 2),
(10, 'TestUser2', 'TestPassword', 'Testemail@email.com', 2),
(11, 'TestUser3', 'TestPassword', 'Testemail@email.com', 2);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `fk_orders_users1_idx` (`users_ID`);

--
-- Индексы таблицы `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`ID`);

--
-- Индексы таблицы `shoe_colours`
--
ALTER TABLE `shoe_colours`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `fk_shoe_collour_orders1_idx` (`orders_ID`);

--
-- Индексы таблицы `shoe_names`
--
ALTER TABLE `shoe_names`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `fk_shoe_names_orders1_idx` (`orders_ID`);

--
-- Индексы таблицы `shoe_sizes`
--
ALTER TABLE `shoe_sizes`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `fk_shoe_sizes_orders1_idx` (`orders_ID`);

--
-- Индексы таблицы `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `fk_users_roles_idx` (`roles_ID`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `orders`
--
ALTER TABLE `orders`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT для таблицы `roles`
--
ALTER TABLE `roles`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT для таблицы `shoe_colours`
--
ALTER TABLE `shoe_colours`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT для таблицы `shoe_names`
--
ALTER TABLE `shoe_names`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT для таблицы `shoe_sizes`
--
ALTER TABLE `shoe_sizes`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT для таблицы `users`
--
ALTER TABLE `users`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `fk_orders_users1` FOREIGN KEY (`users_ID`) REFERENCES `users` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ограничения внешнего ключа таблицы `shoe_colours`
--
ALTER TABLE `shoe_colours`
  ADD CONSTRAINT `fk_shoe_collour_orders1` FOREIGN KEY (`orders_ID`) REFERENCES `orders` (`ID`);

--
-- Ограничения внешнего ключа таблицы `shoe_names`
--
ALTER TABLE `shoe_names`
  ADD CONSTRAINT `fk_shoe_names_orders1` FOREIGN KEY (`orders_ID`) REFERENCES `orders` (`ID`);

--
-- Ограничения внешнего ключа таблицы `shoe_sizes`
--
ALTER TABLE `shoe_sizes`
  ADD CONSTRAINT `fk_shoe_sizes_orders1` FOREIGN KEY (`orders_ID`) REFERENCES `orders` (`ID`);

--
-- Ограничения внешнего ключа таблицы `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `fk_users_roles` FOREIGN KEY (`roles_ID`) REFERENCES `roles` (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
