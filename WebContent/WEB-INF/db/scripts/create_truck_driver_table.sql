-- Tabela de pipeiros
CREATE TABLE TRUCK_DRIVER (
	ID INTEGER(255) AUTO_INCREMENT PRIMARY KEY,
	NAME VARCHAR(255) NOT NULL,
	DOCUMENT_ID VARCHAR(11) NOT NULL UNIQUE,
	EMAIL VARCHAR(255) NOT NULL UNIQUE,
	LICENCE_PLATE VARCHAR(7) NOT NULL UNIQUE,
	PHONE VARCHAR(11) NOT NULL UNIQUE,
	CODE VARCHAR(6) NOT NULL UNIQUE,
	MODIFIED TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP()
);

-- Insert inicial para testes
INSERT INTO TRUCK_DRIVER (NAME, DOCUMENT_ID, EMAIL, LICENCE_PLATE, PHONE, CODE) VALUES ('Jos� Augusto', '44982797510', 'meu@email.com', 'ABC1234', '8198735671', 'PE1234');