insert into tipo (descricao) values
('Carro'),
('Usuario'),
('Direcao');

insert into tipocategoria (idtipo, descricao) values
(1,'Segurança'),
(1,'Conforto'),
(1,'Som'),
(1,'Bancos'),
(1,'Janelas'),
(1,'Janelas');

insert into categoria (idtipocategoria, descricao) values
(1, 'airbag motorista'),
(1, 'alarme'),
(1, 'freios ABS'),
(1, 'airbag passageiro'),
(1, 'airbag lateral'),
(1, 'controle de tração'),
(1, 'distribuição eletrônica de frenagem'),
(2, 'ar-condicionado'),
(2, 'travas elétricas'),
(2, 'ar-quente'),
(2, 'piloto automático'),
(2, 'volante com regulagem de altura'),
(2, 'trio elétrico'),
(3, 'cd player'),
(3, 'cd player com MP3'),
(3, 'entrada USB'),
(3, 'rádio FM/AM'),
(3, 'Kit Multimídia'),
(4, 'bancos de couro'),
(4, 'ajuste de altura'),
(4, 'ajuste elétrico'),
(5, 'vidros elétricos dianteiros'),
(5, 'desembaçador traseiro'),
(5, 'teto solar'),
(5, 'vidros elétricos traseiros'),
(6, 'computador de bordo'),
(6, 'sensor de farol'),
(6, 'farol de neblina');

insert into mecanica (motorizacao,combustivel,potencia,velocidadeMaxima,consumoCidade,consumoEstrada,cambio,direcao) values  
('1.0', 'Elétrica', '82.0 / 78.0', null, '9.5 / 13.8', '12.0 / 16.6', 'Manual de 6 marchas', 'Elétrica');

insert into carro(descricao,fabricante,ano) values
('Onix','Chevrolet','2024'),
('Cruze','Chevrolet','2024'),
('Tracker','Chevrolet','2024');

insert into modelo(descricao,idmecanica,idcarro) values
('Onix 1.0 2024',1,1);

insert into modelocategoria (idcategoria,idmodelo,valorcategoria) values
(1,1,true),
(2,1,true),
(3,1,true),
(4,1,true),
(8,1,true),
(11,1,false),
(18,1,false);

insert into endereco(cep,uf,cidade,bairro,rua,numero,complemento,servico,idUsuario) values
('13914114','SP','Jaguariúna','Jardim Sylvio Rinaldi II','Rua Antonio Gilberto Rosin','154','casa','correios',1);

insert into usuario(nome,cpf,email,senha,idade) values
('Michele','28536264829','michele@gmail.com.br','123456','30');


select cr.descricao ,m.descricao, c.descricao, mc.valorcategoria from modelo md 
left Join modelocategoria mc on mc.idmodelo = md.id
left join categoria c on c.id = mc.id
left join modelo m on m.id = mc.idmodelo
left join carro cr on cr.id = m.idcarro

