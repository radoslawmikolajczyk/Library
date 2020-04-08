DROP DATABASE IF EXISTS Biblioteka;

CREATE DATABASE Biblioteka;
USE Biblioteka;

CREATE TABLE Czytelnik(

	id_czytelnika SERIAL UNIQUE NOT NULL PRIMARY KEY,
	imie VARCHAR(30) NOT NULL,
	nazwisko VARCHAR(50) NOT NULL,
	nr_telefonu VARCHAR(12) UNIQUE NOT NULL,
	adres VARCHAR(100)
	
);

CREATE TABLE Ksiazka(

	id_ksiazki SERIAL UNIQUE NOT NULL PRIMARY KEY,
	autor VARCHAR(100) NOT NULL,
	tytul VARCHAR(80) NOT NULL,
	wydawnictwo VARCHAR(50),
	rok_wydania INTEGER,
	ilosc_sztuk INTEGER NOT NULL

);

CREATE TABLE Wypozyczenia_zwroty(

    id_wypozyczenia SERIAL PRIMARY KEY,
    imie VARCHAR(30) NOT NULL,
	nazwisko VARCHAR(50) NOT NULL,
	autor VARCHAR(100) NOT NULL,
	tytul VARCHAR(80) NOT NULL,
	data_wypozyczenia CHAR(10) NOT NULL

);

INSERT INTO Ksiazka (id_ksiazki,autor,tytul,wydawnictwo,rok_wydania,ilosc_sztuk) VALUES
(6,"Christie A.","12 prac Herkulesa",NULL,NULL,3),
(1,"Przybyłowicz Ł.","100 najciekawszych zwierząt Polski",NULL,NULL,2),
(2,"Nojszewska A","100 najpiękniejszych ras psów ",NULL,NULL,2),
(3,"-","100 najpiękniejszych starówek Europy",NULL,NULL,2),
(4,"Bąk J.","100 najpiękniejszych zabytków Polski",NULL,NULL,2),
(5,"Bąk J.","100 najpiękniejszych zabytków świata",NULL,NULL,2),
(7,"Makuszyński K.","120 Przygód Koziołka Matołka [cz.1 cyklu]",NULL,NULL,2),
(8,"Szymeczko K.","A to historia. Opowiadania z dziejów Polski",NULL,NULL,2),
(9,"Brzechwa J.","Akademia pana Kleksa",NULL,NULL,2),
(10,"Carrol L.","Alicja w krainie czarów",NULL,NULL,2),
(11,"Centkiewicz Cz.","Anaruk, chłopiec z Grenlandii",NULL,NULL,2),
(12,"Montgomery L.M.","Ania z Zielonego Wzgórza (Złota seria)",NULL,NULL,2),
(13,"Jastrun T.","Antoś i jeszcze ktoś",NULL,NULL,2),
(14,"-","Architektura (To mój kraj)",NULL,NULL,2),
(15,"Papuzińska J.","Asiunia",NULL,NULL,2),
(16,"-","Bajki dla chłopców",NULL,NULL,2),
(17,"-","Bajki dla dziewczynek",NULL,NULL,2),
(18,"Wójcik E.","Bajki o księżniczkach",NULL,NULL,2),
(19,"Majerczyk A.","Bajki przedszkolaka",NULL,NULL,2),
(20,"Lem S.","Bajki robotów",NULL,NULL,1),
(21,"Brett D.","Bajki, które leczą cz.1",NULL,NULL,2),
(22,"Brett D.","Bajki, które leczą cz.2",NULL,NULL,2),
(23,"Wheatley A.","Bardzo ilustrowana historia malarstwa ",NULL,NULL,2),
(24,"Berowska M.","Bawmy się : wiersze dla dzieci",NULL,NULL,2),
(25,"Andersen H.Ch.","Baśnie / Andersen H.Ch [klasyczne, il. J.M. Szancer]",NULL,NULL,2),
(26,"Siejnicki J.K.","Baśnie Europy",NULL,NULL,2),
(27,"-","Baśnie polskie",NULL,NULL,3),
(28,"-","Baśnie z czterech stron świata",NULL,NULL,2),
(29,"Combrzyńska-Nogala D.","Bezsenność Jutki",NULL,NULL,2),
(30,"Milos D.","Biały klaun",NULL,NULL,2),
(31,"Webb H.","Biedna, mała Luna",NULL,NULL,2),
(32,"Kasdepke G.","Bodzio i Pulpet",NULL,NULL,2),
(33,"Brzechwa J.","Brzechwa dzieciom",NULL,NULL,2),
(34,"Kosmowska B.","Buba",NULL,NULL,4),
(35,"Salinger J.D.","Buszujący w zbożu",NULL,NULL,2),
(36,"Andersen H. Ch.","Calineczka i inne baśnie",NULL,NULL,2),
(37,"Molnar F.","Chłopcy z Placu Broni",NULL,NULL,3),
(38,"-","Ciało człowieka",NULL,NULL,2),
(39,"Kasdepke G.","Co to znaczy, czyli... 101 zabawnych historyjek […]",NULL,NULL,2),
(40,"Kasdepke G.","Co to znaczy. Cz. 2, Powrót Bartusia czyli […]",NULL,NULL,2),
(41,"Rudź P.","Cuda Wszechświata ",NULL,NULL,1),
(42,"-","Cuda kultury Unesco (Imagine)",NULL,NULL,2),
(43,"Duszyńska J.","Cudaczek Wyśmiewaczek ",NULL,NULL,2),
(44,"Szczygielski M.","Czarny młyn",NULL,NULL,2),
(45,"Webb H.","Czaruś, mały uciekinier",NULL,NULL,2),
(46,"Webb H.","Czekoladowy piesek",NULL,NULL,5),
(47,"Szymeczko K.","Czworo i kości",NULL,NULL,2),
(48,"Rondina C.","Czy dorośli zawsze mają rację?",NULL,NULL,3),
(49,"Łacina A.","Czynnik miłości",NULL,NULL,2),
(50,"Terakowska D.","Córka czarownic",NULL,NULL,2),
(51,"Grisham J.","Darujmy sobie te święta",NULL,NULL,2),
(52,"Olech J.","Dynastia Miziołków",NULL,NULL,3),
(53,"Fiedler A.","Dywizjon 303",NULL,NULL,2),
(54,"Lindgren A.","Dzieci z Bullerbyn",NULL,NULL,2),
(55,"Nimschowski I.","Dziecinnie proste origami",NULL,NULL,2),
(56,"Sharon J.","Franklin i duch jeziora",NULL,NULL,1),
(57,"Christie A.","Morderstwo w Orient Expressie ",NULL,NULL,2),
(58,"Homer","Odyseja",NULL,NULL,2),
(59,"Twain M.","Przygody Tomka Sawyera (Złota seria)",NULL,NULL,2),
(60,"Sienkiewicz H.","Quo vadis",NULL,NULL,2),
(61,"Burnett F.H.","Tajemniczy ogród",NULL,NULL,2),
(62,"DePino C.","Śmierdzący ser",NULL,NULL,2),
(63,"Czechow A.","Śmierć urzędnika",NULL,NULL,3);

