-- phpMyAdmin SQL Dump
-- version 4.9.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: May 26, 2020 at 02:10 PM
-- Server version: 5.7.26
-- PHP Version: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `edt`
--

-- --------------------------------------------------------

--
-- Table structure for table `Cours`
--

CREATE TABLE `Cours` (
  `ID_Cours` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Enseignant`
--

CREATE TABLE `Enseignant` (
  `ID_Utilisateur` int(11) NOT NULL,
  `ID_Cours` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Etudiant`
--

CREATE TABLE `Etudiant` (
  `ID_Utilisateur` int(11) NOT NULL,
  `numero` int(11) NOT NULL,
  `ID_Groupe` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Groupe`
--

CREATE TABLE `Groupe` (
  `ID_Groupe` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `ID_Promotion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Promotion`
--

CREATE TABLE `Promotion` (
  `ID_Promotion` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Salle`
--

CREATE TABLE `Salle` (
  `ID_Salle` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `capacite` int(11) NOT NULL,
  `ID_Site` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Seance`
--

CREATE TABLE `Seance` (
  `ID_Seance` int(11) NOT NULL,
  `semaine` int(11) NOT NULL,
  `date` date NOT NULL,
  `heure_debut` time NOT NULL,
  `heure_fin` time NOT NULL,
  `etat` int(11) NOT NULL,
  `ID_Cours` int(11) NOT NULL,
  `ID_Type` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Seance_Ensaignants`
--

CREATE TABLE `Seance_Ensaignants` (
  `ID_Seance` int(11) NOT NULL,
  `ID_Enseignant` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Seance_Groupe`
--

CREATE TABLE `Seance_Groupe` (
  `ID_Seance` int(11) NOT NULL,
  `ID_Groupe` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Seance_Salles`
--

CREATE TABLE `Seance_Salles` (
  `ID_Seance` int(11) NOT NULL,
  `ID_Salle` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Site`
--

CREATE TABLE `Site` (
  `ID_Site` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Type_Cours`
--

CREATE TABLE `Type_Cours` (
  `ID_Type` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Utilisateur`
--

CREATE TABLE `Utilisateur` (
  `ID_Utilisateur` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `pwd` varchar(255) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `droit` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Cours`
--
ALTER TABLE `Cours`
  ADD PRIMARY KEY (`ID_Cours`);

--
-- Indexes for table `Enseignant`
--
ALTER TABLE `Enseignant`
  ADD PRIMARY KEY (`ID_Utilisateur`,`ID_Cours`),
  ADD KEY `ID_Utilisateur` (`ID_Utilisateur`),
  ADD KEY `ID_Cours` (`ID_Cours`);

--
-- Indexes for table `Etudiant`
--
ALTER TABLE `Etudiant`
  ADD PRIMARY KEY (`ID_Utilisateur`),
  ADD KEY `ID_Groupe` (`ID_Groupe`),
  ADD KEY `ID_Utilisateur` (`ID_Utilisateur`);

--
-- Indexes for table `Groupe`
--
ALTER TABLE `Groupe`
  ADD PRIMARY KEY (`ID_Groupe`),
  ADD KEY `ID_Promotion` (`ID_Promotion`);

--
-- Indexes for table `Promotion`
--
ALTER TABLE `Promotion`
  ADD PRIMARY KEY (`ID_Promotion`);

--
-- Indexes for table `Salle`
--
ALTER TABLE `Salle`
  ADD PRIMARY KEY (`ID_Salle`),
  ADD KEY `ID_Site` (`ID_Site`);

--
-- Indexes for table `Seance`
--
ALTER TABLE `Seance`
  ADD PRIMARY KEY (`ID_Seance`),
  ADD KEY `ID_Cours` (`ID_Cours`),
  ADD KEY `ID_Type` (`ID_Type`);

--
-- Indexes for table `Seance_Ensaignants`
--
ALTER TABLE `Seance_Ensaignants`
  ADD PRIMARY KEY (`ID_Seance`,`ID_Enseignant`),
  ADD KEY `ID_Seance` (`ID_Seance`),
  ADD KEY `ID_Enseignant` (`ID_Enseignant`);

--
-- Indexes for table `Seance_Groupe`
--
ALTER TABLE `Seance_Groupe`
  ADD PRIMARY KEY (`ID_Seance`,`ID_Groupe`),
  ADD KEY `ID_Seance` (`ID_Seance`),
  ADD KEY `ID_Groupe` (`ID_Groupe`);

--
-- Indexes for table `Seance_Salles`
--
ALTER TABLE `Seance_Salles`
  ADD PRIMARY KEY (`ID_Seance`,`ID_Salle`),
  ADD KEY `ID_Seance` (`ID_Seance`),
  ADD KEY `ID_Salle` (`ID_Salle`);

--
-- Indexes for table `Site`
--
ALTER TABLE `Site`
  ADD PRIMARY KEY (`ID_Site`);

--
-- Indexes for table `Type_Cours`
--
ALTER TABLE `Type_Cours`
  ADD PRIMARY KEY (`ID_Type`);

--
-- Indexes for table `Utilisateur`
--
ALTER TABLE `Utilisateur`
  ADD PRIMARY KEY (`ID_Utilisateur`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Cours`
--
ALTER TABLE `Cours`
  MODIFY `ID_Cours` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Groupe`
--
ALTER TABLE `Groupe`
  MODIFY `ID_Groupe` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Promotion`
--
ALTER TABLE `Promotion`
  MODIFY `ID_Promotion` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Salle`
--
ALTER TABLE `Salle`
  MODIFY `ID_Salle` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Seance`
--
ALTER TABLE `Seance`
  MODIFY `ID_Seance` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Site`
--
ALTER TABLE `Site`
  MODIFY `ID_Site` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Type_Cours`
--
ALTER TABLE `Type_Cours`
  MODIFY `ID_Type` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Utilisateur`
--
ALTER TABLE `Utilisateur`
  MODIFY `ID_Utilisateur` int(11) NOT NULL AUTO_INCREMENT;
