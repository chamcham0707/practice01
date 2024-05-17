CREATE TABLE member (
    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    email VARCHAR(255) NOT NULL COMMENT '이메일',
    name VARCHAR(255) NOT NULL COMMENT '이름',
    age INT(3) NOT NULL COMMENT '나이',
    phone VARCHAR(255) NOT NULL COMMENT '전화번호',
    address VARCHAR(255) NOT NULL COMMENT '주소',
    assets VARCHAR(1) NOT NULL COMMENT '재산',
    married_count INT(3) NOT NULL COMMENT '결혼 횟수',
    has_jesa TINYINT(1) NOT NULL COMMENT '제사 여부',
    children_count INT(3) NULL COMMENT '자녀 수',
    has_own_house TINYINT(1) NOT NULL COMMENT '자가 여부',
    car_price INT(10) NULL COMMENT '차량가액 (단위: 만원)'
) COMMENT='Member Table';