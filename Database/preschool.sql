-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 25, 2017 lúc 07:24 SA
-- Phiên bản máy phục vụ: 10.1.21-MariaDB
-- Phiên bản PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `preschool`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `cbyt`
--

CREATE TABLE `cbyt` (
  `id` int(11) NOT NULL,
  `macbyt` varchar(30) COLLATE utf8_vietnamese_ci NOT NULL,
  `ho_tencbyt` varchar(40) COLLATE utf8_vietnamese_ci NOT NULL,
  `trinh_do` varchar(30) COLLATE utf8_vietnamese_ci NOT NULL,
  `chuyen_mon` varchar(30) COLLATE utf8_vietnamese_ci NOT NULL,
  `dia_chi` varchar(50) COLLATE utf8_vietnamese_ci NOT NULL,
  `phone` varchar(15) COLLATE utf8_vietnamese_ci NOT NULL,
  `status` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `cbyt`
--

INSERT INTO `cbyt` (`id`, `macbyt`, `ho_tencbyt`, `trinh_do`, `chuyen_mon`, `dia_chi`, `phone`, `status`) VALUES
(3, 'sƯƠNG', 'Mai Trang', 'College', 'Nông', '177 Cống Lỡ', '09999', NULL),
(4, 'Mai3026', 'Mai', 'University', 'Nông', '177 Cống Lỡ', '09999', NULL),
(5, 'Mai3703', 'Mai', 'University', 'Nông', '177 Cống Lỡ', '09999', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `giaovien`
--

CREATE TABLE `giaovien` (
  `id` int(50) NOT NULL,
  `teacher_id` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `teacher_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Birthday` date NOT NULL,
  `trinhdo` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `chuyenmon` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `Address` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `status` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `giaovien`
--

INSERT INTO `giaovien` (`id`, `teacher_id`, `teacher_name`, `Birthday`, `trinhdo`, `chuyenmon`, `Address`, `phone`, `status`) VALUES
(2, 'GV12', 'Nguyễn Mai', '2017-06-01', 'College', 'Giao dục', 'Hồ Thủy', '0988888', NULL),
(3, 'Mai9132', 'Mai', '1997-03-25', 'College', 'Giao dục thể chất', '9132', '01121', NULL),
(4, 'Mai6248', 'Mai', '1997-03-25', 'University', 'Giao dục thể chất', '6248', '01121', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hocsinh`
--

CREATE TABLE `hocsinh` (
  `id` int(11) NOT NULL,
  `student_id` varchar(30) COLLATE utf8_vietnamese_ci NOT NULL,
  `student_name` varchar(50) COLLATE utf8_vietnamese_ci NOT NULL,
  `ngaysinh` date DEFAULT NULL,
  `gioitinh` tinyint(1) DEFAULT NULL,
  `diachi` varchar(100) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `ngayvaotruong` date DEFAULT NULL,
  `tinhtrangsuckhoe` varchar(30) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `malop` int(11) NOT NULL,
  `hotenph` varchar(100) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `phone` varchar(100) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `hocsinh`
--

INSERT INTO `hocsinh` (`id`, `student_id`, `student_name`, `ngaysinh`, `gioitinh`, `diachi`, `ngayvaotruong`, `tinhtrangsuckhoe`, `malop`, `hotenph`, `phone`, `status`) VALUES
(5, 'Mai6865', 'Mai', '1997-03-25', 1, '6865', '1997-03-25', 'Tot', 1, 'Nguyễn Bạch', '01225543977', NULL),
(6, 'Mai1160', 'Mai', '1997-03-25', 1, '1160', '1997-03-25', 'Tot', 1, NULL, NULL, NULL),
(7, 'Mai2227', 'Mai', '1997-03-25', 0, '2227', '1997-03-25', 'Tot', 1, NULL, NULL, NULL),
(8, 'Mai2222', 'Mai', '1997-03-25', 0, '2227', '1997-03-25', 'Tot', 1, NULL, NULL, NULL),
(9, 'Mai2221', 'Mai', '1997-03-25', 0, '2227', '1997-03-25', 'Tot', 1, NULL, NULL, NULL),
(10, 'Mai2223', 'Mai', '1997-03-25', 0, '2227', '1997-03-25', 'Tot', 1, NULL, NULL, NULL),
(11, 'Mai22', 'Mai', '1997-03-25', 0, '2227', '1997-03-25', 'Tot', 1, NULL, NULL, NULL),
(12, 'Mai221', 'Mai', '1997-03-25', 0, '2227', '1997-03-25', 'Tot', 1, NULL, NULL, NULL),
(13, 'Mai2211', 'Mai', '1997-03-25', 0, '2227', '1997-03-25', 'Tot', 1, NULL, NULL, NULL),
(14, 'Mai22111', 'Mai', '1997-03-25', 0, '2227', '1997-03-25', 'Tot', 1, NULL, NULL, NULL),
(15, 'Mai221111', 'Mai', '1997-03-25', 0, '2227', '1997-03-25', 'Tot', 1, NULL, NULL, NULL),
(16, 'Mai2211111', 'Mai', '1997-03-25', 0, '2227', '1997-03-25', 'Tot', 1, NULL, NULL, NULL),
(17, 'Mai491', 'Mai', '1997-03-25', 1, '491', '1997-03-25', 'Tot', 1, NULL, NULL, NULL),
(18, 'Mai4911', 'Mai', '1997-03-25', 1, '491', '1997-03-25', 'Tot', 1, NULL, NULL, NULL),
(19, 'Mai49111', 'Mai', '1997-03-25', 1, '491', '1997-03-25', 'Tot', 1, NULL, NULL, NULL),
(20, 'Mai5595', 'Mai', '1997-03-25', 1, '5595', '1997-03-25', 'Tot', 3, NULL, '212', NULL),
(21, 'ABC', 'Mai', '1997-03-25', 0, '5187', '1997-03-25', 'Tot', 3, 'Sơn', 'Sơn', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `iclass`
--

CREATE TABLE `iclass` (
  `id` int(11) NOT NULL,
  `malop` varchar(50) COLLATE utf8_vietnamese_ci NOT NULL,
  `tenlop` varchar(100) COLLATE utf8_vietnamese_ci NOT NULL,
  `namhoc` varchar(50) COLLATE utf8_vietnamese_ci NOT NULL,
  `magv` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `status` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `iclass`
--

INSERT INTO `iclass` (`id`, `malop`, `tenlop`, `namhoc`, `magv`, `quantity`, `status`) VALUES
(1, 'CL1', 'Lớp mầm', '2014', 3, 30, NULL),
(2, 'CL8216', 'Mai', '2014', 2, 30, NULL),
(3, 'CL8211', 'Lớp chồi', '2014', 2, 30, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khamsuckhoe`
--

CREATE TABLE `khamsuckhoe` (
  `id` int(11) NOT NULL,
  `sophieukham` varchar(10) COLLATE utf8_vietnamese_ci NOT NULL,
  `lankham` int(11) NOT NULL,
  `namhoc` varchar(100) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `ngaykham` date NOT NULL,
  `mahocsinh` int(11) NOT NULL,
  `macbyt` int(11) NOT NULL,
  `chieucao` varchar(10) COLLATE utf8_vietnamese_ci NOT NULL,
  `cannang` varchar(10) COLLATE utf8_vietnamese_ci NOT NULL,
  `benh` varchar(100) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `ketluan` varchar(255) COLLATE utf8_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `khamsuckhoe`
--

INSERT INTO `khamsuckhoe` (`id`, `sophieukham`, `lankham`, `namhoc`, `ngaykham`, `mahocsinh`, `macbyt`, `chieucao`, `cannang`, `benh`, `ketluan`) VALUES
(1, 'H1', 1, '2012', '2017-06-01', 6, 3, '145', '35', 'kHÔNG', 'Tốt'),
(2, 'H1', 1, '2012', '2017-06-01', 6, 3, '145', '35', 'kHÔNG', 'Tốt'),
(3, '12', 1, '2012', '2017-06-05', 20, 3, '145', '123', 'ssdsd', '1212'),
(4, 'Z1', 1, '2012', '2012-01-01', 20, 3, '1', '1', NULL, '111');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nktheodoi`
--

CREATE TABLE `nktheodoi` (
  `id` int(11) NOT NULL,
  `ngaytheodoi` date NOT NULL,
  `mahs` int(11) NOT NULL,
  `tinhtrang` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `nktheodoi`
--

INSERT INTO `nktheodoi` (`id`, `ngaytheodoi`, `mahs`, `tinhtrang`) VALUES
(1, '2017-06-01', 5, 0),
(2, '1997-03-25', 5, 0),
(3, '2017-06-01', 5, 1),
(4, '2016-01-01', 5, 0),
(6, '2017-06-01', 5, 0),
(7, '2017-06-01', 5, 0),
(8, '2017-06-01', 5, 0),
(9, '2017-06-01', 5, 0),
(10, '2017-06-24', 5, 0),
(11, '2017-06-24', 20, 1),
(12, '2017-06-24', 11, 0),
(13, '2017-06-24', 6, 0),
(14, '2017-06-24', 14, 0),
(15, '2017-06-24', 15, 0),
(16, '2017-06-24', 12, 0),
(17, '2017-06-24', 13, 0),
(18, '2017-06-24', 16, 0),
(19, '2017-06-24', 9, 0),
(20, '2017-06-24', 8, 1),
(21, '2017-06-24', 10, 1),
(22, '2017-06-24', 7, 1),
(23, '2017-06-24', 17, 0),
(24, '2017-06-24', 18, 0),
(25, '2017-06-24', 19, 0),
(27, '2017-06-24', 20, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thutienhoc`
--

CREATE TABLE `thutienhoc` (
  `id` int(11) NOT NULL,
  `mabienlai` varchar(50) COLLATE utf8_vietnamese_ci NOT NULL,
  `ngaythu` date NOT NULL,
  `mahs` int(11) NOT NULL,
  `tienhocphi` int(11) NOT NULL,
  `tienan` float NOT NULL,
  `tienphuthu` float NOT NULL,
  `tongtien` float NOT NULL,
  `namhoc` varchar(50) COLLATE utf8_vietnamese_ci NOT NULL,
  `tiendadong` int(11) DEFAULT NULL,
  `tienchuadong` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `thutienhoc`
--

INSERT INTO `thutienhoc` (`id`, `mabienlai`, `ngaythu`, `mahs`, `tienhocphi`, `tienan`, `tienphuthu`, `tongtien`, `namhoc`, `tiendadong`, `tienchuadong`) VALUES
(1, 'MS1', '2017-06-01', 5, 1000, 1000, 1000, 10000, '2012', 10, 10);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `cbyt`
--
ALTER TABLE `cbyt`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `giaovien`
--
ALTER TABLE `giaovien`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `hocsinh`
--
ALTER TABLE `hocsinh`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_lop_student` (`malop`);

--
-- Chỉ mục cho bảng `iclass`
--
ALTER TABLE `iclass`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `unique` (`malop`),
  ADD KEY `fk_gv_class` (`magv`);

--
-- Chỉ mục cho bảng `khamsuckhoe`
--
ALTER TABLE `khamsuckhoe`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_cbyt_sk` (`macbyt`),
  ADD KEY `fk_sk_hs` (`mahocsinh`);

--
-- Chỉ mục cho bảng `nktheodoi`
--
ALTER TABLE `nktheodoi`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_theodoi_hs` (`mahs`);

--
-- Chỉ mục cho bảng `thutienhoc`
--
ALTER TABLE `thutienhoc`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_tien_hs` (`mahs`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `cbyt`
--
ALTER TABLE `cbyt`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT cho bảng `giaovien`
--
ALTER TABLE `giaovien`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT cho bảng `hocsinh`
--
ALTER TABLE `hocsinh`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT cho bảng `iclass`
--
ALTER TABLE `iclass`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT cho bảng `khamsuckhoe`
--
ALTER TABLE `khamsuckhoe`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT cho bảng `nktheodoi`
--
ALTER TABLE `nktheodoi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;
--
-- AUTO_INCREMENT cho bảng `thutienhoc`
--
ALTER TABLE `thutienhoc`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `hocsinh`
--
ALTER TABLE `hocsinh`
  ADD CONSTRAINT `fk_lop_student` FOREIGN KEY (`malop`) REFERENCES `iclass` (`id`);

--
-- Các ràng buộc cho bảng `iclass`
--
ALTER TABLE `iclass`
  ADD CONSTRAINT `fk_gv_class` FOREIGN KEY (`magv`) REFERENCES `giaovien` (`id`);

--
-- Các ràng buộc cho bảng `khamsuckhoe`
--
ALTER TABLE `khamsuckhoe`
  ADD CONSTRAINT `fk_cbyt_sk` FOREIGN KEY (`macbyt`) REFERENCES `cbyt` (`id`),
  ADD CONSTRAINT `fk_sk_hs` FOREIGN KEY (`mahocsinh`) REFERENCES `hocsinh` (`id`);

--
-- Các ràng buộc cho bảng `nktheodoi`
--
ALTER TABLE `nktheodoi`
  ADD CONSTRAINT `fk_theodoi_hs` FOREIGN KEY (`mahs`) REFERENCES `hocsinh` (`id`);

--
-- Các ràng buộc cho bảng `thutienhoc`
--
ALTER TABLE `thutienhoc`
  ADD CONSTRAINT `fk_tien_hs` FOREIGN KEY (`mahs`) REFERENCES `hocsinh` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
