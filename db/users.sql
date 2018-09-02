-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Aug 24, 2018 at 08:29 AM
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
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `mobileNo` varchar(10) NOT NULL,
  `password` varchar(60) NOT NULL,
  `college` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`mobileNo`, `password`, `college`, `name`, `email`) VALUES
('0987654321', 'asdfghjkl', 'svce', 'ninth try', 'hello@gmail.com'),
('1234554321', 'heyyy', 'svce', 'firsttry', 'svce@gmail.com'),
('1234567890', 'iamgroot', 'svce', 'randomfcker', 'root@gmail.com'),
('1234567891', 'heyy there', 'svce', 'randomfcker', 'sljdc@gmail.com'),
('4444444444', '44444', 'svce', 'four', 'four@gmail.com'),
('5555555555', 'qwerty', 'svce', 'five', 'root@gmail.com'),
('6666666666', 'thanosteeth', 'svce', 'six', 'root@gmail.com'),
('8248628913', 'kd', 'sce', 'randomfcker', 'shriramgobu@gmail.com'),
('9876544567', 'hyy', 'svce', 'secondtry', 'root@gmail.com'),
('9952070437', 'hida', 'svce', 'shriram', 'hello@gmail.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`mobileNo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
