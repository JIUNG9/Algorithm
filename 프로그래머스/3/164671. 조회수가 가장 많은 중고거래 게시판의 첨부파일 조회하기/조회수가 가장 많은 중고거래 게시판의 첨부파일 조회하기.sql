-- 코드를 입력하세요
select concat("/home/grep/src/",b.board_id,"/",file_id,file_name, file_ext) as file_path
from used_goods_board as b inner join used_goods_file f on b.board_id = f.board_id
where b.views in (select max(views)  from used_goods_board)
order by 1 desc