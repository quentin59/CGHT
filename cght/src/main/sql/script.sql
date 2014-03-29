-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Client: 127.0.0.1
-- Généré le: Sam 29 Mars 2014 à 16:58
-- Version du serveur: 5.5.27-log
-- Version de PHP: 5.4.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `projetiti`
--

-- --------------------------------------------------------

--
-- Structure de la table `actualite`
--

CREATE TABLE IF NOT EXISTS `actualite` (
  `idActualite` int(11) NOT NULL AUTO_INCREMENT,
  `titre` varchar(100) NOT NULL,
  `contenu` text NOT NULL,
  `numLicence` varchar(8) NOT NULL,
  `dateActualite` date NOT NULL,
  PRIMARY KEY (`idActualite`),
  KEY `numLicence` (`numLicence`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `actualite`
--

INSERT INTO `actualite` (`idActualite`, `titre`, `contenu`, `numLicence`, `dateActualite`) VALUES
(1, 'coucou', 'zizoiecizecoiezncinzeiocnioznczeoi', '12345678', '2014-02-08'),
(2, 'ok', 'azerty', '12345678', '2014-02-08'),
(3, 'a', 'azer', '12345678', '2013-01-15'),
(4, 'b', 'azer', '12345678', '2013-02-15');

-- --------------------------------------------------------

--
-- Structure de la table `adherent`
--

CREATE TABLE IF NOT EXISTS `adherent` (
  `numLicence` varchar(8) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `dateNaissance` date NOT NULL,
  `adresse` varchar(50) DEFAULT NULL,
  `codePostal` char(5) DEFAULT NULL,
  `ville` varchar(30) DEFAULT NULL,
  `telephone` char(10) NOT NULL,
  `portable` char(10) DEFAULT NULL,
  `mail` varchar(30) DEFAULT NULL,
  `numPass` varchar(10) DEFAULT NULL,
  `classement` varchar(10) NOT NULL,
  `certif` tinyint(1) DEFAULT NULL,
  `statut` varchar(15) DEFAULT NULL,
  `prendrePhoto` tinyint(1) DEFAULT NULL,
  `publierPhoto` tinyint(1) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`numLicence`),
  KEY `numLicence` (`numLicence`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `adherent`
--

INSERT INTO `adherent` (`numLicence`, `nom`, `prenom`, `dateNaissance`, `adresse`, `codePostal`, `ville`, `telephone`, `portable`, `mail`, `numPass`, `classement`, `certif`, `statut`, `prendrePhoto`, `publierPhoto`, `password`) VALUES
('12345678', 'Vendeville', 'Quentin', '1992-08-06', '11 allée du Talisman', '59650', 'Villeneuve d''Ascq', '0320916554', '0678987694', 'quentin.vendeville@hei.Fr', '3456', 'NC', 1, 'administrateur', 1, 1, 'azertyuiop'),
('1300000G', 'Poillot', 'Thomas', '1992-12-28', '', '', 'Chéreng', '', '', 'thom.poillot@gmail.com', '', '40', 1, 'adherent', 1, 1, '123456'),
('1500000J', 'Regolle', 'Lisa', '1992-11-03', NULL, NULL, NULL, '0808080808', NULL, NULL, NULL, '15/3', NULL, NULL, NULL, NULL, NULL),
('1500001J', 'Descamps', 'Stanislas', '1991-07-03', '5 rue de la pluie', '6000', 'Nice', '0707070707', '0505050505', 'stan.descamps@hei.Fr', '56789', '30/5', 0, 'adherent', 0, 1, '123456'),
('23456789', 'Dupond', 'Jean', '2014-03-03', NULL, NULL, NULL, '', NULL, NULL, NULL, '40', NULL, 'adherent', NULL, NULL, 'adazdazdazdadzada'),
('9876543F', 'Thibault', 'Damien', '1990-10-10', NULL, NULL, NULL, '0320032003', NULL, NULL, NULL, '0', NULL, NULL, NULL, NULL, '');

-- --------------------------------------------------------

--
-- Structure de la table `annonce`
--

CREATE TABLE IF NOT EXISTS `annonce` (
  `idAnnonce` int(11) NOT NULL AUTO_INCREMENT,
  `titre` varchar(100) NOT NULL,
  `contenu` text NOT NULL,
  `coordonnees` varchar(100) NOT NULL,
  `numLicence` varchar(8) NOT NULL,
  `dateAnnonce` date NOT NULL,
  `categorie` varchar(30) NOT NULL,
  `prix` float NOT NULL,
  PRIMARY KEY (`idAnnonce`),
  KEY `numLicence` (`numLicence`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `annonce`
--

INSERT INTO `annonce` (`idAnnonce`, `titre`, `contenu`, `coordonnees`, `numLicence`, `dateAnnonce`, `categorie`, `prix`) VALUES
(1, 'Vente de raquette', 'Je vends une raquette !', '06-06-06-06-06', '12345678', '2014-02-15', 'Vente de matériel', 1000),
(2, 'Recherche joueur', 'Bonjour,\r\n\r\nJe recherche un ou une joueur/se pour taper la baballe ensemble :p', '0678901234', '12345678', '2014-02-24', 'Recherche', 0);

-- --------------------------------------------------------

--
-- Structure de la table `cours`
--

CREATE TABLE IF NOT EXISTS `cours` (
  `idCours` int(11) NOT NULL AUTO_INCREMENT,
  `jourCours` varchar(15) NOT NULL,
  `heureDebut` int(11) NOT NULL,
  `minuteDebut` int(11) NOT NULL,
  `heureFin` int(11) NOT NULL,
  `minuteFin` int(11) NOT NULL,
  PRIMARY KEY (`idCours`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Contenu de la table `cours`
--

INSERT INTO `cours` (`idCours`, `jourCours`, `heureDebut`, `minuteDebut`, `heureFin`, `minuteFin`) VALUES
(1, 'lundi', 19, 5, 21, 15),
(3, 'mardi', 15, 30, 17, 0),
(4, 'vendredi', 8, 0, 9, 30),
(5, 'mardi', 13, 0, 14, 30);

-- --------------------------------------------------------

--
-- Structure de la table `paiement`
--

CREATE TABLE IF NOT EXISTS `paiement` (
  `idPaiement` int(11) NOT NULL AUTO_INCREMENT,
  `numCheque` varchar(20) NOT NULL,
  `banque` varchar(20) NOT NULL,
  `echeance` date NOT NULL,
  `montant` decimal(10,0) NOT NULL,
  `numLicence` varchar(8) NOT NULL,
  PRIMARY KEY (`idPaiement`),
  KEY `numLicence` (`numLicence`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `participer`
--

CREATE TABLE IF NOT EXISTS `participer` (
  `numLicence` varchar(8) NOT NULL,
  `idCours` int(11) NOT NULL,
  PRIMARY KEY (`numLicence`,`idCours`),
  KEY `idCours` (`idCours`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `participer`
--

INSERT INTO `participer` (`numLicence`, `idCours`) VALUES
('1300000G', 1),
('1300000G', 5);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `actualite`
--
ALTER TABLE `actualite`
  ADD CONSTRAINT `actualite_ibfk_1` FOREIGN KEY (`numLicence`) REFERENCES `adherent` (`numLicence`) ON UPDATE CASCADE;

--
-- Contraintes pour la table `annonce`
--
ALTER TABLE `annonce`
  ADD CONSTRAINT `annonce_ibfk_1` FOREIGN KEY (`numLicence`) REFERENCES `adherent` (`numLicence`) ON UPDATE CASCADE;

--
-- Contraintes pour la table `paiement`
--
ALTER TABLE `paiement`
  ADD CONSTRAINT `paiement_ibfk_1` FOREIGN KEY (`numLicence`) REFERENCES `adherent` (`numLicence`) ON UPDATE CASCADE;

--
-- Contraintes pour la table `participer`
--
ALTER TABLE `participer`
  ADD CONSTRAINT `participer_ibfk_2` FOREIGN KEY (`idCours`) REFERENCES `cours` (`idCours`),
  ADD CONSTRAINT `participer_ibfk_1` FOREIGN KEY (`numLicence`) REFERENCES `adherent` (`numLicence`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
