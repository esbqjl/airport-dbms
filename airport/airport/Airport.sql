Create DATABASE IF NOT Exists AirportDB;
use AirportDB;
Create TABLE IF NOT EXISTS `Airport` (
	`id`   varchar(20) UNIQUE NOT NULL comment '机场id',
    `city` varchar(30) NOT NULL comment '城市', 
    `name` varchar(10) NOT NULL comment '姓名',
    
    PRIMARY KEY (`name`)
)ENGINE = InnoDB CHARACTER SET utf8mb4;

Create TABLE IF NOT EXISTS `Store` (
    `name`   varchar(20) NOT NULL  comment '商店名字',
	`airport_name` varchar(30) NOT NULL comment '机场名字', 
    `product_type` varchar(10) NOT NULL comment '物品类型',
    `type`   varchar(20) NOT NULL  comment '商店类型',
    `place`   varchar(20) NOT NULL comment '位置',
    
    constraint `store_airport_airport_name_fk`
		foreign key (`airport_name`) references `Airport`(name)
        on delete no action
        on update cascade,
	PRIMARY KEY (`name`,`airport_name`)
)ENGINE = InnoDB CHARACTER SET utf8mb4 ;

Create TABLE IF NOT EXISTS `Worker` (
	`id`           int NOT NULL auto_increment comment '工人id', 
    `airport_name` varchar(10) NOT NULL comment '机场名字',
    `name`         varchar(30) NOT NULL comment '工人名字',
    `age`          int DEFAULT NULL comment '年龄',
    `salary`       int DEFAULT NULL comment '工资',
    `store_name`   varchar(40) DEFAULT NULL comment '商店名',
    `job`          varchar(30) DEFAULT NULL comment '工作',
    constraint `Worker_Airport_airport_name_fk`
		foreign key	(`airport_name`) references `Airport`(name)
        on delete no action
        on update cascade,
    PRIMARY KEY (`id`)
    
)ENGINE = InnoDB CHARACTER SET utf8mb4 auto_increment=1;

Create TABLE IF NOT EXISTS `Flight` (
	`id` int NOT NULL auto_increment comment  'id',
	`flight_number`     varchar(20) NOT NULL  comment '航班号', 
    `departure_time`    datetime NOT NULL comment '起飞时间',
    `arrival_time`      datetime NOT NULL comment '到达时间',
    `departure_airport` varchar(10) NOT NULL comment '起飞机场',
    `arrival_airport`   varchar(10) NOT NULL comment '到达机场',
    constraint `Flight_Airport_arrival_airport_fk`
		foreign key	(`arrival_airport`) references Airport(name)
        on delete cascade
        on update cascade,
	constraint `Flught_Airport_departure_airport_fk`
		foreign key	(departure_airport) references Airport(name)
        on delete cascade
        on update cascade,
    PRIMARY KEY (`id`)
)ENGINE = InnoDB auto_increment=1 CHARACTER SET utf8mb4 ;

Create TABLE IF NOT EXISTS `Ticket` (
	`order_number` int(30) NOT NULL auto_increment comment '订单号', 
    `passenger_name` varchar(40) NOT NULL comment '顾客名字',
    `flight_number`   varchar(20) NOT NULL  comment '航班号码',
    `flight_company`   varchar(30) NOT NULL  comment '航班公司',
    `seat_class`   varchar(20) NOT NULL  comment '仓位等级',
    `price`   double comment '价格',
    PRIMARY KEY (`order_number`)
)ENGINE = InnoDB CHARACTER SET utf8mb4  auto_increment=1;

Create TABLE IF NOT EXISTS `Supplier` (
	`id` varchar(30) NOT NULL  comment 'id', 
    `type` varchar(30) NOT NULL comment '类型',
    PRIMARY KEY (`id`)
)ENGINE = InnoDB CHARACTER SET utf8mb4 ;

Create TABLE IF NOT EXISTS `FlightCompany` (
	`id` varchar(30) NOT NULL  comment 'id', 
    `flight_company_name` varchar(30) NOT NULL comment '航班公司名字',
    constraint `FlightCompany_Supplier_supplier_id_fk`
		foreign key	(`id`) references `Supplier`(`id`)
        on delete cascade
        on update cascade,
    PRIMARY KEY (`id`)
)ENGINE = InnoDB CHARACTER SET utf8mb4 ;

Create TABLE IF NOT EXISTS `BookingAgent` (
	`id` varchar(30) NOT NULL  comment 'id', 
    `booking_company_name` varchar(30) NOT NULL comment '航班公司名字',
    `agent_name` varchar(30) NOT NULL comment '代理人名字',
    constraint `BookingAgent_Supplier_supplier_id_fk`
		foreign key	(`id`) references `Supplier` (`id`)
        on delete cascade
        on update cascade,
    PRIMARY KEY (`id`)
)ENGINE = InnoDB CHARACTER SET utf8mb4 ;

Create TABLE IF NOT EXISTS `purchase` (
	`flight_number`       varchar(20) NOT NULL comment '航班号', 
    `supplier_id`         varchar(20) NOT NULL comment '提供者id',
    `ticket_order_number` int NOT NULL comment '飞机票订单号',
    
	constraint `purchase_supplier_supplier_id_fk`
		foreign key	(supplier_id) references Supplier (id)
        on delete cascade
        on update cascade,
	constraint `purchase_ticket_order_number_fk`
		foreign key (`ticket_order_number`) references `Ticket`(order_number)
        on delete cascade
        on update cascade,
        PRIMARY KEY(`ticket_order_number`)
)ENGINE = InnoDB CHARACTER SET utf8mb4 ;

DELIMITER || 
CREATE TRIGGER `BASupplier` AFTER INSERT ON `BookingAgent`  FOR EACH ROW  BEGIN IF NOT EXISTS (Select `id` from `Supplier` where `id`= new.`id`) then insert into `supplier`(`id`,`type`) values(new.`id`,"BookingAgent"); END iF; END
 ||  
CREATE TRIGGER `FCSupplier` AFTER INSERT ON `FlightCompany`  FOR EACH ROW  BEGIN IF NOT EXISTS (Select `id` from `Supplier` where `id`= new.`id`) then insert into `supplier`(`id`,`type`) values(new.`id`,"FlightCompany"); END iF; END
 || 
 Create TRIGGER `Worker1` Before Insert ON `worker` FOR EACH ROW BEGIN IF NOT EXISTS (Select `name` from `store` where `name`=new.`store_name` LIMIT 1) then SET new.store_name=null; END IF; END
 ||
DELIMITER ;

insert into airport(name, city, id) values("JFK","NY","1L");
insert into airport(name, city, id) values("LAX","LA","2L");
insert into airport(name, city, id) values("BOS","BOS","3L");
insert into airport(name, city, id) values("BSA","BHM","4L");
insert into airport(name, city, id) values("JIA","JNU","5L");


insert into store(name,airport_name,product_type, type, place)values("71","JFK","Snack", "Convenient Store", "EastSide of Airport");
insert into store(name,airport_name,product_type, type, place)values("LadyM","LAX","Cake", "Cake Store", "WestSide of Airport");
insert into store(name,airport_name,product_type, type, place)values("71","BOS","Snack", "Convenient Store", "EastSide of Airport");
insert into store(name,airport_name,product_type, type, place)values("M&M","BSA","fast food", "Resturant", "center of Airport");
insert into store(name,airport_name,product_type, type, place)values("71","JIA","Snack", "Convenient Store", "EastSide of Airport");



insert into worker(airport_name,name, age, salary, store_name,job) values("JFK",  "Wenjun",22, 20000,"71","counter");
insert into worker(airport_name,name, age, salary, store_name,job) values("LAX",  "Yike",23, 15000,"LadyM","counter");
insert into worker(airport_name,name, age, salary, store_name,job) values("BOS",  "Hankai",41, 4400,"71","counter");
insert into worker(airport_name,name, age, salary, store_name,job) values("BSA",  "Eric",27, 4400,"M&M","counter");
insert into worker(airport_name,name, age, salary, store_name,job) values("JIA",  "Alex",43, 5000,"71","counter");





insert into flight(flight_number,departure_time, arrival_time, departure_airport, arrival_airport) values("LA330","2013-04-09 09:51:52","2013-04-09 10:51:52", "BOS","LAX");
insert into flight(flight_number,departure_time, arrival_time, departure_airport, arrival_airport) values("BO330","2013-04-09 10:00:00","2013-04-09 13:32:09", "LAX","BOS");
insert into flight(flight_number,departure_time, arrival_time, departure_airport, arrival_airport) values("JI330","2013-04-09 14:04:00","2013-04-09 17:00:00", "BSA","JIA");
insert into flight(flight_number,departure_time, arrival_time, departure_airport, arrival_airport) values("BS330","2013-04-09 18:50:41","2013-04-09 20:50:00", "JIA","BSA");
insert into flight(flight_number,departure_time, arrival_time, departure_airport, arrival_airport) values("JF330","2013-04-09 22:51:52","2013-04-09 23:51:52", "BOS","JFK");



insert into Supplier(id,type)values("34651","BookingAgent");
insert into Supplier(id,type)values("134651","FlightCompany");
insert into Supplier(id,type)values("34652","BookingAgent");
insert into Supplier(id,type)values("134652","FlightCompany");
insert into Supplier(id,type)values("34653","BookingAgent");
insert into Supplier(id,type)values("134653","FlightCompany");




insert into bookingAgent(id,booking_company_name,agent_name)values("34651", "XieCheng", "Wendy");
insert into bookingAgent(id,booking_company_name,agent_name)values("34652", "StudentUniverse", "Cady");
insert into bookingAgent(id,booking_company_name,agent_name)values("34653", "Migos", "takeoff");



insert into flightCompany(id,flight_company_name)values("134651", "Delta");
insert into flightCompany(id,flight_company_name)values("134652", "Sky");
insert into flightCompany(id,flight_company_name)values("134653", "United Airline");



insert into ticket(passenger_name,flight_number,flight_company, seat_class,price)values("Wenjun","LA330","Delta","Premium",991.7);
insert into ticket(passenger_name,flight_number,flight_company, seat_class,price)values("Yike","BO330","United Airline","Premium",343);
insert into ticket(passenger_name,flight_number,flight_company, seat_class,price)values("Hankai","JI330","Sky","Premium",300.3);
insert into ticket(passenger_name,flight_number,flight_company, seat_class,price)values("Eric","BS330","Sky","Premium",243);
insert into ticket(passenger_name,flight_number,flight_company, seat_class,price)values("Alex","JF330","Skyi","Premium",339);





insert into Purchase(flight_number,supplier_id,ticket_order_number)values("LA330","134651",1);
insert into Purchase(flight_number,supplier_id,ticket_order_number)values("BO330","134652",2);
insert into Purchase(flight_number,supplier_id,ticket_order_number)values("JI330","134653",3);
insert into Purchase(flight_number,supplier_id,ticket_order_number)values("BS330","34651",4);
insert into Purchase(flight_number,supplier_id,ticket_order_number)values("JF330","34651",5);

