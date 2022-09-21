-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:3306
-- Généré le : jeu. 30 juin 2022 à 11:02
-- Version du serveur :  5.7.33
-- Version de PHP : 7.4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `db_dcorp`
--

-- --------------------------------------------------------

--
-- Structure de la table `caisse`
--

CREATE TABLE `caisse` (
  `codeCaisse` int(11) NOT NULL,
  `MontantPaye` float DEFAULT NULL,
  `datePayement` date DEFAULT NULL,
  `codeEtudiant` int(11) DEFAULT NULL,
  `codeFormation` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `dette`
--

CREATE TABLE `dette` (
  `codeDette` int(11) NOT NULL,
  `nom` varchar(50) DEFAULT NULL,
  `montant` float DEFAULT NULL,
  `datePayement` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `dette`
--

INSERT INTO `dette` (`codeDette`, `nom`, `montant`, `datePayement`) VALUES
(1, 'f', 88676, '2022-06-05');

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

CREATE TABLE `etudiant` (
  `codeEtudiant` int(11) NOT NULL,
  `nom` varchar(50) DEFAULT NULL,
  `contact` varchar(50) DEFAULT NULL,
  `adresse` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `etudiant`
--

INSERT INTO `etudiant` (`codeEtudiant`, `nom`, `contact`, `adresse`) VALUES
(1, 'Bethel', '0995010362', 'Mabanga');

-- --------------------------------------------------------

--
-- Structure de la table `formation`
--

CREATE TABLE `formation` (
  `codeFormation` int(11) NOT NULL,
  `nomFormation` varchar(50) DEFAULT NULL,
  `statut` varchar(50) DEFAULT NULL,
  `montantformation` float DEFAULT NULL,
  `codeEtudiant` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `formation`
--

INSERT INTO `formation` (`codeFormation`, `nomFormation`, `statut`, `montantformation`, `codeEtudiant`) VALUES
(1, 'Html', 'Maitre dylan', 37485, 1);

-- --------------------------------------------------------

--
-- Structure de la table `partenaire`
--

CREATE TABLE `partenaire` (
  `codePartenaire` int(11) NOT NULL,
  `nom` varchar(50) DEFAULT NULL,
  `contact` varchar(50) DEFAULT NULL,
  `mail` varchar(50) DEFAULT NULL,
  `adresse` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `personnel`
--

CREATE TABLE `personnel` (
  `codePersonnel` int(11) NOT NULL,
  `nom` varchar(50) DEFAULT NULL,
  `contact` varchar(50) DEFAULT NULL,
  `mail` varchar(50) DEFAULT NULL,
  `adresse` varchar(50) DEFAULT NULL,
  `statut` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `projet`
--

CREATE TABLE `projet` (
  `codeProjet` int(11) NOT NULL,
  `nomProjet` varchar(50) DEFAULT NULL,
  `Descriptions` varchar(100) DEFAULT NULL,
  `statut` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `projet`
--

INSERT INTO `projet` (`codeProjet`, `nomProjet`, `Descriptions`, `statut`) VALUES
(1, 'Vol des voitures', 'Tu vole, on te paie', 'Maitre dylan'),
(2, 'fsnskjfk', 'davowdvl', 'blablal');

-- --------------------------------------------------------

--
-- Doublure de structure pour la vue `show_caisse_one`
-- (Voir ci-dessous la vue réelle)
--
CREATE TABLE `show_caisse_one` (
`codeCaisse` int(11)
,`MontantPaye` float
,`datePayement` date
,`CodeFormation` int(11)
,`nomFormation` varchar(50)
,`adresse` varchar(50)
,`montantformation` float
,`codeEtudiant` int(11)
,`nom` varchar(50)
);

-- --------------------------------------------------------

--
-- Doublure de structure pour la vue `show_formation`
-- (Voir ci-dessous la vue réelle)
--
CREATE TABLE `show_formation` (
`codeEtudiant` int(11)
,`nom` varchar(50)
,`contact` varchar(50)
,`adresse` varchar(50)
,`nomFormation` varchar(50)
,`statut` varchar(50)
,`montantformation` float
,`codeFormation` int(11)
);

-- --------------------------------------------------------

--
-- Structure de la table `t_login`
--

CREATE TABLE `t_login` (
  `id` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `t_login`
--

INSERT INTO `t_login` (`id`, `username`, `password`) VALUES
(1, 'admin', 'dcorp');

-- --------------------------------------------------------

--
-- Structure de la vue `show_caisse_one`
--
DROP TABLE IF EXISTS `show_caisse_one`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `show_caisse_one`  AS  select `caisse`.`codeCaisse` AS `codeCaisse`,`caisse`.`MontantPaye` AS `MontantPaye`,`caisse`.`datePayement` AS `datePayement`,`caisse`.`codeFormation` AS `CodeFormation`,`show_formation`.`nomFormation` AS `nomFormation`,`show_formation`.`adresse` AS `adresse`,`show_formation`.`montantformation` AS `montantformation`,`show_formation`.`codeEtudiant` AS `codeEtudiant`,`show_formation`.`nom` AS `nom` from (`caisse` join `show_formation` on((`caisse`.`codeFormation` = `show_formation`.`codeFormation`))) ;

-- --------------------------------------------------------

--
-- Structure de la vue `show_formation`
--
DROP TABLE IF EXISTS `show_formation`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `show_formation`  AS  select `etudiant`.`codeEtudiant` AS `codeEtudiant`,`etudiant`.`nom` AS `nom`,`etudiant`.`contact` AS `contact`,`etudiant`.`adresse` AS `adresse`,`formation`.`nomFormation` AS `nomFormation`,`formation`.`statut` AS `statut`,`formation`.`montantformation` AS `montantformation`,`formation`.`codeFormation` AS `codeFormation` from (`etudiant` join `formation` on((`etudiant`.`codeEtudiant` = `formation`.`codeEtudiant`))) ;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `caisse`
--
ALTER TABLE `caisse`
  ADD PRIMARY KEY (`codeCaisse`),
  ADD KEY `fk_refEtudiant` (`codeEtudiant`),
  ADD KEY `fk_refFormation` (`codeFormation`);

--
-- Index pour la table `dette`
--
ALTER TABLE `dette`
  ADD PRIMARY KEY (`codeDette`);

--
-- Index pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD PRIMARY KEY (`codeEtudiant`),
  ADD UNIQUE KEY `un_nomEtudiant` (`nom`);

--
-- Index pour la table `formation`
--
ALTER TABLE `formation`
  ADD PRIMARY KEY (`codeFormation`),
  ADD KEY `fk_etudiant` (`codeEtudiant`);

--
-- Index pour la table `partenaire`
--
ALTER TABLE `partenaire`
  ADD PRIMARY KEY (`codePartenaire`);

--
-- Index pour la table `personnel`
--
ALTER TABLE `personnel`
  ADD PRIMARY KEY (`codePersonnel`),
  ADD UNIQUE KEY `un_nomPersonnel` (`nom`);

--
-- Index pour la table `projet`
--
ALTER TABLE `projet`
  ADD PRIMARY KEY (`codeProjet`);

--
-- Index pour la table `t_login`
--
ALTER TABLE `t_login`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `caisse`
--
ALTER TABLE `caisse`
  MODIFY `codeCaisse` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `dette`
--
ALTER TABLE `dette`
  MODIFY `codeDette` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `etudiant`
--
ALTER TABLE `etudiant`
  MODIFY `codeEtudiant` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `formation`
--
ALTER TABLE `formation`
  MODIFY `codeFormation` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `partenaire`
--
ALTER TABLE `partenaire`
  MODIFY `codePartenaire` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `personnel`
--
ALTER TABLE `personnel`
  MODIFY `codePersonnel` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `projet`
--
ALTER TABLE `projet`
  MODIFY `codeProjet` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `t_login`
--
ALTER TABLE `t_login`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `caisse`
--
ALTER TABLE `caisse`
  ADD CONSTRAINT `fk_refEtudiant` FOREIGN KEY (`codeEtudiant`) REFERENCES `etudiant` (`codeEtudiant`),
  ADD CONSTRAINT `fk_refFormation` FOREIGN KEY (`codeFormation`) REFERENCES `formation` (`codeFormation`);

--
-- Contraintes pour la table `formation`
--
ALTER TABLE `formation`
  ADD CONSTRAINT `fk_etudiant` FOREIGN KEY (`codeEtudiant`) REFERENCES `etudiant` (`codeEtudiant`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
