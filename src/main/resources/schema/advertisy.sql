-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Gazdă: 127.0.0.1
-- Timp de generare: nov. 15, 2020 la 07:58 PM
-- Versiune server: 10.4.14-MariaDB
-- Versiune PHP: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Bază de date: `advertisy`
--

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `address`
--

CREATE TABLE `address` (
  `id` int(11) NOT NULL,
  `street_address` varchar(250) COLLATE utf8mb4_romanian_ci NOT NULL,
  `place` varchar(250) COLLATE utf8mb4_romanian_ci NOT NULL,
  `county_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_romanian_ci;

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `announcement`
--

CREATE TABLE `announcement` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  `title` varchar(250) COLLATE utf8mb4_romanian_ci NOT NULL,
  `short_description` varchar(500) COLLATE utf8mb4_romanian_ci NOT NULL,
  `long_description` varchar(1000) COLLATE utf8mb4_romanian_ci NOT NULL,
  `price` double NOT NULL,
  `views` int(11) NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  `is_visible` tinyint(1) NOT NULL,
  `publication_date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_romanian_ci;

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `announcement_ban`
--

CREATE TABLE `announcement_ban` (
  `id` int(11) NOT NULL,
  `announcement_id` int(11) NOT NULL,
  `message` varchar(500) COLLATE utf8mb4_romanian_ci NOT NULL,
  `ban_date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_romanian_ci;

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `announcement_category`
--

CREATE TABLE `announcement_category` (
  `id` int(11) NOT NULL,
  `name` varchar(250) COLLATE utf8mb4_romanian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_romanian_ci;

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `announcement_photo`
--

CREATE TABLE `announcement_photo` (
  `id` int(11) NOT NULL,
  `announcement_id` int(11) NOT NULL,
  `photo` blob NOT NULL,
  `mime_type` varchar(250) COLLATE utf8mb4_romanian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_romanian_ci;

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `announcement_report`
--

CREATE TABLE `announcement_report` (
  `id` int(11) NOT NULL,
  `announcement_id` int(11) NOT NULL,
  `message` varchar(500) COLLATE utf8mb4_romanian_ci NOT NULL,
  `report_date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_romanian_ci;

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `announcement_unban_request`
--

CREATE TABLE `announcement_unban_request` (
  `id` int(11) NOT NULL,
  `announcement_id` int(11) NOT NULL,
  `message` varchar(500) COLLATE utf8mb4_romanian_ci NOT NULL,
  `request_date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_romanian_ci;

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `county`
--

CREATE TABLE `county` (
  `id` int(11) NOT NULL,
  `name` varchar(250) COLLATE utf8mb4_romanian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_romanian_ci;

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `role`
--

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `name` varchar(250) COLLATE utf8mb4_romanian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_romanian_ci;

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(250) COLLATE utf8mb4_romanian_ci NOT NULL,
  `email` varchar(250) COLLATE utf8mb4_romanian_ci NOT NULL,
  `password` varchar(250) COLLATE utf8mb4_romanian_ci NOT NULL,
  `phone` varchar(50) COLLATE utf8mb4_romanian_ci NOT NULL,
  `address_id` int(11) NOT NULL,
  `photo_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  `last_login` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_romanian_ci;

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `user_photo`
--

CREATE TABLE `user_photo` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `photo` blob NOT NULL,
  `mime_type` varchar(250) COLLATE utf8mb4_romanian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_romanian_ci;

--
-- Indexuri pentru tabele eliminate
--

--
-- Indexuri pentru tabele `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`id`),
  ADD KEY `county_id` (`county_id`);

--
-- Indexuri pentru tabele `announcement`
--
ALTER TABLE `announcement`
  ADD PRIMARY KEY (`id`),
  ADD KEY `category_id` (`category_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexuri pentru tabele `announcement_ban`
--
ALTER TABLE `announcement_ban`
  ADD PRIMARY KEY (`id`);

--
-- Indexuri pentru tabele `announcement_category`
--
ALTER TABLE `announcement_category`
  ADD PRIMARY KEY (`id`);

--
-- Indexuri pentru tabele `announcement_photo`
--
ALTER TABLE `announcement_photo`
  ADD PRIMARY KEY (`id`);

--
-- Indexuri pentru tabele `announcement_report`
--
ALTER TABLE `announcement_report`
  ADD PRIMARY KEY (`id`);

--
-- Indexuri pentru tabele `announcement_unban_request`
--
ALTER TABLE `announcement_unban_request`
  ADD PRIMARY KEY (`id`);

--
-- Indexuri pentru tabele `county`
--
ALTER TABLE `county`
  ADD PRIMARY KEY (`id`);

--
-- Indexuri pentru tabele `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indexuri pentru tabele `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `address_id` (`address_id`),
  ADD KEY `photo_id` (`photo_id`),
  ADD KEY `role_id` (`role_id`);

--
-- Indexuri pentru tabele `user_photo`
--
ALTER TABLE `user_photo`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pentru tabele eliminate
--

--
-- AUTO_INCREMENT pentru tabele `address`
--
ALTER TABLE `address`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pentru tabele `announcement`
--
ALTER TABLE `announcement`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pentru tabele `announcement_ban`
--
ALTER TABLE `announcement_ban`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pentru tabele `announcement_category`
--
ALTER TABLE `announcement_category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pentru tabele `announcement_photo`
--
ALTER TABLE `announcement_photo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pentru tabele `announcement_report`
--
ALTER TABLE `announcement_report`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pentru tabele `announcement_unban_request`
--
ALTER TABLE `announcement_unban_request`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pentru tabele `county`
--
ALTER TABLE `county`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pentru tabele `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pentru tabele `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pentru tabele `user_photo`
--
ALTER TABLE `user_photo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constrângeri pentru tabele eliminate
--

--
-- Constrângeri pentru tabele `address`
--
ALTER TABLE `address`
  ADD CONSTRAINT `address_ibfk_1` FOREIGN KEY (`county_id`) REFERENCES `county` (`id`);

--
-- Constrângeri pentru tabele `announcement`
--
ALTER TABLE `announcement`
  ADD CONSTRAINT `announcement_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `announcement_category` (`id`),
  ADD CONSTRAINT `announcement_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Constrângeri pentru tabele `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`),
  ADD CONSTRAINT `user_ibfk_2` FOREIGN KEY (`photo_id`) REFERENCES `user_photo` (`id`),
  ADD CONSTRAINT `user_ibfk_3` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
