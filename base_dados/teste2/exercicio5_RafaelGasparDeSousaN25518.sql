

--este codigo irá criar a nossa base de dados
CREATE DATABASE payment_trade_and_finance;

--este codigo irá criar o utilizador do administrador que terá todos os previlegios sobre a base de dados
CREATE USER administrador IDENTIFIED BY 'senha';
GRANT ALL PRIVILEGES ON payment_trade_and_finance TO administrador;

--este codigo irá criar o utilizador que so poderá ler a base de dados
CREATE USER leitor IDENTIFIED BY 'senha';
GRANT SELECT ON payment_trade_and_finance TO leitor;