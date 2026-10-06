select count(*) as FISH_COUNT
from FISH_INFO
where date_format(time, '%Y') = '2021';
