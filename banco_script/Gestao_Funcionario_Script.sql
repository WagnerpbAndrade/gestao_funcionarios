DROP DATABASE funcionariodb;

CREATE DATABASE funcionariodb;

USE funcionariodb;

CREATE TABLE IF NOT EXISTS funcionario (
    idFuncionario INT AUTO_INCREMENT NOT NULL,
    nome          VARCHAR (50) NOT NULL,
    telefone      VARCHAR (15) NOT NULL,
    salario       DOUBLE       NOT NULL,
    salarioBonus  DOUBLE       NOT NULL,
    assiduidade   INTEGER      NOT NULL,
    cargo         VARCHAR (50) NOT NULL,
    regiao        VARCHAR (50) NOT NULL,
    dependentes   INTEGER      NOT NULL,
    status		  INTEGER	   NOT NULL DEFAULT 1,
    
    PRIMARY KEY(idFuncionario)
);


CREATE TABLE IF NOT EXISTS bonus (
	idBonus INT NOT NULL AUTO_INCREMENT,
    tipoDeBonus VARCHAR(50) NOT NULL,
	
	PRIMARY KEY (idBonus)

);

CREATE TABLE IF NOT EXISTS bonusFuncionario (
	idFuncionario INT NOT NULL,
	idBonus INT NOT NULL
);

CREATE TABLE IF NOT EXISTS log (
	idLog INT NOT NULL AUTO_INCREMENT,
	log VARCHAR(1000) NOT NULL,
    
	PRIMARY KEY(idLog)
);

INSERT INTO bonus(tipoDeBonus) VALUES('Normal');
INSERT INTO bonus(tipoDeBonus) VALUES('Generoso');
INSERT INTO bonus(tipoDeBonus) VALUES('Assiduidade');
INSERT INTO bonus(tipoDeBonus) VALUES('Localidade');
INSERT INTO bonus(tipoDeBonus) VALUES('Dependentes');



