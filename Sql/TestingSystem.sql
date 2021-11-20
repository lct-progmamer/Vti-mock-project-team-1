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

	Id  					  							SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	Ct_name     	  									VARCHAR(255) UNIQUE KEY  NOT NULL,
	Discription_Quyen_gop   							VARCHAR(2000) NOT NULL,
	Date_Start     										DATETIME DEFAULT(NOW()),
	Date_End        									DATETIME DEFAULT(NOW()),
	Tong_tien_quyen_gop									INT UNSIGNED NOT NULL DEFAULT(100000),
	`Status`                   							FLOAT UNSIGNED DEFAULT(0)
);

DROP TABLE IF EXISTS `IMAGE_QUYEN_GOP`;
CREATE TABLE `IMAGE_QUYEN_GOP`(

	Id 														SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	`name`					 		       				VARCHAR(500) UNIQUE KEY NOT NULL,
	Discription_Image   									VARCHAR(800) NOT NULL,
	Ct_quyen_gop_Id  										SMALLINT UNSIGNED  NOT NULL,
	
    
	FOREIGN KEY (Ct_quyen_gop_Id) REFERENCES CT_QUYEN_GOP(Id)

);

DROP TABLE IF EXISTS `USER_QUYEN_GOP`;
CREATE TABLE `USER_QUYEN_GOP`(

		Ct_quyen_gop_Id  										SMALLINT UNSIGNED NOT NULL,
		User_Id          										SMALLINT UNSIGNED NOT NULL,
		Tien_quyen_gop 											INT UNSIGNED NOT NULL DEFAULT(0),
		`status`												enum('0' , '1') DEFAULT(0), -- 1 : DA CHUYEN , 0 : CHUA CHUYEN

		FOREIGN KEY (Ct_quyen_gop_Id) REFERENCES CT_QUYEN_GOP(Id),
		FOREIGN KEY (User_Id) REFERENCES `User`(id)
		
);

DROP TABLE IF EXISTS `NGAN_HANG_TU_THIEN`;
CREATE TABLE `NGAN_HANG_TU_THIEN`(
	id						SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `name`					VARCHAR(250)  NOT NULL,
	image_bank				VARCHAR(500),
    so_tk					VARCHAR(50) UNIQUE KEY NOT NULL,
    id_quyen_gop			SMALLINT UNSIGNED NOT NULL,
    
    FOREIGN KEY (id_quyen_gop) REFERENCES CT_QUYEN_GOP(Id)
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
                    

INSERT INTO 	`CT_QUYEN_GOP`(Ct_name , Discription_Quyen_gop , Date_Start , Date_End , Tong_tien_quyen_gop , `Status`)
VALUES				('Ủng hộ Quỹ Vaccine: Cả nước đoàn kết, quyết tâm chống dịch',
'Câu chuyện
Một năm rưỡi trôi qua, đại dịch đã hoành hành trên thế giới, gây ra những tổn thất nghiêm trọng, cướp đi sinh mạng của hàng triệu người và đảo lộn đời sống, kinh tế, xã hội của các quốc gia. Đại dịch đến nay vẫn chưa có dấu hiệu thuyên giảm; giải pháp vaccine là biện pháp hữu hiệu nhất để bảo vệ tính mạng của người dân và đưa cuộc sống trở lại bình thường. Hầu hết các quốc gia đã và đang phấn đấu thực hiện mục tiêu bao phủ vaccine cho ít nhất 2/3 dân số đến hết năm 2021, trong đó có Việt Nam chúng ta.
Để có thể tiếp cận được nguồn vaccine trong bối cảnh khan hiếm trên quy mô toàn cầu, Bộ Y tế đã hết sức nỗ lực, cố gắng đưa vaccine về Việt Nam. Hơn 200 cuộc trao đổi, làm việc, đàm phán với các tổ chức, nhà sản xuất vaccine được Bộ Y tế bền bỉ thực hiện suốt từ giữa năm 2020 đến nay đã giúp Việt Nam có được 130 triệu liều vaccine trong năm 2021. Bộ Y tế hiện vẫn đang tiếp tục trao đổi nhằm đạt mục tiêu 150 triệu liều để tạo miễn dịch cộng đồng trong năm 2021. Tất cả các vaccine được Bộ Y tế cấp phép sử dụng và đưa về Việt Nam đều đảm bảo an toàn và hiệu quả.','2021-07-20' , '2021-12-31' , '300000000',55),


('Tình thương cho em - Ủng hộ trẻ mồ côi vì dịch bệnh' , 'Chỉ sau một mùa hè, hơn 1.500 em học sinh ở TP.HCM phút chốc rơi vào cảnh mồ côi cha, mồ côi mẹ, bi đát hơn là mồ côi cả cha lẫn mẹ do dịch bệnh! 
Có lẽ bất kỳ ai khi nghe, đọc được con số báo cáo của Sở GD&ĐT TPHCM với Ban Văn hoá - Xã hội, HĐND TPHCM vào ngày 14/9 đều nghẹn lòng, đau xót.
Phía sau con số tưởng như tròn trịa ấy là bao giọt nước mắt vỡ tan, bao câu chuyện day dứt  khi các em nhỏ đang tuổi ăn, tuổi học, tuổi vô tư hồn nhiên phải rời xa vòng tay cha mẹ. Dịch bệnh đã vĩnh viễn cướp đi mái ấm hạnh phúc của các em. Chặng đường sắp tới, các em phải tự mình đối mặt với cuộc sống bấp bênh và một tương lai bất định.', '2021-09-19' , '2021-12-31' , 15000000 , 79),


('Chung tay quyên góp xây dựng ngôi nhà hạnh phúc cho gia đình em Giàng Thị Chênh mồ côi cha'
, 'Em Giàng Thị Chênh sinh năm 2012 tại một vùng quê nghèo thuộc xã Bản Lầu, huyện Mường Khương của tình Lào Cai.Vốn dĩ em Chênh cũng sẽ được sống như bao đứa trẻ khác, có được sự yêu thương chăm sóc của cha, hằng ngày được cắp sách tới trường… Nhưng không may cha em qua đời sớm để lại ba mẹ con em không nơi nương tựa. Hơn nữa mẹ em tuổi già sức yếu, tinh thần lại không tỉnh táo hoàn toàn nên không có đủ khả năng lo cho hai anh em Chênh có được cuộc sống đầy đủ. Vì hoàn cảnh gia đình quá khó khăn, cả Chênh và anh trai đều không được đi học.' , '2021-01-11' , '2022-03-31',100000000 , 5),


('Chung tay quyên góp gói quà nhu yếu phẩm cho 107 em nhỏ khó khăn', 
'Sài Gòn, thành phố đầu tàu kinh tế của cả nước, đang trải qua những tháng ngày buồn nhất trong nhiều chục năm qua khi mọi hoạt động đều đình trệ vì dịch bệnh. Hàng triệu người nghèo của thành phố đang đứng trước bờ vực của cái đói và tương lai bất định. Đáng thương nhất phải kể đến những gia đình vốn đã rất nghèo từ trước dịch, nhưng nay càng lao đao hơn bao giờ hết. Đó không chỉ là những người bị mất việc làm vì dịch bệnh, mà có cả những người khuyết tật kiếm sống trên đường phố nhưng giờ đây không biết làm gì để có thu nhập, hoặc những người vừa có thu nhập thấp vừa phải lo cho người thân đang mang bệnh. '
,'2021-07-18' , '2021-12-31',230000000 , 70),


('Giúp 300 người nghèo có nơi ở an toàn vùng tâm dịch',
'Thành phố Hồ Chí Minh đang trải qua làn sóng dịch bệnh khắc nghiệt nhất và giãn cách xã hội đã ảnh hưởng nghiêm trọng đến miếng cơm manh áo, đẩy những người lao động nghèo đến bờ vực của cái đói và tình trạng không nhà không cửa. Trong số 3.000 gia đình mà chương trình “Mỗi ngày Một quả trứng” đang hỗ trợ lương thực khẩn cấp, có đến 85% tương đương với 2.550 hộ phải thuê trọ. Cho dù chỉ là một phòng trọ nhỏ bé thì họ cũng có một nơi chốn để đi về, che chở cả người lớn và trẻ nhỏ khỏi mưa nắng, cũng như tránh khỏi những mối nguy hiểm của cuộc sống lang thang trên đường phố.','2021-07-18','2021-12-31',1560000000,70),

('Chung tay quyên góp xây dựng mới ngôi trường tặng 32 em học sinh bản Huổi Po',
'Na Cô Sa là là xã biên giới xa xôi nhất với muôn vàn khó khăn của huyện Nậm Pồ, tỉnh Điện Biên. Xã có đường biên giới dài 17,1km, 9/11 bản tiếp giáp với nước bạn Lào. Thiếu thốn nhất phải kể đến bản Huổi Po của xã với tên gọi “4 Không” - Không đường, không điện, không chợ, không hệ thống thông tin, 97% dân số là đồng bào dân tộc Mông, đa phần thuộc diện đói, nghèo. Cách trung tâm xã 10km có điểm trường Huổi Po được bà con góp công xây dựng hơn 10 năm nay. Điểm trường là niềm hy vọng của người dân bản giúp con cháu mình được học cái chữ cho tương lai khấm khá.','2021-10-26','2022-03-21',350000000,56);






INSERT INTO image_quyen_gop(`name`	 , Discription_Image , Ct_quyen_gop_Id)
VALUES ('210625182930-637602425706833110.jpg','Vaccine là biện pháp hữu hiệu nhất để bảo vệ tính mạng của người dân và đưa cuộc sống trở lại bình thường',1) ,
('210625182125-637602420857550435.jpg','Sự chung tay từ cộng đồng các nhà hảo tâm sẽ là đóng góp to lớn để giúp đất nước chiến thắng đại dịch',1),
('210721142144-637624741042118090.jpg' ,
'Sự chung tay từ cộng đồng các nhà hảo tâm sẽ là đóng góp to lớn để giúp đất nước chiến thắng đại dịch' , 1),
('210920192348-637677626283318592.jpg'
, 'Dịch bệnh phức tạp đã khiến hơn 1.500 em nhỏ sống tại TP.HCM mất người thân, trở thành trẻ mồ côi' , 2 ),
('210920192844-637677629249618686.jpg','Các em nhỏ mồ côi vì dịch bệnh rất cần sự chăm lo để vượt qua nỗi đau và ổn định cuộc sống',2),
('211006094630-637691103903433389.jpg','Các em nhỏ nhận quà từ Chương trình "Tình thương cho em"',2),
('211102104856-637714469367188872.jpg','Hình ảnh em Chênh cùng mẹ bên bếp củi.',3),
('211102104930-637714469701570149.jpg','Dù bao khó khăn nhưng em Chênh luôn khao khát được đến trường.',3),
('211102104952-637714469923465414.jpg','Ngôi nhà làm từ tre và lá cọ mà gia đình em Chênh đang ở nhờ.',3),
('210723161559-637626537590447065.jpg','Mất đi việc làm, thực phẩm leo giá càng khiến cho cuộc sống khó khăn chồng chất khó khăn...',4),
('210719174945-637623137856063478.jpg','Gói hỗ trợ trẻ em của chiến dịch “Ba lô chở che mùa dịch"',4),
('210719175015-637623138153424988.jpg','Chung tay trao những gói hỗ trợ đến các hoàn cảnh khó khăn',4),
('210719173522-637623129226018749.jpg','Cuộc sống leo lắt, nay đây mai đó khổ sở của người dân vì dịch bệnh',5),
('210719173644-637623130049978802.jpg','Tình trạng lao động bị thất nghiệp khiến họ không đủ thu nhập lo cho gia đình',5),
('210719173719-637623130396678370.jpg','Thu nhập bấp bênh khiến cái ăn, cái mặc thiếu thốn vô cùng',5),
('211027102022-637709268226101974.jpg','Điểm trường Huổi Po tọa lạc tại bản Huổi Po, xã Na Cô Sa có hơn 10 năm tuổi đời',6),
('211027102153-637709269133295529.jpg','Điểm trường đã xuống cấp nghiêm trọng. Phòng học được ghép bằng gỗ thưa không thể nào ngăn được gió lạnh',6),
('211027102225-637709269456099618.jpg','Nói về cái khó của sự học nơi đây có lẽ nhiều không kể hết, nhưng chính những nhọc nhằn của các em là động lực để nhiều thầy cô âm thầm hy sinh bám trường, bám lớp. ',6);



INSERT INTO USER_QUYEN_GOP(Ct_quyen_gop_Id , User_Id , Tien_quyen_gop , `status`)
VALUES (1,16,150000000 , 1);


INSERT INTO `NGAN_HANG_TU_THIEN`(`name` , image_bank , so_tk , id_quyen_gop)
VALUES ('Agribank' , 'agribank-logo.png' , '00000000001' , 1),
		('TechComBank' ,'techcombank.jpg', '00000000002' , 1),
        ('Viettinbank' ,'viettin-bank.png', '00000000003' , 1),
        ('MB BANK' , 'mb-bank.jpg' , '00000000004' , 1),
        ('VietTinBank' , 'viettin-bank.png' , '00000000005',2),
        ('MB BANK' , 'mb-bank.jpg' , '423423421',2),
        ('techcom BANK' , 'techcombank.jpg' , '32423423523',2),
        ('AGRIBANK' , 'agribank-logo.png' , '4534253466',2),
        ('VietTinBank' , 'viettin-bank.png' , '123456768',3),
        ('MB BANK' , 'mb-bank.jpg' , '75634541756',3),
        ('Techcom BANK' , 'techcombank.jpg' , '12315432131',3),
        ('AGRIBANK' , 'agribank-logo.png' , '12312432423',3),
        ('MB BANK' , 'mb-bank.jpg' , '7563454756',4),
        ('TechCom BANK' , 'techcombank.jpg' , '234234523143',4),	
        ('AGRIBANK' , 'agribank-logo.png' , '12334643534',4),
        ('VietTinBank' , 'viettin-bank.png' , '1232545346',4),
        ('MB BANK' , 'mb-bank.jpg' , '676575674',5),
        ('AGRIBANK' , 'agribank-logo.png' , '3142354634',5),
        ('VietTinBank' , 'viettin-bank.png' , '34564352345',5),
        ('MB BANK' , 'mb-bank.jpg' , '345345547645',6),
        ('AGRIBANK' , 'agribank-logo.png' , '1243768245',6),
        ('VietTinBank' , 'viettin-bank.png' , '23421435',6);
        
				
												
												