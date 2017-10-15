CREATE TABLE ENDERECO(

    ID INT NOT NULL AUTO_INCREMENT,
    CLIENTE_ID INT NOT NULL,
    LOGRADOURO VARCHAR (100) NOT NULL,
    NUMERO VARCHAR(10) NOT NULL,
    COMPLEMENTO VARCHAR (50),
    CIDADE VARCHAR(50) NOT NULL,
    UF VARCHAR(2) NOT NULL,
    CEP VARCHAR (9) NOT NULL,
    PRINCIPAL BOOLEAN DEFAULT FALSE,

    PRIMARY KEY (ID, CLIENTE_ID),
    FOREIGN KEY (CLIENTE_ID) REFERENCES CLIENTE(ID)

)