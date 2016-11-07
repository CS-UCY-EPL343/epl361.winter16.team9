
/*Create database*/
CREATE DATABASE  IF NOT EXISTS `hotline`;
USE `hotline`;

DROP TABLE IF EXISTS `ChatRecord`;
DROP TABLE IF EXISTS `ChatSession`;
DROP TABLE IF EXISTS `File`;
DROP TABLE IF EXISTS `Statistics`;
DROP TABLE IF EXISTS `Case`;
DROP TABLE IF EXISTS `Operator`;


/*Create Operator table*/

CREATE TABLE Operator (
	operator_id varchar(16) NOT NULL,
	name varchar(32),
	surname varchar(32),
	telephone varchar(16),
	email varchar(64),
	username	varchar(64),
	password	varchar(256),
	salt		varchar(256),
	PRIMARY KEY (operator_id)
)ENGINE = InnoDB;

/*Create Case table*/

CREATE TABLE `Case` (
	case_id varchar(16) NOT NULL,  
	operator_id varchar(16) NOT NULL,
	url_link blob, /* */
	time_created timestamp NOT NULL,
	comments blob NOT NULL,
	topic blob NOT NULL,
	name	blob NOT NULL,
	surname blob NOT NULL,
	gender 	blob NOT NULL,
	age 	blob NOT NULL,
	city 	blob NOT NULL,
	email 	blob NOT NULL,
	telephone blob NOT NULL,
	PRIMARY KEY (case_id),
	CONSTRAINT fk_operator_report FOREIGN KEY (operator_id) REFERENCES Operator(operator_id)
)ENGINE = InnoDB;
	


/*Create Statistic table*/

CREATE TABLE File (
	id int(11) NOT NULL AUTO_INCREMENT,
	case_id varchar(16) NOT NULL,
	data longblob NOT NULL,
	CONSTRAINT fk_report_file FOREIGN KEY(case_id) REFERENCES `Case`(case_id),
	PRIMARY KEY (id)
)ENGINE = InnoDB;

/*Create Statistic table*/
CREATE TABLE Statistics (
	id int(11) NOT NULL AUTO_INCREMENT,
	case_id varchar(16) NOT NULL,
	time_created TIMESTAMP  DEFAULT CURRENT_TIMESTAMP,
	time_finished DATETIME ,
	age int(11) NOT NULL,
	gender tinyint(1) NOT NULL, 
	city varchar(32) NOT NULL,
	CONSTRAINT fk_report_statistics FOREIGN KEY(case_id) REFERENCES `Case`(case_id),
	PRIMARY KEY (id)
)ENGINE = InnoDB;


/*Create ChatSession table*/
CREATE TABLE ChatSession (
	session_id varchar(16) NOT NULL,
	case_id varchar(16),
	time_opened TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	time_closed DATETIME ,
	CONSTRAINT fk_case_chatsession FOREIGN KEY(case_id) REFERENCES 	`Case`(case_id),
	PRIMARY KEY (session_id)
)ENGINE = InnoDB;

/*Create ChatSession table*/
CREATE TABLE ChatRecord (
	session_id varchar(16) NOT NULL,
	timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	received tinyint(1) NOT NULL, 
	operator_id varchar(16) NOT NULL,
	data longblob  NOT NULL,
	CONSTRAINT fk_chatsession_chatrecord FOREIGN KEY(session_id) REFERENCES ChatSession(session_id),
	CONSTRAINT fk_chatsession_operator FOREIGN KEY(operator_id) REFERENCES Operator(operator_id),
	PRIMARY KEY (session_id, timestamp)
)ENGINE = InnoDB;

