-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 23, 2017 at 02:25 PM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `preschool`
--

-- --------------------------------------------------------

--
-- Table structure for table `class1`
--

CREATE TABLE `class1` (
  `id` int(11) NOT NULL,
  `class_id` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `class_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `intake_year` year(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `class1`
--

INSERT INTO `class1` (`id`, `class_id`, `class_name`, `intake_year`) VALUES
(1, 'cl1', 'sdsdsa', 2012);

-- --------------------------------------------------------

--
-- Table structure for table `diemdanh`
--

CREATE TABLE `diemdanh` (
  `id` int(11) NOT NULL,
  `ngay` date NOT NULL,
  `classId` int(11) NOT NULL,
  `studentId` int(11) NOT NULL,
  `status` tinyint(4) NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id` int(50) NOT NULL,
  `employee_id` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `employee_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Gender` tinyint(4) NOT NULL,
  `Birthday` date NOT NULL,
  `Degree` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Position` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Address` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `class_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `hososk`
--

CREATE TABLE `hososk` (
  `id` int(11) NOT NULL,
  `ma_hs` varchar(50) COLLATE utf8_vietnamese_ci NOT NULL,
  `ngaylap` date NOT NULL,
  `status` tinyint(4) NOT NULL,
  `ngayKhamDK` date NOT NULL,
  `studentId` int(11) NOT NULL,
  `result` text COLLATE utf8_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- --------------------------------------------------------

--
-- Table structure for table `lichhoc`
--

CREATE TABLE `lichhoc` (
  `id` int(11) NOT NULL,
  `classId` int(11) NOT NULL,
  `noiDungHoc` text COLLATE utf8_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `id` int(11) NOT NULL,
  `student_id` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `student_name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `birthday` date NOT NULL,
  `gender` tinyint(4) NOT NULL,
  `result` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `tenphuhuynh` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `phone` int(11) NOT NULL,
  `class_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`id`, `student_id`, `student_name`, `birthday`, `gender`, `result`, `tenphuhuynh`, `address`, `phone`, `class_id`) VALUES
(1, 'sadsd', 'sdasdsa', '2017-05-01', 1, 'đâsd', 'đá', 'sadasd', 3225465, 1),
(2, 'sdsad', 'sdasd', '2017-05-01', 1, 'dsadsd', 'sdasd', 'sdasd', 96789, 1);

-- --------------------------------------------------------

--
-- Table structure for table `thuchi`
--

CREATE TABLE `thuchi` (
  `id` int(11) NOT NULL,
  `MaPT` varchar(50) COLLATE utf8_vietnamese_ci NOT NULL,
  `MaTre` int(11) NOT NULL,
  `soTienThu` int(11) NOT NULL,
  `noiDungThu` text COLLATE utf8_vietnamese_ci NOT NULL,
  `Status` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `class1`
--
ALTER TABLE `class1`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `diemdanh`
--
ALTER TABLE `diemdanh`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_diemdanh_class` (`classId`),
  ADD KEY `fk_diemdanh_student` (`studentId`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_class_id_employee` (`class_id`);

--
-- Indexes for table `hososk`
--
ALTER TABLE `hososk`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_hs_student` (`studentId`);

--
-- Indexes for table `lichhoc`
--
ALTER TABLE `lichhoc`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_lichhoc_class` (`classId`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `studentId` (`student_id`),
  ADD KEY `fk_class_id_student` (`class_id`);

--
-- Indexes for table `thuchi`
--
ALTER TABLE `thuchi`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `MaPT` (`MaPT`),
  ADD KEY `fk_thuchi_student` (`MaTre`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `class1`
--
ALTER TABLE `class1`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `diemdanh`
--
ALTER TABLE `diemdanh`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `hososk`
--
ALTER TABLE `hososk`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `thuchi`
--
ALTER TABLE `thuchi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `diemdanh`
--
ALTER TABLE `diemdanh`
  ADD CONSTRAINT `fk_diemdanh_class` FOREIGN KEY (`classId`) REFERENCES `class1` (`id`),
  ADD CONSTRAINT `fk_diemdanh_student` FOREIGN KEY (`studentId`) REFERENCES `student` (`id`);

--
-- Constraints for table `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `fk_class_id_employee` FOREIGN KEY (`class_id`) REFERENCES `class1` (`id`);

--
-- Constraints for table `hososk`
--
ALTER TABLE `hososk`
  ADD CONSTRAINT `fk_hs_student` FOREIGN KEY (`studentId`) REFERENCES `student` (`id`);

--
-- Constraints for table `lichhoc`
--
ALTER TABLE `lichhoc`
  ADD CONSTRAINT `fk_lichhoc_class` FOREIGN KEY (`classId`) REFERENCES `class1` (`id`);

--
-- Constraints for table `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `fk_class_id_student` FOREIGN KEY (`class_id`) REFERENCES `class1` (`id`);

--
-- Constraints for table `thuchi`
--
ALTER TABLE `thuchi`
  ADD CONSTRAINT `fk_thuchi_student` FOREIGN KEY (`MaTre`) REFERENCES `student` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
