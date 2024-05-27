-- 코드를 작성해주세요
 with can_upgrade as(
    select i1.item_id, i1.parent_item_id
    from item_tree as i1
    where i1.item_id IN (select parent_item_id as item_id from item_tree)
)

# select * from can_upgrade 


select ii.item_id, item_name, rarity
from item_info ii inner join item_tree as it on ii.item_id = it.item_id
where ii.item_id NOT IN(select item_id from can_upgrade)
order by 1 desc