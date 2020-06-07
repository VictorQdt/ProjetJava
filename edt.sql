-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3308
-- Généré le :  Dim 07 juin 2020 à 20:25
-- Version du serveur :  8.0.18
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `edt`
--

-- --------------------------------------------------------

--
-- Structure de la table `cours`
--

DROP TABLE IF EXISTS `cours`;
CREATE TABLE IF NOT EXISTS `cours` (
  `ID_Cours` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  PRIMARY KEY (`ID_Cours`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `cours`
--

INSERT INTO `cours` (`ID_Cours`, `nom`) VALUES
(1, 'Maths'),
(5, 'Physique'),
(6, 'Traitement du Signal'),
(7, 'Informatique'),
(8, 'PSTE'),
(9, 'Anthropologie'),
(10, 'Anglais'),
(11, 'Espagnol');

-- --------------------------------------------------------

--
-- Structure de la table `enseignant`
--

DROP TABLE IF EXISTS `enseignant`;
CREATE TABLE IF NOT EXISTS `enseignant` (
  `ID_Utilisateur` int(11) NOT NULL,
  `ID_Cours` int(11) NOT NULL,
  PRIMARY KEY (`ID_Utilisateur`,`ID_Cours`),
  KEY `ID_Utilisateur` (`ID_Utilisateur`),
  KEY `ID_Cours` (`ID_Cours`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `enseignant`
--

INSERT INTO `enseignant` (`ID_Utilisateur`, `ID_Cours`) VALUES
(3, 1),
(3, 2),
(4, 7),
(5, 1),
(6, 6),
(7, 1),
(8, 10),
(9, 11),
(10, 8),
(11, 9);

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

DROP TABLE IF EXISTS `etudiant`;
CREATE TABLE IF NOT EXISTS `etudiant` (
  `ID_Utilisateur` int(11) NOT NULL,
  `numero` int(11) NOT NULL,
  `ID_Groupe` int(11) NOT NULL,
  PRIMARY KEY (`ID_Utilisateur`),
  KEY `ID_Groupe` (`ID_Groupe`),
  KEY `ID_Utilisateur` (`ID_Utilisateur`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `etudiant`
--

INSERT INTO `etudiant` (`ID_Utilisateur`, `numero`, `ID_Groupe`) VALUES
(1, 1, 1),
(2, 1, 1),
(12, 1234567, 2),
(13, 9765, 2),
(14, 73, 3),
(17, 987654, 1);

-- --------------------------------------------------------

--
-- Structure de la table `groupe`
--

DROP TABLE IF EXISTS `groupe`;
CREATE TABLE IF NOT EXISTS `groupe` (
  `ID_Groupe` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `ID_Promotion` int(11) NOT NULL,
  PRIMARY KEY (`ID_Groupe`),
  KEY `ID_Promotion` (`ID_Promotion`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `groupe`
--

INSERT INTO `groupe` (`ID_Groupe`, `nom`, `ID_Promotion`) VALUES
(1, 'td1', 1),
(2, 'td2', 1),
(3, 'TD3', 1),
(4, 'TD4', 1);

-- --------------------------------------------------------

--
-- Structure de la table `promotion`
--

DROP TABLE IF EXISTS `promotion`;
CREATE TABLE IF NOT EXISTS `promotion` (
  `ID_Promotion` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  PRIMARY KEY (`ID_Promotion`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `promotion`
--

INSERT INTO `promotion` (`ID_Promotion`, `nom`) VALUES
(1, 'ING3');

-- --------------------------------------------------------

--
-- Structure de la table `salle`
--

DROP TABLE IF EXISTS `salle`;
CREATE TABLE IF NOT EXISTS `salle` (
  `ID_Salle` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `capacite` int(11) NOT NULL,
  `ID_Site` int(11) NOT NULL,
  PRIMARY KEY (`ID_Salle`),
  KEY `ID_Site` (`ID_Site`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `salle`
--

INSERT INTO `salle` (`ID_Salle`, `nom`, `capacite`, `ID_Site`) VALUES
(1, 'p300', 30, 1),
(2, 'p400', 50, 2),
(3, 'p500', 30, 1),
(4, 'p600', 40, 2);

-- --------------------------------------------------------

--
-- Structure de la table `seance`
--

DROP TABLE IF EXISTS `seance`;
CREATE TABLE IF NOT EXISTS `seance` (
  `ID_Seance` int(11) NOT NULL AUTO_INCREMENT,
  `semaine` int(11) NOT NULL,
  `date` bigint(11) NOT NULL,
  `duree` float NOT NULL,
  `etat` int(11) NOT NULL,
  `ID_Cours` int(11) NOT NULL,
  `ID_Type` int(11) NOT NULL,
  PRIMARY KEY (`ID_Seance`),
  KEY `ID_Cours` (`ID_Cours`),
  KEY `ID_Type` (`ID_Type`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `seance`
--

INSERT INTO `seance` (`ID_Seance`, `semaine`, `date`, `duree`, `etat`, `ID_Cours`, `ID_Type`) VALUES
(1, 5, 1590673550000, 1.5, 0, 1, 1),
(2, 5, 1590751850000, 2, 1, 2, 1),
(3, 5, 1591372833761, 2.5, 1, 1, 1),
(20, 24, 1591597800000, 1.5, 0, 1, 1),
(21, 24, 1591605000000, 2, 2, 8, 1),
(22, 24, 1591709400000, 1.5, 0, 7, 2),
(23, 24, 1591875000000, 1, 1, 10, 1),
(24, 24, 1591714800000, 1.5, 0, 10, 2),
(25, 24, 1591707600000, 1.5, 0, 6, 3),
(26, 25, 1592312400000, 1.5, 0, 6, 3),
(27, 23, 1591102800000, 1.5, 0, 6, 3);

-- --------------------------------------------------------

--
-- Structure de la table `seance_enseignants`
--

DROP TABLE IF EXISTS `seance_enseignants`;
CREATE TABLE IF NOT EXISTS `seance_enseignants` (
  `ID_Seance` int(11) NOT NULL,
  `ID_Enseignant` int(11) NOT NULL,
  PRIMARY KEY (`ID_Seance`,`ID_Enseignant`),
  KEY `ID_Seance` (`ID_Seance`),
  KEY `ID_Enseignant` (`ID_Enseignant`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `seance_enseignants`
--

INSERT INTO `seance_enseignants` (`ID_Seance`, `ID_Enseignant`) VALUES
(1, 3),
(2, 3),
(3, 3),
(20, 7),
(21, 10),
(22, 4),
(23, 8),
(24, 6),
(25, 8),
(26, 8),
(27, 8);

-- --------------------------------------------------------

--
-- Structure de la table `seance_groupe`
--

DROP TABLE IF EXISTS `seance_groupe`;
CREATE TABLE IF NOT EXISTS `seance_groupe` (
  `ID_Seance` int(11) NOT NULL,
  `ID_Groupe` int(11) NOT NULL,
  PRIMARY KEY (`ID_Seance`,`ID_Groupe`),
  KEY `ID_Seance` (`ID_Seance`),
  KEY `ID_Groupe` (`ID_Groupe`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `seance_groupe`
--

INSERT INTO `seance_groupe` (`ID_Seance`, `ID_Groupe`) VALUES
(1, 1),
(2, 1),
(3, 2),
(20, 1),
(21, 2),
(23, 1),
(23, 2),
(24, 1),
(25, 1),
(26, 1),
(26, 2),
(26, 3),
(27, 3);

-- --------------------------------------------------------

--
-- Structure de la table `seance_salles`
--

DROP TABLE IF EXISTS `seance_salles`;
CREATE TABLE IF NOT EXISTS `seance_salles` (
  `ID_Seance` int(11) NOT NULL,
  `ID_Salle` int(11) NOT NULL,
  PRIMARY KEY (`ID_Seance`,`ID_Salle`),
  KEY `ID_Seance` (`ID_Seance`),
  KEY `ID_Salle` (`ID_Salle`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `seance_salles`
--

INSERT INTO `seance_salles` (`ID_Seance`, `ID_Salle`) VALUES
(1, 1),
(1, 2),
(2, 2),
(3, 2),
(3, 3),
(3, 4),
(20, 1),
(21, 2),
(22, 2),
(23, 4),
(24, 1),
(25, 3),
(26, 3),
(27, 3);

-- --------------------------------------------------------

--
-- Structure de la table `site`
--

DROP TABLE IF EXISTS `site`;
CREATE TABLE IF NOT EXISTS `site` (
  `ID_Site` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  PRIMARY KEY (`ID_Site`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `site`
--

INSERT INTO `site` (`ID_Site`, `nom`) VALUES
(1, 'E1'),
(2, 'E2');

-- --------------------------------------------------------

--
-- Structure de la table `type_cours`
--

DROP TABLE IF EXISTS `type_cours`;
CREATE TABLE IF NOT EXISTS `type_cours` (
  `ID_Type` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  PRIMARY KEY (`ID_Type`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `type_cours`
--

INSERT INTO `type_cours` (`ID_Type`, `nom`) VALUES
(1, 'Cours'),
(3, 'TP'),
(4, 'TD');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `ID_Utilisateur` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `pwd` varchar(255) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `droit` int(11) NOT NULL,
  PRIMARY KEY (`ID_Utilisateur`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`ID_Utilisateur`, `email`, `pwd`, `nom`, `prenom`, `droit`) VALUES
(1, 'fsr', 'fes', 'fes', 'fe', 4),
(2, 'fes', 'fes', 'fes', 'fes', 4),
(3, 'a', 'a', 'jps', 'jps', 3),
(4, 'segado@gmail.com', 'info', 'segado', 's', 3),
(5, 'coudray@gmail.com', 'math', 'coudray', 'm', 3),
(6, 'lopes@gmail.com', 'elec', 'lopes', 'n', 3),
(7, 'chary@gmail.com', 'math', 'chary', 'z', 3),
(8, 'zouzou@gmail.com', 'anglais', 'zouzou', 'cecile', 3),
(9, 'dupont@gmail.com', 'espagnol', 'dupont', 'charles', 3),
(10, 'lemarec@gmail.com', 'pste', 'lemarec', 'steph', 3),
(11, 'poulou@gmail.com', 'anthro', 'poulou', 'lou', 3),
(12, 'victor@gmail.com', 'vic', 'quidet', 'victor', 4),
(13, 'paul@gmail.com', 'paul', 'senard', 'paul', 4),
(14, 'corentin@gmail.com', 'coco', 'talamon', 'coco', 4),
(15, 'zeus@gmail.com', 'sss', 'zeus', 'titant', 1),
(16, 'lolo@gmail.com', 'lolo', 'azert', 'y', 2),
(17, 'michel@gmail.com', 'michou', 'michel', 'jean', 4);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
