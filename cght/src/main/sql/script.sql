-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Client: 127.0.0.1
-- Généré le: Lun 12 Mai 2014 à 20:42
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `actualite`
--

INSERT INTO `actualite` (`idActualite`, `titre`, `contenu`, `numLicence`, `dateActualite`) VALUES
(1, 'Tournoi interne', 'Comme tous les ans, le club vous propose de participer au tournoi interne!\r\n\r\nLes inscriptions sont gratuites et se font auprès de Vincent Dupond.\r\n\r\nOn espère vous voir nombreux !', '12345678', '2014-03-02'),
(2, 'Assemblée générale', 'L''assemblée générale annuelle aura lieu de vendredi 14 mars dans la salle Polyvalente d''Haubourdin à 18h;\r\n\r\nElle sera suivie d''un cocktail de l''amitié !', '1500000J', '2014-03-07'),
(3, 'Stage de Pâques', 'Le club vous propose un stage pour les jeunes pendant les vacances de Pâques !\n\nIl se déroulera du lundi 21 au jeudi 24 avril 2014, de 10h à 12h et de 12h30 à 14h30 pour 30€.\n\nBonnes vacances !', '1500000J', '2014-04-20');

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
('12345678', 'Vendeville', 'Quentin', '1992-08-06', '11 allée du Talisman', '59650', 'Villeneuve d''Ascq', '0320916554', '0678987694', 'q@v.fr', '3456', 'NC', 1, 'administrateur', 1, 1, '8ad811c3e12c0c112849a46a7392a644'),
('1300000G', 'Poillot', 'Thomas', '1992-12-28', '', '', 'Chéreng', '', '', 'thom.poillot@gmail.com', '', '40', 1, 'adherent', 1, 1, 'c56d0e9a7ccec67b4ea131655038d604'),
('1325364H', 'Descamps', 'Stanislas', '1991-07-03', '5 rue de la pluie', '06000', 'Nice', '0707070707', '0505050505', 'stan.descamps@hei.Fr', '56789', '30/5', 0, 'adherent', 0, 1, 'c56d0e9a7ccec67b4ea131655038d604'),
('1500000J', 'Regolle', 'Lisa', '1992-11-03', '3 bis chemin de Tavoy', '59320', 'Hallennes-Lez-Haubourdin', '0320384275', '0647941894', 'l@r.fr', '633', '15/3', 1, 'administrateur', 1, 1, '0e0e456aa16f8574a2f5dc1394f99708'),
('3500000H', 'Malvache', 'Maxime', '1992-08-04', '11 rue des chouettes', '14000', 'Montreal', '0303030303', '0606060606', 'vendevillequentin59@free.fr', '4321', '30/5', 1, 'adherent', 1, 0, 'c56d0e9a7ccec67b4ea131655038d604'),
('8532593A', 'Dupond', 'Vincent', '1992-12-28', '12 Allée de le Lavande', '59550', 'Chéreng', '0345651077', '0777153094', 'v@d.fr', '057', '15/5', 1, 'adherent', 1, 1, 'c56d0e9a7ccec67b4ea131655038d604');

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
(1, 'Vente de raquette', 'Je me sépare de mon ancienne raquette. C''est une Wilson rouge et blanche. Quelques coups sur le cadre mais bon état général. Faire offre de prix ! Merci !', '06-06-06-06-06', '12345678', '2014-02-15', 'Vente de matériel', 1000),
(2, 'Recherche joueur', 'Bonjour,\n\nJe recherche un ou une joueur/se pour s''entrainer le samedi ou dimanche matin tous les 15 jours. Je suis de niveau 30.\n\nMerci de me contacter par mail !\n\nSportivement,\nStan.', 's@d.fr', '1325364H', '2014-02-24', 'Recherche de partenaire de jeu', 0);

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Contenu de la table `cours`
--

INSERT INTO `cours` (`idCours`, `jourCours`, `heureDebut`, `minuteDebut`, `heureFin`, `minuteFin`) VALUES
(1, 'Mardi', 19, 0, 21, 0),
(2, 'Mercredi', 18, 0, 19, 30),
(3, 'Mercredi', 19, 30, 21, 30),
(4, 'Jeudi', 19, 0, 20, 30),
(5, 'Jeudi', 20, 30, 22, 30),
(6, 'Samedi', 14, 0, 16, 0),
(7, 'Samedi', 16, 0, 18, 0);

-- --------------------------------------------------------

--
-- Structure de la table `flag`
--

CREATE TABLE IF NOT EXISTS `flag` (
  `notification` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `flag`
--

INSERT INTO `flag` (`notification`) VALUES
(0);

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
  `payer` tinyint(1) NOT NULL,
  PRIMARY KEY (`idPaiement`),
  KEY `numLicence` (`numLicence`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Contenu de la table `paiement`
--

INSERT INTO `paiement` (`idPaiement`, `numCheque`, `banque`, `echeance`, `montant`, `numLicence`, `payer`) VALUES
(1, '1234', 'LCL', '2014-05-05', '100', '1300000G', 0),
(2, '1235', 'Crédit agricole', '2014-05-09', '150', '1325364H', 0),
(3, '1236', 'Caisse d''épargne', '2014-06-10', '100', '1325364H', 1),
(4, '9876', 'Société générale', '2014-06-07', '55', '1500000J', 0),
(5, '1830', 'LCL', '2014-05-01', '55', '12345678', 0),
(6, '1358', 'Crédit mutuel', '2014-02-07', '75', '8532593A', 1),
(7, '2601', 'Crédit mutuel', '2014-06-05', '75', '8532593A', 0),
(8, '9248', 'CIC', '2014-03-13', '150', '3500000H', 1);

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
('1325364H', 1),
('12345678', 2),
('1500000J', 3),
('1300000G', 4),
('3500000H', 4),
('8532593A', 4),
('12345678', 5),
('1300000G', 6),
('1325364H', 6),
('8532593A', 6),
('12345678', 7),
('1500000J', 7);

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
  ADD CONSTRAINT `participer_ibfk_1` FOREIGN KEY (`numLicence`) REFERENCES `adherent` (`numLicence`),
  ADD CONSTRAINT `participer_ibfk_2` FOREIGN KEY (`idCours`) REFERENCES `cours` (`idCours`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
