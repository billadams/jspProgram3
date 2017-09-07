-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3307
-- Generation Time: Aug 30, 2017 at 09:22 PM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `17subilladams`
--

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE `employees` (
  `firstName` varchar(30) NOT NULL,
  `middleName` varchar(30) DEFAULT NULL,
  `lastName` varchar(30) NOT NULL,
  `employeeID` int(11) NOT NULL,
  `birthDate` date NOT NULL,
  `hireDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`firstName`, `middleName`, `lastName`, `employeeID`, `birthDate`, `hireDate`) VALUES
('Aaron', 'A', 'Aaronson', 65, '1980-01-01', '2013-01-02'),
('Erin', '', 'Erinson', 66, '1980-01-01', '2012-01-01'),
('Roy', 'M', 'Batty', 734, '2016-01-08', '2016-01-09'),
('Sylvester', 'G', 'Stallone', 1234, '1946-07-06', '1994-08-03'),
('Beatrix', '', 'Kiddo', 1313, '1976-02-28', '2003-10-10'),
('Molly', '', 'Thousands', 1337, '1984-07-01', '2000-04-30'),
('Molly', 'K', 'Ringwald', 1616, '1968-02-18', '2007-05-05'),
('Marty', '', 'McFly', 1985, '1968-06-12', '1885-01-01'),
('Paul', 'Muad\'Dib', 'Atreides', 2000, '1965-04-04', '1984-05-05'),
('Ally', 'E', 'Sheedy', 5813, '1862-06-13', '1992-03-14'),
('Jason', '', 'Statham', 7564, '1967-07-26', '2015-12-10'),
('Arnold', 'D', 'Palmer', 8675, '1929-09-10', '2005-06-15');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`employeeID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `employees`
--
ALTER TABLE `employees`
  MODIFY `employeeID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8676;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
