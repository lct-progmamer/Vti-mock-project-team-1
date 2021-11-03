-- Drop the database if it already exists
DROP DATABASE IF EXISTS TestingSystem;
-- Create database
CREATE DATABASE IF NOT EXISTS TestingSystem;
USE TestingSystem;

-- Create table user
DROP TABLE IF EXISTS 	`User`;
CREATE TABLE IF NOT EXISTS `User` ( 	
	id 				SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	`username`	 	CHAR(50) NOT NULL UNIQUE CHECK (LENGTH(`username`) >= 6 AND LENGTH(`username`) <= 50),
	`email` 		CHAR(50) NOT NULL UNIQUE CHECK (LENGTH(`email`) >= 6 AND LENGTH(`email`) <= 50),
	`password` 		VARCHAR(800) NOT NULL,
    `firstName` 	NVARCHAR(50) NOT NULL,
	`lastName` 		NVARCHAR(50) NOT NULL,
    `role` 			ENUM('Admin','Employee','Manager') DEFAULT 'Employee',
	`status`		TINYINT DEFAULT 0, -- 0: Not Active, 1: Active
    `avatarUrl`		VARCHAR(500)
);

-- Create table Registration_User_Token
DROP TABLE IF EXISTS 	`Registration_User_Token`;
CREATE TABLE IF NOT EXISTS `Registration_User_Token` ( 	
	id 				INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	`token`	 		CHAR(36) NOT NULL UNIQUE,
	`user_id` 		SMALLINT UNSIGNED NOT NULL,
	`expiryDate` 	DATETIME NOT NULL
);

-- Create table Reset_Password_Token
DROP TABLE IF EXISTS 	`Reset_Password_Token`;
CREATE TABLE IF NOT EXISTS `Reset_Password_Token` ( 	
	id 				INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	`token`	 		CHAR(36) NOT NULL UNIQUE,
	`user_id` 		SMALLINT UNSIGNED NOT NULL,
	`expiryDate` 	DATETIME NOT NULL
);


DROP TABLE IF EXISTS `CT_QUYEN_GOP`;
CREATE TABLE `CT_QUYEN_GOP`(

	Id  					  											SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	Ct_name     	  											VARCHAR(255) UNIQUE KEY  NOT NULL,
	Discription_Quyen_gop   							VARCHAR(800) NOT NULL,
	Date_Start     												DATETIME DEFAULT(NOW()),
	Date_End        											DATETIME DEFAULT(NOW()),
	Tong_tien_quyen_gop										INT UNSIGNED NOT NULL,
	Image_Id  														SMALLINT UNSIGNED NOT NULL,
	`Status`                   						ENUM('1','0') -- 0 : CHUA KET THUC , 1 : DA KET THUC
	
);

DROP TABLE IF EXISTS `IMAGE_QUYEN_GOP`;
CREATE TABLE `IMAGE_QUYEN_GOP`(

	Id 																		SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	Image_url					 		       					VARCHAR(255) UNIQUE KEY NOT NULL,
	Discription_Image   									VARCHAR(800) NOT NULL,
	Ct_quyen_gop_Id  											SMALLINT UNSIGNED  NOT NULL

);

DROP TABLE IF EXISTS `USER_QUYEN_GOP`;
CREATE TABLE `USER_QUYEN_GOP`(

		Ct_quyen_gop_Id  										SMALLINT UNSIGNED NOT NULL ,
		User_Id          										SMALLINT UNSIGNED NOT NULL ,
		Tien_quyen_gop 											INT UNSIGNED NOT NULL,
		
		FOREIGN KEY (Ct_quyen_gop_Id) REFERENCES CT_QUYEN_GOP(Id),
		FOREIGN KEY (User_Id) REFERENCES `User`(id)
		
);


-- password: 123456
INSERT INTO `User` 	(`username`,			`email`,						`password`,														`firstName`,		`lastName`, 	`status`, 	`role`,  		`avatarUrl`				)
VALUE				('hanh.havan@vti',		'hanhhanoi1999@gmail.com',		'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',		'Hà'	,		'Văn Hanh',			0, 		'Manager' 	,		null				), 
					('thanhhung12@vti',		'hung122112@gmail.com',			'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',		'Nguyễn',		'Thanh Hưng',		0, 		'Manager' 	,		null				), 
					('can.tuananh@vti',		'cananh.tuan12@vti.com',		'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',		'Cấn'	,		'Tuấn Anh',			0, 		'Manager' 	,		null				), 
					('toananh123@vti',		'toananh123@vti.com',			'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',		'Nguyễn',		'Anh Toàn',			0, 		'Manager' 	,		null				), 
					('manhhung123@vti',		'manhhung123@vti.com',			'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',		'Nguyễn',		'Mạnh Hùng',		0, 		'Manager' 	,		null				),
					('maianhvti123',		'maianhng@gmail.com', 			'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',		'Nguyễn',		'Mai Anh',			0, 		'Employee'	,		null				),
					('tuanvti12344',		'tuan1234@gmail.com', 			'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',		'Nguyễn',		'Văn Tuấn',			0, 		'Employee'	,		null				),
					('ngthuy123',			'thuyhanoi@gmail.com', 			'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',		'Nguyễn',		'Thị Thủy',			0, 		'Employee'	,		null				),
					('quanganhvti',			'quanganh@gmail.com', 			'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',		'Nguyễn',		'Quang Anh',		0, 		'Manager' 	,		null				),
					('hoanghungvti',	    'hunghoang@gmail.com', 			'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',		'Vũ'	,		'Hoàng Hưng',		0, 		'Employee'	,		null				),
					('quocanhvti',			'quocanh12@gmail.com', 			'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',		'Nguyễn',		'Quốc Anh',			0, 		'Admin'	  	,		null				),
					('vananhvti',			'vananhb1@gmail.com', 			'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',		'Nguyễn',		'Vân Anh',			0, 		'Employee'	,		null				),
					('mailanvti',			'mailan123@gmail.com', 			'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',		'Nguyễn',		'Thị Trinh',		0, 		'Manager' 	,		null				),
					('tuanhungvti',			'tuanhung@gmail.com', 			'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',		'Vũ'	,		'Tuấn Hưng',		0, 		'Employee'	,		null				),
					('xuanmaivti',			'xuanmai12@gmail.com', 			'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',		'Nguyễn',		'Xuân Mai',			0, 		'Employee'	,		null				),
                    ('duynn03',				'duynn03@gmail.com', 			'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',		'Nguyễn',		'Duy',				1, 		'Employee'	,		'1613362949329.png'	);
                    

												
												
												
												