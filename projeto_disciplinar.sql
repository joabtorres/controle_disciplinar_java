DROP DATABASE projeto_disciplinar;
CREATE DATABASE projeto_disciplinar DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_general_ci; 
USE projeto_disciplinar;
CREATE TABLE `tb_disciplina` (
  `cod` int(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `nome` varchar(200) NOT NULL,
  `carga_horaria` varchar(30) NOT NULL,
  `curso` varchar(200) NOT NULL,
  `vagas` int(3) NOT NULL,
  `periodo` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `tb_disciplina` (`cod`, `nome`, `carga_horaria`, `curso`, `vagas`, `periodo`) VALUES
(1, 'Programaçao Web', '120 Horas', 'Análise e Desenvolvimento de Sistemas', 20, 'Vespertino'),
(2, 'Estrutura de Dados', '10 Horas', 'Análise e Desenvolvimento de Sistemas', 40, 'Noturno'),
(3, 'Engenharia de Softwarea', '80 Horas', 'Ciência da Computação', 20, 'Matutino'),
(4, 'Linguagem de Programacão I', '120 Horas', 'Análise e Desenvolvimento de Sistemas', 40, 'Vespertino');

