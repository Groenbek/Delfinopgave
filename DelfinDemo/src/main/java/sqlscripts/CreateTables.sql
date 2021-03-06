SET @@session.time_zone = '+00:00';
SELECT @@global.time_zone, @@session.time_zone;

DROP SCHEMA IF EXISTS dolphinclub;
CREATE SCHEMA dolphinclub;

create table dolphinclub.members (
m_id				integer not null auto_increment,
m_name				varchar(50),
age					integer,
act_or_pas			varchar(10),
competitive			varchar(30),
unique key (m_id),
primary key (m_id)
);

create table dolphinclub.training (
t_id				integer not null auto_increment,
coach_name				varchar(50),
primary key (t_id)
);

create table dolphinclub.team (
team_id				integer not null auto_increment,
t_teamname			varchar(50),
t_trainername		varchar(50),
primary key (team_id)
);

create table dolphinclub.swimevent (
se_id				integer not null auto_increment,
se_date				varchar(10),
se_name                         varchar(50),
PRIMARY KEY (se_id)
);

create table dolphinclub.discipline (
d_id				integer not null auto_increment,
d_name				varchar(20),
PRIMARY KEY (d_id)
);

create table dolphinclub.memberstoevent (
se_id				integer not null,
m_id				integer not null, 
d_id				integer not null,
se_placement		integer,
primary key (se_id, m_id, d_id),
    FOREIGN KEY (se_id)
		REFERENCES swimevent(se_id),
	FOREIGN KEY (m_id)
		REFERENCES members(m_id),
	FOREIGN KEY (d_id)
		REFERENCES discipline(d_id)
);

create table dolphinclub.memberstotraining (
t_id				integer not null,
m_id				integer not null,
d_id				integer not null,
trainingdate			varchar(20),
tid				integer not null,
primary key (t_id, m_id, d_id),
    FOREIGN KEY (t_id)
		REFERENCES training(t_id),
	FOREIGN KEY (m_id)
		REFERENCES members(m_id),
	FOREIGN KEY (d_id)
		REFERENCES discipline(d_id)
);
create table dolphinclub.pricelist (
m_type				integer not null auto_increment,
price				integer,
primary key (m_type)
);
create table dolphinclub.memberstoteam (
team_id				integer not null,
m_id				integer not null,
m_type				integer not null,
haspaid				varchar(25),
primary key (team_id, m_id, m_type),
	FOREIGN KEY (team_id)
		REFERENCES team(team_id),
	FOREIGN KEY (m_id)
		REFERENCES members(m_id),
        foreign key (m_type)
        references pricelist(m_type)
);