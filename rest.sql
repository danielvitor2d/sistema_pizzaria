-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: 26-Nov-2018 às 12:53
-- Versão do servidor: 10.1.36-MariaDB
-- versão do PHP: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `rest`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `clientes`
--

CREATE TABLE `clientes` (
  `id` int(10) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `apelido` varchar(70) NOT NULL,
  `rua` varchar(30) NOT NULL,
  `numero` varchar(50) NOT NULL,
  `complemento` varchar(100) NOT NULL,
  `cidade` varchar(70) NOT NULL,
  `bairro` varchar(70) NOT NULL,
  `numerot` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `clientes`
--

INSERT INTO `clientes` (`id`, `nome`, `apelido`, `rua`, `numero`, `complemento`, `cidade`, `bairro`, `numerot`) VALUES
(1, 'Daniel Vitor Pereira Rodrigues', 'Daniel', 'Rua Doutor Tibúrcio Soares', '444', 'Vizinho ao Renir', 'Acopis', 'Centro', '5585997355182'),
(2, 'Lucas Rangel Santos Lima', 'Rangel', 'Rua Paulino Félix', '447', 'Rua de baixo', 'Acopiara', 'Moreiras', '854785698521'),
(3, 'Samantha Leandro', 'Samantha', 'Avenida Paulino Félix', '290', 'Apartamento', 'Acopiara', 'Centro', '999024811'),
(4, 'Mário Professor', 'Super Mário', 'Rua Januário Pereira', '81', 'Em frente a casa do Dra. Tereza', 'Acopiara', 'Centro', '998087687'),
(5, 'Mikaele Professora', 'Mikaele', 'Travessa Ivan Gurgel', '54', '', 'Acopiara', 'Centro', '999693463'),
(6, 'Auzenor', '0', '0', '0', '0', 'Acopiara', '0', '997550636'),
(7, 'Gabi', '0', '0', '0', '0', 'Acopiara', '0', '981463283'),
(8, 'Leonardo', 'Nardo', 'Rua Manoel Ferreira de Andrade', '0', 'ao lado de casa do Jocélio', 'Acopiara', 'Moreiras', '997243709'),
(9, 'Jane Kelly', '0', '0', '0', '0', 'Acopiara', '0', '993308722'),
(10, 'Mariane', 'Mariane', 'Cazuzinha Marquês', '16', '0', 'Acopiara', 'Centro', '999840276'),
(11, 'Verônica Reis', 'Verônica', '0', '0', '0', 'Acopiara', 'Centro', '999263441'),
(12, 'Glorinha', 'Glorinha', '0', '0', '0', 'Acopiara', '0', '0'),
(13, 'Maíra', 'Maíra', 'Rua José Paulino', '25', '0', 'Acopiara', 'Centro', '0'),
(14, 'Roberta', 'Roberta', '0', '0', '0', 'Acopiara', 'Moreiras', '998151764'),
(15, 'Gil', 'Gil', '0', '0', '0', 'Acopiara', 'nova Acopiara', '0'),
(16, 'Acelina', 'Acelina', '0', '0', '0', 'Acopiara', 'Centro', '999846530'),
(17, 'Bruno', 'Bruno', '0', '0', '0', 'Acopiara', '0', '999957655'),
(18, 'Joabe Gilearde', 'Joabe professor', '0', '0', '0', 'Acopiara', '0', '997223650'),
(19, 'Andrelina', 'Andrelina', 'Rua Ernesto Pereira', '33', '0', 'Acopiara', 'Nova Acopiara', '999617550'),
(20, 'Leidiane', 'Leidiane', '0', '0', '0', 'Acopiara', '0', '997426467'),
(21, 'Marcelo Sousa', 'Marcelo', 'Avenida Pedro Alves', '798', 'vizinho a casa do Ediglê', 'Acopiara', 'Centro', '996533256'),
(22, 'Pedro', 'Pedro', '0', '0', 'casa da dona Fransquinha', 'Acopiara', 'Aroeira', '996364428'),
(23, 'Ivone', 'Ivone do Júnior das rifas', '0', '0', 'próximo ao Instituto Coelhinho', 'Acopiara', 'Vila Palmeira', '0'),
(24, '0', '0', 'Rua Marechal Deodoro', '547', 'casa do Alexandre, apartamento', 'Acopiara', 'Centro', '999325740'),
(25, 'Angélica', 'Angélica', '0', '0', '0', 'Acopiara', 'Ramira', '999478043'),
(26, 'Carlos Henrique', 'Carlos Henrique', '0', '0', '0', 'Acopiara', '0', '997884536'),
(27, 'Sabrina', 'Sabrina', '0', '0', '0', 'Acopiara', '0', '981222588'),
(28, 'Felícia', 'Felícia', '0', '0', 'próximo ao arco da santa', 'Acopiara', '0', '996359417'),
(29, 'Yamusa', 'Yamusa', 'Rua Monoel Jossé', '0', '0', 'Acopiara', 'Centro', '999470081'),
(30, 'Thaiane', 'filha da Jaiane', 'Avenida Cazuzinha Marques', '0', 'vizinha à Nordenha fardamento', 'Acopiara', 'Centro', '996340775'),
(31, 'Dalva', 'Dalva', '0', '0', '0', 'Acopiara', 'Nova Acopiara', '997042695'),
(32, 'Marla Yanne', 'Marla', 'Rua Luís Gonzaga de Mendonça', '571', 'em frente a casa do Cícero Andrade', 'Acopiara', 'Centro', '996172990'),
(33, 'João Vitor', 'João Vitor', '0', '0', '0', 'Acopiara', 'Nova Acopiara', '997091982'),
(34, 'Tatiana', 'Tatiana', '0', '0', 'por traz da cagece', 'Acopiara', '0', '998052541'),
(35, 'Andréia', 'Andréia', '0', '0', '0', 'Acopiara', 'Nova Acopiara', '999331729'),
(36, 'Kivya', 'Kivya', '0', '0', '0', 'Acopiara', '0', '997489127'),
(37, 'Netinha', 'Netinha do Diniz', '0', '0', 'vizinha à Joana Angélica', 'Acopiara', 'Acopiara', '999705879'),
(38, 'Marília', 'Marília', 'Rua Francisco Alves Martins', '445', 'por trás da chácara do Chico Mel', 'Acopiara', 'Nova Acopiara', '997355214'),
(39, 'Sonja', 'Sonja', '0', '0', 'depois da casa do Carlúcio', 'Acopiara ', '0', '0'),
(40, 'Giovana Alves', 'Giovana', '0', '985', 'depois do quebra mola', 'Acopiara', 'Nova Acopiara', '997819754'),
(41, 'Almirton', 'Almirton', '0', '0', '0', '0', '0', '0'),
(42, 'Pablo', 'Pablo', '0', '0', 'em cima da padaria', 'Acopiara', 'Vila Esperança', '0'),
(43, 'Keke', 'Keke', '0', '0', '0', 'Acopiara', '0', '996699684'),
(44, 'Teixeira', 'Teixeira', '0', '0', '0', 'Acopiara', '0', '999146084'),
(45, 'Francivaldo', 'Francivaldo', '0', '0', '0', 'Acopiara', '0', '999036835'),
(46, 'Lucas Estevão', 'Estevão', 'Avenida edro Alves', '0', 'em frente a Francina, loja da sky', 'Acopiara', 'Centro', '996989982'),
(47, 'Antonia', 'Antonia', 'Avenida Lima Diniz', '0', 'supermercado Diniz', 'Acopiara', 'Nova Acopiara', '996611574'),
(48, 'Garlena', 'Eduardo Seguros', 'Rua José Pereira', '256', '0', 'Acopiara', '0', '997988158'),
(49, 'Ruan', 'Ruan', '0', '0', 'farmácia Menino Deus', 'Acopiara', 'Centro', '0'),
(50, 'Danilo', 'Danilo', '0', '0', '0', 'Acopiara', 'Vila Aroeira', '996042225'),
(51, 'Nieuda', 'Nieuda', 'Rua José Macêdo', '93', 'em cima da padaria Sousa Braga', 'Acopiara', 'Vila Palmeira', '997136834'),
(52, 'Esaú', 'Esaú', '0', '0', 'em frente a presbiteriana', 'Acopiara', '0', '999828988'),
(53, 'Josean', 'Josean', '0', '0', 'próximo ao aroeiras club', 'Acopiara', 'Vila Aroeira', '996929063'),
(54, 'Sidney', 'Nenca costureira', '0', '0', '0', 'Acopiara', '0', '0'),
(55, 'Naeli', '0', '0', '0', '0', '0', '0', '0'),
(56, 'Irany', 'Irany', 'Travessa João Pereira', '16', 'segunda rua depois do Instituto à direita', 'Acopiara', 'Vila Palmeira', '996488494'),
(57, 'Emídio', 'Emídio', '0', '0', 'rua do fórum, em frente ao salão da Marina', 'Acopiara', '0', '999958899'),
(58, 'Expedito', '0', '0', '0', '0', '0', '0', '0'),
(59, 'Luana', 'Luana', '0', '0', 'casa Luís da Eliane', 'Acopiara', '0', '0'),
(60, 'Vanessa', 'Vanessa', '0', '0', '0', '0', '0', '0'),
(61, 'Daniel', '0', '0', '0', 'perto da casa do Josa', 'Acopiara', 'Centro', '0'),
(62, 'Cacilda', 'Cacilda', 'Rua Cazuzinha Marques', '0', 'ao lado da pague menos', 'Acopiara', 'Centro', '996965199'),
(63, 'Diogo', 'Diogo', 'Luís Gonzaga de Mendonça', '1071', '0', 'Acopiara', '0', '0'),
(64, 'Almeida', 'Almeida', '0', '0', '0', 'Acopiara', '0', '0'),
(65, 'Magislene', 'esposa do Roni', 'Rua Tancredo Neves', '659', 'em frente a cerâmica Rufino', 'Acopiara', '0', '999044609'),
(66, 'Andresa', 'Andresa', '0', '0', '0', 'Acopiara', '0', '0'),
(67, 'Vanderlan', 'Vanderlan', 'Avenida Lima Diniz', '0', 'em frente a casa do Assis Coura, casa da esquina.', 'Acopiara', 'Nova Acopiara', '999847647'),
(68, 'Amabile', 'Amabile', 'Rua Coronel Manoel José', '0', 'em frente a casa do Josa', 'Acopiara', '0', '996754743'),
(69, 'Vaninha', 'Vaninha', 'Rua Coronel José Nunes', '0', '0', 'Acopiara', '0', '997544407'),
(70, 'Leda', 'espoda do Popó', 'Avenida Paulino Félix', '0', '0', 'Acopiara', 'Centro', '0'),
(71, 'Henrique', 'Henrique', '0', '161', 'depois do Cabana à direita', 'Acopiara', 'Nova Acopiara', '996081851'),
(72, 'Eduardo', 'Eduardo', '0', '0', '0', 'Acopiara', 'Nova Acopiara', '0'),
(73, 'Raíssa', 'Raíssa', '0', '128', 'primeira à direita depois do cabana', 'Acopiara', 'Nova Acopiara', '997258587'),
(74, 'Ítalo', 'Filho da Mazé', 'Avenida Lima Diniz', '0', '0', 'Acopiara', 'Centro', '997695972'),
(75, 'Karina', '0', '0', '0', 'Perto da Dr. Ana Patrícia', 'Acopiara', 'Nova Acopiara', '996894230'),
(76, 'Helisandra ', 'Professor', '0', '0', '0', 'Acopiara', 'vila Palmeira', '999124279'),
(77, 'Ismael', '0', 'Joaquim Ferreira de Almeida', '134 ', 'A', 'Acopiara', 'Nova Acopiara', '996372852'),
(78, 'Jahir paulinho', '0', 'Av Paulinho Felix', '0', '0', 'Acopiara', 'Centro', '988213021'),
(79, 'Tainara', '0', 'Av Francisco Alves', '704', '0', 'Acopiara', 'Moreiras', '997691661'),
(80, 'Olegário', '0', '0', '0', '0', 'Acopiara', 'Centro', '999958899'),
(81, 'Yasmin', '0', 'Mutirão3', '0', '0', 'Acopiara', 'Vila Esperança', '99920760'),
(82, 'Sheila', '0', 'Av Lima Diniz', '0', '0', 'Acopiara', 'Nova Acopiara', '0'),
(83, 'Valeska', '0', 'Emídio Alves', '676', '0', 'Acopiara', '0', '996287726'),
(84, 'Solange', '0', '0', '0', '0', 'Acopiara', '0', '998668743'),
(85, 'Leandro Rodrigues', '0', 'Manoel José', '121', '0', 'Acopiara', 'Centro', '999629493'),
(86, 'Taís', '0', '0', '0', '0', 'Acopiara', '0', '97886198'),
(87, '2º Enfermagem', '', 'Alfredo nunes', '0', '0', 'Acopiara', 'Centro', '0'),
(88, 'Edigleuda', '0', 'Emídio de Lima Pinho', '0', '0', 'Acopiara', 'São Francisco', '96982250'),
(89, 'Regis', '0', '0', '0', '0', 'Acopiara', '0', '999677940'),
(90, 'Patrícia', '0', 'Nogueira Neves', '105', '0', 'Acopiara', 'São Francisco', '999483233'),
(91, 'Iris', '0', 'Pedro Alves', '718', '0', 'Acopiara', 'Centro', '996014556'),
(92, 'Luan', '0', 'Av Lima Diniz', '0', '0', 'Acopiara', 'Nova Acopiara', '0'),
(93, 'Elen', '0', 'Av Nova', '346', '0', 'Acopiara', 'Centro', '997855282'),
(94, 'Akelândia', '0', 'Francisco Alves Martins', '162', 'a', 'Acopiara', '0', '0'),
(95, 'Vinicius', '0', 'Av Lima Diniz', '', '0', 'Acopiara', 'Nova Acopiara', '99793049'),
(96, 'Veruska0', '0', 'Cazuzinha Marques', '0', '0', 'Acopiara', '0', '96216474');

-- --------------------------------------------------------

--
-- Estrutura da tabela `custo`
--

CREATE TABLE `custo` (
  `id` int(10) NOT NULL,
  `agua` double NOT NULL,
  `luz` double NOT NULL,
  `tel` double NOT NULL,
  `net` double NOT NULL,
  `gas` double NOT NULL,
  `ml` double NOT NULL,
  `piz` double NOT NULL,
  `aux` double NOT NULL,
  `cai` double NOT NULL,
  `ent` double NOT NULL,
  `divulg` double NOT NULL,
  `dia` varchar(10) NOT NULL,
  `mes` varchar(10) NOT NULL,
  `ano` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `custo`
--

INSERT INTO `custo` (`id`, `agua`, `luz`, `tel`, `net`, `gas`, `ml`, `piz`, `aux`, `cai`, `ent`, `divulg`, `dia`, `mes`, `ano`) VALUES
(4, 25, 60, 85, 35, 0, 50, 600, 200, 160, 150, 200, '30', '10', '2017');

-- --------------------------------------------------------

--
-- Estrutura da tabela `estoque`
--

CREATE TABLE `estoque` (
  `id` int(10) NOT NULL,
  `prod` varchar(30) DEFAULT NULL,
  `qtd` bigint(255) DEFAULT NULL,
  `preco` double DEFAULT NULL,
  `tipo` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `estoque`
--

INSERT INTO `estoque` (`id`, `prod`, `qtd`, `preco`, `tipo`) VALUES
(5, 'Calabresa', 850, 12.9, 'P'),
(6, 'Mussarela', 200, 15, 'P'),
(7, 'Cebola', 880, 3, 'P'),
(8, 'Presunto', 748, 12.3, 'P'),
(9, 'Bacon', 1084, 14.49, 'P'),
(10, 'Frango', 2850, 10, 'P'),
(11, 'Carne de sol', 1450, 17.6, 'P'),
(12, 'Ovo', 1, 0.7, 'Q'),
(13, 'Salsicha', 500, 8.5, 'P'),
(14, 'Tomate', 920, 2, 'P'),
(15, 'Massa', 2, 1.7, 'Q'),
(17, 'Vinho Branco', 0, 14.9, 'Q'),
(18, 'Tempero Completo', 0, 0, 'P'),
(19, 'Extrato de Tomate', 0, 2.5, 'Q'),
(20, 'Molho de Tomate', 3650, 5, 'P'),
(21, 'Milho Verde', 2360, 7, 'P'),
(22, 'Catupiry', 200, 20, 'P'),
(23, 'Atum', 1500, 25.8, 'P'),
(24, 'Lombo', 862, 18.9, 'P'),
(25, 'Embalagem', 78, 1.3, 'Q'),
(26, 'Gás', 13, 1, 'Q'),
(27, 'Azeitona', 1670, 6.7, 'P'),
(28, 'Guaraná', 12, 2.75, 'Q'),
(29, 'Coca', 4, 5.34, 'Q'),
(30, 'Cajuína', 4, 5.34, 'Q'),
(33, 'Batata Palha', 400, 25, 'P'),
(34, 'Acréscimo', 100, 1, 'Q');

-- --------------------------------------------------------

--
-- Estrutura da tabela `login`
--

CREATE TABLE `login` (
  `id` int(11) NOT NULL,
  `login` varchar(30) NOT NULL,
  `senha` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `login`
--

INSERT INTO `login` (`id`, `login`, `senha`) VALUES
(1, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Estrutura da tabela `produtos`
--

CREATE TABLE `produtos` (
  `id` int(10) NOT NULL,
  `np` varchar(30) NOT NULL,
  `prec` double NOT NULL,
  `prev` double NOT NULL,
  `pl` double NOT NULL,
  `aumento` double NOT NULL,
  `plr` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `produtos`
--

INSERT INTO `produtos` (`id`, `np`, `prec`, `prev`, `pl`, `aumento`, `plr`) VALUES
(2, 'Pizza de Calabresa', 11.48, 20, 42.6, 8.52, 0),
(4, 'Pizza de Bacon', 11, 20, 45, 9, 81.81818181818181),
(5, 'PIzza de Frango', 10.95, 20, 45.25000000000001, 9.05, 0),
(6, 'PIzza de Mussarela', 4, 18, 77.77777777777777, 14, 350),
(7, 'PIzza de Presunto', 10.945, 20, 45.275, 9.055, 0),
(8, 'Pizza Carne de Sol', 10.155000000000001, 20, 49.224999999999994, 9.844999999999999, 0),
(9, 'Pizza À Moda', 11.845500000000001, 20, 40.772499999999994, 8.154499999999999, 0),
(10, 'Pizza Portuguesa', 12.344999999999999, 20, 38.275000000000006, 7.655000000000001, 0),
(11, 'Borda', 4, 5, 20, 1, 25),
(12, 'Pizza de Lombo', 10.285, 22, 53.25, 11.715, 0),
(13, 'Pizza de Atum', 12.83, 22, 41.68181818181818, 9.17, 0),
(14, 'Pizza de Calabacon', 12.989, 22, 40.959090909090904, 9.011, 0),
(15, 'PIzza de Franbacon', 12.399, 22, 43.6409090909091, 9.601, 0),
(16, 'PIzza do Pizzaiolo', 12.695, 22, 42.29545454545455, 9.305, 0),
(17, 'PIzza Dois Queijos', 12.25, 22, 44.31818181818182, 9.75, 0),
(18, 'PIzza Jardineira', 10.46, 18, 41.888888888888886, 7.539999999999999, 0),
(19, 'Cajuína 2l', 5.34, 8, 33.25, 2.66, 0),
(20, 'Coca 2l', 5.34, 8, 33.25, 2.66, 0),
(21, 'Borda Vulcão 1', 5, 12, 58.333333333333336, 7, 0),
(22, 'Borda Vulcão 2', 5, 10, 50, 5, 0),
(23, 'Borda Vulcão 3', 5, 8, 37.5, 3, 0),
(24, 'PIzza Crocante', 11.375, 20, 43.125, 8.625, 0),
(25, 'Acréscimo', 1, 1.01, 0.990099009900991, 0.010000000000000009, 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `receitas`
--

CREATE TABLE `receitas` (
  `id` int(5) NOT NULL,
  `produto` varchar(25) NOT NULL,
  `qtdoupeso` double NOT NULL,
  `precofinal` int(150) NOT NULL,
  `receita` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `receitas`
--

INSERT INTO `receitas` (`id`, `produto`, `qtdoupeso`, `precofinal`, `receita`) VALUES
(220, 'Catupiry', 200, 4, 'Borda'),
(281, 'Mussarela', 250, 4, 'PIzza de Frango'),
(282, 'Frango', 250, 3, 'PIzza de Frango'),
(283, 'Tomate', 50, 0, 'PIzza de Frango'),
(284, 'Massa', 1, 2, 'PIzza de Frango'),
(285, 'Milho Verde', 50, 0, 'PIzza de Frango'),
(286, 'Embalagem', 1, 1, 'PIzza de Frango'),
(287, 'Gás', 1, 1, 'PIzza de Frango'),
(288, 'Molho de Tomate', 50, 0, 'PIzza de Frango'),
(289, 'Mussarela', 250, 4, 'Pizza Carne de Sol'),
(290, 'Carne de sol', 200, 4, 'Pizza Carne de Sol'),
(291, 'Molho de Tomate', 50, 0, 'Pizza Carne de Sol'),
(292, 'Embalagem', 1, 1, 'Pizza Carne de Sol'),
(293, 'Gás', 1, 1, 'Pizza Carne de Sol'),
(294, 'Azeitona', 50, 0, 'Pizza Carne de Sol'),
(302, 'Mussarela', 300, 5, 'Pizza de Bacon'),
(303, 'Bacon', 150, 2, 'Pizza de Bacon'),
(304, 'Massa', 1, 2, 'Pizza de Bacon'),
(305, 'Molho de Tomate', 50, 0, 'Pizza de Bacon'),
(306, 'Embalagem', 1, 1, 'Pizza de Bacon'),
(307, 'Azeitona', 50, 0, 'Pizza de Bacon'),
(308, 'Gás', 1, 1, 'Pizza de Bacon'),
(309, 'Gás', 1, 1, 'PIzza de Presunto'),
(310, 'Embalagem', 1, 1, 'PIzza de Presunto'),
(311, 'Milho Verde', 50, 0, 'PIzza de Presunto'),
(312, 'Molho de Tomate', 50, 0, 'PIzza de Presunto'),
(313, 'Massa', 1, 2, 'PIzza de Presunto'),
(314, 'Presunto', 150, 2, 'PIzza de Presunto'),
(315, 'Mussarela', 300, 5, 'PIzza de Presunto'),
(316, 'Mussarela', 250, 4, 'Pizza À Moda'),
(317, 'Calabresa', 50, 1, 'Pizza À Moda'),
(318, 'Cebola', 10, 0, 'Pizza À Moda'),
(319, 'Presunto', 50, 1, 'Pizza À Moda'),
(320, 'Bacon', 50, 1, 'Pizza À Moda'),
(321, 'Frango', 50, 1, 'Pizza À Moda'),
(322, 'Carne de sol', 50, 1, 'Pizza À Moda'),
(323, 'Tomate', 20, 0, 'Pizza À Moda'),
(324, 'Massa', 1, 2, 'Pizza À Moda'),
(325, 'Molho de Tomate', 50, 0, 'Pizza À Moda'),
(326, 'Milho Verde', 30, 0, 'Pizza À Moda'),
(327, 'Embalagem', 1, 1, 'Pizza À Moda'),
(328, 'Gás', 1, 1, 'Pizza À Moda'),
(329, 'Azeitona', 30, 0, 'Pizza À Moda'),
(330, 'Gás', 1, 1, 'Pizza Portuguesa'),
(331, 'Embalagem', 1, 1, 'Pizza Portuguesa'),
(332, 'Milho Verde', 50, 0, 'Pizza Portuguesa'),
(333, 'Molho de Tomate', 50, 0, 'Pizza Portuguesa'),
(334, 'Massa', 1, 2, 'Pizza Portuguesa'),
(335, 'Ovo', 2, 1, 'Pizza Portuguesa'),
(336, 'Presunto', 150, 2, 'Pizza Portuguesa'),
(337, 'Mussarela', 300, 5, 'Pizza Portuguesa'),
(338, 'Embalagem', 1, 1, 'Pizza de Atum'),
(339, 'Gás', 1, 1, 'Pizza de Atum'),
(340, 'Atum', 150, 4, 'Pizza de Atum'),
(341, 'Molho de Tomate', 50, 0, 'Pizza de Atum'),
(342, 'Massa', 1, 2, 'Pizza de Atum'),
(343, 'Cebola', 70, 0, 'Pizza de Atum'),
(344, 'Mussarela', 300, 5, 'Pizza de Atum'),
(345, 'Mussarela', 300, 5, 'Pizza de Lombo'),
(346, 'Cebola', 50, 0, 'Pizza de Lombo'),
(347, 'Molho de Tomate', 100, 1, 'Pizza de Lombo'),
(348, 'Lombo', 150, 3, 'Pizza de Lombo'),
(349, 'Embalagem', 1, 1, 'Pizza de Lombo'),
(350, 'Gás', 1, 1, 'Pizza de Lombo'),
(351, 'Calabresa', 200, 3, 'Pizza de Calabacon'),
(352, 'Mussarela', 300, 5, 'Pizza de Calabacon'),
(353, 'Massa', 1, 2, 'Pizza de Calabacon'),
(354, 'Cebola', 70, 0, 'Pizza de Calabacon'),
(355, 'Molho de Tomate', 50, 0, 'Pizza de Calabacon'),
(356, 'Embalagem', 1, 1, 'Pizza de Calabacon'),
(357, 'Gás', 1, 1, 'Pizza de Calabacon'),
(358, 'Bacon', 100, 1, 'Pizza de Calabacon'),
(359, 'Mussarela', 250, 4, 'PIzza de Franbacon'),
(360, 'Frango', 250, 3, 'PIzza de Franbacon'),
(361, 'Tomate', 50, 0, 'PIzza de Franbacon'),
(362, 'Massa', 1, 2, 'PIzza de Franbacon'),
(363, 'Milho Verde', 50, 0, 'PIzza de Franbacon'),
(364, 'Embalagem', 1, 1, 'PIzza de Franbacon'),
(365, 'Gás', 1, 1, 'PIzza de Franbacon'),
(366, 'Molho de Tomate', 50, 0, 'PIzza de Franbacon'),
(367, 'Bacon', 100, 1, 'PIzza de Franbacon'),
(368, 'Gás', 1, 1, 'PIzza do Pizzaiolo'),
(369, 'Embalagem', 1, 1, 'PIzza do Pizzaiolo'),
(370, 'Milho Verde', 50, 0, 'PIzza do Pizzaiolo'),
(371, 'Molho de Tomate', 50, 0, 'PIzza do Pizzaiolo'),
(372, 'Massa', 1, 2, 'PIzza do Pizzaiolo'),
(373, 'Presunto', 150, 2, 'PIzza do Pizzaiolo'),
(374, 'Mussarela', 250, 4, 'PIzza do Pizzaiolo'),
(375, 'Frango', 250, 3, 'PIzza do Pizzaiolo'),
(376, 'Mussarela', 250, 4, 'PIzza Dois Queijos'),
(377, 'Massa', 1, 2, 'PIzza Dois Queijos'),
(378, 'Molho de Tomate', 100, 1, 'PIzza Dois Queijos'),
(379, 'Embalagem', 1, 1, 'PIzza Dois Queijos'),
(380, 'Gás', 1, 1, 'PIzza Dois Queijos'),
(381, 'Catupiry', 200, 4, 'PIzza Dois Queijos'),
(382, 'Mussarela', 350, 5, 'PIzza Jardineira'),
(383, 'Tomate', 50, 0, 'PIzza Jardineira'),
(384, 'Massa', 1, 2, 'PIzza Jardineira'),
(385, 'Molho de Tomate', 50, 0, 'PIzza Jardineira'),
(386, 'Milho Verde', 50, 0, 'PIzza Jardineira'),
(387, 'Embalagem', 1, 1, 'PIzza Jardineira'),
(388, 'Gás', 1, 1, 'PIzza Jardineira'),
(389, 'Azeitona', 50, 0, 'PIzza Jardineira'),
(390, 'Calabresa', 200, 3, 'Pizza de Calabresa'),
(391, 'Mussarela', 300, 5, 'Pizza de Calabresa'),
(392, 'Massa', 1, 2, 'Pizza de Calabresa'),
(393, 'Cebola', 50, 0, 'Pizza de Calabresa'),
(394, 'Molho de Tomate', 50, 0, 'Pizza de Calabresa'),
(395, 'Embalagem', 1, 1, 'Pizza de Calabresa'),
(396, 'Gás', 1, 1, 'Pizza de Calabresa'),
(398, 'Cajuína', 1, 5, 'Cajuína 2l'),
(399, 'Coca', 1, 5, 'Coca 2l'),
(400, 'Catupiry', 250, 5, 'Borda Vulcão 1'),
(401, 'Catupiry', 250, 5, 'Borda Vulcão 2'),
(402, 'Catupiry', 250, 5, 'Borda Vulcão 3'),
(403, 'Mussarela', 350, 5, 'PIzza Crocante'),
(404, 'Tomate', 50, 0, 'PIzza Crocante'),
(405, 'Massa', 1, 2, 'PIzza Crocante'),
(406, 'Molho de Tomate', 50, 0, 'PIzza Crocante'),
(407, 'Milho Verde', 50, 0, 'PIzza Crocante'),
(408, 'Embalagem', 1, 1, 'PIzza Crocante'),
(409, 'Gás', 1, 1, 'PIzza Crocante'),
(410, 'Batata Palha', 50, 1, 'PIzza Crocante'),
(411, 'Acréscimo', 1, 1, 'Acréscimo'),
(412, 'Mussarela', 350, 5, 'Pizza de Mussarela'),
(413, 'Tomate', 50, 0, 'Pizza de Mussarela'),
(414, 'Massa', 1, 2, 'Pizza de Mussarela'),
(415, 'Molho de Tomate', 50, 0, 'Pizza de Mussarela'),
(416, 'Milho Verde', 50, 0, 'Pizza de Mussarela'),
(417, 'Embalagem', 1, 1, 'Pizza de Mussarela'),
(418, 'Gás', 1, 1, 'Pizza de Mussarela');

-- --------------------------------------------------------

--
-- Estrutura da tabela `vendas`
--

CREATE TABLE `vendas` (
  `cliente` varchar(100) DEFAULT NULL,
  `produto` varchar(50) DEFAULT NULL,
  `preco` double DEFAULT NULL,
  `quantidade` int(50) DEFAULT NULL,
  `hora` varchar(100) DEFAULT NULL,
  `minuto` varchar(100) DEFAULT NULL,
  `segundo` varchar(100) DEFAULT NULL,
  `nvenda` varchar(255) DEFAULT NULL,
  `precoreal` double DEFAULT NULL,
  `dia` varchar(10) DEFAULT NULL,
  `mes` varchar(10) DEFAULT NULL,
  `ano` varchar(10) DEFAULT NULL,
  `desconto` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `vendas`
--

INSERT INTO `vendas` (`cliente`, `produto`, `preco`, `quantidade`, `hora`, `minuto`, `segundo`, `nvenda`, `precoreal`, `dia`, `mes`, `ano`, `desconto`) VALUES
('Daniel Vitor Pereira Rodrigues', 'Hambúrguer', 35, 1, '14', '21', '47', '3092017142147', 25, '30', '09', '2017', 0),
('Daniel Vitor Pereira Rodrigues', 'Hambúrguer2', 65, 1, '14', '24', '12', '3092017142412', 25, '30', '09', '2017', 0),
('Daniel Vitor Pereira Rodrigues', 'DiaD', 55, 1, '15', '34', '45', '3092017153445', 50, '30', '09', '2017', 0),
('Daniel Vitor Pereira Rodrigues', 'DiaD', 55, 1, '15', '37', '21', '3092017153721', 50, '30', '09', '2017', 0),
('Daniel Vitor Pereira Rodrigues', 'DiaD', 110, 2, '15', '38', '52', '3092017153852', 50, '30', '09', '2017', 0),
('Daniel Vitor Pereira Rodrigues', 'Pizza de Calabresa', 20, 1, '10', '13', '12', '17102017101312', 11.73, '17', '10', '2017', 0),
('Lucas Estevão', 'Pizza de Calabresa', 10, 1, '19', '8', '1', '181020171981', 11.48, '18', '10', '2017', 0),
('Lucas Estevão', 'PIzza de Frango', 10, 1, '19', '8', '1', '181020171981', 10.95, '18', '10', '2017', 0),
('Yamusa', 'Pizza de Calabresa', 10, 1, '23', '3', '25', '1810201723325', 11.48, '18', '10', '2017', 0),
('Yamusa', 'Pizza de Bacon', 10, 1, '23', '3', '25', '1810201723325', 11.258500000000002, '18', '10', '2017', 0),
('Yamusa', 'Borda', 5, 1, '23', '3', '25', '1810201723325', 4, '18', '10', '2017', 0),
('Ítalo', 'Pizza À Moda', 20, 1, '23', '6', '51', '1810201723651', 11.845500000000001, '18', '10', '2017', 0),
('Mikaele Professora', 'Pizza Portuguesa', 20, 1, '23', '13', '59', '18102017231359', 12.344999999999999, '18', '10', '2017', 0),
('Mikaele Professora', 'Borda', 5, 1, '23', '13', '59', '18102017231359', 4, '18', '10', '2017', 0),
('Mikaele Professora', 'Cajuína 2l', 8, 1, '23', '13', '59', '18102017231359', 5.34, '18', '10', '2017', 0),
('Karina', 'Pizza de Calabresa', 20, 1, '23', '15', '36', '18102017231536', 11.48, '18', '10', '2017', 0),
('Karina', 'Coca 2l', 8, 1, '23', '15', '36', '18102017231536', 5.34, '18', '10', '2017', 0),
('Amabile', 'PIzza de Frango', 10, 1, '23', '17', '55', '18102017231755', 10.95, '18', '10', '2017', 0),
('Amabile', 'Pizza de Calabresa', 10, 1, '23', '17', '55', '18102017231755', 11.48, '18', '10', '2017', 0),
('Sonja', 'Pizza de Calabresa', 10, 1, '23', '19', '39', '18102017231939', 11.48, '18', '10', '2017', 0),
('Sonja', 'Pizza Carne de Sol', 10, 1, '23', '19', '39', '18102017231939', 10.155000000000001, '18', '10', '2017', 0),
('Magislene', 'Pizza À Moda', 20, 1, '22', '38', '11', '25102017223811', 11.845500000000001, '25', '10', '2017', 0),
('Mikaele Professora', 'Pizza de Calabresa', 10, 1, '22', '41', '55', '25102017224155', 11.48, '25', '10', '2017', 0),
('Mikaele Professora', 'Pizza Portuguesa', 10, 1, '22', '41', '55', '25102017224155', 12.344999999999999, '25', '10', '2017', 0),
('Mikaele Professora', 'Borda', 5, 1, '22', '41', '55', '25102017224155', 4, '25', '10', '2017', 0),
('Samantha Leandro', 'Pizza de Calabresa', 20, 1, '22', '45', '58', '25102017224558', 11.48, '25', '10', '2017', 0),
('Helisandra ', 'PIzza do Pizzaiolo', 22, 1, '23', '10', '24', '25102017231024', 12.695, '25', '10', '2017', 0),
('Helisandra ', 'Pizza de Lombo', 11, 1, '23', '10', '24', '25102017231024', 10.285, '25', '10', '2017', 0),
('Helisandra ', 'Pizza Carne de Sol', 10, 1, '23', '10', '24', '25102017231024', 10.155000000000001, '25', '10', '2017', 0),
('Helisandra ', 'Borda', 16, 3, '23', '10', '24', '25102017231024', 4, '25', '10', '2017', 0),
('Angélica', 'Pizza À Moda', 20, 1, '23', '12', '38', '25102017231238', 11.845500000000001, '25', '10', '2017', 0),
('Jahir paulinho', 'Pizza Carne de Sol', 10, 1, '23', '15', '9', '2510201723159', 10.155000000000001, '25', '10', '2017', 0),
('Jahir paulinho', 'Pizza de Calabresa', 10, 1, '23', '15', '9', '2510201723159', 11.48, '25', '10', '2017', 0),
('Jahir paulinho', 'Borda', 5, 1, '23', '15', '9', '2510201723159', 4, '25', '10', '2017', 0),
('Ismael', 'PIzza de Franbacon', 11, 1, '23', '21', '27', '25102017232127', 12.399, '25', '10', '2017', 0),
('Ismael', 'Pizza de Calabacon', 11, 1, '23', '21', '27', '25102017232127', 12.989, '25', '10', '2017', 0),
('Olegário', 'Pizza À Moda', 20, 1, '23', '22', '50', '25102017232250', 11.845500000000001, '25', '10', '2017', 0),
('Sheila', 'Pizza À Moda', 20, 1, '23', '24', '40', '25102017232440', 11.845500000000001, '25', '10', '2017', 0),
('Sheila', 'Borda', 5, 1, '23', '24', '40', '25102017232440', 4, '25', '10', '2017', 0),
('Yasmin', 'Pizza de Calabresa', 20, 1, '23', '25', '51', '25102017232551', 11.48, '25', '10', '2017', 0),
('Sonja', 'Pizza Carne de Sol', 10, 1, '19', '4', '25', '2710201719425', 5.077500000000001, '27', '10', '2017', 0),
('Sonja', 'Pizza de Calabresa', 10, 1, '19', '4', '25', '2710201719425', 5.74, '27', '10', '2017', 0),
('Sonja', 'Pizza Carne de Sol', 10, 1, '19', '5', '9', '271020171959', 5.077500000000001, '27', '10', '2017', 0),
('Sonja', 'Pizza de Calabresa', 10, 1, '19', '5', '9', '271020171959', 5.74, '27', '10', '2017', 0),
('Solange', 'Pizza de Calabresa', 20, 1, '19', '23', '20', '27102017192320', 11.48, '27', '10', '2017', 0),
('Taís', 'PIzza de Mussarela', 9, 1, '19', '53', '38', '27102017195338', 5.0625, '27', '10', '2017', 0),
('Taís', 'Pizza Carne de Sol', 10, 1, '19', '53', '38', '27102017195338', 5.077500000000001, '27', '10', '2017', 0),
('Taís', 'Borda', 5, 1, '19', '53', '38', '27102017195338', 4, '27', '10', '2017', 0),
('Joabe Gilearde', 'Pizza de Calabresa', 10, 1, '20', '52', '52', '27102017205252', 5.74, '27', '10', '2017', 0),
('Joabe Gilearde', 'PIzza de Frango', 10, 1, '20', '52', '52', '27102017205252', 5.475, '27', '10', '2017', 0),
('Joabe Gilearde', 'Borda', 5, 1, '20', '52', '52', '27102017205252', 4, '27', '10', '2017', 0),
('Edigleuda', 'Pizza de Calabresa', 10, 1, '21', '12', '10', '27102017211210', 5.74, '27', '10', '2017', 0),
('Edigleuda', 'PIzza de Presunto', 10, 1, '21', '12', '10', '27102017211210', 5.4725, '27', '10', '2017', 0),
('Regis', 'PIzza de Frango', 10, 1, '21', '16', '56', '27102017211656', 5.475, '27', '10', '2017', 0),
('Regis', 'Pizza de Bacon', 10, 1, '21', '16', '56', '27102017211656', 5.629250000000001, '27', '10', '2017', 0),
('Regis', 'Borda', 5, 1, '21', '16', '56', '27102017211656', 4, '27', '10', '2017', 0),
('Regis', 'Cajuína 2l', 8, 1, '21', '16', '56', '27102017211656', 5.34, '27', '10', '2017', 0),
('Regis', 'Pizza de Calabresa', 20, 1, '21', '16', '56', '27102017211656', 11.48, '27', '10', '2017', 0),
('0', 'Pizza de Calabresa', 20, 1, '20', '34', '44', '17112018203444', 11.48, '17', '11', '2018', 0),
('0', 'Pizza de Calabresa', 20, 1, '21', '36', '32', '17112018213632', 11.48, '17', '11', '2018', 0),
('Almirton', 'Pizza de Calabresa', 20, 1, '21', '37', '01', '17112018213701', 11.48, '17', '11', '2018', 25),
('Almirton', 'PIzza de Frango', 20, 1, '21', '37', '01', '17112018213701', 10.95, '17', '11', '2018', 25),
('0', 'Pizza de Calabresa', 20, 1, '22', '22', '20', '17112018222220', 11.48, '17', '11', '2018', 10),
('0', 'PIzza de Mussarela', 18, 1, '22', '22', '20', '17112018222220', 10.125, '17', '11', '2018', 10),
('0', 'PIzza de Presunto', 20, 1, '22', '22', '20', '17112018222220', 10.945, '17', '11', '2018', 10),
('0', 'Pizza À Moda', 20, 1, '22', '22', '20', '17112018222220', 11.845500000000001, '17', '11', '2018', 10),
('0', 'Pizza de Calabresa', 20, 1, '12', '58', '10', '24112018125810', 11.48, '24', '11', '2018', 0),
('Almeida', 'Pizza de Calabresa', 20, 1, '14', '09', '27', '24112018140927', 11.48, '24', '11', '2018', 0),
('Almirton', 'Pizza de Calabresa', 20, 1, '14', '11', '03', '24112018141103', 11.48, '24', '11', '2018', 10),
('Daniel Vitor Pereira Rodrigues', 'Pizza de Calabresa', 20, 1, '17', '52', '17', '24112018175217', 11.48, '24', '11', '2018', 8),
('Daniel Vitor Pereira Rodrigues', 'Pizza de Bacon', 20, 1, '17', '52', '17', '24112018175217', 11, '24', '11', '2018', 8),
('Daniel Vitor Pereira Rodrigues', 'PIzza de Mussarela', 18, 1, '17', '52', '17', '24112018175217', 4, '24', '11', '2018', 8),
('Daniel Vitor Pereira Rodrigues', 'PIzza de Presunto', 20, 1, '17', '52', '17', '24112018175217', 10.945, '24', '11', '2018', 8),
('Daniel Vitor Pereira Rodrigues', 'Pizza Carne de Sol', 20, 1, '17', '52', '17', '24112018175217', 10.155000000000001, '24', '11', '2018', 8);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `custo`
--
ALTER TABLE `custo`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `estoque`
--
ALTER TABLE `estoque`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `produtos`
--
ALTER TABLE `produtos`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `receitas`
--
ALTER TABLE `receitas`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=97;

--
-- AUTO_INCREMENT for table `custo`
--
ALTER TABLE `custo`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `estoque`
--
ALTER TABLE `estoque`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `produtos`
--
ALTER TABLE `produtos`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `receitas`
--
ALTER TABLE `receitas`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=419;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
