CREATE TABLE promocao
(
    ID INT NOT NULL AUTO_INCREMENT,
    PRODUTO_ID INT NOT NULL,
    DT_INICIO DATETIME NOT NULL DEFAULT NOW(),
    DT_FIM DATETIME,
    PERC_DESCONTO DOUBLE NOT NULL,
    PRIMARY KEY (ID),
    FOREIGN KEY (PRODUTO_ID) REFERENCES produto(ID)
);