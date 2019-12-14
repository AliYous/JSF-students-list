{\rtf1\ansi\ansicpg1252\cocoartf2511
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;}
{\*\expandedcolortbl;;}
\paperw11900\paperh16840\margl1440\margr1440\vieww10800\viewh8400\viewkind0
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural\partightenfactor0

\f0\fs24 \cf0 -- phpMyAdmin SQL Dump\
-- version 4.8.5\
-- https://www.phpmyadmin.net/\
--\
-- Host: localhost:8889\
-- Generation Time: Dec 14, 2019 at 06:58 PM\
-- Server version: 5.7.25\
-- PHP Version: 7.3.1\
\
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";\
SET time_zone = "+00:00";\
\
--\
-- Database: `studentdb`\
--\
\
-- --------------------------------------------------------\
\
--\
-- Table structure for table `student`\
--\
\
CREATE TABLE `student` (\
  `id` int(11) NOT NULL,\
  `firstName` varchar(50) NOT NULL,\
  `lastName` varchar(50) NOT NULL,\
  `email` varchar(50) NOT NULL\
) ENGINE=InnoDB DEFAULT CHARSET=utf8;\
\
--\
-- Dumping data for table `student`\
--\
\
INSERT INTO `student` (`id`, `firstName`, `lastName`, `email`) VALUES\
(1, 'Ahsan', 'Khalil', 'ahsan@gmail.com'),\
(5, 'Muhammad', 'Khalil', 'mahsanprogrammer@gmail.com'),\
(7, 'Kashif', 'afzal', 'kashif@gmail.com');\
\
--\
-- Indexes for dumped tables\
--\
\
--\
-- Indexes for table `student`\
--\
ALTER TABLE `student`\
  ADD PRIMARY KEY (`id`);\
\
--\
-- AUTO_INCREMENT for dumped tables\
--\
\
--\
-- AUTO_INCREMENT for table `student`\
--\
ALTER TABLE `student`\
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;\
}