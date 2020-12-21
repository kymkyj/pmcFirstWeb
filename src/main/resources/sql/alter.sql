/*----------------2020.10.29--------------------*/
ALTER TABLE `study`.`user`
ADD UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE;
;

/*----------------2020.11.03---------------------*/
ALTER TABLE `study`.`user`
ADD COLUMN `auth_key` VARCHAR(50) NULL COMMENT '이메일 인증용 난수' AFTER `attchment_id`;



/*----------------2020.11.27---------------------*/
ALTER TABLE `study`.`user`
CHANGE COLUMN `attchment_id` `attachment_id` BIGINT NULL DEFAULT NULL ;


/*----------------2020.12.01---------------------*/
ALTER TABLE `study`.`study_material`
ADD `type` VARCHAR(50) NULL COMMENT '메인 이미지 체크용';

/*----------------2020.12.02---------------------*/
ALTER TABLE `study`.`attachment`
CHANGE COLUMN `path` `path` VARCHAR(300) NOT NULL COMMENT '자료 위치' ;

/*----------------2020.12.13---------------------*/
alter table region add latitude varchar(50) null comment '위도';
alter table region add longitude varchar(50) null comment '경도';

SET foreign_key_checks = 0;
TRUNCATE TABLE region
SET foreign_key_checks = 1;

/*----------------2020.12.19---------------------*/
alter table user add subject_id bigint null comment '유저 관심 카테고리';