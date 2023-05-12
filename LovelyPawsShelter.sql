-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: May 12, 2023 at 03:51 AM
-- Server version: 5.7.39
-- PHP Version: 7.4.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `LovelyPawsShelter`
--

-- --------------------------------------------------------

CREATE DATABASE LovelyPawsShelter;

USE LovelyPawsShelter;
--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`username`, `password`) VALUES
('admin', '12345');

-- --------------------------------------------------------

--
-- Table structure for table `adoption`
--

CREATE TABLE `adoption` (
  `email` varchar(30) NOT NULL,
  `fname` varchar(20) NOT NULL,
  `lname` varchar(20) NOT NULL,
  `phoneNum` varchar(10) NOT NULL,
  `statement` varchar(2000) NOT NULL,
  `petID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `adoption`
--

INSERT INTO `adoption` (`email`, `fname`, `lname`, `phoneNum`, `statement`, `petID`) VALUES
('kwang@gmail.com', 'Kevin', 'Wang', '7415618923', 'I love pets!', 1),
('vickywong@gmail.com', 'Vicky', 'Wong', '6468094323', 'I love Poodle!!', 5),
('wolfie@gmail.com', 'Wolfie', 'Wong', '7328413555', 'I love cats!!', 4);

-- --------------------------------------------------------

--
-- Table structure for table `animal`
--

CREATE TABLE `animal` (
  `petID` int(10) NOT NULL,
  `name` varchar(10) NOT NULL,
  `breed` varchar(20) NOT NULL,
  `gender` varchar(6) NOT NULL,
  `age` int(2) NOT NULL,
  `description` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `animal`
--

INSERT INTO `animal` (`petID`, `name`, `breed`, `gender`, `age`, `description`) VALUES
(1, 'Max', 'Golden Retriever', 'Male', 2, 'Max is a friendly and energetic Golden Retriever. He loves playing fetch and going for long walks. He\'s great with kids and other pets, and would make a great addition to any family.'),
(2, 'Luna', 'Siamese', 'Female', 5, 'Luna is a beautiful Siamese cat with piercing blue eyes. She\'s independent but also loves to cuddle. She\'s great with other cats and enjoys lounging in sunny spots. Luna would make a great companion for anyone looking for a low-maintenance pet.'),
(3, 'Rocky', 'Pitbull', 'Male', 1, 'Rocky is a lovable Pitbull who loves to play and cuddle. He\'s great with kids and other pets, and is always eager to please. Rocky is still a puppy at heart and would do best in a home with an active family who can give him plenty of exercise and attention.'),
(4, 'Ginger', 'Tabby', 'Female', 3, 'Ginger is a sweet and affectionate Tabby cat. She loves to play and is always up for a good cuddle. She\'s great with kids and other cats, and would make a great companion for anyone looking for a low-key pet.\r\n\r\n'),
(5, 'Baxter', 'Poodle', 'Male', 4, 'Baxter is a friendly and playful poodle. He loves to go for walks and play fetch. He\'s great with kids and other dogs, and would make a great addition to any family. Baxter does have some separation anxiety, so he would do best in a home where someone is around most of the time.'),
(6, 'Milo', 'Golden Retriever', 'Male', 2, 'Milo is a playful and energetic golden retriever. He loves to play fetch and go for long walks. He is great with kids and other dogs, and loves to cuddle up on the couch at the end of a long day. Milo is crate trained and housebroken.'),
(7, 'Mop', 'German Shepherd', 'Male', 1, 'Max is a loyal and energetic German Shepherd. He loves to play fetch and go for long walks. He is great with kids and other dogs, and loves to cuddle up with his family. Max is crate trained and knows basic obedience commands.'),
(8, 'Rufus', 'Bulldog', 'Male', 3, 'Rufus is a gentle and loyal bulldog. He loves to cuddle up on the couch and watch TV with his family. He is great with kids and other pets, and loves to go for walks in the park. Rufus is crate trained and knows basic obedience commands.'),
(9, 'Sasha', 'Siberian Husky', 'Female', 5, 'Sasha is a beautiful and adventurous Siberian husky. She loves to go for runs and play in the snow. She is great with older kids and adults, but can be a bit too energetic for small children. Sasha is crate trained and knows basic obedience commands.'),
(10, 'Simba', 'Maine Coon', 'Male', 2, 'Simba is a majestic and affectionate Maine Coon cat. He loves to be around people and will follow you around the house. He is great with other cats and would do well in a home with multiple pets. Simba is litter box trained and up to date on all his shots.'),
(11, 'Batman', 'Domestic Shorthair', 'Male', 9, 'Batman is a super sweet black cat. He used to live outside and then was injured during a fight with other cats. He\'s very calm and good with other cats and children.'),
(12, 'Yuzu', 'Domestic Shorthair', 'Female', 2, 'Yuzu is a super sweet and clingy tabby cat. She was found injured in the backyard. She loves cuddles and needs a lot of love. ');

-- --------------------------------------------------------

--
-- Table structure for table `appointment`
--

CREATE TABLE `appointment` (
  `email` varchar(30) NOT NULL,
  `fname` varchar(20) NOT NULL,
  `lname` varchar(20) NOT NULL,
  `date` date NOT NULL,
  `time` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `appointment`
--

INSERT INTO `appointment` (`email`, `fname`, `lname`, `date`, `time`) VALUES
('1', '1', '1', '2023-05-06', 'AM'),
('allen@gmail.com', 'Allen', 'Chen', '2023-05-05', 'AM'),
('batman@gmail.com', 'Batman', 'Wong', '2023-05-05', 'PM'),
('Kevin@gmail.com', 'Kevin', 'Wong', '2023-05-09', 'PM'),
('vicky@gmail.com', 'Vicky', 'Wong', '2023-05-10', 'AM'),
('wolf@gmail.com', 'Wolfgang', 'Wong', '2023-05-07', 'AM'),
('yuzu@gmail.com', 'Yuzu', 'Wong', '2023-05-07', 'PM');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `adoption`
--
ALTER TABLE `adoption`
  ADD PRIMARY KEY (`email`,`petID`);

--
-- Indexes for table `animal`
--
ALTER TABLE `animal`
  ADD PRIMARY KEY (`petID`);

--
-- Indexes for table `appointment`
--
ALTER TABLE `appointment`
  ADD PRIMARY KEY (`email`,`date`,`time`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
