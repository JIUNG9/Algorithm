-- 코드를 입력하세요
with get_most_view as(
    select board_id, dense_rank() over(order by ugb.views desc) as rnk
    from used_goods_board as ugb    
)

select concat("/home/grep/src/",ugb.board_id,"/",file_id,file_name,file_ext) as file_path
from used_goods_board as ugb inner join used_goods_file as ugf on ugb.board_id = ugf.board_id
where ugb.board_id in (select board_id from get_most_view as gmv where gmv.rnk = 1)
order by file_id desc