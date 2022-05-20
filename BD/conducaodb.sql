-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-05-2022 a las 00:37:25
-- Versión del servidor: 10.3.16-MariaDB
-- Versión de PHP: 7.3.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `conducaodb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `acesso`
--

CREATE TABLE `acesso` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `acesso`
--

INSERT INTO `acesso` (`id`, `nome`) VALUES
(1, 'admin'),
(2, 'director'),
(3, 'professor'),
(4, 'secretaria'),
(5, 'instrutor');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aluno`
--

CREATE TABLE `aluno` (
  `id` int(11) NOT NULL,
  `id_transporte` int(11) NOT NULL,
  `ficha_requerimento` varchar(255) NOT NULL,
  `cartao_vacina` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `aluno`
--

INSERT INTO `aluno` (`id`, `id_transporte`, `ficha_requerimento`, `cartao_vacina`) VALUES
(8, 1, 'FGG44266', 'HSF28929'),
(9, 1, 'KJN32637', 'JNG837747');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aluno_aula`
--

CREATE TABLE `aluno_aula` (
  `id` int(11) NOT NULL,
  `id_aluno` int(11) NOT NULL,
  `id_aula` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `aluno_aula`
--

INSERT INTO `aluno_aula` (`id`, `id_aluno`, `id_aula`) VALUES
(3, 9, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aluno_exame`
--

CREATE TABLE `aluno_exame` (
  `id` int(11) NOT NULL,
  `id_aluno` int(11) NOT NULL,
  `id_exame` int(11) NOT NULL,
  `avaliacao_quantitativa` int(11) NOT NULL,
  `avaliacao_qualitativa` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `aluno_exame`
--

INSERT INTO `aluno_exame` (`id`, `id_aluno`, `id_exame`, `avaliacao_quantitativa`, `avaliacao_qualitativa`) VALUES
(2, 9, 1, 16, 'R');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aula`
--

CREATE TABLE `aula` (
  `id` int(11) NOT NULL,
  `id_professor` int(11) NOT NULL,
  `sumario` text NOT NULL,
  `date_aula` date NOT NULL,
  `id_tipo` int(11) NOT NULL,
  `numero` int(10) NOT NULL,
  `hora_inicio` varchar(5) NOT NULL,
  `duracao` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `aula`
--

INSERT INTO `aula` (`id`, `id_professor`, `sumario`, `date_aula`, `id_tipo`, `numero`, `hora_inicio`, `duracao`) VALUES
(1, 2, 'Condução 3ra\nLicença\ne outros', '2022-05-31', 1, 1, '12:45', '01:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bairro`
--

CREATE TABLE `bairro` (
  `id` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `id_municipio` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `bairro`
--

INSERT INTO `bairro` (`id`, `nome`, `id_municipio`) VALUES
(1, 'Shisindo', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cargo`
--

CREATE TABLE `cargo` (
  `id` int(11) NOT NULL,
  `nome` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cargo`
--

INSERT INTO `cargo` (`id`, `nome`) VALUES
(1, 'Director'),
(4, 'Instructor'),
(2, 'Professor'),
(3, 'Secretaria');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `id` int(11) NOT NULL,
  `nome` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`id`, `nome`) VALUES
(1, 'VIP');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `exame`
--

CREATE TABLE `exame` (
  `id` int(11) NOT NULL,
  `id_instrutor` int(11) NOT NULL,
  `data` date NOT NULL,
  `id_tipo` int(11) NOT NULL,
  `id_categoria` int(11) NOT NULL,
  `hora` varchar(5) NOT NULL,
  `duracao` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `exame`
--

INSERT INTO `exame` (`id`, `id_instrutor`, `data`, `id_tipo`, `id_categoria`, `hora`, `duracao`) VALUES
(1, 6, '2022-05-20', 1, 1, '14:30', '02:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `funcionario`
--

CREATE TABLE `funcionario` (
  `id` int(11) NOT NULL,
  `id_cargo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `funcionario`
--

INSERT INTO `funcionario` (`id`, `id_cargo`) VALUES
(1, 1),
(2, 2),
(10, 3),
(6, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inscricao`
--

CREATE TABLE `inscricao` (
  `id` int(11) NOT NULL,
  `id_aluno` int(11) NOT NULL,
  `data` date NOT NULL,
  `id_tipo_inscricao` int(11) NOT NULL,
  `id_categoria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `inscricao`
--

INSERT INTO `inscricao` (`id`, `id_aluno`, `data`, `id_tipo_inscricao`, `id_categoria`) VALUES
(1, 9, '2022-05-20', 1, 1),
(2, 8, '2022-05-20', 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `instructor`
--

CREATE TABLE `instructor` (
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `instructor`
--

INSERT INTO `instructor` (`id`) VALUES
(6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `municipio`
--

CREATE TABLE `municipio` (
  `id` int(11) NOT NULL,
  `nome` varchar(50) COLLATE latin1_bin NOT NULL,
  `id_provincia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin;

--
-- Volcado de datos para la tabla `municipio`
--

INSERT INTO `municipio` (`id`, `nome`, `id_provincia`) VALUES
(1, 'Cuito', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pessoa`
--

CREATE TABLE `pessoa` (
  `id` int(11) NOT NULL,
  `nome` varchar(60) NOT NULL,
  `sobrenome` varchar(60) NOT NULL,
  `passaporte` varchar(60) DEFAULT NULL,
  `genero` varchar(60) NOT NULL,
  `data_nascimento` date NOT NULL,
  `email` varchar(120) DEFAULT NULL,
  `telefone` varchar(60) NOT NULL,
  `id_endereco` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `pessoa`
--

INSERT INTO `pessoa` (`id`, `nome`, `sobrenome`, `passaporte`, `genero`, `data_nascimento`, `email`, `telefone`, `id_endereco`) VALUES
(1, 'Samuel', 'Jamba', 'K041376', 'Masculino', '2022-05-05', 'a@a.aa', '(+244)993-237-273', 1),
(2, 'Josep', 'Mandiaco', 'K1234', 'Masculino', '2022-05-09', 'a@a.aa', '(+244)939-172-322', 2),
(4, 'Michaella', 'Jackson', 'L34828', 'Femenino', '2022-05-09', 'm@m.mm', '(+244)934-512-217', 4),
(5, 'Michaella', 'Jackson', 'L34828', 'Femenino', '2022-05-09', 'm@m.mm', '(+244)934-512-217', 5),
(6, 'Michaella', 'Girkan Sofir', 'L176232', 'Femenino', '2022-05-09', 'm@m.mm', '(+244)923-723-727', 6),
(8, 'George', 'Mazunda', '', 'Masculino', '2022-05-20', '', '(+244)981-637-272', 8),
(9, 'Lusinda', 'Ferinha', '', 'Femenino', '2022-05-20', '', '(+244)981-637-272', 9),
(10, 'Frederica', 'Chamba', '', 'Femenino', '2022-05-20', 'a@a.aa', '(+244)986-237-232', 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `professor`
--

CREATE TABLE `professor` (
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `professor`
--

INSERT INTO `professor` (`id`) VALUES
(2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `provincia`
--

CREATE TABLE `provincia` (
  `id` int(11) NOT NULL,
  `nome` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `provincia`
--

INSERT INTO `provincia` (`id`, `nome`) VALUES
(1, 'Luanda'),
(2, 'Bié');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `residencia`
--

CREATE TABLE `residencia` (
  `id` int(11) NOT NULL,
  `id_bairro` int(11) NOT NULL,
  `rua` varchar(60) NOT NULL,
  `num_casa` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `residencia`
--

INSERT INTO `residencia` (`id`, `id_bairro`, `rua`, `num_casa`) VALUES
(1, 1, 'CFG', '11'),
(2, 1, 'Capitango', '234'),
(3, 1, 'Capitango', '234'),
(4, 1, 'PedCuli', ''),
(5, 1, 'PedCuli', '123'),
(6, 1, 'Housua', ''),
(7, 1, 'Housua', ''),
(8, 1, 'Central Park', '345'),
(9, 1, 'Central Park', '987'),
(10, 1, 'Jota', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo`
--

CREATE TABLE `tipo` (
  `id` int(11) NOT NULL,
  `nome` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipo`
--

INSERT INTO `tipo` (`id`, `nome`) VALUES
(1, 'Pratico'),
(2, 'Teorico');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_inscricao`
--

CREATE TABLE `tipo_inscricao` (
  `id` int(11) NOT NULL,
  `nome` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipo_inscricao`
--

INSERT INTO `tipo_inscricao` (`id`, `nome`) VALUES
(1, 'Pessoal');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_transporte`
--

CREATE TABLE `tipo_transporte` (
  `id` int(11) NOT NULL,
  `nome` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipo_transporte`
--

INSERT INTO `tipo_transporte` (`id`, `nome`) VALUES
(1, 'Ligeiro'),
(2, 'Pesado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `transporte`
--

CREATE TABLE `transporte` (
  `id` int(11) NOT NULL,
  `peso` double(10,2) NOT NULL,
  `marca` varchar(60) NOT NULL,
  `modelo` varchar(60) NOT NULL,
  `cor` varchar(60) NOT NULL,
  `matricula` varchar(60) NOT NULL,
  `num_circulacao` varchar(60) NOT NULL,
  `id_tipo_trans` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `transporte`
--

INSERT INTO `transporte` (`id`, `peso`, `marca`, `modelo`, `cor`, `matricula`, `num_circulacao`, `id_tipo_trans`) VALUES
(1, 400.75, 'HYUNDAI', 'H09', 'VERMELHO', 'B041376HJ', '67RT54', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `nome` varchar(60) NOT NULL,
  `senha` varchar(255) NOT NULL,
  `id_acesso` int(11) NOT NULL,
  `id_funcionario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `nome`, `senha`, `id_acesso`, `id_funcionario`) VALUES
(1, 'admin', '2c978d261a17e63ffc5b87f58b2e237fbe88a94ef1113cd76caa9453d4123c7310cde5fb2048dd5c88ca36cb18c520060b7b58027dd8177499860b32d7f54705', 1, NULL),
(2, 'director', '8de1915069b1910852fe83683260e09b9fc5f7d0aeaa07aab6786d9dbba7db72636a0b323e81fdc118c30fae211496fc4a3d17a502514d5db73c1a17ff4456fa', 2, 1),
(3, 'professor', 'a07935bbb9b78e72767d6f19987ace2e5cedcd2899d329173f69f6441d10d3a5dcd4f56550e36ce082dfe4a2ce93c5758f0aa88373fcaa00e97709fa27ca20a1', 3, 2),
(4, 'instrutor', '83710f4481135056c6ddf5a363e58d1df54328842b665732e26947625f2a03a859a56d69b13ff4fdd84e3e82d2efe791104c34629125056c71b135715d41c403', 5, 6),
(5, 'secretaria', 'ba8db23cb9855e57e2da11ce7ddc65439260973114f58a8b7ac8a4a659e125eee9eb8c8c95812f345576cddbe618bf4766759ed83a8fb6281c75e3113c7c8d57', 4, 10);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `acesso`
--
ALTER TABLE `acesso`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `aluno`
--
ALTER TABLE `aluno`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_transporte` (`id_transporte`);

--
-- Indices de la tabla `aluno_aula`
--
ALTER TABLE `aluno_aula`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_aluno` (`id_aluno`),
  ADD KEY `id_aula` (`id_aula`);

--
-- Indices de la tabla `aluno_exame`
--
ALTER TABLE `aluno_exame`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_aluno` (`id_aluno`),
  ADD KEY `id_exame` (`id_exame`);

--
-- Indices de la tabla `aula`
--
ALTER TABLE `aula`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_professor` (`id_professor`),
  ADD KEY `id_tipo` (`id_tipo`);

--
-- Indices de la tabla `bairro`
--
ALTER TABLE `bairro`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_municipio` (`id_municipio`);

--
-- Indices de la tabla `cargo`
--
ALTER TABLE `cargo`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nome` (`nome`);

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `exame`
--
ALTER TABLE `exame`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_categoria` (`id_categoria`),
  ADD KEY `id_instrutor` (`id_instrutor`),
  ADD KEY `id_tipo` (`id_tipo`);

--
-- Indices de la tabla `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_cargo` (`id_cargo`);

--
-- Indices de la tabla `inscricao`
--
ALTER TABLE `inscricao`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_aluno` (`id_aluno`),
  ADD KEY `id_categoria` (`id_categoria`),
  ADD KEY `id_tipo_inscricao` (`id_tipo_inscricao`);

--
-- Indices de la tabla `instructor`
--
ALTER TABLE `instructor`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `municipio`
--
ALTER TABLE `municipio`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_provincia` (`id_provincia`);

--
-- Indices de la tabla `pessoa`
--
ALTER TABLE `pessoa`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_endereco` (`id_endereco`);

--
-- Indices de la tabla `professor`
--
ALTER TABLE `professor`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `provincia`
--
ALTER TABLE `provincia`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `residencia`
--
ALTER TABLE `residencia`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_bairro` (`id_bairro`);

--
-- Indices de la tabla `tipo`
--
ALTER TABLE `tipo`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tipo_inscricao`
--
ALTER TABLE `tipo_inscricao`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tipo_transporte`
--
ALTER TABLE `tipo_transporte`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `transporte`
--
ALTER TABLE `transporte`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_tipo_trans` (`id_tipo_trans`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_acesso` (`id_acesso`),
  ADD KEY `id_funcionario` (`id_funcionario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `acesso`
--
ALTER TABLE `acesso`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `aluno_aula`
--
ALTER TABLE `aluno_aula`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `aluno_exame`
--
ALTER TABLE `aluno_exame`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `aula`
--
ALTER TABLE `aula`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `bairro`
--
ALTER TABLE `bairro`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `cargo`
--
ALTER TABLE `cargo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `exame`
--
ALTER TABLE `exame`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `inscricao`
--
ALTER TABLE `inscricao`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `municipio`
--
ALTER TABLE `municipio`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `pessoa`
--
ALTER TABLE `pessoa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `provincia`
--
ALTER TABLE `provincia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `residencia`
--
ALTER TABLE `residencia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `tipo`
--
ALTER TABLE `tipo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tipo_inscricao`
--
ALTER TABLE `tipo_inscricao`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `tipo_transporte`
--
ALTER TABLE `tipo_transporte`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `transporte`
--
ALTER TABLE `transporte`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `aluno`
--
ALTER TABLE `aluno`
  ADD CONSTRAINT `aluno_ibfk_1` FOREIGN KEY (`id`) REFERENCES `pessoa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `aluno_ibfk_2` FOREIGN KEY (`id_transporte`) REFERENCES `transporte` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `aluno_aula`
--
ALTER TABLE `aluno_aula`
  ADD CONSTRAINT `aluno_aula_ibfk_1` FOREIGN KEY (`id_aluno`) REFERENCES `aluno` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `aluno_aula_ibfk_2` FOREIGN KEY (`id_aula`) REFERENCES `aula` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `aluno_exame`
--
ALTER TABLE `aluno_exame`
  ADD CONSTRAINT `aluno_exame_ibfk_1` FOREIGN KEY (`id_aluno`) REFERENCES `aluno` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `aluno_exame_ibfk_2` FOREIGN KEY (`id_exame`) REFERENCES `exame` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `aula`
--
ALTER TABLE `aula`
  ADD CONSTRAINT `aula_ibfk_1` FOREIGN KEY (`id_professor`) REFERENCES `professor` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `aula_ibfk_2` FOREIGN KEY (`id_tipo`) REFERENCES `tipo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `bairro`
--
ALTER TABLE `bairro`
  ADD CONSTRAINT `bairro_ibfk_1` FOREIGN KEY (`id_municipio`) REFERENCES `municipio` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `exame`
--
ALTER TABLE `exame`
  ADD CONSTRAINT `exame_ibfk_1` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `exame_ibfk_2` FOREIGN KEY (`id_instrutor`) REFERENCES `instructor` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `exame_ibfk_3` FOREIGN KEY (`id_tipo`) REFERENCES `tipo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `funcionario`
--
ALTER TABLE `funcionario`
  ADD CONSTRAINT `funcionario_ibfk_1` FOREIGN KEY (`id`) REFERENCES `pessoa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `funcionario_ibfk_2` FOREIGN KEY (`id_cargo`) REFERENCES `cargo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `inscricao`
--
ALTER TABLE `inscricao`
  ADD CONSTRAINT `inscricao_ibfk_1` FOREIGN KEY (`id_aluno`) REFERENCES `aluno` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `inscricao_ibfk_2` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `inscricao_ibfk_3` FOREIGN KEY (`id_tipo_inscricao`) REFERENCES `tipo_inscricao` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `instructor`
--
ALTER TABLE `instructor`
  ADD CONSTRAINT `instructor_ibfk_1` FOREIGN KEY (`id`) REFERENCES `funcionario` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `municipio`
--
ALTER TABLE `municipio`
  ADD CONSTRAINT `municipio_ibfk_1` FOREIGN KEY (`id_provincia`) REFERENCES `provincia` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `pessoa`
--
ALTER TABLE `pessoa`
  ADD CONSTRAINT `pessoa_ibfk_1` FOREIGN KEY (`id_endereco`) REFERENCES `residencia` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `professor`
--
ALTER TABLE `professor`
  ADD CONSTRAINT `professor_ibfk_1` FOREIGN KEY (`id`) REFERENCES `funcionario` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `residencia`
--
ALTER TABLE `residencia`
  ADD CONSTRAINT `residencia_ibfk_1` FOREIGN KEY (`id_bairro`) REFERENCES `bairro` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `transporte`
--
ALTER TABLE `transporte`
  ADD CONSTRAINT `transporte_ibfk_1` FOREIGN KEY (`id_tipo_trans`) REFERENCES `tipo_transporte` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`id_acesso`) REFERENCES `acesso` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `usuario_ibfk_2` FOREIGN KEY (`id_funcionario`) REFERENCES `funcionario` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
