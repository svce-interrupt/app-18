-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Aug 24, 2018 at 08:30 AM
-- Server version: 10.1.34-MariaDB
-- PHP Version: 7.2.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `register`
--

-- --------------------------------------------------------

--
-- Table structure for table `events`
--

CREATE TABLE `events` (
  `mobileNo` varchar(10) NOT NULL,
  `GoodWillHunting` int(1) DEFAULT NULL,
  `TheGameOfCodes` int(1) DEFAULT NULL,
  `Predestination` int(1) DEFAULT NULL,
  `TheDigitalFortress` int(1) DEFAULT NULL,
  `TheSecretSociety` int(1) DEFAULT NULL,
  `UnicornOfSilicon` int(1) DEFAULT NULL,
  `FishBowlConversation` int(1) DEFAULT NULL,
  `Inquizitive` int(1) DEFAULT NULL,
  `MiniProject` int(1) DEFAULT NULL,
  `PresentationFrankenstein` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `events`
--

INSERT INTO `events` (`mobileNo`, `GoodWillHunting`, `TheGameOfCodes`, `Predestination`, `TheDigitalFortress`, `TheSecretSociety`, `UnicornOfSilicon`, `FishBowlConversation`, `Inquizitive`, `MiniProject`, `PresentationFrankenstein`) VALUES
('0987654321', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
('2147483647', 1, 1, 1, 0, 0, 0, 0, 0, 0, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `events`
--
ALTER TABLE `events`
  ADD PRIMARY KEY (`mobileNo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
