-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Lun 30 Juin 2014 à 11:51
-- Version du serveur: 5.00.15
-- Version de PHP: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `cinepantin`
--
CREATE DATABASE IF NOT EXISTS `cinepantin` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `cinepantin`;

-- --------------------------------------------------------

--
-- Structure de la table `adresse`
--

CREATE TABLE IF NOT EXISTS `adresse` (
  `IDADRESSE` bigint(20) NOT NULL,
  `CODEPOSTAL` varchar(255) character set utf8 collate utf8_bin default NULL,
  `PAYS` varchar(255) character set utf8 collate utf8_bin default NULL,
  `RUE` varchar(255) character set utf8 collate utf8_bin default NULL,
  `TELEPHONE` varchar(255) character set utf8 collate utf8_bin default NULL,
  `VILLE` varchar(255) character set utf8 collate utf8_bin default NULL,
  `NOM` varchar(255) default NULL,
  `PRENOM` varchar(255) default NULL,
  PRIMARY KEY  (`IDADRESSE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `adresse`
--

INSERT INTO `adresse` (`IDADRESSE`, `CODEPOSTAL`, `PAYS`, `RUE`, `TELEPHONE`, `VILLE`, `NOM`, `PRENOM`) VALUES
(6, '75009', 'France', '32 rue de l''arcade', '06 12 14 47 14', 'Paris', 'marzouk1', 'wiem1');

-- --------------------------------------------------------

--
-- Structure de la table `article`
--

CREATE TABLE IF NOT EXISTS `article` (
  `IDARTICLE` bigint(20) NOT NULL,
  `LONGDESCARTICLE` text character set utf8 collate utf8_bin,
  `NOMARTICLE` varchar(255) character set utf8 collate utf8_bin default NULL,
  `PRIXUNITARTICLE` double default NULL,
  `QTESTOCK` int(11) default NULL,
  `SERIALPROPRIETES` longblob,
  `SHORTDESCARTICLE` varchar(255) character set utf8 collate utf8_bin default NULL,
  `TVA` varchar(255) character set utf8 collate utf8_bin default NULL,
  `URLIMAGE` varchar(255) character set utf8 collate utf8_bin default NULL,
  `idCategorie` bigint(20) default NULL,
  `idPlageDePrix` bigint(20) default NULL,
  PRIMARY KEY  (`IDARTICLE`),
  KEY `FK_ARTICLE_idPlageDePrix` (`idPlageDePrix`),
  KEY `FK_ARTICLE_idCategorie` (`idCategorie`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `article`
--

INSERT INTO `article` (`IDARTICLE`, `LONGDESCARTICLE`, `NOMARTICLE`, `PRIXUNITARTICLE`, `QTESTOCK`, `SERIALPROPRIETES`, `SHORTDESCARTICLE`, `TVA`, `URLIMAGE`, `idCategorie`, `idPlageDePrix`) VALUES
(351, 'L''histoire de Noé', 'Noé', 11.5, 4, 0xaced0005737200116a6176612e7574696c2e486173684d61700507dac1c31660d103000246000a6c6f6164466163746f724900097468726573686f6c6478703f4000000000000c7708000000100000000274000c7265616c697361746575727374001044617272656e2041726f6e6f666b737974000574697472657400064e6fc383c2a978, 'Epopée', 'NORMAL', NULL, 1, NULL),
(355, 'Charles Bovary, officier de santé médiocre malgré de laborieuses études, épouse en secondes noces Emma Rouault, la fille d''un gros fermier des environs de Tostes', 'Madame Bovary', 2.75, 10, 0xaced0005737200116a6176612e7574696c2e486173684d61700507dac1c31660d103000246000a6c6f6164466163746f724900097468726573686f6c6478703f4000000000000c770800000010000000027400064175746575727400104775737461766520466c61756265727474000547656e7265740005526f6d616e78, 'Roman de Gustave Flaubert', 'NORMAL', NULL, 2, NULL),
(356, 'Tris vit dans un monde post-apocalyptique où la société est divisée en cinq factions. À 16 ans elle doit choisir sa nouvelle appartenance pour le reste de sa vie. Cas rarissime, son test d''aptitudes n''est pas concluant. Elle est divergente. Ce secret peut la sauver... ou la tuer.', 'Divergente - Tome 1', 16.45, 15, 0xaced0005737200116a6176612e7574696c2e486173684d61700507dac1c31660d103000246000a6c6f6164466163746f724900097468726573686f6c6478703f4000000000000c7708000000100000000274000641757465757274000d5665726f6e69636120526f746874000547656e726574000f536369656e63652066696374696f6e78, 'Livre science fiction', 'NORMAL', NULL, 2, NULL),
(702, 'Film', 'Le Grand Bleu', 12, 1, 0xaced0005737200116a6176612e7574696c2e486173684d61700507dac1c31660d103000246000a6c6f6164466163746f724900097468726573686f6c6478703f4000000000000c7708000000100000000274000c7265616c697361746575727374000a4c756320426573736f6e740005746974726574000d4c65204772616e6420426c657578, 'Drame', 'NORMAL', NULL, NULL, NULL),
(1801, 'Avec Léon, Besson suit la démarche inverse de son précédent film, Nikita ; alors qu''il n''a pas hésité à injecter dans son dernier film européen des séquences d''action hollywoodiennes, il teinte ici son premier film américain d''une fable urbaine néoréaliste. Jean Réno incarne Léon, tueur à gages froid et méthodique, dont la paisible existence va être chamboulée par l''intrusion dans sa vie de Mathilda, jeune orpheline de 12 ans, interprétée par la débutante Nathalie Portman. Besson se régale à mettre en scène la relation entre les deux individus, et s''amuse à ne pas dévoiler complètement son mystère', 'Léon', 15.17, 10, 0xaced0005737200116a6176612e7574696c2e486173684d61700507dac1c31660d103000246000a6c6f6164466163746f724900097468726573686f6c6478703f4000000000000c77080000001000000002740007416374657572737400424a65616e2052656e6f2c2047617279204f6c646d616e2c204e6174616c696520506f72746d616e2c2044616e6e79204169656c6c6f2c20506574657220417070656c74000d52c3a9616c697361746575727374000a4c756320426573736f6e78, 'Film policier', 'NORMAL', NULL, 1, NULL),
(1851, 'Le narrateur mène une vie tranquille dans sa maison au bord de la Seine, en Normandie, lorsque d''étranges phénomènes commencent à se produire. C''est la carafe d''eau sur sa table de nuit qui est bue, des objets qui disparaissent ou se brisent, une fleur cueillie par une main invisible... Peu à peu, le narrateur acquiert la certitude qu''un être surnaturel et immatériel vit chez lui, se nourrit de ses provisions.', 'Le Horla', 12.22, 10, 0xaced0005737200116a6176612e7574696c2e486173684d61700507dac1c31660d103000246000a6c6f6164466163746f724900097468726573686f6c6478703f4000000000000c77080000001000000002740006417574657572740011477579206465204d617570617373616e7474000547656e726574000b46616e746173746971756578, 'Fantastique', 'NORMAL', NULL, 2, NULL),
(1901, 'Anna, une jeune fille aussi audacieuse qu''optimiste, se lance dans un incroyable voyage en compagnie de Kristoff, un montagnard expérimenté, et de son fidèle renne, Sven à la recherche de sa soeur, Elsa, la Reine des Neiges qui a plongé le royaume d''Arendelle dans un hiver éternel... En chemin, ils vont rencontrer de mystérieux trolls et un drôle de bonhomme de neige nommé Olaf, braver les conditions extrêmes des sommets escarpés et glacés, et affronter la magie qui les guette à chaque pas.', 'La Reine des Neiges', 14.99, 10, 0xaced0005737200116a6176612e7574696c2e486173684d61700507dac1c31660d103000246000a6c6f6164466163746f724900097468726573686f6c6478703f4000000000000c770800000010000000027400074163746575727374000c4b72697374656e2042656c6c74000d52c3a9616c697361746575727374000c4a656e6e69666572204c656578, 'Anna, une jeune fille aussi audacieuse qu''optimiste, se lance dans un incroyable voyage en compagnie de Kristoff.', 'NORMAL', NULL, 1, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE IF NOT EXISTS `categorie` (
  `IDCATEGORIE` bigint(20) NOT NULL,
  `DESCRIPTIONCATEGORIE` varchar(255) character set utf8 collate utf8_bin default NULL,
  `NOMCATEGORIE` varchar(255) character set utf8 collate utf8_bin default NULL,
  PRIMARY KEY  (`IDCATEGORIE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `categorie`
--

INSERT INTO `categorie` (`IDCATEGORIE`, `DESCRIPTIONCATEGORIE`, `NOMCATEGORIE`) VALUES
(1, 'DVD', 'DVD'),
(2, 'Livres', 'Livres'),
(3, 'Autres', 'Autre');

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE IF NOT EXISTS `client` (
  `idClient` bigint(20) NOT NULL,
  `LOGIN` varchar(255) character set utf8 collate utf8_bin default NULL,
  `MDP` varchar(255) character set utf8 collate utf8_bin default NULL,
  `NEWSLETTER` int(11) default NULL,
  `NOM` varchar(255) character set utf8 collate utf8_bin default NULL,
  `PRENOM` varchar(255) character set utf8 collate utf8_bin default NULL,
  `ADRESSEFACTURATION_IDADRESSE` bigint(20) default NULL,
  `ADRESSELIVRAISON_IDADRESSE` bigint(20) default NULL,
  PRIMARY KEY  (`idClient`),
  KEY `FK_CLIENT_ADRESSEFACTURATION_IDADRESSE` (`ADRESSEFACTURATION_IDADRESSE`),
  KEY `FK_CLIENT_ADRESSELIVRAISON_IDADRESSE` (`ADRESSELIVRAISON_IDADRESSE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `client`
--

INSERT INTO `client` (`idClient`, `LOGIN`, `MDP`, `NEWSLETTER`, `NOM`, `PRENOM`, `ADRESSEFACTURATION_IDADRESSE`, `ADRESSELIVRAISON_IDADRESSE`) VALUES
(5, 'wiem.marzouk@gmail.com', 'mdp', 1, 'marzouk', 'wiem', 6, 6);

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE IF NOT EXISTS `commande` (
  `IDCOMMANDE` bigint(20) NOT NULL,
  `DATECOMMANDE` date default NULL,
  `idClient` bigint(20) default NULL,
  `COMMENTAIRE` varchar(255) default NULL,
  `TOTALTTC` double default NULL,
  `TYPEPAIEMENT` varchar(255) default NULL,
  PRIMARY KEY  (`IDCOMMANDE`),
  KEY `FK_COMMANDE_idClient` (`idClient`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `commande`
--

INSERT INTO `commande` (`IDCOMMANDE`, `DATECOMMANDE`, `idClient`, `COMMENTAIRE`, `TOTALTTC`, `TYPEPAIEMENT`) VALUES
(105, '2014-06-27', 5, '', 14.4, 'option1');

-- --------------------------------------------------------

--
-- Structure de la table `facture`
--

CREATE TABLE IF NOT EXISTS `facture` (
  `IDFACTURE` bigint(20) NOT NULL,
  `DATEFACTURE` date default NULL,
  `TOTALHT` double default NULL,
  `TOTALTTC` double default NULL,
  `TOTALTVA` double default NULL,
  `idClient` bigint(20) default NULL,
  `idCommande` bigint(20) default NULL,
  PRIMARY KEY  (`IDFACTURE`),
  KEY `FK_FACTURE_idCommande` (`idCommande`),
  KEY `FK_FACTURE_idClient` (`idClient`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `lignecommande`
--

CREATE TABLE IF NOT EXISTS `lignecommande` (
  `IDLIGNECOMMANDE` bigint(20) NOT NULL,
  `QTECOMMANDEE` int(11) default NULL,
  `idArticle` bigint(20) default NULL,
  `idCommande` bigint(20) default NULL,
  `COMMANDE_IDCOMMANDE` bigint(20) default NULL,
  PRIMARY KEY  (`IDLIGNECOMMANDE`),
  KEY `FK_LIGNECOMMANDE_idCommande` (`idCommande`),
  KEY `FK_LIGNECOMMANDE_idArticle` (`idArticle`),
  KEY `FK_LIGNECOMMANDE_COMMANDE_IDCOMMANDE` (`COMMANDE_IDCOMMANDE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `lignecommande`
--

INSERT INTO `lignecommande` (`IDLIGNECOMMANDE`, `QTECOMMANDEE`, `idArticle`, `idCommande`, `COMMANDE_IDCOMMANDE`) VALUES
(106, 1, 702, NULL, 105);

-- --------------------------------------------------------

--
-- Structure de la table `lignepanier`
--

CREATE TABLE IF NOT EXISTS `lignepanier` (
  `IDLIGNEPANIER` bigint(20) NOT NULL,
  `QTECOMMANDE` int(11) default NULL,
  `idPanier` bigint(20) default NULL,
  `idArticle` bigint(20) default NULL,
  `PANIER_IDPANIER` bigint(20) default NULL,
  PRIMARY KEY  (`IDLIGNEPANIER`),
  KEY `FK_LIGNEPANIER_idArticle` (`idArticle`),
  KEY `FK_LIGNEPANIER_idPanier` (`idPanier`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `panier`
--

CREATE TABLE IF NOT EXISTS `panier` (
  `IDPANIER` bigint(20) NOT NULL,
  `DATEPANIER` date default NULL,
  `idClient` bigint(20) default NULL,
  PRIMARY KEY  (`IDPANIER`),
  KEY `FK_PANIER_idClient` (`idClient`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `panier_lignepanier`
--

CREATE TABLE IF NOT EXISTS `panier_lignepanier` (
  `Panier_IDPANIER` bigint(20) NOT NULL,
  `lignesPanier_IDLIGNEPANIER` bigint(20) NOT NULL,
  PRIMARY KEY  (`Panier_IDPANIER`,`lignesPanier_IDLIGNEPANIER`),
  KEY `FK_PANIER_LIGNEPANIER_lignesPanier_IDLIGNEPANIER` (`lignesPanier_IDLIGNEPANIER`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `plagedeprix`
--

CREATE TABLE IF NOT EXISTS `plagedeprix` (
  `IDPLAGEDEPRIX` bigint(20) NOT NULL,
  `PRIXMAX` double default NULL,
  `PRIXMIN` double default NULL,
  PRIMARY KEY  (`IDPLAGEDEPRIX`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `sequence`
--

CREATE TABLE IF NOT EXISTS `sequence` (
  `SEQ_NAME` varchar(50) character set utf8 collate utf8_bin NOT NULL,
  `SEQ_COUNT` decimal(38,0) default NULL,
  PRIMARY KEY  (`SEQ_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `sequence`
--

INSERT INTO `sequence` (`SEQ_NAME`, `SEQ_COUNT`) VALUES
('SEQ_GEN', '404');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `article`
--
ALTER TABLE `article`
  ADD CONSTRAINT `FK_ARTICLE_idCategorie` FOREIGN KEY (`idCategorie`) REFERENCES `categorie` (`IDCATEGORIE`),
  ADD CONSTRAINT `FK_ARTICLE_idPlageDePrix` FOREIGN KEY (`idPlageDePrix`) REFERENCES `plagedeprix` (`IDPLAGEDEPRIX`);

--
-- Contraintes pour la table `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `FK_CLIENT_ADRESSEFACTURATION_IDADRESSE` FOREIGN KEY (`ADRESSEFACTURATION_IDADRESSE`) REFERENCES `adresse` (`IDADRESSE`),
  ADD CONSTRAINT `FK_CLIENT_ADRESSELIVRAISON_IDADRESSE` FOREIGN KEY (`ADRESSELIVRAISON_IDADRESSE`) REFERENCES `adresse` (`IDADRESSE`);

--
-- Contraintes pour la table `commande`
--
ALTER TABLE `commande`
  ADD CONSTRAINT `FK_COMMANDE_idClient` FOREIGN KEY (`idClient`) REFERENCES `client` (`idClient`);

--
-- Contraintes pour la table `facture`
--
ALTER TABLE `facture`
  ADD CONSTRAINT `FK_FACTURE_idClient` FOREIGN KEY (`idClient`) REFERENCES `client` (`idClient`),
  ADD CONSTRAINT `FK_FACTURE_idCommande` FOREIGN KEY (`idCommande`) REFERENCES `commande` (`IDCOMMANDE`);

--
-- Contraintes pour la table `lignecommande`
--
ALTER TABLE `lignecommande`
  ADD CONSTRAINT `FK_LIGNECOMMANDE_COMMANDE_IDCOMMANDE` FOREIGN KEY (`COMMANDE_IDCOMMANDE`) REFERENCES `commande` (`IDCOMMANDE`),
  ADD CONSTRAINT `FK_LIGNECOMMANDE_idArticle` FOREIGN KEY (`idArticle`) REFERENCES `article` (`IDARTICLE`),
  ADD CONSTRAINT `FK_LIGNECOMMANDE_idCommande` FOREIGN KEY (`idCommande`) REFERENCES `commande` (`IDCOMMANDE`);

--
-- Contraintes pour la table `lignepanier`
--
ALTER TABLE `lignepanier`
  ADD CONSTRAINT `FK_LIGNEPANIER_idArticle` FOREIGN KEY (`idArticle`) REFERENCES `article` (`IDARTICLE`),
  ADD CONSTRAINT `FK_LIGNEPANIER_idPanier` FOREIGN KEY (`idPanier`) REFERENCES `panier` (`IDPANIER`);

--
-- Contraintes pour la table `panier`
--
ALTER TABLE `panier`
  ADD CONSTRAINT `FK_PANIER_idClient` FOREIGN KEY (`idClient`) REFERENCES `client` (`idClient`);

--
-- Contraintes pour la table `panier_lignepanier`
--
ALTER TABLE `panier_lignepanier`
  ADD CONSTRAINT `FK_PANIER_LIGNEPANIER_lignesPanier_IDLIGNEPANIER` FOREIGN KEY (`lignesPanier_IDLIGNEPANIER`) REFERENCES `lignepanier` (`IDLIGNEPANIER`),
  ADD CONSTRAINT `FK_PANIER_LIGNEPANIER_Panier_IDPANIER` FOREIGN KEY (`Panier_IDPANIER`) REFERENCES `panier` (`IDPANIER`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
